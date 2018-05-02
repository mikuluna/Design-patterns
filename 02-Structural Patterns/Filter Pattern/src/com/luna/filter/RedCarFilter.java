package com.luna.filter;

import com.luna.filter.model.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤筛选出红色车辆
 */
public class RedCarFilter implements Filter {
    @Override
    public List<Car> filter(List<Car> cars) {
        List<Car> redCars = new ArrayList<Car>();
        for(Car car:cars){
            if(car.getColor().equals("red")){
                redCars.add(car);
            }
        }
        return redCars;
    }
}
