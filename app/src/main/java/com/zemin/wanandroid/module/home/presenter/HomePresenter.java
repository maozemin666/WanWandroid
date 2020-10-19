package com.zemin.wanandroid.module.home.presenter;

import com.zemin.basic_core.base.BasePresenter;
import com.zemin.wanandroid.http.RequestListener;
import com.zemin.wanandroid.module.home.model.BannerBean;
import com.zemin.wanandroid.module.home.model.HomeRequest;
import com.zemin.wanandroid.module.home.view.HomeView;

import java.util.List;

/**
 * @Date 2020/9/22 18:31
 * @Created by zemin
 */
public class HomePresenter extends BasePresenter<HomeView> {

    public void getBanner() {
        HomeRequest.getBanner(getRxLife(), new RequestListener.SimpleRequestListenerImpl<List<BannerBean>>(){
            @Override
            public void onSuccess(int code, List<BannerBean> data) {
                if (isAttach()) {
                    getBaseView().getBannerSuccess(code, data);
                }
            }

            @Override
            public void onFail(int code, String msg) {
                if (isAttach()) {
                    getBaseView().getBannerFail(code, msg);
                }
            }
        });
    }

    public void getTopArticleList() {

    }

    public void getArticleList(int currentPage) {

    }
}
