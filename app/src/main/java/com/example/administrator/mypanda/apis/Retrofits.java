package com.example.administrator.mypanda.apis;


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * @author 农民伯伯
 * @version 2017/10/31
 *          Retrofit进行网络请求的接口
 */
public interface Retrofits {
    @GET
    Observable<ResponseBody> doGet(@Url String url);

    @FormUrlEncoded
    @POST("{path}")
    Observable<ResponseBody> doPost(@Path("path") String path, @FieldMap Map<String, String> mMap);
}
