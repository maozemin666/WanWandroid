package com.zemin.rxhttp;

import com.zemin.rxhttp.core.RxHttp;
import com.zemin.rxhttp.core.RxLife;
import com.zemin.rxhttp.request.base.BaseResponse;
import com.zemin.rxhttp.request.exception.ApiException;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @Date 2020/7/16 22:11
 * @Created by zemin
 */
public class RxRequest<T, R extends BaseResponse<T>> implements IRequest<T> {

    private final Observable<R> observable;
    private RequestListener requestListener;
    private RxLife rxLife;

    private RxRequest(Observable<R> observable) {
        this.observable = observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public static <T, R extends BaseResponse<T>> RxRequest<T, R> create(Observable<R> observable) {
        return new RxRequest<>(observable);
    }

    public RxRequest<T, R> listener(RequestListener requestListener) {
        this.requestListener = requestListener;
        return this;
    }

    public RxRequest<T, R> autoLife(RxLife rxLife) {
        this.rxLife = rxLife;
        return this;
    }

    @Override
    public Disposable request(ResultCallBack<T> callBack) {
        Disposable disposable = observable.subscribe(response -> {
            if (!isSuccess(response.getCode())) {
                throw new ApiException(response.getCode(), response.getMsg());
            }
            if (callBack != null) {
                callBack.onSuccess(response.getCode(), response.getData());
            }
        },
        error -> {
            if (error instanceof ApiException) {
                ApiException e = (ApiException) error;
                if (callBack != null) {
                    callBack.onFail(e.getCode(), e.getMessage());
                } else {
                    if (requestListener != null) {
                        requestListener.onError();
                    }
                }
            }
            if (requestListener != null) {
                requestListener.onFinish();
            }
        },
        () -> {
            if (requestListener != null) {
                requestListener.onFinish();
            }
        });
        if (rxLife != null) {
            rxLife.add(disposable);
        }
        return disposable;
    }

    private boolean isSuccess(int code) {
        if (code == RxHttp.getRequestSetting().getSuccessCode()) {
            return true;
        }
        return false;
    }
}
