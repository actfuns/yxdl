package com.wanniu.game.data.ext;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.data.BlessBuffCO;
import com.wanniu.game.player.AttributeUtil;

public class BlessBuffExt
        extends BlessBuffCO {
    public JSONObject attr;

    public void initProperty() {
        super.initProperty();
        this.attr = new JSONObject();

        String key = AttributeUtil.getKeyByName(this.buffAttribute1);
        if (key == null) {
            Out.error(new Object[]{"BlessBuffExt attrName not exist : ", this.buffAttribute1});
        }
        this.attr.put("attrKey", key);
        this.attr.put("attrValue", Integer.valueOf(this.buffValue1));
    }
}


