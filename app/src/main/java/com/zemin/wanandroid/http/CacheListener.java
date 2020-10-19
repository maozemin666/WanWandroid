package com.zemin.wanandroid.http;

/**
 * @Date 2020/10/18 18:33
 * @Created by zemin
 */
public interface CacheListener<E> {
    void onSuccess(int code, E data);

    void onFail();
}
