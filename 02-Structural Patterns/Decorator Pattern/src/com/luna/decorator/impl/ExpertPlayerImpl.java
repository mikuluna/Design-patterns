package com.luna.decorator.impl;

import com.luna.decorator.Player;

/**
 * 高端玩家类
 */
public class ExpertPlayerImpl implements Player {
    @Override
    public String equip() {
        return "高端玩家";
    }
}
