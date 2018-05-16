package com.luna.facade.subsystem;

/**
 * 枪支状态（拿枪，收枪）
 */
public class StateOfGuns {
    /**
     * 拿枪
     */
    public void gotAGun(){
        System.out.println("正在拿枪");
    }

    /**
     * 收枪
     */
    public void collectTheGun(){
        System.out.println("正在收枪");
    }
}
