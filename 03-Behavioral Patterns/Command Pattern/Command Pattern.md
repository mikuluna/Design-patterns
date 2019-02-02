# 命令模式（Command Pattern）
## 定义
将一个请求封装为一个对象，从而使我们可用不同的请求对客户进行参数化；对请求排队或者记录请求日志，以及支持可撤销的操作。命令模式是一种对象行为型模式，其别名为动作(Action)模式或事务(Transaction)模式。
### 角色
Command: 抽象命令类：其中声明了用于执行请求的execute()等方法，通过这些方法可以调用请求接收者的相关操作。
ConcreteCommand: 具体命令类：实现了在抽象命令类中声明的方法，它对应具体的接收者对象，将接收者对象的动作绑定其中。在实现execute()方法时，将调用接收者对象的相关操作(Action)。
Invoker: 调用者：个调用者并不需要在设计时确定其接收者，因此它只与抽象命令类之间存在关联关系。在程序运行时可以将一个具体命令对象注入其中，再调用具体命令对象的execute()方法，从而实现间接调用请求接收者的相关操作。
Receiver: 接收者：接收者执行与请求相关的操作，它具体实现对请求的业务处理。
Client:客户类：使用命令模式实现的业务的类。
## 代码
### 抽象命令类
```
/**
 * 抽象命令类
 */
public abstract class Command {
    public abstract void execute();
}
```
### 接收类
```
/**
 * 接收者
 */
public class Receiver {
    public void action(){
        System.out.println("我要打十个");
    }
    public void unableAction(){
        System.out.println("我要抓十个");
    }
}
```
### 命令具体实现类
```
/**
 * 具体实现：打人命令
 */
public class FightCommand extends Command {
    private Receiver receiver;

    public FightCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.action();
    }
}

```
```
/**
 * 具体实现：抓人命令
 */
public class CatchCommand extends Command {
    private Receiver receiver;

    public CatchCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.unableAction();
    }
}
```
### 调用者
```
/**
 * 调用者
 */
public class Invoker {
    private Command command;

    //构造注入
    public Invoker(Command command) {
        this.command = command;
    }
    public Invoker() {
    }

    //设值注入
    public void setCommand(Command command) {
        this.command = command;
    }

    //业务方法，用于调用命令类的execute()方法
    public void call() {
        command.execute();
    }
}
```
### 测试类
```
public class Client {
    public static void main(String[] args) {
        // 创建命令的接受者
        Receiver receiver = new Receiver();
        // 创建命令对象，并设定它的接受者
        Command catchCommand = new CatchCommand(receiver);
        Command fightCommand = new FightCommand(receiver);
        // 创建命令执行者，并将相应的命令作为参数传递给Invoker
        Invoker invoker = new Invoker();
        invoker.setCommand(catchCommand);
        invoker.call();//抓人
        invoker.setCommand(fightCommand);
        invoker.call();//打人
    }
}
```
## 总结
命令模式其实就是通过一个方法执行不同的东西，根据你传入的不同命令来执行。
### 优点
- 实现客户端和接受者之间的解耦。
- 可以动态的添加新的命令。
- 只需要调用同一个方法（doCommand方法）便可以实现不同的功能。
### 缺点
实现一个具体的命令系统，可能要创建很多的具体命令对象。