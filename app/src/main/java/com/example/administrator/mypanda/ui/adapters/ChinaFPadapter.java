package com.example.administrator.mypanda.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.mypanda.entity.ChinaLiveEntity;
import com.example.administrator.mypanda.ui.fragmens.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 农民伯伯
 * @version 2017/11/17
 */

public class ChinaFPadapter extends FragmentPagerAdapter {

    private  ArrayList<BaseFragment> mList;
    private  List<ChinaLiveEntity.TablistBean> tablist;

    public ChinaFPadapter(FragmentManager fm, List<ChinaLiveEntity.TablistBean> tablist,ArrayList<BaseFragment> mList) {
        super(fm);
        this.mList = mList;
        this.tablist = tablist;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tablist.get(position).getTitle();
    }
}
