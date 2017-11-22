package com.example.administrator.mypanda.ui.fragmens;

import android.view.View;
import android.widget.ListView;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.ChiledEntity;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;
import com.example.administrator.mypanda.ui.adapters.ChiledAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author 农民伯伯
 * @version 2017/11/17
 */

public class ChiledFragment extends BaseFragment implements Iview<ChiledEntity>{

    @Inject
    Presenters p;
    private  String url;
   private List<ChiledEntity.VideoBean> mList = new ArrayList<>();
    private ChiledAdapter adapter;

    public ChiledFragment(String url) {
        this.url = url;
    }
    public  static BaseFragment getInstance(String id){
        return new ChiledFragment(id);

    }
    @Override
    public void setViewVisible() {
        setNotScrollViewVisible(View.VISIBLE);
        setBodyView(R.layout.fragment_child);
    }

    @Override
    public void init() {
        ListView mChildListView = (ListView) findViewById(R.id.mChildListView);
        adapter = new ChiledAdapter(getActivity(),mList);
        mChildListView.setAdapter(adapter);
        p.requestNews("http://api.cntv.cn/video/videolistById?vsid="+url+"&n=7&serviceId=panda&o=desc&of=time&p=1");
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
    public void success(ChiledEntity chiledEntity) {
        mList.addAll(chiledEntity.getVideo());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void failure(Throwable e) {

    }
}
