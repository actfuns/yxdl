package com.wanniu.game.shopMall;

import com.alibaba.fastjson.JSON;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.data.CardCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ShopMallConfigCO;
import com.wanniu.game.data.SocialFriendCO;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.data.ext.ExchangeMallExt;
import com.wanniu.game.data.ext.ShopMallItemsExt;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailPlayerData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.LogReportService;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.poes.ShopMallPO;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pomelo.Common;
import pomelo.area.PlayerHandler;
import pomelo.area.ShopMallHandler;

public class ShopMallManager {
    private WNPlayer player;

    public static ShopMallItemData createShopMallItemData(String jsonString) {
        ShopMallItemData data = (ShopMallItemData) JSON.parseObject(jsonString, ShopMallItemData.class);
        return data;
    }

    public ShopMallPO db;

    public class ShopMallData {
        public String itemType;
        public int moneyType;
        public int isOpen;
        public String name;
        public int isLimit;
    }

    public class ShopMallResult {
        public boolean result;
        public String msg;
        public int totalNum;

        public ShopMallResult(boolean result, String msg) {
            this.result = result;
            this.msg = msg;
        }
    }


    public ShopMallManager(WNPlayer player, ShopMallPO db) {
        this.player = player;
        this.db = db;
        if (this.db == null) {
            this.db = new ShopMallPO();
            this.db.dayMallItemNums = new HashMap<>();
            this.db.weekMallItemNums = new HashMap<>();
            this.db.seenTab = new HashMap<>();

            refreshNewDay();
            refreshNewWeek();
            PlayerPOManager.put(ConstsTR.shopMallTR, this.player.getId(), (GEntity) this.db);
        }
    }

