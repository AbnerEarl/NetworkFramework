package com.example.frank.networkframework.client;

import com.example.frank.networkframework.callback.ICallback;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * PROJECT_NAME:NetworkFramework
 * PACKAGE_NAME:com.example.frank.networkframework.http_processor
 * USER:Frank
 * DATE:2018/10/19
 * TIME:20:35
 * DAY_NAME_FULL:星期五
 * DESCRIPTION:On the description and function of the document
 **/
public abstract class HttpICallbackImpl<Result> implements ICallback {
    @Override
    public void onSuccess(String result) {
        Gson gson=new Gson();
        Class<?> clz=analysisClassInfo(this);
        Result objResult=(Result)gson.fromJson(result,clz);
        onSuccess(objResult);
    }

    public abstract void onSuccess(Result result);

    public static Class<?> analysisClassInfo(Object object){
        Type genType=object.getClass().getGenericSuperclass();
        Type[] params=((ParameterizedType)genType).getActualTypeArguments();
        return (Class<?>)params[0];
    }

}
