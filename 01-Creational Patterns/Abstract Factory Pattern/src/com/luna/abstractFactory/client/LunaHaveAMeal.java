package com.luna.abstractFactory.client;

import com.luna.abstractFactory.factory.IFactory;
import com.luna.abstractFactory.factory.impl.KendaFactory;
import com.luna.abstractFactory.factory.impl.McdonFactory;
import com.luna.abstractFactory.model.FriedChickenMeal;
import com.luna.abstractFactory.model.HamburgerMeal;
import com.luna.abstractFactory.product.IFriedChickenMeal;
import com.luna.abstractFactory.product.IHamburgerMeal;

/**
 * 测试类
 */
public class LunaHaveAMeal {
    public static void main(String args[]){
        //1.首先我们来规定汉堡套餐炸鸡套餐分别有什么！
        //汉堡套餐是可乐+牛肉汉堡+炸土豆
        HamburgerMeal hamburgerMeal = new HamburgerMeal("cola","beef burger","chips");
        //炸鸡套餐是可乐+炸鸡腿
        FriedChickenMeal friedChickenMeal = new FriedChickenMeal("cola","fried drumstick");
        //2.这个时候作者来到了麦当鸡
        IFactory factory = new McdonFactory();
        //3.作者想了半天(天秤座没办法)，决定少吃一点（想减肥），就决定是你了，炸鸡套餐！
        IFriedChickenMeal wantedMeal = factory.createFriedChickenMeal();
        //4.作者点餐了哦
        wantedMeal.order(friedChickenMeal);
        //5.作者要饿昏了，吃吃吃！
        wantedMeal.eat(friedChickenMeal);
        //你以为到这就完结了嘛。作者没有吃饱！！！于是打算去买肯打鸡的汉堡套餐！哼！（减肥什么的，不存在的）
        //作者比较懒，剩下的就不写注释了哦~
        IFactory factoryKen = new KendaFactory();
        IHamburgerMeal addMeal = factoryKen.createHamburgerMeal();
        addMeal.order(hamburgerMeal);
        addMeal.eat(hamburgerMeal);
    }
}
