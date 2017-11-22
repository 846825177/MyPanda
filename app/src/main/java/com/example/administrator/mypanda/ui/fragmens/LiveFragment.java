package com.example.administrator.mypanda.ui.fragmens;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.LiveTitle;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;
import com.example.administrator.mypanda.ui.adapters.LiveFPadapter;
import com.example.administrator.mypanda.views.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author 农民伯伯
 * @version 2017/11/3
 */

public class LiveFragment extends BaseFragment implements Iview<LiveTitle>{
    private NoScrollViewPager m_live_viewpager;
    @Inject
    Presenters p ;
    private TabLayout m_live_tablayout;

    @Override
    public void setViewVisible() {
        setNotScrollViewVisible(View.VISIBLE);
        setBodyView(R.layout.fragment_live_body);
    }

    @Override
    public void init() {
        m_live_viewpager = (NoScrollViewPager) findViewById(R.id.m_live_viewpager);
        m_live_viewpager.setNoScroll(true);
        m_live_tablayout = (TabLayout) findViewById(R.id.m_live_tablayout);
        p.requestNews("http://www.ipanda.com/kehuduan/PAGE14501772263221982/index.json");
    }

    @Override
    public void setDagger() {
        DaggerUserComponent.builder().ipersenter(new Ipersenter(getActivity(),this)).build().inject(this);
    }

    @Override
    public void showAlertDialog(String title, String message) {

    }

    @Override
    public void cancleAlertDialog() {
    }


    @Override
    public void success(LiveTitle liveTitle) {
        ArrayList<BaseFragment > mList = new ArrayList<>();
        List<LiveTitle.TablistBean> tablist = liveTitle.getTablist();
        mList.add( new ChildLiveFragment(tablist.get(0).getUrl()));
        for (int i = 0; i < tablist.size()-1; i++) {
            mList.add(ChiledFragment.getInstance(tablist.get(i+1).getId()));
        }
        LiveFPadapter liveFPadapter = new LiveFPadapter(getChildFragmentManager(), mList, tablist);
        m_live_viewpager.setAdapter(liveFPadapter);
        m_live_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        m_live_tablayout.setTabTextColors(ContextCompat.getColor(getActivity(), R.color.default_bg), ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark));
        m_live_tablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark));
        ViewCompat.setElevation(m_live_tablayout, 10);
        m_live_tablayout.setupWithViewPager(m_live_viewpager);

    }

    @Override
    public void failure(Throwable e) {

    }
}
