package com.luna.filter.util;

import com.luna.filter.Filter;
import com.luna.filter.model.Car;

import java.util.List;

/**
 * 两个条件都需要满足
 */
public class FilterAnd implements Filter{
    private Filter filter;
    private Filter otherFilter;

    public FilterAnd(Filter filter, Filter otherFilter) {
        this.filter = filter;
        this.otherFilter = otherFilter;
    }

    @Override
    public List<Car> filter(List<Car> cars) {
        List<Car> tempList = filter.filter(cars);
        return otherFilter.filter(tempList);
    }
}
