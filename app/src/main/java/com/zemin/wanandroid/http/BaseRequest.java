package com.zemin.wanandroid.http;

import androidx.annotation.NonNull;

import com.zemin.rxhttp.IRequest;
import com.zemin.rxhttp.RxRequest;
import com.zemin.rxhttp.core.RxLife;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @Date 2020/7/19 11:56
 * @Created by zemin
 */
public class BaseRequest {

    public static <T> void cacheAndNetList(RxLife rxLife
            , Observable<WanReponse<List<T>>> observable, @NonNull RequestListener<List<T>> requestListener
            , String key, Class<T> clazz) {
        cacheAndNetList(rxLife, false, observable, requestListener, key, clazz);
    }

    public static <T> void cacheAndNetList(RxLife rxLife, boolean isRefresh
            , Observable<WanReponse<List<T>>> observable, @NonNull RequestListener<List<T>> requestListener
            , String key, Class<T> clazz) {
        if (isRefresh) {
            rxLife.add(request(observable, requestListener, respToCache -> {
                WanCache.getInstance().save(key, respToCache);
                return true;
            }));
            return;
        }

        // from cache
        rxLife.add(WanCache.getInstance().getList(key, clazz, new CacheListener<List<T>>() {
            @Override
            public void onSuccess(int code, List<T> data) {
                requestListener.onSuccess(code, data);
                request(observable, requestListener, respToCache -> {
                    if (WanCache.getInstance().isSame(data, respToCache)) {
                        return false;
                    }

                    // update cache from net
                    WanCache.getInstance().save(key, respToCache);
                    return true;
                });
            }

            @Override
            public void onFail() {
                request(observable, requestListener, respToCache -> {
                    WanCache.getInstance().save(key, respToCache);
                    return true;
                });
            }
        }));
    }

    protected static <T> Disposable request(Observable<WanReponse<T>> observable
            , @NonNull RequestListener<T> requestListener
            , @NonNull RespToCache<T> respToCache) {
        return RxRequest.create(observable)
                .listener(new RxRequestListener(requestListener))
                .request(new RxResultCallBack<>(requestListener, respToCache));
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
        private final RespToCache<T> respToCache;
        private final RequestListener<T> requestListener;

        RxResultCallBack(RequestListener<T> listener, RespToCache<T> respToCache) {
            this.requestListener = listener;
            this.respToCache = respToCache;
        }

        @Override
        public void onSuccess(int code, T data) {
            requestListener.onSuccess(code, data);
            respToCache.onResponse(data);
        }

        @Override
        public void onFail(int code, String msg) {
            requestListener.onFail(code, msg);
        }
    }

    public interface RespToCache<T> {
        boolean onResponse(T resp);
    }
}
