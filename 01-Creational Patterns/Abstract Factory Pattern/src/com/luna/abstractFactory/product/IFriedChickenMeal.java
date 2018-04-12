package com.luna.abstractFactory.product;

import com.luna.abstractFactory.model.FriedChickenMeal;

/**
 * 炸鸡套餐操作接口
 */
public interface IFriedChickenMeal {
    /**
     * 订炸鸡套餐
     * @param friedChickenMeal
     */
    public void order(FriedChickenMeal friedChickenMeal);

    /**
     * 吃订炸鸡套餐
     * @param friedChickenMeal
     */
    public void eat(FriedChickenMeal friedChickenMeal);
}
