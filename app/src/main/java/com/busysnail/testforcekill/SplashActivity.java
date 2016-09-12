package com.busysnail.testforcekill;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.lang.ref.WeakReference;

public class SplashActivity extends BaseActivity {
    MyHandler handler=new MyHandler(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AppStatusManager.getInstance().setAppStatus(AppStatusConstant.STATUS_NORMAL);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void setupContentView() {
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void setupView() {

    }

    @Override
    protected void setupData(Bundle savedInstanceState) {
        handler.sendEmptyMessageDelayed(0,1000);
    }

    public static class MyHandler extends Handler{
        WeakReference<SplashActivity> weakReference;
        MyHandler(SplashActivity activity){
            weakReference=new WeakReference<SplashActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            weakReference.get().startActivity(new Intent(weakReference.get(),MainActivity.class));
        }
    }

}
