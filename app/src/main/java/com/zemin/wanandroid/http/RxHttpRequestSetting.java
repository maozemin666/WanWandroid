package com.zemin.wanandroid.http;

import com.zemin.rxhttp.request.setting.DefaultRequestSetting;

/**
 * @Date 2020/7/19 11:29
 * @Created by zemin
 */
public class RxHttpRequestSetting extends DefaultRequestSetting {
    @Override
    public int getSuccessCode() {
        return RequestSettingConfig.SUCCESS_CODE;
    }

    @Override
    public String getBaseUrl() {
        return RequestSettingConfig.BASE_URL;
    }
}
