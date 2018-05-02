package com.luna.filter;

import com.luna.filter.model.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤筛选出四轮车
 */
public class FourWheelerFilter implements Filter{
    @Override
    public List<Car> filter(List<Car> cars) {
        List<Car> fourWheelterCars  = new ArrayList<Car>();
        for(Car car :cars){
            if(car.getTyreNum().equals("4")){
                fourWheelterCars.add(car);
            }
        }
        return fourWheelterCars;
    }
}
