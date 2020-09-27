package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.ClassUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.data.RankListCO;
import com.wanniu.game.player.AttributeUtil;

import java.util.HashMap;
import java.util.Map;


public class RankListExt
        extends RankListCO {
    public Map<String, Integer> rankAttrs;

    public void initProperty() {
        this.rankAttrs = new HashMap<>();
        for (int i = 1; i <= 4; i++) {
            String propName = "prop" + i;
            String maxValue = "max" + i;

            try {
                if (ClassUtil.getProperty(this, propName) != null && StringUtil.isNotEmpty((String) ClassUtil.getProperty(this, propName))) {
                    String key = AttributeUtil.getKeyByName((String) ClassUtil.getProperty(this, propName));
                    if (StringUtil.isNotEmpty(key) && ClassUtil.getProperty(this, maxValue) != null) {
                        this.rankAttrs.put(key, Integer.valueOf(((Integer) ClassUtil.getProperty(this, maxValue)).intValue()));
                    }
                }
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }
    }
}


