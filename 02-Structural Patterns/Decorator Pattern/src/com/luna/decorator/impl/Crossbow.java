package com.luna.decorator.impl;

import com.luna.decorator.Player;
import com.luna.decorator.PlayerDecorator;

/**
 * 十字弩
 */
public class Crossbow extends PlayerDecorator {
    public Crossbow(Player player) {
        super(player);
    }
    @Override
    public String equip(){
        return super.equip()+"+十字弩";
    }
}
