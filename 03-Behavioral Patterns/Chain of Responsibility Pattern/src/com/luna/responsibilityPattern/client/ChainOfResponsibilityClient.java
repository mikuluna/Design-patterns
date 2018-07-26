package com.luna.responsibilityPattern.client;

import com.luna.responsibilityPattern.Ratify;
import com.luna.responsibilityPattern.RealChain;
import com.luna.responsibilityPattern.Result;
import com.luna.responsibilityPattern.impl.DepartmentHeader;
import com.luna.responsibilityPattern.impl.GroupLeader;
import com.luna.responsibilityPattern.impl.Manager;
import com.luna.responsibilityPattern.mode.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模模式工具类
 */
public class ChainOfResponsibilityClient {
    private List<Ratify> ratifyArrayList;
    public ChainOfResponsibilityClient(){
        ratifyArrayList = new ArrayList<Ratify>();
    }

    /**
     * 责任链可扩展性
     * @param ratify
     */
    public void addRatifys(Ratify ratify){
        ratifyArrayList.add(ratify);
    }

    /**
     * 执行请求
     * @param request
     * @return
     */
    public Result execute(Request request){
        List<Ratify> ratifies = new ArrayList<Ratify>();
        ratifies.addAll(ratifyArrayList);
        ratifies.add(new GroupLeader());
        ratifies.add(new Manager());
        ratifies.add(new DepartmentHeader());
        RealChain realChain = new RealChain(ratifies,request,0);
        return realChain.proceed(request);
    }
}
