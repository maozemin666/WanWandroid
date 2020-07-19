package com.zemin.rxhttp.core;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @Date 2020/7/16 23:31
 * @Created by zemin
 */
public class RxLife {
    private CompositeDisposable compositeDisposable;

    private RxLife() {
        this.compositeDisposable = new CompositeDisposable();
    }

    public static RxLife create() {
        return new RxLife();
    }

    public void add(Disposable disposable) {
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            return;
        }
       compositeDisposable.add(disposable);
    }

    public void destroy() {
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            return;
        }
        compositeDisposable.dispose();
    }

}
