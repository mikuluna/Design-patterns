package com.luna.facade.test;

import com.luna.facade.FacadeMaker;

/**
 * 客户端（测试类）
 */
public class Client {
    public static void main(String[] args) {
        FacadeMaker facadeMaker = new FacadeMaker();
        //看一下里面的三个宏
        facadeMaker.belly();
        facadeMaker.mirageTank();
        facadeMaker.rookieDisturb();
    }
}
