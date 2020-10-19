package com.zemin.wanandroid.module.home.model;

import androidx.annotation.NonNull;

import com.zemin.rxhttp.core.RxLife;
import com.zemin.wanandroid.http.BaseRequest;
import com.zemin.wanandroid.http.RequestListener;
import com.zemin.wanandroid.http.WanApi;
import com.zemin.wanandroid.http.WanCache;
import com.zemin.wanandroid.http.WanReponse;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

/**
 * @Date 2020/9/24 10:34
 * @Created by zemin
 */
public class HomeRequest extends BaseRequest {
    public static void getBanner(RxLife rxLife, RequestListener<List<BannerBean>> listener) {
        cacheAndNetList(rxLife,
                WanApi.api().getBanner(),
                listener,
                WanCache.CacheKey.BANNER, BannerBean.class);
    }


}
