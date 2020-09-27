package com.wanniu.game.data.ext;

import com.wanniu.game.data.SuitConfigCO;
import com.wanniu.game.player.AttributeUtil;


public class SuitConfigExt
        extends SuitConfigCO {
    public String _prop;

    public void initProperty() {
        this._prop = AttributeUtil.getKeyByName(this.prop);
    }
}


