package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.ClassUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.UpLevelExpCO;

import java.util.HashMap;
import java.util.Map;


public class UpLevelExpExt
        extends UpLevelExpCO {
    public int Pro;
    public Map<Const.PlayerBtlData, Integer> attrs;

    public void initProperty() {
        this.attrs = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            String propName = "prop" + i;
            String maxValue = "max" + i;

            try {
                Object obj = ClassUtil.getProperty(this, propName);
                if (obj != null) {
                    String key = (String) obj;

                    Const.PlayerBtlData pbd = Const.PlayerBtlData.getE(key);
                    if (pbd != null) {
                        this.attrs.put(pbd, Integer.valueOf(((Integer) ClassUtil.getProperty(this, maxValue)).intValue()));
                    }
                }
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }
    }
}


