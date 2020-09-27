package com.wanniu.game.arena.po;

import com.wanniu.game.DBField;

import java.util.Date;


public class ArenaSystemPO {
    @DBField(isPKey = true, fieldType = "varchar", size = 50)
    public String logicServerId;
    public Date seasonResetTime;
    public int term;

    public ArenaSystemPO() {
    }

    public ArenaSystemPO(String logicServerId) {
        this.logicServerId = logicServerId;
        this.seasonResetTime = new Date();
        this.term = 0;
    }
}


