package com.example.administrator.mypanda.ui.homepage;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.HomeBean;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;
import com.example.administrator.mypanda.ui.HudongActivity;
import com.example.administrator.mypanda.ui.adapters.HomeFVAdapter;
import com.example.administrator.mypanda.ui.base.BaseActivity;
import com.example.administrator.mypanda.ui.fragmens.ChinaLiveFragment;
import com.example.administrator.mypanda.ui.fragmens.CultureFragment;
import com.example.administrator.mypanda.ui.fragmens.HomeFragment;
import com.example.administrator.mypanda.ui.fragmens.LiveFragment;
import com.example.administrator.mypanda.ui.fragmens.ObservationFragment;
import com.example.administrator.mypanda.views.NoScrollViewPager;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * @author 农民伯伯
 * @version 2017/11/2
 */

public class HomeAcitivity extends BaseActivity implements Iview<HomeBean>,ViewPager.OnPageChangeListener, View.OnClickListener {

    private NoScrollViewPager mHomeViewPager;
    private TabLayout mHomeTabLayou;
    private TextView mHomeTitle;
    private ImageView mPerson_sign;
    private ImageView mHudong;
    ArrayList<String> mTitle = new ArrayList<>();
    ArrayList<Fragment> mList = new ArrayList<>();
    private ImageView mLog;
    @Inject
    Presenters presenters;
    @Override
    public void setViewVisible() {
        setHeaderViewVisible(View.VISIBLE);
        setNotScrollViewVisible(View.VISIBLE);
        setFooterViewVisible(View.VISIBLE);
        setHeaderView(R.layout.activity_home_header);
        setBodyView(R.layout.activity_home_body);
        setFooterView(R.layout.activity_home_footer);
    }
    @Override
    protected void onResume() {
        /**
         * 设置为竖屏
         */
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        super.onResume();
    }
    @Override
    public void init() {
        mHomeTabLayou = (TabLayout) findViewById(R.id.mHomeTabLayou);
        mHomeViewPager = (NoScrollViewPager) findViewById(R.id.mHomeViewPager);
        mPerson_sign = (ImageView) findViewById(R.id.mPerson_sign);
        mHudong = (ImageView) findViewById(R.id.mHudong);
        mHomeTitle = (TextView) findViewById(R.id.mHomeTitle);
        mLog = (ImageView) findViewById(R.id.mLog);
        mHudong.setOnClickListener(this);
        //首页
        HomeFragment homeFragment = new HomeFragment();
        //熊猫观察
        ObservationFragment observationFragment = new ObservationFragment();
        //熊猫文化
        CultureFragment cultureFragment = new CultureFragment();

        //熊猫直播
        LiveFragment liveFragment = new LiveFragment();

        //直播中国
        ChinaLiveFragment chinaLiveFragment = new ChinaLiveFragment();

        presenters.requestNews("http://www.ipanda.com/kehuduan/PAGE1450172284887217/index.json");

        mList.add(homeFragment);
        mList.add(observationFragment);
        mList.add(cultureFragment);
        mList.add(liveFragment);
        mList.add(chinaLiveFragment);
        mTitle.add("首页");
        mTitle.add("熊猫观察");
        mTitle.add("熊猫文化");
        mTitle.add("熊猫直播");
        mTitle.add("直播中国");

        HomeFVAdapter adapter = new HomeFVAdapter(getSupportFragmentManager(), mList, mTitle);
        mHomeTabLayou.setupWithViewPager(mHomeViewPager);
        mHomeViewPager.setAdapter(adapter);
        mHomeViewPager.setNoScroll(true);
        mHomeTabLayou.getTabAt(0).setIcon(R.mipmap.tab_home_normal);
        mHomeTabLayou.getTabAt(1).setIcon(R.mipmap.tab_panda_eye_normal);
        mHomeTabLayou.getTabAt(2).setIcon(R.mipmap.tab_panda_culture_normals);
        mHomeTabLayou.getTabAt(3).setIcon(R.mipmap.tab_panda_live_normal);
        mHomeTabLayou.getTabAt(4).setIcon(R.mipmap.tab_live_china_normal);
        mHomeViewPager.setOnPageChangeListener(this);

    }

    @Override
    public void setDagger() {
        DaggerUserComponent.builder().ipersenter(new Ipersenter(this,this)).build().inject(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position != 0) {
            mHomeTitle.setText(mTitle.get(position));
            mHudong.setVisibility(View.GONE);
            mLog.setVisibility(View.GONE);
        } else {
            mHomeTitle.setText(" ");
            mHudong.setVisibility(View.VISIBLE);
            mLog.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mHudong:
                startActivity(new Intent(this, HudongActivity.class));
                break;


        }
    }

    @Override
    public void success(HomeBean homeBean) {
//        List<HomeBean.TabBean> tab = homeBean.getTab();
    }

    @Override
    public void failure(Throwable e) {

    }
}
