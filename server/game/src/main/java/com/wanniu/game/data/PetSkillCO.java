package com.wanniu.game.data;


public class PetSkillCO {
    public int skillID;
    public String skillName;
    public String skillDesc;
    public int skillType;
    public int maxLevel;
    public int hateRate;
    public int baseHateValue;
    public int cDTime;
    public int costManaPer;
    public String costManaSet;
    public String dmgType;
    public int dmgRate;
    public int dmgRatePerLvl;
    public String exdDmgType;
    public String exdDmgSet;
    public String prop;
    public int propID;
    public int chance;
    public String buffTime;
    public String valueAttributeName1;
    public int valueAttribute1;
    public String valueSet;
    public String valueAttributeName2;
    public int valueAttribute2;
    public String valueSet2;
    public String valueAttributeName3;
    public int valueAttribute3;
    public String valueSet3;
    public int canAuto;
    public int canIronMaiden;
    public String skillIcon;
    public String upReqLevel;
    public String upCostSP;
    public String power;

    public int getKey() {
        return this.skillID;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


