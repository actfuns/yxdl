package com.wanniu.game.guild.guildDungeon;

import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaData;
import com.wanniu.game.area.AreaEvent;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.area.DamageHealVO;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.GDungeonMapCO;
import com.wanniu.game.data.GDungeonRankCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.guild.GuildCommonUtil;
import com.wanniu.game.guild.GuildService;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildDungeonPO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pomelo.area.GuildHandler;
import pomelo.area.PlayerHandler;
import pomelo.guild.GuildManagerHandler;
import pomelo.item.ItemOuterClass;


public class GuildDungeon
        extends Area {
    public String guildId;
    public int maxCountDungeonId;
    public int dungeonCount;
    public Map<String, GuildDungeonPlayerInfo> playerInfo;
    public boolean isClose;
    public String killplayerId;
    public Map<String, Area.Actor> playerIds;
    private GuildDungeon self = this;

    public GuildDungeon(JSONObject opts) {
        super(opts);
        this.playerIds = this.actors;

        this.guildId = opts.getString("guildId");
        this.maxCountDungeonId = opts.getIntValue("maxCountDungeonId");
        this.dungeonCount = opts.getIntValue("dungeonCount");
        this.playerInfo = new HashMap<>();
        this.isClose = false;
        this.killplayerId = "";


        GuildService.dungeonInit(this.guildId, this.instanceId, "");
    }


    public void onClose(String msg) {
        if (this.isClose) {
            return;
        }

        this.isClose = true;
        List<PlayerItemPO> itemsInfo = new ArrayList<>();
        for (Area.AreaItem dropItem : this.items.values()) {
            itemsInfo.add(dropItem.item.cloneItemDB());
        }

        GuildService.dungeonPass(this.guildId, this.dungeonCount, this.killplayerId);

        for (String id : this.actors.keySet()) {
            WNPlayer player = getPlayer(id);
            if (null == player) {
                continue;
            }
            List<ItemOuterClass.ItemDetail> awardItem = new ArrayList<>();
            for (Area.AreaItem dropItem : this.items.values()) {
                awardItem.add(dropItem.item.getItemDetail(player.playerBasePO).build());
            }

            int state = 0;
            if (this.areaId == this.maxCountDungeonId) {
                state = 1;
            }

            GuildHandler.OnDungeonEndPush.Builder msgPush = GuildHandler.OnDungeonEndPush.newBuilder();
            msgPush.setS2CCode(200);
            msgPush.addAllAwardItem(awardItem);
            msgPush.setState(state);
            msgPush.setLeftTime(60);
            player.receive("area.guildPush.onDungeonEndPush", (GeneratedMessage) msgPush.build());
        }

        GuildService.updateDropItem(this.guildId, this.dungeonCount, itemsInfo);

        GuildDungeonPO data = GuildService.updateDamageAndHeal(this.guildId, this.playerInfo, this.dungeonCount, this.killplayerId);

        if (this.areaId == this.maxCountDungeonId) {
            rankReward(data);
        }


        this.closeFuture = JobFactory.addDelayJob(new Runnable() {
            public void run() {
                for (String id : GuildDungeon.this.playerIds.keySet()) {
                    Area.Actor playerData = GuildDungeon.this.playerIds.get(id);
                    if (playerData.leave)
                        continue;
                    WNPlayer player = GuildDungeon.this.getPlayer(id);
                    if (null != player) {
                        if (GuildDungeon.this.areaId == GuildDungeon.this.maxCountDungeonId) {
                            player.guildManager.leaveDungeon(player);
                            continue;
                        }
                        player.guildManager.joinGuildDungeon(GuildDungeon.this.self, 0);
                    }
                }

                AreaUtil.closeArea(GuildDungeon.this.instanceId);
            }
        } 60000L);
    }


    public void onPlayerEntered(WNPlayer player) {
        try {
            GuildService.updatePlayerNum(this.guildId, this.dungeonCount, getPlayerNum());
        } catch (Exception err) {
            Out.error(new Object[]{"GuildService updatePlayerNum error:", err});
            throw new Error("call GuildService updatePlayerNum error");
        }
    }


    public void onPlayerLeaved(WNPlayer player) {
        super.onPlayerLeaved(player);
        try {
            GuildService.updatePlayerNum(this.guildId, this.dungeonCount, getPlayerNum());
        } catch (Exception err) {
            Out.error(new Object[]{"GuildService updatePlayerNum error:", err});
            throw new Error("call GuildService updatePlayerNum error");
        }
    }

    public void closeGuildDungeon() {
        if (this.isClose) {
            return;
        }

        List<PlayerItemPO> itemsInfo = new ArrayList<>();
        for (Area.AreaItem dropItem : this.items.values()) {
            itemsInfo.add(dropItem.item.cloneItemDB());
        }

        try {
            GuildService.updateDropItem(this.guildId, this.dungeonCount, itemsInfo);
            GuildDungeonPO data = GuildService.updateDamageAndHeal(this.guildId, this.playerInfo, this.dungeonCount, this.killplayerId);

            rankReward(data);

            for (String id : this.playerIds.keySet()) {
                Area.Actor playerData = this.playerIds.get(id);
                if (playerData.leave) {
                    continue;
                }
                WNPlayer player = getPlayer(id);

                if (null != player) {
                    player.guildManager.leaveDungeon(player);
                }
            }

            addCloseFuture();
        } catch (Exception err) {
            Out.error(new Object[]{"closeGuildDungeon error:", err});
            throw new Error("closeGuildDungeon error");
        }
    }


    public int getRank(ArrayList<GuildManagerHandler.RankInfo> rankInfo, String playerId) {
        for (int i = 0; i < rankInfo.size(); i++) {
            if (((GuildManagerHandler.RankInfo) rankInfo.get(i)).getPlayerId() == playerId) {
                return i + 1;
            }
        }
        return 0;
    }

    public void rankReward(GuildDungeonPO data) {
        Map<String, Integer> playerScores = new HashMap<>();
        for (Integer dungeonCount : data.damagePlayer.keySet()) {
            ArrayList<String> damagePlayers = (ArrayList<String>) data.damagePlayer.get(dungeonCount);
            for (String id : damagePlayers) {
                List<GDungeonMapCO> props = GameData.findGDungeonMaps(t -> (t.type == Const.SCENE_TYPE.GUILD_DUNGEON.getValue()));


                props.sort((o1, o2) -> o1.layer - o2.layer);


                if (playerScores.containsKey(id)) {
                    int scores = ((Integer) playerScores.get(id)).intValue();
                    playerScores.put(id, Integer.valueOf(scores + ((GDungeonMapCO) props.get(dungeonCount.intValue() - 1)).gpoints));
                    continue;
                }
                playerScores.put(id, Integer.valueOf(((GDungeonMapCO) props.get(dungeonCount.intValue() - 1)).gpoints));
            }
        }


        for (String id : playerScores.keySet()) {
            int dungeonScore = ((Integer) playerScores.get(id)).intValue();
            int rank = getRank(data.damageRankInfo, id);
            GDungeonRankCO rankProp = GuildCommonUtil.findGDungeonRanks(1, rank);
            if (null != rankProp) {
                dungeonScore += rankProp.gpoints;
            }

            rank = getRank(data.healRankInfo, id);
            rankProp = GuildCommonUtil.findGDungeonRanks(2, rank);
            if (null != rankProp) {
                dungeonScore += rankProp.gpoints;
            }

            WNPlayer player = PlayerUtil.getOnlinePlayer(id);
            if (null != player) {
                player.addGuildPoint(dungeonScore);
                player.pushDynamicData("guildpoint", Integer.valueOf(player.player.guildpoint));
                continue;
            }
            MailSysData mailData = new MailSysData("Guild_dungeon_integral");
            mailData.attachments = new ArrayList();
            MailData.Attachment attach = new MailData.Attachment();
            attach.itemCode = "guildpoint";
            attach.itemNum = dungeonScore;
            mailData.attachments.add(attach);
            MailUtil.getInstance().sendMailToOnePlayer(id, (MailData) mailData, Const.GOODS_CHANGE_TYPE.GUILD_BOSS);
        }
    }


    public void onBattleReport(List<DamageHealVO> datas) {
        for (DamageHealVO data : datas) {
            GuildDungeonPlayerInfo info = new GuildDungeonPlayerInfo();
            info.damage = data.TotalDamage;
            info.heal = data.TotalHealing;
            this.playerInfo.put(data.PlayerUUID, info);
            WNPlayer player = getPlayer(data.PlayerUUID);
            if (null != player) {
                player.guildManager.setJoinDungeonGuildId(this.guildId);
            }
        }
    }


    public void onKillBoss(String playerId) {
        this.killplayerId = playerId;
    }

    public boolean canRebirth(String playerId) {
        Area.Actor playerData = (Area.Actor) this.actors.get(playerId);
        if (null != playerData) {
            MapBase mapBase = this.prop;
            if (mapBase.revival == 0)
                return false;
            if (mapBase.revival < 0)
                return true;
            if (playerData.rebornNum >= mapBase.revival) {
                return false;
            }
            playerData.rebornNum++;
        }

        return true;
    }

    public boolean isDamagePlayer(Map<Integer, ArrayList<String>> damagePlayer, int dungeonCount, String playerId) {
        ArrayList<String> eachCountDamage = damagePlayer.get(Integer.valueOf(dungeonCount));
        if (null != eachCountDamage && eachCountDamage.size() > 0) {
            int index = eachCountDamage.indexOf(playerId);
            if (index != -1) {
                return true;
            }
        }
        return false;
    }


    public PlayerHandler.ReliveResponse.Builder relive(String playerId, Area.ReliveType reliveType) {
        PlayerHandler.ReliveResponse.Builder res = PlayerHandler.ReliveResponse.newBuilder();
        Area.Actor actor = this.playerIds.get(playerId);
        WNPlayer player = getPlayer(playerId);
        if (null == actor || null == player) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("REVIVE_NOT_FIND_PLAYER"));
            return res;
        }

        if (this.prop.revival > 0 && actor.rebornNum >= this.prop.revival) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("REVIVE_MAX"));
            return res;
        }

        return super.relive(playerId, reliveType);
    }

    public int reviveNum(String playerId) {
        MapBase mapBase = this.prop;
        Area.Actor playerData = this.playerIds.get(playerId);
        if (null == playerData) {
            return 0;
        }

        int configNum = mapBase.revival;
        if (configNum <= 0) {
            return configNum;
        }
        if (configNum <= playerData.rebornNum) {
            return 0;
        }
        return configNum - playerData.rebornNum;
    }


    public void onPlayerDeadByMonster(String playerId, AreaEvent.MonsterData monsterData) {
        Area.Actor playerData = this.playerIds.get(playerId);
        if (null == playerData) {
            Out.error(new Object[]{"onPlayerDead not exist! :", playerId});
            return;
        }
        WNPlayer player = getPlayer(playerId);
        PlayerHandler.PlayerRelivePush.Builder data = newPlayerRelivePush(player);
        int overTime = GlobalConfig.Dungeon_DeadBack_Time;
        data.setCountDown(overTime);
    }


    public void addPlayer(WNPlayer player) {
        setForce(player);
        String enterSceneData = toJSON4EnterScene(player);
        try {
            playerEnterRequest(player, enterSceneData);
            this.hasPlayerEntered = true;

            if (null == this.actors.get(player.getId())) {
                this.playerIds.put(player.getId(), new Area.Actor());
            }
        } catch (Exception error) {
            Out.error(new Object[]{"c# enter scene id: ", this.instanceId, "enterSceneData:", enterSceneData});
            Out.error(new Object[]{"c# enter scene id: ", this.instanceId, " error : ", error});
            throw error;
        }
    }


    public void removePlayer(WNPlayer player, boolean keepObject) {
        String playerId = player.getId();
        if (hasPlayer(playerId)) {
            playerLeaveRequest(player, keepObject);
            onPlayerLeaved(player);

            resetEmptyTime();


            ((Area.Actor) this.playerIds.get(playerId)).leave = true;
        }
    }


    public void dispose() {
        for (String playerId : this.playerIds.keySet()) {
            if (((Area.Actor) this.playerIds.get(playerId)).leave)
                continue;
            WNPlayer player = getPlayer(playerId);

            AreaUtil.dispatchByAreaId(player, new AreaData(player.playerTempData.historyAreaId, player.playerTempData.historyX, player.playerTempData.historyY), null);
        }

        getZoneManager().destroyZoneRequest(this.instanceId);
    }

    public void cleanDropItems() {
    }
}


