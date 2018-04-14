package com.luna.singleton.demo;

/**
 * 懒汉式(线程不安全)
 */
public class SingletonDemo3 {
    //定义对象
    private static SingletonDemo3 singleton;
    //private的构造函数，防止实例化
    private SingletonDemo3() {}
    //如果对象不存在就new出来
    public static SingletonDemo3 getInstance() {
        if (singleton == null) {
            singleton = new SingletonDemo3();
        }
        return singleton;
    }
}
