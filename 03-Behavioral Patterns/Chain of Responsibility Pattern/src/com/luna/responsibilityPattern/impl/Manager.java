package com.luna.responsibilityPattern.impl;

import com.luna.responsibilityPattern.Ratify;
import com.luna.responsibilityPattern.Result;
import com.luna.responsibilityPattern.mode.Request;

/**
 * 经理
 */
public class Manager implements Ratify {
    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("=============Manager经理处理request:"+request.toString());
        //如果天数大于一，交给上级。
        if(request.days()>3){
            Request newRequest = new Request.Builder().newRequest(request)
                    .setManagerInfo(request.name()+"每月的KPI考核还不错，可以批准")
                    .build();
            return chain.proceed(newRequest);
        }
        return new Result(true,"Manager经理：早点把事情办完，项目离不开你");
    }
}
