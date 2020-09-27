package com.wanniu.game.data.ext;

import com.wanniu.game.common.Const;
import com.wanniu.game.data.FashSuitConfigCO;

import java.util.HashMap;
import java.util.Map;


public class FashSuitConfigExt
        extends FashSuitConfigCO {
    public Map<Const.PlayerBtlData, Integer> Attr2Map;
    public Map<Const.PlayerBtlData, Integer> Attr3Map;

    public void initProperty() {
        this.Attr2Map = new HashMap<>();
        this.Attr3Map = new HashMap<>();

        String[] attr2strs = this.attr2.split(";");
        String[] attr3strs = this.attr3.split(";");

        for (String str : attr2strs) {
            String[] sub_str = str.split(":");
            this.Attr2Map.put(Const.PlayerBtlData.getE(Integer.parseInt(sub_str[0])), Integer.valueOf(Integer.parseInt(sub_str[1])));
        }

        for (String str : attr3strs) {
            String[] sub_str = str.split(":");
            this.Attr2Map.put(Const.PlayerBtlData.getE(Integer.parseInt(sub_str[0])), Integer.valueOf(Integer.parseInt(sub_str[1])));
        }
    }
}


