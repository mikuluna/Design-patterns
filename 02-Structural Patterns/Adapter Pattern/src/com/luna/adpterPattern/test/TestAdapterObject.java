package com.luna.adpterPattern.test;

import com.luna.adpterPattern.Appliance;
import com.luna.adpterPattern.impl.AdapterObjectKar98k;
import com.luna.adpterPattern.impl.Kar98k;

/**
 * 测试类
 */
public class TestAdapterObject {
    public static void main(String[] args) {
        Appliance new98k = new AdapterObjectKar98k(new Kar98k());
        new98k.shooting();
        new98k.hiting();
    }
}
