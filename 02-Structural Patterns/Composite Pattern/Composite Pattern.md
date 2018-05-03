# 组合模式（Composite Pattern）
## 定义
组合模式可以理解为一种树结构。
### 组合模式三要素
1. 抽象构件角色Component：它为组合中的对象声明接口，也可以为共有接口实现缺省行为。
2. 树叶构件角色Leaf：在组合中表示叶节点对象——没有子节点，实现抽象构件角色声明的接口。
3. 树枝构件角色Composite：在组合中表示分支节点对象——有子节点，实现抽象构件角色声明的接口；存储子部件。
## 代码
### Component接口
```
/**
 * 提供了add方法，输出方法。但是不给任何操作
 */
public abstract class Component {
    public  void killPlayer(Component player){

    }
    public abstract void printKillPlayer(int depth);
}
```
### 玩家类
```
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
```
### 低端盒子玩家类
```
/**
 * 低端盒子玩家
 */
public class LeafPlayer extends Component{
    private String name;
    private String sex;

    public LeafPlayer(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    //打印出结构
    @Override
    public void printKillPlayer(int depth) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(new String(sb) + this.getName());
    }
}
```
### Test
```
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
```
输出结果：
```
luna
--xuan
----bug
--miku
----tom
```

## 总结
### 我的理解
组合模式就是在一个Composite里面放自己的List,并且可以向自己的List添加子类,最底层用Leaf,因为Leaf里面没有List，可以不浪费资源。  
输出采用递归的形式。循环List每一个元素，并且调用每个元素的print方法，依次递归下去，直到没有子元素。  
### 什么时候用组合模式？
当发现需求中是体现部分与整体层次结构时，以及你希望用户可以忽略组合对象与单个对象的不同，统一地使用组合结构中的所有对象时，就应该考虑组合模式了。  