package com.wanniu.game.data;


public class GuildSettingCO {
    public int joinLv;
    public int cost;
    public int selfOut;
    public int kickOut;
    public int fireOut;
    public int fireNum;
    public int applicationFail;
    public int impeach;
    public int impeachTime;
    public int impeachNo;
    public int announcement;
    public String defaultNote;
    public int recording;
    public int applyMax;
    public int nameMaxLen;
    public int maxLen;
    public String changeName;
    public int changeNameCost;
    public int changeNameCD;
    public int warehousePutIn;
    public int warehouseDel;
    public int warehouseMinLv;
    public int warehouseMinQ;
    public float gTechItemRefreshTime;
    public String gBossOpenTime;
    public String gBossShowTime;
    public String gBossCloseTime;

    public int getKey() {
        return this.joinLv;
    }

    public void initProperty() {
    }

    public void beforeProperty() {
    }
}


