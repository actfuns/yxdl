package com.wanniu.game.player;

import com.wanniu.game.GWorld;


public class RebateService {
    private static final RebateService instance = new RebateService();

    public static RebateService getInstance() {
        return instance;
    }


    public void ansycCheckRebate(WNPlayer player) {
        GWorld.getInstance().ansycExec(new RebateCheckTask(player));
    }
}


