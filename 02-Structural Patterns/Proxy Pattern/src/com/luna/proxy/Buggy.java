package com.luna.proxy;

/**
 * 真实对象三蹦子Buggy
 */
public class Buggy implements ICar {
    @Override
    public void run() {
        System.out.println("Buggy在跑");
    }
}
