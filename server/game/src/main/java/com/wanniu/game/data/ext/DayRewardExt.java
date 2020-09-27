package com.wanniu.game.data.ext;

import com.wanniu.game.data.DayRewardCO;

import java.util.HashMap;
import java.util.Map;


public class DayRewardExt
        extends DayRewardCO {
    public Map<String, Integer> dayRewards = new HashMap<>();


    public void initProperty() {
        String[] items = this.rankReward.trim().split(";");
        for (String item : items) {
            String[] str = item.trim().split(":");
            this.dayRewards.put(str[0], Integer.valueOf(Integer.parseInt(str[1])));
        }
    }
}


