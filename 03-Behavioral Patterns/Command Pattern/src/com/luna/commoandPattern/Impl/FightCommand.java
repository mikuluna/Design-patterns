package com.luna.commoandPattern.Impl;

import com.luna.commoandPattern.Command;
import com.luna.commoandPattern.Receiver;

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
