package com.zemin.wanandroid.common;

import android.app.Application;

import com.zemin.rxhttp.core.RxHttp;
import com.zemin.wanandroid.http.RxHttpRequestSetting;

/**
 * @Date 2020/7/19 11:42
 * @Created by zemin
 */
public class WanAndroid extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RxHttp.getInstance().init(this);
        RxHttp.getInstance().initRequest(new RxHttpRequestSetting());
    }
}
