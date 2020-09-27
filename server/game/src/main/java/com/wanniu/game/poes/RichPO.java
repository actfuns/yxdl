package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.TurnRewardCO;

import java.util.HashMap;
import java.util.Map;


@DBTable("player_rich")
public class RichPO
        extends GEntity {
    public int currentStep;
    public int freeCount;
    public int currentTurn;
    public Map<Integer, Integer> turnStatesMap;

    public RichPO() {
        reset(-1);
    }

    public void reset(int newTurn) {
        this.turnStatesMap = new HashMap<>();
        for (TurnRewardCO turnRewardCO : GameData.TurnRewards.values()) {
            this.turnStatesMap.put(Integer.valueOf(turnRewardCO.sort), Integer.valueOf(0));
        }
        this.currentStep = 1;
        this.freeCount = 0;

        this.currentTurn = newTurn;
    }
}


