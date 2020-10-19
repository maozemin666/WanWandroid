package com.zemin.basic_core.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @Date 2020/9/22 18:15
 * @Created by zemin
 */
public abstract class MvpFragment<P extends MvpPresenter> extends Fragment implements MvpView {

    protected P presenter;

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            final int layoutRes = getLayoutRes();
            if (layoutRes > 0) {
                rootView = inflater.inflate(layoutRes, container, false);
            }
        }
        return rootView;
    }

    protected abstract int getLayoutRes();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attachPresenter();
        initialize();
    }

    private void attachPresenter() {
        if (presenter == null) {
            presenter = initPresenter();
        }
        if (presenter != null) {
            presenter.attach(this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.detach();
        }
    }

    private void initialize() {
        initView();
        loadData();
    }

    public final <V extends View> V findViewById(@IdRes int id) {
        return rootView.findViewById(id);
    }

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract void loadData();
}
