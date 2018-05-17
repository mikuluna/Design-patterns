package com.luna.proxy;

/**
 * 静态代理对象
 */
public class StaticProxy implements ICar{
    private ICar car;

    public StaticProxy(ICar car){
        this.car = car;
    }
    @Override
    public void run() {
        System.out.println("代理...");
        car.run();
    }
}
