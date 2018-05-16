package com.luna.flyweight.test;

import com.luna.flyweight.FlyweightFactory;
import com.luna.flyweight.model.Gun;

/**
 * 客户类(Test)
 */
public class Client {
    public static void main(String[] args) {
        //玩家luna一开始捡了UMP9,M16A4
        Gun firstGun = FlyweightFactory.getGun("UMP9");
        firstGun.getGun();
        Gun secondGun = FlyweightFactory.getGun("M16A4");
        secondGun.getGun();
        //又捡了Kar98k和M4A1然后就换了枪
        Gun thirdGun = FlyweightFactory.getGun("Kar98k");
        thirdGun.getGun();
        Gun forthGun = FlyweightFactory.getGun("M4A1");
        forthGun.getGun();
        // 最后(再捡一次UMP9)觉得还是要把M4A1换成UMP9。
        Gun fifthGun = FlyweightFactory.getGun("UMP9");
        fifthGun.getGun();
        System.out.println("一共捡了"+FlyweightFactory.getSize()+"把非手枪");
    }
}
