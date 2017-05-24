package cn.jiangzehui.eventbustext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.tv);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }



    @Subscribe(threadMode= ThreadMode.MAIN)
    public void updateUi(MainMessage mm){
        tv.setText(mm.getMsg());
        //Toast.makeText(this,mm.getMsg(),Toast.LENGTH_SHORT).show();

    }

    @Subscribe(threadMode= ThreadMode.MAIN)
    public void updateUi(String mm){
        tv.setText(mm);
        //Toast.makeText(this,mm.getMsg(),Toast.LENGTH_SHORT).show();

    }

}
