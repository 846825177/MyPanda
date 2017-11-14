package com.example.administrator.mypanda.ui.fragmens;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.HomeFragmentEntity;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;
import com.example.administrator.mypanda.tools.SpacesItemDecoration;
import com.example.administrator.mypanda.ui.adapters.HomeRecyclerAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * @author 农民伯伯
 * @version 2017/11/3
 */

public class HomeFragment extends BaseFragment implements Iview<HomeFragmentEntity>{
    @Inject
    Presenters presenters;
    private XRecyclerView mXrecyclerview;
    private ArrayList<String> mType = new ArrayList<>();
    private HomeRecyclerAdapter homeRecyclerAdapter;
    private View inflate;

    @Override
    public void setViewVisible() {
        setNotScrollViewVisible(View.VISIBLE);
        setBodyView(R.layout.fragment_home_body);
    }

    @Override
    public void init() {
        mXrecyclerview = (XRecyclerView) findViewById(R.id.mXrecyclerview);
        mXrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        mXrecyclerview.addItemDecoration(new SpacesItemDecoration(10));
        inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_recyclerview_header, null);
        presenters.requestNews("http://www.ipanda.com/kehuduan/PAGE14501749764071042/index.json");

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
    public void success(HomeFragmentEntity homeFragmentEntity) {
        //精彩推荐
        String title1 = homeFragmentEntity.getData().getArea().getTitle();
        //央视名栏
        String title2 = homeFragmentEntity.getData().getCctv().getTitle();
        //直播中国
        String title3 = homeFragmentEntity.getData().getChinalive().getTitle();
        //特别策划
        String title4 = homeFragmentEntity.getData().getInteractive().getTitle();
        //光影中国
        String title41 = homeFragmentEntity.getData().getList().get(0).getTitle();
        //熊猫观察
        String title5 = homeFragmentEntity.getData().getPandaeye().getTitle();
        //熊猫直播
        String title6 = homeFragmentEntity.getData().getPandalive().getTitle();
        //长城直播
        String title7 = homeFragmentEntity.getData().getWalllive().getTitle();
        mType.add("轮播图");
        mType.add("精彩推荐");
        mType.add("熊猫观察");
        mType.add("熊猫直播");
        mType.add("长城直播");
        mType.add("直播中国");
        mType.add("特别策划");
        mType.add("央视名栏");
        mType.add("光影中国");
        Log.e("TAG",mType.toString());
        homeRecyclerAdapter = new HomeRecyclerAdapter(getActivity(),homeFragmentEntity,mType);
        mXrecyclerview.setAdapter(homeRecyclerAdapter);
    }

    @Override
    public void failure(Throwable e) {

    }
}
