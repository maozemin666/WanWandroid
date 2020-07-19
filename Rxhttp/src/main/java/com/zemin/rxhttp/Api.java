package com.zemin.rxhttp;

/**
 * @Date 2020/7/16 23:42
 * @Created by zemin
 */
public class Api {
    protected static <T> T api(Class<T> clazz) {
        return RequestClientManager.getService(clazz);
    }
}
