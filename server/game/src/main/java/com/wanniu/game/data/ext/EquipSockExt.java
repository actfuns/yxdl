package com.wanniu.game.data.ext;

import com.wanniu.game.data.EquipSockCO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EquipSockExt
        extends EquipSockCO {
    public Map<Integer, Integer> sockOpenLevel;
    public List<String> typeList;

    public void initProperty() {
        this.sockOpenLevel = new HashMap<>();
        this.sockOpenLevel.put(Integer.valueOf(1), Integer.valueOf(this.sock1OpenLvl));
        this.sockOpenLevel.put(Integer.valueOf(2), Integer.valueOf(this.sock2OpenLvl));
        this.sockOpenLevel.put(Integer.valueOf(3), Integer.valueOf(this.sock3OpenLvl));
        this.sockOpenLevel.put(Integer.valueOf(4), Integer.valueOf(this.sock4OpenLvl));
        this.sockOpenLevel.put(Integer.valueOf(5), Integer.valueOf(this.sock5OpenLvl));

        this.typeList = Arrays.asList(this.gemTypeList.split(","));
    }
}


