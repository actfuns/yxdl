package com.wanniu.game.data.ext;

import com.wanniu.game.data.GuildFortCO;

import java.util.HashMap;
import java.util.Map;

public class GuildFortExt
        extends GuildFortCO {
    public Map<String, Integer> winnerReward = new HashMap<>();

    public Map<String, Integer> loserReward = new HashMap<>();

    public Map<String, Integer> dailyReward = new HashMap<>();

    public void initProperty() {
        String[] items = this.victoryResources.trim().split(";");
        for (String item : items) {
            String[] str = item.trim().split(":");
            this.winnerReward.put(str[0], Integer.valueOf(Integer.parseInt(str[1])));
        }

        items = this.failResources.trim().split(";");
        for (String item : items) {
            String[] str = item.trim().split(":");
            this.loserReward.put(str[0], Integer.valueOf(Integer.parseInt(str[1])));
        }

        items = this.dayResources.trim().split(";");
        for (String item : items) {
            String[] str = item.trim().split(":");
            this.dailyReward.put(str[0], Integer.valueOf(Integer.parseInt(str[1])));
        }
    }
}


