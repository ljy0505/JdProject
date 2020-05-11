package com.example.jd2.home.contract;


import com.example.jd2.base.BaseView;
import com.example.jd2.bean.NewsBean;
import com.example.jd2.utils.INetCallBack;

public class NewsFragmentContract {
    public interface INewsView extends BaseView {
        void  setRecommendList(NewsBean newsBean);
    }
    public interface INewsMode{
        <T> void getRecommendList(String tabID, INetCallBack<T> iNetCallBack);
    }
    public interface INewsPresenter{
        void getRecommend(String string);
    }
}
