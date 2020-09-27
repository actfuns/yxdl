package com.wanniu.game.area;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.GConfig;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.proxy.ProxyClient;
import com.wanniu.core.proxy.ProxyType;
import com.wanniu.core.util.DateUtil;
import com.wanniu.csharp.CSharpClient;
import com.wanniu.csharp.CSharpNode;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.cross.CrossServerArea;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.fightLevel.FightLevelManager;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.team.TeamData;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import pomelo.area.PlayerHandler;


public class AreaUtil {
    public static final long MIN_CHANGE_AREA_INTERVAL_MILL = 1000L;
    private static AreaUtil instance;

    public static AreaUtil getInstance() {
        if (instance == null) {
            instance = new AreaUtil();
        }
        return instance;
    }


    public static final String canTransArea(MapBase sceneProp, WNPlayer player) {
        if (sceneProp == null) {
            return LangService.getValue("AREA_ID_NULL");
        }
        if (sceneProp.allowedTransfer == 0) {
            return LangService.getValue("AREA_NOT_TRANSFER");
        }

        return canEnterArea(sceneProp, player);
    }


    public static final boolean disCardItemByTransArea(MapBase sceneProp, WNPlayer player) {
        String transItemCode = sceneProp.costItem;
        int needTransItemNum = sceneProp.costItemNum;
        if (transItemCode.length() > 0) {
            int itemNum = player.getWnBag().findItemNumByCode(transItemCode);
            if (itemNum < needTransItemNum) {
                player.onFunctionGoTo(Const.FUNCTION_GOTO_TYPE.DIAMONDSHOP, transItemCode, null, null);
                return false;
            }
            player.getWnBag().discardItem(transItemCode, needTransItemNum, Const.GOODS_CHANGE_TYPE.transport, null, false, false);
        }
        return true;
    }


    public static final String canEnterArea(MapBase sceneProp, WNPlayer player) {
        if (sceneProp == null) {
            return LangService.getValue("AREA_ID_NULL");
        }

        if (GWorld.APP_TIME - player.getLastChangeAreaTime() < 1000L) {
            Out.error(new Object[]{player.getName(), " changeArea too rapid error : ", player.area.getSceneName(), "-", player.area.instanceId, " to ", sceneProp.name, " use ", Long.valueOf(GWorld.APP_TIME - player.getLastChangeAreaTime()), "ms use ", JSON.toJSONString(player.playerTempData)});
            return LangService.getValue("DUNGEON_ALREAD_IN_DUNGEON");
        }

        if (!player.getArea().isNormal()) {
            return LangService.getValue("DUNGEON_ALREAD_IN_DUNGEON");
        }

        if (sceneProp.openRule == Const.OpenRuleType.EVERY_DAY.getValue()) {
            long currTime = System.currentTimeMillis();
            Date beginTime = DateUtil.format(sceneProp.beginTime);
            Date endTime = DateUtil.format(sceneProp.endTime);
            if ((sceneProp.beginTime != null && currTime < beginTime.getTime()) || (sceneProp.endTime != null && currTime > endTime.getTime())) {
                return LangService.getValue("DUNGEON_TEAM_NOT_OPEN");
            }
        } else if (sceneProp.openRule == Const.OpenRuleType.EVERY_WEEK.getValue()) {
            int pos = sceneProp.OpenDate.indexOf(Integer.valueOf(Calendar.getInstance().get(7)));
            if (-1 == pos) {
                return LangService.getValue("DUNGEON_TEAM_NOT_OPEN");
            }
            long currTime = System.currentTimeMillis();
            Date beginTime = DateUtil.format(sceneProp.beginTime);
            Date endTime = DateUtil.format(sceneProp.endTime);
            if ((sceneProp.beginTime != null && currTime < beginTime.getTime()) || (sceneProp.endTime != null && currTime > endTime.getTime())) {
                return LangService.getValue("DUNGEON_TEAM_NOT_OPEN");
            }
        }
        if (player.getLevel() < sceneProp.reqLevel) {
            return LangService.getValue("AREA_PLAYER_LEVEL_LIMIT").replace("{playerLevel}", LangService.getValue("RED").replace("{a}", "" + sceneProp.reqLevel));
        }


        Map<String, TeamData.TeamMemberData> members = player.getTeamManager().getTeamMembers();
        if (members != null && player.getTeamManager().isTeamLeader() && sceneProp.mapID != 70002) {
            for (TeamData.TeamMemberData member : members.values()) {
                WNPlayer mp = member.getPlayer();
                if (member.isFollow() && member.isOnline() && mp != null &&
                        mp.getLevel() < sceneProp.reqLevel) {
                    return LangService.getValue("AREA_TEAM_LEVEL_NOT_ENOUGH").replace("{playername}", mp.getName());
                }
            }
        }


        if (sceneProp.mapID != GlobalConfig.World_Boss_NewScene || player.getPlayerTasks().isCompleteTaskByID(GlobalConfig.World_Boss_NweScene_Quest)) {
            if (sceneProp.upLevellimit > 0) {
                if ((player.getPlayer()).upLevel > sceneProp.upLevellimit) {
                    return LangService.getValue("MAP_OVER_UPLEVEL").replace("{uplevel}", "" + sceneProp.upLevellimit);
                }
            } else if (sceneProp.levellimit > 0 &&
                    player.getLevel() > sceneProp.levellimit) {
                return LangService.getValue("MAP_OVER_LEVEL").replace("{level}", "" + sceneProp.levellimit);
            }
        }


        if (sceneProp.reqQuestId != 0 &&
                !player.getPlayerTasks().isTaskDoingOrFinish(sceneProp.reqQuestId)) {
            return LangService.getValue("PLAYER_NOT_FINISH_OR_NOT_HAVE_TASK");
        }

        String reqItemCode = sceneProp.reqItemCode;
        int reqItemCount = sceneProp.reqItemCount;
        if (reqItemCode.length() > 0) {
            if (reqItemCode.equals("gold")) {
                if (player.moneyManager.getGold() < reqItemCount) {
                    return LangService.getValue("MAP_ITEM_NOT_ENOUGH").replace("{itemName}", (ItemUtil.getUnEquipPropByCode(reqItemCode)).name);
                }
            } else {
                int itemNum = player.getWnBag().findItemNumByCode(reqItemCode);
                if (itemNum < reqItemCount) {
                    return LangService.getValue("MAP_ITEM_NOT_ENOUGH").replace("{itemName}", (ItemUtil.getUnEquipPropByCode(reqItemCode)).name);
                }
            }
        }
        return null;
    }


