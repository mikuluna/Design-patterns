package com.luna.builderPattern.builder.impl;

import com.luna.builderPattern.builder.Builder;
import com.luna.builderPattern.model.HamburgerMeal;

/**
 * 配餐员（我会准备）
 */
public class ConcreteBuilder extends Builder{
    //汉堡套餐实例
    HamburgerMeal hamburgerMeal = new HamburgerMeal();

    //准备可乐
    @Override
    public void BuildDrink() {
        hamburgerMeal.setDrink("cola");
        System.out.println("正在准备"+hamburgerMeal.getDrink());
    }
    //准备牛肉汉堡
    @Override
    public void BuildHamburger() {
        hamburgerMeal.setHamburger("beef burger");
        System.out.println("正在准备"+hamburgerMeal.getHamburger());
    }
    //准备炸土豆
    @Override
    public void BuildSnack() {
        hamburgerMeal.setSnack("chips");
        System.out.println("正在准备"+hamburgerMeal.getSnack());
    }
    //获取套餐
    @Override
    public HamburgerMeal getHamburgerMeal(){
        System.out.println("获得汉堡套餐："+hamburgerMeal.getDrink()+","
                +hamburgerMeal.getHamburger()+","+hamburgerMeal.getSnack());
        return hamburgerMeal;
    }
}
