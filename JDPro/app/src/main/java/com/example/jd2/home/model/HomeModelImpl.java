package com.example.jd2.home.model;


import com.example.jd2.base.BaseModel;
import com.example.jd2.home.contract.HomeContract;
import com.example.jd2.utils.INetCallBack;

public class HomeModelImpl extends BaseModel implements HomeContract.IHomeModel {
    private HomeContract.IHomePresenter iHomePresenter;

    public HomeModelImpl(HomeContract.IHomePresenter iHomePresenter) {
        this.iHomePresenter = iHomePresenter;
    }

    @Override
    public <T> void getHomeBannView(INetCallBack<T> netCallBack) {
        //网络请求结束了
       // iHomePresenter.callHomeBannView("");
       // NetWorkFactory.getInstance().getNetWork().get("/app/ssdf",netCallBack);
    }

    @Override
    public <T> void getHomeTabList(INetCallBack<T> iNetCallBack) {

    }
}
