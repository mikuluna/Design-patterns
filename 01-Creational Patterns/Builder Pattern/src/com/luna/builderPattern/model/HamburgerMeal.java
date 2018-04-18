package com.luna.builderPattern.model;

/**
 * 汉堡套餐
 */
public class HamburgerMeal {
    String drink;//饮料
    String hamburger;//汉堡
    String snack;//小吃

    public HamburgerMeal(){}
    /**
     * 构造器方便之后定套餐里面的东西
     * @param drink
     * @param hamburger
     * @param snack
     */
    public HamburgerMeal(String drink, String hamburger, String snack) {
        this.drink = drink;
        this.hamburger = hamburger;
        this.snack = snack;
    }

    //将所有的getter和setter方法写好


    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getHamburger() {
        return hamburger;
    }

    public void setHamburger(String hamburger) {
        this.hamburger = hamburger;
    }

    public String getSnack() {
        return snack;
    }

    public void setSnack(String snack) {
        this.snack = snack;
    }
}
