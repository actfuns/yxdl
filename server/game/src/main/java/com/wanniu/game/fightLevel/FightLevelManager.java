/*     */ package com.wanniu.game.fightLevel;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.proxy.ProxyClient;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaData;
/*     */ import com.wanniu.game.area.AreaDataConfig;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.CircleSceneCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.MonsterRefreshCO;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.data.base.MonsterBase;
/*     */ import com.wanniu.game.data.base.TaskBase;
/*     */ import com.wanniu.game.data.ext.MonsterRefreshExt;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.item.VirtualItem;
/*     */ import com.wanniu.game.monster.MonsterConfig;
/*     */ import com.wanniu.game.player.PathService;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.FightLevelsPO;
/*     */ import com.wanniu.game.request.fightLevel.GetBossDamageRankHandler;
/*     */ import com.wanniu.game.request.fightLevel.GetMonsterLeaderHandler;
/*     */ import com.wanniu.game.task.po.TaskPO;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import com.wanniu.game.team.TeamUtil;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import pomelo.area.FightLevelHandler;
/*     */ import pomelo.item.ItemOuterClass;
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
/*     */ public class FightLevelManager
/*     */ {
/*     */   public WNPlayer player;
/*     */   private FightLevelsPO po;
/*     */   
/*     */   public FightLevelsPO getFightLevelsPo() {
/*  71 */     return this.po;
/*     */   }
/*     */   
/*     */   public FightLevelManager(WNPlayer player, FightLevelsPO po) {
/*  75 */     this.player = player;
/*  76 */     if (po == null) {
/*  77 */       po = new FightLevelsPO();
/*     */     }
/*  79 */     if (po.todays == null) {
/*  80 */       po.todays = new HashMap<>();
/*     */     }
/*  82 */     if (po.finishes == null) {
/*  83 */       po.finishes = new HashMap<>();
/*     */     }
/*  85 */     if (po.resourceDungeon == null) {
/*  86 */       po.resourceDungeon = new HashMap<>();
/*     */     }
/*  88 */     this.po = po;
/*     */     
/*  90 */     PlayerPOManager.put(ConstsTR.player_fightlevelTR, player.getId(), (GEntity)po);
/*     */   }
/*     */   
/*     */   public int getTodayFinish(int templateID) {
/*  94 */     return this.po.todays.containsKey(Integer.valueOf(templateID)) ? ((Integer)this.po.todays.get(Integer.valueOf(templateID))).intValue() : 0;
/*     */   }
/*     */   
/*     */   public int getTodayBuy(int templateID) {
/*  98 */     return ((Integer)this.po.buys.getOrDefault(Integer.valueOf(templateID), Integer.valueOf(0))).intValue();
/*     */   }
/*     */   
/*     */   public int getCurrHard(int templateID) {
/* 102 */     return this.po.finishes.containsKey(Integer.valueOf(templateID)) ? ((Integer)this.po.finishes.get(Integer.valueOf(templateID))).intValue() : 1;
/*     */   }
/*     */   
/*     */   public void useProduce(int templateID) {
/* 106 */     if (!needProduce(templateID)) {
/* 107 */       Out.info(new Object[] { "needProduce false,player id:" + this.player.getId() + " mapId:" + templateID });
/*     */       return;
/*     */     } 
/* 110 */     Map<Integer, Integer> todays = this.po.todays;
/* 111 */     int count = getTodayFinish(templateID);
/* 112 */     synchronized (this.po.todays) {
/* 113 */       todays.put(Integer.valueOf(templateID), Integer.valueOf(count + 1));
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean needProduce(int templateID) {
/* 118 */     return (getTodayFinish(templateID) < 3 + getTodayBuy(templateID));
/*     */   }
/*     */   
/*     */   public void refreshNewDay() {
/* 122 */     synchronized (this.po.todays) {
/* 123 */       this.po.todays.clear();
/* 124 */       this.po.buys.clear();
/*     */ 
/*     */       
/* 127 */       this.po.resourceDungeon.clear();
/* 128 */       for (Map<Integer, Integer> val : (Iterable<Map<Integer, Integer>>)this.po.dropedBossMap.values()) {
/* 129 */         val.clear();
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
/*     */   private boolean isDropedControledArea(Area area) {
/* 141 */     if (area.sceneType == Const.SCENE_TYPE.FIGHT_LEVEL.getValue() || area.sceneType == Const.SCENE_TYPE.LOOP
/* 142 */       .getValue()) {
/* 143 */       return true;
/*     */     }
/*     */     
/* 146 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onDungeonReset(int areaId) {
/* 153 */     Map<Integer, Integer> val = (Map<Integer, Integer>)this.po.dropedBossMap.get(Integer.valueOf(areaId));
/* 154 */     if (val != null) {
/* 155 */       val.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canDrop(int bossId, Area area) {
/* 166 */     if (bossId == 0 || !isDropedControledArea(area)) {
/* 167 */       return true;
/*     */     }
/*     */     
/* 170 */     Map<Integer, Integer> val = (Map<Integer, Integer>)this.po.dropedBossMap.get(Integer.valueOf(area.areaId));
/* 171 */     if (val != null && 
/* 172 */       val.containsKey(Integer.valueOf(bossId))) {
/* 173 */       int times = ((Integer)val.get(Integer.valueOf(bossId))).intValue();
/* 174 */       if (times > 0) {
/* 175 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 180 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBossDead(int bossId, Area area) {
/* 189 */     if (!isDropedControledArea(area)) {
/*     */       return;
/*     */     }
/* 192 */     MonsterBase prop = MonsterConfig.getInstance().get(bossId);
/* 193 */     if (prop == null || prop.type < 3) {
/*     */       return;
/*     */     }
/*     */     
/* 197 */     Map<Integer, Integer> val = (Map<Integer, Integer>)this.po.dropedBossMap.get(Integer.valueOf(area.areaId));
/* 198 */     if (val != null) {
/* 199 */       if (val.containsKey(Integer.valueOf(bossId))) {
/* 200 */         val.put(Integer.valueOf(bossId), Integer.valueOf(((Integer)val.get(Integer.valueOf(bossId))).intValue() + 1));
/*     */       } else {
/* 202 */         val.put(Integer.valueOf(bossId), Integer.valueOf(1));
/*     */       } 
/*     */     } else {
/* 205 */       Map<Integer, Integer> newVal = new ConcurrentHashMap<>();
/* 206 */       newVal.put(Integer.valueOf(bossId), Integer.valueOf(1));
/* 207 */       this.po.dropedBossMap.put(Integer.valueOf(area.areaId), newVal);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<FightLevelHandler.MonsterInfo> getMonsterInfo(Map<Integer, Map<Integer, Integer>> datas, int areaId) {
/* 213 */     List<FightLevelHandler.MonsterInfo> result = new ArrayList<>();
/*     */     
/* 215 */     Map<Integer, Integer> data = datas.get(Integer.valueOf(areaId));
/*     */     
/* 217 */     List<MonsterRefreshExt> props = GameData.findMonsterRefreshs(t -> (t.mapID == areaId));
/*     */ 
/*     */ 
/*     */     
/* 221 */     for (MonsterRefreshCO prop : props) {
/* 222 */       FightLevelHandler.MonsterInfo.Builder m = FightLevelHandler.MonsterInfo.newBuilder();
/* 223 */       m.setMonsterId(prop.monsterID);
/* 224 */       if (data != null && data.get(Integer.valueOf(prop.iD)) != null && ((Integer)data.get(Integer.valueOf(prop.iD))).intValue() != 0) {
/* 225 */         m.setTime(((Integer)data.get(Integer.valueOf(prop.iD))).intValue());
/*     */       } else {
/* 227 */         m.setTime(((Integer)data.get(Integer.valueOf(0))).intValue());
/*     */       } 
/* 229 */       result.add(m.build());
/*     */     } 
/*     */     
/* 232 */     return result;
/*     */   }
/*     */   
/*     */   public int vipAddTimes(WNPlayer player, int type) {
/* 236 */     switch (type) {
/*     */     
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 247 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ItemOuterClass.MiniItem> getDropItems(String itemTC) {
/* 253 */     List<ItemOuterClass.MiniItem> dropItems = new ArrayList<>();
/*     */     
/* 255 */     List<NormalItem> items = ItemUtil.createItemsByTcCode(itemTC);
/* 256 */     for (NormalItem item : items) {
/*     */       
/* 258 */       ItemOuterClass.MiniItem.Builder dropItem = ItemUtil.getMiniItemData(item.prop.code, 1);
/*     */       
/* 260 */       if (dropItem != null) {
/* 261 */         dropItems.add(dropItem.build());
/*     */       }
/*     */     } 
/*     */     
/* 265 */     return dropItems;
/*     */   }
/*     */   
/*     */   public String enterDungeonReq(WNPlayer player, int dungeonId) {
/* 269 */     MapBase prop = AreaDataConfig.getInstance().get(dungeonId);
/* 270 */     String data = isDungeonOpen(prop);
/* 271 */     if (data != null) {
/* 272 */       return data;
/*     */     }
/* 274 */     data = canEnterDungeon(player, prop, true);
/* 275 */     if (data != null) {
/* 276 */       return data;
/*     */     }
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
/* 292 */     if ((prop.allowedPlayersMix > 1 || player.getTeamManager().isInTeam()) && !PlayerUtil.isRobot(player.player)) {
/* 293 */       int teamCount = 0;
/* 294 */       TeamData.TeamMemberData teamMember = player.getTeamManager().getTeamMember();
/* 295 */       TeamData team = player.getTeamManager().getTeam();
/* 296 */       if (teamMember != null && team != null) {
/* 297 */         teamCount = team.memberCount();
/* 298 */         if (!teamMember.isLeader) {
/* 299 */           return LangService.getValue((prop.allowedPlayersMax == 1) ? "DUNGEON_SINGLE_MORE" : "TEAM_NO_AUTHORITY");
/*     */         }
/*     */       } 
/* 302 */       if (teamCount < prop.allowedPlayersMix || teamCount > prop.allowedPlayersMax) {
/* 303 */         return LangService.getValue((teamCount < prop.allowedPlayersMix) ? "TEAM_MEMBER_COUNT" : ((prop.allowedPlayersMax == 1) ? "DUNGEON_SINGLE_MORE" : "DUNGEON_TEAM_PLAYER_MORE"));
/*     */       }
/* 305 */       if (teamCount > 1) {
/* 306 */         if (team.confirm) {
/* 307 */           return DungeonService.getInstance().enterDungeonInTeam(team, prop, dungeonId);
/*     */         }
/* 309 */         if (dungeonId == 53001) {
/* 310 */           AreaUtil.dispatchByAreaId(player, dungeonId, null);
/*     */         } else {
/* 312 */           enterDungeonMutiPlayers(team, dungeonId);
/*     */         } 
/*     */         
/* 315 */         return null;
/*     */       } 
/*     */     } 
/* 318 */     if (dungeonId == 53001) {
/* 319 */       AreaUtil.dispatchByAreaId(player, dungeonId, null);
/*     */     } else {
/* 321 */       enterDungeon(player, dungeonId);
/*     */     } 
/* 323 */     return null;
/*     */   }
/*     */   
/*     */   public String canEnterDungeon(WNPlayer player, MapBase prop, boolean bAlone) {
/* 327 */     Area area = player.getArea();
/*     */     
/* 329 */     if (area != null && !area.isNormal()) {
/* 330 */       return bAlone ? LangService.getValue("DUNGEON_ALREAD_IN_DUNGEON") : LangService.format("TEAM_MEMBER_BATTLE", new Object[] { player.getName() });
/*     */     }
/*     */     
/* 333 */     return AreaUtil.canEnterArea(prop, player);
/*     */   }
/*     */   
/*     */   public String replyEnterDungeon(final WNPlayer player, final int type, int dungeonId) {
/* 337 */     if (player.isRomote()) {
/* 338 */       ProxyClient.getInstance().add(new Message()
/*     */           {
/*     */             protected void write() throws IOException {
/* 341 */               this.body.writeByte(3);
/* 342 */               this.body.writeString(player.getId());
/* 343 */               this.body.writeByte(type);
/*     */             }
/*     */ 
/*     */             
/*     */             public short getType() {
/* 348 */               return 1265;
/*     */             }
/*     */           });
/* 351 */       return null;
/*     */     } 
/* 353 */     if (type != Const.HandsUpState.ACCEPT.value && type != Const.HandsUpState.REFUSE.value) {
/* 354 */       return LangService.getValue("DATA_ERR");
/*     */     }
/*     */     
/* 357 */     TeamData.TeamMemberData teamMember = player.getTeamManager().getTeamMember();
/* 358 */     if (teamMember == null) {
/* 359 */       return LangService.getValue("EXPIRED_MSG");
/*     */     }
/*     */     
/* 362 */     TeamData team = player.getTeamManager().getTeam();
/* 363 */     if (team == null || !team.teamMembers.containsKey(player.getId()) || !team.islock()) {
/* 364 */       return LangService.getValue("EXPIRED_MSG");
/*     */     }
/* 366 */     if (type == Const.HandsUpState.REFUSE.value && teamMember.isLeader) {
/* 367 */       FightLevelHandler.CloseHandUpPush push = FightLevelHandler.CloseHandUpPush.newBuilder().setMsg(LangService.getValue("TEAM_GOTO_CANCEL")).build();
/* 368 */       for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 369 */         member.handup = Const.HandsUpState.WAITING.value;
/* 370 */         if (!member.id.equals(player.getId())) {
/* 371 */           MessageUtil.sendMessage(member.id, "area.fightLevelPush.closeHandUpPush", (GeneratedMessage)push);
/*     */         }
/*     */       } 
/* 374 */       team.unlock();
/* 375 */       return null;
/*     */     } 
/*     */     
/* 378 */     String data = isDungeonOpen(dungeonId);
/* 379 */     if (data != null) {
/* 380 */       return data;
/*     */     }
/* 382 */     Area area = player.getArea();
/* 383 */     if (area != null && AreaUtil.needCreateArea(area.areaId)) {
/* 384 */       return LangService.getValue("PLAYER_CANT_DO");
/*     */     }
/*     */     
/* 387 */     teamMember.handup = type;
/*     */     
/* 389 */     boolean allAccept = true, allReply = true;
/* 390 */     FightLevelHandler.OnMemberEnterFubenStateChangePush msgData = FightLevelHandler.OnMemberEnterFubenStateChangePush.newBuilder().setS2CPlayerId(player.getId()).setS2CIsReady((type == Const.HandsUpState.ACCEPT.value) ? 1 : 0).build();
/* 391 */     for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 392 */       allAccept = (allAccept && member.handup == Const.HandsUpState.ACCEPT.value);
/* 393 */       allReply = (allReply && member.handup != Const.HandsUpState.WAITING.value);
/* 394 */       MessageUtil.sendMessage(member.id, "area.fightLevelPush.onMemberEnterFubenStateChangePush", (GeneratedMessage)msgData);
/*     */     } 
/*     */     
/* 397 */     if (allReply) {
/* 398 */       team.unlock();
/*     */     }
/*     */     
/* 401 */     if (allAccept) {
/* 402 */       if (dungeonId == 53001) {
/* 403 */         AreaUtil.dispatch(player, team.teamMembers.keySet(), team.logicServerId, dungeonId, null);
/*     */       } else {
/* 405 */         enterDungeonMutiPlayers(team, dungeonId);
/*     */       } 
/*     */     }
/* 408 */     return null;
/*     */   }
/*     */   
/*     */   public void enterDungeon(WNPlayer player, int mapId) {
/* 412 */     AreaUtil.createAreaAndDispatch(player, Arrays.asList(new String[] { player.getId() }, ), player.getLogicServerId(), mapId, null);
/*     */   }
/*     */   
/*     */   public void enterDungeonMutiPlayers(TeamData team, int mapId) {
/* 416 */     AreaUtil.createAreaAndDispatch(this.player, team.teamMembers.keySet(), team.logicServerId, mapId, null);
/*     */   }
/*     */   
/*     */   public String isDungeonOpen(int mpaId) {
/* 420 */     return isDungeonOpen(AreaUtil.getAreaProp(mpaId));
/*     */   }
/*     */   
/*     */   public String isDungeonOpen(MapBase prop) {
/* 424 */     if (prop == null) {
/* 425 */       return LangService.getValue("DUNGEON_NULL");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 431 */     long currTime = GWorld.APP_TIME;
/* 432 */     Date beginTime = null;
/* 433 */     if (StringUtil.isNotEmpty(prop.beginTime)) {
/* 434 */       beginTime = AreaUtil.formatToday(prop.beginTime);
/*     */     }
/* 436 */     Date endTime = null;
/* 437 */     if (StringUtil.isNotEmpty(prop.endTime)) {
/* 438 */       endTime = AreaUtil.formatToday(prop.endTime);
/*     */     }
/* 440 */     if ((beginTime != null && currTime < beginTime.getTime()) || (endTime != null && currTime > endTime.getTime())) {
/* 441 */       return LangService.getValue("DUNGEON_TEAM_NOT_OPEN");
/*     */     }
/*     */     
/* 444 */     if (prop.openRule == Const.OpenRuleType.EVERY_WEEK.getValue()) {
/* 445 */       Calendar calendar_curr = Calendar.getInstance();
/* 446 */       int pos = prop.OpenDate.indexOf(Integer.valueOf(calendar_curr.get(7)));
/* 447 */       if (-1 == pos) {
/* 448 */         return LangService.getValue("DUNGEON_TEAM_NOT_OPEN");
/*     */       }
/*     */     } 
/* 451 */     return null;
/*     */   }
/*     */   
/*     */   public String leaveDungeon(WNPlayer player, Area area) {
/* 455 */     TeamUtil.removeAcrossMatch(player);
/* 456 */     int targetAreaId = player.playerTempData.historyAreaId;
/* 457 */     if (area.prop.leaveToMapID != 0) {
/* 458 */       targetAreaId = area.prop.leaveToMapID;
/*     */     }
/* 460 */     AreaData areaData = new AreaData(targetAreaId);
/* 461 */     if (targetAreaId == player.playerTempData.historyAreaId) {
/* 462 */       areaData.targetX = player.playerTempData.historyX;
/* 463 */       areaData.targetY = player.playerTempData.historyY;
/*     */     } 
/* 465 */     float[] xy = PathService.findToAreaXYByAreaId(area.areaId, targetAreaId);
/* 466 */     if (xy != null) {
/* 467 */       areaData.targetX = xy[0];
/* 468 */       areaData.targetY = xy[1];
/*     */     } 
/* 470 */     Out.debug(new Object[] { player.getName(), " ==leaveDungeon== ", area.getSceneName(), " to ", areaData });
/*     */     
/* 472 */     TeamData team = player.getTeamManager().getTeam();
/* 473 */     TeamData.TeamMemberData member = player.getTeamManager().getTeamMember();
/* 474 */     if (member != null) {
/* 475 */       member.follow = true;
/*     */     }
/* 477 */     if (team != null && team.loopTasks != null) {
/* 478 */       boolean quit = false;
/* 479 */       for (TaskPO taskData : team.loopTasks.values()) {
/* 480 */         if (taskData == null)
/*     */           continue; 
/* 482 */         TaskBase taskProp = (TaskBase)GameData.CircleScenes.get(Integer.valueOf(taskData.templateId));
/* 483 */         if (taskProp == null)
/*     */           continue; 
/* 485 */         if (taskProp.circleDungeonID == area.areaId) {
/* 486 */           for (CircleSceneCO posProp : GameData.CircleScenes.values()) {
/* 487 */             if (posProp.circleDungeonID == area.areaId) {
/* 488 */               if (player.playerTempData.historyAreaId == posProp.startScene) {
/* 489 */                 areaData.targetX = posProp.loopOutPos[0];
/* 490 */                 areaData.targetY = posProp.loopOutPos[1];
/*     */               } 
/* 492 */               quit = true;
/*     */               break;
/*     */             } 
/*     */           } 
/* 496 */           if (quit) {
/*     */             
/* 498 */             team.confirm = true;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 504 */     MapBase prop = AreaDataConfig.getInstance().get(targetAreaId);
/* 505 */     area = (prop.type == Const.SCENE_TYPE.CROSS_SERVER.getValue()) ? AreaUtil.dispatchByCrossServerId(player, areaData) : AreaUtil.dispatchByAreaId(player, areaData, null);
/*     */     
/* 507 */     return (area != null) ? null : LangService.getValue("SOMETHING_ERR");
/*     */   }
/*     */   
/*     */   public Object enterWaitDungeon(WNPlayer player, int dungeonId) {
/* 511 */     MapBase prop = AreaUtil.getAreaProp(dungeonId);
/*     */     
/* 513 */     String data = isDungeonOpen(prop);
/* 514 */     if (data != null) {
/* 515 */       return data;
/*     */     }
/*     */     
/* 518 */     data = canEnterDungeon(player, prop, true);
/*     */     
/* 520 */     if (data != null) {
/* 521 */       return data;
/*     */     }
/*     */     
/* 524 */     if (prop == null || prop.dungeonTab != 2) {
/* 525 */       return LangService.getValue("PARAM_ERROR");
/*     */     }
/*     */     
/* 528 */     TeamData.TeamMemberData teamMember = player.getTeamManager().getTeamMember();
/*     */     
/* 530 */     if (teamMember != null) {
/* 531 */       return LangService.getValue("MATCH_IN_TEAM");
/*     */     }
/*     */     
/* 534 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addStackItem(String code, int worth, List<NormalItem> awardDropItems) {
/* 539 */     for (NormalItem awardDropItem : awardDropItems) {
/*     */       
/* 541 */       if (awardDropItem.itemDb.code.equals(code)) {
/*     */         
/* 543 */         ((VirtualItem)awardDropItem).addWorth(worth);
/*     */         
/* 545 */         return true;
/*     */       } 
/*     */     } 
/* 548 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int addStackItemByCount(String code, int groupCount, int groupCountMax, List<NormalItem> awardDropItems) {
/* 553 */     for (NormalItem awardDropItem : awardDropItems) {
/*     */       
/* 555 */       if (awardDropItem.itemDb.code.equals(code)) {
/*     */ 
/*     */         
/* 558 */         awardDropItem.addGroupNum(groupCount);
/*     */         
/* 560 */         int leftCount = awardDropItem.itemDb.groupCount - groupCountMax;
/*     */         
/* 562 */         if (leftCount > 0) {
/*     */ 
/*     */           
/* 565 */           awardDropItem.setNum(groupCountMax);
/*     */           
/* 567 */           return leftCount;
/*     */         } 
/*     */         
/* 570 */         return 0;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 575 */     return groupCount;
/*     */   }
/*     */   
/*     */   public GetMonsterLeaderHandler.GetMonsterLeaderData getMonsterLeader(WNPlayer player, int monsterId, int areaId) {
/* 579 */     List<ItemOuterClass.MiniItem> dropItems = new ArrayList<>();
/* 580 */     GetMonsterLeaderHandler.GetMonsterLeaderData data = new GetMonsterLeaderHandler.GetMonsterLeaderData(dropItems, 0, 0, "");
/*     */     
/* 582 */     MonsterBase monsterProp = MonsterConfig.getInstance().get(monsterId);
/*     */     
/* 584 */     if (monsterProp != null)
/*     */     {
/* 586 */       data.dropItems = getDropItems(monsterProp.showTc);
/*     */     }
/*     */     
/* 589 */     MapBase areaProp = AreaDataConfig.getInstance().get(areaId);
/*     */     
/* 591 */     if (areaProp != null) {
/*     */       
/* 593 */       data.reqLevel = areaProp.reqLevel;
/* 594 */       data.reqUpLevel = areaProp.reqUpLevel;
/*     */     } 
/* 596 */     MonsterRefreshCO refreshProp = null;
/* 597 */     List<MonsterRefreshExt> refreshProps = GameData.findMonsterRefreshs(t -> 
/* 598 */         (t.monsterID == monsterId && t.mapID == areaId));
/*     */     
/* 600 */     if (refreshProps.size() > 0) {
/* 601 */       refreshProp = (MonsterRefreshCO)refreshProps.get(0);
/* 602 */       data.refreshPoint = refreshProp.refreshPoint;
/*     */     } 
/*     */     
/* 605 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GetBossDamageRankHandler.GetBossDamageRankResult getBossDamageRank(WNPlayer player, Area area) {
/* 615 */     GetBossDamageRankHandler.GetBossDamageRankResult data = new GetBossDamageRankHandler.GetBossDamageRankResult(new ArrayList(), 0, 0);
/*     */     
/* 617 */     return data;
/*     */   }
/*     */   
/*     */   public void addPrifit(int mapId) {
/* 621 */     Out.info(new Object[] { "增加副本收益次数 mapId=", Integer.valueOf(mapId) });
/* 622 */     this.po.buys.put(Integer.valueOf(mapId), Integer.valueOf(((Integer)this.po.buys.getOrDefault(Integer.valueOf(mapId), Integer.valueOf(0))).intValue() + 1));
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\fightLevel\FightLevelManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */