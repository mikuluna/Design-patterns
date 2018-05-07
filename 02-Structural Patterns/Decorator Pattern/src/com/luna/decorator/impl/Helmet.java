package com.luna.decorator.impl;

import com.luna.decorator.Player;
import com.luna.decorator.PlayerDecorator;

/**
 * 头盔类
 */
public class Helmet extends PlayerDecorator {
    public Helmet(Player player) {
        super(player);
    }
    @Override
    public String equip(){
        return super.equip()+"+3级头盔";
    }
}
