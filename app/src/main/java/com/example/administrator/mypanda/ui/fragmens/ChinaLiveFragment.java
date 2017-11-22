package com.example.administrator.mypanda.ui.fragmens;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.ChinaLiveEntity;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;
import com.example.administrator.mypanda.ui.adapters.ChinaFPadapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author 农民伯伯
 * @version 2017/11/3
 */

public class ChinaLiveFragment extends BaseFragment implements Iview<ChinaLiveEntity>, View.OnClickListener {
@Inject
    Presenters p;
    private TabLayout china_tablayout;
    private ViewPager china_viewpager;
    private ArrayList<ChinaLiveEntity.TablistBean> mTabLits = new ArrayList<>();
    private ArrayList<BaseFragment> mList = new ArrayList<>();
    private ChinaFPadapter chinaFPadapter;
    private boolean flag = true;
    private ImageView mChina_add;

    @Override
    public void setViewVisible() {
        setNotScrollViewVisible(View.VISIBLE);
        setBodyView(R.layout.fragment_chinalive_body);
    }

    @Override
    public void init() {
        china_tablayout = (TabLayout) findViewById(R.id.china_tablayout);
        china_viewpager = (ViewPager) findViewById(R.id.china_viewpager);
        mChina_add = (ImageView) findViewById(R.id.mChina_add);
        mChina_add.setOnClickListener(this);
        chinaFPadapter = new ChinaFPadapter(getChildFragmentManager(),mTabLits ,mList);
        china_viewpager.setAdapter(chinaFPadapter);
        ViewCompat.setElevation(china_tablayout, 10);
        china_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        china_tablayout.setupWithViewPager(china_viewpager);
        p.requestNews("http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json");

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
    public void success(ChinaLiveEntity chinaLiveEntity) {
        if(flag) {
            List<ChinaLiveEntity.TablistBean> tablist = chinaLiveEntity.getTablist();
            mTabLits.addAll(tablist);
            for (int i = 0; i < tablist.size(); i++) {
                mList.add(ChildChinaLiveFragment.getInstance(tablist.get(i).getUrl()));
            }
            flag=false;
        }
        chinaFPadapter.notifyDataSetChanged();

    }

    @Override
    public void failure(Throwable e) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mChina_add:
                Toast.makeText(getActivity(), "添加", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
