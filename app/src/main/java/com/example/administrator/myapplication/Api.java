package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2019/11/20.
 */

public class Api {
    private static String token;
    private static String deviceId;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        Api.token = token;
    }

    public static String getdeviceId() {
        return deviceId;
    }

    public static void setdeviceId(String deviceId) {
        Api.deviceId = deviceId;
    }
}
