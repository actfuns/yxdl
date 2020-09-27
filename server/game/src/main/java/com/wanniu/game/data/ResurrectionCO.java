package com.wanniu.game.data;


public class ResurrectionCO {
    public int mapID;
    public String mapName;
    public int safeResurrect;
    public int backResurrect;
    public int immResurrect;
    public int resurrectNum;
    public int lieDown;
    public int autoResurrectTime;
    public int resurrectCD;
    public int freeResurrect;
    public int cost;

    public int getKey() {
        return this.mapID;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


