package com.wanniu.game.data.ext;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.game.data.EnchantCO;


public class EnchantExt
        extends EnchantCO {
    public JSONObject mates = null;


    public void initProperty() {
        this.mates = new JSONObject();
        this.mates.put(this.mateCode1, Integer.valueOf(this.mateCount1));
        this.mates.put(this.mateCode2, Integer.valueOf(this.mateCount2));
    }
}


