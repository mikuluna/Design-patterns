package com.luna.filter;

import com.luna.filter.model.Car;

import java.util.List;

/**
 * Filter接口
 */
public interface Filter {
    /**
     * 过滤器方法，过滤一些我们自己定的条件
     * @param cars
     * @return
     */
    public List<Car> filter(List<Car> cars);
}
