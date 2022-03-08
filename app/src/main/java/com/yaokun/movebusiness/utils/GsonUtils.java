package com.yaokun.movebusiness.utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

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
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Type type) {
        return GSON.fromJson(json, type);
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
