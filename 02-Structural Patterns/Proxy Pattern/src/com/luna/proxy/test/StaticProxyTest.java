package com.luna.proxy.test;

import com.luna.proxy.Buggy;
import com.luna.proxy.StaticProxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        StaticProxy proxy = new StaticProxy(new Buggy());
        proxy.run();
    }
}
