package com.example.frank.networkframework.application;

import android.app.Application;

import com.example.frank.networkframework.proxy.HttpHelper;
import com.example.frank.networkframework.realsubject.OkHttpProcessor;
import com.example.frank.networkframework.realsubject.VolleyProcessor;
import com.example.frank.networkframework.realsubject.XUtilsProcessor;

/**
 * PROJECT_NAME:NetworkFramework
 * PACKAGE_NAME:com.example.frank.networkframework.application
 * USER:Frank
 * DATE:2018/10/19
 * TIME:21:46
 * DAY_NAME_FULL:星期五
 * DESCRIPTION:On the description and function of the document
 **/
public class HttpApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        HttpHelper.init(new VolleyProcessor(this));
//        HttpHelper.init(new OkHttpProcessor());
        HttpHelper.init(new XUtilsProcessor(this));
    }
}
