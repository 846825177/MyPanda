package com.example.administrator.mypanda.http.products;

import android.content.Context;

import com.example.administrator.mypanda.interfacs.HttpCallback;
import com.example.administrator.mypanda.tools.OkHttpTools;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author 农民伯伯
 * @version 2017/11/1
 *          抽象工厂中的具体产品
 */

public class OkHttpRequest<T> implements HttpRequest<T> {
    @Override
    public void doGet(Context context, String path, final Type type, final HttpCallback<T> callback) {
        Request request = new Request.Builder().get().url(path).build();
        Call call = OkHttpTools.getInstance().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.failure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Gson gson = new Gson();
                T t = gson.fromJson(response.body().string(), type);
                callback.success(t);
            }
        });
    }

    @Override
    public void doPost(Context context, String path, final Type type, Map<String, String> mParams, final HttpCallback<T> callback) {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().method("POST", body).url(path).build();
        Call call = OkHttpTools.getInstance().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.failure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Gson gson = new Gson();
                T t = gson.fromJson(response.body().string(), type);
                callback.success(t);
            }
        });
    }
}
