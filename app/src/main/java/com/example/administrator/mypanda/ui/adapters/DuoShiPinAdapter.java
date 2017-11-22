package com.example.administrator.mypanda.ui.adapters;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.DuoShiJueEntiy;

import java.util.List;

/**
 * Created by dell on 2017/11/10.
 */

public class DuoShiPinAdapter extends BaseAdapter {

    private  List<DuoShiJueEntiy.ListBean> list;
    private  FragmentActivity activity;

    public DuoShiPinAdapter(List<DuoShiJueEntiy.ListBean> list, FragmentActivity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(activity).inflate(R.layout.duoshipinitem, null);
            holder.imageView = convertView.findViewById(R.id.it_duo_iamge);
            holder.textView=convertView.findViewById(R.id.it_duo_text);
            convertView.setTag(holder);


        }else {
            holder = (ViewHolder) convertView.getTag();

        }
        Glide.with(activity).load(list.get(position).getImage()).into(holder.imageView);
        holder.textView.setText(list.get(position).getTitle());



        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;





    }


}
