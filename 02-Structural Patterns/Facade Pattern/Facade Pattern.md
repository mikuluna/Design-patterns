# 外观模式（Facade Pattern）
## 定义
外观模式（Facade Pattern）隐藏系统的复杂性，并向客户端提供了一个客户端可以访问系统的接口。  
这种类型的设计模式属于结构型模式，它向现有的系统添加一个接口，来隐藏系统的复杂性。  
这种模式涉及到一个单一的类，该类提供了客户端请求的简化方法和对现有系统类方法的委托调用。  

简单来说，该模式就是把一些复杂的流程封装成一个接口供给外部用户更简单的使用。这个模式中，设计到3个角色。  
1. 门面角色：外观模式的核心。它被客户角色调用，它熟悉子系统的功能。内部根据客户角色的需求预定了几种功能的组合。
2. 子系统角色:实现了子系统的功能。它对客户角色和Facade时未知的。它内部可以有系统内的相互交互，也可以由供外界调用的接口。
3. 客户角色:通过调用Facede来完成要实现的功能。
## 代码
比如我们在吃鸡的时候，我们有这么几个子系统（Subsystem）：角色状态（蹲下，站立，趴着），枪支状态（拿枪，收枪），前进操作（前进，后退）这三种系统（其他的先不管）。
我们用Facade写了一些招式（也可以理解为宏）：趴着进毒圈（趴着拿枪前进），菜鸡打扰招式（站立收枪后退）,幻影坦克招式（蹲下拿枪）这三个招式。
### Subsystem
#### PhysicalState(角色的状态)
包括蹲下站立和趴着。
```
/**
 * 角色状态（蹲下，站立，趴着）
 */
public class PhysicalState {
    /**
     * 蹲下
     */
    public void crouch(){
        System.out.print("正在蹲下");
    }
    /**
     * 站立
     */
    public void stand(){
        System.out.println("正在站立");
    }
    /**
     * 趴着
     */
    public void prone(){
        System.out.println("正在趴着");
    }
}
```
#### StateOfGuns（枪支状态）
包括收枪和拿枪
```
/**
 * 枪支状态（拿枪，收枪）
 */
public class StateOfGuns {
    /**
     * 拿枪
     */
    public void gotAGun(){
        System.out.println("正在拿枪");
    }

    /**
     * 收枪
     */
    public void collectTheGun(){
        System.out.println("正在收枪");
    }
}
```
#### MoveState(前进操作)
包括前进和后退
```
/**
 * 前进操作（前进，后退）
 */
public class MoveState {
    /**
     * 前进
     */
    public void goForward(){
        System.out.println("正在前进");
    }

    /**
     * 后退
     */
    public void moveBack(){
        System.out.println("正在后退");
    }
}
```
### Facade
外观类。也就是组合的招式。
```
/**
 * 招式(可以理解为游戏里面玩家定义的宏)
 */
public class FacadeMaker {
    private PhysicalState physicalState;
    private StateOfGuns stateOfGuns;
    private MoveState moveState;

    public FacadeMaker() {
            physicalState = new PhysicalState();
            stateOfGuns = new StateOfGuns();
            moveState = new MoveState();
    }

    /**
     * 趴着进毒圈（趴着拿枪前进）
     */
    public void belly(){
        System.out.println("趴着进毒圈宏：");
        physicalState.prone();
        stateOfGuns.gotAGun();
        moveState.goForward();
        System.out.println("=================");
    }
    /**
     * 菜鸡打扰招式（站立收枪后退）
     */
    public void rookieDisturb(){
        System.out.println("菜鸡打扰宏：");
        physicalState.stand();
        stateOfGuns.collectTheGun();
        moveState.moveBack();
        System.out.println("=================");
    }
    /**
     * 幻影坦克招式（蹲下拿枪）
     */
    public void mirageTank(){
        System.out.println("幻影坦克宏：");
        physicalState.crouch();
        stateOfGuns.gotAGun();
        System.out.println("=================");
    }
}
```

### 测试类Client
```
/**
 * 客户端（测试类）
 */
public class Client {
    public static void main(String[] args) {
        FacadeMaker facadeMaker = new FacadeMaker();
        //看一下里面的三个宏
        facadeMaker.belly();
        facadeMaker.mirageTank();
        facadeMaker.rookieDisturb();
    }
}
```
输出：
```
趴着进毒圈宏：
正在趴着
正在拿枪
正在前进
=================
幻影坦克宏：
正在蹲下正在拿枪
=================
菜鸡打扰宏：
正在站立
正在收枪
正在后退
=================
```
## 总结
### 使用场景
- 构建一个有层次结构的子系统时，使用外观模式定义子系统中每层的入口点，如果子系统之间是相互依赖的，则可以让他们通过外观接口进行通信，减少子系统之间的依赖关系。
- 子系统往往会因为不断的重构演化而变得越来越复杂，大多数的模式使用时也会产生很多很小的类，这给外部调用他们的用户程序带来了使用的困难，我们可以使用外观类提供一个简单的接口，对外隐藏子系统的具体实现并隔离变化。
- 当维护一个遗留的大型系统时，可能这个系统已经非常难以维护和拓展，但因为它含有重要的功能，新的需求必须依赖于它，则可以使用外观类，来为设计粗糙或者复杂的遗留代码提供一个简单的接口，让新系统和外观类交互，而外观类负责与遗留的代码进行交互。

###外观模式优点：
- 松散耦合  
 使得客户端和子系统之间解耦，让子系统内部的模块功能更容易扩展和维护；
- 简单易用  
客户端根本不需要知道子系统内部的实现，或者根本不需要知道子系统内部的构成，它只需要跟Facade类交互即可。
- 更好的划分访问层次  
有些方法是对系统外的，有些方法是系统内部相互交互的使用的。子系统把那些暴露给外部的功能集中到门面中，这样就可以实现客户端的使用，很好的隐藏了子系统内部的细节。
