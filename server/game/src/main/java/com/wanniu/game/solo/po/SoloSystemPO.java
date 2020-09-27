package com.wanniu.game.solo.po;

import com.wanniu.game.DBField;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SoloSystemPO {
    @DBField(isPKey = true, fieldType = "varchar", size = 50)
    public String logicServerId;
    public Date seasonEndTime;
    public int term;
    public int rounds;
    public List<String> soloNewses;

    public SoloSystemPO() {
    }

    public SoloSystemPO(String logicServerId) {
        this.logicServerId = logicServerId;
        this.seasonEndTime = null;
        this.term = 0;
        this.rounds = 1;

        this.soloNewses = new ArrayList<>();
    }
}


