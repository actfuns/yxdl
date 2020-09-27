package com.wanniu.game.data.ext;

import com.wanniu.game.data.SuitListCO;
import com.wanniu.game.equip.NormalEquip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class SuitListExt
        extends SuitListCO {
    public List<String> partCodes;

    public void initProperty() {
        this.partCodes = new ArrayList<>();
        String[] pars = this.partCodeList.split(",");
        for (String code : pars) {
            this.partCodes.add(code);
        }
    }


    public List<String> getContaintsCode(Map<Integer, NormalEquip> equips) {
        List<String> list = new ArrayList<>();
        for (NormalEquip equip : equips.values()) {
            if (equip == null) {
                continue;
            }
            if (this.partCodes.contains(equip.itemDb.code)) {
                list.add(equip.itemDb.code);
            }
        }
        return list;
    }
}


