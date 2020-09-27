package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.ClassUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.MasterPropCO;

import java.util.HashMap;
import java.util.Map;

public class MasterPropExt
        extends MasterPropCO {
    public Map<Const.PlayerBtlData, Integer> attr_master = new HashMap<>();
    public Map<Const.PlayerBtlData, Float> attr_grow = new HashMap<>();

    public void initProperty() {
        for (int i = 1; i <= this.propCount; i++) {
            String propName = "prop" + i;
            String attrMax = "max" + i;
            String propName_grow = "grow" + i;

            try {
                Object obj = ClassUtil.getProperty(this, propName);
                if (obj != null) {
                    String key = (String) obj;
                    Const.PlayerBtlData pbd = Const.PlayerBtlData.getE(key);

                    if (pbd != null) {
                        this.attr_master.put(pbd, Integer.valueOf(((Integer) ClassUtil.getProperty(this, attrMax)).intValue()));
                    }

                    this.attr_grow.put(pbd, Float.valueOf(((Float) ClassUtil.getProperty(this, propName_grow)).floatValue()));
                }
            } catch (Exception e) {
                Out.error(new Object[]{"Exception in MasterPropExt: ", e});
            }
        }
    }
}


