package com.example.administrator.mypanda.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.ItemIentity;

import java.util.List;

/**
 * @author 农民伯伯
 * @version 2017/11/9
 */


public class ItemIadapter extends RecyclerView.Adapter<ItemIadapter.ViewHolder> {

    private Context context;
    private String url;
    private List<ItemIentity.ListBean> mList;

    public ItemIadapter(Context context, List<ItemIentity.ListBean> list) {
        this.context = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemh_item, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(mList.get(position).getImage()).into(holder.itemc_item_leftimg_b);
        holder.itemc_item_time_b.setText(mList.get(position).getVideoLength());
        holder.itemc_item_title_b.setText(mList.get(position).getTitle());
        holder.itemc_item_data_b.setText(mList.get(position).getDaytime());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView itemc_item_leftimg_b;
        public TextView itemc_item_time_b;
        public TextView itemc_item_title_b;
        public TextView itemc_item_data_b;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.itemc_item_leftimg_b = (ImageView) rootView.findViewById(R.id.itemc_item_leftimg_b);
            this.itemc_item_time_b = (TextView) rootView.findViewById(R.id.itemc_item_time_b);
            this.itemc_item_title_b = (TextView) rootView.findViewById(R.id.itemc_item_title_b);
            this.itemc_item_data_b = (TextView) rootView.findViewById(R.id.itemc_item_data_b);
        }

    }
}
