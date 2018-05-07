package com.luna.decorator.impl;

import com.luna.decorator.Player;
import com.luna.decorator.PlayerDecorator;

/**
 * 平底锅
 */
public class Pan extends PlayerDecorator {
    public Pan(Player player) {
        super(player);
    }
    @Override
    public String equip(){
        return super.equip()+"+平底锅";
    }
}
