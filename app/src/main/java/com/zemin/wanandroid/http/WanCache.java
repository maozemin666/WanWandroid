package com.zemin.wanandroid.http;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jakewharton.disklrucache.DiskLruCache;
import com.zemin.base_utils.file.CaCheUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


/**
 * @Date 2020/10/11 20:54
 * @Created by zemin
 */
public class WanCache {
    private static final String TAG = "WanCache";

    private static final long MAX_SIZE = 10 * 1024 * 1024; // 10M
    private static final String DIR_NAME = "rx-cache";

    private DiskLruCache diskLruCache;

    private Gson gson = new Gson();

    private WanCache() {
        openLruCache();
    }

    private static class SingletonHolder {
        private static final WanCache INSTANCE = new WanCache();
    }

    public static WanCache getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public DiskLruCache getDiskLruCache() {
        if (diskLruCache == null) {
            throw new RuntimeException("WanCache未初始化或初始化失败");
        }
        return diskLruCache;
    }

    private void openLruCache() {
        if (diskLruCache != null && !diskLruCache.isClosed()) {
            try {
                diskLruCache.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File file = new File(CaCheUtil.getCacheDir(), DIR_NAME);
        if (!file.exists()) {
            if (!file.mkdir()) {
                Log.d(TAG, "file not create success");
                return;
            }
        }
        try {
            diskLruCache = DiskLruCache.open(file, 1, 1, MAX_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isSame(Object cache, Object net) {
        String cacheJson = gson.toJson(cache);
        String netJson = gson.toJson(net);
        return TextUtils.equals(cacheJson, netJson);
    }

    public Disposable save(String key, Object bean) {
        return Observable.create(emitter -> saveSync(key, bean))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public Disposable remove(String key) {
        return Observable.create(emitter -> removeSync(key))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public <T> Disposable getList(String key, Class<T> clazz, CacheListener<List<T>> cacheListener) {
        return Observable.create(
                emitter -> {
                    List<T> beans = getListSync(key, clazz);
                    if (beans == null) {
                        throw new RuntimeException("缓存值为空");
                    }
                    emitter.onNext(beans);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        beans -> {
                            cacheListener.onSuccess(WanApi.ApiCode.SUCCESS, (List<T>) beans);
                        }
                        , error -> {
                            cacheListener.onFail();
                        });
    }

    private  <T> List<T> getListSync(String key, Class<T> clazz) throws IOException {
        synchronized (getDiskLruCache()) {
            DiskLruCache.Snapshot snapshot = getDiskLruCache().get(key);
            String json = snapshot.getString(0);
            List<T> list = jsonToBeanList(json, clazz);
            snapshot.close();
            return list;
        }
    }

    private <T> List<T> jsonToBeanList(String json, Class<T> clazz) {
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        ArrayList<T> list = new ArrayList<>();
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = jsonParser.parse(json).getAsJsonArray();
        for (JsonElement jsonElement : jsonArray) {
            list.add(gson.fromJson(jsonElement, clazz));
        }
        return list;
    }

    private void saveSync(String key, Object bean) throws IOException {
        synchronized (getDiskLruCache()) {
            DiskLruCache.Editor editor = getDiskLruCache().edit(key);
            editor.set(0, gson.toJson(bean));
            editor.commit();
            getDiskLruCache().flush();
        }
    }

    private void removeSync(String key) throws IOException {
        synchronized (getDiskLruCache()) {
            getDiskLruCache().remove(key);
        }
    }

    public static class CacheKey {
        public static final String BANNER = "banner_json";
    }
}
