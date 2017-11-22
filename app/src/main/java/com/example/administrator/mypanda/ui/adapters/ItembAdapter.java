package com.example.administrator.mypanda.ui.adapters;

import android.content.Context;
import android.content.Intent;
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
import com.example.administrator.mypanda.ui.PlayAcitivity;

import java.util.List;

/**
 * @author 农民伯伯
 * @version 2017/11/8
 */

public class ItembAdapter extends RecyclerView.Adapter<ItembAdapter.ViewHolder> {

    private final Context context;
    private final List<HomeFragmentEntity.DataBean.AreaBean.ListscrollBean> mList;

    public ItembAdapter(Context context, List<HomeFragmentEntity.DataBean.AreaBean.ListscrollBean> listscroll) {
        this.context = context;
        this.mList = listscroll;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.itemb_item, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(Tools.queryWidth(context)/2, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(5,5,5,5);
        holder.mItemb_item_content.setLayoutParams(params);
        holder.mItemb_item_title.setLayoutParams(params);
        holder.mItemb_item_title.setText(mList.get(position).getTitle());
        Glide.with(context).load(mList.get(position).getImage()).into(holder.mItemb_item_content);
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayAcitivity.class);
                if(!mList.get(position).getPid().equals("")){
                    intent.putExtra("pid",mList.get(position).getPid());
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View rootView;
        public ImageView mItemb_item_content;
        public TextView mItemb_item_title;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mItemb_item_content = (ImageView) rootView.findViewById(R.id.mItemb_item_content);
            this.mItemb_item_title = (TextView) rootView.findViewById(R.id.mItemb_item_title);
        }
    }


}
