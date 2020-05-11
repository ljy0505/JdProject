package com.example.jd2.home.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.jd2.home.view.fragment.NewsFragment;

import java.util.List;

public class NewsFragmentAdapter extends FragmentPagerAdapter {
     List<NewsFragment> fragments;

    public NewsFragmentAdapter(FragmentManager fm, List<NewsFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
