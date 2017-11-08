package com.example.administrator.mypanda.ui;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.HudongEntity;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;
import com.example.administrator.mypanda.ui.adapters.HudongAdapter;
import com.example.administrator.mypanda.ui.base.BaseActivity;

import java.util.ArrayList;

import javax.inject.Inject;

public class HudongActivity extends BaseActivity implements Iview<HudongEntity>, View.OnClickListener, AdapterView.OnItemClickListener {

    @Inject
    Presenters presenters;
    private ImageView mHuDong_return;
    private TextView mHuDong_title;
    private ListView mHudong_listView;
    private ArrayList<HudongEntity.InteractiveBean> mList = new ArrayList<>();
    private HudongAdapter hudongAdapter;

    @Override
    public void setViewVisible() {
        setHeaderViewVisible(View.VISIBLE);
        setNotScrollViewVisible(View.VISIBLE);
        setHeaderView(R.layout.activity_hudong_header);
        setBodyView(R.layout.activity_hudong_body);
    }

    @Override
    public void init() {
        mHuDong_return = (ImageView) findViewById(R.id.mHuDong_Return);
        mHuDong_title = (TextView) findViewById(R.id.mHuDong_Title);
        mHudong_listView = (ListView) findViewById(R.id.mHudong_ListView);
        mHuDong_return.setOnClickListener(this);
        presenters.requestNews("http://www.ipanda.com/kehuduan/PAGE14501767715521482/index.json");
        hudongAdapter = new HudongAdapter(this, mList);
        mHudong_listView.setAdapter(hudongAdapter);
        mHudong_listView.setOnItemClickListener(this);
    }

    @Override
    public void setDagger() {
        DaggerUserComponent.builder().ipersenter(new Ipersenter(HudongActivity.this,HudongActivity.this)).build().inject(HudongActivity.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mHuDong_Return:
                finish();
                break;
        }
    }

    @Override
    public void success(HudongEntity hudongEntity) {
        Log.e("TAG", hudongEntity.toString());
        mList.addAll(hudongEntity.getInteractive());
        hudongAdapter.notifyDataSetChanged();
    }

    @Override
    public void failure(Throwable e) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(HudongActivity.this, WebActivity.class);
        intent.putExtra("url",mList.get(position).getUrl());
        intent.putExtra("title",mList.get(position).getTitle());
        startActivity(intent);

    }
}
