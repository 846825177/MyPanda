package com.example.administrator.mypanda.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.HudongEntity;

import java.util.ArrayList;

/**
 * @author 农民伯伯
 * @version 2017/11/5
 */

public class HudongAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<HudongEntity.InteractiveBean> mList;

    public HudongAdapter(Context context, ArrayList<HudongEntity.InteractiveBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.hudong_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.mHudong_item_title.setText(mList.get(position).getTitle());
        Glide.with(context).load(mList.get(position).getImage()).placeholder(R.mipmap._no_img).into(holder.mHudong_item_image);
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView mHudong_item_title;
        public ImageView mHudong_item_image;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.mHudong_item_title = (TextView) rootView.findViewById(R.id.mHudong_item_title);
            this.mHudong_item_image = (ImageView) rootView.findViewById(R.id.mHudong_item_image);
        }

    }
}
