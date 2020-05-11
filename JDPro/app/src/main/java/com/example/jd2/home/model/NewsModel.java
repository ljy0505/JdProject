package com.example.jd2.home.model;

import android.util.Log;


import com.example.jd2.home.contract.NewsFragmentContract;
import com.example.jd2.utils.INetCallBack;
import com.example.jd2.utils.NetWorkFactory;
import com.example.jd2.utils.ParamsUtils;
import com.example.jd2.utils.api.URLConstants;

import java.util.HashMap;

public class NewsModel implements NewsFragmentContract.INewsMode {
    @Override
    public <T> void getRecommendList(String tabID, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("id", tabID);
        commonParams.put("start", "0");
        commonParams.put("number", "0");
        commonParams.put("point_time", "0");

        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().get(URLConstants.RECOMMEND_LIST,commonParams,iNetCallBack);
    }
}
