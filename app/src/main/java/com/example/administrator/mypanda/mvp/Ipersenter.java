package com.example.administrator.mypanda.mvp;

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
    public Ipersenter(Iview iview) {
        this.iview = iview;
    }

    @Provides
    Presenters Ipersenter() {
        return new Presenters(iview);
    }
}