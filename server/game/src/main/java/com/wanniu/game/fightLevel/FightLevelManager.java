package com.wanniu.game.fightLevel;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.proxy.ProxyClient;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaData;
import com.wanniu.game.area.AreaDataConfig;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.CircleSceneCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.MonsterRefreshCO;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.data.base.MonsterBase;
import com.wanniu.game.data.base.TaskBase;
import com.wanniu.game.data.ext.MonsterRefreshExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.VirtualItem;
import com.wanniu.game.monster.MonsterConfig;
import com.wanniu.game.player.PathService;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.FightLevelsPO;
import com.wanniu.game.request.fightLevel.GetBossDamageRankHandler;
import com.wanniu.game.request.fightLevel.GetMonsterLeaderHandler;
import com.wanniu.game.task.po.TaskPO;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamUtil;
import com.wanniu.redis.PlayerPOManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import pomelo.area.FightLevelHandler;
import pomelo.item.ItemOuterClass;


public class FightLevelManager {
    public WNPlayer player;
    private FightLevelsPO po;

    public FightLevelsPO getFightLevelsPo() {
        return this.po;
    }

    public FightLevelManager(WNPlayer player, FightLevelsPO po) {
        this.player = player;
        if (po == null) {
            po = new FightLevelsPO();
        }
        if (po.todays == null) {
            po.todays = new HashMap<>();
        }
        if (po.finishes == null) {
            po.finishes = new HashMap<>();
        }
        if (po.resourceDungeon == null) {
            po.resourceDungeon = new HashMap<>();
        }
        this.po = po;

        PlayerPOManager.put(ConstsTR.player_fightlevelTR, player.getId(), (GEntity) po);
    }

    public int getTodayFinish(int templateID) {
        return this.po.todays.containsKey(Integer.valueOf(templateID)) ? ((Integer) this.po.todays.get(Integer.valueOf(templateID))).intValue() : 0;
    }

    public int getTodayBuy(int templateID) {
        return ((Integer) this.po.buys.getOrDefault(Integer.valueOf(templateID), Integer.valueOf(0))).intValue();
    }

    public int getCurrHard(int templateID) {
        return this.po.finishes.containsKey(Integer.valueOf(templateID)) ? ((Integer) this.po.finishes.get(Integer.valueOf(templateID))).intValue() : 1;
    }

    public void useProduce(int templateID) {
        if (!needProduce(templateID)) {
            Out.info(new Object[]{"needProduce false,player id:" + this.player.getId() + " mapId:" + templateID});
            return;
        }
        Map<Integer, Integer> todays = this.po.todays;
        int count = getTodayFinish(templateID);
        synchronized (this.po.todays) {
            todays.put(Integer.valueOf(templateID), Integer.valueOf(count + 1));
        }
    }

    public boolean needProduce(int templateID) {
        return (getTodayFinish(templateID) < 3 + getTodayBuy(templateID));
    }

    public void refreshNewDay() {
        synchronized (this.po.todays) {
            this.po.todays.clear();
            this.po.buys.clear();


            this.po.resourceDungeon.clear();
            for (Map<Integer, Integer> val : (Iterable<Map<Integer, Integer>>) this.po.dropedBossMap.values()) {
                val.clear();
            }
        }
    }


    private boolean isDropedControledArea(Area area) {
        if (area.sceneType == Const.SCENE_TYPE.FIGHT_LEVEL.getValue() || area.sceneType == Const.SCENE_TYPE.LOOP
                .getValue()) {
            return true;
        }

        return false;
    }


    public void onDungeonReset(int areaId) {
        Map<Integer, Integer> val = (Map<Integer, Integer>) this.po.dropedBossMap.get(Integer.valueOf(areaId));
        if (val != null) {
            val.clear();
        }
    }


