package com.luna.commoandPattern.client;

import com.luna.commoandPattern.Command;
import com.luna.commoandPattern.Impl.CatchCommand;
import com.luna.commoandPattern.Impl.FightCommand;
import com.luna.commoandPattern.Invoker;
import com.luna.commoandPattern.Receiver;

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
