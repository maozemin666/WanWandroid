package com.zemin.wanandroid.http;

import androidx.annotation.NonNull;

import com.zemin.rxhttp.IRequest;
import com.zemin.rxhttp.RxRequest;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @Date 2020/7/19 11:56
 * @Created by zemin
 */
public class BaseRequest {

    public static <T> Disposable request(Observable<WanAndroidReponse<T>> observable, @NonNull RequestListener<T> requestListener) {
        return RxRequest.create(observable)
                .listener(new RxRequestListener(requestListener))
                .request(new RxResultCallBack<>(requestListener));
    }

    static class RxRequestListener implements IRequest.RequestListener {
        private RequestListener listener;

        RxRequestListener(RequestListener listener) {
            this.listener = listener;
        }

        @Override
        public void onStart() {
            listener.onStart();
        }

        @Override
        public void onError() {
            listener.onError();
        }

        @Override
        public void onFinish() {
            listener.onFinish();
        }
    }

    static class RxResultCallBack<T> implements IRequest.ResultCallBack<T> {
        private RequestListener<T> listener;

        RxResultCallBack(RequestListener<T> listener) {
            this.listener = listener;
        }

        @Override
        public void onSuccess(int code, T data) {
            listener.onSuccess(code, data);
        }

        @Override
        public void onFail(int code, String msg) {
            listener.onFail(code, msg);
        }
    }
}
