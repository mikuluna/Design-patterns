# 桥接模式（Bridge Pattern）
## 定义
桥接模式（Bridge Pattern），将抽象部分与它的实现部分分离，使它们都可以独立地变化。  
按照我的理解，桥接模式是将一个整体分成一块一块的，从而可以形成各种排列组合。  
比如一个充电器，可以有多种充电头和多种线，排列组成了一个我们要的充电器。我们把充电头放在一个抽象类，线放在一个抽象类，具体实现之后，再进行排列组合即可。  
桥接模式很明显就是为了解耦！
## 代码
我们依旧以吃鸡为例。三蹦子Buggy和吉普Uaz都可以行驶在麦田Cornfield或者山地Mountain
### 车
#### 抽象车
```
/**
 * 抽象车
 */
public abstract class Car {
    /**
     * 获取车名
     */
    public abstract void getCarName();

}
```
#### 三蹦子Buggy
```
/**
 * 三蹦子
 */
public class Buggy extends Car {
    @Override
    public void getCarName() {
        System.out.print("三蹦子");
    }
}
```
#### 吉普Uaz
```
/**
 * 吉普
 */
public class Uaz extends Car {
    @Override
    public void getCarName() {
        System.out.print("吉普车");
    }
}

```
### 路
#### 路抽象
```
/**
 * 路抽象
 */
public abstract class Road {
    protected Car car;

    /**
     * 构造函数，方便传入car
     */
    public Road(Car car) {
        this.car = car;
    }

    /**
     * 车行驶在哪条路上
     */
    public abstract void inTheRoad();
}
```
#### 麦田Cornfield
```
/**
 * 麦田类
 */
public class Cornfield extends Road {
    public Cornfield(Car car){
        super(car);
    }
    @Override
    public void inTheRoad() {
        car.getCarName();
        System.out.println("在麦田行驶");

    }
}
```
#### 山地Mountain
```
/**
 * 山地类
 */
public class Mountain extends Road {
    public Mountain(Car car){
        super(car);
    }
    @Override
    public void inTheRoad() {
        car.getCarName();
        System.out.println("在山地行驶");

    }
}
```
### 测试类（排列组合）
```
public class TestBridge {
    public static void main(String[] args) {
        //先将车的对象建好
        Car buggy = new Buggy();
        Car uaz = new Uaz();
        //进行各种排列组合
        Road mountainUaz = new Mountain(uaz);
        mountainUaz.inTheRoad();
        Road mountainBuggy = new Mountain(buggy);
        mountainBuggy.inTheRoad();
        Road cornfieldUaz = new Cornfield(uaz);
        cornfieldUaz.inTheRoad();
        Road cornfieldBuggyz = new Cornfield(buggy);
        cornfieldBuggyz.inTheRoad();
    }
}

```
输出：  
吉普车在山地行驶  
三蹦子在山地行驶  
吉普车在麦田行驶  
三蹦子在麦田行驶  
## 总结
- 如果一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性，避免在两个层次之间建立静态的联系。
- 抽象化角色和具体化角色都应该可以被子类扩展。在这种情况下，桥接模式可以灵活地组合不同的抽象化角色和具体化角色，并独立化地扩展。
- 设计要求实现化角色的任何改变不应当影响客户端，或者说实现化角色的改变对客户端是完全透明的。
### 桥接模式适用于  
1. 你不希望在抽象和它的实现部分之间有一个固定的绑定关系。例如这种情况可能是因为，在程序运行时刻实现部分应可以被选择或者切换。
2. 类的抽象以及它的实现都应该可以通过生成子类的方法加以扩充。
3. 对一个抽象的实现部分的修改应对客户不产生影响，即客户的代码不必重新编译。
4. 正如在意图一节的第一个类图中所示的那样，有许多类要生成。这样一种类层次结构说明你必须将一个对象分解成两个部分
5. 你想在多个对象间共享实现（可能使用引用计数），但同时要求客户并不知道这一点。

    