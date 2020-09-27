package com.wanniu.game.data;


public class AchievementSeniorCO {
    public int id;
    public int chapterID;
    public int conditionType;
    public String name;
    public String des;
    public int quality;
    public int point;
    public String targetID;
    public int targetNum;
    public int schedule;
    public int broadCast;
    public String icon;

    public int getKey() {
        return this.id;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