    public final ShopMallResult buyMallItem(String itemId, int count, String playerId, int bDiamond) {
        ShopMallResult result = new ShopMallResult(true, null);

        ShopMallConfigCO shopMallConfigCO = null;

        ShopMallItemsExt mallItemProp = ShopMallConfig.getInstance().fingShowMallItemByID(itemId);
        ExchangeMallExt exchangeMallExt = ShopMallConfig.getInstance().findExchangeMallItemByID(itemId);
        Date now = new Date();
        Date endTime = null;


        if (mallItemProp == null && exchangeMallExt == null) {
            return new ShopMallResult(false, LangService.getValue("ITEM_NULL"));
        }

        if (mallItemProp != null) {

            if (mallItemProp.buyTimes > 0 || mallItemProp.weekBuyTimes > 0) {
                int remainNum = getSelfMallItemRemainNum(mallItemProp.iD);
                if ((remainNum > 0 && remainNum < count) || remainNum == 0) {
                    return new ShopMallResult(false, LangService.getValue("SHOPMALL_LIMIT_ITEM_OVER"));
                }
            }

            shopMallConfigCO = (ShopMallConfigCO) GameData.ShopMallConfigs.get(Integer.valueOf(mallItemProp.itemType));
            endTime = mallItemProp.endTime;
        }
        if (exchangeMallExt != null) {

            if (exchangeMallExt.exchangeTimes > 0 || exchangeMallExt.weekExchangeTimes > 0 || exchangeMallExt.totalTimes > 0) {
                int remainNum = getSelfMallExchangeItemRemainNum(exchangeMallExt.iD);
                if ((remainNum > 0 && remainNum < count) || remainNum == 0) {
                    return new ShopMallResult(false, LangService.getValue("SHOPMALL_LIMIT_ITEM_OVER"));
                }
            }

            shopMallConfigCO = (ShopMallConfigCO) GameData.ShopMallConfigs.get(Integer.valueOf(exchangeMallExt.itemType));
            endTime = exchangeMallExt.endTime;
        }

        if (!isValidOfMallTab(shopMallConfigCO.itemType)) {
            return new ShopMallResult(false, LangService.getValue("SHOPMALL_ITEM_OPEN_NOT"));
        }

        if (endTime != null && now.getTime() > endTime.getTime()) {
            return new ShopMallResult(false, LangService.getValue("SHOPMALL_LIMIT_ITEM_OVER"));
        }

        if (StringUtil.isNotEmpty(playerId) && !this.player.friendManager.isFriend(playerId)) {
            return new ShopMallResult(false, LangService.getValue("FRIEND_FIND_NONE"));
        }


        int itemNum = -1;
        if (mallItemProp != null) {
            int priceSingle = mallItemProp.price2;
            if (priceSingle <= 0) {
                priceSingle = mallItemProp.price;
            }
            int costNum = priceSingle * count;
            itemNum = mallItemProp.num * count;

            if (shopMallConfigCO.consumeType == Const.SHOP_MALL_CONSUME_TYPE.DIAMOND.getValue()) {

                if (!this.player.moneyManager.enoughDiamond(costNum)) {
                    return new ShopMallResult(false, LangService.getValue("DIAMAND_NOT_ENOUGH"));
                }
            } else if (shopMallConfigCO.consumeType == Const.SHOP_MALL_CONSUME_TYPE.TICKET.getValue()) {

                if (!this.player.moneyManager.enoughTicketAndDiamond(costNum)) {
                    return new ShopMallResult(false, LangService.getValue("DIAMAND_NOT_ENOUGH"));
                }
            }

            int consumePoint = mallItemProp.points * count;

            this.player.moneyManager.addConsumePoint(consumePoint, Const.GOODS_CHANGE_TYPE.shop);

            List<Common.KeyValueStruct> itemChange = new ArrayList<>();
            Common.KeyValueStruct.Builder it = Common.KeyValueStruct.newBuilder();
            it.setKey(mallItemProp.itemCode);
            it.setValue(String.valueOf(itemNum));
            itemChange.add(it.build());


            if (shopMallConfigCO.consumeType == Const.SHOP_MALL_CONSUME_TYPE.DIAMOND.getValue()) {
                this.player.moneyManager.costDiamond(costNum, Const.GOODS_CHANGE_TYPE.shop, itemChange);
            } else if (shopMallConfigCO.consumeType == Const.SHOP_MALL_CONSUME_TYPE.TICKET.getValue()) {
                this.player.moneyManager.costTicketAndDiamond(costNum, Const.GOODS_CHANGE_TYPE.shop, itemChange);
            }


            if (StringUtil.isEmpty(playerId)) {
                int forceType = mallItemProp.isBind;
                if (!this.player.getWnBag().testAddCodeItem(mallItemProp.itemCode, itemNum, Const.ForceType.getE(forceType))) {
                    return new ShopMallResult(false, LangService.getValue("BAG_FULL"));
                }
                Out.info(new Object[]{"商城购买 playerId=", this.player.getId(), ",itemId=", mallItemProp.itemCode, ",count=", Integer.valueOf(itemNum)});
                Map<Integer, Object> currencyList = new HashMap<>();
                currencyList.put(Integer.valueOf(mallItemProp.consumeType), Integer.valueOf(priceSingle));
                this.player.getWnBag().addCodeItem(mallItemProp.itemCode, itemNum, Const.ForceType.getE(forceType), Const.GOODS_CHANGE_TYPE.shop, currencyList);
            } else {
                MailPlayerData mailData = new MailPlayerData();
                mailData.mailSender = this.player.getName();
                mailData.mailSenderId = this.player.getId();
                mailData.mailTitle = LangService.getValue("SHOPMALL_SEND_FRIEND_ITEM_TITLE");
                mailData.mailText = LangService.getValue("SHOPMALL_SEND_FRIEND_ITEM").replace("{playerName}", this.player.getName()).replace("{itemNum}", String.valueOf(itemNum)).replace("{itemName}", mallItemProp.name);
                mailData.mailRead = 1;
                mailData.mailIcon = (this.player.getPlayer()).pro;
                ArrayList<MailData.Attachment> atts = new ArrayList<>();
                MailData.Attachment att = new MailData.Attachment();
                att.itemCode = mallItemProp.itemCode;
                att.itemNum = itemNum;
                atts.add(att);
                mailData.attachments = atts;
                MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.shop);

                int friendshipNum = ((SocialFriendCO) GameData.SocialFriends.get(Integer.valueOf(7))).friendshipNum;

                String messageText = ((SocialFriendCO) GameData.SocialFriends.get(Integer.valueOf(7))).messageText;


                this.player.baseDataManager.addFriendly(friendshipNum);
                this.player.pushDynamicData("friendly", Integer.valueOf(this.player.player.friendly));
                PlayerPO friend = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
                PlayerUtil.sendSysMessageToPlayer(messageText.replace("{playerName}", friend.name).replace("itemName", mallItemProp.name), this.player.getId());
            }

            result.totalNum = this.player.bag.findItemNumByCode(mallItemProp.itemCode);

            if (mallItemProp.buyTimes > 0 || mallItemProp.weekBuyTimes > 0) {
                addSelfMallItemNum(mallItemProp.iD, count);
            }


            LogReportService.getInstance().ansycReportShop(this.player, mallItemProp.itemCode, itemNum, shopMallConfigCO.consumeType, costNum);
        }
        if (exchangeMallExt != null) {
            itemNum = exchangeMallExt.num * count;

            for (Map.Entry<String, Integer> entry : (Iterable<Map.Entry<String, Integer>>) exchangeMallExt.exchangeNeedMap.entrySet()) {
                if (this.player.bag.findItemNumByCode((String) entry.getKey()) < ((Integer) entry.getValue()).intValue() * count) {
                    return new ShopMallResult(false, "");
                }
            }

            int forceType = exchangeMallExt.isBind;
            if (!this.player.getWnBag().testAddCodeItem(exchangeMallExt.itemCode, itemNum, Const.ForceType.getE(forceType))) {
                return new ShopMallResult(false, LangService.getValue("BAG_FULL"));
            }

            for (Map.Entry<String, Integer> entry : (Iterable<Map.Entry<String, Integer>>) exchangeMallExt.exchangeNeedMap.entrySet()) {
                this.player.bag.discardItem(entry.getKey(), ((Integer) entry.getValue()).intValue() * count, Const.GOODS_CHANGE_TYPE.shop);
            }

            Out.info(new Object[]{"商城兑换 playerId=", this.player.getId(), ",itemId=", exchangeMallExt.itemCode, ",count=", Integer.valueOf(count)});

            this.player.getWnBag().addCodeItem(exchangeMallExt.itemCode, itemNum, Const.ForceType.getE(forceType), Const.GOODS_CHANGE_TYPE.shop);

            result.totalNum = this.player.bag.findItemNumByCode(exchangeMallExt.itemCode);

            if (exchangeMallExt.exchangeTimes > 0 || exchangeMallExt.weekExchangeTimes > 0) {
                addSelfMallExchangeItemNum(exchangeMallExt.iD, count);
            }
        }

