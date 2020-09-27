package com.wanniu.game.data;


public class DungeonMonRatioCO {
    public int mon_type;
    public float normal_hp_ratio;
    public float normal_atk_ratio;
    public float normal_def_ratio;
    public float normal_dM_ratio;
    public float hard_hp_ratio;
    public float hard_atk_ratio;
    public float hard_def_ratio;
    public float hard_dM_ratio;

    public int getKey() {
        return this.mon_type;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


