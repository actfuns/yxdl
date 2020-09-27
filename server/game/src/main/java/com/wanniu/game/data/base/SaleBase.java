package com.wanniu.game.data.base;


public abstract class SaleBase {
    public int iD;
    public int typeID;
    public String typeName;
    public int itemID;
    public String itemShowName;
    public String itemCode;
    public int isDynamic;
    public int isBind;
    public int itemCount;
    public int goldPrice;
    public int cashPrice;
    public int diamondPrice;
    public int moneyType;
    public int needMoney;

    public Integer getKey() {
        return Integer.valueOf(this.iD);
    }


    public void beforeProperty() {
    }


    public void initProperty() {
        if (this.goldPrice > 0) {
            this.moneyType = 1;
            this.needMoney = this.goldPrice;
        } else if (this.cashPrice > 0) {
            this.moneyType = 2;
            this.needMoney = this.cashPrice;
        } else if (this.diamondPrice > 0) {
            this.moneyType = 3;
            this.needMoney = this.diamondPrice;
        }
    }
}