        return result;
    }

    public final ArrayList<ShopMallHandler.MallItem.Builder> getMallItemList(int itemType) {
        ArrayList<ShopMallHandler.MallItem.Builder> items = new ArrayList<>();
        Date now = new Date();
        if (!isValidOfMallTab(itemType)) {
            return items;
        }
        seeTab(itemType);


        List<ShopMallItemsExt> mallItems = GameData.findShopMallItemss(t -> (t.itemType == itemType));
        List<ExchangeMallExt> exchangeMallExts = GameData.findExchangeMalls(t -> (t.itemType == itemType));
        if (mallItems != null) {
            for (ShopMallItemsExt mallItem : mallItems) {
                if (mallItem.serveLimit == Const.SHOP_MALL_SERVER_LIMIT.SELF.getValue()) {

                    if (!GWorld.DEBUG && mallItem.itemType == 199) {
                        continue;
                    }

                    int remainNum = getSelfMallItemRemainNum(mallItem.iD);
                    boolean flag = true;
                    if (mallItem.isShow == 0) {
                        flag = false;
                    }
                    if (remainNum == 0 && mallItem.isUseOut == 1) {
                        flag = false;
                    }
                    long endTime = 0L;
                    Date endDate = mallItem.endTime;
                    if (endDate != null) {
                        if (now.getTime() > endDate.getTime()) {
                            flag = false;
                        } else {
                            endTime = endDate.getTime();
                        }
                    }

                    if (flag) {
                        DItemEquipBase itemProp = ItemConfig.getInstance().getItemProp(mallItem.itemCode);
                        if (itemProp != null) {
                            ShopMallHandler.MallItem.Builder data = ShopMallHandler.MallItem.newBuilder();
                            data.setId(mallItem.iD);
                            data.setCode(mallItem.itemCode);
                            data.setGroupCount(mallItem.num);
                            data.setOriginPrice(mallItem.price);
                            int nowPrice = (mallItem.price2 <= 0) ? mallItem.price : mallItem.price2;
                            data.setNowPrice(nowPrice);
                            data.setDisCount(mallItem.series);
                            data.setEndTime((int) (endTime / 1000L));
                            data.setRemainNum(remainNum);
                            data.setConsumeScore(mallItem.points);
                            data.setCanSend(1);
                            switch (mallItem.isBind) {
                                case 1:
                                    data.setBindType(1);
                                    data.setCanSend(0);
                                    break;
                                case 2:
                                    data.setBindType(0);
                                    break;
                                default:
                                    data.setBindType(itemProp.bindType);
                                    break;
                            }
                            items.add(data);
                            continue;
                        }
                        Out.error(new Object[]{"there is no shop item prop, code : ", mallItem.itemCode});
                    }
                }
            }
        }


        if (exchangeMallExts != null) {
            for (ExchangeMallExt mallItem : exchangeMallExts) {

                if (!GWorld.DEBUG && mallItem.itemType == 199) {
                    continue;
                }

                int remainNum = getSelfMallExchangeItemRemainNum(mallItem.iD);
                boolean flag = true;
                if (mallItem.isShow == 0) {
                    flag = false;
                }
                if (remainNum == 0 && mallItem.isUseOut == 1) {
                    flag = false;
                }
                long endTime = 0L;
                Date endDate = mallItem.endTime;
                if (endDate != null) {
                    if (now.getTime() > endDate.getTime()) {
                        flag = false;
                    } else {
                        endTime = endDate.getTime();
                    }
                }

                if (flag) {
                    DItemEquipBase itemProp = ItemConfig.getInstance().getItemProp(mallItem.itemCode);
                    if (itemProp != null) {
                        ShopMallHandler.MallItem.Builder data = ShopMallHandler.MallItem.newBuilder();
                        data.setId(mallItem.iD);
                        data.setCode(mallItem.itemCode);
                        data.setGroupCount(mallItem.num);
                        data.setOriginPrice(0);
                        data.setNowPrice(0);
                        data.setDisCount(0);
                        data.setEndTime((int) (endTime / 1000L));
                        data.setRemainNum(remainNum);
                        data.setConsumeScore(0);
                        data.setCanSend(1);
                        switch (mallItem.isBind) {
                            case 1:
                                data.setBindType(1);
                                data.setCanSend(0);
                                break;
                            case 2:
                                data.setBindType(0);
                                break;
                            default:
                                data.setBindType(itemProp.bindType);
                                break;
                        }
                        items.add(data);
                        continue;
                    }
                    Out.error(new Object[]{"there is no shop item prop, code : ", mallItem.itemCode});
                }
            }
        }


        return items;
    }

    public final List<ShopMallHandler.MallTab.Builder> getMallTabs() {
        List<ShopMallHandler.MallTab.Builder> tabs = new ArrayList<>();
        for (ShopMallConfigCO shopMallTabsProp : GameData.ShopMallConfigs.values()) {
            if (shopMallTabsProp.isOpened == 1 || GWorld.DEBUG) {

                if (!GWorld.DEBUG && shopMallTabsProp.itemType == 199) {
                    continue;
                }
                ShopMallHandler.MallTab.Builder data = ShopMallHandler.MallTab.newBuilder();
                data.setMoneyType(shopMallTabsProp.consumeType);
                data.setItemType(shopMallTabsProp.itemType);
                if (isValidOfMallLimitItemTab(shopMallTabsProp.itemType)) {
                    data.setIsOpen(1);
                } else {
                    data.setIsOpen(0);
                }
                data.setScriptNum(getSuperScriptNum(shopMallTabsProp.itemType));
                data.setName(shopMallTabsProp.labelName);

                if (shopMallTabsProp.itemType == Const.SHOP_MALL_ITEM_TYPE.DIAMOND_LIMIT.getValue() || shopMallTabsProp.itemType == Const.SHOP_MALL_ITEM_TYPE.TICKET_LIMIT.getValue() || shopMallTabsProp.itemType == Const.SHOP_MALL_ITEM_TYPE.ITEM_LIMIT.getValue()) {
                    data.setIsLimit(1);
                } else {
                    data.setIsLimit(0);
                }
                data.setLastNumText(shopMallTabsProp.remainNum);
                tabs.add(data);
            }
        }
        return tabs;
    }

    public final void refreshNewDay() {
        if (this.db.seenTab == null) {
            this.db.seenTab = new HashMap<>();
        }
        if (this.db.dayMallItemNums == null) {
            this.db.dayMallItemNums = new HashMap<>();
        }

        if (this.db.seenTab.containsKey(Integer.valueOf(Const.SHOP_MALL_CONSUME_TYPE.DIAMOND.getValue()))) {
            ((Map) this.db.seenTab.get(Integer.valueOf(Const.SHOP_MALL_CONSUME_TYPE.DIAMOND.getValue()))).clear();
        } else {
            this.db.seenTab.put(Integer.valueOf(Const.SHOP_MALL_CONSUME_TYPE.DIAMOND.getValue()), new HashMap<>());
        }
        if (this.db.seenTab.containsKey(Integer.valueOf(Const.SHOP_MALL_CONSUME_TYPE.TICKET.getValue()))) {
            ((Map) this.db.seenTab.get(Integer.valueOf(Const.SHOP_MALL_CONSUME_TYPE.TICKET.getValue()))).clear();
        } else {
            this.db.seenTab.put(Integer.valueOf(Const.SHOP_MALL_CONSUME_TYPE.TICKET.getValue()), new HashMap<>());
        }
        this.db.dayMallItemNums.clear();
        this.db.dayMallExchangeItemNums.clear();
    }


    public void refreshNewWeek() {
        if (this.db.weekMallItemNums == null) {
            this.db.weekMallItemNums = new HashMap<>();
        }

        this.db.weekMallItemNums.clear();
        this.db.weekMallExchangeItemNums.clear();
        this.db.resetTime = new Date();
    }


    public void onLogin() {
        Date now = new Date();
        Date monday = ShopMallService.getInstance().getResetTime();
        if (now.getTime() > monday.getTime() && (this.db.resetTime == null || this.db.resetTime.getTime() < monday.getTime())) {
            refreshNewWeek();
        }
    }

    private final void seeTab(int itemType) {
        ShopMallConfigCO shopMallConfigCO = (ShopMallConfigCO) GameData.ShopMallConfigs.get(Integer.valueOf(itemType));
        if (shopMallConfigCO == null) {
            return;
        }
        if (this.db.seenTab.containsKey(Integer.valueOf(shopMallConfigCO.consumeType))) {
            Map<Integer, Boolean> node = (Map<Integer, Boolean>) this.db.seenTab.get(Integer.valueOf(shopMallConfigCO.consumeType));
            node.put(Integer.valueOf(itemType), Boolean.valueOf(true));
        } else {
            Map<Integer, Boolean> node = new HashMap<>();
            node.put(Integer.valueOf(itemType), Boolean.valueOf(true));
            this.db.seenTab.put(Integer.valueOf(shopMallConfigCO.consumeType), node);
        }
    }

    private final void addSelfMallItemNum(String id, int count) {
        int num = 0;
        if (this.db.dayMallItemNums.containsKey(id)) {
            num = ((Integer) this.db.dayMallItemNums.get(id)).intValue();
        } else {
            this.db.dayMallItemNums.put(id, Integer.valueOf(num));
        }
        num += count;
        this.db.dayMallItemNums.put(id, Integer.valueOf(num));

        int weekNum = 0;
        if (this.db.weekMallItemNums == null) {
            this.db.weekMallItemNums = new HashMap<>();
        }
        if (this.db.weekMallItemNums.containsKey(id)) {
            weekNum = ((Integer) this.db.weekMallItemNums.get(id)).intValue();
        } else {
            this.db.weekMallItemNums.put(id, Integer.valueOf(weekNum));
        }
        weekNum += count;
        this.db.weekMallItemNums.put(id, Integer.valueOf(weekNum));
    }

    private final void addSelfMallExchangeItemNum(String id, int count) {
        int num = 0;
        if (this.db.dayMallExchangeItemNums.containsKey(id)) {
            num = ((Integer) this.db.dayMallExchangeItemNums.get(id)).intValue();
        } else {
            this.db.dayMallExchangeItemNums.put(id, Integer.valueOf(num));
        }
        num += count;
        this.db.dayMallExchangeItemNums.put(id, Integer.valueOf(num));

        int weekNum = 0;
        if (this.db.weekMallExchangeItemNums.containsKey(id)) {
            weekNum = ((Integer) this.db.weekMallExchangeItemNums.get(id)).intValue();
        } else {
            this.db.weekMallExchangeItemNums.put(id, Integer.valueOf(weekNum));
        }
        weekNum += count;
        this.db.weekMallExchangeItemNums.put(id, Integer.valueOf(weekNum));

        int totalNum = 0;
        if (this.db.totalMallExchangeItemNums.containsKey(id)) {
            totalNum = ((Integer) this.db.totalMallExchangeItemNums.get(id)).intValue();
        } else {
            this.db.totalMallExchangeItemNums.put(id, Integer.valueOf(totalNum));
        }
        totalNum += count;
        this.db.totalMallExchangeItemNums.put(id, Integer.valueOf(totalNum));
    }

    private final int getSelfMallItemRemainNum(String id) {
        int useNum = 0;
        if (this.db.dayMallItemNums.containsKey(id)) {
            useNum = ((Integer) this.db.dayMallItemNums.get(id)).intValue();
        } else {
            this.db.dayMallItemNums.put(id, Integer.valueOf(useNum));
        }

        ShopMallItemsExt mallItemProp = ShopMallConfig.getInstance().fingShowMallItemByID(id);

        int remainNum = -1;
        int dayTime = mallItemProp.buyTimes;
        int weekTime = mallItemProp.weekBuyTimes;

        if (dayTime > 0) {
            int vip = this.player.baseDataManager.getVip();
            int add = 0;
            if (vip > 0) {
                add = ((CardCO) GameData.Cards.get(Integer.valueOf(vip))).prv7;
            }
            remainNum = mallItemProp.buyTimes + add - useNum;
            remainNum = (remainNum >= 0) ? remainNum : 0;
        }

        if (weekTime > 0) {
            useNum = 0;
            if (this.db.weekMallItemNums.containsKey(id)) {
                useNum = ((Integer) this.db.weekMallItemNums.get(id)).intValue();
            } else {
                this.db.weekMallItemNums.put(id, Integer.valueOf(useNum));
            }
            remainNum = mallItemProp.weekBuyTimes - useNum;
            remainNum = (remainNum > 0) ? remainNum : 0;
        }

        return remainNum;
    }


    private final int getSelfMallExchangeItemRemainNum(String id) {
        ExchangeMallExt exchangeMallExt = ShopMallConfig.getInstance().findExchangeMallItemByID(id);

        int remainNum = -1;

        int dayTime = exchangeMallExt.exchangeTimes;
        int weekTime = exchangeMallExt.weekExchangeTimes;
        int totalTime = exchangeMallExt.totalTimes;


        if (dayTime > 0) {


            int dayUseNum = 0;
            if (this.db.dayMallExchangeItemNums.containsKey(id)) {
                dayUseNum = ((Integer) this.db.dayMallExchangeItemNums.get(id)).intValue();
            } else {
                this.db.dayMallExchangeItemNums.put(id, Integer.valueOf(dayUseNum));
            }

            remainNum = exchangeMallExt.exchangeTimes - dayUseNum;
            remainNum = (remainNum >= 0) ? remainNum : 0;
        }

        if (weekTime > 0) {
            int weekUseNum = 0;
            if (this.db.weekMallExchangeItemNums.containsKey(id)) {
                weekUseNum = ((Integer) this.db.weekMallExchangeItemNums.get(id)).intValue();
            } else {
                this.db.weekMallExchangeItemNums.put(id, Integer.valueOf(weekUseNum));
            }

            remainNum = exchangeMallExt.weekExchangeTimes - weekUseNum;
            remainNum = (remainNum > 0) ? remainNum : 0;
        }

        if (totalTime > 0) {
            int weekUseNum = 0;
            if (this.db.totalMallExchangeItemNums.containsKey(id)) {
                weekUseNum = ((Integer) this.db.totalMallExchangeItemNums.get(id)).intValue();
            } else {
                this.db.totalMallExchangeItemNums.put(id, Integer.valueOf(weekUseNum));
            }

            remainNum = exchangeMallExt.totalTimes - weekUseNum;
            remainNum = (remainNum > 0) ? remainNum : 0;
        }

        return remainNum;
    }

    private final boolean isValidOfMallTab(int itemType) {
        boolean result = isOpenOfMallTab(itemType);
        if (!result) {
            return false;
        }
        if ((itemType == Const.SHOP_MALL_ITEM_TYPE.DIAMOND_LIMIT.getValue() || itemType == Const.SHOP_MALL_ITEM_TYPE.TICKET_LIMIT.getValue() || itemType == Const.SHOP_MALL_ITEM_TYPE.ITEM_LIMIT.getValue()) &&
                !isValidOfMallLimitItemTab(itemType)) {
            return false;
        }

        return true;
    }

    public final boolean isOpenOfMallTab(int itemType) {
        ShopMallConfigCO shopMallConfigCO = (ShopMallConfigCO) GameData.ShopMallConfigs.get(Integer.valueOf(itemType));
        if (shopMallConfigCO == null) {
            return false;
        }

        if (shopMallConfigCO.isOpened == 0 && !GWorld.DEBUG) {
            return false;
        }
        return true;
    }

    private final boolean isValidOfMallLimitItemTab(int itemType) {
        Date now = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        int nowHour = c.get(11);
        ShopMallConfigCO shopMallConfigCO = (ShopMallConfigCO) GameData.ShopMallConfigs.get(Integer.valueOf(itemType));
        if (shopMallConfigCO == null) {
            return false;
        }
        if (shopMallConfigCO.consumeType == Const.SHOP_MALL_CONSUME_TYPE.DIAMOND.getValue() && itemType == Const.SHOP_MALL_ITEM_TYPE.DIAMOND_LIMIT.getValue()) {
            int onSaleTime = GlobalConfig.Shop_OnSaleTime_Diamond;
            int shelfTime = GlobalConfig.Shop_ShelfTime_Diamond;
            if (nowHour < onSaleTime || nowHour >= shelfTime) {
                return false;
            }
        } else if (shopMallConfigCO.consumeType == Const.SHOP_MALL_CONSUME_TYPE.TICKET.getValue() && itemType == Const.SHOP_MALL_ITEM_TYPE.TICKET_LIMIT.getValue()) {
            int onSaleTime = GlobalConfig.Shop_OnSaleTime_Ticket;
            int shelfTime = GlobalConfig.Shop_ShelfTime_Ticket;
            if (nowHour < onSaleTime || nowHour >= shelfTime) {
                return false;
            }
        } else if (shopMallConfigCO.consumeType == Const.SHOP_MALL_CONSUME_TYPE.ITEMCHANGE.getValue() && itemType == Const.SHOP_MALL_ITEM_TYPE.ITEM_LIMIT.getValue()) {
            int onSaleTime = GlobalConfig.Shop_OnSaleTime_Exchange;
            int shelfTime = GlobalConfig.Shop_ShelfTime_Exchange;
            if (nowHour < onSaleTime || nowHour >= shelfTime) {
                return false;
            }
        }
        return true;
    }

    public final List<PlayerHandler.SuperScriptType> getSuperScript() {
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        PlayerHandler.SuperScriptType.Builder script = PlayerHandler.SuperScriptType.newBuilder();
        script.setType(Const.SUPERSCRIPT_TYPE.SHOPMALL.getValue());
        script.setNumber(0);


        if (this.player.functionOpenManager.isOpen(Const.FunctionType.MALL.getValue())) {
            script.setNumber(getSuperScriptAllNum());
        }
        list.add(script.build());
        return list;
    }

    private final int getSuperScriptAllNum() {
        int result = 0;
        for (ShopMallConfigCO shopMallTabsProp : GameData.ShopMallConfigs.values()) {
            int moneyType = shopMallTabsProp.consumeType;
            int itemType = shopMallTabsProp.itemType;
            if (shopMallTabsProp.isOpened == 1) {
                int num = getSuperScriptNum(itemType);
                if (num > 0) {
                    result = num;
                    break;
                }
            }
        }
        return result;
    }

    private final int getSuperScriptNum(int itemType) {
        int result = 0;
        if (itemType != Const.SHOP_MALL_ITEM_TYPE.DIAMOND_LIMIT.getValue() && itemType != Const.SHOP_MALL_ITEM_TYPE.TICKET_LIMIT.getValue()) {


            List<ShopMallItemsExt> mallItems = GameData.findShopMallItemss(t -> (t.itemType == itemType));
            for (ShopMallItemsExt mallItem : mallItems) {
                if (mallItem.serveLimit == Const.SHOP_MALL_SERVER_LIMIT.SELF.getValue()) ;
            }
        }


        return result;
    }
}


