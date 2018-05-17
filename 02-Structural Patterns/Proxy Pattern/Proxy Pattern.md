# 代理模式（Proxy Pattern）
## 定义
给某一个对象提供一个代理或占位符，并由代理对象来控制对原对象的访问。
### 核心模块
- Subject（抽象主题角色）：
它声明了真实主题和代理主题的共同接口，这样一来在任何使用真实主题的地方都可以使用代理主题，客户端通常需要针对抽象主题角色进行编程。
- Proxy（代理主题角色）：
它包含了对真实主题的引用，从而可以在任何时候操作真实主题对象；在代理主题角色中提供一个与真实主题角色相同的接口，以便在任何时候都可以替代真实主题；代理主题角色还可以控制对真实主题的使用，负责在需要的时候创建和删除真实主题对象，并对真实主题对象的使用加以约束。通常，在代理主题角色中，客户端在调用所引用的真实主题操作之前或之后还需要执行其他操作，而不仅仅是单纯调用真实主题对象中的操作。
- RealSubject（真实主题角色）：
它定义了代理角色所代表的真实对象，在真实主题角色中实现了真实的业务操作，客户端可以通过代理主题角色间接调用真实主题角色中定义的操作。
## 代码
### 静态代理(Static Proxy)
我们同样以吃鸡为例，有三个要素：一个抽象的ICar，真实对象三蹦子Buggy，以及一个代理对象Proxy
#### 共同接口ICar
```
/**
 * 共同接口Car抽象类
 */
public interface ICar {
    public void run();
}
```
#### 真实对象Buggy
```
/**
 * 真实对象三蹦子Buggy
 */
public class Buggy implements ICar {
    @Override
    public void run() {
        System.out.println("Buggy在跑");
    }
}

```
#### 代理对象StaticProxy
```
/**
 * 静态代理对象
 */
public class StaticProxy implements ICar{
    private ICar car;

    public StaticProxy(ICar car){
        this.car = car;
    }
    @Override
    public void run() {
        System.out.println("代理...");
        car.run();
    }
}
```
#### 测试
```
public class StaticProxyTest {
    public static void main(String[] args) {
        StaticProxy proxy = new StaticProxy(new Buggy());
        proxy.run();
    }
}
```
输出：
```
代理...
Buggy在跑
```
静态代理的缺点：会导致proxy膨胀。但如果我们需要很多的代理，每一个都这么手动的去创建实属浪费时间，而且会有大量的重复代码，此时我们就可以采用动态代理。
### 动态代理(Dynamic Proxy)
JDK动态代理的思维模式与之前的一般模式是一样的，也是面向接口进行编码，创建代理类将具体类隐藏解耦，不同之处在于代理类的创建时机不同，动态代理需要在运行时因需实时创建。
#### 共同接口ICar
与静态代理一致
```
/**
 * 共同接口Car抽象类
 */
public interface ICar {
    public void run();
}
```
#### 真实对象Buggy
与静态代理一致
```
/**
 * 真实对象三蹦子Buggy
 */
public class Buggy implements ICar {
    @Override
    public void run() {
        System.out.println("Buggy在跑");
    }
}

```
#### 代理对象DynamicProxy 
```
/**
 * 动态代理
 */
public class DynamicProxy implements InvocationHandler{
    private ICar car;

    public DynamicProxy(ICar car) {
        this.car = car;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理...");
        method.invoke(car,args);
        return null;
    }
}
```
#### 测试类
```
/**
 * 测试类
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        //我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler h = new DynamicProxy(new Buggy());

        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 ICar.class.getClassLoader() ，我们这里使用ICar这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数new Class[]{ICar.class}，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数h， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        ICar proxy = (ICar) Proxy.newProxyInstance(ICar.class.getClassLoader(),new Class[]{ICar.class},h);
        proxy.run();
    }
}
```

## 总结
- 优点
动态代理与静态代理相比较，最大的好处是接口中声明的所有方法都被转移到调用处理器一个集中的方法中处理（InvocationHandler.invoke）。这样，在接口方法数量比较多的时候，我们可以进行灵活处理，而不需要像静态代理那样每一个方法进行中转。在本示例中看不出来，因为invoke方法体内嵌入了具体的外围业务（记录任务处理前后时间并计算时间差），实际中可以类似Spring AOP那样配置外围业务。 
- 不足
它始终无法摆脱仅支持 interface 代理的桎梏，因为它的设计注定了这个遗憾。回想一下那些动态生成的代理类的继承关系图，它们已经注定有一个共同的父类叫 Proxy。Java 的继承机制注定了这些动态代理类们无法实现对 class 的动态代理，原因是多继承在 Java 中本质上就行不通。 
### 代理模式作用
1. 职责清晰:真实的角色就是实现实际的业务逻辑，不用关心其他非本职责的事务，通过后期的代理完成一件完成事务，附带的结果就是编程简洁清晰。
2. 代理对象可以在客户端和目标对象之间起到中介的作用，这样起到了中介的作用和保护了目标对象的作用。
3. 高扩展性