package com.example.administrator.mypanda.http.products;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.administrator.mypanda.interfacs.HttpCallback;
import com.example.administrator.mypanda.tools.VolleyTools;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author 农民伯伯
 * @version 2017/11/1
 *          抽象工厂中的具体产品
 */

public class VolleyRequest<T> implements HttpRequest<T> {
    @Override
    public void doGet(Context context, String path, final Type type, final HttpCallback<T> callback) {
        StringRequest request = new StringRequest(Request.Method.GET, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                T t = gson.fromJson(response, type);
                callback.success(t);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.failure(error);
            }
        });
        VolleyTools.getInstance(context).add(request);
    }

    @Override
    public void doPost(Context context, String path, final Type type, final Map<String, String> mParams, final HttpCallback<T> callback) {
        StringRequest request = new StringRequest(Request.Method.POST, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                T t = gson.fromJson(response, type);
                callback.success(t);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.failure(error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return mParams;
            }
        };
        VolleyTools.getInstance(context).add(request);
    }
}
