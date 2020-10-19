package com.zemin.wanandroid.http;


import com.zemin.rxhttp.Api;
import com.zemin.wanandroid.module.home.model.BannerBean;
import com.zemin.wanandroid.module.main.model.ArticleListBean;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @Date 2020/7/19 10:55
 * @Created by zemin
 */
public class WanApi extends Api {

    public static ApiService api() {
        return Api.api(ApiService.class);
    }

    public interface ApiCode {
        int SUCCESS = 0;

        int ERROR = 1000;
    }

    public interface ApiService {

        @GET("article/list/{page}/json")
        Observable<WanReponse<ArticleListBean>> getArticleLis(@Path("page") int page);

        @GET("banner/json")
        Observable<WanReponse<List<BannerBean>>> getBanner();
    }
}
