package com.luna.bridge.test;

import com.luna.bridge.car.Car;
import com.luna.bridge.car.impl.Buggy;
import com.luna.bridge.car.impl.Uaz;
import com.luna.bridge.road.Road;
import com.luna.bridge.road.impl.Cornfield;
import com.luna.bridge.road.impl.Mountain;

public class TestBridge {
    public static void main(String[] args) {
        //先将车的对象建好
        Car buggy = new Buggy();
        Car uaz = new Uaz();
        //进行各种排列组合
        Road mountainUaz = new Mountain(uaz);
        mountainUaz.inTheRoad();
        Road mountainBuggy = new Mountain(buggy);
        mountainBuggy.inTheRoad();
        Road cornfieldUaz = new Cornfield(uaz);
        cornfieldUaz.inTheRoad();
        Road cornfieldBuggyz = new Cornfield(buggy);
        cornfieldBuggyz.inTheRoad();
    }
}
