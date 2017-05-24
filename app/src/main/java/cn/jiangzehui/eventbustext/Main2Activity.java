package cn.jiangzehui.eventbustext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //EventBus.getDefault().post(new MainMessage("event,event!"));
        EventBus.getDefault().post("enemememem");
    }
}
