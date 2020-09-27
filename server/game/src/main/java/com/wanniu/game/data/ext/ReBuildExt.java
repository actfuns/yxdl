package com.wanniu.game.data.ext;

import com.wanniu.game.data.ReBuildCO;

import java.util.HashMap;
import java.util.Map;


public class ReBuildExt
        extends ReBuildCO {
    public Map<String, Integer> materials;

    public int getKey() {
        return this.iD;
    }


    public void initProperty() {
        this.materials = new HashMap<>();
        this.materials.put(this.mateCode1, Integer.valueOf(this.mateCount1));
        this.materials.put(this.mateCode2, Integer.valueOf(this.mateCount2));
        this.materials.put(this.mateCode3, Integer.valueOf(this.mateCount3));
    }
}


