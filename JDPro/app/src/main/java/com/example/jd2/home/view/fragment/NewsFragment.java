package com.example.jd2.home.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.jd2.R;
import com.example.jd2.base.BaseFragment;
import com.example.jd2.bean.NewsBean;
import com.example.jd2.home.adapter.NewsBannerAdapter;
import com.example.jd2.home.contract.NewsFragmentContract;
import com.example.jd2.home.presenter.NewsPresenter;
import com.example.jd2.home.view.Banner_Indicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class NewsFragment extends BaseFragment<NewsPresenter> implements NewsFragmentContract.INewsView {
    private String tabID;
    private List<View> banner_views = new ArrayList<>();
    private ViewPager banner_viewPager;
    private int viewpager_Current_Pos = 0;
    private int current_banner_item;
    private Banner_Indicator banner_indicator;

    public NewsFragment(String tabID) {
        this.tabID = tabID;
    }

    @Override
    protected NewsPresenter initPresenter() {
        return new NewsPresenter();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mPresenter.getRecommendList(tabID);
    }

    @Override
    protected void initView(View view) {
        banner_viewPager = view.findViewById(R.id.banner_viewpage);
        banner_indicator = view.findViewById(R.id.banner_indicator);
    }


    @Override
    protected int getLayoutID() {
        return R.layout.fragment_news;
    }

    @Override
    public void setRecommendList(NewsBean newsBean) {
        initBanner(newsBean);
    }


    private void initBanner(final NewsBean newsBean) {

        for (int i = 0; i < newsBean.getData().getBanner_list().size(); i++) {
            current_banner_item = i;
            View ban_view = LayoutInflater.from(getContext()).inflate(R.layout.news_banner_item, null);
            TextView bannerContent = ban_view.findViewById(R.id.banner_content);
            ImageView bannerImage = ban_view.findViewById(R.id.banner_image);

            bannerContent.setText(newsBean.getData().getBanner_list().get(i).getDescription());
            Glide.with(getContext()).load(newsBean.getData().getBanner_list().get(i).getImage_url()).into(bannerImage);

            banner_views.add(ban_view);
            ban_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "点击了"+current_banner_item+"个view", Toast.LENGTH_SHORT).show();
                }
            });
        }
        NewsBannerAdapter bannerAdapter = new NewsBannerAdapter(banner_views);
        banner_viewPager.setAdapter(bannerAdapter);

        banner_indicator.setBannerImageSize(newsBean.getData().getBanner_list().size());
        banner_indicator.setCurrentBannerItem(0);


        banner_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                current_banner_item = position;
                banner_indicator.setCurrentBannerItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                viewpager_Current_Pos += 1;
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        banner_viewPager.setCurrentItem(viewpager_Current_Pos % (newsBean.getData().getBanner_list().size()));
                    }
                });
            }
        };
        timer.schedule(timerTask, 2000, 2000);
    }


}
