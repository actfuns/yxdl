package com.wanniu.game.data.ext;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.data.MonsterRefreshCO;

import java.util.HashMap;
import java.util.Map;


public class MonsterRefreshExt
        extends MonsterRefreshCO {
    public String[] monsterRefreshPoints;
    public float pointX = 0.0F;
    public float pointY = 0.0F;

    public Map<String, Integer> joinReward;


    public void initProperty() {
        super.initProperty();

        this.monsterRefreshPoints = this.refreshPoint.split(":");

        String[] xy = this.monPoint.split(",");
        if (xy.length == 2) {
            try {
                this.pointX = Float.parseFloat(xy[0]);
                this.pointY = Float.parseFloat(xy[1]);
            } catch (NumberFormatException e) {
                Out.error(new Object[]{e});
                this.pointX = 0.0F;
                this.pointY = 0.0F;
            }
        }
        if (!StringUtil.isEmpty(this.partakeDropPre)) {
            Map<String, Integer> tempJoinReward = new HashMap<>();
            String[] joins = this.partakeDropPre.split(";");
            if (joins != null && joins.length > 0) {
                for (String j : joins) {
                    String[] js = j.split(":");
                    tempJoinReward.put(js[0], Integer.valueOf(Integer.parseInt(js[1])));
                }
            }
            this.joinReward = tempJoinReward;
        }
    }


    public String getRefreshPoint() {
        return this.monsterRefreshPoints[RandomUtil.getIndex(this.monsterRefreshPoints.length)];
    }

    public boolean containsRefreshPoint(String point) {
        for (String p : this.monsterRefreshPoints) {
            if (p.equalsIgnoreCase(point)) {
                return true;
            }
        }
        return false;
    }
}


