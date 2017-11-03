package com.example.administrator.mypanda.ui.fragmens;

import android.view.View;

import com.example.administrator.mypanda.R;

/**
 * @author 农民伯伯
 * @version 2017/11/3
 */

public class HomeFragment extends BaseFragment {
    @Override
    public void setViewVisible() {
        setNotScrollViewVisible(View.VISIBLE);
        setBodyView(R.layout.fragment_home_body);
    }

    @Override
    public void init() {

    }

    @Override
    public void setDagger() {

    }

    @Override
    public void showAlertDialog(String title, String message) {

    }

    @Override
    public void cancleAlertDialog() {

    }
}
