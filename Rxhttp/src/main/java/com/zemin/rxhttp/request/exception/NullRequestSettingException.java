package com.zemin.rxhttp.request.exception;

/**
 * @Date 2020/7/18 16:38
 * @Created by zemin
 */
public class NullRequestSettingException extends RuntimeException {
    public NullRequestSettingException() {
        super("requestsetting未设置");
    }
}
