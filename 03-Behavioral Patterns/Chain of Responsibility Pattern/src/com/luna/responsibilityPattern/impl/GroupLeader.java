package com.luna.responsibilityPattern.impl;


import com.luna.responsibilityPattern.Ratify;
import com.luna.responsibilityPattern.Result;
import com.luna.responsibilityPattern.mode.Request;

/**
 * 组长
 */
public class GroupLeader implements Ratify {

    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("=============GroupLeader组长处理request:"+request.toString());
        //如果天数大于一，交给上级。
        if(request.days()>1){
            Request newRequest = new Request.Builder().newRequest(request)
                    .setManagerInfo(request.name()+"平时表现不错，而且现在也不忙")
                    .build();
            return chain.proceed(newRequest);
        }
        return new Result(true,"GroupLeader组长：早去早回");
    }
}
