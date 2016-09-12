package com.busysnail.testforcekill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    Button button;

    @Override
    protected void setupContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void setupView() {
        button = (Button) findViewById(R.id.activity_main_btn);
    }

    @Override
    protected void setupData(Bundle savedInstanceState) {
        MyApplication.list = new ArrayList<>();
        MyApplication.list.add("i come from mainactivity");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InfoActivity.class));
            }
        });
    }

    @Override
    protected void protectApp(int status) {
        Toast.makeText(getApplicationContext(),"应用被回收重启走流程",Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int action = intent.getIntExtra(AppStatusConstant.KEY_HOME_ACTION, AppStatusConstant.ACTION_BACK_TO_HOME);
        switch (action) {
            case AppStatusConstant.ACTION_RESTART_APP:
                protectApp(AppStatusConstant.ACTION_RESTART_APP);
                break;
            case AppStatusConstant.ACTION_KICK_OUT:
                break;
            case AppStatusConstant.ACTION_BACK_TO_HOME:
                break;
        }
    }
}

