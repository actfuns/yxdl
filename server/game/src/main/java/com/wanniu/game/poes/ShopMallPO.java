package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@DBTable("player_shop_mall")
public final class ShopMallPO
        extends GEntity {
    public Map<Integer, Map<Integer, Boolean>> seenTab;
    public Map<String, Integer> dayMallItemNums = new HashMap<>();
    public Map<String, Integer> weekMallItemNums = new HashMap<>();
    public Map<String, Integer> dayMallExchangeItemNums = new HashMap<>();
    public Map<String, Integer> weekMallExchangeItemNums = new HashMap<>();
    public Map<String, Integer> totalMallExchangeItemNums = new HashMap<>();
    public Date resetTime;

    public ShopMallPO(Map<Integer, Map<Integer, Boolean>> seenTab) {
        this();
        this.seenTab = seenTab;
    }

    public ShopMallPO() {
    }
}


