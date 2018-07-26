package com.luna.responsibilityPattern.impl;

import com.luna.responsibilityPattern.Ratify;
import com.luna.responsibilityPattern.Result;
import com.luna.responsibilityPattern.mode.Request;

/**
 * 部门领导
 */
public class DepartmentHeader implements Ratify {
    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("=============DepartmentHeader部门领导request:"
                + request.toString());
        if (request.days() > 7) {
            return new Result(false, "你这个完全没必要");
        }
        return new Result(true, "DepartmentHeader：不要着急，把事情处理完再回来！");
    }
}
