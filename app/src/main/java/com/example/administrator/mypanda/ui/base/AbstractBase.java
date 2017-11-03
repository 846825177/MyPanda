package com.example.administrator.mypanda.ui.base;

/**
 * @author 农民伯伯
 * @version 2017/11/2
 */

public interface  AbstractBase {


    /**
     * 设置显示哪个布局文件
     */
    public abstract void setViewVisible();

    /**
     * 初始化控件等相关操作
     */
    public abstract void init();

    /**
     * 设置初始化注入Dagger2
     */
    public abstract void setDagger();

    /**
     * showAlertDialog()  设置显示alertDialog
     *
     * @param title
     * @param message cancleAlertDialog() 取消显示alertDialog
     */

    public abstract void showAlertDialog(String title, String message);

    public abstract void cancleAlertDialog();

    /**
     * setHeaderView(int id); 设置头布局 传入控件id
     * setFooterView(int id); 设置尾部局 传入控件id
     * setBodyView(int id);   设置身体布局 传入控件id
     *
     * @param id
     */

    public abstract void setHeaderView(int id);

    public abstract void setFooterView(int id);

    public abstract void setBodyView(int id);

    /**
     * 设置是否使用布局
     *
     * @param visible
     */

    public abstract void setHeaderViewVisible(int visible);

    public abstract void setFooterViewVisible(int visible);

    public abstract void setNotScrollViewVisible(int visible);

    public abstract void setScrollViewVisible(int visible);

    public abstract void setRefreshViewVisible(int visible);

    public abstract void setErrorViewVisible(int visible);

    /**
     * 检查使用哪个布局
     */

    public abstract void checkBodyLayout();

    public abstract void checkHeaderLayout();

    public abstract void checkFooterLayout();

}
