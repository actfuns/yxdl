package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.BlessBuffCO;
import com.wanniu.game.data.BlessLevelCO;
import com.wanniu.game.data.GameData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlessLevelExt
        extends BlessLevelCO {
    public Map<Const.PlayerBtlData, Integer> bufsAttr = new HashMap<>();

    public void initProperty() {
        super.initProperty();
        this.buffList = new ArrayList<>();
        String[] strArr = this.blessBuff.split(",");
        for (int i = 0; i < strArr.length; i++) {
            int id = Integer.parseInt(strArr[i]);
            this.buffList.add(Integer.valueOf(id));
            BlessBuffCO prop = (BlessBuffCO) GameData.BlessBuffs.get(Integer.valueOf(id));
            if (prop == null) {
                Out.error(new Object[]{"找不到工会buffId"});
            } else {

                Const.PlayerBtlData pbd = Const.PlayerBtlData.getE(prop.buffAttribute1);
                if (pbd == null) {
                    Out.error(new Object[]{"找不到工会buff类型"});
                } else {

                    this.bufsAttr.put(pbd, Integer.valueOf(prop.buffValue1));
                }
            }
        }
    }

    public List<Integer> buffList;
}


