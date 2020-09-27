package com.wanniu.game.data;


public class SkillDataCO {
    public int skillID;
    public int skillIndex;
    public String skillName;
    public String pro;
    public int tab;
    public int skillType;
    public String skillDesc;
    public int maxLevel;
    public int preSkillID;
    public String preSkillName;
    public int preSkillLevel;
    public int enSkillID;
    public int learnSkill;
    public String skillIcon;
    public String upReqLevel;
    public String upCostGold;
    public String upCostSP;
    public String upCostItem;
    public String videoFile;
    public int resByWeapon;
    public String power;

    public int getKey() {
        return this.skillID;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


