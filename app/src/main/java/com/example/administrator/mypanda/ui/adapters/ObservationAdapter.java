package com.example.administrator.mypanda.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.ObservationBentity;

import java.util.List;

/**
 *@author 农民伯伯
        * @version 2017/11/3
        */
public class ObservationAdapter extends BaseAdapter {
    Context context;

    private List<ObservationBentity.ListBean> list;

    private ViewHolder holder;

    public ObservationAdapter(Context context, List<ObservationBentity.ListBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {

        return list.size();

    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {

            view = View.inflate(context, R.layout.item_watch, null);
            holder = new ViewHolder(view);
            view.setTag(holder);

        } else {

            holder = (ViewHolder) view.getTag();

        }

        Glide.with(context).load(list.get(i).getPicurl()).into(holder.iv_watch_img);
        holder.tv_watch_title.setText(list.get(i).getTitle());
        holder.tv_watch_cont.setText("2017-11-05 09:40");
        holder.play_time_on.setText(list.get(i).getVideolength());


        return view;
    }

    class ViewHolder {
        public View rootView;
        public ImageView iv_watch_img;
        public TextView tv_watch_title;
        public TextView tv_watch_cont;
        public TextView play_time_on;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_watch_img = (ImageView) rootView.findViewById(R.id.iv_watch_img);
            this.tv_watch_title = (TextView) rootView.findViewById(R.id.tv_watch_title);
            this.tv_watch_cont = (TextView) rootView.findViewById(R.id.tv_watch_cont);
            this.play_time_on = (TextView) rootView.findViewById(R.id.play_time_on);
        }

    }
}
