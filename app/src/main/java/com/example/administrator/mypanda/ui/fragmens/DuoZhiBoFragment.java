package com.example.administrator.mypanda.ui.fragmens;

import android.view.View;
import android.widget.GridView;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.DuoShiJueEntiy;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;
import com.example.administrator.mypanda.ui.adapters.DuoShiPinAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by dell on 2017/11/10.
 */
//多视觉直播
//fragmelayout切换fragment
public class DuoZhiBoFragment extends BaseFragment implements Iview<DuoShiJueEntiy> {
    @Inject
    Presenters p;
    private String url;
    private GridView gridView;

    public DuoZhiBoFragment(String url) {
        super();
        this.url = url;
    }


    private void initviews() {
        gridView = (GridView) findViewById(R.id.duoshipin_gridview);
    }

    @Override
    public void setViewVisible() {
        setNotScrollViewVisible(View.VISIBLE);
    }

    @Override
    public void init() {
        setBodyView(R.layout.duoshijuefragment);
        initviews();
        p.requestNews(url);
    }

    @Override
    public void setDagger() {
        DaggerUserComponent.builder().ipersenter(new Ipersenter(getActivity(), this)).build().inject(this);
    }

    @Override
    public void showAlertDialog(String title, String message) {

    }

    @Override
    public void cancleAlertDialog() {

    }

    @Override
    public void success(DuoShiJueEntiy duoShiJueEntiy) {
        List<DuoShiJueEntiy.ListBean> list = duoShiJueEntiy.getList();
        DuoShiPinAdapter duoShiPinAdapter = new DuoShiPinAdapter(list, getActivity());
        gridView.setAdapter(duoShiPinAdapter);
    }

    @Override
    public void failure(Throwable e) {

    }


}
