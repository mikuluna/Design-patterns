package com.luna.test;

import com.luna.factory.FruitStore;
import com.luna.factory.impl.FruitFactory;
import com.luna.model.Fruit;

/**
 * 测试水果工厂
 */
public class TestFactory {
    public static void main(String args[]) throws Exception {
        FruitStore fruitFactory = new FruitFactory();
        Fruit fruit = fruitFactory.createFruit("Apple");
        fruit.show();
    }
}
