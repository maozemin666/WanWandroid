package com.zemin.base_utils.file;

import android.os.Environment;

/**
 * @Date 2020/10/18 13:47
 * @Created by zemin
 */
public class FileUtils {
    public static boolean isSDCardAlive() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }
}
