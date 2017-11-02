package com.example.administrator.mypanda.ui.startpage;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.concat.Concat;
import com.example.administrator.mypanda.entity.TestEntity;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;
import com.example.administrator.mypanda.tools.Tools;
import com.example.administrator.mypanda.ui.base.BaseActivity;

import javax.inject.Inject;

public class StartPageActivity extends BaseActivity implements Iview<TestEntity> {


    @Inject
    Presenters presenters;

    /**
     * 在这里控制布局的显示
     */

    @Override
    public void setViewVisible() {
        setHeaderViewVisible(View.GONE);
        setNotScrollViewVisible(View.VISIBLE);
        setFooterViewVisible(View.GONE);

    }


    /**
     * 初始化布局和相关操作
     */


    @Override
    public void init() {
        setBodyView(R.layout.activity_start);
        if (Tools.isNetworkAvailable(this)) {
            SharedPreferences preferences = getSharedPreferences("publicfile", this.MODE_PRIVATE);
            String version = preferences.getString("version", "");
            presenters.requestNews(Concat.BASE_URL + Concat.TAB_URL);
        } else {
            Tools.showNetWork(this, "当前无网络连接", "好的", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                }
            });
        }
    }

    @Override
    public void setDagger() {
        DaggerUserComponent.builder().ipersenter(new Ipersenter(this)).build().inject(this);
    }

    @Override
    public void success(TestEntity testEntity) {
        Log.e("TAG", testEntity.toString());
    }

    @Override
    public void failure(Throwable e) {

    }


}

