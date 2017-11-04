package com.example.administrator.mypanda.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.ui.base.BaseActivity;

public class HudongActivity extends BaseActivity {


    private ImageView mHuDong_return;
    private TextView mHuDong_title;

    @Override
    public void setViewVisible() {
        setHeaderViewVisible(View.VISIBLE);
        setNotScrollViewVisible(View.VISIBLE);
        setHeaderView(R.layout.activity_hudong_header);
        setBodyView(R.layout.activity_hudong_body);
    }

    @Override
    public void init() {
        mHuDong_return = (ImageView) findViewById(R.id.mHuDong_Return);
        mHuDong_title =     (TextView) findViewById(R.id.mHuDong_Title);
    }

    @Override
    public void setDagger() {

    }
}
