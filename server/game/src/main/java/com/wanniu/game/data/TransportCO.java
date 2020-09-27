package com.wanniu.game.data;


public class TransportCO {
    public int transportID;
    public int transMod;
    public String modValue;
    public int needNumber;
    public int count;
    public int targetMap;
    public String targetPoint;
    public String failTips;

    public int getKey() {
        return this.transportID;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


