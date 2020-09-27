package com.wanniu.game.data;


public class BaseDataCO {
    public int petID;
    public String petName;
    public String petRank;
    public int qcolor;
    public String type;
    public String petItemCode;
    public int itemCount;
    public String expCode;
    public int initLevel;
    public int basePhyDamage;
    public float phyGrowUp;
    public int baseMagDamage;
    public float magGrowUp;
    public int initHit;
    public float hitGrowUP;
    public int initCrit;
    public float critGrowUP;
    public int initCritDamage;
    public int critDamageGrowUp;
    public float moveSpeed;
    public String initSkill;
    public int masterPropID;
    public String desc;
    public String icon;
    public String model;
    public int modelPercent;
    public float modelY;
    public String sound;

    public int getKey() {
        return this.petID;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


