package com.zemin.wanandroid;

import android.util.Log;

import com.zemin.basic_core.base.BaseActivity;
import com.zemin.basic_core.mvp.MvpPresenter;
import com.zemin.wanandroid.http.BaseRequest;
import com.zemin.wanandroid.http.RequestListener;
import com.zemin.wanandroid.http.WanAndroidApi;
import com.zemin.wanandroid.module.main.model.ArticleListBean;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        BaseRequest.request(WanAndroidApi.api().getArticleLis(0), new RequestListener<ArticleListBean>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onError() {

            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onSuccess(int code, ArticleListBean data) {
                Log.e(TAG, "onSuccess: code="+code+"  data="+data.toJson());
            }

            @Override
            public void onFail(int code, String msg) {

            }
        });
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