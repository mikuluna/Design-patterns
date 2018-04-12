# 工厂模式Factory Pattern
## 定义
 工厂模式定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
 它提供了一种创建对象的最佳方式。
## 代码解析
### 水果父类
```
package com.luna.factory;

/**
 * 水果父类
 */
public abstract class Fruit {
    /**
     * 展示是哪种水果 
     */
    public abstract void show();
}

```
### Apple,Banana,Orange类
```
/**
 * 苹果类
 */
public class Apple extends Fruit {
    @Override
    public void show() {
        System.out.println("I am an apple");
    }
}

```

```
/**
 * 香蕉类
 */
public class Banana extends Fruit {

    @Override
    public void show() {
        System.out.println("I am a banana");
    }
}

```

```
/**
 * 橘子类
 */
public class Orange extends Fruit {

    @Override
    public void show() {
        System.out.println("I am an orange");
    }
}
```
### FruitStore和它的实现类FruitFactory
```
/**
 * 水果商店
 */
public abstract  class FruitStore {
    public Fruit orderFruit(String type) {
        Fruit fruit = this.createFruit(type);
        return fruit;
    }
    public abstract Fruit createFruit(String type);
}

```

```
public class FruitFactory extends FruitStore {

    @Override
    public Fruit createFruit(String type) {
        Fruit fruit = null;
        if(type.equals("Apple")){
            fruit = new Apple();
        }
        else if(type.equals("Orange")){
            fruit = new Orange();
        }
        else if(type.equals("Banana")){
            fruit = new Banana();
        }
        return fruit;
    }
}
```
### 测试类
```
public class TestFactory {
    public static void main(String args[]){
        FruitStore fruitFactory = new FruitFactory();
        Fruit fruit = fruitFactory.orderFruit("Apple");
        fruit.show();
    }
}
```
## 与反射的结合
当然我们也可以改写一下水果工厂那个类
```
/**
 * 水果工厂
 */
public class FruitFactory extends FruitStore {
    @Override
    public Fruit createFruit(String type) throws Exception {
      Class<?> cls = Class.forName(type);
        Object obj = cls.newInstance();
        return (Fruit) obj;
    }
} 
```
## 现实运用
spring中ApplicationContext及子类的对于工厂方法的使用
![](https://github.com/mikuluna/Design-patterns/raw/master/img/gongchang.png)
## 补充（简单工厂与工厂方法）
上述代码与反射结合之前，是一个简单工厂形式。（劣势在于，新增一个水果都要每次去改工厂）  
所以！就出现了工厂方法！那么他们有什么区别呢？其实只用记住一句话就行了：**工厂方法比起简单工厂的优势在于新增不用修改Factory！**也就是所谓的**开-闭原则**  
这时我们又会有一个疑问，工厂方法需要怎么来实现呢？
其实很简单。就是把Apple、Banana和Orange分别作为一个工厂的实现。（**原FruitFactory变成了AppleFactory、BananaFactory和OrangeFactory**）  
### AppleFactory、BananaFactory和OrangeFactory
FruitStore修改一下
```
public abstract  class FruitStore {
    public Fruit orderFruit() {
        Fruit fruit = this.createFruit();
        return fruit;
    }
    public abstract Fruit createFruit();
}

```
AppleFactory
```
public class AppleFactory extends FruitStore {
    @Override
    public Fruit createFruit() {
        Fruit fruit = new Apple();
        return fruit
    }
}
```
BananaFactory
```
public class BananaFactory extends FruitStore {
    @Override
    public Fruit createFruit() {
        Fruit fruit = new Banana();
        return fruit
    }
}
```
OrangeFactory
```
public class OrangeFactory extends FruitStore {
    @Override
    public Fruit createFruit() {
        Fruit fruit = new Orange();
        return fruit
    }
}
```
### 测试类
```
public class TestFactory {
    public static void main(String args[]){
        FruitStore fruitFactory = new AppleFactory();
        Fruit fruit = fruitFactory.orderFruit();
        fruit.show();
    }
}
```
### 总结
这样是不是看出来简单工厂和工厂方法的区别了吗？按照我的理解。**工厂方法比较笨重，但是比起简单工厂可以不断的新加，然而简单工厂新加产品比较麻烦，还需要去改工厂类（违反了开-闭原则）**。  
但是**简单工厂+反射** 是不是可以说是简单工厂与工厂方法的最优解~
