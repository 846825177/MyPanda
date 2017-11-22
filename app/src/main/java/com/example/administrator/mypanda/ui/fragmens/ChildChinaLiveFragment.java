package com.example.administrator.mypanda.ui.fragmens;

/**
 * @author 农民伯伯
 * @version 2017/11/22
 */

public class ChildChinaLiveFragment extends BaseFragment {

    private  String url;

    public ChildChinaLiveFragment(String url) {
        this.url = url;
    }

    public static ChildChinaLiveFragment getInstance(String url){
        return new ChildChinaLiveFragment(url);
    }

    @Override
    public void setViewVisible() {

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
