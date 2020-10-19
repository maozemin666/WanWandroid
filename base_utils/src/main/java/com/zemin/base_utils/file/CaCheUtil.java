package com.zemin.base_utils.file;

import com.zemin.base_utils.Utils;

import java.io.File;

/**
 * @Date 2020/10/11 21:09
 * @Created by zemin
 */
public class CaCheUtil {
    private CaCheUtil() {
    }

    public static String getCacheDir() {
        File cacheFile = null;
        if (FileUtils.isSDCardAlive()) {
            cacheFile = Utils.getAppContext().getExternalCacheDir();
        }
        if (cacheFile == null) {
            cacheFile = Utils.getAppContext().getCacheDir();
        }
        return cacheFile.getAbsolutePath();
    }
}
