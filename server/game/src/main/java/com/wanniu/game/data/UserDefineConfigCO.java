package com.wanniu.game.data;


public class UserDefineConfigCO {
    public int mon_type;
    public float def_ratio;
    public float hit_ratio;
    public float dodge_ratio;
    public float crit_ratio;
    public float resCrit_ratio;

    public int getKey() {
        return this.mon_type;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


