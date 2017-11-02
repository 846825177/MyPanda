package com.example.administrator.mypanda.tools;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @author 农民伯伯
 * @version 2017/11/1
 *          Volley的单例类
 */

public class VolleyTools {
    private static VolleyTools tools;
    private RequestQueue queue;

    private VolleyTools(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public static VolleyTools getInstance(Context context) {
        if (tools == null) {
            synchronized (VolleyTools.class) {
                if (tools == null) {
                    tools = new VolleyTools(context);
                }
            }
        }
        return tools;
    }

    public <T> Request<T> add(Request<T> request) {
        return queue.add(request);
    }


}
