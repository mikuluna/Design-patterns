package com.luna.abstractFactory.product;

import com.luna.abstractFactory.model.HamburgerMeal;

/**
 * 汉堡套餐操作接口
 */
public interface IHamburgerMeal {
    /**
     * 订汉堡套餐
     * @param hamburgerMeal
     */
    public void order(HamburgerMeal hamburgerMeal);

    /**
     * 吃汉堡套餐
     * @param hamburgerMeal
     */
    public void eat(HamburgerMeal hamburgerMeal);
}
