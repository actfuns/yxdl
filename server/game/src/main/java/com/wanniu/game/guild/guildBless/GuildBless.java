package com.wanniu.game.guild.guildBless;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.BlessItemCO;
import com.wanniu.game.data.GShopCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.GuildBuildingCO;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.data.ext.BlessLevelExt;
import com.wanniu.game.data.ext.BlesslibaoExt;
import com.wanniu.game.data.ext.GShopExt;
import com.wanniu.game.data.ext.GuildSettingExt;
import com.wanniu.game.guild.GuildCommonUtil;
import com.wanniu.game.guild.GuildMsg;
import com.wanniu.game.guild.GuildRandomItem;
import com.wanniu.game.guild.GuildResult;
import com.wanniu.game.guild.GuildService;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.guild.RecordInfo;
import com.wanniu.game.guild.RoleInfo;
import com.wanniu.game.guild.guidDepot.GuildRecordData;
import com.wanniu.game.guild.guildTech.GuildTech;
import com.wanniu.game.guild.guildTech.GuildTechData;
import com.wanniu.game.guild.po.GuildBlessPO;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.player.WNPlayer;
import io.netty.util.internal.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pomelo.guild.GuildManagerHandler;
import pomelo.item.ItemOuterClass;


public class GuildBless {
    public GuildBlessPO blessData;
    public String id;
    public int logicServerId;
    public int level;
    public Date createTime;
    public int blessValue;
    public int blessValueMax;
    public ArrayList<GuildRecordData> news;
    public Date refreshTime;
    public Map<Integer, GuildBlessPO.GuildBlessItem> blessItems;
    public Map<Const.PlayerBtlData, Integer> bufsAttr;
    public int blessLevel;
    public ArrayList<Integer> goods;
    public GuildTechData techData;
    public int throwAwardState;
    public GuildTech tech;
    public List<Map<String, Integer>> giftLs;
    public float[] blessProcess = new float[]{0.3F, 0.6F, 1.0F};


    public int randIndexByWeight(List<GuildRandomItem> objArr, String weightKey) {
        if (objArr.size() == 0) {
            return -1;
        }
        String key = "weight";
        if (!StringUtil.isNullOrEmpty(weightKey)) {
            key = weightKey;
        }


        int totalWeight = 0;
        for (int i = 0; i < objArr.size(); i++) {
            GuildRandomItem randomItem = objArr.get(i);
            if (null != randomItem) {
                totalWeight += randomItem.getPropertyValue(key);
            }
        }
        int randNum = Utils.random(1, totalWeight);
        int totalNum = 0;
        for (int j = 0; j < objArr.size(); j++) {
            GuildRandomItem randomItem = objArr.get(j);
            if (null != randomItem) {

                totalNum += randomItem.getPropertyValue(key);
                if (randNum <= totalNum)
                    return j;
            }
        }
        return -1;
    }


    public <T> ArrayList<T> randomSomeFromArray(List<T> buffList, int num) {
        ArrayList<T> resultArray = new ArrayList<>();
        if (null == buffList) {
            return resultArray;
        }

        ArrayList<T> cacheArr = new ArrayList<>();
        for (int i = 0; i < buffList.size(); i++) {
            cacheArr.add(buffList.get(i));
        }

        int randCount = (num <= cacheArr.size()) ? num : cacheArr.size();
        for (int j = 0; j < randCount; j++) {
            int index = Utils.random(0, cacheArr.size() - 1);
            resultArray.add(cacheArr.get(index));
            cacheArr.remove(index);
        }
        return resultArray;
    }


    public Map<String, Integer> randomSomeFromMap(Map<String, Integer> buffMap, int num) {
        Map<String, Integer> _map = new HashMap<>();
        ArrayList<String> cacheArr = new ArrayList<>();
        for (String key : buffMap.keySet()) {
            cacheArr.add(key);
        }

        int randCount = (num <= cacheArr.size()) ? num : cacheArr.size();
        for (int i = 0; i < randCount; i++) {
            int index = Utils.random(0, cacheArr.size() - 1);
            String key = cacheArr.get(index);
            _map.put(key, buffMap.get(key));
            cacheArr.remove(index);
        }

        return _map;
    }

    public GuildBless(GuildBlessPO blessData, int logicServerId) {
        this();
        this.blessData = blessData;
        this.id = blessData.id;
        this.logicServerId = blessData.logicServerId;
        this.level = blessData.level;
        this.createTime = blessData.createTime;


        GuildBlessPO.GuildBlessAllBlob blobData = blessData.allBlobData;
        this.blessValue = blobData.blessValue;
        this.blessValueMax = blobData.blessValueMax;
        this.news = blobData.news;
        this.refreshTime = blobData.refreshTime;
        this.blessItems = blobData.blessItems;
        this.blessLevel = blobData.blessLevel;
        this.giftLs = blessData.gifts;
        refreshBlessProcess();


        this.goods = blobData.goods;
        if (null != this.goods && this.goods.size() == 0) {
            randomShopGoods();
        }

        if (null == blobData.techData) {
            this.tech = new GuildTech(this.id);
        } else {
            this.tech = new GuildTech(blobData.techData);
        }
    }

