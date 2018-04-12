package com.luna.abstractFactory.factory.impl;

import com.luna.abstractFactory.factory.IFactory;
import com.luna.abstractFactory.product.IFriedChickenMeal;
import com.luna.abstractFactory.product.IHamburgerMeal;
import com.luna.abstractFactory.product.impl.KendaFriedChickenMeal;
import com.luna.abstractFactory.product.impl.KendaHamburgerMeal;

/**
 * 肯打鸡工厂
 */
public class KendaFactory implements IFactory{
    @Override
    public IHamburgerMeal createHamburgerMeal() {
        return new KendaHamburgerMeal();
    }

    @Override
    public IFriedChickenMeal createFriedChickenMeal() {
        return new KendaFriedChickenMeal();
    }
}
