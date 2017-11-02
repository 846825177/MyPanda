package com.example.administrator.mypanda.mvp;

import com.example.administrator.mypanda.ui.startpage.StartPageActivity;

import dagger.Component;

/**
 * @author 农民伯伯
 * @version 2017/11/2
 */
@Component(modules = {Ipersenter.class})
public interface UserComponent {
    //当前只能写MainActivity，不能写Activity，要不然会出现空指针。
    void inject(StartPageActivity activity);
}