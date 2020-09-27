package com.wanniu.game.data;


public class GuildBossRatioCO {
    public int gBoss_lv;
    public float gBoss_hp_ratio;
    public float gBoss_atk_ratio;
    public float gBoss_def_ratio;
    public float gBoss_hit_ratio;
    public float gBoss_dodge_ratio;
    public float gBoss_crit_ratio;
    public float gBoss_resCrit_ratio;

    public int getKey() {
        return this.gBoss_lv;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


