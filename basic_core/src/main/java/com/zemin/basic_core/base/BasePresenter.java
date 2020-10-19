package com.zemin.basic_core.base;

import com.zemin.basic_core.mvp.MvpPresenter;
import com.zemin.rxhttp.core.RxLife;

/**
 * @Date 2020/9/22 18:27
 * @Created by zemin
 */
public abstract class BasePresenter<V extends BaseView> extends MvpPresenter<V> {

    private RxLife rxLife;

    @Override
    public void attach(V baseView) {
        super.attach(baseView);
        rxLife = RxLife.create();
    }

    @Override
    public void detach() {
        super.detach();
        rxLife.destroy();
        rxLife = null;
    }

    public RxLife getRxLife() {
        return rxLife;
    }
}
