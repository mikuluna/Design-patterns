# 抽象工厂模式Abstract Factory Pattern
## 定义
 抽象工厂模式提供一个接口，用于创建相关或依赖对象的家族，而不需要明确指定具体类。可以理解成是多个工厂方法的组合。  
 
## 代码解析
由于抽象工厂直接看代码可能会绕晕，所以我写了个背景，还有每段代码的注释都会写的比较详细。   
  
   
**背景**：我们以肯打鸡和麦当鸡为背景，讲述了作者luna去吃午餐的过程。
- 首先肯打鸡和麦当鸡都有两种套餐：汉堡套餐和炸鸡套餐。两种套餐都有两个方法，一个叫order（买），一个叫eat（吃）
- 抽象工厂IFactory可以看做是这一类餐厅的抽象接口，里面会有两个方法，create汉堡套餐和create炸鸡套餐。
- 肯打鸡工厂和麦当鸡工厂分别继承了IFactory
- 最后作者去买了麦当鸡的A套餐。
### 汉堡套餐和炸鸡套餐
model（package）里面包含两个套餐，一个叫汉堡套餐，一个叫炸鸡套餐。  
#### 汉堡套餐
```
/**
 * 汉堡套餐
 */
public class HamburgerMeal {
    String drink;//饮料
    String Hamburger;//汉堡
    String snack;//小吃

    /**
     * 构造器方便之后定套餐里面的东西
     * @param drink
     * @param hamburger
     * @param snack
     */
    public HamburgerMeal(String drink, String hamburger, String snack) {
        this.drink = drink;
        Hamburger = hamburger;
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
        return Hamburger;
    }

    public void setHamburger(String hamburger) {
        Hamburger = hamburger;
    }

    public String getSnack() {
        return snack;
    }

    public void setSnack(String snack) {
        this.snack = snack;
    }
}
```
#### 炸鸡套餐
```
/**
 * 炸鸡套餐
 */
public class FriedChickenMeal {
    String drink;//饮料
    String friedChicken;//炸鸡

    /**
     * 构造器方便之后定套餐里面的东西
     * @param drink
     * @param friedChicken
     */
    public FriedChickenMeal(String drink, String friedChicken) {
        this.drink = drink;
        this.friedChicken = friedChicken;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getFriedChicken() {
        return friedChicken;
    }

    public void setFriedChicken(String friedChicken) {
        this.friedChicken = friedChicken;
    }
}
```
### 汉堡套餐和炸鸡套餐的流程4种实现
product（package）里面包括6个类：2个接口（汉堡套餐操作接口，炸鸡套餐操作接口），4个实现（肯打鸡汉堡/炸鸡套餐以及麦当鸡的汉堡/炸鸡套餐）
汉堡套餐操作接口
```
/**
 * 汉堡套餐操作接口
 */
public interface IHamburgerMeal {
    /**
     * 订汉堡套餐
     * @param hamburgerMeal
     */
    public void order(HamburgerMeal hamburgerMeal);

    /**
     * 吃汉堡套餐
     * @param hamburgerMeal
     */
    public void eat(HamburgerMeal hamburgerMeal);
}
```
炸鸡套餐操作接口
```
/**
 * 炸鸡套餐操作接口
 */
public interface IFriedChickenMeal {
    /**
     * 订炸鸡套餐
     * @param friedChickenMeal
     */
    public void order(FriedChickenMeal friedChickenMeal);

    /**
     * 吃订炸鸡套餐
     * @param friedChickenMeal
     */
    public void eat(FriedChickenMeal friedChickenMeal);
}
```
肯打鸡汉堡套餐
```
/**
 * 肯打鸡汉堡套餐
 */
public class KendaHamburgerMeal implements IHamburgerMeal {
    @Override
    public void order(HamburgerMeal hamburgerMeal) {
        System.out.println("在点餐！肯打鸡的汉堡套餐，包括："+hamburgerMeal.getDrink()+","
                +hamburgerMeal.getHamburger()+","+hamburgerMeal.getSnack());
    }

    @Override
    public void eat(HamburgerMeal hamburgerMeal) {
        System.out.println("饿了！在吃！！！肯打鸡的汉堡套餐，包括："+hamburgerMeal.getDrink()+","
                +hamburgerMeal.getHamburger()+","+hamburgerMeal.getSnack());
    }
}
```
肯打鸡炸鸡套餐
```
/**
 * 肯打鸡炸鸡套餐
 */
public class KendaFriedChickenMeal implements IFriedChickenMeal {
    @Override
    public void order(FriedChickenMeal friedChickenMeal) {
        System.out.println("在点餐！肯打鸡的炸鸡套餐，包括："+friedChickenMeal.getDrink()+","
                +friedChickenMeal.getFriedChicken());
    }

    @Override
    public void eat(FriedChickenMeal friedChickenMeal) {
        System.out.println("饿了！在吃！！！肯打鸡的炸鸡套餐，包括："+friedChickenMeal.getDrink()+","
                +friedChickenMeal.getFriedChicken());
    }
}
```
麦当鸡汉堡套餐
```
/**
 * 麦当鸡汉堡套餐
 */
public class McdonHamburgerMeal implements IHamburgerMeal{
    @Override
    public void order(HamburgerMeal hamburgerMeal) {
        System.out.println("在点餐！麦当鸡的汉堡套餐，包括："+hamburgerMeal.getDrink()+","
                +hamburgerMeal.getHamburger()+","+hamburgerMeal.getSnack());
    }

    @Override
    public void eat(HamburgerMeal hamburgerMeal) {
        System.out.println("饿了！在吃！！！麦当鸡的汉堡套餐，包括："+hamburgerMeal.getDrink()+","
                +hamburgerMeal.getHamburger()+","+hamburgerMeal.getSnack());

    }
}
```
麦当鸡炸鸡套餐
```
/**
 * 麦当鸡炸鸡套餐
 */
public class McdonFriedChickenMeal implements IFriedChickenMeal {

    @Override
    public void order(FriedChickenMeal friedChickenMeal) {
        System.out.println("在点餐！麦当鸡的炸鸡套餐，包括："+friedChickenMeal.getDrink()+","
                +friedChickenMeal.getFriedChicken());
    }

    @Override
    public void eat(FriedChickenMeal friedChickenMeal) {
        System.out.println("饿了！在吃！！！麦当鸡的炸鸡套餐，包括："+friedChickenMeal.getDrink()+","
                +friedChickenMeal.getFriedChicken());

    }
}
```
### !!抽象工厂接口IFactory与麦当鸡工厂和肯打鸡工厂
前面都是铺垫，这里才是抽象工厂的重点！  
IFactory抽象工厂接口
```
/**
 * 抽象工厂接口
 */
public interface IFactory {
    /**
     * 创造汉堡套餐
     * @return
     */
    public IHamburgerMeal createHamburgerMeal();

    /**
     * 创造炸鸡套餐
     * @return
     */
    public IFriedChickenMeal createFriedChickenMeal();
}
```
麦当鸡工厂
```
/**
 * 麦当鸡工厂
 */
public class McdonFactory implements IFactory {
    @Override
    public IHamburgerMeal createHamburgerMeal() {
        return new McdonHamburgerMeal();
    }

    @Override
    public IFriedChickenMeal createFriedChickenMeal() {
        return new McdonFriedChickenMeal();
    }
}
```
肯打鸡工厂
```
/**
 * 肯打鸡工厂
 */
public class KendaFactory implements IFactory{
    @Override
    public IHamburgerMeal createHamburgerMeal() {
        return new KendaHamburgerMeal();
    }

    @Override
    public IFriedChickenMeal createFriedChickenMeal() {
        return new KendaFriedChickenMeal();
    }
}

```
### client可以说是测试类
讲述了作者Luna去吃饭的故事
```
/**
 * 测试类
 */
public class LunaHaveAMeal {
    public static void main(String args[]){
        //1.首先我们来规定汉堡套餐炸鸡套餐分别有什么！
        //汉堡套餐是可乐+牛肉汉堡+炸土豆
        HamburgerMeal hamburgerMeal = new HamburgerMeal("cola","beef burger","chips");
        //炸鸡套餐是可乐+炸鸡腿
        FriedChickenMeal friedChickenMeal = new FriedChickenMeal("cola","fried drumstick");
        //2.这个时候作者来到了麦当鸡
        IFactory factory = new McdonFactory();
        //3.作者想了半天(天秤座没办法)，决定少吃一点（想减肥），就决定是你了，炸鸡套餐！
        IFriedChickenMeal wantedMeal = factory.createFriedChickenMeal();
        //4.作者点餐了哦
        wantedMeal.order(friedChickenMeal);
        //5.作者要饿昏了，吃吃吃！
        wantedMeal.eat(friedChickenMeal);
        //你以为到这就完结了嘛。作者没有吃饱！！！于是打算去买肯打鸡的汉堡套餐！哼！（减肥什么的，不存在的）
        //作者比较懒，剩下的就不写注释了哦~
        IFactory factoryKen = new KendaFactory();
        IHamburgerMeal addMeal = factoryKen.createHamburgerMeal();
        addMeal.order(hamburgerMeal);
        addMeal.eat(hamburgerMeal);
    }
}
```
### 总结
很欢乐的写完了抽象工厂模式。（本故事纯属虚构，作者吃不了那么多的，但是减肥是真的）  
下面我要贴的东西，是别人总结的，关于简单工厂，工厂方法，抽象工厂的区别。
- 简单工厂是一对多的关系 (一个工厂可以生成多个产品)
- 工厂方法是一对一的关系(一个工厂只能生产一个产品)
- 抽象工厂抽象了前面两个设计模式、(一生产线可以生产多个产品可以、多个生产线可以生产一个产品)  

