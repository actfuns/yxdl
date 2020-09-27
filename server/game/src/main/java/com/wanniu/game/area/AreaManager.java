package com.wanniu.game.area;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GConfig;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.arena.ArenaArea;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.cross.CrossServerArea;
import com.wanniu.game.cross.CrossServerLocalArea;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.fightLevel.FightLevel;
import com.wanniu.game.five2Five.Five2FiveArea;
import com.wanniu.game.guild.guildBoss.GuildBossArea;
import com.wanniu.game.guild.guildDungeon.GuildDungeon;
import com.wanniu.game.guild.guildFort.GuildFortPveArea;
import com.wanniu.game.guild.guildFort.GuildFortPvpArea;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.solo.SoloArea;
import com.wanniu.game.task.TaskEvent;
import com.wanniu.game.task.TaskUtils;
import com.wanniu.game.team.TeamData;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


public class AreaManager {
    private static AreaManager instance;
    public static final Map<String, Area> CrossServerAreas = new ConcurrentHashMap<>();
    public static final Map<String, ProxyArea> ProxyServerAreas = new ConcurrentHashMap<>();


    public static AreaManager getInstance() {
        if (instance == null) {
            instance = new AreaManager();
        }
        return instance;
    }

    private AreaMap allAreas = new AreaMap();

    public AreaMap getAreaMap() {
        return this.allAreas;
    }

    public final void init() {
        int interval = 600000;

        JobFactory.addScheduleJob(() -> refreshAreas(), interval, interval);


        JobFactory.addScheduleJob(() -> refreshAreaItems(), 2000L, 2000L);
    }


