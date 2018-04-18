package com.luna.builderPattern.builder;

import com.luna.builderPattern.model.HamburgerMeal;

/**
 * 准备汉堡套餐的过程
 */
public abstract class Builder {
    //准备饮料
    public abstract void BuildDrink();
    //准备主食
    public abstract void BuildHamburger();
    //准备小吃
    public abstract void BuildSnack();
    //获取结果
    public abstract HamburgerMeal getHamburgerMeal();

}
