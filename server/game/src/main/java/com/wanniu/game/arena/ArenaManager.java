package com.wanniu.game.arena;

import Xmds.GetPlayerData;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaData;
import com.wanniu.game.area.AreaManager;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.data.ext.JJCRewardExt;
import com.wanniu.game.five2Five.Five2FiveService;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.data.ItemToBtlServerData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.ArenaDataPO;
import com.wanniu.game.rank.RankType;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamService;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import pomelo.area.ArenaHandler;
import pomelo.area.PlayerHandler;


public class ArenaManager {
    private WNPlayer player;
    private ArenaDataPO arenaData;
    private MapBase mapProp;

    public ArenaManager(WNPlayer player) {
        this.player = player;
        init(this.player.getId());
    }


    private void init(String playerId) {
        ArenaDataPO arenaDataDb = getFromRedis(playerId);
        if (arenaDataDb == null) {
            arenaDataDb = new ArenaDataPO();
            PlayerPOManager.put(ConstsTR.player_arena_dataTR, playerId, (GEntity) arenaDataDb);
        }
        this.arenaData = arenaDataDb;
        this.mapProp = ArenaService.getInstance().getArenaMap();
    }

    public ArenaHandler.ArenaInfoResponse.Builder getArenaInfo() {
        ArenaHandler.ArenaInfoResponse.Builder res = ArenaHandler.ArenaInfoResponse.newBuilder();
        initSeasonAward();

        res.setS2CSingleRank(getSingleRankIndex());
        res.setS2CSingleReward(getSingleReward());
        res.setS2CTotalReward(this.arenaData.totalReward);
        res.setS2CTotalRank(getLastTotalRank());
        res.setS2CCurrentTotalRank(getCurrentTotalRank());
        res.setS2CCurrentTotalScore(this.arenaData.scoreMonth);
        res.setS2CSeasonEndTime(ArenaService.getInstance().getSeasonEndTime().getTime());

        this.player.updateSuperScriptList(getSuperScript());
        return res;
    }


