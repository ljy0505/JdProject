package com.example.jd2.home.presenter;


import com.example.jd2.base.BasePresenter;
import com.example.jd2.bean.User;
import com.example.jd2.home.contract.HomeContract;
import com.example.jd2.home.model.HomeModelImpl;
import com.example.jd2.home.view.HomeActivity;
import com.example.jd2.utils.INetCallBack;

public class HomePresenterImpl extends BasePresenter<HomeActivity> implements HomeContract.IHomePresenter {

    private HomeContract.IHomeModel iHomeModel;
    //private HomeContract.IHomeView iHomeView;

    public HomePresenterImpl() {
        iHomeModel = new HomeModelImpl(this);
    }

    @Override
    public void callHomeBannView(String string) {
        //P层中拿到数据
        //  P层中拿到数据
        mView.setBannView(string);
    }

    public void getBannerView() {
        iHomeModel.getHomeBannView(new INetCallBack<User>() {
            @Override
            public void onSuccess(User user) {

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getHomeTabList() {

    }

  /*  @Override
    public void disAttachView() {
        iHomeModel = null;
        iHomeView = null;
    }*/
}
