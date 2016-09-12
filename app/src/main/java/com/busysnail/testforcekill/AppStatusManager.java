package com.busysnail.testforcekill;

/**
 * author: malong on 2016/9/12
 * email: malong_ilp@163.com
 * address: Xidian University
 */

public class AppStatusManager {
    public int appStatus= AppStatusConstant.STATUS_FORCE_KILLED;        //APP状态 初始值为没启动 不在前台状态

    public static AppStatusManager appStatusManager;

    private AppStatusManager() {

    }


    public static AppStatusManager getInstance() {
        if (appStatusManager == null) {
            appStatusManager = new AppStatusManager();
        }
        return appStatusManager;
    }

    public int getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(int appStatus) {
        this.appStatus = appStatus;
    }
}
