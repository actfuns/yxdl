package com.wanniu.game.guild.guildTech;

import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.GTechnologyItemCO;
import com.wanniu.game.data.GTechnologyLevelCO;
import com.wanniu.game.data.GuildBuildingCO;
import com.wanniu.game.guild.GuildMsg;
import com.wanniu.game.guild.GuildService;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.player.WNPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GuildTech {
    public String id;
    public int level;
    public int buffLevel;
    public int refreshLevel;
    public Map<String, Integer> products;

    public int randIndexByWeight(ArrayList<Map<String, Integer>> objArr, String weightKey) {
        if (objArr.size() == 0) {
            return -1;
        }

        String key = "weight";
        if (null != weightKey) {
            key = weightKey;
        }

        int totalWeight = 0;
        for (int i = 0; i < objArr.size(); i++) {
            totalWeight += ((Integer) ((Map) objArr.get(i)).get(key)).intValue();
        }
        int randNum = Utils.random(1, totalWeight);
        int totalNum = 0;
        for (int j = 0; j < objArr.size(); j++) {
            totalNum += ((Integer) ((Map) objArr.get(j)).get(key)).intValue();
            if (randNum <= totalNum) {
                return j;
            }
        }
        return -1;
    }


    public GuildTech(GuildTechData techData) {
        this.id = techData.id;
        GuildTechData.GuildTechBlob blobData = techData.blobData;
        this.level = blobData.level;
        this.buffLevel = blobData.buffLevel;
        this.refreshLevel = blobData.refreshLevel;
        this.products = blobData.products;
        if (null != this.products && this.products.size() > 0) {
            randomProduce();
        }
    }

    public GuildTech(String guildId) {
        createDefaultTech(guildId);
    }

    public void createDefaultTech(String guildId) {
        GuildBuildingCO buildProp = GuildUtil.getGuildBuildingProp(Const.GuildBuilding.TECH.getValue());
        this.id = guildId;
        this.level = buildProp.minLv;
        this.buffLevel = 0;
        this.refreshLevel = this.level;
        this.products = new HashMap<>();

        randomProduce();
    }

    public void randomProduce() {
        this.refreshLevel = this.level;
        if (null != this.products) {
            this.products.clear();
        }
        Map<Integer, GTechnologyItemCO> producePropList = GuildUtil.getTechProducePropList();
        GTechnologyLevelCO levelProp = GuildUtil.getTechLevelPropByLevel(this.refreshLevel);

        ArrayList<Map<String, Integer>> produceList = new ArrayList<>();
        for (GTechnologyItemCO prop : producePropList.values()) {
            Map<String, Integer> item = new HashMap<>();
            item.put("iD", Integer.valueOf(prop.iD));
            item.put("pro", Integer.valueOf(prop.pro));
            item.put("count", Integer.valueOf(prop.count));
            produceList.add(item);
        }

        int kindNum = (levelProp.techItemDayCount < produceList.size()) ? levelProp.techItemDayCount : produceList.size();
        for (int i = 0; i < kindNum; i++) {
            int index = randIndexByWeight(produceList, "pro");
            if (index == -1) {
                break;
            }
            Map<String, Integer> item = produceList.get(index);
            this.products.put(Integer.toString(((Integer) item.get("iD")).intValue()), item.get("count"));
            produceList.remove(index);
        }
    }


    public void refreshNewDay(boolean isPush) {
        randomProduce();
        if (isPush) {
            GuildMsg.TechRefreshGuildMsg msgData = new GuildMsg.TechRefreshGuildMsg();
            msgData.techData.blobData.products = this.products;
            GuildMsg msg = new GuildMsg(Const.NotifyType.TECH_NEW_DAY_PUSH.getValue(), (GuildMsg.GuildMsgData) msgData);
            GuildService.notifyAllMemberRefreshGuild(this.id, msg, null);
        }
    }

    public GuildTechData toJson4Serialize() {
        GuildTechData data = new GuildTechData();
        data.id = this.id;
        data.blobData = new GuildTechData.GuildTechBlob();
        data.blobData.level = this.level;
        data.blobData.buffLevel = this.buffLevel;
        data.blobData.refreshLevel = this.refreshLevel;
        data.blobData.products = this.products;
        return data;
    }


    public void upgradeLevel(WNPlayer player) {
        this.level++;
        GuildMsg.TechRefreshGuildMsg msgData = new GuildMsg.TechRefreshGuildMsg();
        msgData.techData.blobData.level = this.level;
        GuildMsg msg = new GuildMsg(Const.NotifyType.TECH_LEVEL_PUSH.getValue(), (GuildMsg.GuildMsgData) msgData);
        GuildService.notifyAllMemberRefreshGuild(this.id, msg, player.getId());
    }

    public void upgradeBuffLevel(WNPlayer player) {
        this.buffLevel++;
        GuildMsg.TechRefreshGuildMsg msgData = new GuildMsg.TechRefreshGuildMsg();
        msgData.techData.blobData.buffLevel = this.buffLevel;
        GuildMsg msg = new GuildMsg(Const.NotifyType.TECH_BUFF_LEVEL_PUSH.getValue(), (GuildMsg.GuildMsgData) msgData);
        GuildService.notifyAllMemberRefreshGuild(this.id, msg, player.getId());
    }
}


