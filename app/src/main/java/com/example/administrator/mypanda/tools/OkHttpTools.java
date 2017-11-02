package com.example.administrator.mypanda.tools;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author 农民伯伯
 * @version 2017/11/1
 *          okhttp的单例类
 */

public class OkHttpTools {
    private static OkHttpTools tools;
    private OkHttpClient client;

    private OkHttpTools() {
        client = new OkHttpClient.Builder().build();

    }

    public static OkHttpTools getInstance() {
        if (tools == null) {
            synchronized (OkHttpTools.class) {
                if (tools == null) {
                    tools = new OkHttpTools();
                }
            }
        }
        return tools;
    }

    public Call newCall(Request request) {
        return client.newCall(request);
    }
}
