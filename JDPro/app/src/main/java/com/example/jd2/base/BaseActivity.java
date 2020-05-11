package com.example.jd2.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView{

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutID());

        mPresenter = initPresenter();
        mPresenter.AttachView(this);

        initView();
        initData();
        initLinstener();

    }

    protected abstract P initPresenter();

    public abstract void initLinstener();

    public abstract void initData();

    public abstract void initView();

    public abstract int getLayoutID();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.disAttachView();
    }
}
