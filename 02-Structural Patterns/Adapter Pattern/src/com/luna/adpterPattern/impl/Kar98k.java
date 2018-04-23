package com.luna.adpterPattern.impl;

import com.luna.adpterPattern.Gun;

/**
 * 被适配者的实现
 * 98k类
 */
public class Kar98k implements Gun {
    @Override
    public void shooting() {
        System.out.println("98K在射击……………");
    }
}
