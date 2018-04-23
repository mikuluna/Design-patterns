# 适配器模式（Adapter Pattern）
## 定义
适配器模式把一个类的接口变成客户端所期待的另一种接口，从而使原本接口不匹配而无法一起工作的两个类能够在一起工作。  
适配器包括：类适配器、对象适配器  
## 类适配器
我们以当前最火的游戏——吃鸡为例子来给大家讲解的一下适配器模式。
### 被适配者（Adaptee）
```
/**
 * 枪接口(被适配者Adaptee)
 */
public interface Gun {
    /**
     * 射击方法
     */
    public void shooting();
}
```
```
/**
 * 被适配者的实现
 * 98k类
 */
public class Kar98k implements Gun {
    @Override
    public void shooting() {
        System.out.println("98K在射击……………");
    }
}
```
### 类适配器
```
/**
 * 新型98k又可以射击，又可以敲打人
 */
public class AdapterClassKar98k extends Kar98k implements Appliance {
    @Override
    public void hiting() {
        System.out.println("新型98k在敲打人");
    }
}
```
### 测试类
```
/**
 * 测试类
 */
public class TestAdapterClass {
    public static void main(String[] args) {
        Appliance new98k = new AdapterClassKar98k();
        new98k.shooting();
        new98k.hiting();
    }
}
```
输出：  
98K在射击……………  
新型98k在敲打人  
## 对象适配器
将上面的适配器稍微修改一下
### 对象适配器
```
public class AdapterObjectKar98k implements Appliance {
    private Gun gun;
    public AdapterObjectKar98k(Gun gun){
        this.gun = gun;
    }
    @Override
    public void hiting() {
        System.out.println("新型98k在敲打人");
    }

    @Override
    public void shooting() {
        gun.shooting();
    }
}
```
### 测试类
```
/**
 * 测试类
 */
public class TestAdapterObject {
    public static void main(String[] args) {
        Appliance new98k = new AdapterObjectKar98k(new Kar98k());
        new98k.shooting();
        new98k.hiting();
    }
}
```
输出：  
98K在射击……………  
新型98k在敲打人  
## 总结
\ |类适配器|对象适配器
 ---|---|---
优点 |灵活性强|把多个不同的适配者适配到同一个目标
缺点 |不支持多继承，一次最多只能适配一个适配者类|与类适配器模式相比，要想置换适配者类的方法就不容易


