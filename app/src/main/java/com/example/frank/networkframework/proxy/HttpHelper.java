package com.example.frank.networkframework.proxy;

import com.example.frank.networkframework.callback.ICallback;
import com.example.frank.networkframework.subject.IHttpProcessor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * PROJECT_NAME:NetworkFramework
 * PACKAGE_NAME:com.example.frank.networkframework.http_processor
 * USER:Frank
 * DATE:2018/10/19
 * TIME:20:48
 * DAY_NAME_FULL:星期五
 * DESCRIPTION:On the description and function of the document
 **/
public class HttpHelper implements IHttpProcessor{
    private static HttpHelper instance;
    private Map<String,Object> mParams;
    private static IHttpProcessor iHttpProcessor=null;
    private HttpHelper(){
        mParams=new HashMap<>();
    }

    public static HttpHelper getInstance(){
        synchronized (HttpHelper.class){
            if (instance==null){
                instance=new HttpHelper();
            }
        }
        return instance;
    }
    public static void init(IHttpProcessor httpProcessor){
        iHttpProcessor=httpProcessor;
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallback callback) {
        iHttpProcessor.post(url,params,callback);
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {
        iHttpProcessor.get(url,params,callback);

    }

    public static String appendParams(String url,Map<String,Object> params){
        if (params==null||params.isEmpty()){
            return url;
        }

        StringBuilder urlBuilder=new StringBuilder(url);
        if (urlBuilder.indexOf("?")<=0){
            urlBuilder.append("?");
        }else {
            if (!urlBuilder.toString().endsWith("?")){
                urlBuilder.append("&");
            }
        }

        for (Map.Entry<String,Object> entry:params.entrySet()){
            urlBuilder.append(entry.getKey()).append("=").append(encode(entry.getValue().toString()));
        }
        return urlBuilder.toString();
    }

    private static String encode(String str){
        try{
            return URLEncoder.encode(str,"utf-8");
        }catch (UnsupportedEncodingException e){
           throw new RuntimeException(e);
        }
    }
}
