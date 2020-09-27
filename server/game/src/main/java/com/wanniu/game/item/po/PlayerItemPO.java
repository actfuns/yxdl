package com.wanniu.game.item.po;

import java.io.Serializable;
import java.util.Date;


public class PlayerItemPO
        implements Serializable {
    private static final long serialVersionUID = 1L;
    public String id;
    public String code;
    public int groupCount;
    public int isNew;
    public ItemSpeData speData = new ItemSpeData();


    public int isBind;


    public int noAuction;


    public int isBindFilter;


    public int noAuctionFilter;

    public long cdTime;

    public Date gotTime;


    public PlayerItemPO() {
        this.isBindFilter = -1;
        this.noAuctionFilter = -1;
    }


    public PlayerItemPO copy() {
        PlayerItemPO po = new PlayerItemPO();
        po.id = this.id;
        po.code = this.code;
        po.groupCount = this.groupCount;
        po.isNew = this.isNew;
        po.speData = this.speData;
        po.isBind = this.isBind;
        po.noAuction = this.noAuction;
        po.cdTime = this.cdTime;
        po.gotTime = this.gotTime;
        po.isBindFilter = this.isBindFilter;
        po.noAuctionFilter = this.noAuctionFilter;
        return po;
    }
}


