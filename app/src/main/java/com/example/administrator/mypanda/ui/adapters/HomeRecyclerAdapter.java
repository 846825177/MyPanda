package com.example.administrator.mypanda.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.entity.HomeFragmentEntity;
import com.example.administrator.mypanda.entity.ItemHentity;
import com.example.administrator.mypanda.entity.ItemIentity;
import com.example.administrator.mypanda.mvp.DaggerUserComponent;
import com.example.administrator.mypanda.mvp.Ipersenter;
import com.example.administrator.mypanda.mvp.Iview;
import com.example.administrator.mypanda.mvp.Presenters;
import com.example.administrator.mypanda.tools.GlideImageLoader;
import com.example.administrator.mypanda.tools.Tools;
import com.example.administrator.mypanda.ui.PlayAcitivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author 农民伯伯
 * @version 2017/11/7
 */

public class HomeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Inject
    Presenters presenters;
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
    private ItembAdapter itembAdapter;


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
        return ITEM_I;
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
                View viewE = LayoutInflater.from(parent.getContext()).inflate(R.layout.homerecycler_item_d, parent, false);
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
                View viewH = LayoutInflater.from(parent.getContext()).inflate(R.layout.homerecycler_item_f, parent, false);
                ViewHolderH holderH = new ViewHolderH(viewH);
                return holderH;
            case ITEM_I:
                View viewI = LayoutInflater.from(parent.getContext()).inflate(R.layout.homerecycler_item_f, parent, false);
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
                final List<HomeFragmentEntity.DataBean.BigImgBean> bigImg = entity.getData().getBigImg();
                ArrayList<String> datas = new ArrayList<>();
                ArrayList<String> titles = new ArrayList<>();
                for (int i = 0; i < bigImg.size(); i++) {
                    datas.add(bigImg.get(i).getImage());
                    titles.add(bigImg.get(i).getTitle());
                }
                holder1.mXBanner.setImages(datas);
                holder1.mXBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                holder1.mXBanner.setImageLoader(new GlideImageLoader());
                holder1.mXBanner.setBannerTitles(titles);
                holder1.mXBanner.setIndicatorGravity(BannerConfig.RIGHT);
                holder1.mXBanner.start();
                holder1.mXBanner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                       if(!bigImg.get(position).getPid().equals("")){
                           Intent intent = new Intent(context, PlayAcitivity.class);
                           intent.putExtra("pid",bigImg.get(position).getPid());
                           context.startActivity(intent);
                       }
                    }
                });
                break;
            case ITEM_B:
                ViewHolderB holder2 = (ViewHolderB) holder;
                holder2.area_title.setText(entity.getData().getArea().getTitle());
                Glide.with(context).load(entity.getData().getArea().getImage()).into(holder2.area_iamge);
                //TODO 瀑布流
                holder2.area_recycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                if (itembAdapter == null) {
                    itembAdapter = new ItembAdapter(context, entity.getData().getArea().getListscroll());
                    holder2.area_recycler.setAdapter(itembAdapter);
                } else {
                    itembAdapter.notifyDataSetChanged();
                }
                break;
            case ITEM_C:
                ViewHolderC holder3 = (ViewHolderC) holder;
                Glide.with(context).load(entity.getData().getPandaeye().getPandaeyelogo()).into(holder3.c_image_left);
                holder3.c_title.setText(entity.getData().getPandaeye().getTitle());
                holder3.c_brief_top.setText(entity.getData().getPandaeye().getItems().get(0).getBrief());
                holder3.c_title_top.setText(entity.getData().getPandaeye().getItems().get(0).getTitle());
                holder3.c_title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Tools.jump(context,entity.getData().getPandaeye().getItems().get(0).getPid(),entity.getData().getPandaeye().getItems().get(0).getUrl());
                    }
                });
                holder3.c_brief_btm.setText(entity.getData().getPandaeye().getItems().get(1).getBrief());
                holder3.c_title_btm.setText(entity.getData().getPandaeye().getItems().get(1).getTitle());
                String pandaeyelist = entity.getData().getPandaeye().getPandaeyelist();
                ItemcAdapter itemcAdapter = new ItemcAdapter(context, pandaeyelist);
                holder3.c_ListView.setAdapter(itemcAdapter);
                break;
            case ITEM_D:
                ViewHolderD holder4 = (ViewHolderD) holder;
                holder4.itemd_title.setText(entity.getData().getPandalive().getTitle());
                holder4.itemd_content_a.setText(entity.getData().getPandalive().getList().get(0).getTitle());
                holder4.itemd_content_b.setText(entity.getData().getPandalive().getList().get(1).getTitle());
                holder4.itemd_contnet_c.setText(entity.getData().getPandalive().getList().get(2).getTitle());
                holder4.itemd_content_d.setText(entity.getData().getPandalive().getList().get(3).getTitle());
                holder4.itemd_content_e.setText(entity.getData().getPandalive().getList().get(4).getTitle());
                holder4.itemd_content_f.setText(entity.getData().getPandalive().getList().get(5).getTitle());
                Glide.with(context).load(entity.getData().getPandalive().getList().get(0).getImage()).into(holder4.itemd_image_a);
                Glide.with(context).load(entity.getData().getPandalive().getList().get(1).getImage()).into(holder4.itemd_image_b);
                Glide.with(context).load(entity.getData().getPandalive().getList().get(2).getImage()).into(holder4.itemd_image_c);
                Glide.with(context).load(entity.getData().getPandalive().getList().get(3).getImage()).into(holder4.itemd_image_d);
                Glide.with(context).load(entity.getData().getPandalive().getList().get(4).getImage()).into(holder4.itemd_image_e);
                Glide.with(context).load(entity.getData().getPandalive().getList().get(5).getImage()).into(holder4.itemd_image_f);
                break;
            case ITEM_E:
                ViewHolderE holder5 = (ViewHolderE) holder;
                holder5.itemd_title.setText(entity.getData().getPandalive().getTitle());
                holder5.itemd_content_a.setText(entity.getData().getWalllive().getList().get(0).getTitle());
                holder5.itemd_content_b.setText(entity.getData().getWalllive().getList().get(1).getTitle());
                holder5.itemd_contnet_c.setText(entity.getData().getWalllive().getList().get(2).getTitle());
                holder5.itemd_content_d.setText(entity.getData().getWalllive().getList().get(3).getTitle());
                holder5.itemd_content_e.setText(entity.getData().getWalllive().getList().get(4).getTitle());
                holder5.itemd_content_f.setText(entity.getData().getWalllive().getList().get(5).getTitle());
                Glide.with(context).load(entity.getData().getWalllive().getList().get(0).getImage()).into(holder5.itemd_image_a);
                Glide.with(context).load(entity.getData().getWalllive().getList().get(1).getImage()).into(holder5.itemd_image_b);
                Glide.with(context).load(entity.getData().getWalllive().getList().get(2).getImage()).into(holder5.itemd_image_c);
                Glide.with(context).load(entity.getData().getWalllive().getList().get(3).getImage()).into(holder5.itemd_image_d);
                Glide.with(context).load(entity.getData().getWalllive().getList().get(4).getImage()).into(holder5.itemd_image_e);
                Glide.with(context).load(entity.getData().getWalllive().getList().get(5).getImage()).into(holder5.itemd_image_f);
                break;
            case ITEM_F:
                ViewHolderF holder6 = (ViewHolderF) holder;
                holder6.itemf_title.setText(entity.getData().getChinalive().getTitle());
                Itemfadapter itemfadapter = new Itemfadapter(context,entity.getData().getChinalive().getList());
                holder6.itemf_recycler.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
                holder6.itemf_recycler.setAdapter(itemfadapter);
                break;
            case ITEM_G:
                ViewHolderG holderG = (ViewHolderG)holder;
                Glide.with(context).load(entity.getData().getInteractive().getInteractiveone().get(0).getImage()).into(holderG.itemg_content);
                holderG.itemg_title.setText(entity.getData().getInteractive().getTitle());
                break;
            case ITEM_H:
                final ViewHolderH holderH = (ViewHolderH)holder;
                holderH.itemf_title.setText(entity.getData().getCctv().getTitle());
                DaggerUserComponent.builder().ipersenter(new Ipersenter(context, new Iview<ItemHentity>() {
                    @Override
                    public void success(ItemHentity o) {
                        holderH.itemf_recycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                        Itemhadapter itemhadapter = new Itemhadapter(context,o.getList() );
                        holderH.itemf_recycler.setAdapter(itemhadapter);
                    }

                    @Override
                    public void failure(Throwable e) {

                    }
                })).build().inject(this);
                presenters.requestNews(entity.getData().getCctv().getListurl());
                break;
            case ITEM_I:
                final ViewHolderI holderI = (ViewHolderI)holder;
                holderI.itemf_title.setText(entity.getData().getList().get(0).getTitle());
                DaggerUserComponent.builder().ipersenter(new Ipersenter(context, new Iview<ItemIentity>() {
                    @Override
                    public void success(ItemIentity o) {
                        holderI.itemf_recycler.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
                        ItemIadapter itemhadapter = new ItemIadapter(context,o.getList());
                        holderI.itemf_recycler.setAdapter(itemhadapter);
                    }

                    @Override
                    public void failure(Throwable e) {

                    }
                })).build().inject(this);
                presenters.requestNews(entity.getData().getList().get(0).getListUrl());


                break;


        }

    }

    @Override
    public int getItemCount() {
        return mType.size();
    }

    public class ViewHolderA extends RecyclerView.ViewHolder {
        public View rootView;
        public Banner mXBanner;

        public ViewHolderA(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mXBanner = (Banner) rootView.findViewById(R.id.mXBanner);
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
        public ListView c_ListView;

        public ViewHolderC(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.c_title = (TextView) rootView.findViewById(R.id.c_title);
            this.c_image_left = (ImageView) rootView.findViewById(R.id.c_image_left);
            this.c_brief_top = (TextView) rootView.findViewById(R.id.c_brief_top);
            this.c_title_top = (TextView) rootView.findViewById(R.id.c_title_top);
            this.c_brief_btm = (TextView) rootView.findViewById(R.id.c_brief_btm);
            this.c_title_btm = (TextView) rootView.findViewById(R.id.c_title_btm);
            this.c_ListView = (ListView) rootView.findViewById(R.id.c_ListView);

        }
    }

    public class ViewHolderD extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView itemd_title;
        public ImageView itemd_image_a;
        public TextView itemd_content_a;
        public ImageView itemd_image_b;
        public TextView itemd_content_b;
        public ImageView itemd_image_c;
        public TextView itemd_contnet_c;
        public ImageView itemd_image_d;
        public TextView itemd_content_d;
        public ImageView itemd_image_e;
        public TextView itemd_content_e;
        public ImageView itemd_image_f;
        public TextView itemd_content_f;

        public ViewHolderD(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.itemd_title = (TextView) rootView.findViewById(R.id.itemd_title);
            this.itemd_image_a = (ImageView) rootView.findViewById(R.id.itemd_image_a);
            this.itemd_content_a = (TextView) rootView.findViewById(R.id.itemd_content_a);
            this.itemd_image_b = (ImageView) rootView.findViewById(R.id.itemd_image_b);
            this.itemd_content_b = (TextView) rootView.findViewById(R.id.itemd_content_b);
            this.itemd_image_c = (ImageView) rootView.findViewById(R.id.itemd_image_c);
            this.itemd_contnet_c = (TextView) rootView.findViewById(R.id.itemd_contnet_c);
            this.itemd_image_d = (ImageView) rootView.findViewById(R.id.itemd_image_d);
            this.itemd_content_d = (TextView) rootView.findViewById(R.id.itemd_content_d);
            this.itemd_image_e = (ImageView) rootView.findViewById(R.id.itemd_image_e);
            this.itemd_content_e = (TextView) rootView.findViewById(R.id.itemd_content_e);
            this.itemd_image_f = (ImageView) rootView.findViewById(R.id.itemd_image_f);
            this.itemd_content_f = (TextView) rootView.findViewById(R.id.itemd_content_f);
        }

    }

    public class ViewHolderE extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView itemd_title;
        public ImageView itemd_image_a;
        public TextView itemd_content_a;
        public ImageView itemd_image_b;
        public TextView itemd_content_b;
        public ImageView itemd_image_c;
        public TextView itemd_contnet_c;
        public ImageView itemd_image_d;
        public TextView itemd_content_d;
        public ImageView itemd_image_e;
        public TextView itemd_content_e;
        public ImageView itemd_image_f;
        public TextView itemd_content_f;

        public ViewHolderE(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.itemd_title = (TextView) rootView.findViewById(R.id.itemd_title);
            this.itemd_image_a = (ImageView) rootView.findViewById(R.id.itemd_image_a);
            this.itemd_content_a = (TextView) rootView.findViewById(R.id.itemd_content_a);
            this.itemd_image_b = (ImageView) rootView.findViewById(R.id.itemd_image_b);
            this.itemd_content_b = (TextView) rootView.findViewById(R.id.itemd_content_b);
            this.itemd_image_c = (ImageView) rootView.findViewById(R.id.itemd_image_c);
            this.itemd_contnet_c = (TextView) rootView.findViewById(R.id.itemd_contnet_c);
            this.itemd_image_d = (ImageView) rootView.findViewById(R.id.itemd_image_d);
            this.itemd_content_d = (TextView) rootView.findViewById(R.id.itemd_content_d);
            this.itemd_image_e = (ImageView) rootView.findViewById(R.id.itemd_image_e);
            this.itemd_content_e = (TextView) rootView.findViewById(R.id.itemd_content_e);
            this.itemd_image_f = (ImageView) rootView.findViewById(R.id.itemd_image_f);
            this.itemd_content_f = (TextView) rootView.findViewById(R.id.itemd_content_f);
        }
    }

    public class ViewHolderF extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView itemf_title;
        public RecyclerView itemf_recycler;

        public ViewHolderF(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.itemf_title = (TextView) rootView.findViewById(R.id.itemf_title);
            this.itemf_recycler = (RecyclerView) rootView.findViewById(R.id.itemf_recycler);
        }
    }

    public class ViewHolderG extends RecyclerView.ViewHolder {

        private  ImageView itemg_content;
        private  TextView itemg_title;

        public ViewHolderG(View itemView) {
            super(itemView);
            itemg_title = itemView.findViewById(R.id.itemg_title);
            itemg_content = itemView.findViewById(R.id.itemg_content);
        }
    }

    public class ViewHolderH extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView itemf_title;
        public RecyclerView itemf_recycler;

        public ViewHolderH(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.itemf_title = (TextView) rootView.findViewById(R.id.itemf_title);
            this.itemf_recycler = (RecyclerView) rootView.findViewById(R.id.itemf_recycler);
        }
    }

    public class ViewHolderI extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView itemf_title;
        public RecyclerView itemf_recycler;

        public ViewHolderI(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.itemf_title = (TextView) rootView.findViewById(R.id.itemf_title);
            this.itemf_recycler = (RecyclerView) rootView.findViewById(R.id.itemf_recycler);
        }
    }



}
