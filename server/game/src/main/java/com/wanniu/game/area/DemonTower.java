package com.wanniu.game.area;

import Xmds.GetPlayerData;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.protocol.PomeloPush;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.game.activity.DemonTowerService;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ScheduleCO;
import com.wanniu.game.data.ext.DropListExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.DemonTowerPO;
import com.wanniu.game.rank.RankType;
import com.wanniu.game.sevengoal.SevenGoalManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import pomelo.Common;
import pomelo.area.BattleHandler;


public class DemonTower
        extends Area {
    public int level = 1;

    public WNPlayer curPlayer;

    public Date startDate;


    static class HistoryItem {
        private Map<String, Integer> historyVirtualItems = new HashMap<>();

        private Map<String, Integer> historyItems = new HashMap<>();

        void addItem(NormalItem item) {
            Integer num = this.historyItems.get(item.itemCode());
            if (num != null) {
                num = Integer.valueOf(num.intValue() + item.getNum());
            } else {
                num = Integer.valueOf(item.getNum());
            }
            this.historyItems.put(item.itemCode(), num);
        }

        void addVirtualItem(String itemCode, int num) {
            Integer oldNum = this.historyVirtualItems.get(itemCode);
            if (oldNum != null) {
                num += oldNum.intValue();
            }
            this.historyItems.put(itemCode, Integer.valueOf(num));
        }
    }

    Map<String, HistoryItem> historyTotals = new HashMap<>();
    private Map<String, GetPlayerData> datas;

    public DemonTower(JSONObject opts) {
        super(opts);


        this.datas = new HashMap<>();
        if (opts.containsKey("lv")) this.level = opts.getIntValue("lv");
        this.startDate = new Date();
    }

    public void bindBattleServer(WNPlayer player) {
        super.bindBattleServer(player);
        this.curPlayer = player;
    }

    public boolean isUseTC() {
        return false;
    }

    public void onMonsterDead(int monsterId, int level, float x, float y, int attackType, String refreshPoint, WNPlayer player, JSONArray teamSharedIdList, JSONArray atkAssistantList) {
        Out.debug(new Object[]{getClass().getName(), " onMonsterDead : ", Integer.valueOf(monsterId), " - ", Float.valueOf(x), ", ", Float.valueOf(y)});
    }

    private List<NormalItem> randomTC(List<DropListExt> drops, int level) {
        List<NormalItem> items = null;
        if (!drops.isEmpty()) {
            DropListExt prop = drops.get(0);
            items = ItemUtil.createItemsByItemCode(prop.firstRewardPreview);
        } else {
            items = new ArrayList<>(0);
        }
        return items;
    }

    public Area.AreaItem onPickItem(String playerId, String itemId, boolean isGuard) {
        Out.debug(new Object[]{getClass().getName(), " onPickItem : ", itemId, Boolean.valueOf(isGuard)});
        return super.onPickItem(playerId, itemId, isGuard);
    }

    protected void addVirtureItem(WNPlayer player, NormalItem dropItem, Const.GOODS_CHANGE_TYPE type) {
        super.addVirtureItem(player, dropItem, type);
        Area.Actor actor = this.actors.get(player.getId());
        Map<String, Integer> historyItems = actor.historyVirtualItems;
        if (historyItems == null)
            actor.historyVirtualItems = historyItems = new HashMap<>();
        String itemCode = dropItem.itemCode();
        int count = historyItems.containsKey(itemCode) ? ((Integer) historyItems.get(dropItem.itemCode())).intValue() : 0;
        count += dropItem.getWorth();
        historyItems.put(itemCode, Integer.valueOf(count));
    }

    public void onRobotQuit(int second) {
    }

    public void onGameOver(JSONObject event) {
        int winForce = event.getIntValue("winForce");
        boolean isWin = (winForce == 2);
        onPlayerWin(isWin);
    }

    private void resultPush(WNPlayer player, BattleHandler.FightLevelResultPush.Builder result, List<DropListExt> drops, DemonTowerPO curPlayerPO, long costTime, boolean refreshChord) {
        ScheduleCO co = (ScheduleCO) GameData.Schedules.get(Integer.valueOf(1));
        if (co != null) {
            result.setIsMax(0);
            List<NormalItem> items = null;
            if (curPlayerPO.maxFloor == this.level) {
                items = randomTC(drops, player.getLevel());
            } else {

                items = new LinkedList<>();
            }
            HistoryItem totalItems = this.historyTotals.get(player.getId());
            if (totalItems == null) {
                totalItems = new HistoryItem();
                this.historyTotals.put(player.getId(), totalItems);
            }
            for (NormalItem item : items) {
                if (item.isVirtual()) {
                    result.addItemLine1(newItemBuilder(item.itemCode(), item.getNum()));
                    totalItems.addVirtualItem(item.itemCode(), item.getNum());
                } else {
                    result.addItemLine2(newItemBuilder(item.itemCode(), item.getNum()));
                    totalItems.addItem(item);
                }
                player.bag.addCodeItemMail(item.itemCode(), item.getNum(), Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.DemonTower, "Bag_full_common");
            }
            Area.Actor actor = getActor(player.getId());
            if (actor != null && actor.historyVirtualItems != null) {
                for (Map.Entry<String, Integer> entry : actor.historyVirtualItems.entrySet()) {
                    result.addItemLine1(newItemBuilder(entry.getKey(), ((Integer) entry.getValue()).intValue()));
                    totalItems.addVirtualItem(entry.getKey(), ((Integer) entry.getValue()).intValue());
                }
            }
        }
        Common.DemonTowerFloorInfo.Builder floorInfoBuilder = player.demonTowerManager.getFloorInfoBuilder(this.level);
        result.setDemonTowerFloorInfo(floorInfoBuilder);
        result.setCurrentTime((int) costTime / 1000);
        result.setNewRecordFloor((curPlayerPO.maxFloor == this.level));
        result.setNewRecordTime(refreshChord);


        int maxFloor = curPlayerPO.maxFloor;

        if (this.level < maxFloor) {
            maxFloor--;
        }
        result.setMyMaxFloorId(maxFloor);

        player.receive("area.battlePush.fightLevelResultPush", (GeneratedMessage) result.build());
    }


    private BattleHandler.ItemNormal.Builder newItemBuilder(String itemCode, int num) {
        return BattleHandler.ItemNormal.newBuilder().setItemCode(itemCode).setItemNum(num);
    }


    private void onPlayerWin(boolean isWin) {
        Out.debug(new Object[]{getClass().getName(), " onGameOver : ", Boolean.valueOf(isWin)});
        int week = Calendar.getInstance().get(7);
        List<DropListExt> drops = GameData.findDropLists(t ->
                (t.isWeek(week) && t.floorNo == this.level));


        BILogService.getInstance().ansycReportDemonTower(this.curPlayer.getPlayer(), isWin ? 1 : 0, this.level);

        DemonTowerPO curPlayerPO = this.curPlayer.demonTowerManager.po;
        if (isWin) {

            boolean jumpToNext = (this.level != GameData.DropLists.size());
            long costTime = (new Date()).getTime() - this.startDate.getTime();
            boolean refreshRecord = DemonTowerService.getInstance().finishFloor(this.level, this.curPlayer.getId(), costTime);
            for (String rid : this.actors.keySet()) {
                WNPlayer player = getPlayer(rid);
                if (player != null) {
                    BattleHandler.FightLevelResultPush.Builder result = BattleHandler.FightLevelResultPush.newBuilder();
                    result.setTime(6);
                    result.setLevel(this.level);
                    result.setType(0);
                    resultPush(player, result, drops, curPlayerPO, costTime, refreshRecord);


                    player.achievementManager.onPassDemonTower(this.level, isWin);
                }
            }


            if (this.level == curPlayerPO.maxFloor) {
                curPlayerPO.maxFloor++;
                curPlayerPO.firstTimeToPeak = new Date();
                curPlayerPO.leastTimeList.add(Long.valueOf(costTime));

            } else if (((Long) curPlayerPO.leastTimeList.get(this.level - 1)).longValue() > costTime) {
                curPlayerPO.leastTimeList.set(this.level - 1, Long.valueOf(costTime));
            }

            this.curPlayer.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.DEMON_TOWER_COUNT, new Object[0]);
            if (jumpToNext) {
                JobFactory.addDelayJob(() -> {
                    for (Map.Entry<String, Area.Actor> entry : this.actors.entrySet()) {
                        if (((Area.Actor) entry.getValue()).alive) {
                            this.datas.put(entry.getKey(), getPlayerData(entry.getKey()));
                            continue;
                        }
                        GetPlayerData data = this.datas.get(entry.getKey());
                        if (data == null) {
                            data = new GetPlayerData();
                            this.datas.put(entry.getKey(), data);
                            continue;
                        }
                        data.hp = 0;
                        data.mp = 0;
                    }
                    this.level++;
                    if (this.curPlayer.rankManager != null)
                        this.curPlayer.rankManager.onEvent(RankType.DEMON_TOWER, new Object[]{Integer.valueOf(curPlayerPO.maxFloor - 1)});
                    DropListExt dropListExt = (DropListExt) GameData.DropLists.get(Integer.valueOf(this.level));
                    if (dropListExt == null) {
                        Out.error(new Object[]{"参数错误"});
                        return;
                    }
                    int mapId = dropListExt.mapId;
                    DemonTower area = (DemonTower) AreaUtil.createArea(this.curPlayer, Utils.toJSON(new Object[]{"logicServerId", Integer.valueOf(this.curPlayer.getLogicServerId()), "areaId", Integer.valueOf(mapId), "lv", Integer.valueOf(this.level)}));
                    area.datas = this.datas;
                    area.level = this.level;
                    area.historyTotals = this.historyTotals;
                    Out.debug(new Object[]{Integer.valueOf(this.datas.size()), " demon tower game over===================================Player:", this.curPlayer.getName(), " change area!!! lv:", Integer.valueOf(area.level)});
                    AreaData areaData = new AreaData(area.areaId, area.instanceId);
                    for (String rid : this.actors.keySet()) {
                        WNPlayer player = getPlayer(rid);
                        if (player != null) AreaUtil.changeArea(player, areaData);
                    }
                } 8000L);


                return;
            }
        } else {
            this.curPlayer.demonTowerManager.po.failedMapId = this.areaId;
        }


        for (String rid : this.actors.keySet()) {
            WNPlayer player = getPlayer(rid);
            if (player != null && curPlayerPO.maxFloor == this.level) {
                BattleHandler.FightLevelResultPush.Builder result = BattleHandler.FightLevelResultPush.newBuilder();
                result.setTime(10);
                result.setLevel(this.level);
                result.setType(1);

                ScheduleCO co = (ScheduleCO) GameData.Schedules.get(Integer.valueOf(1));
                if (co != null) {
                    result.setIsMax(0);
                    HistoryItem totalItems = this.historyTotals.get(rid);
                    if (totalItems == null) {
                        totalItems = new HistoryItem();
                        this.historyTotals.put(player.getId(), totalItems);
                    }

                    if (this.level >= GameData.DropLists.size()) {
                        List<NormalItem> items = randomTC(drops, player.getLevel());
                        for (NormalItem item : items) {
                            if (item.isVirtual()) {
                                totalItems.addVirtualItem(item.itemCode(), item.getNum());
                            } else {
                                totalItems.addItem(item);
                            }
                            player.bag.addCodeItemMail(item.itemCode(), item.getNum(), Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.DemonTower, "Bag_full_common");
                        }
                    }

                    for (Map.Entry<String, Integer> entry : (Iterable<Map.Entry<String, Integer>>) totalItems.historyVirtualItems.entrySet()) {
                        result.addItemLine1(newItemBuilder(entry.getKey(), ((Integer) entry.getValue()).intValue()));
                    }
                    for (Map.Entry<String, Integer> entry : (Iterable<Map.Entry<String, Integer>>) totalItems.historyItems.entrySet()) {
                        result.addItemLine2(newItemBuilder(entry.getKey(), ((Integer) entry.getValue()).intValue()));
                    }
                } else {
                    result.setIsMax(1);

                    Collection<String> teamData = player.getTeamMembers();
                    if (teamData != null) {
                        for (String teamMemPlayerId : teamData) {

                            if (this.actors.containsKey(teamMemPlayerId) && (getActor(teamMemPlayerId)).profitable) {
                                int xianyuan = player.processXianYuanGet(GlobalConfig.Fate_Resource);
                                result.addItemLine1(newItemBuilder("fate", xianyuan));
                                break;
                            }
                        }
                    }
                }
                Common.DemonTowerFloorInfo.Builder floorInfoBuilder = player.demonTowerManager.getFloorInfoBuilder(this.level);
                result.setDemonTowerFloorInfo(floorInfoBuilder);
                result.setMyMaxFloorId(curPlayerPO.maxFloor - 1);
                Out.error(new Object[]{result.build()});
                player.receive("area.battlePush.fightLevelResultPush", (GeneratedMessage) result.build());
            }
        }

        super.onRobotQuit(10);
    }

    public String toJSON4EnterScene(WNPlayer player) {
        JSONObject json = player.toJSON4EnterScene(this);

        Map<String, Number> tempData = (Map<String, Number>) json.get("tempData");
        tempData.put("x", Integer.valueOf(0));
        tempData.put("y", Integer.valueOf(0));
        GetPlayerData data = this.datas.get(player.getId());
        if (data != null) {
            int maxHp = ((Integer) player.btlDataManager.finalInflus.get(Const.PlayerBtlData.MaxHP)).intValue();
            int hp = data.hp + maxHp * 20 / 100;
            tempData.put("hp", Integer.valueOf(Math.min(hp, maxHp)));
            tempData.put("mp", Integer.valueOf(data.mp));
        }


        return json.toJSONString();
    }

    protected void onDailyActivity(WNPlayer player) {
        super.onDailyActivity(player);
        player.dailyActivityMgr.onEvent(Const.DailyType.DEMON_TOWER, "0", 1);
    }


    public void pushRelive(WNPlayer player) {
    }


    public void onPlayerDeadByMonster(WNPlayer player, AreaEvent.MonsterData monsterData, float playerX, float playerY) {
        Out.debug(new Object[]{getClass().getName(), " onPlayerDeadByMonster : ", player.getName()});

        if (isAllActorDie()) {
            this.isClose = true;
            onPlayerWin(false);
            addCloseFuture();
        }

        player.activityManager.triggerLimitTimeGift(2);
    }


    public void onPlayerDeadByPlayer(WNPlayer deadPlayer, WNPlayer hitPlayer, float x, float y) {
        Out.warn(new Object[]{getClass().getName(), " onPlayerDeadByPlayer : ", deadPlayer.getName()});
    }


    public void onPlayerEntered(WNPlayer player) {
        super.onPlayerEntered(player);
    }


    public void onPlayerLeaved(WNPlayer player) {
        if (!this.isClose && isAllActorDie()) {
            this.isClose = true;
            onPlayerWin(false);
            addCloseFuture();
        }
    }


    public void onEndEnterScene(WNPlayer player) {
        super.onEndEnterScene(player);
        player.receive((Message) new PomeloPush() {
            protected void write() throws IOException {
                BattleHandler.SceneNamePush.Builder push = BattleHandler.SceneNamePush.newBuilder();
                push.setSceneName(LangService.format("DEMON_TOWER_LV", new Object[]{Integer.valueOf(this.this$0.level)}));
                this.body.writeBytes(push.build().toByteArray());
            }


            public String getRoute() {
                return "area.battlePush.sceneNamePush";
            }
        });
    }
}


