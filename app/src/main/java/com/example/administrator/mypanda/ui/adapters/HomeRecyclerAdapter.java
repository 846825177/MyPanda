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
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 农民伯伯
 * @version 2017/11/7
 */

public class HomeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_A = 0;
    private static final int ITEM_B = 1;
    private static final int ITEM_C = 2;
    private static final int ITEM_D = 3;
    private static final int ITEM_E = 4;
    private static final int ITEM_F = 5;
    private static final int ITEM_G = 6;
    private static final int ITEM_H = 7;
    private static final int ITEM_I = 8;
    private static final int ITEM_COUNT = 9;

    private ArrayList<String> mType;
    private Context context;
    private HomeFragmentEntity entity;


    public HomeRecyclerAdapter(Context context, HomeFragmentEntity entity, ArrayList<String> mType) {
        this.entity = entity;
        this.context = context;
        this.mType = mType;
    }

    @Override
    public int getItemViewType(int position) {
        if (mType.get(position).equals("轮播图")) {
            return ITEM_A;
        } else if (mType.get(position).equals("精彩推荐")) {
            return ITEM_B;
        } else if (mType.get(position).equals("熊猫观察")) {
            return ITEM_C;
        } else if (mType.get(position).equals("熊猫直播")) {
            return ITEM_D;

        } else if (mType.get(position).equals("长城直播")) {
            return ITEM_E;

        } else if (mType.get(position).equals("直播中国")) {
            return ITEM_F;

        } else if (mType.get(position).equals("特别策划")) {
            return ITEM_G;

        } else if (mType.get(position).equals("央视名栏")) {
            return ITEM_H;

        } else if (mType.get(position).equals("《光影中国》")) {
            return ITEM_I;

        }
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ITEM_A:
                View viewA = LayoutInflater.from(parent.getContext()).inflate(R.layout.homerecycler_item_a, parent, false);
                ViewHolderA holderA = new ViewHolderA(viewA);
                return holderA;
            case ITEM_B:
                View viewB = LayoutInflater.from(parent.getContext()).inflate(R.layout.homerecycler_item_b, parent, false);
                ViewHolderB holderB = new ViewHolderB(viewB);
                return holderB;
            case ITEM_C:
                View viewC = LayoutInflater.from(parent.getContext()).inflate(R.layout.homerecycler_item_c, parent, false);
                ViewHolderC holderC = new ViewHolderC(viewC);
                return holderC;
            case ITEM_D:
                View viewD = LayoutInflater.from(parent.getContext()).inflate(R.layout.homerecycler_item_d, parent, false);
                ViewHolderD holderD = new ViewHolderD(viewD);
                return holderD;
            case ITEM_E:
                View viewE = LayoutInflater.from(parent.getContext()).inflate(R.layout.homerecycler_item_e, parent, false);
                ViewHolderE holderE = new ViewHolderE(viewE);
                return holderE;
            case ITEM_F:
                View viewF = LayoutInflater.from(parent.getContext()).inflate(R.layout.homerecycler_item_f, parent, false);
                ViewHolderF holderF = new ViewHolderF(viewF);
                return holderF;
            case ITEM_G:
                View viewG = LayoutInflater.from(parent.getContext()).inflate(R.layout.homerecycler_item_g, parent, false);
                ViewHolderG holderG = new ViewHolderG(viewG);
                return holderG;
            case ITEM_H:
                View viewH = LayoutInflater.from(parent.getContext()).inflate(R.layout.homerecycler_item_h, parent, false);
                ViewHolderH holderH = new ViewHolderH(viewH);
                return holderH;
            case ITEM_I:
                View viewI = LayoutInflater.from(parent.getContext()).inflate(R.layout.homerecycler_item_i, parent, false);
                ViewHolderI holderI = new ViewHolderI(viewI);
                return holderI;

        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case ITEM_A:
                ViewHolderA holder1 = (ViewHolderA) holder;
                List<HomeFragmentEntity.DataBean.BigImgBean> bigImg = entity.getData().getBigImg();
                ArrayList<String> datas = new ArrayList<>();
                for (int i = 0; i < bigImg.size(); i++) {
                    datas.add(bigImg.get(i).getImage());
                }
                holder1.mXBanner.setData(datas);
                break;
            case ITEM_B:
                ViewHolderB holder2 = (ViewHolderB) holder;
                holder2.area_title.setText(entity.getData().getArea().getTitle());
                Glide.with(context).load(entity.getData().getArea().getImage()).into(holder2.area_iamge);
                //TODO 瀑布流
                break;
            case ITEM_C:
                ViewHolderC holder3 = (ViewHolderC) holder;
                Glide.with(context).load(entity.getData().getPandaeye().getPandaeyelogo()).into(holder3.c_image_left);
                break;
            case ITEM_D:
                break;
            case ITEM_E:
                break;
            case ITEM_F:
                break;
            case ITEM_G:
                break;
            case ITEM_H:
                break;
            case ITEM_I:
                break;


        }

    }

    @Override
    public int getItemCount() {
        return mType.size();
    }

    public class ViewHolderA extends RecyclerView.ViewHolder {
        public View rootView;
        public XBanner mXBanner;

        public ViewHolderA(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mXBanner = (XBanner) rootView.findViewById(R.id.mXBanner);
        }
    }

    public class ViewHolderB extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView area_iamge;
        public TextView area_title;
        public RecyclerView area_recycler;

        public ViewHolderB(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.area_iamge = (ImageView) rootView.findViewById(R.id.area_iamge);
            this.area_title = (TextView) rootView.findViewById(R.id.area_title);
            this.area_recycler = (RecyclerView) rootView.findViewById(R.id.area_recycler);
        }
    }

    public class ViewHolderC extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView c_title;
        public ImageView c_image_left;
        public TextView c_brief_top;
        public TextView c_title_top;
        public TextView c_brief_btm;
        public TextView c_title_btm;
        public LinearLayout c_ListView;

        public ViewHolderC(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.c_title = (TextView) rootView.findViewById(R.id.c_title);
            this.c_image_left = (ImageView) rootView.findViewById(R.id.c_image_left);
            this.c_brief_top = (TextView) rootView.findViewById(R.id.c_brief_top);
            this.c_title_top = (TextView) rootView.findViewById(R.id.c_title_top);
            this.c_brief_btm = (TextView) rootView.findViewById(R.id.c_brief_btm);
            this.c_title_btm = (TextView) rootView.findViewById(R.id.c_title_btm);
            this.c_ListView = (LinearLayout) rootView.findViewById(R.id.c_ListView);
        }
    }

    public class ViewHolderD extends RecyclerView.ViewHolder {
        public ViewHolderD(View itemView) {
            super(itemView);
        }
    }

    public class ViewHolderE extends RecyclerView.ViewHolder {
        public ViewHolderE(View itemView) {
            super(itemView);
        }
    }

    public class ViewHolderF extends RecyclerView.ViewHolder {
        public ViewHolderF(View itemView) {
            super(itemView);
        }
    }

    public class ViewHolderG extends RecyclerView.ViewHolder {
        public ViewHolderG(View itemView) {
            super(itemView);
        }
    }

    public class ViewHolderH extends RecyclerView.ViewHolder {
        public ViewHolderH(View itemView) {
            super(itemView);
        }
    }

    public class ViewHolderI extends RecyclerView.ViewHolder {
        public ViewHolderI(View itemView) {
            super(itemView);
        }
    }


}