    public static final boolean disCardItemByEnterArea(MapBase sceneProp, WNPlayer player) {
        String reqItemCode = sceneProp.reqItemCode;
        if (reqItemCode.length() > 0) {
            int itemNum = player.getWnBag().findItemNumByCode(reqItemCode);
            if (itemNum < sceneProp.reqItemCount) {
                return false;
            }
            player.getWnBag().discardItem(reqItemCode, sceneProp.reduceItemCount, Const.GOODS_CHANGE_TYPE.transport, null, false, false);
        }
        return true;
    }


    public static final Area enterArea(WNPlayer player, int areaId) {
        return enterArea(player, areaId, 0.0F, 0.0F);
    }


    public static final Area enterArea(WNPlayer player, int areaId, float targetX, float targetY) {
        MapBase sceneProp = null;
        if (areaId == -999) {
            areaId = GlobalConfig.CROSS_SERVER_ENTER_SCENE;
        }
        sceneProp = AreaDataConfig.getInstance().get(areaId);
        if (sceneProp == null) {
            Out.error(new Object[]{"no sceneProp areaId:", Integer.valueOf(areaId)});
            return null;
        }

        Out.debug(new Object[]{"areaUtil enterArea areaId:", Integer.valueOf(areaId)});

        if (player.getAreaId() == areaId) {
            PlayerUtil.sendSysMessageToPlayer(LangService.getValue("MAP_IN"), player.getId(), Const.TipsType.BLACK);
            return null;
        }

        String result = canEnterArea(sceneProp, player);
        if (result != null) {
            PlayerUtil.sendSysMessageToPlayer(result, player.getId(), Const.TipsType.BLACK);
            return null;
        }

        disCardItemByEnterArea(sceneProp, player);

        if (sceneProp.type == Const.SCENE_TYPE.NORMAL.getValue() || sceneProp.type == Const.SCENE_TYPE.ILLUSION.getValue())
            return dispatchByAreaId(player, new AreaData(areaId, targetX, targetY), (Map<String, Object>) null);
        if (sceneProp.type == Const.SCENE_TYPE.FIGHT_LEVEL.getValue() || sceneProp.type == Const.SCENE_TYPE.LOOP.getValue() || sceneProp.type == Const.SCENE_TYPE.DEMON_TOWER.getValue() || sceneProp.type == Const.SCENE_TYPE.RESOURCE_DUNGEON.getValue() || sceneProp.type == Const.SCENE_TYPE.ILLUSION_2.getValue()) {

            FightLevelManager fightLevelManager = player.fightLevelManager;
            String data = fightLevelManager.enterDungeonReq(player, areaId);
            if (data != null) {
                PlayerUtil.sendSysMessageToPlayer(data, player.getId(), Const.TipsType.BLACK);
            }
            return null;
        }
        if (sceneProp.type == Const.SCENE_TYPE.CROSS_SERVER.getValue()) {
            if (player.getSceneType() == Const.SCENE_TYPE.FIGHT_LEVEL.getValue() || player.getSceneType() == Const.SCENE_TYPE.LOOP.getValue()) {
                PlayerUtil.sendSysMessageToPlayer(LangService.getValue("CROSS_SERVER_AUTH_LIMIT_FIGHTLEVEL"), player.getId(), null);
                return null;
            }
            return dispatchByCrossServerId(player, new AreaData(areaId, targetX, targetY));
        }
        if (sceneProp.type == Const.SCENE_TYPE.WORLD_BOSS.getValue()) {
            String instanceId = null;
            if (player.getTeamManager().isInTeam()) {
                Map<String, TeamData.TeamMemberData> teamMembers = player.getTeamManager().getTeamMembers();
                for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
                    WNPlayer member = teamMember.getPlayer();
                    if (member != null && !teamMember.id.equals(player.getId()) && member.getAreaId() == areaId) {
                        instanceId = member.getInstanceId();
                        break;
                    }
                }
            }
            if (instanceId != null) {
                return dispatchByInstanceId(player, new AreaData(areaId, instanceId));
            }
            return dispatchByAreaId(player, new AreaData(areaId, 0.0F, 0.0F), (Map<String, Object>) null);
        }


