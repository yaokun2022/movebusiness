package com.yaokun.movebusiness.data;

import android.util.Log;

import com.google.gson.Gson;
import com.yaokun.movebusiness.utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Callback;

/**
 * 远程数据请求
 */
public class RemoteRepository {
    private static final String TAG = RemoteRepository.class.getSimpleName();

    // 登陆接口url
    private static final String LOGIN_URL = "http://mock.bigoat.com/mock/620e59762f09d576049aa3a9/park/login";
    private static final String AUTH_LIST_URL = "http://mock.bigoat.com/mock/620e59762f09d576049aa3a9/park/getAuthList";

    private static final Gson GSON = new Gson();


    /**
     * 登陆接口
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public static void login(String username, String password, Callback callback) {

        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);

        String json = GSON.toJson(map);
        Log.d(TAG, json);

        HttpUtils.post(LOGIN_URL, json, callback);
    }



    /**
     * 授权记录接口
     *
     * @param park 车牌
     * @return
     */
    public static void getAuthList(String park, Callback callback) {

        Map<String, String> map = new HashMap<>();
        map.put("park", park);

        HttpUtils.get(AUTH_LIST_URL, map, callback);
    }
}
