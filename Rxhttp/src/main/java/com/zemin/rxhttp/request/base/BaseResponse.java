package com.zemin.rxhttp.request.base;

/**
 * @Date 2020/7/16 22:30
 * @Created by zemin
 */
public interface BaseResponse<E> {
    int getCode();

    void setCode(int code);

    E getData();

    String getMsg();

    void setMsg(String msg);
}
