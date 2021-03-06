package com.example.jd2.home.model;

import android.util.Log;


import com.example.jd2.home.contract.RecommentContract;
import com.example.jd2.utils.INetCallBack;
import com.example.jd2.utils.NetWorkFactory;
import com.example.jd2.utils.ParamsUtils;
import com.example.jd2.utils.api.URLConstants;

import java.util.HashMap;

public class RecommendModel implements RecommentContract.IRecommendModel {
    @Override
    public <T> void getRecommendList(String id, INetCallBack<T> iNetCallBack) {
       /* //测试添加参数
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("id", id);
        commonParams.put("start", "0");
        commonParams.put("number", "0");
        commonParams.put("point_time", "0");
//  此处 -- 登录以后 需要修改
        for (String key : commonParams.keySet()) {
            Log.e("TAG", "key=: " + key + ",values=" + commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().get(URLConstants.RECOMMEND_LIST, commonParams, iNetCallBack);
        */
    }

    @Override
    public <T> void getColumList(INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        for (String key : commonParams.keySet()) {
            Log.e("TAG", "key=" + key + ",values=" + commonParams.get(key));
        }

        NetWorkFactory.getInstance().getNetWork().get(URLConstants.COLUM_LIST, commonParams, iNetCallBack);
    }
}
