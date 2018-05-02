package com.luna.filter.util;

import com.luna.filter.Filter;
import com.luna.filter.model.Car;

import java.util.List;

/**
 * 只要满足一个条件即可
 */
public class FilterOr implements Filter{
    private Filter filter;
    private Filter otherFilter;

    public FilterOr(Filter filter, Filter otherFilter) {
        this.filter = filter;
        this.otherFilter = otherFilter;
    }

    @Override
    public List<Car> filter(List<Car> cars) {
        List<Car> temList = filter.filter(cars);
        List<Car> otherTemList = otherFilter.filter(cars);
        for(Car car:temList){
            if(!otherTemList.contains(car)){
                otherTemList.add(car);
            }
        }
        return otherTemList;
    }
}
