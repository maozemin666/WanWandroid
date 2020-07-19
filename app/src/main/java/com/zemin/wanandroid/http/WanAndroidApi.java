package com.zemin.wanandroid.http;


import com.zemin.rxhttp.Api;
import com.zemin.wanandroid.module.main.model.ArticleListBean;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @Date 2020/7/19 10:55
 * @Created by zemin
 */
public class WanAndroidApi extends Api {

    public static ApiService api() {
        return Api.api(ApiService.class);
    }

    public interface ApiService {

        @GET("article/list/{page}/json")
        Observable<WanAndroidReponse<ArticleListBean>> getArticleLis(@Path("page") int page);
    }
}
