package com.example.administrator.mypanda.mvp;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 2017/5/8.
 * Author:crs
 * Description:用于提供依赖
 */

@Module
public class Ipersenter {
    private Iview iview;
    private Context context;
    public Ipersenter(Context context, Iview iview) {
        this.iview = iview;
        this.context=context;
    }

    @Provides
    Presenters Ipersenter() {
        return new Presenters(context,iview);
    }
}