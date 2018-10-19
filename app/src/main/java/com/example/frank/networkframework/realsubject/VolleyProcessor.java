package com.example.frank.networkframework.realsubject;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.frank.networkframework.callback.ICallback;
import com.example.frank.networkframework.subject.IHttpProcessor;

import java.util.Map;

/**
 * PROJECT_NAME:NetworkFramework
 * PACKAGE_NAME:com.example.frank.networkframework.http_processor
 * USER:Frank
 * DATE:2018/10/19
 * TIME:20:49
 * DAY_NAME_FULL:星期五
 * DESCRIPTION:On the description and function of the document
 **/
public class VolleyProcessor implements IHttpProcessor {

    private static RequestQueue mQueue=null;
    public VolleyProcessor(Context context) {
        mQueue= Volley.newRequestQueue(context);
    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                callback.onSuccess(response);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        });
        mQueue.add(stringRequest);
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallback callback) {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.onSuccess(response);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        });
        mQueue.add(stringRequest);
    }
}
