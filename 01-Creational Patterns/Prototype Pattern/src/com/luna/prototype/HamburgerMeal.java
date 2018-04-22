package com.luna.prototype;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 汉堡套餐
 */
public class HamburgerMeal implements Cloneable,Serializable{
    private String drink;//饮料
    private String hamburger;//汉堡
    private String snack;//小吃
    private ArrayList<String> seasoningPackets;//调料包
    private Customer customer;//消费者

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

    /**
     * 构造器方便之后定套餐里面的东西
     * @param drink
     * @param hamburger
     * @param snack
     * @param seasoningPackets
     */
    public HamburgerMeal(String drink, String hamburger, String snack, ArrayList<String> seasoningPackets) {
        this.drink = drink;
        this.hamburger = hamburger;
        this.snack = snack;
        this.seasoningPackets = seasoningPackets;
    }

    /**
     * 重写clone()方法
     */
    @Override
    public HamburgerMeal clone() throws CloneNotSupportedException {
//        return (HamburgerMeal)super.clone();
        HamburgerMeal hamburgerMeal = (HamburgerMeal)super.clone();
        hamburgerMeal.customer = (Customer)customer.clone();
        hamburgerMeal.seasoningPackets = (ArrayList<String>)seasoningPackets.clone();
        return hamburgerMeal;
    }

    /**
     * 重写toString方法，方便展示
     * @return
     */
    @Override
    public String toString() {
        return "汉堡套餐包括："+this.drink+","+this.hamburger+","+this.snack+
                this.seasoningPackets.toString()+this.customer.toString();
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
    public ArrayList<String> getSeasoningPackets() {
        return seasoningPackets;
    }

    public void setSeasoningPackets(ArrayList<String> seasoningPackets) {
        this.seasoningPackets = seasoningPackets;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

