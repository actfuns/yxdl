package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.ClassUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.data.base.DEquipBase;
import com.wanniu.game.player.AttributeUtil;

import java.util.HashMap;


public class UniqueEquipExt
        extends DEquipBase {
    public String getKey() {
        return this.code;
    }


    public void initProperty() {
        initProp();

        this.fixedAtts = new HashMap<>();
        try {
            for (int i = 1; i <= 6; i++) {
                String attrName = "rProp" + i;
                String par = "rPar" + i;
                String minValue = "rMin" + i;
                String maxValue = "rMax" + i;

                String key = (String) ClassUtil.getProperty(this, attrName);
                if (!StringUtil.isEmpty(key)) {
                    this.fixedAtts.put(AttributeUtil.getKeyByName(key),
                            Integer.valueOf(((Integer) ClassUtil.getProperty(this, minValue)).intValue()));
                }
            }
        } catch (Exception e) {
            Out.error(new Object[]{e});
        }
    }
}


