package com.example.administrator.mypanda.ui.fragmens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.ui.base.AbstractBase;

/**
 * @author 农民伯伯
 * @version 2017/11/3
 */

public abstract class BaseFragment extends Fragment implements AbstractBase {
    /**
     * 布局默认全部都不使用
     * <p>
     * isShowHeaderView = false;            控制是否使用头布局
     * isShowFooterView = false;            控制是否使用尾布局
     * isShowNotScrollViewVisible = false;  控制是否使用不滑动的主体布局
     * isShowScrollView = false;            控制是否使用滑动的主体布局
     * isShowRefreshView = false;           控制是否使用刷新的主体布局
     * isShowErrorView = false;             控制是否使用错误布局
     */
    public boolean isShowHeaderView = false;
    public boolean isShowFooterView = false;
    public boolean isShowNotScrollView = false;
    public boolean isShowScrollView = false;
    public boolean isShowRefreshView = false;
    public boolean isShowErrorView = false;


    private LinearLayout mHeaderView;
    private LinearLayout mFooterView;
    private LinearLayout mNotScrollBody;
    private LinearLayout mScrollView;
    private ScrollView mScrollBody;
    private LinearLayout mRefreshView;
    private SwipeRefreshLayout mRefreshBody;
    private LinearLayout mErrorBody;
    private RelativeLayout mBodyView;
    private View view;

    /**
     * 设置默认布局
     *
     * @param savedInstanceState
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        setDagger();
        view = inflater.inflate(R.layout.base_activity, container, false);
        //初始化总布局的控件
        initView(view);
        //设置布局显示
        setViewVisible();
        init();
        /**
         * 检查头布局是否显示
         */
        checkHeaderLayout();
        /**
         * 检查身体布局
         */
        checkBodyLayout();
        /**
         * 检查尾部布局
         */
        checkFooterLayout();
        return view;
    }
    public View findViewById(int id){
        View view1 = view.findViewById(id);
        return view1;
    }


        /**
     * 设置头布局 判断如果显示就添加View
     *
     * @param id
     */
    @Override
    public void setHeaderView(int id) {
        //通过 View.inflate() 方法，查找出相对应的View
        View headerView = View.inflate(getActivity(), id, null);
        // 因为加入Base后 宽高属性失效，所以在此设置宽高
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 70);
        //把宽高属性设置给对应的View
        headerView.setLayoutParams(params);
        if (isShowHeaderView)
            mHeaderView.addView(headerView);
    }

    /**
     * 设置尾部局 判断如果显示就添加View
     *
     * @param id
     */
    @Override
    public void setFooterView(int id) {
        //通过 View.inflate() 方法，查找出相对应的View
        View footerView = View.inflate(getActivity(), id, null);
        // 因为加入Base后 宽高属性失效，所以在此设置宽高
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 70);
        //把宽高属性设置给对应的View
        footerView.setLayoutParams(params);
        if (isShowFooterView)
            mFooterView.addView(footerView);
    }

    /**
     * 设置身体布局 通过boolean值判断用的是哪个body布局 并且添加View
     *
     * @param id
     */
    @Override
    public void setBodyView(int id) {
        //通过 View.inflate() 方法，查找出相对应的View
        View body = View.inflate(getActivity(), id, null);
        // 因为加入Base后 宽高属性失效，所以在此设置宽高
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //把宽高属性设置给对应的View
        body.setLayoutParams(params);
        if (isShowErrorView) {
            mErrorBody.addView(body);
        }
        if (isShowRefreshView) {
            mRefreshView.addView(body);
            return;
        }
        if (isShowScrollView) {
            mScrollView.addView(body);
            return;
        }
        if (isShowNotScrollView) {
            mNotScrollBody.addView(body);
            return;
        }


    }

    /**
     * 设置是否显示头部局
     *
     * @param visible
     */
    @Override
    public void setHeaderViewVisible(int visible) {
        isShowHeaderView = visible == View.VISIBLE;
    }

    /**
     * 设置是否显示尾部局
     *
     * @param visible
     */
    @Override
    public void setFooterViewVisible(int visible) {
        isShowFooterView = visible == View.VISIBLE;
    }

    /**
     * 设置是否显示非滑动布局
     *
     * @param visible
     */
    @Override
    public void setNotScrollViewVisible(int visible) {
        isShowNotScrollView = visible == View.VISIBLE;
    }

    /**
     * 设置是否显示滑动布局
     *
     * @param visible
     */
    @Override
    public void setScrollViewVisible(int visible) {
        isShowScrollView = visible == View.VISIBLE;
    }

    /**
     * 设置是否显示刷新布局
     *
     * @param visible
     */

    @Override
    public void setRefreshViewVisible(int visible) {
        isShowRefreshView = visible == View.VISIBLE;
    }

    /**
     * 设置是否显示错误布局
     *
     * @param visible
     */
    @Override
    public void setErrorViewVisible(int visible) {
        isShowErrorView = visible == View.VISIBLE;
    }

    /**
     * 检查身体布局显示哪个
     */
    @Override
    public void checkBodyLayout() {

        if (isShowNotScrollView)
            mNotScrollBody.setVisibility(View.VISIBLE);
        else
            mNotScrollBody.setVisibility(View.GONE);

        if (isShowScrollView)
            mScrollBody.setVisibility(View.VISIBLE);
        else
            mScrollBody.setVisibility(View.GONE);

        if (isShowRefreshView)
            mRefreshBody.setVisibility(View.VISIBLE);
        else
            mRefreshBody.setVisibility(View.GONE);

        if (isShowErrorView)
            mErrorBody.setVisibility(View.VISIBLE);
        else
            mErrorBody.setVisibility(View.GONE);

    }

    /**
     * 检查是否显示头布局
     */
    @Override
    public void checkHeaderLayout() {
        if (isShowHeaderView)
            mHeaderView.setVisibility(View.VISIBLE);
        else
            mHeaderView.setVisibility(View.GONE);

    }

    /**
     * 检查是否显示尾部局
     */
    @Override
    public void checkFooterLayout() {
        if (isShowFooterView)
            mFooterView.setVisibility(View.VISIBLE);
        else
            mFooterView.setVisibility(View.GONE);
    }


    private void initView(View view) {
        mHeaderView = (LinearLayout) view.findViewById(R.id.mHeaderView);
        mFooterView = (LinearLayout) view.findViewById(R.id.mFooterView);
        mNotScrollBody = (LinearLayout) view.findViewById(R.id.mNotScrollBody);
        mScrollView = (LinearLayout) view.findViewById(R.id.mScrollView);
        mScrollBody = (ScrollView) view.findViewById(R.id.mScrollBody);
        mRefreshView = (LinearLayout) view.findViewById(R.id.mRefreshView);
        mRefreshBody = (SwipeRefreshLayout) view.findViewById(R.id.mRefreshBody);
        mErrorBody = (LinearLayout) view.findViewById(R.id.mErrorBody);
        mBodyView = (RelativeLayout) view.findViewById(R.id.mBodyView);
    }
}


