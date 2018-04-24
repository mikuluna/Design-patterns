package com.luna.bridge.road.impl;

import com.luna.bridge.car.Car;
import com.luna.bridge.road.Road;

/**
 * 麦田类
 */
public class Cornfield extends Road {
    public Cornfield(Car car){
        super(car);
    }
    @Override
    public void inTheRoad() {
        car.getCarName();
        System.out.println("在麦田行驶");

    }
}
