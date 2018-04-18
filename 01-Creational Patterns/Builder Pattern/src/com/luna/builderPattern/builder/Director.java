package com.luna.builderPattern.builder;

import com.luna.builderPattern.model.HamburgerMeal;

/**
 * 指派者（你要按照一定顺序去执行Builder）
 */
public class Director {
    HamburgerMeal hamburgerMeal;
    //配餐执行的过程
    public void construct(Builder builder){
        builder.BuildDrink();
        builder.BuildHamburger();
        builder.BuildSnack();
    }
}
