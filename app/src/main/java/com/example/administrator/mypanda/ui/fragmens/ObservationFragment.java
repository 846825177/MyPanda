package com.example.administrator.mypanda.ui.fragmens;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.ObservationBentity;
import com.example.administrator.mypanda.entity.ObservationEntity;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;
import com.example.administrator.mypanda.ui.adapters.ObservationAdapter;

import java.util.ArrayList;

import javax.inject.Inject;


/**
 * @author 农民伯伯
 * @version 2017/11/3
 */

public class ObservationFragment extends BaseFragment implements Iview<ObservationEntity> {
    private ListView iv_watch_list;
    private ArrayList<ObservationBentity.ListBean> mList = new ArrayList<>();
    @Inject
    Presenters presenters;
    private ObservationAdapter adapter;

    @Override
    public void setViewVisible() {
        setNotScrollViewVisible(View.VISIBLE);
        setBodyView(R.layout.fragment_observation_body);
    }

    @Override
    public void init() {
        iv_watch_list = (ListView) findViewById(R.id.iv_watch_list);
        adapter = new ObservationAdapter(getActivity(), mList);
        iv_watch_list.setAdapter(adapter);
        presenters.requestNews("http://www.ipanda.com/kehuduan/PAGE14503485387528442/index.json");
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
    public void success(ObservationEntity watchBean) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_observation_listviewheader, null);
        iv_watch_list.addHeaderView(view);
        ImageView ob_title_image = view.findViewById(R.id.ob_title_image);
        TextView ob_title_text = view.findViewById(R.id.ob_title_text);
        Glide.with(getActivity()).load(watchBean.getData().getBigImg().get(0).getImage()).into(ob_title_image);
        ob_title_text.setText(watchBean.getData().getBigImg().get(0).getTitle());
        DaggerUserComponent.builder().ipersenter(new Ipersenter(getActivity(), new Iview<ObservationBentity>() {
            @Override
            public void success(ObservationBentity bentity) {
                    mList.addAll(bentity.getList());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void failure(Throwable e) {

            }
        })).build().inject(this);
        presenters.requestNews(watchBean.getData().getListurl());
    }

    @Override
    public void failure(Throwable e) {

    }
}
