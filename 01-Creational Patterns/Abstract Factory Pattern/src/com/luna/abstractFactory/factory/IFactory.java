package com.luna.abstractFactory.factory;

import com.luna.abstractFactory.product.IFriedChickenMeal;
import com.luna.abstractFactory.product.IHamburgerMeal;

/**
 * 抽象工厂
 */
public interface IFactory {
    /**
     * 创造汉堡套餐
     * @return
     */
    public IHamburgerMeal createHamburgerMeal();

    /**
     * 创造炸鸡套餐
     * @return
     */
    public IFriedChickenMeal createFriedChickenMeal();
}
