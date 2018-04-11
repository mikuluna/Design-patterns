# 工厂模式Factory Pattern
## 定义
 工厂方法模式定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
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
        Fruit fruit = fruitFactory.createFruit("Apple");
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
![ApplicationContext]("https://github.com/mikuluna/Design-patterns/raw/master/img/gongchang.png")
