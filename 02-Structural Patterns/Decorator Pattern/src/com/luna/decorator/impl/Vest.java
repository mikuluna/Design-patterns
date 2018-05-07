package com.luna.decorator.impl;

import com.luna.decorator.Player;
import com.luna.decorator.PlayerDecorator;

/**
 * 防弹衣
 */
public class Vest extends PlayerDecorator {
    public Vest(Player player) {
        super(player);
    }
    @Override
    public String equip(){
        return super.equip()+"+防弹衣";
    }
}
