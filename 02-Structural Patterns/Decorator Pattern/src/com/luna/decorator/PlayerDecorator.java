package com.luna.decorator;

/**
 * 抽象PlayerDecorator类（装饰器的父类）
 */
public abstract class PlayerDecorator implements Player {
    private Player player;
    public PlayerDecorator(Player player){
        this.player = player;
    }
    @Override
    public String equip() {
        return player.equip();
    }
}
