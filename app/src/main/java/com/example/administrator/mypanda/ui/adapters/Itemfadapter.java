package com.example.administrator.mypanda.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.HomeFragmentEntity;
import com.example.administrator.mypanda.tools.Tools;

import java.util.List;

/**
 * @author 农民伯伯
 * @version 2017/11/9
 */

public class Itemfadapter extends RecyclerView.Adapter<Itemfadapter.ViewHolder> {

    private final Context context;
    private final List<HomeFragmentEntity.DataBean.ChinaliveBean.ListBeanXX> list;

    public Itemfadapter(Context context, List<HomeFragmentEntity.DataBean.ChinaliveBean.ListBeanXX> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemf_item, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewGroup.LayoutParams params = new LinearLayout.LayoutParams(Tools.queryWidth(context)/3,200);
        holder.itemf_item_iamge.setLayoutParams(params);
        Glide.with(context).load(list.get(position).getImage()).into(holder.itemf_item_iamge);
        holder.itemf_item_title.setText(list.get(position).getTitle());
        }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView itemf_item_title;
        private  ImageView itemf_item_iamge;

        public ViewHolder(View itemView) {
            super(itemView);
            itemf_item_iamge = itemView.findViewById(R.id.itemf_item_iamge);
            itemf_item_title = itemView.findViewById(R.id.itemf_item_title);
        }
    }
}
