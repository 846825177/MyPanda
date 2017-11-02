package com.example.administrator.mypanda.ui.base;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.example.administrator.mypanda.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * @author 农民伯伯
 * @version 2017/11/1
 */

public abstract class BaseActivity extends AbstractActivity {
    /**
     * 头布局
     */
    @InjectView(R.id.mHeaderView)
    LinearLayout mHeaderView;
    /**
     * 尾部局
     */
    @InjectView(R.id.mFooterView)
    LinearLayout mFooterView;
    /**
     * 非滑动布局
     */
    @InjectView(R.id.mNotScrollBody)
    LinearLayout mNotScrollBody;
    /**
     * 滑动布局
     */
    @InjectView(R.id.mScrollView)
    LinearLayout mScrollView;
    /**
     * 滑动父布局
     */
    @InjectView(R.id.mScrollBody)
    ScrollView mScrollBody;
    /**
     * 刷新布局
     */
    @InjectView(R.id.mRefreshView)
    LinearLayout mRefreshView;
    /**
     * 刷新父布局
     */
    @InjectView(R.id.mRefreshBody)
    SwipeRefreshLayout mRefreshBody;
    /**
     * 错误布局
     */
    @InjectView(R.id.mErrorBody)
    LinearLayout mErrorBody;
    /**
     * 总的body布局
     */
    @InjectView(R.id.mBodyView)
    RelativeLayout mBodyView;

    /**
     * 设置默认布局
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setDagger();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);
        ButterKnife.inject(this);
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

    }

    /**
     * 设置头布局 判断如果显示就添加View
     *
     * @param id
     */
    @Override
    public void setHeaderView(int id) {
        //通过 View.inflate() 方法，查找出相对应的View
        View headerView = View.inflate(this, id, null);
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
        View footerView = View.inflate(this, id, null);
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
        View body = View.inflate(this, id, null);
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
}
