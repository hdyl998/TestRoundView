package com.hd.mylib;

import android.app.Application;

/**
 * Note：None
 * Created by Liuguodong on 2019/10/15
 * E-Mail Address：986850427@qq.com
 */
public class HdApp extends Application {

    private static HdApp app;


    public static Application getContext() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }
}
