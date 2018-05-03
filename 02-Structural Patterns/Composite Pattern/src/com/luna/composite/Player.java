package com.luna.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 玩家类
 */
public class Player extends Component {
    private String name;
    private String sex;
    private List<Component> playerList;

    public Player(String name, String sex) {
        this.name = name;
        this.sex = sex;
        playerList = new ArrayList<Component>();
    }
    public List<Component> getPlayerList() {
        return playerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //游戏中杀死了对方
    @Override
    public void killPlayer(Component player){
        playerList.add(player);
    }

    //打印出结构
    @Override
    public void printKillPlayer(int depth){
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(new String(sb) + this.getName());
        //递归调用子类的此方法，并且递归一次多输出一个“--”，直到没有了子集
        for(Component player:playerList){
            player.printKillPlayer(depth + 2);
        }

    }

}
