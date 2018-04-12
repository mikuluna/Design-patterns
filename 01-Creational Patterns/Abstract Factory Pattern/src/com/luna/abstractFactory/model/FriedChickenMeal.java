package com.luna.abstractFactory.model;

/**
 * 炸鸡套餐
 */
public class FriedChickenMeal {
    String drink;//饮料
    String friedChicken;//炸鸡

    /**
     * 构造器方便之后定套餐里面的东西
     * @param drink
     * @param friedChicken
     */
    public FriedChickenMeal(String drink, String friedChicken) {
        this.drink = drink;
        this.friedChicken = friedChicken;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getFriedChicken() {
        return friedChicken;
    }

    public void setFriedChicken(String friedChicken) {
        this.friedChicken = friedChicken;
    }
}