    private String canEnter() {
        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.JJC.getValue())) {
            return LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN");
        }

        if (Five2FiveService.getInstance().applyMatchTime(this.player.getId()) != null) {
            return LangService.getValue("JJC_IN_PVP_NOT_JOIN");
        }

        if (this.player.soloManager.isBusy() || this.player.soloManager.isInMatching()) {
            return LangService.getValue("JJC_IN_PVP_NOT_JOIN");
        }
        if (this.arenaData.usedDefTimes >= GlobalConfig.JJC_EnterCount) {
            return LangService.getValue("DUNGEON_JJC_NUM_NOT_ENOUGH");
        }
        if (this.mapProp.reqUpLevel > 0 && (this.player.getPlayer()).upLevel < this.mapProp.reqUpLevel)
            return LangService.getValue("PLAER_UPLEVEL_NOT_ENOUGH");
        if (this.mapProp.reqLevel > 0 && this.player.getLevel() < this.mapProp.reqLevel) {
            return LangService.getValue("PLAYER_LEVEL_NOT_ENOUGH") + this.mapProp.reqUpLevel;
        }
        if (ArenaService.getInstance().isInOpenTime()) {
            return null;
        }
        return LangService.getValue("DUNGEON_JJC_NOT_OPEN");
    }


    public void refreshNewDay() {
        if (this.player.functionOpenManager.isOpen(Const.FunctionType.JJC.getValue())) {
            resetDaily();
            this.arenaData.usedDefTimes = 0;
            this.player.updateSuperScriptList(getSuperScript());
            Out.debug(new Object[]{"ArenaManager.refreshNewDay() on ---------------"});
        }
    }


    private void resetDaily() {
        this.arenaData.score = 0;

        this.arenaData.combo = 0;
        this.arenaData.comboDaily = 0;
        this.arenaData.killDaily = 0;
    }


    private void enterArenaArea() {
        if (getActivityTime() != ArenaService.getInstance().getBeginTime()) {
            setActivityTime(ArenaService.getInstance().getBeginTime());
        }
        String instanceId = getArenaInstanceId();
        if (StringUtil.isNotEmpty(instanceId)) {
            Area area = AreaManager.getInstance().getArea(instanceId);
            if (area != null && !area.isClose()) {
                AreaUtil.dispatchByInstanceId(this.player, new AreaData(area.areaId, instanceId));
                return;
            }
        }
        AreaUtil.dispatchByAreaId(this.player, this.mapProp.mapID, null);
    }


    public int getSingleRankIndex() {
        return (int) RankType.ARENA_SCORE.getHandler().getRank(GWorld.__SERVER_ID, this.player.getId());
    }

    public int getScore() {
        return this.arenaData.score;
    }


    public int getKillMonth() {
        return this.arenaData.killMonth;
    }

    public int getCombo() {
        return this.arenaData.combo;
    }


    public int getSingleReward() {
        if (!ArenaService.getInstance().canDrawDayAward()) {
            return 0;
        }
        return this.arenaData.singleReward;
    }

    private long getActivityTime() {
        return this.arenaData.activityTime;
    }


    private void setActivityTime(long timeMillis) {
        this.arenaData.activityTime = timeMillis;
    }


    public int getLastTotalRank() {
        return ArenaService.getInstance().getLastAllScoreRank(this.player.getId());
    }


    public int getCurrentTotalRank() {
        return ArenaService.getInstance().getCurrentAllScoreRank(this.player.getId());
    }


    public int getCurrentTotalScore() {
        return this.arenaData.scoreMonth;
    }

    private void reCalcScore(int areaPlayerCount, int changeAddRate) {
        float addRate = (20 - areaPlayerCount) * 0.1F + 1.0F;
        addRate = (addRate > 2.8F) ? 2.8F : addRate;
        int score = (int) ((GlobalConfig.JJC_KillScore * changeAddRate) * addRate);
        addScore(score);
    }


    public void onDead() {
        this.arenaData.combo = 0;
        this.arenaData.deadMonth++;
    }

    public void onHit(int areaPlayerCount, int changeAddRate) {
        this.arenaData.combo++;

        if (this.arenaData.comboDaily < this.arenaData.combo) {
            this.arenaData.comboDaily = this.arenaData.combo;
        }

        this.arenaData.killDaily++;
        this.arenaData.killMonth++;
        reCalcScore(areaPlayerCount, changeAddRate);
    }


    public void addScore(int addNumber) {
        this.arenaData.score += addNumber;
    }


    public void killPlayer(WNPlayer enemy, Area.Actor deadActor, int areaPlayerCount) {
        if (isInArenaMap(this.player) && isInArenaMap(enemy)) {

            boolean hasTsBuff = deadActor.buffers.remove(String.valueOf(Const.Arena.ARENA_TIANSHEN.value));
            int changeAddRate = hasTsBuff ? 3 : 1;
            onHit(areaPlayerCount, changeAddRate);
            enemy.arenaManager.onDead();


            this.player.achievementManager.onArenaKill();
            this.player.achievementManager.onArenaScore(getScore());
            Out.debug(new Object[]{"killPlayer: ", Integer.valueOf(this.arenaData.score), " ", Integer.valueOf(this.arenaData.combo)});
        }
    }


    public void dropPlayerScore(WNPlayer hitPlayer, float x, float y, int score) {
        if (score == 0) {
            return;
        }
        Area arenaArea = this.player.getArea();
        if (arenaArea == null) {
            return;
        }

        List<NormalItem> normalItems = new ArrayList<>();
        int minDropCount = 3;
        int maxDropCount = 7;
        if (score < minDropCount) {
            minDropCount = score;
        }
        if (score < maxDropCount) {
            maxDropCount = score;
        }

        int randomDropCount = RandomUtil.getInt(minDropCount, maxDropCount);
        float scoreF = score;
        for (; randomDropCount > 0; randomDropCount--) {
            int randomScore = getRandomNum(randomDropCount, score);
            score -= randomScore;

            String itemCode = "";
            if (randomScore / scoreF * 100.0F > 22.0F) {
                itemCode = GlobalConfig.JJC_BigItemCode;
            } else if (randomScore / scoreF * 100.0F > 15.0F && randomScore / scoreF * 100.0F <= 22.0F) {
                itemCode = GlobalConfig.JJC_MiddleItemCode;
            } else {
                itemCode = GlobalConfig.JJC_SmallItemCode;
            }
            List<NormalItem> tempNormalItems = ItemUtil.createItemsByItemCode(itemCode, randomScore);
            normalItems.addAll(tempNormalItems);
        }

        Out.debug(new Object[]{getClass(), "Area onPlayerDeadByPlayer items:", Integer.valueOf(normalItems.size())});
        List<ItemToBtlServerData> itemsPayLoad = new ArrayList<>();
        for (NormalItem dropItem : normalItems) {
            dropItem.itemDb.gotTime = new Date();
            Area.AreaItem areaItem = new Area.AreaItem(dropItem);
            areaItem.dropPlayer = this.player;


            areaItem.dropX = x;


            areaItem.dropY = y;

            arenaArea.items.put(dropItem.itemDb.id, areaItem);
            List<String> list_pids = new ArrayList<>();
            if (hitPlayer != null) {
                list_pids.add(hitPlayer.getId());
            }
            ItemToBtlServerData itemData = dropItem.toJSON4BatterServer(list_pids, Const.TEAM_DISTRIBUTE_TYPE.FREEDOM, true);
            itemData.protectTime = 0;
            itemData.distributeType = 0;
            itemsPayLoad.add(itemData);
        }

        String data = Utils.toJSON(new Object[]{"pos", Utils.ofMap(new Object[]{"x", Float.valueOf(x), "y", Float.valueOf(y)}), "items", itemsPayLoad}).toJSONString();
        Out.debug(new Object[]{getClass(), " onPlayerDeadByPlayer:", data});
        this.player.getXmdsManager().onMonsterDiedDrops(arenaArea.instanceId, data);

        addScore(-((int) scoreF));
    }


    private static int getRandomNum(int people, int wmoney) {
        if (people == 1) {
            return wmoney;
        }

        double min = 1.0D;
        double max = (wmoney / people * 2);

        double money = RandomUtil.randomDouble() * max;
        money = (money <= min) ? 1.0D : money;
        return (int) money;
    }


    public void onAreaClose(int rankIndex) {
        if (rankIndex == 1) {
            this.arenaData.singleWinTimes++;
            if (this.arenaData.singleWinTimes == 1) {
                this.arenaData.firstSingleWinTime = System.currentTimeMillis();
            }
        }
        if (!ArenaService.getInstance().canDrawDayAward()) {
            this.arenaData.singleReward = 1;

            ArenaService.getInstance().refreshScoreRank(this.player.getId(), getScore());
        }
        this.arenaData.scoreMonth += getScore();

        ArenaService.getInstance().refreshMonthScoreRank(this.player.getId(), this.arenaData.scoreMonth);
        resetDaily();
        this.player.updateSuperScriptList(getSuperScript());
    }


    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        ArrayList<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.JJC.getValue())) {
            return list;
        }

        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(Const.SUPERSCRIPT_TYPE.JJC_ENTER.getValue());
        data.setNumber((canEnter() == null) ? 1 : 0);

        PlayerHandler.SuperScriptType.Builder data1 = PlayerHandler.SuperScriptType.newBuilder();
        data1.setType(Const.SUPERSCRIPT_TYPE.JJC_REWARD.getValue());
        data1.setNumber(0);

        if (getSingleReward() == 1) {
            data1.setNumber(data1.getNumber() + 1);
        } else if (this.arenaData.totalReward == 1 && getLastTotalRank() != 0) {
            data1.setNumber(data1.getNumber() + 1);
        }

        list.add(data.build());
        list.add(data1.build());

        return list;
    }


    public void handleEnterArenaArea(ArenaHandler.EnterArenaAreaResponse.Builder result) {
        String msg = canEnter();
        if (msg == null) {
            try {
                this.player.taskManager.dealTaskEvent(Const.TaskType.JOAN_ARENA, 1);
                this.player.dailyActivityMgr.onEvent(Const.DailyType.ARENA, "0", 1);


                Map<String, TeamData.TeamMemberData> members = this.player.getTeamManager().getTeamMembers();
                if (members != null) {
                    if (this.player.getTeamManager().isTeamLeader()) {
                        for (TeamData.TeamMemberData member : members.values()) {
                            if (member.isFollow()) {
                                TeamService.followLeader(member.getPlayer(), false);
                            }
                        }
                    } else {
                        TeamService.followLeader(this.player, false);
                    }
                }
                enterArenaArea();
                result.setS2CCode(200);
            } catch (Exception e) {
                Out.error(new Object[]{getClass(), "_enterArenaArea rpc error!", e});
                result.setS2CCode(500);
                result.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
            }
        } else {
            result.setS2CCode(500);
            result.setS2CMsg(msg);
        }
    }


    private boolean isInArenaMap(WNPlayer player) {
        return isInArenaMap(player.getAreaId());
    }

    public boolean isInArenaMap(int areaId) {
        return (areaId == this.mapProp.mapID);
    }


    public void handleLeaveArenaArea(ArenaHandler.LeaveArenaAreaResponse.Builder result) {
        if (isInArenaMap(this.player)) {
            Area leaveArea = this.player.getArea();
            float x = 0.0F;
            float y = 0.0F;
            if (leaveArea != null) {
                try {
                    if (leaveArea.hasPlayer(this.player.getId())) {
                        GetPlayerData playerData = leaveArea.getPlayerData(this.player.getId());
                        if (playerData != null) {
                            x = playerData.x;
                            y = playerData.y;
                        }

                        int score = this.arenaData.score;
                        if (score > 0) {
                            dropPlayerScore(this.player, x, y, score);

                        }

                    }

                } catch (Exception e) {
                    Out.error(new Object[]{e});
                }
            }


            Area area = AreaUtil.dispatchByAreaId(this.player, (this.player.getPlayerTempData()).historyAreaId, (this.player.getPlayerTempData()).historyX, (this.player.getPlayerTempData()).historyY);

            this.player.getXmdsManager().refreshPlayerPKMode(this.player.getId(), this.player.pkRuleManager.pkData.pkModel);
            if (area != null) {
                result.setS2CCode(200);
            } else {
                result.setS2CCode(500);
                result.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
            }
        } else {

            result.setS2CCode(500);
            result.setS2CMsg(LangService.getValue("AREA_ID_NULL"));
        }
    }


    public void handleGetReward(int requestRewardType, ArenaHandler.ArenaRewardResponse.Builder result) {
        if ((getSingleReward() != 1 && requestRewardType == 1) || (this.arenaData.totalReward != 1 && requestRewardType == 2)) {

            result.setS2CCode(500);
            result.setS2CMsg(LangService.getValue("SOLO_REWARD_HAS_DRAWED"));

        } else {

            int rankIndex = 0;
            if (requestRewardType == 1) {
                rankIndex = getSingleRankIndex();
            } else if (requestRewardType == 2) {
                rankIndex = getLastTotalRank();
            }
            Out.debug(new Object[]{"handleGetReward rankIndex: ", Integer.valueOf(rankIndex)});
            if (rankIndex > 0) {
                JJCRewardExt prop = null;
                for (JJCRewardExt rewExt : GameData.JJCRewards.values()) {
                    if (requestRewardType == rewExt.type && ((
                            rankIndex >= rewExt.startRank && rankIndex <= rewExt.stopRank) || rewExt.stopRank == 0)) {
                        prop = rewExt;

                        break;
                    }
                }

                Out.debug(new Object[]{"handleGetReward prop: ", prop});
                if (prop == null) {
                    result.setS2CCode(500);
                    result.setS2CMsg(LangService.getValue("SOLO_REWARD_NOT_EXIST"));
                } else {
                    List<NormalItem> items = ItemUtil.createItemsByItemCode(prop._rankReward);

                    if (!this.player.getWnBag().testAddEntityItems(items, true)) {
                        result.setS2CCode(500);
                        result.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
                        return;
                    }
                    this.player.getWnBag().addEntityItems(items, Const.GOODS_CHANGE_TYPE.arena);
                    result.setS2CCode(200);
                    if (requestRewardType == 1) {
                        this.arenaData.singleReward = 2;
                    } else if (requestRewardType == 2) {
                        this.arenaData.totalReward = 2;
                    }
                }
            } else {

                result.setS2CCode(500);
                result.setS2CMsg(LangService.getValue("SOLO_REWARD_CANNOT_DRAW"));
            }
        }
    }


    private static ArenaDataPO getFromRedis(String playerId) {
        return (ArenaDataPO) PlayerPOManager.findPO(ConstsTR.player_arena_dataTR, playerId, ArenaDataPO.class);
    }


    public void setArenaInstanceId(String instanceId) {
        this.arenaData.arenaInstanceId = instanceId;
    }

    public String getArenaInstanceId() {
        return this.arenaData.arenaInstanceId;
    }


    public boolean isInArena() {
        String instanceId = getArenaInstanceId();
        if (StringUtil.isNotEmpty(instanceId)) {
            Area area = AreaManager.getInstance().getArea(instanceId);
            if (area != null) {
                return true;
            }
        }
        return false;
    }


    public void initSeasonAward() {
        if (this.arenaData.season != ArenaService.getInstance().getTerm()) {
            this.arenaData.totalReward = 1;
            this.arenaData.season = ArenaService.getInstance().getTerm();

            this.arenaData.deadMonth = 0;
            this.arenaData.killMonth = 0;
            this.arenaData.scoreMonth = 0;
            this.arenaData.singleWinTimes = 0;
            this.arenaData.firstSingleWinTime = 0L;
        }
    }
}


