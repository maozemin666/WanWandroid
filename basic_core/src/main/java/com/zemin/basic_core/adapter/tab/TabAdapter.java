package com.zemin.basic_core.adapter.tab;

import android.view.View;

import androidx.fragment.app.Fragment;

/**
 * @Date 2020/11/15 17:47
 * @Created by zemin
 */
public interface TabAdapter<T> {
    void onBindData(View view, T data, boolean isSelected);

    void onDoubleTap(Fragment fragment);
}
