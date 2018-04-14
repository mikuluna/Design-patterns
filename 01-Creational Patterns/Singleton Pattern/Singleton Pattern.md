# 单例模式Singleton Pattern
## 定义
单例模式是一种常用的软件设计模式，在它的核心结构中值包含一个被称为单例的特殊类。一个类只有一个实例，即一个类只有一个对象实例。  
单例模式只有一个实例，并且不能new出来（它的构造方法一定是private）
## 单例模式的几种方式
### 饿汉式
#### 饿汉式（静态常量）
```
/**
 * 饿汉式（静态常量）
 */
public class SingletonDemo1 {
    //静态常量将对象new出来
    private final static SingletonDemo1 INSTANCE = new SingletonDemo1();
    //private的构造函数，防止实例化
    private SingletonDemo1(){
    }
    //通过getInstance获取对象
    public static SingletonDemo1 getInstance(){
        return INSTANCE;
    }
}
```
#### 饿汉式（静态代码块）
```
/**
 * 饿汉式（静态代码块）
 */
public class SingletonDemo2 {
    //定义对象，并且通过静态代码块new出来
    private static SingletonDemo2 instance;
    static {
        instance=new SingletonDemo2();
    }
    //private的构造函数，防止实例化
    private SingletonDemo2(){
    }
    //通过getInstance获取对象
    public static SingletonDemo2 getInstance(){
        return instance;
    }
}
```
饿汉式优点：简单好写，线程不用担心
饿汉式缺点：浪费内存（就算不用也要new出来）
### 懒汉式
#### 懒汉式(线程不安全)-不要用
```

/**
 * 懒汉式(线程不安全)
 */
public class SingletonDemo3 {
    //定义对象
    private static SingletonDemo3 singleton;
    //private的构造函数，防止实例化
    private SingletonDemo3() {}
    //如果对象不存在就new出来
    public static SingletonDemo3 getInstance() {
        if (singleton == null) {
            singleton = new SingletonDemo3();
        }
        return singleton;
    }
}
```
优点：不用担心浪费内存。
缺点：只能单个线程，多个线程的话，会有问题。
#### 懒汉式(线程安全，同步方法)-不推荐
```
/**
 * 懒汉式(线程安全，同步方法)
 */
public class SingletonDemo4 {
    //定义对象
    private static SingletonDemo4 singleton;
    //private的构造函数，防止实例化
    private SingletonDemo4() {}
    //如果对象不存在就new出来，并且加入synchronized关键字达到同步
    public static synchronized SingletonDemo4 getInstance() {
        if (singleton == null) {
            singleton = new SingletonDemo4();
        }
        return singleton;
    }
}
```
优点：不用担心浪费内存。
缺点：效率低下（因为锁），并且大多数情况下不需要同步
### 双重校验锁-优先考虑
```
/**
 * 双重校验锁
 */
public class SingletonDemo5 {
    //定义对象
    private static SingletonDemo5 singleton;
    //private的构造函数，防止实例化
    private SingletonDemo5() {}
    //如果对象不存在同步中再校验一遍，以便防止重复创建对象。
    public static SingletonDemo5 getInstance() {
        if (singleton == null) {
            synchronized(SingletonDemo5.class){
                if(singleton==null){
                    singleton=new SingletonDemo5();
                }
            }

        }
        return singleton;
    }
}
```

### 静态内部类-优先考虑
```
/**
 * 静态内部类
 */
public class SingletonDemo6 {
    //private的构造函数，防止实例化
    private SingletonDemo6() {}
    //内部类作用创建一个final的实体
    private static class SingletonInstance {
        private static final SingletonDemo6 INSTANCE = new SingletonDemo6();
    }
    //在第一次调用方法的时候才会new出来，之后就直接拿之前的
    public static SingletonDemo6 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
```

### 枚举-优先考虑
```
/**
 * 枚举
 */
public enum  SingletonDemo7 {
    INSTANCE;
    public void whateverMethod(){
    }
}

```
这种方式是Effective Java作者Josh Bloch 提倡的方式，它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象，可谓是很坚强的壁垒啊，不过，个人认为由于1.5中才加入enum特性，用这种方式写不免让人感觉生疏，在实际工作中，我也很少看见有人这么写过
## 场景
- 需要频繁的进行创建和销毁的对象；
- 创建对象时耗时过多或耗费资源过多，但又经常用到的对象；
- 工具类对象；
- 频繁访问数据库或文件的对象
## 总结
作者一句话总结：
单例模式：一个不能被new出来，却要记获取实体方法，有且有一个对象，节省资源的模式。