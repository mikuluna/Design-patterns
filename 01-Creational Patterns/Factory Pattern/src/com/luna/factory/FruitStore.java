package com.luna.factory;

import com.luna.model.Fruit;

/**
 * 水果商店
 */
public abstract  class FruitStore {
    public Fruit orderFruit(String type) {
        Fruit fruit = this.createFruit(type);
        return fruit;
    }
    public abstract Fruit createFruit(String type) throws IllegalAccessException, InstantiationException, Exception;
}
