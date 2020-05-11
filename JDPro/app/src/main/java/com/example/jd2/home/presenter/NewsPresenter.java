package com.example.jd2.home.presenter;


import com.example.jd2.base.BasePresenter;
import com.example.jd2.bean.NewsBean;
import com.example.jd2.home.contract.NewsFragmentContract;
import com.example.jd2.home.contract.RecommentContract;
import com.example.jd2.home.model.NewsModel;
import com.example.jd2.utils.INetCallBack;

public class NewsPresenter extends BasePresenter<NewsFragmentContract.INewsView> implements RecommentContract.IRecommendPresenter {

    private final NewsModel iNewsModel;

    @Override
    public void getColumList() {

    }

    public NewsPresenter() {
        iNewsModel = new NewsModel();
    }

    @Override
    public void getRecommendList(String id) {
        iNewsModel.getRecommendList(id, new INetCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {
                mView.setRecommendList(newsBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
