package com.wanniu.game.data;


public class LimitTimeGiftCO {
    public int id;
    public String name;
    public int condition;
    public int value;
    public int minLevel;
    public int maxLevel;
    public int pushPro;
    public int onlyPushOne;
    public String rewardItem;
    public int limitTime;
    public int price;
    public String atlasRoute;
    public String atlasID;

    public int getKey() {
        return this.id;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


