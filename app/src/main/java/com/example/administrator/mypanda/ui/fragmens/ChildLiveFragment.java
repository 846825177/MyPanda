package com.example.administrator.mypanda.ui.fragmens;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.ChildLiveEntity;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;

import javax.inject.Inject;

/**
 * @author 农民伯伯
 * @version 2017/11/17
 */

public class ChildLiveFragment extends BaseFragment implements Iview<ChildLiveEntity>, View.OnClickListener {
    @Inject
    Presenters p;

    private int i=1;

    private VideoView videoView;
    private TextView p_zhibo_text;
    private ImageView p_zhibo_image;
    private FrameLayout p_zhibo_frame;
    private TextView p_zhibo_content;
    private Button duo_zhibo;
    private Button kan_liao;
    private FragmentTransaction transaction;
    private DuoZhiBoFragment duoZhiBoFragment;
    private KanLiaoFragment kanLiaoFragment;
    private String url;

    public ChildLiveFragment(String url) {
        this.url = url;
    }

    @Override
    public void setViewVisible() {
        setNotScrollViewVisible(View.VISIBLE);
        setBodyView(R.layout.p_zhibofragment);
    }

    @Override
    public void init() {
        //videoview
        videoView = (VideoView) findViewById(R.id.p_zhibovideoview);
        //更换的text标题
        p_zhibo_text = (TextView) findViewById(R.id.p_zhibo_text);
        //上下图标的切换
        p_zhibo_image = (ImageView) findViewById(R.id.p_zhibo_image);
        //fragmeLayout 更换视图
        p_zhibo_frame = (FrameLayout) findViewById(R.id.p_zhibo_frame);
        //隐藏显示的文字内容
        p_zhibo_content = (TextView) findViewById(R.id.p_zhibo_content);
        //多视频直播
        duo_zhibo = (Button) findViewById(R.id.duo_zhibo);
        //边看边聊
        kan_liao = (Button) findViewById(R.id.kan_liao);
        p.requestNews("http://www.ipanda.com/kehuduan/PAGE14501769230331752/index.json");
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
    public void success(ChildLiveEntity childLiveEntity) {
        Log.e("BIG",childLiveEntity.toString());
        String title = childLiveEntity.getLive().get(0).getTitle();
        p_zhibo_text.setText(title);
        String brief = childLiveEntity.getLive().get(0).getBrief();
        p_zhibo_content.setText(brief);
        p_zhibo_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i%2==0){
                    p_zhibo_content.setVisibility(View.GONE);
                    p_zhibo_image.setBackgroundResource(R.mipmap.xia);
                    i++;

                }else {
                    p_zhibo_content.setVisibility(View.VISIBLE);
                    p_zhibo_image.setBackgroundResource(R.mipmap.shang);
                    i++;
                }



            }
        });




        duo_zhibo.setText(childLiveEntity.getBookmark().getMultiple().get(0).getTitle());
        kan_liao.setText(childLiveEntity.getBookmark().getWatchTalk().get(0).getTitle());
        url = childLiveEntity.getBookmark().getMultiple().get(0).getUrl();


        FragmentManager childFragmentManager = getChildFragmentManager();
        transaction = childFragmentManager.beginTransaction();
        if (duoZhiBoFragment==null){
            duoZhiBoFragment = new DuoZhiBoFragment(url);
        }
        transaction.replace(R.id.p_zhibo_frame,duoZhiBoFragment);
        transaction.commit();



        duo_zhibo.setOnClickListener(this);
        kan_liao.setOnClickListener(this);


    }

    @Override
    public void failure(Throwable e) {

    }

    @Override
    public void onClick(View v) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        transaction = childFragmentManager.beginTransaction();

        switch (v.getId()){
            case R.id.duo_zhibo:
                if (duoZhiBoFragment==null){
                    duoZhiBoFragment = new DuoZhiBoFragment(url);
                }
                transaction.replace(R.id.p_zhibo_frame,duoZhiBoFragment);

                break;

            case R.id.kan_liao:
                if (kanLiaoFragment==null){
                    kanLiaoFragment = new KanLiaoFragment();
                }
                transaction.replace(R.id.p_zhibo_frame,kanLiaoFragment);

                break;


        }
        transaction.commit();


    }
}