        return null;
    }


    public static final boolean canRideMount(int areaId) {
        MapBase prop = getAreaProp(areaId);
        return (prop.rideMount == 1);
    }

    public static final MapBase getAreaProp(int areaId) {
        return AreaDataConfig.getInstance().get(areaId);
    }

    public static final int getAreaType(int areaId) {
        return (getAreaProp(areaId)).type;
    }


    public static Date formatToday(String stringTime) {
        String[] begins = stringTime.split("-");
        Calendar date = Calendar.getInstance();
        if (begins.length == 3) {
            date.set(11, Integer.parseInt(begins[0]));
            date.set(12, Integer.parseInt(begins[1]));
            date.set(13, Integer.parseInt(begins[2]));
            date.set(14, 0);
        }
        return date.getTime();
    }


    public static final boolean needCreateArea(int areaId) {
        MapBase prop = getAreaProp(areaId);
        return (prop == null || (prop.type != Const.SCENE_TYPE.NORMAL.getValue() && prop.type != Const.SCENE_TYPE.ILLUSION.getValue() && prop.type != Const.SCENE_TYPE.CROSS_SERVER.getValue()));
    }


    public static final Area getArea(String instanceId) {
        return AreaManager.getInstance().getArea(instanceId);
    }


    public static final void closeArea(String instanceId) {
        AreaManager.getInstance().closeArea(instanceId);
        Out.debug(new Object[]{"closeArea:::", instanceId});
    }


    public static final void closeAreaNoPlayer(String instanceId) {
        AreaManager.getInstance().closeAreaNoPlayer(instanceId);
        Out.debug(new Object[]{"closeAreaNoPlayer:::", instanceId});
    }


    public static final void changeAreaPush(WNPlayer player, int areaId, String instanceId) {
        player.receive("area.playerPush.changeAreaPush", (GeneratedMessage) changeAreaPush(areaId, instanceId));
    }


    public static final PlayerHandler.ChangeAreaPush changeAreaPush(int areaId, String instanceId) {
        MapBase prop = AreaDataConfig.getInstance().get(areaId);
        PlayerHandler.ChangeAreaPush.Builder data = PlayerHandler.ChangeAreaPush.newBuilder();
        data.setS2CMapId(areaId);
        data.setS2CInstanceId(instanceId);
        data.setS2CSceneId(prop.templateID);
        data.setS2CSceneType(prop.type);
        data.setS2CSceneUseAgent(prop.useAgent);
        data.setS2CRideMount(prop.rideMount);
        data.setS2CChangePkType(prop.changePKtype);
        return data.build();
    }


    public static final Area changeArea(WNPlayer player, AreaData areaData) {
        Area area = player.getArea();
        if (area != null) {
            if (area.instanceId.equals(areaData.instanceId)) {
                Out.debug(new Object[]{player.getName(), "已在场景，无需切换：", area.prop.name});
                return area;
            }

            String matchScene = GlobalConfig.MATCH_SCENE;
            MapBase destMap = AreaDataConfig.getInstance().get(areaData.areaId);
            if (destMap != null && matchScene.indexOf(String.valueOf(destMap.type)) == -1) {
                player.soloManager.quitMatching(false);
                player.five2FiveManager.cancelFive2FiveMatch(false);
            }
            area.syncPlayerHistoryData(player);
        }

        int areaId = areaData.areaId;
        float targetX = areaData.targetX;
        float targetY = areaData.targetY;

        player.syncBornData(targetX, targetY, areaId);
        player.setBornType(Const.BORN_TYPE.BORN);
        player.setEnterState(Const.ENTER_STATE.changeArea.value);

        PlayerRemote.playerEnterAreaServer(player, areaData.instanceId);
        Out.info(new Object[]{"enter scene:playerId=", player.getId(), "araid=", Integer.valueOf((area == null) ? areaId : area.areaId), ",instanceId=", (area == null) ? areaData.instanceId : area.instanceId});
        return area;
    }


    public static final Area dispatchByInstanceId(WNPlayer player, AreaData areaData) {
        if (player.getInstanceId().equals(areaData.instanceId)) {
            return null;
        }

        changeTeamArea(player, areaData);
        return getArea(areaData.instanceId);
    }

    public static final Area dispatchByAreaId(WNPlayer player, int areaId, Map<String, Object> userData) {
        return dispatchByAreaId(player, new AreaData(areaId), userData);
    }


    public static final Area dispatchByAreaId(WNPlayer player, int areaId, float targetX, float targetY) {
        return dispatchByAreaId(player, new AreaData(areaId, targetX, targetY), (Map<String, Object>) null);
    }


    public static final Area dispatchByAreaId(WNPlayer player, AreaData areaData, Map<String, Object> userData) {
        Out.debug(new Object[]{"dispatchByAreaId areaData:", Integer.valueOf(areaData.areaId), ",", areaData.instanceId});
        JSONObject json = Utils.toJSON(new Object[]{"id", player.getId(), "logicServerId", Integer.valueOf(player.getLogicServerId()), "areaId", Integer.valueOf(areaData.areaId)});
        if (userData != null) {
            json.putAll(userData);
        }
        Area area = AreaManager.getInstance().dispatchByAreaId(player, json);
        areaData.instanceId = area.instanceId;

        changeTeamArea(player, areaData);
        return area;
    }


    public static final Area dispatchByCrossServerId(WNPlayer player, AreaData areaData) {
        Out.debug(new Object[]{"dispatchByCrossServerId areaData:", areaData});
        areaData.logicServerId = player.getAcrossServerId();
        JSONObject json = Utils.toJSON(new Object[]{"id", player.getId(), "logicServerId", Integer.valueOf(areaData.logicServerId), "areaId", Integer.valueOf(areaData.areaId)});
        Area area = null;
        if (GConfig.getInstance().isEnableProxy()) {
            json = ProxyClient.getInstance().request(ProxyType.ProxyMethod.M_DISPATCHER, json);
            if (json.containsKey("exists")) {
                area = getArea(json.getString("instanceId"));
                if (area == null) {
                    return bindCrossServerArea(player, json, crossArea -> {
                        areaData.instanceId = crossArea.instanceId;

                        changeTeamArea(player, areaData);
                    });
                }
            } else {
                area = AreaManager.getInstance().createArea(player, json);
                json.put("csNode", GWorld.__CS_NODE);
                json.put("fullCount", Integer.valueOf(area.fullCount));
                json.put("maxCount", Integer.valueOf(area.maxCount));
                json.put("lifeTime", Integer.valueOf(area.lifeTime));
                json.put("sid", Integer.valueOf(GWorld.__SERVER_ID));
                json = ProxyClient.getInstance().request(ProxyType.ProxyMethod.M_CREATE, json);
                area.lineIndex = json.getIntValue("lineIndex");
            }
            areaData.instanceId = area.instanceId;

            changeTeamArea(player, areaData);
        } else {
            area = dispatchByAreaId(player, areaData, (Map<String, Object>) null);
        }

        return area;
    }


    public static Area bindCrossServerArea(WNPlayer player, JSONObject json, AreaCB cb) {
        CSharpNode node = (CSharpNode) json.getObject("csNode", CSharpNode.class);
        CrossServerArea crossServerArea1 = new CrossServerArea(json);
        AreaManager.CrossServerAreas.put(((Area) crossServerArea1).instanceId, crossServerArea1);
        String nodeId = node.getNodeId();
        CrossServerArea crossArea = crossServerArea1;
        if (CSharpClient.getXmdsManager(nodeId) == null) {
            CSharpClient.getInstance().connectAsync(node, () -> {
                Out.debug(new Object[]{" bindCrossServerArea ", nodeId});
                player.setBattleServerId(nodeId);
                crossArea.bindBattleServer(player);
                cb.call(crossArea);
            });
            return (Area) crossServerArea1;
        }
        crossArea.bindBattleServer(player);

        cb.call(crossArea);
        return (Area) crossServerArea1;
    }

    public static final void changeTeamArea(WNPlayer player, AreaData areaData) {
        Map<String, TeamData.TeamMemberData> members = player.getTeamManager().getTeamMembers();
        if (members != null && player.getTeamManager().isTeamLeader() && areaData.areaId != 70002) {

            for (TeamData.TeamMemberData member : members.values()) {
                if (member.isFollow() && member.isOnline()) {
                    changeArea(member.getPlayer(), areaData);
                }
            }
        } else {
            changeArea(player, areaData);
        }
    }


    public static Area createAreaAndDispatch(WNPlayer player, Collection<String> playerIds, int logicServerId, int areaId, Map<String, Object> userData) {
        JSONObject areaData = Utils.toJSON(new Object[]{"logicServerId", Integer.valueOf(logicServerId), "areaId", Integer.valueOf(areaId)});
        if (userData != null) {
            areaData.putAll(userData);
        }
        Area area = AreaManager.getInstance().createArea(player, areaData);
        AreaData data = new AreaData(areaId, area.instanceId);

        for (String rid : playerIds) {
            WNPlayer member = PlayerUtil.getOnlinePlayer(rid);
            if (member != null) {
                changeArea(member, data);
            }
        }

        return area;
    }

    public static Area dispatch(WNPlayer player, Collection<String> playerIds, int logicServerId, int areaId, Map<String, Object> userData) {
        JSONObject areaData = Utils.toJSON(new Object[]{"logicServerId", Integer.valueOf(logicServerId), "areaId", Integer.valueOf(areaId)});
        if (userData != null) {
            areaData.putAll(userData);
        }
        Area area = AreaManager.getInstance().dispatchByAreaId(player, areaData);
        AreaData data = new AreaData(areaId, area.instanceId);

        for (String rid : playerIds) {
            WNPlayer member = PlayerUtil.getOnlinePlayer(rid);
            if (member != null) {
                changeArea(member, data);
            }
        }

        return area;
    }


    private static boolean isNormalArea(int sceneType) {
        return (sceneType == Const.SCENE_TYPE.NORMAL.getValue() || sceneType == Const.SCENE_TYPE.ILLUSION.getValue() || sceneType == Const.SCENE_TYPE.CROSS_SERVER.getValue());
    }


    public static Area dispatch(WNPlayer player) {
        Const.BORN_TYPE bornType = Const.BORN_TYPE.NORMAL;
        Out.debug(new Object[]{"dispatch try createAreaAndDispatch begin"});
        Area area = player.getArea();
        if (area == null || area.isPlayerClose(player)) {
            int areaId = player.playerTempData.areaId;
            MapBase prop = getAreaProp(areaId);
            if (prop.disConnToMapID != 0) {
                areaId = (player.getPlayerTempData()).bornAreaId;
                bornType = Const.BORN_TYPE.BORN;
                Out.debug(new Object[]{"create area 2222: areaId:", Integer.valueOf(areaId), "  bornType:", bornType});
            } else if (!isNormalArea(prop.type)) {
                areaId = (player.getPlayerTempData()).historyAreaId;
                bornType = Const.BORN_TYPE.HISTORY;
                Out.debug(new Object[]{"create area 1111: areaId:", Integer.valueOf(areaId), "  bornType:", bornType});
            }
            if (Const.SCENE_TYPE.CROSS_SERVER.getValue() == getAreaType(areaId)) {
                area = dispatchByCrossServerId(player, new AreaData(areaId));
            } else {
                player.setBornType(bornType, areaId);
                float x = player.playerTempData.x;
                float y = player.playerTempData.y;
                area = dispatchByAreaId(player, new AreaData(areaId, x, y), (Map<String, Object>) null);
            }
        } else {
            if (!area.isNormal()) {
                bornType = Const.BORN_TYPE.BORN;
            }
            player.setBornType(bornType, area.areaId);

            PlayerRemote.playerEnterAreaServerInner(player, area);
        }

        return area;
    }

    public static Area createArea(WNPlayer player, JSONObject json) {
        return AreaManager.getInstance().createArea(player, json);
    }

    public static boolean isCrossArea(int sceneType) {
        return (sceneType == Const.SCENE_TYPE.CROSS_SERVER.getValue());
    }

    @FunctionalInterface
    public static interface AreaCB {
        void call(CrossServerArea param1CrossServerArea);
    }
}


