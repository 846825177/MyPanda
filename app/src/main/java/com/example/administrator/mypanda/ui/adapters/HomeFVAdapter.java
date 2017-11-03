package com.example.administrator.mypanda.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * @author 农民伯伯
 * @version 2017/11/3
 */

public class HomeFVAdapter extends FragmentPagerAdapter {
    private final ArrayList<String> mTitle;
    private ArrayList<Fragment> mList;

    public HomeFVAdapter(FragmentManager fm, ArrayList<Fragment> mList, ArrayList<String> mTitle) {
        super(fm);
        this.mList = mList;
        this.mTitle = mTitle;
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
        return mTitle.get(position);
    }
}
