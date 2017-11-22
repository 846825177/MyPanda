package com.example.administrator.mypanda.ui.fragmens;

import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.ChildChinaListEntity;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;
import com.example.administrator.mypanda.ui.adapters.ChildChinaLiveAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author 农民伯伯
 * @version 2017/11/22
 */

public class ChildChinaLiveFragment extends BaseFragment implements Iview<ChildChinaListEntity>{
    @Inject
    Presenters p;
    private  String url;

    private List<ChildChinaListEntity.LiveBean> mList = new ArrayList<>();
    private ListView mChildChinaListView;
    private ChildChinaLiveAdapter adapter;

    public ChildChinaLiveFragment(String url) {
        this.url = url;
    }

    public static ChildChinaLiveFragment getInstance(String url){
        return new ChildChinaLiveFragment(url);
    }

    @Override
    public void setViewVisible() {
        setNotScrollViewVisible(View.VISIBLE);
        setBodyView(R.layout.fragment_childchinalivefragment);
    }

    @Override
    public void init() {
        mChildChinaListView = (ListView) findViewById(R.id.mChildChinaListView);
        adapter = new ChildChinaLiveAdapter(mList,getActivity());
        mChildChinaListView.setAdapter(adapter);
        p.requestNews(url);
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
    public void success(ChildChinaListEntity childChinaListEntity) {
        List<ChildChinaListEntity.LiveBean> live = childChinaListEntity.getLive();
        mList.addAll(live);
        adapter.notifyDataSetChanged();
        Log.e("TAG","CHILDCHINALIVEFRAGMENT:"+childChinaListEntity.toString());
    }

    @Override
    public void failure(Throwable e) {

    }
}
