package com.zemin.wanandroid;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.zemin.basic_core.base.BaseActivity;
import com.zemin.basic_core.mvp.MvpPresenter;
import com.zemin.wanandroid.module.home.fragment.HomeFragment;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void initView() {
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.content);
        if (fragment == null) {
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.add(R.id.content, HomeFragment.create());
            fragmentTransaction.commit();
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected MvpPresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}