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

    class SimpleRequestListenerImpl<E> implements RequestListener<E> {
        @Override
        public void onStart() {

        }

        @Override
        public void onError() {

        }

        @Override
        public void onFinish() {

        }

        @Override
        public void onSuccess(int code, E data) {

        }

        @Override
        public void onFail(int code, String msg) {

        }
    }
}
