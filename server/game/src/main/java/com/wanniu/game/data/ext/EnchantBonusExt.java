package com.wanniu.game.data.ext;

import com.wanniu.game.data.EnchantBonusCO;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.player.AttributeUtil;


public class EnchantBonusExt
        extends EnchantBonusCO {
    public int _type;
    public String _prop;

    public void initProperty() {
        this._type = (ItemConfig.getInstance().getIdConfig(this.type)).typeID;

        this._prop = AttributeUtil.getKeyByName(this.prop);
    }
}


