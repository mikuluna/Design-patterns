package com.luna.singleton.demo;

/**
 * 懒汉式(线程安全，同步方法)
 */
public class SingletonDemo4 {
    //定义对象
    private static SingletonDemo4 singleton;
    //private的构造函数，防止实例化
    private SingletonDemo4() {}
    //如果对象不存在就new出来，并且加入synchronized关键字达到同步
    public static synchronized SingletonDemo4 getInstance() {
        if (singleton == null) {
            singleton = new SingletonDemo4();
        }
        return singleton;
    }
}
