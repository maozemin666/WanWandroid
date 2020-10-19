package com.zemin.wanandroid.module.main.activity;

import com.zemin.basic_core.base.BaseActivity;
import com.zemin.wanandroid.R;
import com.zemin.wanandroid.module.main.view.ArticlePresenter;

/**
 * @Date 2020/9/24 15:32
 * @Created by zemin
 */
public class ArticleActivity extends BaseActivity<ArticlePresenter> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_article;
    }

    @Override
    protected ArticlePresenter initPresenter() {
        return new ArticlePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
