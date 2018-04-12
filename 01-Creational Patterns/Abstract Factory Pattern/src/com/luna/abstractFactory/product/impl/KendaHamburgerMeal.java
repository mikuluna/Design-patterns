package com.luna.abstractFactory.product.impl;

import com.luna.abstractFactory.model.HamburgerMeal;
import com.luna.abstractFactory.product.IHamburgerMeal;

/**
 * 肯打鸡汉堡套餐
 */
public class KendaHamburgerMeal implements IHamburgerMeal {
    @Override
    public void order(HamburgerMeal hamburgerMeal) {
        System.out.println("在点餐！肯打鸡的汉堡套餐，包括："+hamburgerMeal.getDrink()+","
                +hamburgerMeal.getHamburger()+","+hamburgerMeal.getSnack());
    }

    @Override
    public void eat(HamburgerMeal hamburgerMeal) {
        System.out.println("饿了！在吃！！！肯打鸡的汉堡套餐，包括："+hamburgerMeal.getDrink()+","
                +hamburgerMeal.getHamburger()+","+hamburgerMeal.getSnack());
    }
}
