package com.wanniu.game.data;


public class AchievementCO {
    public int id;
    public int chapterID;
    public int conditionType;
    public String name;
    public String des;
    public String targetID;
    public int targetNum;
    public int schedule;
    public int broadCast;
    public String icon;
    public String awardKey;
    public int awardValue;

    public int getKey() {
        return this.id;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


