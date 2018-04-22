package com.luna.prototype;

import java.util.ArrayList;

public class TestShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        //1.一个HamburgerMeal对象我们称为Luna的汉堡套餐
        HamburgerMeal hamburgerMealForLuna = new HamburgerMeal("cola","beef burger","chips");
        ArrayList<String> seasoningPackets = new ArrayList<String>();
        seasoningPackets.add("辣椒包");
        seasoningPackets.add("宫保酱");
        seasoningPackets.add("川味酱");
        hamburgerMealForLuna.setSeasoningPackets(seasoningPackets);
        Customer customerLuna = new Customer("luna","20");
        hamburgerMealForLuna.setCustomer(customerLuna);
        System.out.println("Luna:"+hamburgerMealForLuna.toString());
        System.out.println("===========================================");
        //2.克隆一下，称为Miku的汉堡套餐,并且直接修改name
        System.out.println("！！！克隆并直接改变Customer对象里面的name！！！！");
        HamburgerMeal hamburgerMealForMiku = hamburgerMealForLuna.clone();
        hamburgerMealForMiku.getCustomer().setName("miku");//浅拷贝的弊端
        System.out.println("Luna:"+hamburgerMealForLuna.toString());
        System.out.println("Miku:"+hamburgerMealForMiku.toString());
        //问题来了！！！name全部变成了miku!!!!!!!!(！！！这就是浅拷贝！！！)
        System.out.println("***************************************");
        //2.extend我们new一个对象呢？
        System.out.println("！！！克隆并new一个Customer对象放进去！！！！");
        Customer customerMiku = new Customer("miku","10");
        hamburgerMealForMiku.setCustomer(customerMiku);
        System.out.println("Luna:"+hamburgerMealForLuna.toString());
        System.out.println("Miku:"+hamburgerMealForMiku.toString());
        //miku变成了我们需要的，为什么？因为对象的引用！！！（是不是想起了equals和==的区别）
        System.out.println("===========================================");
        //3.这个时候如果改变miku的汉堡套餐其他的东西会怎么样呢？
        //3.1修改一个String类型呢：
        System.out.println("！！！修改克隆的String类型！！！！");
        hamburgerMealForMiku.setDrink("milk");
        System.out.println("Luna(change Miku drink):"+hamburgerMealForLuna.toString());
        System.out.println("Miku(change Miku drink):"+hamburgerMealForMiku.toString());
        System.out.println("===========================================");
        //这里变化了，说明String并不在影响范围
        //3.2修改一个ArrayList对象呢。
        //3.2.1直接对原来的ArrayList进行增删改
        System.out.println("！！！直接修改ArrayList，即去掉index:0！！！！");
        hamburgerMealForMiku.getSeasoningPackets().remove(0);
        System.out.println("Luna(change Miku drink):"+hamburgerMealForLuna.toString());
        System.out.println("Miku(change Miku drink):"+hamburgerMealForMiku.toString());
        System.out.println("===========================================");
        //3.2.2新建一个调料包对象
        System.out.println("！！！new一个ArrayList，放入克隆的对象里面！！！！");
        ArrayList<String> seasoningPacketsNew = new ArrayList<String>();
        seasoningPacketsNew.add("酸甜酱");
        seasoningPacketsNew.add("宫保酱");
        hamburgerMealForMiku.setSeasoningPackets(seasoningPacketsNew);
        System.out.println("Luna(change Miku SeasoningPackets):"+hamburgerMealForLuna.toString());
        System.out.println("Miku(change Miku SeasoningPackets):"+hamburgerMealForMiku.toString());
    }
}
