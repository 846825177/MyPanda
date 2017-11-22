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
import com.example.administrator.mypanda.entity.ChildChinaListEntity;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * @author 农民伯伯
 * @version 2017/11/22
 */

public class ChildChinaLiveAdapter extends BaseAdapter {

    private  List<ChildChinaListEntity.LiveBean> mList;
    private  Context context;
    private int count=0;
    public ChildChinaLiveAdapter(List<ChildChinaListEntity.LiveBean> mList, Context activity) {
        this.mList = mList;
        this.context = activity;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.chinalivefragment_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(mList.get(position).getImage()).into(holder.ivv_livechina.ivThumb);
        holder.tv_title_item_livechina.setText(mList.get(position).getTitle());
        holder.iv_livechina_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = count++;
                if (sum % 2 != 1) {
                    holder.tv_content.setVisibility(View.VISIBLE);
                    holder.tv_content.setText(mList.get(position).getBrief());
                    holder.iv_livechina_show.setImageResource(R.mipmap.shang);
                } else {
                    holder.tv_content.setVisibility(View.GONE);
                    holder.iv_livechina_show.setImageResource(R.mipmap.xia);
                }

            }
        });


        return convertView;

    }
    public class ViewHolder {
        public View rootView;
        //视频播放器
        public JCVideoPlayer ivv_livechina;
        public TextView tv_title_item_livechina;
        public ImageView iv_livechina_show;
        public TextView tv_content;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.ivv_livechina = (JCVideoPlayer) rootView.findViewById(R.id.mChinaJC);
            this.tv_title_item_livechina = (TextView) rootView.findViewById(R.id.tv_title_item_livechina);
            this.iv_livechina_show = (ImageView) rootView.findViewById(R.id.iv_livechina_show);
            this.tv_content = rootView.findViewById(R.id.tv_content_livechian);
        }

    }

}
