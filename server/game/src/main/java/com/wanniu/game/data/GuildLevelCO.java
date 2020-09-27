package com.wanniu.game.data;


public class GuildLevelCO {
    public int position;
    public int exp;
    public int funds;
    public int gold;
    public int building1;
    public int building2;
    public int building3;
    public int member;
    public int maxExpDay;
    public int maxFundsDay;

    public int getKey() {
        return this.position;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


