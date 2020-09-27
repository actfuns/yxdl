/*     */ package com.wanniu.game.area;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.DungeonMapCostCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.FightLevelsPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.area.BagHandler;
/*     */ import pomelo.area.BattleHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ResourceDungeon
/*     */   extends Area
/*     */ {
/*     */   public int killedMonster;
/*     */   public long createTime;
/*     */   
/*     */   public ResourceDungeon(JSONObject opts) {
/*  40 */     super(opts);
/*  41 */     this.killedMonster = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onMonsterDead(int monsterId, int level, float x, float y, int attackType, String refreshPoint, WNPlayer hitFinalPlayer, JSONArray teamSharedIdList, JSONArray atkAssistantList) {
/*  46 */     Out.debug(new Object[] { getClass().getName(), " onMonsterDead : ", Integer.valueOf(monsterId), " - ", Float.valueOf(x), ", ", Float.valueOf(y) });
/*  47 */     super.onMonsterDead(monsterId, level, x, y, attackType, refreshPoint, hitFinalPlayer, teamSharedIdList, null);
/*  48 */     this.killedMonster++;
/*     */   }
/*     */ 
/*     */   
/*     */   public Area.AreaItem onPickItem(String playerId, String itemId, boolean isGuard) {
/*  53 */     Out.debug(new Object[] { getClass().getName(), " onPickItem : ", itemId, Boolean.valueOf(isGuard) });
/*     */ 
/*     */ 
/*     */     
/*  57 */     Area.AreaItem areaItem = super.onPickItem(playerId, itemId, isGuard);
/*  58 */     if (areaItem == null) {
/*  59 */       return null;
/*     */     }
/*  61 */     Area.Actor actor = this.actors.get(playerId);
/*  62 */     if (actor.historyItems == null) {
/*  63 */       actor.historyItems = new ArrayList<>();
/*     */     }
/*     */     
/*  66 */     synchronized (actor.historyItems) {
/*  67 */       actor.historyItems.add(areaItem.item);
/*     */     } 
/*     */ 
/*     */     
/*  71 */     DungeonMapCostCO resourceConfig = (DungeonMapCostCO)GameData.DungeonMapCosts.get(Integer.valueOf(this.prop.mapID));
/*  72 */     if (resourceConfig.playType == 1) {
/*  73 */       BagHandler.BagNewItemFromResFubenPush.Builder push = BagHandler.BagNewItemFromResFubenPush.newBuilder();
/*  74 */       push.addS2CData(areaItem.item.toJSON4MiniItem());
/*  75 */       WNPlayer player = getPlayer(playerId);
/*  76 */       player.receive("area.bagPush.bagNewItemFromResFubenPush", (GeneratedMessage)push.build());
/*     */     } 
/*     */     
/*  79 */     return areaItem;
/*     */   }
/*     */   
/*     */   protected void addVirtureItem(WNPlayer player, NormalItem dropItem, Const.GOODS_CHANGE_TYPE type) {
/*  83 */     if (this.isClose) {
/*     */       return;
/*     */     }
/*  86 */     super.addVirtureItem(player, dropItem, type);
/*  87 */     Area.Actor actor = this.actors.get(player.getId());
/*  88 */     if (actor == null) {
/*     */       return;
/*     */     }
/*  91 */     Map<String, Integer> historyItems = actor.historyVirtualItems;
/*  92 */     if (historyItems == null) {
/*  93 */       actor.historyVirtualItems = historyItems = new HashMap<>();
/*     */     }
/*  95 */     String itemCode = dropItem.itemCode();
/*  96 */     int count = historyItems.containsKey(itemCode) ? ((Integer)historyItems.get(dropItem.itemCode())).intValue() : 0;
/*  97 */     count += dropItem.getWorth();
/*  98 */     historyItems.put(itemCode, Integer.valueOf(count));
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerEntered(WNPlayer player) {
/* 103 */     super.onPlayerEntered(player);
/*     */     
/* 105 */     this.createTime = System.currentTimeMillis();
/*     */ 
/*     */     
/* 108 */     FightLevelsPO fightLevelsPO = player.fightLevelManager.getFightLevelsPo();
/* 109 */     FightLevelsPO.ResourceDungeonPO resourceDungeon = (FightLevelsPO.ResourceDungeonPO)fightLevelsPO.resourceDungeon.get(Integer.valueOf(this.areaId));
/* 110 */     if (resourceDungeon.entering) {
/* 111 */       resourceDungeon.entering = false;
/* 112 */       resourceDungeon.usedTimes++;
/* 113 */       Out.info(new Object[] { player.getId(), " 成功进入资源副本:", player.getArea().getSceneName(), " 本日进入次数为:", Integer.valueOf(resourceDungeon.usedTimes) });
/*     */     } 
/*     */     
/* 116 */     DungeonMapCostCO resourceConfig = (DungeonMapCostCO)GameData.DungeonMapCosts.get(Integer.valueOf(this.prop.mapID));
/* 117 */     if (resourceConfig.playType == 1) {
/* 118 */       player.dailyActivityMgr.onEvent(Const.DailyType.RESOURCE_CHALLENGE, "0", 1);
/* 119 */     } else if (resourceConfig.playType == 2) {
/* 120 */       player.dailyActivityMgr.onEvent(Const.DailyType.RESOURCE_WATCH_PET, "0", 1);
/* 121 */     } else if (resourceConfig.playType == 3) {
/* 122 */       player.dailyActivityMgr.onEvent(Const.DailyType.RESOURCE_FARM, "0", 1);
/*     */     } 
/*     */ 
/*     */     
/* 126 */     if (resourceConfig.playType == 1) {
/* 127 */       player.activityManager.triggerLimitTimeGift(1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushRelive(WNPlayer player) {
/* 134 */     DungeonMapCostCO resourceConfig = (DungeonMapCostCO)GameData.DungeonMapCosts.get(Integer.valueOf(this.prop.mapID));
/* 135 */     if (resourceConfig.playType == 2) {
/* 136 */       super.pushRelive(player);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGameOver(JSONObject event) {
/* 143 */     int winForce = event.getIntValue("winForce");
/*     */     
/* 145 */     DungeonMapCostCO resourceConfig = (DungeonMapCostCO)GameData.DungeonMapCosts.get(Integer.valueOf(this.prop.mapID));
/* 146 */     if (resourceConfig.playType == 1) {
/*     */       
/* 148 */       JobFactory.addDelayJob(() -> onPlayerWin((winForce == 1), resourceConfig), 3000L);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 153 */       JobFactory.addDelayJob(() -> onPlayerWin((winForce == 2), resourceConfig), 3000L);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void onPlayerWin(boolean isWin, DungeonMapCostCO resourceConfig) {
/* 161 */     Out.debug(new Object[] { getClass().getName(), " onGameOver : " });
/*     */     
/* 163 */     for (String rid : this.actors.keySet()) {
/* 164 */       Area.Actor actor = this.actors.get(rid);
/* 165 */       WNPlayer player = getPlayer(rid);
/* 166 */       if (player != null && actor != null) {
/*     */         
/* 168 */         if (resourceConfig != null) {
/*     */           
/* 170 */           if (resourceConfig.isDoubleBonus == 1) {
/* 171 */             FightLevelsPO fightLevelsPO = player.fightLevelManager.getFightLevelsPo();
/* 172 */             fightLevelsPO.doubleReward = new FightLevelsPO.RDDoubleRewardPO();
/*     */             
/* 174 */             fightLevelsPO.doubleReward.doubleVirtualItems = actor.historyVirtualItems;
/* 175 */             fightLevelsPO.doubleReward.doubleItems = new ArrayList();
/* 176 */             if (actor.historyItems != null) {
/* 177 */               synchronized (actor.historyItems) {
/* 178 */                 for (NormalItem item : actor.historyItems) {
/* 179 */                   fightLevelsPO.doubleReward.doubleItems.add(item.itemDb);
/*     */                 }
/*     */               } 
/*     */             }
/*     */           } 
/* 184 */           BattleHandler.ResourceDungeonResultPush.Builder resourcePush = BattleHandler.ResourceDungeonResultPush.newBuilder();
/* 185 */           resourcePush.setDungeonId(this.prop.mapID);
/* 186 */           resourcePush.setKillMonster(this.killedMonster);
/* 187 */           resourcePush.setDoubleCost((resourceConfig.isDoubleBonus == 1) ? resourceConfig.bounsCostDiamond : -1);
/*     */           
/* 189 */           resourcePush.setExp(0);
/* 190 */           resourcePush.setGold(0);
/* 191 */           if (actor.historyVirtualItems != null && actor.historyVirtualItems.size() > 0) {
/* 192 */             for (String code : actor.historyVirtualItems.keySet()) {
/* 193 */               int value = ((Integer)actor.historyVirtualItems.get(code)).intValue();
/* 194 */               switch (code) {
/*     */                 case "exp":
/* 196 */                   resourcePush.setExp(value);
/*     */                 
/*     */                 case "gold":
/* 199 */                   resourcePush.setGold(value);
/*     */               } 
/*     */ 
/*     */             
/*     */             } 
/*     */           }
/* 205 */           Map<String, Integer> finalItems = new HashMap<>();
/* 206 */           if (actor.historyItems != null && actor.historyItems.size() > 0) {
/* 207 */             synchronized (actor.historyItems) {
/* 208 */               for (NormalItem item : actor.historyItems) {
/* 209 */                 if (finalItems.get(item.itemDb.code) == null) {
/* 210 */                   finalItems.put(item.itemDb.code, Integer.valueOf(item.itemDb.groupCount)); continue;
/*     */                 } 
/* 212 */                 finalItems.put(item.itemDb.code, Integer.valueOf(((Integer)finalItems.get(item.itemDb.code)).intValue() + item.itemDb.groupCount));
/*     */               } 
/*     */             } 
/*     */           }
/*     */           
/* 217 */           List<BattleHandler.ItemNormal> list_rewards = new ArrayList<>();
/* 218 */           for (String code : finalItems.keySet()) {
/* 219 */             BattleHandler.ItemNormal.Builder itemNormal = BattleHandler.ItemNormal.newBuilder();
/* 220 */             itemNormal.setItemCode(code);
/* 221 */             itemNormal.setItemNum(((Integer)finalItems.get(code)).intValue());
/* 222 */             list_rewards.add(itemNormal.build());
/*     */           } 
/*     */           
/* 225 */           resourcePush.addAllItemLine1(list_rewards);
/* 226 */           resourcePush.setSucc(isWin ? 1 : 0);
/* 227 */           player.receive("area.battlePush.resourceDungeonResultPush", (GeneratedMessage)resourcePush.build());
/*     */         } 
/*     */ 
/*     */         
/* 231 */         BILogService.getInstance().ansycReportResourceDungeon(player.getPlayer(), isWin ? 1 : 0, resourceConfig.mapID);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerDeadByMonster(WNPlayer player, AreaEvent.MonsterData monsterData, float playerX, float playerY) {
/* 241 */     super.onPlayerDeadByMonster(player, monsterData, playerX, playerY);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\area\ResourceDungeon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */