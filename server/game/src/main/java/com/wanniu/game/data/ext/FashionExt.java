package com.wanniu.game.data.ext;

import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.FashionCO;

import java.util.HashMap;
import java.util.Map;


public class FashionExt
        extends FashionCO {
    public int avatarTag;
    public Map<Const.PlayerBtlData, Integer> atts;

    public void initProperty() {
        if (this.type == Const.FASHION_TYPE.WEPON.value) {
            this.avatarTag = Const.AVATAR_TYPE.R_HAND_WEAPON.value;
        } else if (this.type == Const.FASHION_TYPE.CLOTH.value) {
            this.avatarTag = Const.AVATAR_TYPE.AVATAR_BODY.value;
        } else if (this.type == Const.FASHION_TYPE.WING.value) {
            this.avatarTag = Const.AVATAR_TYPE.REAR_EQUIPMENT.value;
        }
        this.atts = new HashMap<>();

        if (StringUtil.isNotEmpty(this.prop1)) {
            this.atts.put(Const.PlayerBtlData.getE(this.prop1), Integer.valueOf(this.num1));
        }
        if (StringUtil.isNotEmpty(this.prop2)) {
            this.atts.put(Const.PlayerBtlData.getE(this.prop2), Integer.valueOf(this.num2));
        }
        if (StringUtil.isNotEmpty(this.prop3)) {
            this.atts.put(Const.PlayerBtlData.getE(this.prop3), Integer.valueOf(this.num3));
        }
        if (StringUtil.isNotEmpty(this.prop4)) {
            this.atts.put(Const.PlayerBtlData.getE(this.prop4), Integer.valueOf(this.num4));
        }
    }


    public String getKey() {
        return this.code;
    }
}


