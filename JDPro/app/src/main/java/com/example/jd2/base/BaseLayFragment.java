package com.example.jd2.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


 // 懒加载Fragment

public abstract class BaseLayFragment extends Fragment {

    private boolean IS_VIEW_CREATE = false;

    public boolean IS_DATA_LOAD = false;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        LazyLoad();
    }

    private void LazyLoad() {
        if (getUserVisibleHint() && IS_VIEW_CREATE && !IS_DATA_LOAD) {
            //加载数据
            initData();
            IS_DATA_LOAD = true;
        } else {
            //不需要加载数据

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(getLayoutID(), container, false);

        IS_VIEW_CREATE = true;
        initView();
        initListener();

        return view;
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract int getLayoutID();
}
