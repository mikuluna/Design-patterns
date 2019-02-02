package com.luna.commoandPattern.Impl;

import com.luna.commoandPattern.Command;
import com.luna.commoandPattern.Receiver;

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
