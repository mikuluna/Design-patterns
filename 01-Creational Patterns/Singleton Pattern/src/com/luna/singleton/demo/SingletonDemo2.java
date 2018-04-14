package com.luna.singleton.demo;

/**
 * 饿汉式（静态代码块）
 */
public class SingletonDemo2 {
    //定义对象，并且通过静态代码块new出来
    private static SingletonDemo2 instance;
    static {
        instance=new SingletonDemo2();
    }
    //private的构造函数，防止实例化
    private SingletonDemo2(){
    }
    //通过getInstance获取对象
    public static SingletonDemo2 getInstance(){
        return instance;
    }
}
