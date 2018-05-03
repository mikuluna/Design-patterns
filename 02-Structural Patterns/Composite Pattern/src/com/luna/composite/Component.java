package com.luna.composite;


/**
 * 提供了add方法，输出方法。但是不给任何操作
 */
public abstract class Component {
    public  void killPlayer(Component player){

    }
    public abstract void printKillPlayer(int depth);
}
