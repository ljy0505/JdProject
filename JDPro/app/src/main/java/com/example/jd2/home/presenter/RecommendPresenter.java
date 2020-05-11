package com.example.jd2.home.presenter;

import android.util.Log;

import com.example.jd2.base.BasePresenter;
import com.example.jd2.bean.ColunmBean;
import com.example.jd2.bean.NewsBean;
import com.example.jd2.home.contract.RecommentContract;
import com.example.jd2.home.model.RecommendModel;
import com.example.jd2.utils.INetCallBack;


public class RecommendPresenter extends BasePresenter<RecommentContract.IRecommendView> implements RecommentContract.IRecommendPresenter {

    private RecommentContract.IRecommendModel recommendModel;

    public RecommendPresenter() {
        recommendModel = new RecommendModel();
    }

    @Override
    public void getColumList() {
        recommendModel.getColumList(new INetCallBack<ColunmBean>() {
            @Override
            public void onSuccess(ColunmBean colunmBean) {
                mView.setColumList(colunmBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getRecommendList(String id) {
        recommendModel.getRecommendList(id, new INetCallBack<NewsBean>() {
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
