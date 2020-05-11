package com.example.jd2.utils;

import java.util.HashMap;

/**
 * httpurl 请求方式--  切换使用不需要更改代码，做到网络请求的切换
 * 工厂设计模式
 * 工厂设计类
 */
public class HttpUrlConnectionUtils implements INetWork {

    private static HttpUrlConnectionUtils httpUrlConnectionUtils;

    private HttpUrlConnectionUtils() {
    }

    public static HttpUrlConnectionUtils getInstance() {
        if (httpUrlConnectionUtils == null) {
            synchronized (HttpUrlConnectionUtils.class) {
                if (httpUrlConnectionUtils == null) {
                    httpUrlConnectionUtils = new HttpUrlConnectionUtils();
                }
            }
        }
        return httpUrlConnectionUtils;
    }

    /*@Override
    public void get(String url) {
        //也做网络请求

    }

    @Override
    public void get(String url, HashMap<String, String> s) {

    }

    @Override
    public void post() {

    }

    @Override
    public void post(String url, HashMap<String, String> s) {

    }*/

    @Override
    public <T> void get(String url, INetCallBack<T> netCallBack) {

    }

    @Override
    public <T> void get(String url, HashMap<String, String> s, INetCallBack<T> netCallBack) {

    }

    @Override
    public <T> void post(String url, INetCallBack<T> netCallBack) {

    }

    @Override
    public <T> void post(String url, HashMap<String, String> s, INetCallBack<T> netCallBack) {

    }
}
