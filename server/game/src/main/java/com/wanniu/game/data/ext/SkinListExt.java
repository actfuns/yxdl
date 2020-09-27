package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.ClassUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.SkinListCO;

import java.util.HashMap;
import java.util.Map;

public class SkinListExt
        extends SkinListCO {
    public Map<Const.PlayerBtlData, Integer> skinAttrs = new HashMap<>();


    public void initProperty() {
        for (int i = 1; i <= 6; i++) {
            String propName = "prop" + i;
            String attrMax = "max" + i;


            try {
                Object obj = ClassUtil.getProperty(this, propName);
                if (obj != null) {
                    String key = (String) obj;
                    Const.PlayerBtlData pbd = Const.PlayerBtlData.getE(key);

                    if (pbd != null) {
                        this.skinAttrs.put(pbd, Integer.valueOf(((Integer) ClassUtil.getProperty(this, attrMax)).intValue()));
                    }
                }

            } catch (Exception e) {
                Out.error(new Object[]{"Exception in SkinListExt: ", e});
            }
        }
    }
}


