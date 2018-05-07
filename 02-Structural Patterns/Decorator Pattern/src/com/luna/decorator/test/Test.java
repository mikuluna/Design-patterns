package com.luna.decorator.test;

import com.luna.decorator.Player;
import com.luna.decorator.impl.*;

public class Test {
    public static void main(String[] args) {
        //高端玩家luna装备了头盔+防弹衣+98k
        Player luna = new Helmet(new Vest(new Kar98k(new ExpertPlayerImpl())));
        System.out.println("luna:"+luna.equip());
        //低端玩家zfox49装备了防弹衣+十字弩+平底锅
        Player zfox49 = new Vest(new Crossbow(new Pan(new BoxesPlayerImpl())));
        System.out.println("zfox49:"+zfox49.equip());
    }
}
