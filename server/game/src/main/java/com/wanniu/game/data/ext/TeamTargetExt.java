package com.wanniu.game.data.ext;

import com.wanniu.game.common.Const;
import com.wanniu.game.data.TeamTargetCO;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomUtils;


public class TeamTargetExt
        extends TeamTargetCO {
    public Map<Const.PlayerBtlData, Integer> randomAttrs() {
        Map<Const.PlayerBtlData, Integer> result = new HashMap<>();
        if (this.min1 > 0 && this.max1 >= this.min1) {
            Const.PlayerBtlData attr1 = Const.PlayerBtlData.getE(this.prop1);
            if (attr1 != null) {
                result.put(attr1, Integer.valueOf(RandomUtils.nextInt(this.min1, this.max1)));
            }
        }

        if (this.min2 > 0 && this.max2 >= this.min2) {
            Const.PlayerBtlData attr2 = Const.PlayerBtlData.getE(this.prop2);
            if (attr2 != null) {
                result.put(attr2, Integer.valueOf(RandomUtils.nextInt(this.min2, this.max2)));
            }
        }

        if (this.min3 > 0 && this.max3 >= this.min3) {
            Const.PlayerBtlData attr3 = Const.PlayerBtlData.getE(this.prop3);
            if (attr3 != null) {
                result.put(attr3, Integer.valueOf(RandomUtils.nextInt(this.min3, this.max3)));
            }
        }
        return result;
    }
}


