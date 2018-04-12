package com.luna.abstractFactory.product.impl;

import com.luna.abstractFactory.model.FriedChickenMeal;
import com.luna.abstractFactory.product.IFriedChickenMeal;

/**
 * 肯打鸡炸鸡套餐
 */
public class KendaFriedChickenMeal implements IFriedChickenMeal {
    @Override
    public void order(FriedChickenMeal friedChickenMeal) {
        System.out.println("在点餐！肯打鸡的炸鸡套餐，包括："+friedChickenMeal.getDrink()+","
                +friedChickenMeal.getFriedChicken());
    }

    @Override
    public void eat(FriedChickenMeal friedChickenMeal) {
        System.out.println("饿了！在吃！！！肯打鸡的炸鸡套餐，包括："+friedChickenMeal.getDrink()+","
                +friedChickenMeal.getFriedChicken());
    }
}
