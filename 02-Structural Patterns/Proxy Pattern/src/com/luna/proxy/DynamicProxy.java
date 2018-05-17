package com.luna.proxy;

import com.luna.proxy.ICar;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 */
public class DynamicProxy implements InvocationHandler{
    private ICar car;

    public DynamicProxy(ICar car) {
        this.car = car;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理...");
        method.invoke(car,args);
        return null;
    }
}
