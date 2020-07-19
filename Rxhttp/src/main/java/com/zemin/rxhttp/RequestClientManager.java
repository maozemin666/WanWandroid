package com.zemin.rxhttp;

import android.text.TextUtils;

import com.zemin.rxhttp.core.BaseClientManager;
import com.zemin.rxhttp.core.RxHttp;
import com.zemin.rxhttp.request.setting.RequestSetting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Date 2020/7/18 16:45
 * @Created by zemin
 */
public class RequestClientManager implements BaseClientManager {
    private final Retrofit retrofit;
    private final HashMap<Class<?>, Retrofit> retrofitMap;

    private RequestClientManager() {
        this.retrofit = create();
        this.retrofitMap = new HashMap<>();
    }

    public static RequestClientManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final RequestClientManager INSTANCE = new RequestClientManager();
    }

    @Override
    public Retrofit create() {
        return create(RxHttp.getRequestSetting().getBaseUrl());
    }

    private Retrofit create(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private Retrofit getRetrofit(Class<?> clazz) {
        if (clazz == null) {
            return retrofit;
        }

        Retrofit retrofit = null;
        if (retrofitMap != null && retrofitMap.size() > 0) {
            Iterator<Map.Entry<Class<?>,Retrofit>> iterator = retrofitMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Class<?>,Retrofit> entry = iterator.next();
                if (TextUtils.equals(entry.getKey().getName(), clazz.getName())) {
                    retrofit = entry.getValue();
                    if (retrofit == null) {
                        iterator.remove();
                    }
                    break;
                }
            }
        }
        if (retrofit != null) {
            return retrofit;
        }

        retrofit = create();
        retrofitMap.put(clazz, retrofit);
        return retrofit;
    }

    public static <T> T getService(Class<T> clazz) {
        return getInstance().getRetrofit(clazz).create(clazz);
    }
}
