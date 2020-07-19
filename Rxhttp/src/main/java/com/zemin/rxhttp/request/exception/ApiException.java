package com.zemin.rxhttp.request.exception;

/**
 * @Date 2020/7/18 16:36
 * @Created by zemin
 */
public class ApiException extends Exception {
    private final String msg;
    private final int code;

    public ApiException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
