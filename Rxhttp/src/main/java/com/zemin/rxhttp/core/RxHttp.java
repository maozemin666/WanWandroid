package com.zemin.rxhttp.core;

import android.content.Context;

import com.zemin.rxhttp.request.exception.NullRequestSettingException;
import com.zemin.rxhttp.request.setting.RequestSetting;

/**
 * @Date 2020/7/18 16:07
 * @Created by zemin
 */
public class RxHttp implements BaseHttp {

    private Context context;
    private RequestSetting requestSetting;

    private RxHttp() {
    }

    public static RxHttp getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final RxHttp INSTANCE = new RxHttp();
    }

    @Override
    public void init(Context context) {
        this.context = context;
    }

    @Override
    public void initRequest(RequestSetting requestSetting) {
        this.requestSetting = requestSetting;
    }

    public static RequestSetting getRequestSetting() {
        RequestSetting requestSetting = getInstance().requestSetting;
        if (requestSetting == null) {
            throw new NullRequestSettingException();
        }
        return requestSetting;
    }
}
