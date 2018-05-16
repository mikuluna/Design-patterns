package com.luna.flyweight;

import com.luna.flyweight.model.Gun;
import com.luna.flyweight.model.TheBigGuns;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 */
public class FlyweightFactory {
    //共享池
    static Map<String,Gun> guns = new HashMap<String, Gun>();
    public static Gun getGun(String key){
        Gun gun = guns.get(key);
        //如果gun==null,表示不存在,则新建,并且保持到共享池中
        if(gun == null){
            gun = new TheBigGuns(key);
            guns.put(key,gun);
        }
        return gun;
    }
    //获取共享池有多少个对象
    public static int getSize(){
        return guns.size();
    }
}
