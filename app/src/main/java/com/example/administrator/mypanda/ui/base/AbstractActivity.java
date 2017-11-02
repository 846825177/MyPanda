package com.example.administrator.mypanda.ui.base;

import android.support.v7.app.AppCompatActivity;

import com.example.administrator.mypanda.tools.Tools;

/**
 * @author 农民伯伯
 * @version 2017/11/1
 */

public abstract class AbstractActivity extends AppCompatActivity implements AbstractBase {
    /**
     * 布局默认全部都不使用
     * <p>
     * isShowHeaderView = false;            控制是否使用头布局
     * isShowFooterView = false;            控制是否使用尾布局
     * isShowNotScrollViewVisible = false;  控制是否使用不滑动的主体布局
     * isShowScrollView = false;            控制是否使用滑动的主体布局
     * isShowRefreshView = false;           控制是否使用刷新的主体布局
     * isShowErrorView = false;             控制是否使用错误布局
     */
    public boolean isShowHeaderView = false;
    public boolean isShowFooterView = false;
    public boolean isShowNotScrollView = false;
    public boolean isShowScrollView = false;
    public boolean isShowRefreshView = false;
    public boolean isShowErrorView = false;

    /**
     * 显示AlertDialog 的方法
     * @param title
     * @param message cancleAlertDialog() 取消显示alertDialog
     */
    @Override
    public void showAlertDialog(String title, String message) {
        Tools.showAlertDialog(this, title, message);
    }

    /**
     * 取消显示AlertDialog的方法
     */

    @Override
    public void cancleAlertDialog() {
        Tools.cancleAlertDialog();
    }
}
