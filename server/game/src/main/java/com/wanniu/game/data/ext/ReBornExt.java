package com.wanniu.game.data.ext;

import com.wanniu.game.data.ReBornCO;

import java.util.HashMap;
import java.util.Map;


public class ReBornExt
        extends ReBornCO {
    public Map<String, Integer> materials;

    public int getKey() {
        return this.level;
    }


    public void initProperty() {
        this.materials = new HashMap<>();
        this.materials.put(this.mateCode1, Integer.valueOf(this.mateCount1));
        this.materials.put(this.mateCode2, Integer.valueOf(this.mateCount2));
    }
}


