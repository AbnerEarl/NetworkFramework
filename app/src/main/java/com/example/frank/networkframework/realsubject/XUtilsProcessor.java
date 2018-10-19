package com.example.frank.networkframework.realsubject;

import com.example.frank.networkframework.application.HttpApplication;
import com.example.frank.networkframework.callback.ICallback;
import com.example.frank.networkframework.subject.IHttpProcessor;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

/**
 * PROJECT_NAME:NetworkFramework
 * PACKAGE_NAME:com.example.frank.networkframework.realsubject
 * USER:Frank
 * DATE:2018/10/19
 * TIME:22:55
 * DAY_NAME_FULL:星期五
 * DESCRIPTION:On the description and function of the document
 **/
public class XUtilsProcessor implements IHttpProcessor {


    public XUtilsProcessor(HttpApplication application){
        x.Ext.init(application);
    }


    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        RequestParams requestParams=new RequestParams(url);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                callback.onFailure(ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallback callback) {

        RequestParams requestParams=new RequestParams(url);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callback.onFailure(ex.toString());

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
