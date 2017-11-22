package com.example.administrator.mypanda.ui.startpage;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.concat.Concat;
import com.example.administrator.mypanda.entity.TestEntity;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;
import com.example.administrator.mypanda.tools.Tools;
import com.example.administrator.mypanda.ui.base.BaseActivity;
import com.example.administrator.mypanda.ui.homepage.HomeAcitivity;

import java.util.ArrayList;

import javax.inject.Inject;

public class StartPageActivity extends BaseActivity implements Iview<TestEntity> {

    @Inject
    Presenters presenters;
    private ArrayList<ImageView> mPagerList = new ArrayList<>();
    private Handler handler = new Handler();

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
        presenters.requestNews(Concat.BASE_URL+Concat.TAB_URL);
        if (Tools.isNetworkAvailable(this)) {
            SharedPreferences preferences = getSharedPreferences("publicfile", this.MODE_PRIVATE);
            String version = preferences.getString("version", "");
            if (version != null && !version.equals("")) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(StartPageActivity.this, HomeAcitivity.class));
                        finish();
                    }
                }, 2000);
            } else {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(StartPageActivity.this, WelComeActivity.class));
                        finish();
                    }
                }, 2000);
            }


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
        DaggerUserComponent.builder().ipersenter(new Ipersenter(this,this)).build().inject(this);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void success(TestEntity testEntity) {
        Log.e("TAG","StartPageActivity:"+testEntity.toString());
    }

    @Override
    public void failure(Throwable e) {

    }
}

