package com.wanniu.game.data.ext;

import com.wanniu.core.util.StringUtil;
import com.wanniu.game.data.SmritiCO;

import java.util.HashMap;
import java.util.Map;

public class SmritiExt
        extends SmritiCO {
    private Map<String, Integer> needItems;

    public void initProperty() {
        Map<String, Integer> tpneedItems = new HashMap<>();
        if (!StringUtil.isEmpty(this.mateCode1) && this.mateCount1 > 0) {
            tpneedItems.put(this.mateCode1, Integer.valueOf(this.mateCount1));
        }
        if (!StringUtil.isEmpty(this.mateCode2) && this.mateCount2 > 0) {
            tpneedItems.put(this.mateCode2, Integer.valueOf(this.mateCount2));
        }
        if (!StringUtil.isEmpty(this.mateCode3) && this.mateCount3 > 0) {
            tpneedItems.put(this.mateCode3, Integer.valueOf(this.mateCount3));
        }
        this.needItems = tpneedItems;
    }

    public Map<String, Integer> getNeedItems() {
        return this.needItems;
    }
}


