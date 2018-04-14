package com.luna.singleton.demo;

/**
 * 双重校验锁
 */
public class SingletonDemo5 {
    //定义对象
    private static SingletonDemo5 singleton;
    //private的构造函数，防止实例化
    private SingletonDemo5() {}
    //如果对象不存在同步中再校验一遍，以便防止重复创建对象。
    public static SingletonDemo5 getInstance() {
        if (singleton == null) {
            synchronized(SingletonDemo5.class){
                if(singleton==null){
                    singleton=new SingletonDemo5();
                }
            }

        }
        return singleton;
    }
}
