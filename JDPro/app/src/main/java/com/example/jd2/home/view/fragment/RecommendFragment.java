package com.example.jd2.home.view.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.example.jd2.R;
import com.example.jd2.base.BaseFragment;
import com.example.jd2.bean.ColunmBean;
import com.example.jd2.bean.NewsBean;
import com.example.jd2.home.adapter.NewsFragmentAdapter;
import com.example.jd2.home.contract.RecommentContract;
import com.example.jd2.home.presenter.RecommendPresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommentContract.IRecommendView {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<NewsFragment> fragments = new ArrayList<>();
    private NewsFragmentAdapter newsFragmentAdapter;

    @Override
    protected RecommendPresenter initPresenter() {
        return new RecommendPresenter();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mPresenter.getColumList();
        //mPresenter.getRecommendList();
    }

    @Override
    protected void initView(View view) {
        tabLayout = view.findViewById(R.id.mytablayout);
        viewPager = view.findViewById(R.id.myviewpager);
    }

    private void initTab(final ColunmBean columList) {
        newsFragmentAdapter = new NewsFragmentAdapter(getChildFragmentManager(), fragments);
        viewPager.setAdapter(newsFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                for (int i = 0; i < columList.getData().getList().size(); i++) {
                    TextView tabAt = (TextView) tabLayout.getTabAt(i).getCustomView();
                    tabAt.setBackgroundResource(R.color.colorWhite);
                }
                GradientDrawable drawable = new GradientDrawable();
                drawable.setCornerRadius(50);

                TextView customView = (TextView) tab.getCustomView();
                drawable.setStroke(1, Color.parseColor("#ff00ff"));
                drawable.setColor(Color.parseColor("#"+columList.getData().getList().get(tab.getPosition()).getBack_color()));
                customView.setBackground(drawable);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected int getLayoutID() {
        return R.layout.recommend_fragment;
    }

    @Override
    public void setRecommendList(NewsBean newsBean) {
    }

    @Override
    public void setColumList(ColunmBean columList) {
        Log.e("TAG", "当前TabLayout的栏目数据：" + columList.toString());
        //栏目请求成功了
        if (columList.getCode() == 1) {
            // mPresenter.getRecommendList(columList.getData().getList().get(0).getId());
            for (int i = 0; i < columList.getData().getList().size(); i++) {
                //创建咱们的Fragment
                NewsFragment  newsFragment = new NewsFragment(columList.getData().getList().get(i).getId());
                fragments.add(newsFragment);
            }
            initTab(columList);
            for (int i = 0; i < columList.getData().getList().size(); i++) {
                TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.recommend_tab_item, null);
                textView.setGravity(Gravity.CENTER);
                textView.setText(i + "个");
                tabLayout.addTab(tabLayout.newTab().setCustomView(textView), i);
            }
        }
    }
}
