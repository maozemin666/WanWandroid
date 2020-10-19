package com.zemin.wanandroid.module.home.view;

import com.zemin.basic_core.base.BaseView;
import com.zemin.wanandroid.module.home.model.BannerBean;

import java.util.List;

/**
 * @Date 2020/9/22 18:29
 * @Created by zemin
 */
public interface HomeView extends BaseView {
    void getBannerSuccess(int code, List<BannerBean> data);

    void getBannerFail(int code, String msg);
}
