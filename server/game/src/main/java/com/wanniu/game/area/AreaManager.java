/*     */ package com.wanniu.game.area;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.arena.ArenaArea;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.cross.CrossServerArea;
/*     */ import com.wanniu.game.cross.CrossServerLocalArea;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.fightLevel.FightLevel;
/*     */ import com.wanniu.game.five2Five.Five2FiveArea;
/*     */ import com.wanniu.game.guild.guildBoss.GuildBossArea;
/*     */ import com.wanniu.game.guild.guildDungeon.GuildDungeon;
/*     */ import com.wanniu.game.guild.guildFort.GuildFortPveArea;
/*     */ import com.wanniu.game.guild.guildFort.GuildFortPvpArea;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import com.wanniu.game.solo.SoloArea;
/*     */ import com.wanniu.game.task.TaskEvent;
/*     */ import com.wanniu.game.task.TaskUtils;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.ConcurrentHashMap;
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
/*     */ public class AreaManager
/*     */ {
/*     */   private static AreaManager instance;
/*  55 */   public static final Map<String, Area> CrossServerAreas = new ConcurrentHashMap<>();
/*  56 */   public static final Map<String, ProxyArea> ProxyServerAreas = new ConcurrentHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AreaManager getInstance() {
/*  63 */     if (instance == null) {
/*  64 */       instance = new AreaManager();
/*     */     }
/*  66 */     return instance;
/*     */   }
/*     */   
/*  69 */   private AreaMap allAreas = new AreaMap();
/*     */   
/*     */   public AreaMap getAreaMap() {
/*  72 */     return this.allAreas;
/*     */   }
/*     */   
/*     */   public final void init() {
/*  76 */     int interval = 600000;
/*     */     
/*  78 */     JobFactory.addScheduleJob(() -> refreshAreas(), interval, interval);
/*     */ 
/*     */ 
/*     */     
/*  82 */     JobFactory.addScheduleJob(() -> refreshAreaItems(), 2000L, 2000L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCloseGame() {
/*  88 */     for (Area area : CrossServerAreas.values()) {
/*     */       try {
/*  90 */         area.dispose(true);
/*  91 */       } catch (Exception e) {
/*  92 */         Out.error(new Object[] { e });
/*     */       } 
/*     */     } 
/*  95 */     for (Area area : this.allAreas.values()) {
/*     */       try {
/*  97 */         area.dispose(true);
/*  98 */       } catch (Exception e) {
/*  99 */         Out.error(new Object[] { e });
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
/*     */ 
/*     */ 
/*     */   
/*     */   public final void refreshAreas() {
/* 116 */     Out.debug(new Object[] { "--------------------------start clear area----------------------------" });
/* 117 */     for (Map.Entry<String, Area> node : this.allAreas.entrySet()) {
/* 118 */       refreshAreaStatu(node.getKey());
/*     */     }
/* 120 */     Out.debug(new Object[] { "--------------------------after clear area----------------------------" });
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
/*     */   public final void refreshAreaItems() {
/* 135 */     long now = System.currentTimeMillis();
/* 136 */     int leftTime = GlobalConfig.itemdrop_lock_lifeTime;
/* 137 */     Area area = null;
/* 138 */     Area.AreaItem areaItem = null;
/* 139 */     for (Map.Entry<String, Area> node : this.allAreas.entrySet()) {
/* 140 */       area = node.getValue();
/* 141 */       for (Map.Entry<String, Area.AreaItem> entry : area.items.entrySet()) {
/* 142 */         areaItem = entry.getValue();
/* 143 */         if (now >= areaItem.createTime + leftTime && 
/* 144 */           area.onCleanItem(areaItem)) {
/* 145 */           area.items.remove(entry.getKey());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final Area getArea(String instanceId) {
/* 153 */     Area area = this.allAreas.get(instanceId);
/* 154 */     if (area == null) {
/* 155 */       area = CrossServerAreas.get(instanceId);
/*     */     }
/* 157 */     if (area == null) {
/* 158 */       area = ProxyServerAreas.get(instanceId);
/*     */     }
/* 160 */     return area;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void refreshAreaStatu(String instanceId) {
/* 167 */     Area area = this.allAreas.get(instanceId);
/* 168 */     if (area != null) {
/* 169 */       boolean flag = area.isValid();
/* 170 */       if (!flag) {
/* 171 */         closeArea(instanceId);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void closeAreaNoPlayer(String instanceId) {
/* 180 */     Area area = this.allAreas.get(instanceId);
/* 181 */     if (area != null && 
/* 182 */       area.canCloseNoPlayer()) {
/* 183 */       closeArea(instanceId);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void closeArea(String instanceId) {
/* 192 */     Area area = getArea(instanceId);
/* 193 */     if (area != null) {
/*     */       try {
/* 195 */         area.dispose();
/* 196 */       } catch (Exception e) {
/* 197 */         Out.error(new Object[] { e });
/*     */       } finally {
/* 199 */         if (this.allAreas.remove(instanceId) == null) {
/* 200 */           CrossServerAreas.remove(instanceId);
/*     */         }
/*     */       } 
/* 203 */       Out.debug(new Object[] { "closeArea instanceId:", area.prop.name, " :", instanceId });
/*     */     } else {
/* 205 */       Out.warn(new Object[] { "more closeArea instanceId:", instanceId });
/*     */     } 
/*     */   }
/*     */   
/*     */   public final Area dispatchByAreaId(WNPlayer player, JSONObject playerInfo) {
/* 210 */     int addCount = 1;
/* 211 */     TeamData.TeamMemberData member = player.getTeamManager().getTeamMember();
/* 212 */     if (member != null && member.isLeader) {
/* 213 */       addCount = player.getTeamManager().followCount();
/*     */     }
/* 215 */     Area area = this.allAreas.dispactch(playerInfo.getIntValue("areaId"), playerInfo.getIntValue("logicServerId"), addCount);
/* 216 */     if (area == null) {
/* 217 */       return createArea(player, playerInfo);
/*     */     }
/* 219 */     return area;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Area createArea(WNPlayer player, JSONObject data) {
/* 230 */     Out.debug(new Object[] { "createArea areaData:", data });
/*     */     
/* 232 */     int areaId = data.getIntValue("areaId");
/* 233 */     MapBase prop = AreaUtil.getAreaProp(areaId);
/* 234 */     if (prop != null) {
/* 235 */       GuildFortPvpArea guildFortPvpArea; String instanceId = UUID.randomUUID().toString();
/* 236 */       boolean usespaceDiv = false;
/* 237 */       if (prop.type == Const.SCENE_TYPE.NORMAL.getValue() || prop.type == Const.SCENE_TYPE.ILLUSION.getValue() || prop.type == Const.SCENE_TYPE.CROSS_SERVER.getValue()) {
/* 238 */         usespaceDiv = true;
/*     */       }
/* 240 */       JSONObject enterData = new JSONObject();
/* 241 */       enterData.put("monsterHard", prop.monsterHard);
/* 242 */       enterData.put("calPKValue", Boolean.valueOf((prop.ignorePkRule == 0)));
/* 243 */       enterData.put("allowAutoGuard", Boolean.valueOf((prop.autoFight == 1)));
/* 244 */       enterData.put("usespaceDiv", Boolean.valueOf(usespaceDiv));
/* 245 */       enterData.put("sceneType", Integer.valueOf(prop.type));
/* 246 */       enterData.put("canRiding", Boolean.valueOf((prop.rideMount == 1)));
/*     */       
/* 248 */       if (prop.type == Const.SCENE_TYPE.LOOP.getValue()) {
/* 249 */         TeamData team = player.getTeamManager().getTeam();
/* 250 */         int averageLevel = TaskUtils.getAvgLevel(team);
/* 251 */         enterData.put("averageLevel", Integer.valueOf(averageLevel));
/* 252 */         enterData.put("floorRatio", Integer.valueOf(1));
/* 253 */         enterData.put("propRatio", Float.valueOf(GlobalConfig.Loop_Hard_Rate));
/* 254 */       } else if (prop.type == Const.SCENE_TYPE.RESOURCE_DUNGEON.getValue()) {
/* 255 */         enterData.put("averageLevel", Integer.valueOf(player.getLevel()));
/* 256 */         enterData.put("floorRatio", Integer.valueOf(1));
/* 257 */         enterData.put("propRatio", Float.valueOf(GlobalConfig.Fate_Resource_Rate));
/* 258 */       } else if (prop.type == Const.SCENE_TYPE.DEMON_TOWER.getValue()) {
/* 259 */         enterData.put("averageLevel", Integer.valueOf(1));
/* 260 */         enterData.put("floorRatio", Integer.valueOf(data.getIntValue("lv")));
/* 261 */         enterData.put("propRatio", Float.valueOf(GlobalConfig.PropRatio));
/* 262 */       } else if (prop.type == Const.SCENE_TYPE.GUILD_BOSS.getValue()) {
/* 263 */         enterData.put("averageLevel", Integer.valueOf(data.getIntValue("lv")));
/* 264 */         enterData.put("floorRatio", Integer.valueOf(0));
/* 265 */         enterData.put("propRatio", Integer.valueOf(1));
/*     */       } else {
/* 267 */         enterData.put("averageLevel", Integer.valueOf(0));
/*     */       } 
/*     */       
/* 270 */       Out.debug(new Object[] { "createArea instanceId:", instanceId, " templateId:", Integer.valueOf(prop.templateID), " enterData:", enterData });
/*     */       
/* 272 */       if (prop.type != Const.SCENE_TYPE.CROSS_SERVER.getValue() || !GConfig.getInstance().isEnableProxy()) {
/* 273 */         player.setBattleServerId(GWorld.__CS_NODE.getNodeId());
/*     */       }
/*     */       
/* 276 */       player.getZoneManager().createZoneRequest(player.getBattleServerId(), prop.templateID, instanceId, enterData.toJSONString());
/*     */       
/* 278 */       int fullAllowedNum = prop.allowedPlayers;
/* 279 */       int maxAllowedNum = prop.allowedPlayers;
/* 280 */       data.put("instanceId", instanceId);
/* 281 */       Area area = null;
/* 282 */       if (prop.type == Const.SCENE_TYPE.NORMAL.getValue()) {
/* 283 */         area = new Area(data);
/* 284 */         fullAllowedNum = prop.fullPlayers;
/* 285 */         maxAllowedNum = prop.maxPlayers;
/* 286 */       } else if (prop.type == Const.SCENE_TYPE.FIGHT_LEVEL.getValue()) {
/* 287 */         FightLevel fightLevel = new FightLevel(data, Const.SCENE_TYPE.FIGHT_LEVEL);
/* 288 */       } else if (prop.type == Const.SCENE_TYPE.FIGHT_LEVEL_ULTRA.getValue()) {
/* 289 */         FightLevel fightLevel = new FightLevel(data, Const.SCENE_TYPE.FIGHT_LEVEL_ULTRA);
/* 290 */       } else if (prop.type == Const.SCENE_TYPE.LOOP.getValue()) {
/* 291 */         FightLevel fightLevel = new FightLevel(data, Const.SCENE_TYPE.LOOP);
/* 292 */       } else if (prop.type == Const.SCENE_TYPE.RESOURCE_DUNGEON.getValue()) {
/* 293 */         area = new ResourceDungeon(data);
/* 294 */       } else if (prop.type == Const.SCENE_TYPE.DEMON_TOWER.getValue()) {
/* 295 */         area = new DemonTower(data);
/* 296 */       } else if (prop.type == Const.SCENE_TYPE.SIN_COM.getValue()) {
/* 297 */         SoloArea soloArea = new SoloArea(data);
/* 298 */       } else if (prop.type == Const.SCENE_TYPE.ARENA.getValue()) {
/* 299 */         ArenaArea arenaArea = new ArenaArea(data);
/* 300 */       } else if (prop.type == Const.SCENE_TYPE.CROSS_SERVER.getValue()) {
/* 301 */         area = GConfig.getInstance().isEnableProxy() ? (Area)new CrossServerArea(data) : (Area)new CrossServerLocalArea(data);
/* 302 */         fullAllowedNum = prop.fullPlayers;
/* 303 */         maxAllowedNum = prop.maxPlayers;
/* 304 */       } else if (prop.type == Const.SCENE_TYPE.GUILD_DUNGEON.getValue()) {
/* 305 */         GuildDungeon guildDungeon = new GuildDungeon(data);
/* 306 */       } else if (prop.type != Const.SCENE_TYPE.WORLD_BOSS.getValue()) {
/*     */ 
/*     */ 
/*     */         
/* 310 */         if (prop.type == Const.SCENE_TYPE.GUILD_BOSS.getValue()) {
/* 311 */           GuildPO guildPo = player.guildManager.guild;
/* 312 */           GuildBossArea guildBossArea = new GuildBossArea(data, guildPo);
/* 313 */         } else if (prop.type == Const.SCENE_TYPE.ILLUSION.getValue()) {
/* 314 */           area = new IllusionArea(data);
/* 315 */           fullAllowedNum = prop.fullPlayers;
/* 316 */           maxAllowedNum = prop.maxPlayers;
/* 317 */         } else if (prop.type == Const.SCENE_TYPE.FIVE2FIVE.getValue()) {
/* 318 */           Five2FiveArea five2FiveArea = new Five2FiveArea(data);
/* 319 */         } else if (prop.type == Const.SCENE_TYPE.ILLUSION_2.getValue()) {
/* 320 */           area = new Illusion2Area(data);
/* 321 */           fullAllowedNum = prop.fullPlayers;
/* 322 */           maxAllowedNum = prop.maxPlayers;
/* 323 */         } else if (prop.type == Const.SCENE_TYPE.GUILD_FORT_PVE.getValue()) {
/* 324 */           GuildFortPveArea guildFortPveArea = new GuildFortPveArea(data);
/* 325 */         } else if (prop.type == Const.SCENE_TYPE.GUILD_FORT_PVP.getValue()) {
/* 326 */           guildFortPvpArea = new GuildFortPvpArea(data);
/*     */         } 
/* 328 */       }  if (guildFortPvpArea != null) {
/* 329 */         Out.info(new Object[] { "create area id :", Integer.valueOf(areaId), " instanceId:", instanceId });
/* 330 */         if (prop.type != Const.SCENE_TYPE.CROSS_SERVER.getValue() || !GConfig.getInstance().isEnableProxy()) {
/* 331 */           this.allAreas.put(instanceId, (Area)guildFortPvpArea);
/*     */         } else {
/* 333 */           CrossServerAreas.put(instanceId, guildFortPvpArea);
/*     */         } 
/* 335 */         guildFortPvpArea.bindBattleServer(player);
/* 336 */         ((Area)guildFortPvpArea).fullCount = fullAllowedNum;
/* 337 */         ((Area)guildFortPvpArea).maxCount = maxAllowedNum;
/* 338 */         return (Area)guildFortPvpArea;
/*     */       } 
/* 340 */       Out.error(new Object[] { "createZone:", Integer.valueOf(areaId), " fail! there is no area type of this,type:", Integer.valueOf(prop.type) });
/*     */     } else {
/*     */       
/* 343 */       Out.error(new Object[] { "areaProp is null! mapId:", Integer.valueOf(areaId) });
/*     */     } 
/* 345 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void onPlayerEvent(String playerId, Const.EventType type, Object... param) {
/* 350 */     WNPlayer player = GWorld.getInstance().getPlayer(playerId);
/* 351 */     if (player == null) {
/*     */       return;
/*     */     }
/* 354 */     player.onEvent(new TaskEvent(type, param));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void areaBattleServerEvent(JSONObject result) {
/* 362 */     Out.debug(new Object[] { "areaBattleServerEvent:", result });
/* 363 */     String instanceId = result.getString("instanceId");
/* 364 */     Area area = AreaUtil.getArea(instanceId);
/* 365 */     if (area != null) {
/* 366 */       switch (result.getString("eventName")) {
/*     */         case "unitDead":
/* 368 */           AreaEvent.unitDeadEventB2R(area, result);
/*     */           return;
/*     */         
/*     */         case "message":
/* 372 */           AreaEvent.messageEventB2R(area, result);
/*     */           return;
/*     */         
/*     */         case "gameOver":
/* 376 */           AreaEvent.gameOverEventB2R(area, result);
/*     */           return;
/*     */         
/*     */         case "pickItem":
/* 380 */           AreaEvent.pickItemEventB2R(area, result);
/*     */           return;
/*     */         
/*     */         case "BattleReportEventB2R":
/* 384 */           AreaEvent.battleReportEventB2R(area, result);
/*     */           return;
/*     */         
/*     */         case "KillBossEventB2R":
/* 388 */           AreaEvent.killBossEventB2R(area, result);
/*     */           return;
/*     */       } 
/*     */       
/* 392 */       Out.error(new Object[] { "area event: ", result });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void playerBattleServerEvent(JSONObject json) {
/*     */     int qty;
/*     */     boolean isUp;
/*     */     WNPlayer player, saverPlayer;
/* 403 */     Out.debug(new Object[] { "playerBattleServerEvent msg:", json });
/* 404 */     String eventName = json.getString("eventName");
/* 405 */     switch (eventName) {
/*     */       case "ConsumeItemEventB2R":
/* 407 */         qty = json.getIntValue("Qty");
/* 408 */         if (qty > 0) {
/* 409 */           onPlayerEvent(json.getString("playerId"), Const.EventType.consumeItem, new Object[] { json.getString("Type"), Integer.valueOf(qty) });
/*     */         }
/*     */         return;
/*     */       
/*     */       case "interActiveItem":
/* 414 */         if (json.containsKey("type")) {
/* 415 */           int type = json.getIntValue("type");
/* 416 */           if (type == 3) {
/* 417 */             WNPlayer wNPlayer = PlayerUtil.getOnlinePlayer(json.getString("playerId"));
/* 418 */             if (wNPlayer != null && wNPlayer.getArea() != null) {
/* 419 */               int objId = json.getIntValue("objId");
/* 420 */               int itemId = json.getIntValue("itemId");
/* 421 */               wNPlayer.getArea().onInterActiveItem(wNPlayer, objId, itemId);
/*     */             } 
/*     */             return;
/*     */           } 
/*     */         } 
/* 426 */         onPlayerEvent(json.getString("playerId"), Const.EventType.interActiveItem, new Object[] { Integer.valueOf(json.getIntValue("itemId")), Integer.valueOf(1) });
/*     */         return;
/*     */       
/*     */       case "changeSceneProgress":
/* 430 */         onPlayerEvent(json.getString("playerId"), Const.EventType.changeSceneProgress, new Object[] { json.getString("key"), json.get("value") });
/*     */         return;
/*     */       
/*     */       case "TransUnitEventB2R":
/* 434 */         JobFactory.addDelayJob(() -> onPlayerEvent(json.getString("playerId"), Const.EventType.changeArea, new Object[] { Integer.valueOf(json.getIntValue("SceneID")), Integer.valueOf(json.getIntValue("targetX")), Integer.valueOf(json.getIntValue("targetY")) }), 0L);
/*     */         return;
/*     */ 
/*     */ 
/*     */       
/*     */       case "SummonMountEventB2R":
/* 440 */         isUp = json.getBooleanValue("IsSummonMount");
/* 441 */         onPlayerEvent(json.getString("playerId"), Const.EventType.summonMount, new Object[] { Boolean.valueOf(isUp), Integer.valueOf(1) });
/*     */         return;
/*     */       
/*     */       case "ShowRebirthDialogueB2R":
/* 445 */         player = GWorld.getInstance().getPlayer(json.getString("DeadUnitUUID"));
/* 446 */         saverPlayer = GWorld.getInstance().getPlayer(json.getString("SaverUUID"));
/* 447 */         if (player != null && saverPlayer != null) {
/* 448 */           String saverName = MessageUtil.getPlayerNameColor(saverPlayer.getName(), (saverPlayer.getPlayer()).pro);
/* 449 */           player.onEvent(new TaskEvent(Const.EventType.rebirth, new Object[] { Integer.valueOf(1), saverName, Integer.valueOf(json.getIntValue("HP")), Integer.valueOf(json.getIntValue("MP")) }));
/*     */         } 
/*     */         return;
/*     */       
/*     */       case "TriggerSceneEventB2R":
/* 454 */         Out.debug(new Object[] { "TriggerSceneEventB2R", json.get("playerId") });
/* 455 */         player = PlayerUtil.getOnlinePlayer(json.getString("playerId"));
/* 456 */         if (player != null) {
/* 457 */           player.onBatterServerSceneEvent(json.getString("EventID"));
/*     */         }
/*     */         return;
/*     */       
/*     */       case "PlayerExceptionEventB2R":
/* 462 */         player = GWorld.getInstance().getPlayer(json.getString("playerId"));
/* 463 */         if (player != null) {
/* 464 */           Out.warn(new Object[] { player.getName(), "使用外挂 :", json.getString("reason") });
/* 465 */           PlayerUtil.sendSysMessageToPlayer("你竟然使用外挂了！！！", json.getString("playerId"), null);
/*     */         } 
/*     */         return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void taskBattleServerEvent(JSONObject msg) {
/* 476 */     Out.debug(new Object[] { "taskBattleServerEvent:", msg });
/* 477 */     String playerId = msg.getString("playerId");
/* 478 */     WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 479 */     if (player != null) {
/* 480 */       String eventName = msg.getString("eventName");
/* 481 */       int templateId = Integer.parseInt(msg.getString("id"));
/* 482 */       String key = msg.getString("key");
/* 483 */       int value = msg.getIntValue("value");
/* 484 */       player.taskManager.onTaskRequestEvent(eventName, templateId, key, value);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\area\AreaManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */