package com.wanniu.game.data.base;


public class DItemEquipBase {
    public String name;
    public String type;
    public String code;
    public String desc;
    public int price;
    public int salePrice;
    public int levelReq;
    public int qcolor;
    public String icon;
    public int groupCount;
    public int purchaseCount;
    public String pro;
    public int noDestory;
    public int noSell;
    public int noTrade;
    public int noAuction;
    public int noDepotRole;
    public int noDepotAcc;
    public int noDepotGuild;
    public String showId;
    public String avatarId;
    public int star;
    public int bindType;
    public int itemType;
    public int itemSecondType;
    public int itemTypeId;
    public int Pro;

    public DItemEquipBase copy() {
        DItemEquipBase base = new DItemEquipBase();
        base.name = this.name;
        base.type = this.type;
        base.code = this.code;
        base.desc = this.desc;
        base.price = this.price;
        base.salePrice = this.salePrice;
        base.levelReq = this.levelReq;
        base.qcolor = this.qcolor;
        base.icon = this.icon;
        base.groupCount = this.groupCount;
        base.purchaseCount = this.purchaseCount;
        base.pro = this.pro;
        base.noDestory = this.noDestory;
        base.noSell = this.noSell;
        base.noTrade = this.noTrade;
        base.noAuction = this.noAuction;
        base.noDepotRole = this.noDepotRole;
        base.noDepotAcc = this.noDepotAcc;
        base.noDepotGuild = this.noDepotGuild;
        base.showId = this.showId;
        base.avatarId = this.avatarId;
        base.star = this.star;
        base.bindType = this.bindType;

        base.itemType = this.itemType;
        base.itemSecondType = this.itemSecondType;
        base.itemTypeId = this.itemTypeId;
        base.Pro = this.Pro;

        return base;
    }

    public void beforeProperty() {
    }
}


