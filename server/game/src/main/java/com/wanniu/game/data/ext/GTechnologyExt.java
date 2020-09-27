package com.wanniu.game.data.ext;

import com.wanniu.game.data.GTechnologyCO;
import com.wanniu.game.player.AttributeUtil;
import io.netty.util.internal.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GTechnologyExt
        extends GTechnologyCO {
    public Map<String, Integer> attrs;
    public List<Integer> recommendPros;

    public void putAttr(String str, int value) {
        if (null == this.attrs) {
            this.attrs = new HashMap<>();
        }

        if (!StringUtil.isNullOrEmpty(str)) {
            String attr = AttributeUtil.getKeyByName(str);
            this.attrs.put(attr, Integer.valueOf(value));
        }
    }

    public void initProperty() {
        putAttr(this.techAttribute1, this.techValue1);
        putAttr(this.techAttribute2, this.techValue2);
        this.recommendPros = new ArrayList<>();
        if (StringUtil.isNullOrEmpty(this.recommend)) {
            String[] proArr = this.recommend.split(",");
            for (String pro : proArr)
                this.recommendPros.add(Integer.valueOf(Integer.parseInt(pro)));
        }
    }
}