    public boolean canDrop(int bossId, Area area) {
        if (bossId == 0 || !isDropedControledArea(area)) {
            return true;
        }

        Map<Integer, Integer> val = (Map<Integer, Integer>) this.po.dropedBossMap.get(Integer.valueOf(area.areaId));
        if (val != null &&
                val.containsKey(Integer.valueOf(bossId))) {
            int times = ((Integer) val.get(Integer.valueOf(bossId))).intValue();
            if (times > 0) {
                return false;
            }
        }


        return true;
    }


    public void onBossDead(int bossId, Area area) {
        if (!isDropedControledArea(area)) {
            return;
        }
        MonsterBase prop = MonsterConfig.getInstance().get(bossId);
        if (prop == null || prop.type < 3) {
            return;
        }

        Map<Integer, Integer> val = (Map<Integer, Integer>) this.po.dropedBossMap.get(Integer.valueOf(area.areaId));
        if (val != null) {
            if (val.containsKey(Integer.valueOf(bossId))) {
                val.put(Integer.valueOf(bossId), Integer.valueOf(((Integer) val.get(Integer.valueOf(bossId))).intValue() + 1));
            } else {
                val.put(Integer.valueOf(bossId), Integer.valueOf(1));
            }
        } else {
            Map<Integer, Integer> newVal = new ConcurrentHashMap<>();
            newVal.put(Integer.valueOf(bossId), Integer.valueOf(1));
            this.po.dropedBossMap.put(Integer.valueOf(area.areaId), newVal);
        }
    }


    public List<FightLevelHandler.MonsterInfo> getMonsterInfo(Map<Integer, Map<Integer, Integer>> datas, int areaId) {
        List<FightLevelHandler.MonsterInfo> result = new ArrayList<>();

        Map<Integer, Integer> data = datas.get(Integer.valueOf(areaId));

        List<MonsterRefreshExt> props = GameData.findMonsterRefreshs(t -> (t.mapID == areaId));


        for (MonsterRefreshCO prop : props) {
            FightLevelHandler.MonsterInfo.Builder m = FightLevelHandler.MonsterInfo.newBuilder();
            m.setMonsterId(prop.monsterID);
            if (data != null && data.get(Integer.valueOf(prop.iD)) != null && ((Integer) data.get(Integer.valueOf(prop.iD))).intValue() != 0) {
                m.setTime(((Integer) data.get(Integer.valueOf(prop.iD))).intValue());
            } else {
                m.setTime(((Integer) data.get(Integer.valueOf(0))).intValue());
            }
            result.add(m.build());
        }

        return result;
    }

    public int vipAddTimes(WNPlayer player, int type) {
        switch (type) {

        }


        return 0;
    }


    public List<ItemOuterClass.MiniItem> getDropItems(String itemTC) {
        List<ItemOuterClass.MiniItem> dropItems = new ArrayList<>();

        List<NormalItem> items = ItemUtil.createItemsByTcCode(itemTC);
        for (NormalItem item : items) {

            ItemOuterClass.MiniItem.Builder dropItem = ItemUtil.getMiniItemData(item.prop.code, 1);

            if (dropItem != null) {
                dropItems.add(dropItem.build());
            }
        }

        return dropItems;
    }

