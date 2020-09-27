package com.wanniu.game.data;


public class TowerMonRatioCO {
    public int tower_floor;
    public float towMon_hp_ratio;
    public float towMon_atk_ratio;
    public float towMon_def_ratio;
    public float towMon_hit_ratio;
    public float towMon_dodge_ratio;
    public float towMon_crit_ratio;
    public float towMon_resCrit_ratio;
    public int towMon_lv;

    public int getKey() {
        return this.tower_floor;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


