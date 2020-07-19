package com.zemin.basic_core.mvp;

public class MvpPresenter<V extends MvpView>  {

    private V baseView;

    public void attach(V baseView) {
        this.baseView = baseView;
    }
}
