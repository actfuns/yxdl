package com.wanniu.game.data.ext;

import com.wanniu.game.common.Const;
import com.wanniu.game.data.ArmourAttributeCO;

import java.util.HashMap;
import java.util.Map;


public class ArmourAttributeExt
        extends ArmourAttributeCO {
    public Map<Const.PlayerBtlData, Integer> atts;

    public void initProperty() {
        this.atts = new HashMap<>();

        String[] propStrs = this.prop.split(";");

        for (String string : propStrs) {
            String[] subPropStrs = string.split(":");
            this.atts.put(Const.PlayerBtlData.getE(Integer.parseInt(subPropStrs[0])), Integer.valueOf(Integer.parseInt(subPropStrs[1])));
        }
    }


    public int getKey() {
        return this.iD;
    }
}


