package com.luna.bridge.road;

import com.luna.bridge.car.Car;

/**
 * 路抽象
 */
public abstract class Road {
    protected Car car;

    /**
     * 构造函数，方便传入car
     */
    public Road(Car car) {
        this.car = car;
    }

    /**
     * 车行驶在哪条路上
     */
    public abstract void inTheRoad();
}
