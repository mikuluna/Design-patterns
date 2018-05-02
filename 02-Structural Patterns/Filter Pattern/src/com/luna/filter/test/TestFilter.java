package com.luna.filter.test;


import com.luna.filter.Filter;
import com.luna.filter.FourWheelerFilter;
import com.luna.filter.RedCarFilter;
import com.luna.filter.model.Car;
import com.luna.filter.util.FilterAnd;
import com.luna.filter.util.FilterOr;

import java.util.ArrayList;
import java.util.List;

public class TestFilter {
    public static void main(String[] args) {
        //1.先把要筛选的车辆构造好
        Car uaz = new Car("uaz","green","4");
        Car buggy = new Car("buggy","red","2");
        Car garcia = new Car("garcia","red","4");
        Car bike = new Car("bike","yellow","2");
        List<Car> carList = new ArrayList<Car>();
        carList.add(uaz);
        carList.add(buggy);
        carList.add(garcia);
        carList.add(bike);
        System.out.println("原本的carList:");
        printCars(carList);

        //2.选出红色Car
        Filter redCarFilter = new RedCarFilter();
        System.out.println("红色车辆:");
        printCars(redCarFilter.filter(carList));

        //3.筛选出4轮车
        Filter num4Filter = new FourWheelerFilter();
        System.out.println("4轮车:");
        printCars(num4Filter.filter(carList));

        //4.筛选出红色或者4轮
        Filter redOrNum4Filter = new FilterOr(redCarFilter,num4Filter);
        System.out.println("红色或者4轮:");
        printCars(redOrNum4Filter.filter(carList));

        //5.筛选出红色并且4轮
        Filter redAndNum4Filter = new FilterAnd(redCarFilter,num4Filter);
        System.out.println("红色并且4轮:");
        printCars(redAndNum4Filter.filter(carList));
    }
    public static void printCars(List<Car> cars){
        for(Car car:cars){
            System.out.println(car.toString()+" ");
        }
        System.out.println("========================");

    }
}
