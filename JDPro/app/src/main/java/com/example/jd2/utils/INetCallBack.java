package com.example.jd2.utils;

public interface INetCallBack<T> {
    void onSuccess(T t);

    void onError(Throwable throwable);
}
