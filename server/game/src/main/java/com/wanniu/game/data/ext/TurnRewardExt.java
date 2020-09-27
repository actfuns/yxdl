package com.wanniu.game.data.ext;

import com.wanniu.game.data.TurnRewardCO;

import java.util.HashMap;


public class TurnRewardExt
        extends TurnRewardCO {
    public HashMap<String, Integer> getRewardMap;

    public void initProperty() {
        this.getRewardMap = new HashMap<>();

        String[] getRewardStrs = this.getReward.split(";");
        for (String getRewardSubStr : getRewardStrs) {
            String[] getRewardSubStrs = getRewardSubStr.split(":");

            this.getRewardMap.put(getRewardSubStrs[0], Integer.valueOf(Integer.parseInt(getRewardSubStrs[1])));
        }
    }
}


