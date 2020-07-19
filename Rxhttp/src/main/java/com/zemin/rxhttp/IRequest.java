package com.zemin.rxhttp;

import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @Date 2020/7/16 22:17
 * @Created by zemin
 */
public interface IRequest<T> {

    Disposable request(ResultCallBack<T> resultCallBack);

    interface ResultCallBack<E> {
        void onSuccess(int code, E data);

        void onFail(int code, String msg);
    }

    interface RequestListener {
        void onStart();

        void onError();

        void onFinish();
    }
}
