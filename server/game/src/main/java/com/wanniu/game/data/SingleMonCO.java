package com.wanniu.game.data;


public class SingleMonCO {
    public int mon_level;
    public int mon_type;
    public int maxHP;
    public int attack;
    public int def;
    public int hit;
    public int dodge;
    public int crit;
    public int resCirt;

    public int getKey() {
        return this.mon_level;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