    public String enterDungeonReq(WNPlayer player, int dungeonId) {
        MapBase prop = AreaDataConfig.getInstance().get(dungeonId);
        String data = isDungeonOpen(prop);
        if (data != null) {
            return data;
        }
        data = canEnterDungeon(player, prop, true);
        if (data != null) {
            return data;
        }


        if ((prop.allowedPlayersMix > 1 || player.getTeamManager().isInTeam()) && !PlayerUtil.isRobot(player.player)) {
            int teamCount = 0;
            TeamData.TeamMemberData teamMember = player.getTeamManager().getTeamMember();
            TeamData team = player.getTeamManager().getTeam();
            if (teamMember != null && team != null) {
                teamCount = team.memberCount();
                if (!teamMember.isLeader) {
                    return LangService.getValue((prop.allowedPlayersMax == 1) ? "DUNGEON_SINGLE_MORE" : "TEAM_NO_AUTHORITY");
                }
            }
            if (teamCount < prop.allowedPlayersMix || teamCount > prop.allowedPlayersMax) {
                return LangService.getValue((teamCount < prop.allowedPlayersMix) ? "TEAM_MEMBER_COUNT" : ((prop.allowedPlayersMax == 1) ? "DUNGEON_SINGLE_MORE" : "DUNGEON_TEAM_PLAYER_MORE"));
            }
            if (teamCount > 1) {
                if (team.confirm) {
                    return DungeonService.getInstance().enterDungeonInTeam(team, prop, dungeonId);
                }
                if (dungeonId == 53001) {
                    AreaUtil.dispatchByAreaId(player, dungeonId, null);
                } else {
                    enterDungeonMutiPlayers(team, dungeonId);
                }

                return null;
            }
        }
        if (dungeonId == 53001) {
            AreaUtil.dispatchByAreaId(player, dungeonId, null);
        } else {
            enterDungeon(player, dungeonId);
        }
        return null;
    }

    public String canEnterDungeon(WNPlayer player, MapBase prop, boolean bAlone) {
        Area area = player.getArea();

        if (area != null && !area.isNormal()) {
            return bAlone ? LangService.getValue("DUNGEON_ALREAD_IN_DUNGEON") : LangService.format("TEAM_MEMBER_BATTLE", new Object[]{player.getName()});
        }

        return AreaUtil.canEnterArea(prop, player);
    }

    public String replyEnterDungeon(final WNPlayer player, final int type, int dungeonId) {
        if (player.isRomote()) {
            ProxyClient.getInstance().add(new Message() {
                protected void write() throws IOException {
                    this.body.writeByte(3);
                    this.body.writeString(player.getId());
                    this.body.writeByte(type);
                }


                public short getType() {
                    return 1265;
                }
            });
            return null;
        }
        if (type != Const.HandsUpState.ACCEPT.value && type != Const.HandsUpState.REFUSE.value) {
            return LangService.getValue("DATA_ERR");
        }

        TeamData.TeamMemberData teamMember = player.getTeamManager().getTeamMember();
        if (teamMember == null) {
            return LangService.getValue("EXPIRED_MSG");
        }

        TeamData team = player.getTeamManager().getTeam();
        if (team == null || !team.teamMembers.containsKey(player.getId()) || !team.islock()) {
            return LangService.getValue("EXPIRED_MSG");
        }
        if (type == Const.HandsUpState.REFUSE.value && teamMember.isLeader) {
            FightLevelHandler.CloseHandUpPush push = FightLevelHandler.CloseHandUpPush.newBuilder().setMsg(LangService.getValue("TEAM_GOTO_CANCEL")).build();
            for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                member.handup = Const.HandsUpState.WAITING.value;
                if (!member.id.equals(player.getId())) {
                    MessageUtil.sendMessage(member.id, "area.fightLevelPush.closeHandUpPush", (GeneratedMessage) push);
                }
            }
            team.unlock();
            return null;
        }

        String data = isDungeonOpen(dungeonId);
        if (data != null) {
            return data;
        }
        Area area = player.getArea();
        if (area != null && AreaUtil.needCreateArea(area.areaId)) {
            return LangService.getValue("PLAYER_CANT_DO");
        }

        teamMember.handup = type;

        boolean allAccept = true, allReply = true;
        FightLevelHandler.OnMemberEnterFubenStateChangePush msgData = FightLevelHandler.OnMemberEnterFubenStateChangePush.newBuilder().setS2CPlayerId(player.getId()).setS2CIsReady((type == Const.HandsUpState.ACCEPT.value) ? 1 : 0).build();
        for (TeamData.TeamMemberData member : team.teamMembers.values()) {
            allAccept = (allAccept && member.handup == Const.HandsUpState.ACCEPT.value);
            allReply = (allReply && member.handup != Const.HandsUpState.WAITING.value);
            MessageUtil.sendMessage(member.id, "area.fightLevelPush.onMemberEnterFubenStateChangePush", (GeneratedMessage) msgData);
        }

