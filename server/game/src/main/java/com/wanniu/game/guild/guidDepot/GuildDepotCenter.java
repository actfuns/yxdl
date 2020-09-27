package com.wanniu.game.guild.guidDepot;

import com.wanniu.core.game.JobFactory;
import com.wanniu.game.common.Const;
import com.wanniu.game.guild.GuildServiceCenter;
import com.wanniu.game.guild.GuildUtil;
import com.wanniu.game.guild.RecordInfo;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildDepotPO;
import com.wanniu.game.poes.GuildMemberPO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pomelo.item.ItemOuterClass;


public class GuildDepotCenter {
    private static GuildDepotCenter instance;
    public Map<String, GuildDepot> depotMap;

    public static GuildDepotCenter getInstance() {
        if (instance == null) {
            instance = new GuildDepotCenter();
        }

        return instance;
    }


    private GuildDepotCenter() {
        this.depotMap = new HashMap<>();
        init();
    }

    public void init() {
        initFromRedis();

        JobFactory.addDelayJob(new Runnable() {
            public void run() {
                GuildDepotCenter.this.saveAllDepot();
            }
        }, Const.Time.Minute.getValue());
    }

    public GuildDepot getDepot(String guildId) {
        return this.depotMap.get(guildId);
    }

    public void initFromRedis() {
        ArrayList<GuildDepotPO> depotList = GuildUtil.getGuildDepotList();
        for (GuildDepotPO depotData : depotList) {
            GuildDepot depot = new GuildDepot(depotData);
            this.depotMap.put(depot.depotData.id, depot);
        }
    }

    public void createDepot(String guildId, int logicServerId) {
        GuildDepot depot = getDepot(guildId);
        if (null == depot) {
            depot = GuildDepot.createEmptyDepot(guildId, logicServerId);
            this.depotMap.put(depot.depotData.id, depot);

            saveDepot(guildId);
        }
    }

    public void saveAllDepot() {
        for (String key : this.depotMap.keySet()) {
            saveDepot(key);
        }
    }

    public void saveDepot(String id) {
        GuildDepot depot = getDepot(id);
        if (null == depot) {
            return;
        }
        GuildDepotPO depotData = depot.toJson4Serialize();
        GuildUtil.updateGuildDepot(depotData);
    }

    public PlayerGuildDepot getDepotDataByPlayerId(WNPlayer player) {
        PlayerGuildDepot data = new PlayerGuildDepot();
        GuildMemberPO myInfo = GuildServiceCenter.getInstance().getGuildMember(player.getId());
        if (null == myInfo) {
            return null;
        }

        GuildDepot depot = getDepot(myInfo.guildId);
        if (null == depot) {
            return data;
        }

        data.depotInfo = depot.getDepotInfo();
        data.bagInfo = depot.bag.toJson4Payload();
        data.detailInfo = depot.bag.getAllEquipDetails4PayLoad(player.playerBasePO);
        return data;
    }

    public ArrayList<RecordInfo> getDepotRecordByPlayerId(String playerId, int page) {
        ArrayList<RecordInfo> data = new ArrayList<>();
        GuildMemberPO myInfo = GuildServiceCenter.getInstance().getGuildMember(playerId);
        if (null == myInfo) {
            return null;
        }

        GuildDepot depot = getDepot(myInfo.guildId);
        if (null == depot) {
            return data;
        }

        data = depot.getRecordList(page);
        return data;
    }

    public ArrayList<ItemOuterClass.ItemDetail> getDepotDetailsByPlayerId(WNPlayer player) {
        ArrayList<ItemOuterClass.ItemDetail> data = new ArrayList<>();
        GuildMemberPO myInfo = GuildServiceCenter.getInstance().getGuildMember(player.getId());
        if (null == myInfo) {
            return null;
        }
        GuildDepot depot = getDepot(myInfo.guildId);
        if (null == depot) {
            return null;
        }
        data = depot.bag.getAllEquipDetails4PayLoad(player.playerBasePO);
        return data;
    }

    public GuildDepotOneGrid getDepotOneGridInfoByPlayerId(WNPlayer player, int bagIndex) {
        GuildDepotOneGrid data = new GuildDepotOneGrid();
        GuildMemberPO myInfo = GuildServiceCenter.getInstance().getGuildMember(player.getId());
        if (null == myInfo) {
            return null;
        }

        GuildDepot depot = getDepot(myInfo.guildId);
        if (null == depot) {
            return null;
        }

        data = depot.bag.getGridAndDetailByIndex(player.playerBasePO, bagIndex);

        return data;
    }
}


