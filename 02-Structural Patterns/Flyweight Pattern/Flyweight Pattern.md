# 享元模式（Flyweight Pattern）
## 定义
享元模式（Flyweight Pattern）主要用于减少创建对象的数量，以减少内存占用和提高性能。这种类型的设计模式属于结构型模式，它提供了减少对象数量从而改善应用所需的对象结构的方式。
### 角色
- Flyweight: 抽象享元类。所有具体享元类的超类或者接口，通过这个接口，Flyweight可以接受并作用于外部专题
- ConcreteFlyweight: 具体享元类。指定内部状态，为内部状态增加存储空间。
- UnsharedConcreteFlyweight: 非共享具体享元类。指出那些不需要共享的Flyweight子类。
- FlyweightFactory: 享元工厂类。用来创建并管理Flyweight对象，它主要用来确保合理地共享Flyweight，当用户请求一个Flyweight时，FlyweightFactory就会提供一个已经创建的Flyweight对象或者新建一个（如果不存在）。
## 代码
比如吃鸡的时候，玩家luna一开始捡了UMP9,M16A4,Kar98k和M4A1然后就换了枪，最后觉得还是要把M4A1换成UMP9。那么这个玩家捡了4把不同的枪（5次）。
### 抽象Gun和它的实现类大枪支TheBigGuns(非手枪)
#### Gun
```
/**
 * 抽象枪支
 */
public abstract class Gun {
    public abstract void getGun();
}
```
#### TheBigGuns
```
/**
 * 大枪（非手枪）
 */
public class TheBigGuns extends Gun {
    private String gunName;
    public TheBigGuns(String gunName) {
        this.gunName = gunName;
    }

    @Override
    public void getGun() {
        System.out.println("获得了"+gunName+"这把非手枪");
    }
}

```
### 享元工厂FlyweightFactory
```
/**
 * 享元工厂
 */
public class FlyweightFactory {
    //共享池
    static Map<String,Gun> guns = new HashMap<String, Gun>();
    public static Gun getGun(String key){
        Gun gun = guns.get(key);
        //如果gun==null,表示不存在,则新建,并且保持到共享池中
        if(gun == null){
            gun = new TheBigGuns(key);
            guns.put(key,gun);
        }
        return gun;
    }
    //获取共享池有多少个对象
    public static int getSize(){
        return guns.size();
    }
}
```
### 客户类Client
玩家luna一开始捡了UMP9,M16A4,Kar98k和M4A1然后就换了枪，最后(再捡一次UMP9)觉得还是要把M4A1换成UMP9。
```
/**
 * 客户类(Test)
 */
public class Client {
    public static void main(String[] args) {
        //玩家luna一开始捡了UMP9,M16A4
        Gun firstGun = FlyweightFactory.getGun("UMP9");
        firstGun.getGun();
        Gun secondGun = FlyweightFactory.getGun("M16A4");
        secondGun.getGun();
        //又捡了Kar98k和M4A1然后就换了枪
        Gun thirdGun = FlyweightFactory.getGun("Kar98k");
        thirdGun.getGun();
        Gun forthGun = FlyweightFactory.getGun("M4A1");
        forthGun.getGun();
        // 最后(再捡一次UMP9)觉得还是要把M4A1换成UMP9。
        Gun fifthGun = FlyweightFactory.getGun("UMP9");
        fifthGun.getGun();
        System.out.println("一共捡了"+FlyweightFactory.getSize()+"把非手枪");
    }
}
```
输出
```
获得了UMP9这把非手枪
获得了M16A4这把非手枪
获得了Kar98k这把非手枪
获得了M4A1这把非手枪
获得了UMP9这把非手枪
一共捡了4把非手枪
```
## 总结
- 享元模式可以极大地减少系统中对象的数量。但是它可能会引起系统的逻辑更加复杂化。
- 享元模式的核心在于享元工厂，它主要用来确保合理地共享享元对象。
- 内部状态为不变共享部分，存储于享元享元对象内部，而外部状态是可变部分，它应当由客户端来负责。

