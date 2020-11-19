package com.zemin.basic_core.mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class MvpActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpView {
    protected P presenter;

    protected abstract int getLayoutId();

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        }
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        initialize();
    }

    protected void initialize() {
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detach();
        }
    }
}
