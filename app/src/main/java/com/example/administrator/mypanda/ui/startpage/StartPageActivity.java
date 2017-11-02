package com.example.administrator.mypanda.ui.startpage;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.tools.Tools;
import com.example.administrator.mypanda.ui.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class StartPageActivity extends BaseActivity {

    @InjectView(R.id.mStartViewPager)
    ViewPager mStartViewPager;

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
        ButterKnife.inject(this);

        if (Tools.isNetworkAvailable(this)) {
            SharedPreferences preferences = getSharedPreferences("publicfile", this.MODE_PRIVATE);
            String version = preferences.getString("version", "");
            if (version != null && !version.equals("")) {

            } else {

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

}
