package com.zemin.basic_core.adapter.tab;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * @Date 2020/11/15 17:46
 * @Created by zemin
 */
public class Page<T extends TabItem> {
    private final T data;
    private final TabAdapter<T> adapter;
    private final Fragment fragment;

    private View view;

    public Page(@NonNull Fragment fragment, @NonNull T data, @NonNull TabAdapter<T> adapter) {
        this.data = data;
        this.adapter = adapter;
        this.fragment = fragment;
    }

    public void notifyAdapterDoubleTap() {
        adapter.onDoubleTap(fragment);
    }

    public void notifyAdapterBindData(boolean selected) {
        adapter.onBindData(view, data, selected);
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public T getData() {
        return data;
    }
}
