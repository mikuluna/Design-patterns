package com.luna.composite;

public class Test {
    public static void main(String[] args) {
        //吃鸡的luna
        Component luna = new Player("luna","women");
        //第二的xuan和他的队友miku
        Component xuan = new Player("xuan","women");
        Component miku = new Player("miku","women");
        //低端盒子玩家tom和他的队友bug
        Component tom = new LeafPlayer("tom","man");
        Component bug  = new LeafPlayer("bug","man");
        //luna杀死了xuan和miku
        luna.killPlayer(xuan);
        luna.killPlayer(miku);
        //miku杀死了tom
        miku.killPlayer(tom);
        //xuan杀死了bug
        xuan.killPlayer(bug);
        luna.printKillPlayer(0);
    }
}
