package com.zemin.base_utils;

import android.content.Context;

/**
 * @Date 2020/10/18 13:53
 * @Created by zemin
 */
public class Utils {

    private static Context sContext;

    public static void init(Context context) {
        sContext = context;
    }

    public static Context getAppContext() {
        if (sContext == null) {
            throw new RuntimeException("utils 未在application初始化");
        }
        return sContext;
    }
}
