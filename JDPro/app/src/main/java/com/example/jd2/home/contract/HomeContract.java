package com.example.jd2.home.contract;

import com.example.jd2.base.BaseView;
import com.example.jd2.utils.INetCallBack;

public class HomeContract {
    public interface IHomeView extends BaseView {
        void setBannView(String string);


        void setTabList(String string);

    }

    public interface IHomeModel {
        <T> void getHomeBannView(INetCallBack<T> iNetCallBack);


        <T> void getHomeTabList(INetCallBack<T> iNetCallBack);
    }

    public interface IHomePresenter {
        void callHomeBannView(String string);
        void getBannerView();

        void getHomeTabList();

    }


}
