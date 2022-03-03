package com.yaokun.movebusiness.utils;

import com.google.gson.Gson;

/**
 * Gson 工具
 */
public class GsonUtils {
    private static final Gson GSON = new Gson();

    /**
     *
     * @param json
     * @param classOfT
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Class<T> classOfT) {
        return GSON.fromJson(json, classOfT);
    }

    /**
     *
     * @param o
     * @return
     */
    public static String toJson(Object o) {
        return GSON.toJson(o);
    }
}
