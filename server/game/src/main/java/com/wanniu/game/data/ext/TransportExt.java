package com.wanniu.game.data.ext;

import com.wanniu.core.util.StringUtil;
import com.wanniu.game.data.TransportCO;

import java.util.HashMap;
import java.util.Map;


public class TransportExt
        extends TransportCO {
    public int targetX;
    public int targetY;
    public Map<String, Integer> targetPoint_;

    public void initProperty() {
        if (!StringUtil.isEmpty(this.targetPoint)) {
            String[] targetPointStr = this.targetPoint.split(",");
            int targetX = (int) Float.parseFloat(targetPointStr[0]);
            int targetY = (int) Float.parseFloat(targetPointStr[1]);
            this.targetPoint_ = new HashMap<>();
            this.targetPoint_.put("targetX", Integer.valueOf(targetX));
            this.targetPoint_.put("targetY", Integer.valueOf(targetY));
        }
    }
}


