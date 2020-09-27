package com.wanniu.game.data;


public class AchievementConfigCO {
    public int typeId;
    public String type;
    public int unlock;
    public int lock;
    public int lv;
    public int quest;
    public String awardKey;

    public int getKey() {
        return this.typeId;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


