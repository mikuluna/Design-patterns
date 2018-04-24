package com.luna.bridge.road.impl;

import com.luna.bridge.car.Car;
import com.luna.bridge.road.Road;

/**
 * 山地类
 */
public class Mountain extends Road {
    public Mountain(Car car){
        super(car);
    }
    @Override
    public void inTheRoad() {
        car.getCarName();
        System.out.println("在山地行驶");

    }
}
