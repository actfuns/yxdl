package com.wanniu.game.data.ext;

import com.wanniu.game.common.Const;
import com.wanniu.game.data.AttributeCO;

public class AttributeExt
        extends AttributeCO {
    public Const.PlayerBtlData btlProp;

    public void initProperty() {
        this.btlProp = Const.PlayerBtlData.getE(this.iD);
    }
}


