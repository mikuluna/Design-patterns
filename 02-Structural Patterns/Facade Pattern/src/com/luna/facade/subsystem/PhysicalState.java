package com.luna.facade.subsystem;

/**
 * 角色状态（蹲下，站立，趴着）
 */
public class PhysicalState {
    /**
     * 蹲下
     */
    public void crouch(){
        System.out.print("正在蹲下");
    }
    /**
     * 站立
     */
    public void stand(){
        System.out.println("正在站立");
    }
    /**
     * 趴着
     */
    public void prone(){
        System.out.println("正在趴着");
    }
}
