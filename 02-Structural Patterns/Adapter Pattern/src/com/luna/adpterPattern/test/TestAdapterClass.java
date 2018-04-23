package com.luna.adpterPattern.test;

import com.luna.adpterPattern.Appliance;
import com.luna.adpterPattern.impl.AdapterClassKar98k;

/**
 * 测试类
 */
public class TestAdapterClass {
    public static void main(String[] args) {
        Appliance new98k = new AdapterClassKar98k();
        new98k.shooting();
        new98k.hiting();
    }
}
