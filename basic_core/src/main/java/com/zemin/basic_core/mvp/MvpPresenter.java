package com.zemin.basic_core.mvp;

public abstract class MvpPresenter<V extends MvpView>  {

    private V baseView;

    public void attach(V baseView) {
        this.baseView = baseView;
    }

    public void detach() {
        this.baseView = null;
    }

    public V getBaseView() {
        return baseView;
    }

    public boolean isAttach() {
        return baseView != null;
    }
}
