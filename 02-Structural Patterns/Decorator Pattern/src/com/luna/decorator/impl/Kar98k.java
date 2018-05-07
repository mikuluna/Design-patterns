package com.luna.decorator.impl;

import com.luna.decorator.Player;
import com.luna.decorator.PlayerDecorator;

/**
 * kar98k
 */
public class Kar98k extends PlayerDecorator {
    public Kar98k(Player player) {
        super(player);
    }
    @Override
    public String equip(){
        return super.equip()+"+kar98k";
    }
}
