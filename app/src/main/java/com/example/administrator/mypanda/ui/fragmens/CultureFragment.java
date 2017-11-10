package com.example.administrator.mypanda.ui.fragmens;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.ClultureEntity;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;
import com.example.administrator.mypanda.tools.GlideImageLoader;
import com.example.administrator.mypanda.ui.adapters.CultureAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author 农民伯伯
 * @version 2017/11/3
 *
 * 熊猫文化
 */

public class CultureFragment extends BaseFragment implements Iview<ClultureEntity>{

    @Inject
    Presenters presenters;
    private ListView mculture_listview;
    private ArrayList<ClultureEntity.ListBean> mList =  new ArrayList<>() ;
    private View view;
    private CultureAdapter adapter;
    private Banner viewmCulture_headerById;

    @Override
    public void setViewVisible() {
        setNotScrollViewVisible(View.VISIBLE);
        setBodyView(R.layout.fragment_culture_body);
    }

    @Override
    public void init() {
        mculture_listview = (ListView) findViewById(R.id.mculture_listview);
        adapter = new CultureAdapter(getActivity(), mList);
        mculture_listview.setAdapter(adapter);
        presenters.requestNews("http://www.ipanda.com/kehuduan/xmwh/index.json");
        view = LayoutInflater.from(getActivity()).inflate(R.layout.culture_header,null);
        viewmCulture_headerById = view.findViewById(R.id.mCulture_header);
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
    public void success(ClultureEntity clultureEntity) {
        mList.addAll(clultureEntity.getList());
        List<ClultureEntity.BigImgBean> bigImg = clultureEntity.getBigImg();
        ArrayList<String> datas = new ArrayList<>();
        ArrayList<String> title = new ArrayList<>();
        for (int i = 0; i < bigImg.size(); i++) {
        datas.add(bigImg.get(i).getImage());
            title.add(bigImg.get(i).getTitle());
        }

       viewmCulture_headerById.setImages(datas);
       viewmCulture_headerById.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
       viewmCulture_headerById.setImageLoader(new GlideImageLoader());
       viewmCulture_headerById.setBannerTitles(title);
       viewmCulture_headerById.setIndicatorGravity(BannerConfig.RIGHT);
       viewmCulture_headerById.start();
        mculture_listview.addHeaderView(view);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void failure(Throwable e) {

    }
}
