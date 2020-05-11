package com.example.jd2;


import com.example.jd2.base.BaseView;
import com.example.jd2.utils.INetCallBack;

public class MainContract {
    public interface IMainView extends BaseView {

    }

    public interface IMainMode {
        <T> void getRecommendList(INetCallBack<T> netCallBack);
    }

    public interface IMainPresenter {
        void getRecommendList();
    }
}
