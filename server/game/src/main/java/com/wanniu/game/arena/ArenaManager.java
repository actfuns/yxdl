/*     */ package com.wanniu.game.arena;
/*     */ 
/*     */ import Xmds.GetPlayerData;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.RandomUtil;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaData;
/*     */ import com.wanniu.game.area.AreaManager;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.data.ext.JJCRewardExt;
/*     */ import com.wanniu.game.five2Five.Five2FiveService;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.item.data.ItemToBtlServerData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.ArenaDataPO;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import com.wanniu.game.team.TeamService;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.area.ArenaHandler;
/*     */ import pomelo.area.PlayerHandler;
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
/*     */ public class ArenaManager
/*     */ {
/*     */   private WNPlayer player;
/*     */   private ArenaDataPO arenaData;
/*     */   private MapBase mapProp;
/*     */   
/*     */   public ArenaManager(WNPlayer player) {
/*  54 */     this.player = player;
/*  55 */     init(this.player.getId());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void init(String playerId) {
/*  64 */     ArenaDataPO arenaDataDb = getFromRedis(playerId);
/*  65 */     if (arenaDataDb == null) {
/*  66 */       arenaDataDb = new ArenaDataPO();
/*  67 */       PlayerPOManager.put(ConstsTR.player_arena_dataTR, playerId, (GEntity)arenaDataDb);
/*     */     } 
/*  69 */     this.arenaData = arenaDataDb;
/*  70 */     this.mapProp = ArenaService.getInstance().getArenaMap();
/*     */   }
/*     */   
/*     */   public ArenaHandler.ArenaInfoResponse.Builder getArenaInfo() {
/*  74 */     ArenaHandler.ArenaInfoResponse.Builder res = ArenaHandler.ArenaInfoResponse.newBuilder();
/*  75 */     initSeasonAward();
/*     */     
/*  77 */     res.setS2CSingleRank(getSingleRankIndex());
/*  78 */     res.setS2CSingleReward(getSingleReward());
/*  79 */     res.setS2CTotalReward(this.arenaData.totalReward);
/*  80 */     res.setS2CTotalRank(getLastTotalRank());
/*  81 */     res.setS2CCurrentTotalRank(getCurrentTotalRank());
/*  82 */     res.setS2CCurrentTotalScore(this.arenaData.scoreMonth);
/*  83 */     res.setS2CSeasonEndTime(ArenaService.getInstance().getSeasonEndTime().getTime());
/*     */     
/*  85 */     this.player.updateSuperScriptList(getSuperScript());
/*  86 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String canEnter() {
/*  95 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.JJC.getValue())) {
/*  96 */       return LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN");
/*     */     }
/*     */     
/*  99 */     if (Five2FiveService.getInstance().applyMatchTime(this.player.getId()) != null) {
/* 100 */       return LangService.getValue("JJC_IN_PVP_NOT_JOIN");
/*     */     }
/*     */     
/* 103 */     if (this.player.soloManager.isBusy() || this.player.soloManager.isInMatching()) {
/* 104 */       return LangService.getValue("JJC_IN_PVP_NOT_JOIN");
/*     */     }
/* 106 */     if (this.arenaData.usedDefTimes >= GlobalConfig.JJC_EnterCount) {
/* 107 */       return LangService.getValue("DUNGEON_JJC_NUM_NOT_ENOUGH");
/*     */     }
/* 109 */     if (this.mapProp.reqUpLevel > 0 && (this.player.getPlayer()).upLevel < this.mapProp.reqUpLevel)
/* 110 */       return LangService.getValue("PLAER_UPLEVEL_NOT_ENOUGH"); 
/* 111 */     if (this.mapProp.reqLevel > 0 && this.player.getLevel() < this.mapProp.reqLevel) {
/* 112 */       return LangService.getValue("PLAYER_LEVEL_NOT_ENOUGH") + this.mapProp.reqUpLevel;
/*     */     }
/* 114 */     if (ArenaService.getInstance().isInOpenTime())
/*     */     {
/* 116 */       return null;
/*     */     }
/* 118 */     return LangService.getValue("DUNGEON_JJC_NOT_OPEN");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refreshNewDay() {
/* 127 */     if (this.player.functionOpenManager.isOpen(Const.FunctionType.JJC.getValue())) {
/* 128 */       resetDaily();
/* 129 */       this.arenaData.usedDefTimes = 0;
/* 130 */       this.player.updateSuperScriptList(getSuperScript());
/* 131 */       Out.debug(new Object[] { "ArenaManager.refreshNewDay() on ---------------" });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void resetDaily() {
/* 137 */     this.arenaData.score = 0;
/*     */     
/* 139 */     this.arenaData.combo = 0;
/* 140 */     this.arenaData.comboDaily = 0;
/* 141 */     this.arenaData.killDaily = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private void enterArenaArea() {
/* 146 */     if (getActivityTime() != ArenaService.getInstance().getBeginTime()) {
/* 147 */       setActivityTime(ArenaService.getInstance().getBeginTime());
/*     */     }
/* 149 */     String instanceId = getArenaInstanceId();
/* 150 */     if (StringUtil.isNotEmpty(instanceId)) {
/* 151 */       Area area = AreaManager.getInstance().getArea(instanceId);
/* 152 */       if (area != null && !area.isClose()) {
/* 153 */         AreaUtil.dispatchByInstanceId(this.player, new AreaData(area.areaId, instanceId));
/*     */         return;
/*     */       } 
/*     */     } 
/* 157 */     AreaUtil.dispatchByAreaId(this.player, this.mapProp.mapID, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSingleRankIndex() {
/* 164 */     return (int)RankType.ARENA_SCORE.getHandler().getRank(GWorld.__SERVER_ID, this.player.getId());
/*     */   }
/*     */   
/*     */   public int getScore() {
/* 168 */     return this.arenaData.score;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getKillMonth() {
/* 175 */     return this.arenaData.killMonth;
/*     */   }
/*     */   
/*     */   public int getCombo() {
/* 179 */     return this.arenaData.combo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSingleReward() {
/* 188 */     if (!ArenaService.getInstance().canDrawDayAward()) {
/* 189 */       return 0;
/*     */     }
/* 191 */     return this.arenaData.singleReward;
/*     */   }
/*     */   
/*     */   private long getActivityTime() {
/* 195 */     return this.arenaData.activityTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setActivityTime(long timeMillis) {
/* 204 */     this.arenaData.activityTime = timeMillis;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastTotalRank() {
/* 211 */     return ArenaService.getInstance().getLastAllScoreRank(this.player.getId());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCurrentTotalRank() {
/* 218 */     return ArenaService.getInstance().getCurrentAllScoreRank(this.player.getId());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCurrentTotalScore() {
/* 225 */     return this.arenaData.scoreMonth;
/*     */   }
/*     */   
/*     */   private void reCalcScore(int areaPlayerCount, int changeAddRate) {
/* 229 */     float addRate = (20 - areaPlayerCount) * 0.1F + 1.0F;
/* 230 */     addRate = (addRate > 2.8F) ? 2.8F : addRate;
/* 231 */     int score = (int)((GlobalConfig.JJC_KillScore * changeAddRate) * addRate);
/* 232 */     addScore(score);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDead() {
/* 237 */     this.arenaData.combo = 0;
/* 238 */     this.arenaData.deadMonth++;
/*     */   }
/*     */   
/*     */   public void onHit(int areaPlayerCount, int changeAddRate) {
/* 242 */     this.arenaData.combo++;
/*     */     
/* 244 */     if (this.arenaData.comboDaily < this.arenaData.combo) {
/* 245 */       this.arenaData.comboDaily = this.arenaData.combo;
/*     */     }
/*     */     
/* 248 */     this.arenaData.killDaily++;
/* 249 */     this.arenaData.killMonth++;
/* 250 */     reCalcScore(areaPlayerCount, changeAddRate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addScore(int addNumber) {
/* 259 */     this.arenaData.score += addNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void killPlayer(WNPlayer enemy, Area.Actor deadActor, int areaPlayerCount) {
/* 266 */     if (isInArenaMap(this.player) && isInArenaMap(enemy)) {
/*     */       
/* 268 */       boolean hasTsBuff = deadActor.buffers.remove(String.valueOf(Const.Arena.ARENA_TIANSHEN.value));
/* 269 */       int changeAddRate = hasTsBuff ? 3 : 1;
/* 270 */       onHit(areaPlayerCount, changeAddRate);
/* 271 */       enemy.arenaManager.onDead();
/*     */ 
/*     */       
/* 274 */       this.player.achievementManager.onArenaKill();
/* 275 */       this.player.achievementManager.onArenaScore(getScore());
/* 276 */       Out.debug(new Object[] { "killPlayer: ", Integer.valueOf(this.arenaData.score), " ", Integer.valueOf(this.arenaData.combo) });
/*     */     } 
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
/*     */   public void dropPlayerScore(WNPlayer hitPlayer, float x, float y, int score) {
/* 290 */     if (score == 0) {
/*     */       return;
/*     */     }
/* 293 */     Area arenaArea = this.player.getArea();
/* 294 */     if (arenaArea == null) {
/*     */       return;
/*     */     }
/*     */     
/* 298 */     List<NormalItem> normalItems = new ArrayList<>();
/* 299 */     int minDropCount = 3;
/* 300 */     int maxDropCount = 7;
/* 301 */     if (score < minDropCount) {
/* 302 */       minDropCount = score;
/*     */     }
/* 304 */     if (score < maxDropCount) {
/* 305 */       maxDropCount = score;
/*     */     }
/*     */     
/* 308 */     int randomDropCount = RandomUtil.getInt(minDropCount, maxDropCount);
/* 309 */     float scoreF = score;
/* 310 */     for (; randomDropCount > 0; randomDropCount--) {
/* 311 */       int randomScore = getRandomNum(randomDropCount, score);
/* 312 */       score -= randomScore;
/*     */       
/* 314 */       String itemCode = "";
/* 315 */       if (randomScore / scoreF * 100.0F > 22.0F) {
/* 316 */         itemCode = GlobalConfig.JJC_BigItemCode;
/* 317 */       } else if (randomScore / scoreF * 100.0F > 15.0F && randomScore / scoreF * 100.0F <= 22.0F) {
/* 318 */         itemCode = GlobalConfig.JJC_MiddleItemCode;
/*     */       } else {
/* 320 */         itemCode = GlobalConfig.JJC_SmallItemCode;
/*     */       } 
/* 322 */       List<NormalItem> tempNormalItems = ItemUtil.createItemsByItemCode(itemCode, randomScore);
/* 323 */       normalItems.addAll(tempNormalItems);
/*     */     } 
/*     */     
/* 326 */     Out.debug(new Object[] { getClass(), "Area onPlayerDeadByPlayer items:", Integer.valueOf(normalItems.size()) });
/* 327 */     List<ItemToBtlServerData> itemsPayLoad = new ArrayList<>();
/* 328 */     for (NormalItem dropItem : normalItems) {
/* 329 */       dropItem.itemDb.gotTime = new Date();
/* 330 */       Area.AreaItem areaItem = new Area.AreaItem(dropItem);
/* 331 */       areaItem.dropPlayer = this.player;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 338 */       areaItem.dropX = x;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 343 */       areaItem.dropY = y;
/*     */       
/* 345 */       arenaArea.items.put(dropItem.itemDb.id, areaItem);
/* 346 */       List<String> list_pids = new ArrayList<>();
/* 347 */       if (hitPlayer != null) {
/* 348 */         list_pids.add(hitPlayer.getId());
/*     */       }
/* 350 */       ItemToBtlServerData itemData = dropItem.toJSON4BatterServer(list_pids, Const.TEAM_DISTRIBUTE_TYPE.FREEDOM, true);
/* 351 */       itemData.protectTime = 0;
/* 352 */       itemData.distributeType = 0;
/* 353 */       itemsPayLoad.add(itemData);
/*     */     } 
/*     */     
/* 356 */     String data = Utils.toJSON(new Object[] { "pos", Utils.ofMap(new Object[] { "x", Float.valueOf(x), "y", Float.valueOf(y) }), "items", itemsPayLoad }).toJSONString();
/* 357 */     Out.debug(new Object[] { getClass(), " onPlayerDeadByPlayer:", data });
/* 358 */     this.player.getXmdsManager().onMonsterDiedDrops(arenaArea.instanceId, data);
/*     */     
/* 360 */     addScore(-((int)scoreF));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getRandomNum(int people, int wmoney) {
/* 371 */     if (people == 1) {
/* 372 */       return wmoney;
/*     */     }
/*     */     
/* 375 */     double min = 1.0D;
/* 376 */     double max = (wmoney / people * 2);
/*     */     
/* 378 */     double money = RandomUtil.randomDouble() * max;
/* 379 */     money = (money <= min) ? 1.0D : money;
/* 380 */     return (int)money;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onAreaClose(int rankIndex) {
/* 390 */     if (rankIndex == 1) {
/* 391 */       this.arenaData.singleWinTimes++;
/* 392 */       if (this.arenaData.singleWinTimes == 1) {
/* 393 */         this.arenaData.firstSingleWinTime = System.currentTimeMillis();
/*     */       }
/*     */     } 
/* 396 */     if (!ArenaService.getInstance().canDrawDayAward()) {
/* 397 */       this.arenaData.singleReward = 1;
/*     */       
/* 399 */       ArenaService.getInstance().refreshScoreRank(this.player.getId(), getScore());
/*     */     } 
/* 401 */     this.arenaData.scoreMonth += getScore();
/*     */     
/* 403 */     ArenaService.getInstance().refreshMonthScoreRank(this.player.getId(), this.arenaData.scoreMonth);
/* 404 */     resetDaily();
/* 405 */     this.player.updateSuperScriptList(getSuperScript());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 412 */     ArrayList<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/* 413 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.JJC.getValue())) {
/* 414 */       return list;
/*     */     }
/*     */     
/* 417 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/* 418 */     data.setType(Const.SUPERSCRIPT_TYPE.JJC_ENTER.getValue());
/* 419 */     data.setNumber((canEnter() == null) ? 1 : 0);
/*     */     
/* 421 */     PlayerHandler.SuperScriptType.Builder data1 = PlayerHandler.SuperScriptType.newBuilder();
/* 422 */     data1.setType(Const.SUPERSCRIPT_TYPE.JJC_REWARD.getValue());
/* 423 */     data1.setNumber(0);
/*     */     
/* 425 */     if (getSingleReward() == 1) {
/* 426 */       data1.setNumber(data1.getNumber() + 1);
/* 427 */     } else if (this.arenaData.totalReward == 1 && getLastTotalRank() != 0) {
/* 428 */       data1.setNumber(data1.getNumber() + 1);
/*     */     } 
/*     */     
/* 431 */     list.add(data.build());
/* 432 */     list.add(data1.build());
/*     */     
/* 434 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleEnterArenaArea(ArenaHandler.EnterArenaAreaResponse.Builder result) {
/* 443 */     String msg = canEnter();
/* 444 */     if (msg == null) {
/*     */       try {
/* 446 */         this.player.taskManager.dealTaskEvent(Const.TaskType.JOAN_ARENA, 1);
/* 447 */         this.player.dailyActivityMgr.onEvent(Const.DailyType.ARENA, "0", 1);
/*     */ 
/*     */         
/* 450 */         Map<String, TeamData.TeamMemberData> members = this.player.getTeamManager().getTeamMembers();
/* 451 */         if (members != null) {
/* 452 */           if (this.player.getTeamManager().isTeamLeader()) {
/* 453 */             for (TeamData.TeamMemberData member : members.values()) {
/* 454 */               if (member.isFollow()) {
/* 455 */                 TeamService.followLeader(member.getPlayer(), false);
/*     */               }
/*     */             } 
/*     */           } else {
/* 459 */             TeamService.followLeader(this.player, false);
/*     */           } 
/*     */         }
/* 462 */         enterArenaArea();
/* 463 */         result.setS2CCode(200);
/* 464 */       } catch (Exception e) {
/* 465 */         Out.error(new Object[] { getClass(), "_enterArenaArea rpc error!", e });
/* 466 */         result.setS2CCode(500);
/* 467 */         result.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*     */       } 
/*     */     } else {
/* 470 */       result.setS2CCode(500);
/* 471 */       result.setS2CMsg(msg);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isInArenaMap(WNPlayer player) {
/* 482 */     return isInArenaMap(player.getAreaId());
/*     */   }
/*     */   
/*     */   public boolean isInArenaMap(int areaId) {
/* 486 */     return (areaId == this.mapProp.mapID);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleLeaveArenaArea(ArenaHandler.LeaveArenaAreaResponse.Builder result) {
/* 495 */     if (isInArenaMap(this.player)) {
/* 496 */       Area leaveArea = this.player.getArea();
/* 497 */       float x = 0.0F;
/* 498 */       float y = 0.0F;
/* 499 */       if (leaveArea != null) {
/*     */         try {
/* 501 */           if (leaveArea.hasPlayer(this.player.getId())) {
/* 502 */             GetPlayerData playerData = leaveArea.getPlayerData(this.player.getId());
/* 503 */             if (playerData != null) {
/* 504 */               x = playerData.x;
/* 505 */               y = playerData.y;
/*     */             } 
/*     */             
/* 508 */             int score = this.arenaData.score;
/* 509 */             if (score > 0) {
/* 510 */               dropPlayerScore(this.player, x, y, score);
/*     */             
/*     */             }
/*     */           
/*     */           }
/*     */         
/*     */         }
/* 517 */         catch (Exception e) {
/* 518 */           Out.error(new Object[] { e });
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 523 */       Area area = AreaUtil.dispatchByAreaId(this.player, (this.player.getPlayerTempData()).historyAreaId, (this.player.getPlayerTempData()).historyX, (this.player.getPlayerTempData()).historyY);
/*     */       
/* 525 */       this.player.getXmdsManager().refreshPlayerPKMode(this.player.getId(), this.player.pkRuleManager.pkData.pkModel);
/* 526 */       if (area != null) {
/* 527 */         result.setS2CCode(200);
/*     */       } else {
/* 529 */         result.setS2CCode(500);
/* 530 */         result.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*     */       } 
/*     */     } else {
/*     */       
/* 534 */       result.setS2CCode(500);
/* 535 */       result.setS2CMsg(LangService.getValue("AREA_ID_NULL"));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleGetReward(int requestRewardType, ArenaHandler.ArenaRewardResponse.Builder result) {
/* 544 */     if ((getSingleReward() != 1 && requestRewardType == 1) || (this.arenaData.totalReward != 1 && requestRewardType == 2)) {
/*     */       
/* 546 */       result.setS2CCode(500);
/* 547 */       result.setS2CMsg(LangService.getValue("SOLO_REWARD_HAS_DRAWED"));
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 552 */       int rankIndex = 0;
/* 553 */       if (requestRewardType == 1) {
/* 554 */         rankIndex = getSingleRankIndex();
/* 555 */       } else if (requestRewardType == 2) {
/* 556 */         rankIndex = getLastTotalRank();
/*     */       } 
/* 558 */       Out.debug(new Object[] { "handleGetReward rankIndex: ", Integer.valueOf(rankIndex) });
/* 559 */       if (rankIndex > 0) {
/* 560 */         JJCRewardExt prop = null;
/* 561 */         for (JJCRewardExt rewExt : GameData.JJCRewards.values()) {
/* 562 */           if (requestRewardType == rewExt.type && ((
/* 563 */             rankIndex >= rewExt.startRank && rankIndex <= rewExt.stopRank) || rewExt.stopRank == 0)) {
/* 564 */             prop = rewExt;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */         
/* 570 */         Out.debug(new Object[] { "handleGetReward prop: ", prop });
/* 571 */         if (prop == null) {
/* 572 */           result.setS2CCode(500);
/* 573 */           result.setS2CMsg(LangService.getValue("SOLO_REWARD_NOT_EXIST"));
/*     */         } else {
/* 575 */           List<NormalItem> items = ItemUtil.createItemsByItemCode(prop._rankReward);
/*     */           
/* 577 */           if (!this.player.getWnBag().testAddEntityItems(items, true)) {
/* 578 */             result.setS2CCode(500);
/* 579 */             result.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/*     */             return;
/*     */           } 
/* 582 */           this.player.getWnBag().addEntityItems(items, Const.GOODS_CHANGE_TYPE.arena);
/* 583 */           result.setS2CCode(200);
/* 584 */           if (requestRewardType == 1) {
/* 585 */             this.arenaData.singleReward = 2;
/* 586 */           } else if (requestRewardType == 2) {
/* 587 */             this.arenaData.totalReward = 2;
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         
/* 592 */         result.setS2CCode(500);
/* 593 */         result.setS2CMsg(LangService.getValue("SOLO_REWARD_CANNOT_DRAW"));
/*     */       } 
/*     */     } 
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
/*     */   private static ArenaDataPO getFromRedis(String playerId) {
/* 607 */     return (ArenaDataPO)PlayerPOManager.findPO(ConstsTR.player_arena_dataTR, playerId, ArenaDataPO.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setArenaInstanceId(String instanceId) {
/* 616 */     this.arenaData.arenaInstanceId = instanceId;
/*     */   }
/*     */   
/*     */   public String getArenaInstanceId() {
/* 620 */     return this.arenaData.arenaInstanceId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInArena() {
/* 629 */     String instanceId = getArenaInstanceId();
/* 630 */     if (StringUtil.isNotEmpty(instanceId)) {
/* 631 */       Area area = AreaManager.getInstance().getArea(instanceId);
/* 632 */       if (area != null) {
/* 633 */         return true;
/*     */       }
/*     */     } 
/* 636 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initSeasonAward() {
/* 643 */     if (this.arenaData.season != ArenaService.getInstance().getTerm()) {
/* 644 */       this.arenaData.totalReward = 1;
/* 645 */       this.arenaData.season = ArenaService.getInstance().getTerm();
/*     */       
/* 647 */       this.arenaData.deadMonth = 0;
/* 648 */       this.arenaData.killMonth = 0;
/* 649 */       this.arenaData.scoreMonth = 0;
/* 650 */       this.arenaData.singleWinTimes = 0;
/* 651 */       this.arenaData.firstSingleWinTime = 0L;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\arena\ArenaManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */