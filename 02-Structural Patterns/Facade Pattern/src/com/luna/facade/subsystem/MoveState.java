package com.luna.facade.subsystem;

/**
 * 前进操作（前进，后退）
 */
public class MoveState {
    /**
     * 前进
     */
    public void goForward(){
        System.out.println("正在前进");
    }

    /**
     * 后退
     */
    public void moveBack(){
        System.out.println("正在后退");
    }
}
