package com.example.frank.networkframework.realsubject;

import android.os.Handler;

import com.example.frank.networkframework.callback.ICallback;
import com.example.frank.networkframework.subject.IHttpProcessor;

import java.io.IOException;
import java.util.Map;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * PROJECT_NAME:NetworkFramework
 * PACKAGE_NAME:com.example.frank.networkframework.realsubject
 * USER:Frank
 * DATE:2018/10/19
 * TIME:22:27
 * DAY_NAME_FULL:星期五
 * DESCRIPTION:On the description and function of the document
 **/
public class OkHttpProcessor implements IHttpProcessor {
    private OkHttpClient okHttpClient;
    private Handler handler;


    public OkHttpProcessor(){
        okHttpClient=new OkHttpClient();
        handler=new Handler();
    }


    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        RequestBody requestBody=appendBody(params);
        Request request=new Request.Builder().url(url).post(requestBody).header("User-Agent","networkframework").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(e.toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    final String result=response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onSuccess(result);
                        }
                    });
                }else {
                    final String result=response.message().toString();

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFailure(result);
                        }
                    });
                }

            }
        });
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {

    }

    private RequestBody appendBody(Map<String,Object> params){
        FormBody.Builder body=new FormBody.Builder();
        if (params==null||params.isEmpty()){
            return body.build();
        }
        for (Map.Entry<String,Object> entry:params.entrySet()){
            body.add(entry.getKey(),entry.getValue().toString());
        }
        return body.build();
    }
}
