package com.wanniu.game.area;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.DungeonMapCostCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.FightLevelsPO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pomelo.area.BagHandler;
import pomelo.area.BattleHandler;


public class ResourceDungeon
        extends Area {
    public int killedMonster;
    public long createTime;

    public ResourceDungeon(JSONObject opts) {
        super(opts);
        this.killedMonster = 0;
    }


    public void onMonsterDead(int monsterId, int level, float x, float y, int attackType, String refreshPoint, WNPlayer hitFinalPlayer, JSONArray teamSharedIdList, JSONArray atkAssistantList) {
        Out.debug(new Object[]{getClass().getName(), " onMonsterDead : ", Integer.valueOf(monsterId), " - ", Float.valueOf(x), ", ", Float.valueOf(y)});
        super.onMonsterDead(monsterId, level, x, y, attackType, refreshPoint, hitFinalPlayer, teamSharedIdList, null);
        this.killedMonster++;
    }


    public Area.AreaItem onPickItem(String playerId, String itemId, boolean isGuard) {
        Out.debug(new Object[]{getClass().getName(), " onPickItem : ", itemId, Boolean.valueOf(isGuard)});


        Area.AreaItem areaItem = super.onPickItem(playerId, itemId, isGuard);
        if (areaItem == null) {
            return null;
        }
        Area.Actor actor = this.actors.get(playerId);
        if (actor.historyItems == null) {
            actor.historyItems = new ArrayList<>();
        }

        synchronized (actor.historyItems) {
            actor.historyItems.add(areaItem.item);
        }


        DungeonMapCostCO resourceConfig = (DungeonMapCostCO) GameData.DungeonMapCosts.get(Integer.valueOf(this.prop.mapID));
        if (resourceConfig.playType == 1) {
            BagHandler.BagNewItemFromResFubenPush.Builder push = BagHandler.BagNewItemFromResFubenPush.newBuilder();
            push.addS2CData(areaItem.item.toJSON4MiniItem());
            WNPlayer player = getPlayer(playerId);
            player.receive("area.bagPush.bagNewItemFromResFubenPush", (GeneratedMessage) push.build());
        }

        return areaItem;
    }

    protected void addVirtureItem(WNPlayer player, NormalItem dropItem, Const.GOODS_CHANGE_TYPE type) {
        if (this.isClose) {
            return;
        }
        super.addVirtureItem(player, dropItem, type);
        Area.Actor actor = this.actors.get(player.getId());
        if (actor == null) {
            return;
        }
        Map<String, Integer> historyItems = actor.historyVirtualItems;
        if (historyItems == null) {
            actor.historyVirtualItems = historyItems = new HashMap<>();
        }
        String itemCode = dropItem.itemCode();
        int count = historyItems.containsKey(itemCode) ? ((Integer) historyItems.get(dropItem.itemCode())).intValue() : 0;
        count += dropItem.getWorth();
        historyItems.put(itemCode, Integer.valueOf(count));
    }


    public void onPlayerEntered(WNPlayer player) {
        super.onPlayerEntered(player);

        this.createTime = System.currentTimeMillis();


        FightLevelsPO fightLevelsPO = player.fightLevelManager.getFightLevelsPo();
        FightLevelsPO.ResourceDungeonPO resourceDungeon = (FightLevelsPO.ResourceDungeonPO) fightLevelsPO.resourceDungeon.get(Integer.valueOf(this.areaId));
        if (resourceDungeon.entering) {
            resourceDungeon.entering = false;
            resourceDungeon.usedTimes++;
            Out.info(new Object[]{player.getId(), " 成功进入资源副本:", player.getArea().getSceneName(), " 本日进入次数为:", Integer.valueOf(resourceDungeon.usedTimes)});
        }

        DungeonMapCostCO resourceConfig = (DungeonMapCostCO) GameData.DungeonMapCosts.get(Integer.valueOf(this.prop.mapID));
        if (resourceConfig.playType == 1) {
            player.dailyActivityMgr.onEvent(Const.DailyType.RESOURCE_CHALLENGE, "0", 1);
        } else if (resourceConfig.playType == 2) {
            player.dailyActivityMgr.onEvent(Const.DailyType.RESOURCE_WATCH_PET, "0", 1);
        } else if (resourceConfig.playType == 3) {
            player.dailyActivityMgr.onEvent(Const.DailyType.RESOURCE_FARM, "0", 1);
        }


        if (resourceConfig.playType == 1) {
            player.activityManager.triggerLimitTimeGift(1);
        }
    }


    public void pushRelive(WNPlayer player) {
        DungeonMapCostCO resourceConfig = (DungeonMapCostCO) GameData.DungeonMapCosts.get(Integer.valueOf(this.prop.mapID));
        if (resourceConfig.playType == 2) {
            super.pushRelive(player);
        }
    }


    public void onGameOver(JSONObject event) {
        int winForce = event.getIntValue("winForce");

        DungeonMapCostCO resourceConfig = (DungeonMapCostCO) GameData.DungeonMapCosts.get(Integer.valueOf(this.prop.mapID));
        if (resourceConfig.playType == 1) {

            JobFactory.addDelayJob(() -> onPlayerWin((winForce == 1), resourceConfig), 3000L);

        } else {

            JobFactory.addDelayJob(() -> onPlayerWin((winForce == 2), resourceConfig), 3000L);
        }
    }


    private void onPlayerWin(boolean isWin, DungeonMapCostCO resourceConfig) {
        Out.debug(new Object[]{getClass().getName(), " onGameOver : "});

        for (String rid : this.actors.keySet()) {
            Area.Actor actor = this.actors.get(rid);
            WNPlayer player = getPlayer(rid);
            if (player != null && actor != null) {

                if (resourceConfig != null) {

                    if (resourceConfig.isDoubleBonus == 1) {
                        FightLevelsPO fightLevelsPO = player.fightLevelManager.getFightLevelsPo();
                        fightLevelsPO.doubleReward = new FightLevelsPO.RDDoubleRewardPO();

                        fightLevelsPO.doubleReward.doubleVirtualItems = actor.historyVirtualItems;
                        fightLevelsPO.doubleReward.doubleItems = new ArrayList();
                        if (actor.historyItems != null) {
                            synchronized (actor.historyItems) {
                                for (NormalItem item : actor.historyItems) {
                                    fightLevelsPO.doubleReward.doubleItems.add(item.itemDb);
                                }
                            }
                        }
                    }
                    BattleHandler.ResourceDungeonResultPush.Builder resourcePush = BattleHandler.ResourceDungeonResultPush.newBuilder();
                    resourcePush.setDungeonId(this.prop.mapID);
                    resourcePush.setKillMonster(this.killedMonster);
                    resourcePush.setDoubleCost((resourceConfig.isDoubleBonus == 1) ? resourceConfig.bounsCostDiamond : -1);

                    resourcePush.setExp(0);
                    resourcePush.setGold(0);
                    if (actor.historyVirtualItems != null && actor.historyVirtualItems.size() > 0) {
                        for (String code : actor.historyVirtualItems.keySet()) {
                            int value = ((Integer) actor.historyVirtualItems.get(code)).intValue();
                            switch (code) {
                                case "exp":
                                    resourcePush.setExp(value);

                                case "gold":
                                    resourcePush.setGold(value);
                            }


                        }
                    }
                    Map<String, Integer> finalItems = new HashMap<>();
                    if (actor.historyItems != null && actor.historyItems.size() > 0) {
                        synchronized (actor.historyItems) {
                            for (NormalItem item : actor.historyItems) {
                                if (finalItems.get(item.itemDb.code) == null) {
                                    finalItems.put(item.itemDb.code, Integer.valueOf(item.itemDb.groupCount));
                                    continue;
                                }
                                finalItems.put(item.itemDb.code, Integer.valueOf(((Integer) finalItems.get(item.itemDb.code)).intValue() + item.itemDb.groupCount));
                            }
                        }
                    }

                    List<BattleHandler.ItemNormal> list_rewards = new ArrayList<>();
                    for (String code : finalItems.keySet()) {
                        BattleHandler.ItemNormal.Builder itemNormal = BattleHandler.ItemNormal.newBuilder();
                        itemNormal.setItemCode(code);
                        itemNormal.setItemNum(((Integer) finalItems.get(code)).intValue());
                        list_rewards.add(itemNormal.build());
                    }

                    resourcePush.addAllItemLine1(list_rewards);
                    resourcePush.setSucc(isWin ? 1 : 0);
                    player.receive("area.battlePush.resourceDungeonResultPush", (GeneratedMessage) resourcePush.build());
                }


                BILogService.getInstance().ansycReportResourceDungeon(player.getPlayer(), isWin ? 1 : 0, resourceConfig.mapID);
            }
        }
    }


    public void onPlayerDeadByMonster(WNPlayer player, AreaEvent.MonsterData monsterData, float playerX, float playerY) {
        super.onPlayerDeadByMonster(player, monsterData, playerX, playerY);
    }
}


