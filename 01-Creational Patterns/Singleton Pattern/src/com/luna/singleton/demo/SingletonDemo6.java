package com.luna.singleton.demo;

/**
 * 静态内部类
 */
public class SingletonDemo6 {
    //private的构造函数，防止实例化
    private SingletonDemo6() {}
    //内部类作用创建一个final的实体
    private static class SingletonInstance {
        private static final SingletonDemo6 INSTANCE = new SingletonDemo6();
    }
    //在第一次调用方法的时候才会new出来，之后就直接拿之前的
    public static SingletonDemo6 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
