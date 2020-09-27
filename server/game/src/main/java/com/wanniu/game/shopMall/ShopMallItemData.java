package com.wanniu.game.shopMall;

import com.alibaba.fastjson.JSON;
import pomelo.area.ShopMallHandler;

public class ShopMallItemData {
    public String id = "";
    public String code = "";

    public int groupCount;

    public int consumeScore;

    public int isSellOut;

    public int bindType;
    public int isSold;

    public final ShopMallHandler.MallScoreItem createMallScoreItem() {
        ShopMallHandler.MallScoreItem.Builder builder = ShopMallHandler.MallScoreItem.newBuilder();
        builder.setId(this.id);
        builder.setCode(this.code);
        builder.setGroupCount(this.groupCount);
        builder.setConsumeScore(this.consumeScore);
        builder.setIsSellOut(this.isSellOut);
        builder.setBindType(this.bindType);
        return builder.build();
    }

    public final String toJsonString() {
        return JSON.toJSONString(this);
    }
}


