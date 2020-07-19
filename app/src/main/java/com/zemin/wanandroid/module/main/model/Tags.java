package com.zemin.wanandroid.module.main.model;

import com.zemin.rxhttp.request.base.BaseBean;

/**
 * @Date 2020/7/19 12:24
 * @Created by zemin
 */
public class Tags extends BaseBean {
    /**
     * name : 本站发布
     * url : /article/list/0?cid=440
     */

    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
