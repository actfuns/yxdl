package com.wanniu.game.data;


public class PassiveSkillCO {
    public int skillID;
    public String skillName;
    public String skillDesc;
    public int skillType;
    public int maxLevel;
    public int target;
    public String skillIcon;
    public int hateRate;
    public String baseHateValue;
    public int cDTime;
    public int minCDTime;
    public String dmgType;
    public int dmgRate;
    public int dmgRatePerLvl;
    public String exdDmgType;
    public String exdDmgSet;
    public int passiveTrigger;
    public int triggerChance;
    public int triggerCondition;
    public int passiveProp1;
    public int passiveProp2;
    public String prop;
    public int chance;
    public int buffTime;
    public int magValueSet1;
    public int magValueSet2;
    public String valueAttributeName1;
    public String valueSet;
    public String valueAttributeName2;
    public String valueSet2;
    public String valueAttributeName3;
    public String valueSet3;

    public int getKey() {
        return this.skillID;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


