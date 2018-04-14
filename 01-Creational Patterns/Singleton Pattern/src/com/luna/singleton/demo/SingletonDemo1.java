package com.luna.singleton.demo;

/**
 * 饿汉式（静态常量）
 */
public class SingletonDemo1 {
    //静态常量将对象new出来
    private final static SingletonDemo1 INSTANCE = new SingletonDemo1();
    //private的构造函数，防止实例化
    private SingletonDemo1(){
    }
    //通过getInstance获取对象
    public static SingletonDemo1 getInstance(){
        return INSTANCE;
    }
}
