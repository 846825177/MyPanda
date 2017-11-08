package com.example.administrator.mypanda.ui.startpage;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.concat.Concat;
import com.example.administrator.mypanda.entity.TestEntity;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;
import com.example.administrator.mypanda.ui.adapters.StartVpAdapter;
import com.example.administrator.mypanda.ui.base.BaseActivity;
import com.example.administrator.mypanda.ui.homepage.HomeAcitivity;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * @author 农民伯伯
 * @version 2017/11/2
 */

public class WelComeActivity extends BaseActivity implements Iview<TestEntity>, View.OnClickListener {

    @Inject
    Presenters presenters;
    private ViewPager mStartViewPager;
    private Button mJump;
    private ArrayList<ImageView> mlist = new ArrayList<>();
    private ArrayList<ImageView> mlist1 = new ArrayList<>();
    private LinearLayout mLinear;

    @Override
    public void setViewVisible() {
        setNotScrollViewVisible(View.VISIBLE);
        setBodyView(R.layout.activity_welcome);
        mStartViewPager = (ViewPager) findViewById(R.id.mStartViewPager);
        mJump = (Button) findViewById(R.id.mJump);
        mJump.setOnClickListener(this);
        mLinear = (LinearLayout) findViewById(R.id.mLinear);
    }

    @Override
    public void init() {
        presenters.requestNews(Concat.BASE_URL + Concat.TAB_URL);
        ImageView imageView1 = new ImageView(this);
        ImageView imageView2 = new ImageView(this);
        ImageView imageView3 = new ImageView(this);
        imageView1.setBackgroundResource(R.mipmap.guide_one);
        imageView2.setBackgroundResource(R.mipmap.guide_two);
        imageView3.setBackgroundResource(R.mipmap.guide_three);
        mlist.add(imageView1);
        mlist.add(imageView2);
        mlist.add(imageView3);
        StartVpAdapter adapter = new StartVpAdapter(mlist);
        mStartViewPager.setAdapter(adapter);
        for (int i = 0; i < mlist.size(); i++) {
            ImageView imageView = new ImageView(WelComeActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            imageView.setLayoutParams(params);
            params.setMargins(5, 5, 5, 15);
            if (i == 0) {
                imageView.setBackgroundResource(R.drawable.startpage_image_ok);
            } else {
                imageView.setBackgroundResource(R.drawable.startpage_image_not);
            }
            mlist1.add(imageView);
            mLinear.addView(imageView);
        }
        mStartViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < mlist.size(); i++) {
                    if (i == position) {
                        mlist1.get(i).setBackgroundResource(R.drawable.startpage_image_ok);
                    } else {
                        mlist1.get(i).setBackgroundResource(R.drawable.startpage_image_not);
                    }
                }
                if (position == mlist.size() - 1) {
                    mJump.setVisibility(View.VISIBLE);
                    mLinear.setVisibility(View.GONE);
                } else {
                    mJump.setVisibility(View.GONE);
                    mLinear.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public void setDagger() {
        DaggerUserComponent.builder().ipersenter(new Ipersenter(this,this)).build().inject(this);
    }


    @Override
    public void success(TestEntity testEntity) {
        Log.e("TAG", "WelComeActivity:" + testEntity.toString());
    }

    @Override
    public void failure(Throwable e) {

    }

    @Override
    public void onClick(View v) {
        getSharedPreferences("publicfile", this.MODE_PRIVATE)
                .edit()
                .putString("version", "1.1")
                .commit();
        startActivity(new Intent(this, HomeAcitivity.class));
        finish();
    }
}
