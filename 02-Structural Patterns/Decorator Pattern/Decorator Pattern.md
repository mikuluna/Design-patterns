# 装饰器模式 (Decorator Pattern)
## 定义
动态地给一个对象添加一些额外的职责。就增加功能来说，Decorator模式相比生成子类更为灵活。（可以看成装饰器模式是一种动态模式的继承）
## 角色
- 抽象构件（Component）角色：给出一个抽象接口，以规范准备接收附加责任的对象。
- 具体构件（Concrete Component）角色：定义一个将要接收附加责任的类。
- 装饰（Decorator）角色：持有一个构件（Component）对象的实例，并实现一个与抽象构件接口一致的接口。
- 具体装饰（Concrete Decorator）角色：负责给构件对象添加上附加的责任。
## 代码
我们依旧以吃鸡为例子。吃鸡人物可以戴头盔Helmet穿防弹衣Vest，他们可以装备kar98k或者十字弩Crossbow或者平底锅Pan
### 抽象吃鸡人物类和抽象装饰器
#### 抽象吃鸡人物类
```
/**
 * 游戏人物
 */
public interface Player {
    /**
     * 装备
     * @return
     */
    public String equip();
}
```
#### 具体吃鸡人物实现类
##### 高端玩家
```
/**
 * 高端玩家类
 */
public class ExpertPlayerImpl implements Player {
    @Override
    public String equip() {
        return "高端玩家";
    }
}
```
##### 盒子玩家
```
/**
 * 盒子玩家
 */
public class BoxesPlayerImpl implements Player {
    @Override
    public String equip() {
        return "盒子玩家";

    }
}

```
#### 抽象装饰器
```
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
```
### 各种装饰器的实现类
#### 头盔Helmet
```
/**
 * 头盔类
 */
public class Helmet extends PlayerDecorator {
    public Helmet(Player player) {
        super(player);
    }
    @Override
    public String equip(){
        return super.equip()+"+3级头盔";
    }
}
```
#### 防弹衣Vest
```
/**
 * 防弹衣
 */
public class Vest extends PlayerDecorator {
    public Vest(Player player) {
        super(player);
    }
    @Override
    public String equip(){
        return super.equip()+"+防弹衣";
    }
}
```
#### kar98k
```
/**
 * kar98k
 */
public class Kar98k extends PlayerDecorator {
    public Kar98k(Player player) {
        super(player);
    }
    @Override
    public String equip(){
        return super.equip()+"+kar98k";
    }
}
```
#### 十字弩Crossbow
```
/**
 * 十字弩
 */
public class Crossbow extends PlayerDecorator {
    public Crossbow(Player player) {
        super(player);
    }
    @Override
    public String equip(){
        return super.equip()+"+十字弩";
    }
}

```
#### 平底锅Pan
```
/**
 * 平底锅
 */
public class Pan extends PlayerDecorator {
    public Pan(Player player) {
        super(player);
    }
    @Override
    public String equip(){
        return super.equip()+"+平底锅";
    }
}

```
### 测试类
```
public class Test {
    public static void main(String[] args) {
        //高端玩家luna装备了头盔+防弹衣+98k
        Player luna = new Helmet(new Vest(new Kar98k(new ExpertPlayerImpl())));
        System.out.println("luna:"+luna.equip());
        //低端玩家zfox49装备了防弹衣+十字弩+平底锅
        Player zfox49 = new Vest(new Crossbow(new Pan(new BoxesPlayerImpl())));
        System.out.println("zfox49:"+zfox49.equip());
    }
}
```
输出：
```
luna:高端玩家+kar98k+防弹衣+3级头盔
zfox49:盒子玩家+平底锅+十字弩+防弹衣
```
## 总结
装饰器像不像就是穿了一件衣服，装备一个枪的意思，它相当于继承的另外一种扩展。
### 装饰器和桥接模式
一直觉得装饰器和桥接模式有点像，下面我们来看看区别吧：
1. 桥接模式中所说的分离，其实是指将结构与实现分离（当结构和实现有可能发生变化时）或属性与基于属性的行为进行分离；而装饰者只是对基于属性的行为进行封闭成独立的类。
2. 桥接中的行为是横向的行为，行为彼此之间无关联；而装饰者模式中的行为具有可叠加性，其表现出来的结果是一个整体，一个各个行为组合后的一个结果。