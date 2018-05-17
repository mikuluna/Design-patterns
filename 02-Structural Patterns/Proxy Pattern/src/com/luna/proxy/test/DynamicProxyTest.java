package com.luna.proxy.test;

import com.luna.proxy.Buggy;
import com.luna.proxy.DynamicProxy;
import com.luna.proxy.ICar;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 测试类
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        //我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler h = new DynamicProxy(new Buggy());

        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 ICar.class.getClassLoader() ，我们这里使用ICar这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数new Class[]{ICar.class}，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数h， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        ICar proxy = (ICar) Proxy.newProxyInstance(ICar.class.getClassLoader(),new Class[]{ICar.class},h);
        proxy.run();
    }
}
