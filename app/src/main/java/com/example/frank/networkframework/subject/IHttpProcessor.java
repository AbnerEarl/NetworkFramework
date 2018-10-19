package com.example.frank.networkframework.subject;

import com.example.frank.networkframework.callback.ICallback;

import java.util.Map;

/**
 * PROJECT_NAME:NetworkFramework
 * PACKAGE_NAME:com.example.frank.networkframework.http_processor
 * USER:Frank
 * DATE:2018/10/19
 * TIME:20:46
 * DAY_NAME_FULL:星期五
 * DESCRIPTION:On the description and function of the document
 **/
public interface IHttpProcessor {
    //网络访问：Post,get,del,update,put
    void post(String url, Map<String,Object> params,ICallback callback);
    void get(String url, Map<String,Object> params,ICallback callback);
}
