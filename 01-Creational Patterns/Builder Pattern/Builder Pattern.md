# 建造者模式（Builder Pattern）
## 定义
将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示  
Builder表示一个过程的分解，比如你去银行取钱：1.先要去拿好，2.然后去柜台办理手续，3.最后拿到钱。我们把这三个步骤分别作为方法放在Builder里面，这样是不是就比较好理解了呢？
## 代码解析
我们就之前作者去麦肯基吃饭的故事的延续的例子。  
- 在作者吃肯打鸡的汉堡套餐的点餐过程中（背景），点餐（Client）之后
- 点餐员会通知配餐员去配餐（Builder和ConcreteBuilder）[“你要准备可乐牛肉汉堡还有炸土豆这三样东西”]
- 配餐过程包括**先**可乐**然后**牛肉汉堡**最后**炸土豆的准备（Director）
- 最后作者获得了汉堡套餐（Product）
### Product汉堡套餐实体类
```
/**
 * 汉堡套餐
 */
public class HamburgerMeal {
    String drink;//饮料
    String hamburger;//汉堡
    String snack;//小吃

    public HamburgerMeal(){}
    /**
     * 构造器方便之后定套餐里面的东西
     * @param drink
     * @param hamburger
     * @param snack
     */
    public HamburgerMeal(String drink, String hamburger, String snack) {
        this.drink = drink;
        this.hamburger = hamburger;
        this.snack = snack;
    }

    //将所有的getter和setter方法写好


    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getHamburger() {
        return hamburger;
    }

    public void setHamburger(String hamburger) {
        this.hamburger = hamburger;
    }

    public String getSnack() {
        return snack;
    }

    public void setSnack(String snack) {
        this.snack = snack;
    }
}
```
### 准备的过程(无关顺序)Builder和实现类ConcreteBuilder
#### 准备汉堡套餐的过程Builder
```
/**
 * 准备汉堡套餐的过程
 */
public abstract class Builder {
    //准备饮料
    public abstract void BuildDrink();
    //准备主食
    public abstract void BuildHamburger();
    //准备小吃
    public abstract void BuildSnack();
    //获取结果
    public abstract HamburgerMeal getHamburgerMeal();

}
```
#### Builder的实现类配餐员ConcreteBuilder
```
/**
 * 配餐员（我会准备）
 */
public class ConcreteBuilder extends Builder{
    //汉堡套餐实例
    HamburgerMeal hamburgerMeal = new HamburgerMeal();

    //准备可乐
    @Override
    public void BuildDrink() {
        hamburgerMeal.setDrink("cola");
        System.out.println("正在准备"+hamburgerMeal.getDrink());
    }
    //准备牛肉汉堡
    @Override
    public void BuildHamburger() {
        hamburgerMeal.setHamburger("beef burger");
        System.out.println("正在准备"+hamburgerMeal.getHamburger());
    }
    //准备炸土豆
    @Override
    public void BuildSnack() {
        hamburgerMeal.setSnack("chips");
        System.out.println("正在准备"+hamburgerMeal.getSnack());
    }
    //获取套餐
    @Override
    public HamburgerMeal getHamburgerMeal(){
        System.out.println("获得汉堡套餐："+hamburgerMeal.getDrink()+","
                +hamburgerMeal.getHamburger()+","+hamburgerMeal.getSnack());
        return hamburgerMeal;
    }
}

```
### （有关顺序）准备套餐具体顺序Director
```
/**
 * 指派者（你要按照一定顺序去执行Builder）
 */
public class Director {
    HamburgerMeal hamburgerMeal;
    //配餐执行的过程
    public void construct(Builder builder){
        builder.BuildDrink();
        builder.BuildHamburger();
        builder.BuildSnack();
    }
}
```
### Client点餐的全步骤（Test）
```
/**
 * 测试类
 */
public class Client {
    public static void main(String args[]){
        //我到了麦当鸡，要点餐，将我想要的给了点餐员和派餐员
        Director director = new Director();
        Builder builder = new ConcreteBuilder();
        //派餐员给我准备过程
        director.construct(builder);
        //我获得的汉堡套餐
        HamburgerMeal hamburgerMeal = builder.getHamburgerMeal();

    }
}
```
输出：
正在准备cola  
正在准备beef burger  
正在准备chips  
获得汉堡套餐：cola,beef burger,chips  
## 总结
建造者模式其实就讲了几个东西Builder、ConcreteBuilder、Director以及Product  
- Builder：接口，过程的分解（你要做些什么事），方法的集，最终获得一个Product
- ConcreteBuilder：Builder的具体实现类
- Director：你要以一个什么顺序去执行Builder的方法
- Product：从Builder获得的Product


