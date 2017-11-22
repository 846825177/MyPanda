package com.example.administrator.mypanda.mvp;

import com.example.administrator.mypanda.ui.HudongActivity;
import com.example.administrator.mypanda.ui.PlayAcitivity;
import com.example.administrator.mypanda.ui.adapters.HomeRecyclerAdapter;
import com.example.administrator.mypanda.ui.adapters.ItemcAdapter;
import com.example.administrator.mypanda.ui.adapters.Itemhadapter;
import com.example.administrator.mypanda.ui.fragmens.ChildLiveFragment;
import com.example.administrator.mypanda.ui.fragmens.ChiledFragment;
import com.example.administrator.mypanda.ui.fragmens.ChinaLiveFragment;
import com.example.administrator.mypanda.ui.fragmens.CultureFragment;
import com.example.administrator.mypanda.ui.fragmens.DuoZhiBoFragment;
import com.example.administrator.mypanda.ui.fragmens.HomeFragment;
import com.example.administrator.mypanda.ui.fragmens.LiveFragment;
import com.example.administrator.mypanda.ui.fragmens.ObservationFragment;
import com.example.administrator.mypanda.ui.homepage.HomeAcitivity;
import com.example.administrator.mypanda.ui.startpage.StartPageActivity;
import com.example.administrator.mypanda.ui.startpage.WelComeActivity;

import dagger.Component;

/**
 * @author 农民伯伯
 * @version 2017/11/2
 */
@Component(modules = {Ipersenter.class})
public interface UserComponent {
    //StartPageActivity，不能写Activity，要不然会出现空指针。
    void inject(StartPageActivity activity);
    void inject(WelComeActivity activity);
    void inject(HudongActivity activity);
    void inject(HomeAcitivity activity);
    void inject(HomeFragment homeFragment);
    void inject(ItemcAdapter itemcAdapter);
    void inject(Itemhadapter itemhadapter);
    void inject(HomeRecyclerAdapter homeRecyclerAdapter);
    void inject(ObservationFragment observationFragment);
    void inject(CultureFragment cultureFragment);

    void inject(PlayAcitivity playAcitivity);

    void inject(LiveFragment liveFragment);

    void inject(ChiledFragment chiledFragment);

    void inject(DuoZhiBoFragment duoZhiBoFragment);

    void inject(ChildLiveFragment childLiveFragment);

    void inject(ChinaLiveFragment chinaLiveFragment);

}