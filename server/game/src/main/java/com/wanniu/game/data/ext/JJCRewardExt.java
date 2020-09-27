package com.wanniu.game.data.ext;

import com.wanniu.core.util.StringUtil;
import com.wanniu.game.data.JJCRewardCO;

import java.util.HashMap;
import java.util.Map;


public class JJCRewardExt
        extends JJCRewardCO {
    public Map<String, Integer> _rankReward;

    public void initProperty() {
        this._rankReward = new HashMap<>();
        if (StringUtil.isEmpty(this.rankReward)) {
            return;
        }
        String[] rewards = this.rankReward.split(";");
        for (String s : rewards) {
            String[] rw = s.split(":");
            if (rw.length >= 2)
                this._rankReward.put(rw[0], Integer.valueOf(Integer.parseInt(rw[1])));
        }
    }
}


