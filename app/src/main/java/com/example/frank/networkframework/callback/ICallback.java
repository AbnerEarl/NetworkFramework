package com.example.frank.networkframework.callback;

/**
 * PROJECT_NAME:NetworkFramework
 * PACKAGE_NAME:com.example.frank.networkframework.http_processor
 * USER:Frank
 * DATE:2018/10/19
 * TIME:20:33
 * DAY_NAME_FULL:星期五
 * DESCRIPTION:On the description and function of the document
 **/
public interface ICallback {
    void onSuccess(String result);
    void onFailure(String e);
}
