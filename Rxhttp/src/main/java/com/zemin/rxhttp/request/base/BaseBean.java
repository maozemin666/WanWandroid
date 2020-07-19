package com.zemin.rxhttp.request.base;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * @Date 2020/7/19 13:09
 * @Created by zemin
 */
public class BaseBean implements Serializable {

    public String toJson() {
        return new Gson().toJson(this);
    }
}
