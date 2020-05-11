package com.example.jd2;

import android.util.Log;


import com.example.jd2.base.BaseModel;
import com.example.jd2.utils.INetCallBack;
import com.example.jd2.utils.NetWorkFactory;
import com.example.jd2.utils.ParamsUtils;
import com.example.jd2.utils.api.URLConstants;

import java.util.HashMap;

public class MainModel extends BaseModel implements MainContract.IMainMode {
    public MainModel() {
    }

    @Override
    public <T> void getRecommendList(INetCallBack<T> netCallBack) {
        //测试添加参数
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("start", "0");
        commonParams.put("number", "0");
        commonParams.put("point_time", "0");

        for (String key : commonParams.keySet()) {
            Log.e("TAG", "key=: " + key + ",values=" + commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().get(URLConstants.VEDIO_LIST, commonParams, netCallBack);

       // NetWorkFactory.getInstance().getNetWork().post(URLConstants.VEDIO_LIST, commonParams, netCallBack);

    }
}
