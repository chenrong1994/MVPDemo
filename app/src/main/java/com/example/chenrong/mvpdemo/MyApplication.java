package com.example.chenrong.mvpdemo;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by chenrong on 2016/11/8.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
