package com.wanniu.game.data.ext;

import com.wanniu.game.common.Const;
import com.wanniu.game.data.MedalListCO;

public class MedalListExt
        extends MedalListCO {
    public int _pro;

    public void initProperty() {
        this._pro = Const.PlayerPro.Value(this.pro);
    }
}


