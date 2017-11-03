package com.example.administrator.mypanda.ui.homepage;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.ui.adapters.HomeFVAdapter;
import com.example.administrator.mypanda.ui.base.BaseActivity;
import com.example.administrator.mypanda.ui.fragmens.ChinaLiveFragment;
import com.example.administrator.mypanda.ui.fragmens.CultureFragment;
import com.example.administrator.mypanda.ui.fragmens.HomeFragment;
import com.example.administrator.mypanda.ui.fragmens.LiveFragment;
import com.example.administrator.mypanda.ui.fragmens.ObservationFragment;
import com.example.administrator.mypanda.views.NoScrollViewPager;

import java.util.ArrayList;

/**
 * @author 农民伯伯
 * @version 2017/11/2
 */

public class HomeAcitivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    private NoScrollViewPager mHomeViewPager;
    private TabLayout mHomeTabLayou;
    private TextView mHomeTitle;
    private ImageView mPerson_sign;
    private ImageView mHudong;
    ArrayList<String> mTitle = new ArrayList<>();
    private ImageView mLog;

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
    public void init() {
        mHomeTabLayou = (TabLayout) findViewById(R.id.mHomeTabLayou);
        mHomeViewPager = (NoScrollViewPager) findViewById(R.id.mHomeViewPager);
        mPerson_sign = (ImageView) findViewById(R.id.mPerson_sign);
        mHudong = (ImageView) findViewById(R.id.mHudong);
        mHomeTitle = (TextView) findViewById(R.id.mHomeTitle);
        mLog = (ImageView) findViewById(R.id.mLog);
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

        ArrayList<Fragment> mList = new ArrayList<>();
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
}
