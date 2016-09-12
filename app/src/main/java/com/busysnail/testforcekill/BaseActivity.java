package com.busysnail.testforcekill;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * author: malong on 2016/9/12
 * email: malong_ilp@163.com
 * address: Xidian University
 */

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (AppStatusManager.getInstance().getAppStatus()){
            case AppStatusConstant.STATUS_FORCE_KILLED:     //被强杀
                protectApp(AppStatusConstant.ACTION_RESTART_APP);
                break;
            case AppStatusConstant.STATUS_KICK_OUT: //被踢出
                protectApp(AppStatusConstant.ACTION_KICK_OUT);
                break;
            case AppStatusConstant.STATUS_NORMAL:   //正常
                setupContentView();
                setupView();
                setupData(savedInstanceState);
                break;
        }
    }


    protected abstract void setupContentView();
    protected abstract void setupView();
    protected abstract void setupData(Bundle savedInstanceState );

    protected void protectApp(int status){
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra(AppStatusConstant.KEY_HOME_ACTION,status);
        startActivity(intent);
    }

}
