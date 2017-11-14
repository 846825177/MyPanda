package com.example.administrator.mypanda.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.KeyEvent;
import android.view.View;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.PlayEntity;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;
import com.example.administrator.mypanda.ui.base.BaseActivity;

import javax.inject.Inject;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * @author 农民伯伯
 * @version 2017/11/14
 */

public class PlayAcitivity extends BaseActivity implements Iview<PlayEntity>{
@Inject
    Presenters presenters;
    private JCVideoPlayer mJCVideoPlayer;
    private long exitTime = 0;
    // 定义一个变量，来标识是否退出
    private static boolean isExit = false;
    @Override
    public void setViewVisible() {
        setNotScrollViewVisible(View.VISIBLE);
        setBodyView(R.layout.activity_play);
    }
    @Override
    protected void onResume() {
        /**
         * 设置为横屏
         */
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
    }
    @Override
    public void init() {
        mJCVideoPlayer = (JCVideoPlayer) findViewById(R.id.mJCVideoPlayer);
        Intent intent = getIntent();
        String pid = intent.getStringExtra("pid");
        presenters.requestNews("http://115.182.35.91/api/getVideoInfoForCBox.do?pid="+pid);
    }

    @Override
    public void setDagger() {
        DaggerUserComponent.builder().ipersenter(new Ipersenter(this,this)).build().inject(this);
    }

    @Override
    public void success(PlayEntity playEntity) {
        mJCVideoPlayer.setUp(playEntity.getVideo().getChapters().get(0).getUrl(),playEntity.getTitle());

    }

    @Override
    public void failure(Throwable e) {

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void exit() {
        if (!isExit) {
            isExit = true;
            if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }

        } else {
            finish();

        }
    }

}
