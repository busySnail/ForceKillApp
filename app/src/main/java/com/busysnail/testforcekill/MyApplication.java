package com.busysnail.testforcekill;

import android.app.Application;

import java.util.List;

/**
 * author: malong on 2016/9/12
 * email: malong_ilp@163.com
 * address: Xidian University
 */

public class MyApplication extends Application {

    public static MyApplication myApplication;
    public static List<String> list;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication=this;
    }
}
