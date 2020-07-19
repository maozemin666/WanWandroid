package com.zemin.rxhttp.core;

import android.content.Context;

import com.zemin.rxhttp.request.setting.RequestSetting;

/**
 * @Date 2020/7/18 16:16
 * @Created by zemin
 */
public interface BaseHttp {
    void init(Context context);

    void initRequest(RequestSetting requestSetting);
}