    public void onCloseGame() {
        for (Area area : CrossServerAreas.values()) {
            try {
                area.dispose(true);
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }
        for (Area area : this.allAreas.values()) {
            try {
                area.dispose(true);
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }
    }


    public final void refreshAreas() {
        Out.debug(new Object[]{"--------------------------start clear area----------------------------"});
        for (Map.Entry<String, Area> node : this.allAreas.entrySet()) {
            refreshAreaStatu(node.getKey());
        }
        Out.debug(new Object[]{"--------------------------after clear area----------------------------"});
    }


    public final void refreshAreaItems() {
        long now = System.currentTimeMillis();
        int leftTime = GlobalConfig.itemdrop_lock_lifeTime;
        Area area = null;
        Area.AreaItem areaItem = null;
        for (Map.Entry<String, Area> node : this.allAreas.entrySet()) {
            area = node.getValue();
            for (Map.Entry<String, Area.AreaItem> entry : area.items.entrySet()) {
                areaItem = entry.getValue();
                if (now >= areaItem.createTime + leftTime &&
                        area.onCleanItem(areaItem)) {
                    area.items.remove(entry.getKey());
                }
            }
        }
    }


    public final Area getArea(String instanceId) {
        Area area = this.allAreas.get(instanceId);
        if (area == null) {
            area = CrossServerAreas.get(instanceId);
        }
        if (area == null) {
            area = ProxyServerAreas.get(instanceId);
        }
        return area;
    }


    public final void refreshAreaStatu(String instanceId) {
        Area area = this.allAreas.get(instanceId);
        if (area != null) {
            boolean flag = area.isValid();
            if (!flag) {
                closeArea(instanceId);
            }
        }
    }


    public final void closeAreaNoPlayer(String instanceId) {
        Area area = this.allAreas.get(instanceId);
        if (area != null &&
                area.canCloseNoPlayer()) {
            closeArea(instanceId);
        }
    }


    public final void closeArea(String instanceId) {
        Area area = getArea(instanceId);
        if (area != null) {
            try {
                area.dispose();
            } catch (Exception e) {
                Out.error(new Object[]{e});
            } finally {
                if (this.allAreas.remove(instanceId) == null) {
                    CrossServerAreas.remove(instanceId);
                }
            }
            Out.debug(new Object[]{"closeArea instanceId:", area.prop.name, " :", instanceId});
        } else {
            Out.warn(new Object[]{"more closeArea instanceId:", instanceId});
        }
    }

    public final Area dispatchByAreaId(WNPlayer player, JSONObject playerInfo) {
        int addCount = 1;
        TeamData.TeamMemberData member = player.getTeamManager().getTeamMember();
        if (member != null && member.isLeader) {
            addCount = player.getTeamManager().followCount();
        }
        Area area = this.allAreas.dispactch(playerInfo.getIntValue("areaId"), playerInfo.getIntValue("logicServerId"), addCount);
        if (area == null) {
            return createArea(player, playerInfo);
        }
        return area;
    }


    public final Area createArea(WNPlayer player, JSONObject data) {
        Out.debug(new Object[]{"createArea areaData:", data});

        int areaId = data.getIntValue("areaId");
        MapBase prop = AreaUtil.getAreaProp(areaId);
        if (prop != null) {
            GuildFortPvpArea guildFortPvpArea;
            String instanceId = UUID.randomUUID().toString();
            boolean usespaceDiv = false;
            if (prop.type == Const.SCENE_TYPE.NORMAL.getValue() || prop.type == Const.SCENE_TYPE.ILLUSION.getValue() || prop.type == Const.SCENE_TYPE.CROSS_SERVER.getValue()) {
                usespaceDiv = true;
            }
            JSONObject enterData = new JSONObject();
            enterData.put("monsterHard", prop.monsterHard);
            enterData.put("calPKValue", Boolean.valueOf((prop.ignorePkRule == 0)));
            enterData.put("allowAutoGuard", Boolean.valueOf((prop.autoFight == 1)));
            enterData.put("usespaceDiv", Boolean.valueOf(usespaceDiv));
            enterData.put("sceneType", Integer.valueOf(prop.type));
            enterData.put("canRiding", Boolean.valueOf((prop.rideMount == 1)));

            if (prop.type == Const.SCENE_TYPE.LOOP.getValue()) {
                TeamData team = player.getTeamManager().getTeam();
                int averageLevel = TaskUtils.getAvgLevel(team);
                enterData.put("averageLevel", Integer.valueOf(averageLevel));
                enterData.put("floorRatio", Integer.valueOf(1));
                enterData.put("propRatio", Float.valueOf(GlobalConfig.Loop_Hard_Rate));
            } else if (prop.type == Const.SCENE_TYPE.RESOURCE_DUNGEON.getValue()) {
                enterData.put("averageLevel", Integer.valueOf(player.getLevel()));
                enterData.put("floorRatio", Integer.valueOf(1));
                enterData.put("propRatio", Float.valueOf(GlobalConfig.Fate_Resource_Rate));
            } else if (prop.type == Const.SCENE_TYPE.DEMON_TOWER.getValue()) {
                enterData.put("averageLevel", Integer.valueOf(1));
                enterData.put("floorRatio", Integer.valueOf(data.getIntValue("lv")));
                enterData.put("propRatio", Float.valueOf(GlobalConfig.PropRatio));
            } else if (prop.type == Const.SCENE_TYPE.GUILD_BOSS.getValue()) {
                enterData.put("averageLevel", Integer.valueOf(data.getIntValue("lv")));
                enterData.put("floorRatio", Integer.valueOf(0));
                enterData.put("propRatio", Integer.valueOf(1));
            } else {
                enterData.put("averageLevel", Integer.valueOf(0));
            }

            Out.debug(new Object[]{"createArea instanceId:", instanceId, " templateId:", Integer.valueOf(prop.templateID), " enterData:", enterData});

            if (prop.type != Const.SCENE_TYPE.CROSS_SERVER.getValue() || !GConfig.getInstance().isEnableProxy()) {
                player.setBattleServerId(GWorld.__CS_NODE.getNodeId());
            }

            player.getZoneManager().createZoneRequest(player.getBattleServerId(), prop.templateID, instanceId, enterData.toJSONString());

            int fullAllowedNum = prop.allowedPlayers;
            int maxAllowedNum = prop.allowedPlayers;
            data.put("instanceId", instanceId);
            Area area = null;
            if (prop.type == Const.SCENE_TYPE.NORMAL.getValue()) {
                area = new Area(data);
                fullAllowedNum = prop.fullPlayers;
                maxAllowedNum = prop.maxPlayers;
            } else if (prop.type == Const.SCENE_TYPE.FIGHT_LEVEL.getValue()) {
                FightLevel fightLevel = new FightLevel(data, Const.SCENE_TYPE.FIGHT_LEVEL);
            } else if (prop.type == Const.SCENE_TYPE.FIGHT_LEVEL_ULTRA.getValue()) {
                FightLevel fightLevel = new FightLevel(data, Const.SCENE_TYPE.FIGHT_LEVEL_ULTRA);
            } else if (prop.type == Const.SCENE_TYPE.LOOP.getValue()) {
                FightLevel fightLevel = new FightLevel(data, Const.SCENE_TYPE.LOOP);
            } else if (prop.type == Const.SCENE_TYPE.RESOURCE_DUNGEON.getValue()) {
                area = new ResourceDungeon(data);
            } else if (prop.type == Const.SCENE_TYPE.DEMON_TOWER.getValue()) {
                area = new DemonTower(data);
            } else if (prop.type == Const.SCENE_TYPE.SIN_COM.getValue()) {
                SoloArea soloArea = new SoloArea(data);
            } else if (prop.type == Const.SCENE_TYPE.ARENA.getValue()) {
                ArenaArea arenaArea = new ArenaArea(data);
            } else if (prop.type == Const.SCENE_TYPE.CROSS_SERVER.getValue()) {
                area = GConfig.getInstance().isEnableProxy() ? (Area) new CrossServerArea(data) : (Area) new CrossServerLocalArea(data);
                fullAllowedNum = prop.fullPlayers;
                maxAllowedNum = prop.maxPlayers;
            } else if (prop.type == Const.SCENE_TYPE.GUILD_DUNGEON.getValue()) {
                GuildDungeon guildDungeon = new GuildDungeon(data);
            } else if (prop.type != Const.SCENE_TYPE.WORLD_BOSS.getValue()) {


                if (prop.type == Const.SCENE_TYPE.GUILD_BOSS.getValue()) {
                    GuildPO guildPo = player.guildManager.guild;
                    GuildBossArea guildBossArea = new GuildBossArea(data, guildPo);
                } else if (prop.type == Const.SCENE_TYPE.ILLUSION.getValue()) {
                    area = new IllusionArea(data);
                    fullAllowedNum = prop.fullPlayers;
                    maxAllowedNum = prop.maxPlayers;
                } else if (prop.type == Const.SCENE_TYPE.FIVE2FIVE.getValue()) {
                    Five2FiveArea five2FiveArea = new Five2FiveArea(data);
                } else if (prop.type == Const.SCENE_TYPE.ILLUSION_2.getValue()) {
                    area = new Illusion2Area(data);
                    fullAllowedNum = prop.fullPlayers;
                    maxAllowedNum = prop.maxPlayers;
                } else if (prop.type == Const.SCENE_TYPE.GUILD_FORT_PVE.getValue()) {
                    GuildFortPveArea guildFortPveArea = new GuildFortPveArea(data);
                } else if (prop.type == Const.SCENE_TYPE.GUILD_FORT_PVP.getValue()) {
                    guildFortPvpArea = new GuildFortPvpArea(data);
                }
            }
            if (guildFortPvpArea != null) {
                Out.info(new Object[]{"create area id :", Integer.valueOf(areaId), " instanceId:", instanceId});
                if (prop.type != Const.SCENE_TYPE.CROSS_SERVER.getValue() || !GConfig.getInstance().isEnableProxy()) {
                    this.allAreas.put(instanceId, (Area) guildFortPvpArea);
                } else {
                    CrossServerAreas.put(instanceId, guildFortPvpArea);
                }
                guildFortPvpArea.bindBattleServer(player);
                ((Area) guildFortPvpArea).fullCount = fullAllowedNum;
                ((Area) guildFortPvpArea).maxCount = maxAllowedNum;
                return (Area) guildFortPvpArea;
            }
            Out.error(new Object[]{"createZone:", Integer.valueOf(areaId), " fail! there is no area type of this,type:", Integer.valueOf(prop.type)});
        } else {

            Out.error(new Object[]{"areaProp is null! mapId:", Integer.valueOf(areaId)});
        }
        return null;
    }


    private static void onPlayerEvent(String playerId, Const.EventType type, Object... param) {
        WNPlayer player = GWorld.getInstance().getPlayer(playerId);
        if (player == null) {
            return;
        }
        player.onEvent(new TaskEvent(type, param));
    }


    public final void areaBattleServerEvent(JSONObject result) {
        Out.debug(new Object[]{"areaBattleServerEvent:", result});
        String instanceId = result.getString("instanceId");
        Area area = AreaUtil.getArea(instanceId);
        if (area != null) {
            switch (result.getString("eventName")) {
                case "unitDead":
                    AreaEvent.unitDeadEventB2R(area, result);
                    return;

                case "message":
                    AreaEvent.messageEventB2R(area, result);
                    return;

                case "gameOver":
                    AreaEvent.gameOverEventB2R(area, result);
                    return;

                case "pickItem":
                    AreaEvent.pickItemEventB2R(area, result);
                    return;

                case "BattleReportEventB2R":
                    AreaEvent.battleReportEventB2R(area, result);
                    return;

                case "KillBossEventB2R":
                    AreaEvent.killBossEventB2R(area, result);
                    return;
            }

            Out.error(new Object[]{"area event: ", result});
        }
    }


    public final void playerBattleServerEvent(JSONObject json) {
        int qty;
        boolean isUp;
        WNPlayer player, saverPlayer;
        Out.debug(new Object[]{"playerBattleServerEvent msg:", json});
        String eventName = json.getString("eventName");
        switch (eventName) {
            case "ConsumeItemEventB2R":
                qty = json.getIntValue("Qty");
                if (qty > 0) {
                    onPlayerEvent(json.getString("playerId"), Const.EventType.consumeItem, new Object[]{json.getString("Type"), Integer.valueOf(qty)});
                }
                return;

            case "interActiveItem":
                if (json.containsKey("type")) {
                    int type = json.getIntValue("type");
                    if (type == 3) {
                        WNPlayer wNPlayer = PlayerUtil.getOnlinePlayer(json.getString("playerId"));
                        if (wNPlayer != null && wNPlayer.getArea() != null) {
                            int objId = json.getIntValue("objId");
                            int itemId = json.getIntValue("itemId");
                            wNPlayer.getArea().onInterActiveItem(wNPlayer, objId, itemId);
                        }
                        return;
                    }
                }
                onPlayerEvent(json.getString("playerId"), Const.EventType.interActiveItem, new Object[]{Integer.valueOf(json.getIntValue("itemId")), Integer.valueOf(1)});
                return;

            case "changeSceneProgress":
                onPlayerEvent(json.getString("playerId"), Const.EventType.changeSceneProgress, new Object[]{json.getString("key"), json.get("value")});
                return;

            case "TransUnitEventB2R":
                JobFactory.addDelayJob(() -> onPlayerEvent(json.getString("playerId"), Const.EventType.changeArea, new Object[]{Integer.valueOf(json.getIntValue("SceneID")), Integer.valueOf(json.getIntValue("targetX")), Integer.valueOf(json.getIntValue("targetY"))}), 0L);
                return;


            case "SummonMountEventB2R":
                isUp = json.getBooleanValue("IsSummonMount");
                onPlayerEvent(json.getString("playerId"), Const.EventType.summonMount, new Object[]{Boolean.valueOf(isUp), Integer.valueOf(1)});
                return;

            case "ShowRebirthDialogueB2R":
                player = GWorld.getInstance().getPlayer(json.getString("DeadUnitUUID"));
                saverPlayer = GWorld.getInstance().getPlayer(json.getString("SaverUUID"));
                if (player != null && saverPlayer != null) {
                    String saverName = MessageUtil.getPlayerNameColor(saverPlayer.getName(), (saverPlayer.getPlayer()).pro);
                    player.onEvent(new TaskEvent(Const.EventType.rebirth, new Object[]{Integer.valueOf(1), saverName, Integer.valueOf(json.getIntValue("HP")), Integer.valueOf(json.getIntValue("MP"))}));
                }
                return;

            case "TriggerSceneEventB2R":
                Out.debug(new Object[]{"TriggerSceneEventB2R", json.get("playerId")});
                player = PlayerUtil.getOnlinePlayer(json.getString("playerId"));
                if (player != null) {
                    player.onBatterServerSceneEvent(json.getString("EventID"));
                }
                return;

            case "PlayerExceptionEventB2R":
                player = GWorld.getInstance().getPlayer(json.getString("playerId"));
                if (player != null) {
                    Out.warn(new Object[]{player.getName(), "使用外挂 :", json.getString("reason")});
                    PlayerUtil.sendSysMessageToPlayer("你竟然使用外挂了！！！", json.getString("playerId"), null);
                }
                return;
        }
    }


    public final void taskBattleServerEvent(JSONObject msg) {
        Out.debug(new Object[]{"taskBattleServerEvent:", msg});
        String playerId = msg.getString("playerId");
        WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
        if (player != null) {
            String eventName = msg.getString("eventName");
            int templateId = Integer.parseInt(msg.getString("id"));
            String key = msg.getString("key");
            int value = msg.getIntValue("value");
            player.taskManager.onTaskRequestEvent(eventName, templateId, key, value);
        }
    }
}


