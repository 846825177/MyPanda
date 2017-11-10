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
import com.example.administrator.mypanda.entity.ItemHentity;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;
import com.example.administrator.mypanda.tools.Tools;

import java.util.List;

import javax.inject.Inject;

/**
 * @author 农民伯伯
 * @version 2017/11/9
 */





    public  class Itemhadapter  extends RecyclerView.Adapter<Itemhadapter.ViewHolder> {
    @Inject
    Presenters presenters;
    private Context context;
    private String url;
    private List<ItemHentity.ListBean> mList ;

    public Itemhadapter(Context context, List<ItemHentity.ListBean> list) {
        this.context = context;
        this.mList = list;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemf_item, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DaggerUserComponent.builder().ipersenter(new Ipersenter(context, new Iview<ItemHentity>() {
            @Override
            public void success(ItemHentity o) {
                mList.addAll(o.getList());
                notifyDataSetChanged();
            }

            @Override
            public void failure(Throwable e) {

            }
        })).build().inject(this);
        ViewGroup.LayoutParams params = new LinearLayout.LayoutParams(Tools.queryWidth(context)/2, 200);
        holder.itemf_item_iamge.setLayoutParams(params);
        Glide.with(context).load(mList.get(position).getImage()).into(holder.itemf_item_iamge);
        holder.itemf_item_title.setText(mList.get(position).getTitle());

    }
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView itemf_item_title;
        private ImageView itemf_item_iamge;

        public ViewHolder(View itemView) {
            super(itemView);
            itemf_item_iamge = itemView.findViewById(R.id.itemf_item_iamge);

            itemf_item_title = itemView.findViewById(R.id.itemf_item_title);
        }

    }
}