        if (allReply) {
            team.unlock();
        }

        if (allAccept) {
            if (dungeonId == 53001) {
                AreaUtil.dispatch(player, team.teamMembers.keySet(), team.logicServerId, dungeonId, null);
            } else {
                enterDungeonMutiPlayers(team, dungeonId);
            }
        }
        return null;
    }

    public void enterDungeon(WNPlayer player, int mapId) {
        AreaUtil.createAreaAndDispatch(player, Arrays.asList(new String[]{player.getId()}, ), player.getLogicServerId(), mapId, null);
    }

    public void enterDungeonMutiPlayers(TeamData team, int mapId) {
        AreaUtil.createAreaAndDispatch(this.player, team.teamMembers.keySet(), team.logicServerId, mapId, null);
    }

    public String isDungeonOpen(int mpaId) {
        return isDungeonOpen(AreaUtil.getAreaProp(mpaId));
    }

    public String isDungeonOpen(MapBase prop) {
        if (prop == null) {
            return LangService.getValue("DUNGEON_NULL");
        }


        long currTime = GWorld.APP_TIME;
        Date beginTime = null;
        if (StringUtil.isNotEmpty(prop.beginTime)) {
            beginTime = AreaUtil.formatToday(prop.beginTime);
        }
        Date endTime = null;
        if (StringUtil.isNotEmpty(prop.endTime)) {
            endTime = AreaUtil.formatToday(prop.endTime);
        }
        if ((beginTime != null && currTime < beginTime.getTime()) || (endTime != null && currTime > endTime.getTime())) {
            return LangService.getValue("DUNGEON_TEAM_NOT_OPEN");
        }

        if (prop.openRule == Const.OpenRuleType.EVERY_WEEK.getValue()) {
            Calendar calendar_curr = Calendar.getInstance();
            int pos = prop.OpenDate.indexOf(Integer.valueOf(calendar_curr.get(7)));
            if (-1 == pos) {
                return LangService.getValue("DUNGEON_TEAM_NOT_OPEN");
            }
        }
        return null;
    }

    public String leaveDungeon(WNPlayer player, Area area) {
        TeamUtil.removeAcrossMatch(player);
        int targetAreaId = player.playerTempData.historyAreaId;
        if (area.prop.leaveToMapID != 0) {
            targetAreaId = area.prop.leaveToMapID;
        }
        AreaData areaData = new AreaData(targetAreaId);
        if (targetAreaId == player.playerTempData.historyAreaId) {
            areaData.targetX = player.playerTempData.historyX;
            areaData.targetY = player.playerTempData.historyY;
        }
        float[] xy = PathService.findToAreaXYByAreaId(area.areaId, targetAreaId);
        if (xy != null) {
            areaData.targetX = xy[0];
            areaData.targetY = xy[1];
        }
        Out.debug(new Object[]{player.getName(), " ==leaveDungeon== ", area.getSceneName(), " to ", areaData});

        TeamData team = player.getTeamManager().getTeam();
        TeamData.TeamMemberData member = player.getTeamManager().getTeamMember();
        if (member != null) {
            member.follow = true;
        }
        if (team != null && team.loopTasks != null) {
            boolean quit = false;
            for (TaskPO taskData : team.loopTasks.values()) {
                if (taskData == null)
                    continue;
                TaskBase taskProp = (TaskBase) GameData.CircleScenes.get(Integer.valueOf(taskData.templateId));
                if (taskProp == null)
                    continue;
                if (taskProp.circleDungeonID == area.areaId) {
                    for (CircleSceneCO posProp : GameData.CircleScenes.values()) {
                        if (posProp.circleDungeonID == area.areaId) {
                            if (player.playerTempData.historyAreaId == posProp.startScene) {
                                areaData.targetX = posProp.loopOutPos[0];
                                areaData.targetY = posProp.loopOutPos[1];
                            }
                            quit = true;
                            break;
                        }
                    }
                    if (quit) {

                        team.confirm = true;
                        break;
                    }
                }
            }
        }
        MapBase prop = AreaDataConfig.getInstance().get(targetAreaId);
        area = (prop.type == Const.SCENE_TYPE.CROSS_SERVER.getValue()) ? AreaUtil.dispatchByCrossServerId(player, areaData) : AreaUtil.dispatchByAreaId(player, areaData, null);

        return (area != null) ? null : LangService.getValue("SOMETHING_ERR");
    }

    public Object enterWaitDungeon(WNPlayer player, int dungeonId) {
        MapBase prop = AreaUtil.getAreaProp(dungeonId);

        String data = isDungeonOpen(prop);
        if (data != null) {
            return data;
        }

        data = canEnterDungeon(player, prop, true);

        if (data != null) {
            return data;
        }

        if (prop == null || prop.dungeonTab != 2) {
            return LangService.getValue("PARAM_ERROR");
        }

        TeamData.TeamMemberData teamMember = player.getTeamManager().getTeamMember();

        if (teamMember != null) {
            return LangService.getValue("MATCH_IN_TEAM");
        }

        return null;
    }


    public boolean addStackItem(String code, int worth, List<NormalItem> awardDropItems) {
        for (NormalItem awardDropItem : awardDropItems) {

            if (awardDropItem.itemDb.code.equals(code)) {

                ((VirtualItem) awardDropItem).addWorth(worth);

                return true;
            }
        }
        return false;
    }


    public int addStackItemByCount(String code, int groupCount, int groupCountMax, List<NormalItem> awardDropItems) {
        for (NormalItem awardDropItem : awardDropItems) {

            if (awardDropItem.itemDb.code.equals(code)) {


                awardDropItem.addGroupNum(groupCount);

                int leftCount = awardDropItem.itemDb.groupCount - groupCountMax;

                if (leftCount > 0) {


                    awardDropItem.setNum(groupCountMax);

                    return leftCount;
                }

                return 0;
            }
        }


        return groupCount;
    }

    public GetMonsterLeaderHandler.GetMonsterLeaderData getMonsterLeader(WNPlayer player, int monsterId, int areaId) {
        List<ItemOuterClass.MiniItem> dropItems = new ArrayList<>();
        GetMonsterLeaderHandler.GetMonsterLeaderData data = new GetMonsterLeaderHandler.GetMonsterLeaderData(dropItems, 0, 0, "");

        MonsterBase monsterProp = MonsterConfig.getInstance().get(monsterId);

        if (monsterProp != null) {
            data.dropItems = getDropItems(monsterProp.showTc);
        }

        MapBase areaProp = AreaDataConfig.getInstance().get(areaId);

        if (areaProp != null) {

            data.reqLevel = areaProp.reqLevel;
            data.reqUpLevel = areaProp.reqUpLevel;
        }
        MonsterRefreshCO refreshProp = null;
        List<MonsterRefreshExt> refreshProps = GameData.findMonsterRefreshs(t ->
                (t.monsterID == monsterId && t.mapID == areaId));

        if (refreshProps.size() > 0) {
            refreshProp = (MonsterRefreshCO) refreshProps.get(0);
            data.refreshPoint = refreshProp.refreshPoint;
        }

        return data;
    }


    public GetBossDamageRankHandler.GetBossDamageRankResult getBossDamageRank(WNPlayer player, Area area) {
        GetBossDamageRankHandler.GetBossDamageRankResult data = new GetBossDamageRankHandler.GetBossDamageRankResult(new ArrayList(), 0, 0);

        return data;
    }

    public void addPrifit(int mapId) {
        Out.info(new Object[]{"增加副本收益次数 mapId=", Integer.valueOf(mapId)});
        this.po.buys.put(Integer.valueOf(mapId), Integer.valueOf(((Integer) this.po.buys.getOrDefault(Integer.valueOf(mapId), Integer.valueOf(0))).intValue() + 1));
    }
}


