/*     */ package com.wanniu.game.area;
/*     */ 
/*     */ import Xmds.GetPlayerData;
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.protocol.PomeloPush;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.game.activity.DemonTowerService;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ScheduleCO;
/*     */ import com.wanniu.game.data.ext.DropListExt;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.BILogService;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.DemonTowerPO;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.Common;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DemonTower
/*     */   extends Area
/*     */ {
/*  55 */   public int level = 1;
/*     */   
/*     */   public WNPlayer curPlayer;
/*     */   
/*     */   public Date startDate;
/*     */ 
/*     */   
/*     */   static class HistoryItem
/*     */   {
/*  64 */     private Map<String, Integer> historyVirtualItems = new HashMap<>();
/*     */     
/*  66 */     private Map<String, Integer> historyItems = new HashMap<>();
/*     */     
/*     */     void addItem(NormalItem item) {
/*  69 */       Integer num = this.historyItems.get(item.itemCode());
/*  70 */       if (num != null) {
/*  71 */         num = Integer.valueOf(num.intValue() + item.getNum());
/*     */       } else {
/*  73 */         num = Integer.valueOf(item.getNum());
/*     */       } 
/*  75 */       this.historyItems.put(item.itemCode(), num);
/*     */     }
/*     */     
/*     */     void addVirtualItem(String itemCode, int num) {
/*  79 */       Integer oldNum = this.historyVirtualItems.get(itemCode);
/*  80 */       if (oldNum != null) {
/*  81 */         num += oldNum.intValue();
/*     */       }
/*  83 */       this.historyItems.put(itemCode, Integer.valueOf(num));
/*     */     }
/*     */   }
/*     */   
/*  87 */   Map<String, HistoryItem> historyTotals = new HashMap<>();
/*     */   private Map<String, GetPlayerData> datas;
/*     */   
/*  90 */   public DemonTower(JSONObject opts) { super(opts);
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
/* 150 */     this.datas = new HashMap<>(); if (opts.containsKey("lv")) this.level = opts.getIntValue("lv");  this.startDate = new Date(); }
/*     */   public void bindBattleServer(WNPlayer player) { super.bindBattleServer(player); this.curPlayer = player; }
/*     */   public boolean isUseTC() { return false; }
/* 153 */   public void onMonsterDead(int monsterId, int level, float x, float y, int attackType, String refreshPoint, WNPlayer player, JSONArray teamSharedIdList, JSONArray atkAssistantList) { Out.debug(new Object[] { getClass().getName(), " onMonsterDead : ", Integer.valueOf(monsterId), " - ", Float.valueOf(x), ", ", Float.valueOf(y) }); } private List<NormalItem> randomTC(List<DropListExt> drops, int level) { List<NormalItem> items = null;
/* 154 */     if (!drops.isEmpty()) {
/* 155 */       DropListExt prop = drops.get(0);
/* 156 */       items = ItemUtil.createItemsByItemCode(prop.firstRewardPreview);
/*     */     } else {
/* 158 */       items = new ArrayList<>(0);
/*     */     } 
/* 160 */     return items; }
/*     */   public Area.AreaItem onPickItem(String playerId, String itemId, boolean isGuard) { Out.debug(new Object[] { getClass().getName(), " onPickItem : ", itemId, Boolean.valueOf(isGuard) }); return super.onPickItem(playerId, itemId, isGuard); }
/*     */   protected void addVirtureItem(WNPlayer player, NormalItem dropItem, Const.GOODS_CHANGE_TYPE type) { super.addVirtureItem(player, dropItem, type); Area.Actor actor = this.actors.get(player.getId()); Map<String, Integer> historyItems = actor.historyVirtualItems; if (historyItems == null)
/*     */       actor.historyVirtualItems = historyItems = new HashMap<>();  String itemCode = dropItem.itemCode(); int count = historyItems.containsKey(itemCode) ? ((Integer)historyItems.get(dropItem.itemCode())).intValue() : 0; count += dropItem.getWorth(); historyItems.put(itemCode, Integer.valueOf(count)); }
/*     */   public void onRobotQuit(int second) {} public void onGameOver(JSONObject event) { int winForce = event.getIntValue("winForce"); boolean isWin = (winForce == 2);
/* 165 */     onPlayerWin(isWin); } private void resultPush(WNPlayer player, BattleHandler.FightLevelResultPush.Builder result, List<DropListExt> drops, DemonTowerPO curPlayerPO, long costTime, boolean refreshChord) { ScheduleCO co = (ScheduleCO)GameData.Schedules.get(Integer.valueOf(1));
/* 166 */     if (co != null) {
/* 167 */       result.setIsMax(0);
/* 168 */       List<NormalItem> items = null;
/* 169 */       if (curPlayerPO.maxFloor == this.level) {
/* 170 */         items = randomTC(drops, player.getLevel());
/*     */       } else {
/*     */         
/* 173 */         items = new LinkedList<>();
/*     */       } 
/* 175 */       HistoryItem totalItems = this.historyTotals.get(player.getId());
/* 176 */       if (totalItems == null) {
/* 177 */         totalItems = new HistoryItem();
/* 178 */         this.historyTotals.put(player.getId(), totalItems);
/*     */       } 
/* 180 */       for (NormalItem item : items) {
/* 181 */         if (item.isVirtual()) {
/* 182 */           result.addItemLine1(newItemBuilder(item.itemCode(), item.getNum()));
/* 183 */           totalItems.addVirtualItem(item.itemCode(), item.getNum());
/*     */         } else {
/* 185 */           result.addItemLine2(newItemBuilder(item.itemCode(), item.getNum()));
/* 186 */           totalItems.addItem(item);
/*     */         } 
/* 188 */         player.bag.addCodeItemMail(item.itemCode(), item.getNum(), Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.DemonTower, "Bag_full_common");
/*     */       } 
/* 190 */       Area.Actor actor = getActor(player.getId());
/* 191 */       if (actor != null && actor.historyVirtualItems != null) {
/* 192 */         for (Map.Entry<String, Integer> entry : actor.historyVirtualItems.entrySet()) {
/* 193 */           result.addItemLine1(newItemBuilder(entry.getKey(), ((Integer)entry.getValue()).intValue()));
/* 194 */           totalItems.addVirtualItem(entry.getKey(), ((Integer)entry.getValue()).intValue());
/*     */         } 
/*     */       }
/*     */     } 
/* 198 */     Common.DemonTowerFloorInfo.Builder floorInfoBuilder = player.demonTowerManager.getFloorInfoBuilder(this.level);
/* 199 */     result.setDemonTowerFloorInfo(floorInfoBuilder);
/* 200 */     result.setCurrentTime((int)costTime / 1000);
/* 201 */     result.setNewRecordFloor((curPlayerPO.maxFloor == this.level));
/* 202 */     result.setNewRecordTime(refreshChord);
/*     */ 
/*     */     
/* 205 */     int maxFloor = curPlayerPO.maxFloor;
/*     */     
/* 207 */     if (this.level < maxFloor) {
/* 208 */       maxFloor--;
/*     */     }
/* 210 */     result.setMyMaxFloorId(maxFloor);
/*     */     
/* 212 */     player.receive("area.battlePush.fightLevelResultPush", (GeneratedMessage)result.build()); }
/*     */ 
/*     */   
/*     */   private BattleHandler.ItemNormal.Builder newItemBuilder(String itemCode, int num) {
/* 216 */     return BattleHandler.ItemNormal.newBuilder().setItemCode(itemCode).setItemNum(num);
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void onPlayerWin(boolean isWin) {
/* 236 */     Out.debug(new Object[] { getClass().getName(), " onGameOver : ", Boolean.valueOf(isWin) });
/* 237 */     int week = Calendar.getInstance().get(7);
/* 238 */     List<DropListExt> drops = GameData.findDropLists(t -> 
/* 239 */         (t.isWeek(week) && t.floorNo == this.level));
/*     */ 
/*     */ 
/*     */     
/* 243 */     BILogService.getInstance().ansycReportDemonTower(this.curPlayer.getPlayer(), isWin ? 1 : 0, this.level);
/*     */     
/* 245 */     DemonTowerPO curPlayerPO = this.curPlayer.demonTowerManager.po;
/* 246 */     if (isWin) {
/*     */       
/* 248 */       boolean jumpToNext = (this.level != GameData.DropLists.size());
/* 249 */       long costTime = (new Date()).getTime() - this.startDate.getTime();
/* 250 */       boolean refreshRecord = DemonTowerService.getInstance().finishFloor(this.level, this.curPlayer.getId(), costTime);
/* 251 */       for (String rid : this.actors.keySet()) {
/* 252 */         WNPlayer player = getPlayer(rid);
/* 253 */         if (player != null) {
/* 254 */           BattleHandler.FightLevelResultPush.Builder result = BattleHandler.FightLevelResultPush.newBuilder();
/* 255 */           result.setTime(6);
/* 256 */           result.setLevel(this.level);
/* 257 */           result.setType(0);
/* 258 */           resultPush(player, result, drops, curPlayerPO, costTime, refreshRecord);
/*     */ 
/*     */ 
/*     */           
/* 262 */           player.achievementManager.onPassDemonTower(this.level, isWin);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 267 */       if (this.level == curPlayerPO.maxFloor) {
/* 268 */         curPlayerPO.maxFloor++;
/* 269 */         curPlayerPO.firstTimeToPeak = new Date();
/* 270 */         curPlayerPO.leastTimeList.add(Long.valueOf(costTime));
/*     */       
/*     */       }
/* 273 */       else if (((Long)curPlayerPO.leastTimeList.get(this.level - 1)).longValue() > costTime) {
/* 274 */         curPlayerPO.leastTimeList.set(this.level - 1, Long.valueOf(costTime));
/*     */       } 
/*     */       
/* 277 */       this.curPlayer.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.DEMON_TOWER_COUNT, new Object[0]);
/* 278 */       if (jumpToNext) {
/* 279 */         JobFactory.addDelayJob(() -> { for (Map.Entry<String, Area.Actor> entry : this.actors.entrySet()) { if (((Area.Actor)entry.getValue()).alive) { this.datas.put(entry.getKey(), getPlayerData(entry.getKey())); continue; }  GetPlayerData data = this.datas.get(entry.getKey()); if (data == null) { data = new GetPlayerData(); this.datas.put(entry.getKey(), data); continue; }  data.hp = 0; data.mp = 0; }  this.level++; if (this.curPlayer.rankManager != null) this.curPlayer.rankManager.onEvent(RankType.DEMON_TOWER, new Object[] { Integer.valueOf(curPlayerPO.maxFloor - 1) });  DropListExt dropListExt = (DropListExt)GameData.DropLists.get(Integer.valueOf(this.level)); if (dropListExt == null) { Out.error(new Object[] { "参数错误" }); return; }  int mapId = dropListExt.mapId; DemonTower area = (DemonTower)AreaUtil.createArea(this.curPlayer, Utils.toJSON(new Object[] { "logicServerId", Integer.valueOf(this.curPlayer.getLogicServerId()), "areaId", Integer.valueOf(mapId), "lv", Integer.valueOf(this.level) })); area.datas = this.datas; area.level = this.level; area.historyTotals = this.historyTotals; Out.debug(new Object[] { Integer.valueOf(this.datas.size()), " demon tower game over===================================Player:", this.curPlayer.getName(), " change area!!! lv:", Integer.valueOf(area.level) }); AreaData areaData = new AreaData(area.areaId, area.instanceId); for (String rid : this.actors.keySet()) { WNPlayer player = getPlayer(rid); if (player != null) AreaUtil.changeArea(player, areaData);  }  }8000L);
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
/*     */         return;
/*     */       } 
/*     */     } else {
/* 343 */       this.curPlayer.demonTowerManager.po.failedMapId = this.areaId;
/*     */     } 
/*     */ 
/*     */     
/* 347 */     for (String rid : this.actors.keySet()) {
/* 348 */       WNPlayer player = getPlayer(rid);
/* 349 */       if (player != null && curPlayerPO.maxFloor == this.level) {
/* 350 */         BattleHandler.FightLevelResultPush.Builder result = BattleHandler.FightLevelResultPush.newBuilder();
/* 351 */         result.setTime(10);
/* 352 */         result.setLevel(this.level);
/* 353 */         result.setType(1);
/*     */         
/* 355 */         ScheduleCO co = (ScheduleCO)GameData.Schedules.get(Integer.valueOf(1));
/* 356 */         if (co != null) {
/* 357 */           result.setIsMax(0);
/* 358 */           HistoryItem totalItems = this.historyTotals.get(rid);
/* 359 */           if (totalItems == null) {
/* 360 */             totalItems = new HistoryItem();
/* 361 */             this.historyTotals.put(player.getId(), totalItems);
/*     */           } 
/*     */           
/* 364 */           if (this.level >= GameData.DropLists.size()) {
/* 365 */             List<NormalItem> items = randomTC(drops, player.getLevel());
/* 366 */             for (NormalItem item : items) {
/* 367 */               if (item.isVirtual()) {
/* 368 */                 totalItems.addVirtualItem(item.itemCode(), item.getNum());
/*     */               } else {
/* 370 */                 totalItems.addItem(item);
/*     */               } 
/* 372 */               player.bag.addCodeItemMail(item.itemCode(), item.getNum(), Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.DemonTower, "Bag_full_common");
/*     */             } 
/*     */           } 
/*     */           
/* 376 */           for (Map.Entry<String, Integer> entry : (Iterable<Map.Entry<String, Integer>>)totalItems.historyVirtualItems.entrySet()) {
/* 377 */             result.addItemLine1(newItemBuilder(entry.getKey(), ((Integer)entry.getValue()).intValue()));
/*     */           }
/* 379 */           for (Map.Entry<String, Integer> entry : (Iterable<Map.Entry<String, Integer>>)totalItems.historyItems.entrySet()) {
/* 380 */             result.addItemLine2(newItemBuilder(entry.getKey(), ((Integer)entry.getValue()).intValue()));
/*     */           }
/*     */         } else {
/* 383 */           result.setIsMax(1);
/*     */           
/* 385 */           Collection<String> teamData = player.getTeamMembers();
/* 386 */           if (teamData != null) {
/* 387 */             for (String teamMemPlayerId : teamData) {
/*     */               
/* 389 */               if (this.actors.containsKey(teamMemPlayerId) && (getActor(teamMemPlayerId)).profitable) {
/* 390 */                 int xianyuan = player.processXianYuanGet(GlobalConfig.Fate_Resource);
/* 391 */                 result.addItemLine1(newItemBuilder("fate", xianyuan));
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           }
/*     */         } 
/* 397 */         Common.DemonTowerFloorInfo.Builder floorInfoBuilder = player.demonTowerManager.getFloorInfoBuilder(this.level);
/* 398 */         result.setDemonTowerFloorInfo(floorInfoBuilder);
/* 399 */         result.setMyMaxFloorId(curPlayerPO.maxFloor - 1);
/* 400 */         Out.error(new Object[] { result.build() });
/* 401 */         player.receive("area.battlePush.fightLevelResultPush", (GeneratedMessage)result.build());
/*     */       } 
/*     */     } 
/*     */     
/* 405 */     super.onRobotQuit(10);
/*     */   }
/*     */   
/*     */   public String toJSON4EnterScene(WNPlayer player) {
/* 409 */     JSONObject json = player.toJSON4EnterScene(this);
/*     */     
/* 411 */     Map<String, Number> tempData = (Map<String, Number>)json.get("tempData");
/* 412 */     tempData.put("x", Integer.valueOf(0));
/* 413 */     tempData.put("y", Integer.valueOf(0));
/* 414 */     GetPlayerData data = this.datas.get(player.getId());
/* 415 */     if (data != null) {
/* 416 */       int maxHp = ((Integer)player.btlDataManager.finalInflus.get(Const.PlayerBtlData.MaxHP)).intValue();
/* 417 */       int hp = data.hp + maxHp * 20 / 100;
/* 418 */       tempData.put("hp", Integer.valueOf(Math.min(hp, maxHp)));
/* 419 */       tempData.put("mp", Integer.valueOf(data.mp));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 426 */     return json.toJSONString();
/*     */   }
/*     */   
/*     */   protected void onDailyActivity(WNPlayer player) {
/* 430 */     super.onDailyActivity(player);
/* 431 */     player.dailyActivityMgr.onEvent(Const.DailyType.DEMON_TOWER, "0", 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushRelive(WNPlayer player) {}
/*     */ 
/*     */   
/*     */   public void onPlayerDeadByMonster(WNPlayer player, AreaEvent.MonsterData monsterData, float playerX, float playerY) {
/* 440 */     Out.debug(new Object[] { getClass().getName(), " onPlayerDeadByMonster : ", player.getName() });
/*     */     
/* 442 */     if (isAllActorDie()) {
/* 443 */       this.isClose = true;
/* 444 */       onPlayerWin(false);
/* 445 */       addCloseFuture();
/*     */     } 
/*     */     
/* 448 */     player.activityManager.triggerLimitTimeGift(2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerDeadByPlayer(WNPlayer deadPlayer, WNPlayer hitPlayer, float x, float y) {
/* 453 */     Out.warn(new Object[] { getClass().getName(), " onPlayerDeadByPlayer : ", deadPlayer.getName() });
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerEntered(WNPlayer player) {
/* 458 */     super.onPlayerEntered(player);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerLeaved(WNPlayer player) {
/* 467 */     if (!this.isClose && isAllActorDie()) {
/* 468 */       this.isClose = true;
/* 469 */       onPlayerWin(false);
/* 470 */       addCloseFuture();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onEndEnterScene(WNPlayer player) {
/* 476 */     super.onEndEnterScene(player);
/* 477 */     player.receive((Message)new PomeloPush()
/*     */         {
/*     */           protected void write() throws IOException {
/* 480 */             BattleHandler.SceneNamePush.Builder push = BattleHandler.SceneNamePush.newBuilder();
/* 481 */             push.setSceneName(LangService.format("DEMON_TOWER_LV", new Object[] { Integer.valueOf(this.this$0.level) }));
/* 482 */             this.body.writeBytes(push.build().toByteArray());
/*     */           }
/*     */ 
/*     */           
/*     */           public String getRoute() {
/* 487 */             return "area.battlePush.sceneNamePush";
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\area\DemonTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */