package com.example.administrator.mypanda.ui.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.ItemcEntity;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * @author 农民伯伯
 * @version 2017/11/8
 */

public class ItemcAdapter extends BaseAdapter implements Iview<ItemcEntity> {

    @Inject
    Presenters presenters;
    private  Context context;
    private  String list;
    private ArrayList<ItemcEntity.ListBean> mList = new ArrayList<>();
    public ItemcAdapter(Context context, String list) {
        DaggerUserComponent.builder().ipersenter(new Ipersenter(context,this)).build().inject(this);
        presenters .requestNews(list);
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return mList.size()/2;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.itemc_item,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.mTopclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, mList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.mbtmclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, mList.get(position+1).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        Glide.with(context).load(mList.get(position).getImage()).into(holder.itemc_item_leftimg);
        holder.itemc_item_time.setText(mList.get(position).getVideoLength());
        holder.itemc_item_title.setText(mList.get(position).getTitle());
        holder.itemc_item_data.setText(mList.get(position).getDaytime());
        Glide.with(context).load(mList.get(position+1).getImage()).into(holder.itemc_item_leftimg_b);
        holder.itemc_item_time_b.setText(mList.get(position+1).getVideoLength());
        holder.itemc_item_title_b.setText(mList.get(position+1).getTitle());
        holder.itemc_item_data_b.setText(mList.get(position+1).getDaytime());
        return convertView;
    }

    @Override
    public void success(ItemcEntity itemcEntity) {
        mList.addAll(itemcEntity.getList());
        this.notifyDataSetChanged();
    }

    @Override
    public void failure(Throwable e) {
        Log.e("TAG",e.toString());
    }
    public class ViewHolder{

        private  ImageView itemc_item_leftimg;
        private TextView itemc_item_time;
        private TextView itemc_item_title;
        private TextView itemc_item_data;
        private  ImageView itemc_item_leftimg_b;
        private  TextView itemc_item_time_b;
        private  TextView itemc_item_title_b;
        private  TextView itemc_item_data_b;
        private  LinearLayout mbtmclick;
        private  LinearLayout mTopclick;

        public ViewHolder(View v) {
            itemc_item_leftimg = v.findViewById(R.id.itemc_item_leftimg);
            itemc_item_time = v.findViewById(R.id.itemc_item_time);
            itemc_item_title = v.findViewById(R.id.itemc_item_title);
            itemc_item_data = v.findViewById(R.id.itemc_item_data);
            itemc_item_leftimg_b = v.findViewById(R.id.itemc_item_leftimg_b);
            itemc_item_time_b = v.findViewById(R.id.itemc_item_time_b);
            itemc_item_title_b = v.findViewById(R.id.itemc_item_title_b);
            itemc_item_data_b = v.findViewById(R.id.itemc_item_data_b);
            mTopclick = v.findViewById(R.id.mTopclick);
            mbtmclick = v.findViewById(R.id.mbtmclick);

        }
    }
}
