package com.zemin.wanandroid.http;

import com.zemin.rxhttp.request.base.BaseResponse;

/**
 * @Date 2020/7/19 12:02
 * @Created by zemin
 */
public class WanReponse<E> implements BaseResponse<E> {
    private int errorCode;
    private String errorMsg;
    private E data;

    @Override
    public int getCode() {
        return errorCode;
    }

    @Override
    public void setCode(int code) {
        errorCode = code;
    }

    @Override
    public E getData() {
        return data;
    }

    @Override
    public String getMsg() {
        return errorMsg;
    }

    @Override
    public void setMsg(String msg) {
        errorMsg = msg;
    }
}
