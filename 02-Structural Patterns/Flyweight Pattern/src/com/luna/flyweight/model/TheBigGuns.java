package com.luna.flyweight.model;

/**
 * 大枪（非手枪）
 */
public class TheBigGuns extends Gun {
    private String gunName;
    public TheBigGuns(String gunName) {
        this.gunName = gunName;
    }

    @Override
    public void getGun() {
        System.out.println("获得了"+gunName+"这把非手枪");
    }
}
