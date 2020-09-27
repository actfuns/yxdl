package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.ClassUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.MasterUpgradePropCO;

import java.util.HashMap;
import java.util.Map;

public class MasterUpgradePropExt
        extends MasterUpgradePropCO {
    public Map<Const.PlayerBtlData, Integer> attr_master = new HashMap<>();


    public void initProperty() {
        for (int i = 1; i <= this.propCount; i++) {
            String propName = "petProp" + i;
            String attrMax = "petMax" + i;

            try {
                Object obj = ClassUtil.getProperty(this, propName);
                if (obj != null) {
                    String key = (String) obj;
                    Const.PlayerBtlData pbd = Const.PlayerBtlData.getE(key);

                    if (pbd != null) {
                        this.attr_master.put(pbd, Integer.valueOf(((Integer) ClassUtil.getProperty(this, attrMax)).intValue()));
                    }
                }
            } catch (Exception e) {
                Out.error(new Object[]{"Exception in MasterUpgradePropExt: ", e});
            }
        }
    }
}


