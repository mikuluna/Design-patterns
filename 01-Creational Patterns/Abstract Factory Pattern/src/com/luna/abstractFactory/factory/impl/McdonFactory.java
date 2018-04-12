package com.luna.abstractFactory.factory.impl;

import com.luna.abstractFactory.factory.IFactory;
import com.luna.abstractFactory.product.IFriedChickenMeal;
import com.luna.abstractFactory.product.IHamburgerMeal;
import com.luna.abstractFactory.product.impl.McdonFriedChickenMeal;
import com.luna.abstractFactory.product.impl.McdonHamburgerMeal;

/**
 * 麦当鸡工厂
 */
public class McdonFactory implements IFactory {
    @Override
    public IHamburgerMeal createHamburgerMeal() {
        return new McdonHamburgerMeal();
    }

    @Override
    public IFriedChickenMeal createFriedChickenMeal() {
        return new McdonFriedChickenMeal();
    }
}
