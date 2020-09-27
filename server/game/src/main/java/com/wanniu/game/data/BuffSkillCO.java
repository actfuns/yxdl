package com.wanniu.game.data;


public class BuffSkillCO {
    public int buffID;
    public String effectName;
    public String effectDesc;
    public int par;
    public int coldTime;
    public int time;
    public int min;
    public int max;
    public int isFormat;
    public int repeat;
    public String buffIcon;

    public int getKey() {
        return this.buffID;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


