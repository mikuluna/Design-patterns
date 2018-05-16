package com.luna.facade;

import com.luna.facade.subsystem.MoveState;
import com.luna.facade.subsystem.PhysicalState;
import com.luna.facade.subsystem.StateOfGuns;

/**
 * 招式(可以理解为游戏里面玩家定义的宏)
 */
public class FacadeMaker {
    private PhysicalState physicalState;
    private StateOfGuns stateOfGuns;
    private MoveState moveState;

    public FacadeMaker() {
        physicalState = new PhysicalState();
        stateOfGuns = new StateOfGuns();
        moveState = new MoveState();
    }

    /**
     * 趴着进毒圈（趴着拿枪前进）
     */
    public void belly(){
        System.out.println("趴着进毒圈宏：");
        physicalState.prone();
        stateOfGuns.gotAGun();
        moveState.goForward();
        System.out.println("=================");
    }
    /**
     * 菜鸡打扰招式（站立收枪后退）
     */
    public void rookieDisturb(){
        System.out.println("菜鸡打扰宏：");
        physicalState.stand();
        stateOfGuns.collectTheGun();
        moveState.moveBack();
        System.out.println("=================");
    }
    /**
     * 幻影坦克招式（蹲下拿枪）
     */
    public void mirageTank(){
        System.out.println("幻影坦克宏：");
        physicalState.crouch();
        stateOfGuns.gotAGun();
        System.out.println("=================");
    }
}
