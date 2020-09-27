package com.wanniu.game.data.ext;

import com.wanniu.game.data.BattleRoyaleRankCO;

import java.util.HashMap;
import java.util.Map;

public class BattleRoyaleRankExt
        extends BattleRoyaleRankCO {
    public Map<String, Integer> gradeRewards = new HashMap<>();


    public void initProperty() {
        String[] items = this.rankReward.trim().split(";");
        for (String item : items) {
            String[] str = item.trim().split(":");
            this.gradeRewards.put(str[0], Integer.valueOf(Integer.parseInt(str[1])));
        }
    }
}


