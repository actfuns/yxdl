package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.MasteryPropCO;
import com.wanniu.game.player.AttributeUtil;

import java.util.Map;
import java.util.TreeMap;

public class MasteryPropExt extends MasteryPropCO {
    public Map<String, Integer> attrs;
    public MasteryCostItem costs;
    public Const.Position Coords;

    public static class MasteryCostItem {
        public String itemCode;

        public MasteryCostItem(String itemCode, int itemNum) {
            this.itemCode = itemCode;
            this.itemNum = itemNum;
        }


        public int itemNum;
    }

    public void initProperty() {
        Map<String, Integer> data = new TreeMap<>();
        String key = AttributeUtil.getKeyByName(this.prop);
        if (key != null) {
            data.put(key, Integer.valueOf(this.value));
        } else {

            Out.error(new Object[]{"MasteryLevelProp attrName not exist ", this.prop});
        }
        this.attrs = data;
        MasteryCostItem costs = new MasteryCostItem(this.costItem, this.itemCount);
        this.costs = costs;


        String[] str = this.coord.split(",");
        Const.Position coord = new Const.Position(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        if (coord.y == 0) {
            Out.error(new Object[]{"MasteryLevelProp y is null " + this.iD});
        }
        this.Coords = coord;
    }
}


