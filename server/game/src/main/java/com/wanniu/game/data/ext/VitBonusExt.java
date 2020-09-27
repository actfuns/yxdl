package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.data.VitBonusCO;

import java.util.HashMap;
import java.util.Map;

public class VitBonusExt
        extends VitBonusCO {
    public Map<String, Integer> rewards;

    public void initRewards(Map<String, Integer> map) {
        String[] rewards = this.chestCode.split(",");
        for (int i = 0; i < rewards.length; i++) {
            String[] _elem = rewards[i].split(":");
            if (2 != _elem.length) {
                Out.error(new Object[]{"the config err in VitBonus.json"});
            } else {

                map.put(_elem[0], Integer.valueOf(_elem[1]));
            }
        }
    }

    public void initProperty() {
        super.initProperty();
        this.rewards = new HashMap<>();
        initRewards(this.rewards);
    }
}


