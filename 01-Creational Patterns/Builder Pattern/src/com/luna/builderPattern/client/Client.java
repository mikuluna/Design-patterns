package com.luna.builderPattern.client;

import com.luna.builderPattern.builder.Builder;
import com.luna.builderPattern.builder.Director;
import com.luna.builderPattern.builder.impl.ConcreteBuilder;
import com.luna.builderPattern.model.HamburgerMeal;

/**
 * 测试类
 */
public class Client {
    public static void main(String args[]){
        //我到了麦当鸡，要点餐，将我想要的给了点餐员和派餐员
        Director director = new Director();
        Builder builder = new ConcreteBuilder();
        //派餐员给我准备过程
        director.construct(builder);
        //我获得的汉堡套餐
        HamburgerMeal hamburgerMeal = builder.getHamburgerMeal();

    }
}
