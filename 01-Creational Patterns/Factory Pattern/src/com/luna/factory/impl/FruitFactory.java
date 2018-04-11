package com.luna.factory.impl;

import com.luna.factory.FruitStore;
import com.luna.model.impl.Apple;
import com.luna.model.impl.Banana;
import com.luna.model.Fruit;
import com.luna.model.impl.Orange;

/**
 * 水果工厂
 */
public class FruitFactory extends FruitStore {

//    @Override
//    public Fruit createFruit(String type) {
//        Fruit fruit = null;
//        if(type.equals("Apple")){
//            fruit = new Apple();
//        }
//        else if(type.equals("Orange")){
//            fruit = new Orange();
//        }
//        else if(type.equals("Banana")){
//            fruit = new Banana();
//        }
//        return fruit;
//    }
    @Override
    public Fruit createFruit(String type) throws Exception {
      Class<?> cls = Class.forName(type);
        Object obj = cls.newInstance();
        return (Fruit) obj;
    }
}
