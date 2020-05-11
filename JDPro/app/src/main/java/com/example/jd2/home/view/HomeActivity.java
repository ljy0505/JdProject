package com.example.jd2.home.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.example.jd2.R;
import com.example.jd2.base.BaseActivity;
import com.example.jd2.home.adapter.HomeFragmrntAdapter;
import com.example.jd2.home.contract.HomeContract;
import com.example.jd2.home.presenter.HomePresenterImpl;
import com.example.jd2.home.view.fragment.MineFragment;
import com.example.jd2.home.view.fragment.RecommendFragment;
import com.example.jd2.home.view.fragment.TopicFragment;
import com.example.jd2.home.view.fragment.VedioFragment;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity<HomePresenterImpl> implements HomeContract.IHomeView {

    private ViewPager viewPager;
    private RecommendFragment recommendFragment;
    private TopicFragment topicFragment;
    private MineFragment mineFragment;
    private VedioFragment vedioFragment;
    private HomeFragmrntAdapter homeFragmrntAdapter;
    private ArrayList<Fragment> fragments;
    /**
     * 推荐
     */
    private RadioButton mRecommoendTab;
    /**
     * 视频
     */
    private RadioButton mVedioTab;
    /**
     * 专题
     */
    private RadioButton mTopicTab;
    /**
     * 我
     */
    private RadioButton mMyTab;
    private RadioGroup mTabsRg;
    private ViewPager mFragmentVp;
    private RadioButton topicTab;
    private RadioGroup radioGroup;


    @Override
    public int getLayoutID() {
        return R.layout.activity_home;
    }

    @Override
    protected HomePresenterImpl initPresenter() {
        return new HomePresenterImpl();
    }

    @Override
    public void initView() {
        fragments = new ArrayList<>();
        viewPager = findViewById(R.id.fragment_vp);

        recommendFragment = new RecommendFragment();
        topicFragment = new TopicFragment();
        mineFragment = new MineFragment();
        vedioFragment = new VedioFragment();


        fragments.add(recommendFragment);
        fragments.add(vedioFragment);
        fragments.add(topicFragment);
        fragments.add(mineFragment);

        homeFragmrntAdapter = new HomeFragmrntAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(homeFragmrntAdapter);
        viewPager.setCurrentItem(0);  //默认展示第一个
        viewPager.setOffscreenPageLimit(4);  //缓存四个


        radioGroup = findViewById(R.id.tabs_rg);
        topicTab = findViewById(R.id.topic_tab);
        mRecommoendTab = findViewById(R.id.recommoend_tab);
        mVedioTab = findViewById(R.id.vedio_tab);
        mMyTab = findViewById(R.id.my_tab);


    }
    @Override
    public void initData() {
        //((HomePresenterImpl) mPresenter).getBannerView();
        mPresenter.getHomeTabList();
    }
    @Override
    public void initLinstener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.recommoend_tab:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.vedio_tab:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.topic_tab:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.my_tab:
                        viewPager.setCurrentItem(3);
                        break;

                }
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mRecommoendTab.setChecked(true);
                        break;
                    case 1:
                        mVedioTab.setChecked(true);
                        break;
                    case 2:
                        topicTab.setChecked(true);
                        break;
                    case 3:
                        mMyTab.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }




    @Override
    public void setBannView(String content) {
        //得到bannView的数据了
    }

    @Override
    public void setTabList(String string) {
        //最终获得tab栏目数据

    }
}
