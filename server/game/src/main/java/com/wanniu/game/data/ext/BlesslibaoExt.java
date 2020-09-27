package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.data.BlesslibaoCO;

import java.util.HashMap;
import java.util.Map;


public class BlesslibaoExt
        extends BlesslibaoCO {
    public Map<String, Integer> itemCode30 = new HashMap<>();
    public Map<String, Integer> itemCode60 = new HashMap<>();
    public Map<String, Integer> itemCode100 = new HashMap<>();


    public void initLs(String code, Map<String, Integer> map) {
        String[] rewards = code.split(",");
        for (int i = 0; i < rewards.length; i++) {
            String[] _elem = rewards[i].split(":");
            if (2 != _elem.length) {
                Out.error(new Object[]{"the config err in Blesslibao.json"});
            } else {

                map.put(_elem[0], Integer.valueOf(_elem[1]));
            }
        }
    }

    public void initProperty() {
        super.initProperty();
        initLs(this.blessAward30, this.itemCode30);
        initLs(this.blessAward60, this.itemCode60);
        initLs(this.blessAward100, this.itemCode100);
    }
}