    public GuildBless() {
        this.giftLs = new ArrayList<>();
        this.blessItems = new HashMap<>();
        this.blessData = new GuildBlessPO();
        resetBlessAwardState();
    }

    public GuildBless(String guildId, int logicServerId) {
        this();
        createDefaultBless(guildId, logicServerId);
    }

    public void resetBlessAwardState() {
        for (int i = 0; i < this.blessData.allBlobData.finishStateArr.length; i++) {
            this.blessData.allBlobData.finishStateArr[i] = Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue();
        }
    }

    public void createDefaultBless(String guildId, int logicServerId) {
        GuildBuildingCO buildProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.BLESS.getValue());
        this.id = guildId;
        this.logicServerId = logicServerId;
        this.level = buildProp.minLv;
        this.createTime = new Date();

        this.blessValue = 0;
        this.blessValueMax = 0;
        this.refreshTime = new Date();
        this.blessData.allBlobData.refreshTime = this.refreshTime;
        this.news = new ArrayList<>();
        this.blessItems = new HashMap<>();
        this.blessLevel = this.level;
        resetBlessAwardState();
        randomBlessItemAndProcess();

        randomShopGoods();

        this.tech = new GuildTech(guildId);
    }

    public void refreshBlessProcess() {
        this.blessValueMax = 0;
        if (null == this.blessItems) {
            return;
        }
        for (GuildBlessPO.GuildBlessItem item : this.blessItems.values()) {
            this.blessValueMax += item.needNum;
        }
    }

    public GuildBlessPO toJson4Serialize() {
        GuildBlessPO data = new GuildBlessPO();
        data.id = this.id;
        data.logicServerId = this.logicServerId;
        data.level = this.level;
        data.createTime = this.createTime;

        GuildBlessPO.GuildBlessAllBlob blobData = new GuildBlessPO.GuildBlessAllBlob();
        blobData.blessValue = this.blessValue;
        blobData.blessValueMax = this.blessValueMax;
        blobData.news = this.news;
        blobData.refreshTime = this.refreshTime;
        blobData.blessItems = this.blessItems;
        blobData.blessLevel = this.blessLevel;
        blobData.finishStateArr = this.blessData.allBlobData.finishStateArr;

        blobData.goods = this.goods;

        blobData.techData = this.tech.toJson4Serialize();

        data.allBlobData = blobData;
        data.gifts = this.giftLs;
        return data;
    }

    public void randomBlessItemAndProcess() {
        randomBlessItem();

        this.blessValue = 0;
        refreshBlessProcess();
    }

    public void randomBlessItem() {
        BlessLevelExt levelProp = GuildUtil.getBlessPropByLevel(this.level);
        List<BlessItemCO> itemPropList = GuildUtil.getBlessItemListByLevel(this.level);
        int kindNum = (levelProp.itemKind < itemPropList.size()) ? levelProp.itemKind : itemPropList.size();

        List<GuildRandomItem> baseItems = new ArrayList<>();
        Map<Integer, GuildBlessPO.GuildBlessItem> resultItems = new HashMap<>();
        int i;
        for (i = 0; i < itemPropList.size(); i++) {
            BlessItemCO prop = itemPropList.get(i);
            GuildRandomItem randomItem = new GuildRandomItem();
            randomItem.id = prop.iD;
            randomItem.weight = prop.pro;
            randomItem.minNum = Math.min(prop.minNeed, prop.maxNeed);
            randomItem.maxNum = Math.max(prop.minNeed, prop.maxNeed);
            baseItems.add(randomItem);
        }

        for (i = 0; i < kindNum; i++) {
            int index = randIndexByWeight(baseItems, null);
            if (-1 == index) {
                break;
            }

            GuildRandomItem itemMap = baseItems.get(index);

            if (null != itemMap) {
                int minX = itemMap.minNum;
                int maxX = itemMap.maxNum;
                int needNum = Utils.random(minX, maxX);
                GuildBlessPO.GuildBlessItem blessItem = new GuildBlessPO.GuildBlessItem();
                blessItem.id = itemMap.id;
                blessItem.finishNum = 0;
                blessItem.needNum = needNum;
                resultItems.put(Integer.valueOf(blessItem.id), blessItem);
                baseItems.remove(index);
            }
        }

        this.blessItems = resultItems;

        this.blessLevel = this.level;

        BlesslibaoExt giftProp = (BlesslibaoExt) GameData.Blesslibaos.get(Integer.valueOf(this.level));
        this.giftLs.clear();

        this.giftLs.add(randomSomeFromMap(giftProp.itemCode30, giftProp.blessBuffNum));
        this.giftLs.add(randomSomeFromMap(giftProp.itemCode60, giftProp.blessBuffNum));
        this.giftLs.add(randomSomeFromMap(giftProp.itemCode100, giftProp.blessBuffNum));
        this.blessData.gifts = this.giftLs;
    }


    public void randomShopGoods() {
        List<GShopExt> itemPropList = GuildUtil.getShopPropList();
        List<GuildRandomItem> baseItems = new ArrayList<>();
        for (int i = 0; i < itemPropList.size(); i++) {
            GShopCO prop = (GShopCO) itemPropList.get(i);
            GuildRandomItem item = new GuildRandomItem();
            item.id = prop.itemID;
            item.weight = prop.pro;
            baseItems.add(item);
        }

        ArrayList<Integer> goodsIdArray = new ArrayList<>();
        for (int j = 0; j < 8; j++) {
            int index = randIndexByWeight(baseItems, null);
            if (index == -1) {
                break;
            }
            goodsIdArray.add(Integer.valueOf(((GuildRandomItem) baseItems.get(index)).id));
            baseItems.remove(index);
        }

        goodsIdArray.sort((a, b) -> a.intValue() - b.intValue());


        this.goods = goodsIdArray;
    }


    public int[] calFinishState() {
        if (this.blessProcess.length != this.blessData.allBlobData.finishStateArr.length) {
            Out.error(new Object[]{"blessProcess.length != this.finishStateArr.length"});
            return null;
        }

        for (int i = 0; i < this.blessData.allBlobData.finishStateArr.length; i++) {
            if (Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue() == this.blessData.allBlobData.finishStateArr[i] &&
                    this.blessValue >= Math.floor((this.blessValueMax * this.blessProcess[i]))) {
                this.blessData.allBlobData.finishStateArr[i] = Const.EVENT_GIFT_STATE.CAN_RECEIVE.getValue();
            }
        }


        return this.blessData.allBlobData.finishStateArr;
    }

    public void checkRefreshNewDay(boolean isPush) {
        randomBlessItemAndProcess();
        randomShopGoods();
        this.tech.refreshNewDay(false);
        this.refreshTime = new Date();
        resetBlessAwardState();
        if (isPush) {
            GuildMsg.TechRefreshGuildMsg msgData = new GuildMsg.TechRefreshGuildMsg();
            msgData.techData.blobData.products = this.tech.products;
            GuildMsg msg = new GuildMsg(Const.NotifyType.BLESS_NEW_DAY_PUSH.getValue(), (GuildMsg.GuildMsgData) msgData);
            GuildService.notifyAllMemberRefreshGuild(this.id, msg, null);
        }
    }

    public void addRecord(GuildRecordData record) {
        record.time = new Date();
        GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
        this.news.add(0, record);
        int len = this.news.size();
        if (len > settingProp.recording) {
            this.news.remove(len - 1);
        }
        saveToRedis();
    }

    public void saveToRedis() {
        GuildBlessPO data = toJson4Serialize();
        GuildUtil.updateGuildBless(data);
    }

    public void saveToMysql() {
        saveToRedis();
    }

    public GuildResult.GuildGiftAndBuffData getGiftAndBuffInfo(int index) {
        GuildResult.GuildGiftAndBuffData data = new GuildResult.GuildGiftAndBuffData();
        Map<String, Integer> giftMap = this.giftLs.get(index);
        if (null != giftMap) {
            data.itemCode = giftMap;
        }
        return data;
    }

    public GuildManagerHandler.GuildBlessInfo toJson4PayLoad() {
        BlessLevelExt levelProp = GuildUtil.getBlessPropByLevel(this.blessLevel);
        GuildManagerHandler.GuildBlessInfo.Builder data = GuildManagerHandler.GuildBlessInfo.newBuilder();
        data.setLevel(this.level);
        data.setBlessValue(this.blessValue);
        data.setBlessValueMax(this.blessValueMax);
        data.addAllFinishState(GuildCommonUtil.toList(this.blessData.allBlobData.finishStateArr));
        data.setBlessCountMax(levelProp.blessTime);


        for (GuildBlessPO.GuildBlessItem item : this.blessItems.values()) {
            GuildManagerHandler.BlessItem.Builder tempInfo = GuildManagerHandler.BlessItem.newBuilder();
            BlessItemCO prop = GuildUtil.getBlessItemById(item.id);
            tempInfo.setId(item.id);
            ItemOuterClass.MiniItem.Builder tmpItem = ItemUtil.getMiniItemData(prop.itemID, item.needNum);
            if (null != tmpItem) {
                tempInfo.setItem(tmpItem);
            } else {
                Out.error(new Object[]{"GuildBless toJson4PayLoad config is null:", prop.itemID});
            }
            tempInfo.setFinishNum(item.finishNum);
            data.addItemList(tempInfo);
        }

        return data.build();
    }

    public List<RecordInfo> getRecordList(int page) {
        List<RecordInfo> list = new ArrayList<>();
        int perPageNum = 50;
        int startIndex = (page - 1) * perPageNum;
        int endIndex = startIndex + perPageNum;
        for (int i = startIndex; i < this.news.size() && i < endIndex; i++) {
            GuildRecordData record = this.news.get(i);
            RecordInfo tempInfo = new RecordInfo();
            tempInfo.time = DateUtil.format(record.time, "MM-dd HH:mm:ss");
            if (null != record.role1 && record.role1.pro > 0) {
                RoleInfo info1 = new RoleInfo();
                info1.pro = record.role1.pro;
                info1.name = record.role1.name;
                tempInfo.role1 = info1;
            }
            if (null != record.role2 && record.role2.pro > 0) {
                RoleInfo info2 = new RoleInfo();
                info2.pro = record.role2.pro;
                info2.name = record.role2.name;
                tempInfo.role1 = info2;
            }

            tempInfo.resultNum = record.result.v1;
            if (!StringUtil.isNullOrEmpty(record.result.v2)) {
                tempInfo.resultStr = record.result.v2;
            }

            if (null != record.item && !StringUtil.isNullOrEmpty(record.item.name)) {
                tempInfo.item = record.item;
            }

            tempInfo.recordType = record.type;
            list.add(tempInfo);
        }
        return list;
    }

    public boolean isTodayValidBlessId(int id) {
        GuildBlessPO.GuildBlessItem blessItem = this.blessItems.get(Integer.valueOf(id));
        if (null == blessItem || blessItem.needNum <= 0) {
            return false;
        }
        return true;
    }

    public boolean isChange(int[] oldState, int[] newState) {
        boolean isChange = false;
        for (int i = 0; i < oldState.length; i++) {
            if (Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue() == oldState[i] && oldState[i] != newState[i]) {
                isChange = true;
            }
        }
        return isChange;
    }

    public GuildResult blessAction(int id, int times, WNPlayer player) {
        GuildResult ret = new GuildResult();
        int[] oldState = new int[3];
        for (int i = 0; i < this.blessData.allBlobData.finishStateArr.length; i++) {
            oldState[i] = this.blessData.allBlobData.finishStateArr[i];
        }

        ((GuildBlessPO.GuildBlessItem) this.blessItems.get(Integer.valueOf(id))).finishNum += times;
        this.blessValue += times;

        int[] newState = calFinishState();

        if (isChange(oldState, newState)) {
            GuildMsg.BlessRefreshGuildMsg msgData = new GuildMsg.BlessRefreshGuildMsg();
            msgData.blessValue = this.blessValue;
            msgData.finishStateArr = newState;
            GuildMsg msg = new GuildMsg(Const.NotifyType.BLESS_FINISH_PUSH.getValue(), (GuildMsg.GuildMsgData) msgData);
            GuildService.notifyAllMemberRefreshGuild(this.id, msg, player.getId());
        }

        BlessItemCO blessItemProp = GuildUtil.getBlessItemById(id);
        DItemEquipBase itemProp = ItemUtil.getPropByCode(blessItemProp.itemID);

        GuildRecordData record = new GuildRecordData();
        record.type = Const.GuildRecord.BLESS_USE_ITEM.getValue();
        record.role1.pro = player.getPro();
        record.role1.name = player.getName();
        record.result.v2 = Integer.toString(times);
        record.item.qColor = itemProp.qcolor;
        record.item.name = itemProp.name;
        addRecord(record);

        GuildResult.GuildBlessActionData data = new GuildResult.GuildBlessActionData();
        data.blessValue = this.blessValue;
        data.id = id;
        data.finishNum = ((GuildBlessPO.GuildBlessItem) this.blessItems.get(Integer.valueOf(id))).finishNum;
        data.finishState = newState;


        BlessLevelExt levelProp = GuildUtil.getBlessPropByLevel(this.level);
        data.buffTime = levelProp.bufftime * 60;
        data.buffIds = randomSomeFromArray(levelProp.buffList, levelProp.blessBuffNum);
        ret.result = 0;
        ret.data = (GuildResult.GuildResultData) data;
        return ret;
    }

    public void upgradeLevel(String playerId) {
        this.level++;
        saveToRedis();
    }
}


