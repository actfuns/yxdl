package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.ClassUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.RideListCO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RideListExt extends RideListCO {
    public Map<Const.PlayerBtlData, Integer> levelAttrs = new HashMap<>();
    public Map<Const.PlayerBtlData, Integer> starAttrs = new HashMap<>();


    public Map<Const.PlayerBtlData, Integer> totalPreStarAttrs = new HashMap<>();


    public void initProperty() {
        for (int i = 1; i <= 7; i++) {
            String propName = "prop" + i;
            String attrMax = "max" + i;
            String starPropName = "starProp" + i;
            String starAttrMax = "starMax" + i;


            try {
                Object obj = ClassUtil.getProperty(this, propName);
                if (obj != null) {
                    String key = (String) obj;
                    Const.PlayerBtlData pbd = Const.PlayerBtlData.getE(key);

                    if (pbd != null) {
                        this.levelAttrs.put(pbd, Integer.valueOf(((Integer) ClassUtil.getProperty(this, attrMax)).intValue()));
                    }
                }
                obj = ClassUtil.getProperty(this, starPropName);
                if (obj != null) {
                    String key = (String) obj;
                    Const.PlayerBtlData pbd = Const.PlayerBtlData.getE(key);

                    if (pbd != null) {
                        this.starAttrs.put(pbd, Integer.valueOf(((Integer) ClassUtil.getProperty(this, starAttrMax)).intValue()));
                        this.totalPreStarAttrs.put(pbd, Integer.valueOf(0));
                    }

                }
            } catch (Exception e) {
                Out.error(new Object[]{"Exception in RidelistExt: ", e});
            }
        }

        Map<Integer, RideListExt> map = GameData.RideLists;
        for (Iterator<Integer> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
            int level = ((Integer) iterator.next()).intValue();
            if (level < this.rideLevel) {
                RideListExt prop_pre = map.get(Integer.valueOf(level));
                Map<Const.PlayerBtlData, Integer> starAttrs_pre = prop_pre.starAttrs;
                for (Const.PlayerBtlData pbd : starAttrs_pre.keySet()) {
                    int value = ((Integer) this.totalPreStarAttrs.get(pbd)).intValue();
                    value += ((Integer) starAttrs_pre.get(pbd)).intValue() * 10;
                    this.totalPreStarAttrs.put(pbd, Integer.valueOf(value));
                }
            }
        }

    }
}


