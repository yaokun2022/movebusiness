package com.yaokun.movebusiness.utils;


import java.io.IOException;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Http 工具
 */
public class HttpUtils {
    private final static MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private static final OkHttpClient CLIENT;
    static {
        CLIENT = new OkHttpClient.Builder().build();
    }

    /**
     * 发起post请求
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static void post(String url, String json, Callback callback) {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        CLIENT.newCall(request).enqueue(callback);
    }

    /**
     * 发起get请求
     *
     * @param url URL地址
     * @param params 参数
     * @return
     * @throws IOException
     */
    public static void get(String url, Map<String, String> params, Callback callback) {
        HttpUrl.Builder urlBuilder =HttpUrl.parse(url).newBuilder();
        if (params != null) {
            for(Map.Entry<String, String> param : params.entrySet()) {
                urlBuilder.addQueryParameter(param.getKey(),param.getValue());
            }
        }
        Request.Builder reqBuild = new Request.Builder();
        reqBuild.url(urlBuilder.build());
        Request request = reqBuild.build();
        CLIENT.newCall(request).enqueue(callback);
    }

}
