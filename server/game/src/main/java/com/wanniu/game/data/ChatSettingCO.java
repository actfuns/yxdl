package com.wanniu.game.data;


public class ChatSettingCO {
    public int channelID;
    public String channel;
    public String channelShort;
    public int openLv;
    public int coolDown;
    public float coolDownExtra;
    public String fontColor;
    public int isVoice;
    public int autoVoice;
    public int anonymous;
    public int callSomeone;
    public int callTimes;
    public int showConfigure;
    public int fontConfigure;

    public int getKey() {
        return this.channelID;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


