package com.wanniu.game.guild.guildShop;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.GShopCO;
import com.wanniu.game.data.ext.GShopExt;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.guild.GuildService;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.player.WNPlayer;

import java.util.ArrayList;
import java.util.List;

import pomelo.area.GuildShopHandler;
import pomelo.item.ItemOuterClass;


public class GuildShopManager {
    public WNPlayer player;
    public ArrayList<Integer> boughtList;
    public ArrayList<Integer> goods;

    public GuildShopManager(WNPlayer player) {
        this.player = player;
        this.boughtList = new ArrayList<>();
        this.goods = new ArrayList<>();
    }

    public JSONObject toJson4Serialize() {
        JSONObject data = new JSONObject();
        data.put("boughtList ", this.boughtList);
        return data;
    }

    public void refreshNewDay(boolean isNewDay) {
        if (isNewDay && null != this.boughtList) {
            this.boughtList.clear();
        }
    }

    public void refreshGuildTodayGoods() {
        GuildResult ret = GuildService.getGuildTodayGoodsList(this.player);
        if (null != ret && null != this.goods) {
            this.goods = ret.goods;
        }
    }

    public void resetPublicData() {
        if (null != this.goods) {
            this.goods.clear();
        }
    }

    public GuildShopHandler.ShopInfo toJson4PayLoad() {
        GuildShopHandler.ShopInfo.Builder shopInfo = GuildShopHandler.ShopInfo.newBuilder();
        if (null == this.goods || this.goods.size() == 0) {
            return shopInfo.build();
        }

        List<GShopExt> itemPropList = GuildUtil.getShopPropList();
        List<GuildShopHandler.ExchangeItem> todayList = new ArrayList<>();
        List<GuildShopHandler.ExchangeItem> nextList = new ArrayList<>();
        for (int i = 0; i < itemPropList.size(); i++) {
            GShopExt prop = itemPropList.get(i);
            int goodId = prop.itemID;
            ItemOuterClass.MiniItem.Builder miniData = ItemUtil.getMiniItemData(prop.itemCode, prop.itemCount, Const.ForceType.getE(prop.isBind));
            if (null != miniData) {


                GuildShopHandler.ExchangeItem.Builder good = GuildShopHandler.ExchangeItem.newBuilder();
                good.setId(goodId);
                good.setItemShowName(prop.itemShowName);
                good.setItem(miniData.build());
                good.setIsBind(miniData.getBindType());
                good.setItemDes(prop.itemDes);

                good.addAllNeedMoney(prop.moneyReqList);

                good.addAllCondition(getConditions((GShopCO) prop));
                good.setMeetCondition((getConditionStatus((GShopCO) prop) == 0) ? 1 : 0);

                good.setState(Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue());
                if (this.goods.indexOf(Integer.valueOf(goodId)) != -1) {
                    good.setState(Const.EVENT_GIFT_STATE.CAN_RECEIVE.getValue());
                    if (this.boughtList.indexOf(Integer.valueOf(goodId)) != -1) {
                        good.setState(Const.EVENT_GIFT_STATE.RECEIVED.getValue());
                    }
                    todayList.add(good.build());
                } else {
                    nextList.add(good.build());
                }
            }
        }

        nextList.sort((a, b) -> (a.getItem().getQColor() != b.getItem().getQColor()) ? (b.getItem().getQColor() - a.getItem().getQColor()) : ((a.getId() != b.getId()) ? (a.getId() - b.getId()) : 0));


        nextList.subList(11, nextList.size() - 1);


        long miniSeconds = Const.Time.Day.getValue() + Utils.getZeroDate().getTime() - System.currentTimeMillis();
        shopInfo.addAllTodayItems(todayList);
        shopInfo.addAllNextItems(nextList);
        shopInfo.setRefreshTime(0, (int) Math.ceil((miniSeconds / 1000L)));
        return shopInfo.build();
    }

    public GuildShopHandler.ShopCondition newCondition(int type, int num) {
        GuildShopHandler.ShopCondition.Builder data = GuildShopHandler.ShopCondition.newBuilder();
        data.setType(type);
        data.setNumber(num);
        return data.build();
    }

    public List<GuildShopHandler.ShopCondition> getConditions(GShopCO prop) {
        List<GuildShopHandler.ShopCondition> data = new ArrayList<>();
        if (prop.levelReq > 0) {
            data.add(newCondition(1, prop.levelReq));
        }

        if (prop.upReq > 0) {
            data.add(newCondition(2, prop.upReq));
        }

        if (prop.vipReq > 0) {
            data.add(newCondition(3, prop.vipReq));
        }

        if (prop.raceReq > 0) {
            data.add(newCondition(4, prop.raceReq));
        }
        if (prop.raceClass > 0) {
            data.add(newCondition(5, prop.raceClass));
        }

        return data;
    }

    public int getConditionStatus(GShopCO prop) {
        List<GuildShopHandler.ShopCondition> conditions = getConditions(prop);
        for (int i = 0; i < conditions.size(); i++) {
            GuildShopHandler.ShopCondition condition = conditions.get(i);
            int type = condition.getType();
            int number = condition.getNumber();
            if (type == 1 && (this.player.getPlayer()).level < number) {
                return 1;
            }
            if (type == 2 && (this.player.getPlayer()).upLevel < number) {
                return 2;
            }


            if (type == 4) ;


            if (type == 5) ;


            if (type == 6) ;


            if (type == 7) ;
        }


        return 0;
    }
}


