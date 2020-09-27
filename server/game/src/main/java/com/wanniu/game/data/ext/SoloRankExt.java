package com.wanniu.game.data.ext;

import com.wanniu.game.data.SoloRankCO;

import java.util.HashMap;
import java.util.Map;

public class SoloRankExt
        extends SoloRankCO {
    public Map<String, Integer> rankRewards = new HashMap<>();


    public void initProperty() {
        String[] items = this.rankReward.trim().split(";");
        for (String item : items) {
            String[] str = item.trim().split(":");
            this.rankRewards.put(str[0], Integer.valueOf(Integer.parseInt(str[1])));
        }
    }
}


