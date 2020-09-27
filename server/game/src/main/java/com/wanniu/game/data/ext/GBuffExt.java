package com.wanniu.game.data.ext;

import com.wanniu.game.data.GBuffCO;
import com.wanniu.game.player.AttributeUtil;
import io.netty.util.internal.StringUtil;

import java.util.HashMap;
import java.util.Map;

public class GBuffExt
        extends GBuffCO {
    public Map<String, Integer> attrs;

    public void putAttr(String str, int value) {
        if (null == this.attrs) {
            this.attrs = new HashMap<>();
        }

        if (StringUtil.isNullOrEmpty(str)) {
            return;
        }

        String attr = AttributeUtil.getKeyByName(str);

        if (StringUtil.isNullOrEmpty(attr)) {
            return;
        }

        this.attrs.put(attr, Integer.valueOf(value));
    }

    public void initProperty() {
        putAttr(this.buffAttribute1, this.buffValue1);
        putAttr(this.buffAttribute2, this.buffValue2);
        putAttr(this.buffAttribute3, this.buffValue3);
        putAttr(this.buffAttribute4, this.buffValue4);
        putAttr(this.buffAttribute5, this.buffValue5);
    }
}


