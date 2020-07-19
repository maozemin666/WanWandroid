package com.zemin.wanandroid.http;

/**
 * @Date 2020/7/19 12:35
 * @Created by zemin
 */
public interface RequestListener<E> {
    void onStart();

    void onError();

    void onFinish();

    void onSuccess(int code, E data);

    void onFail(int code, String msg);
}
