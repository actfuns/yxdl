/*     */ package com.wanniu.game.area;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.proxy.ProxyClient;
/*     */ import com.wanniu.core.proxy.ProxyType;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.csharp.CSharpClient;
/*     */ import com.wanniu.csharp.CSharpNode;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.cross.CrossServerArea;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.fightLevel.FightLevelManager;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
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
/*     */ public class AreaUtil
/*     */ {
/*     */   public static final long MIN_CHANGE_AREA_INTERVAL_MILL = 1000L;
/*     */   private static AreaUtil instance;
/*     */   
/*     */   public static AreaUtil getInstance() {
/*  45 */     if (instance == null) {
/*  46 */       instance = new AreaUtil();
/*     */     }
/*  48 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String canTransArea(MapBase sceneProp, WNPlayer player) {
/*  55 */     if (sceneProp == null) {
/*  56 */       return LangService.getValue("AREA_ID_NULL");
/*     */     }
/*  58 */     if (sceneProp.allowedTransfer == 0) {
/*  59 */       return LangService.getValue("AREA_NOT_TRANSFER");
/*     */     }
/*     */     
/*  62 */     return canEnterArea(sceneProp, player);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean disCardItemByTransArea(MapBase sceneProp, WNPlayer player) {
/*  69 */     String transItemCode = sceneProp.costItem;
/*  70 */     int needTransItemNum = sceneProp.costItemNum;
/*  71 */     if (transItemCode.length() > 0) {
/*  72 */       int itemNum = player.getWnBag().findItemNumByCode(transItemCode);
/*  73 */       if (itemNum < needTransItemNum) {
/*  74 */         player.onFunctionGoTo(Const.FUNCTION_GOTO_TYPE.DIAMONDSHOP, transItemCode, null, null);
/*  75 */         return false;
/*     */       } 
/*  77 */       player.getWnBag().discardItem(transItemCode, needTransItemNum, Const.GOODS_CHANGE_TYPE.transport, null, false, false);
/*     */     } 
/*  79 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String canEnterArea(MapBase sceneProp, WNPlayer player) {
/*  87 */     if (sceneProp == null) {
/*  88 */       return LangService.getValue("AREA_ID_NULL");
/*     */     }
/*     */     
/*  91 */     if (GWorld.APP_TIME - player.getLastChangeAreaTime() < 1000L) {
/*  92 */       Out.error(new Object[] { player.getName(), " changeArea too rapid error : ", player.area.getSceneName(), "-", player.area.instanceId, " to ", sceneProp.name, " use ", Long.valueOf(GWorld.APP_TIME - player.getLastChangeAreaTime()), "ms use ", JSON.toJSONString(player.playerTempData) });
/*  93 */       return LangService.getValue("DUNGEON_ALREAD_IN_DUNGEON");
/*     */     } 
/*     */     
/*  96 */     if (!player.getArea().isNormal()) {
/*  97 */       return LangService.getValue("DUNGEON_ALREAD_IN_DUNGEON");
/*     */     }
/*     */     
/* 100 */     if (sceneProp.openRule == Const.OpenRuleType.EVERY_DAY.getValue()) {
/* 101 */       long currTime = System.currentTimeMillis();
/* 102 */       Date beginTime = DateUtil.format(sceneProp.beginTime);
/* 103 */       Date endTime = DateUtil.format(sceneProp.endTime);
/* 104 */       if ((sceneProp.beginTime != null && currTime < beginTime.getTime()) || (sceneProp.endTime != null && currTime > endTime.getTime())) {
/* 105 */         return LangService.getValue("DUNGEON_TEAM_NOT_OPEN");
/*     */       }
/* 107 */     } else if (sceneProp.openRule == Const.OpenRuleType.EVERY_WEEK.getValue()) {
/* 108 */       int pos = sceneProp.OpenDate.indexOf(Integer.valueOf(Calendar.getInstance().get(7)));
/* 109 */       if (-1 == pos) {
/* 110 */         return LangService.getValue("DUNGEON_TEAM_NOT_OPEN");
/*     */       }
/* 112 */       long currTime = System.currentTimeMillis();
/* 113 */       Date beginTime = DateUtil.format(sceneProp.beginTime);
/* 114 */       Date endTime = DateUtil.format(sceneProp.endTime);
/* 115 */       if ((sceneProp.beginTime != null && currTime < beginTime.getTime()) || (sceneProp.endTime != null && currTime > endTime.getTime())) {
/* 116 */         return LangService.getValue("DUNGEON_TEAM_NOT_OPEN");
/*     */       }
/*     */     } 
/* 119 */     if (player.getLevel() < sceneProp.reqLevel) {
/* 120 */       return LangService.getValue("AREA_PLAYER_LEVEL_LIMIT").replace("{playerLevel}", LangService.getValue("RED").replace("{a}", "" + sceneProp.reqLevel));
/*     */     }
/*     */ 
/*     */     
/* 124 */     Map<String, TeamData.TeamMemberData> members = player.getTeamManager().getTeamMembers();
/* 125 */     if (members != null && player.getTeamManager().isTeamLeader() && sceneProp.mapID != 70002)
/*     */     {
/* 127 */       for (TeamData.TeamMemberData member : members.values()) {
/* 128 */         WNPlayer mp = member.getPlayer();
/* 129 */         if (member.isFollow() && member.isOnline() && mp != null && 
/* 130 */           mp.getLevel() < sceneProp.reqLevel) {
/* 131 */           return LangService.getValue("AREA_TEAM_LEVEL_NOT_ENOUGH").replace("{playername}", mp.getName());
/*     */         }
/*     */       } 
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
/* 146 */     if (sceneProp.mapID != GlobalConfig.World_Boss_NewScene || player.getPlayerTasks().isCompleteTaskByID(GlobalConfig.World_Boss_NweScene_Quest)) {
/* 147 */       if (sceneProp.upLevellimit > 0) {
/* 148 */         if ((player.getPlayer()).upLevel > sceneProp.upLevellimit) {
/* 149 */           return LangService.getValue("MAP_OVER_UPLEVEL").replace("{uplevel}", "" + sceneProp.upLevellimit);
/*     */         }
/* 151 */       } else if (sceneProp.levellimit > 0 && 
/* 152 */         player.getLevel() > sceneProp.levellimit) {
/* 153 */         return LangService.getValue("MAP_OVER_LEVEL").replace("{level}", "" + sceneProp.levellimit);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 162 */     if (sceneProp.reqQuestId != 0 && 
/* 163 */       !player.getPlayerTasks().isTaskDoingOrFinish(sceneProp.reqQuestId)) {
/* 164 */       return LangService.getValue("PLAYER_NOT_FINISH_OR_NOT_HAVE_TASK");
/*     */     }
/*     */     
/* 167 */     String reqItemCode = sceneProp.reqItemCode;
/* 168 */     int reqItemCount = sceneProp.reqItemCount;
/* 169 */     if (reqItemCode.length() > 0) {
/* 170 */       if (reqItemCode.equals("gold")) {
/* 171 */         if (player.moneyManager.getGold() < reqItemCount) {
/* 172 */           return LangService.getValue("MAP_ITEM_NOT_ENOUGH").replace("{itemName}", (ItemUtil.getUnEquipPropByCode(reqItemCode)).name);
/*     */         }
/*     */       } else {
/* 175 */         int itemNum = player.getWnBag().findItemNumByCode(reqItemCode);
/* 176 */         if (itemNum < reqItemCount) {
/* 177 */           return LangService.getValue("MAP_ITEM_NOT_ENOUGH").replace("{itemName}", (ItemUtil.getUnEquipPropByCode(reqItemCode)).name);
/*     */         }
/*     */       } 
/*     */     }
/* 181 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean disCardItemByEnterArea(MapBase sceneProp, WNPlayer player) {
/* 188 */     String reqItemCode = sceneProp.reqItemCode;
/* 189 */     if (reqItemCode.length() > 0) {
/* 190 */       int itemNum = player.getWnBag().findItemNumByCode(reqItemCode);
/* 191 */       if (itemNum < sceneProp.reqItemCount) {
/* 192 */         return false;
/*     */       }
/* 194 */       player.getWnBag().discardItem(reqItemCode, sceneProp.reduceItemCount, Const.GOODS_CHANGE_TYPE.transport, null, false, false);
/*     */     } 
/* 196 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static final Area enterArea(WNPlayer player, int areaId) {
/* 201 */     return enterArea(player, areaId, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Area enterArea(WNPlayer player, int areaId, float targetX, float targetY) {
/* 208 */     MapBase sceneProp = null;
/* 209 */     if (areaId == -999) {
/* 210 */       areaId = GlobalConfig.CROSS_SERVER_ENTER_SCENE;
/*     */     }
/* 212 */     sceneProp = AreaDataConfig.getInstance().get(areaId);
/* 213 */     if (sceneProp == null) {
/* 214 */       Out.error(new Object[] { "no sceneProp areaId:", Integer.valueOf(areaId) });
/* 215 */       return null;
/*     */     } 
/*     */     
/* 218 */     Out.debug(new Object[] { "areaUtil enterArea areaId:", Integer.valueOf(areaId) });
/*     */     
/* 220 */     if (player.getAreaId() == areaId) {
/* 221 */       PlayerUtil.sendSysMessageToPlayer(LangService.getValue("MAP_IN"), player.getId(), Const.TipsType.BLACK);
/* 222 */       return null;
/*     */     } 
/*     */     
/* 225 */     String result = canEnterArea(sceneProp, player);
/* 226 */     if (result != null) {
/* 227 */       PlayerUtil.sendSysMessageToPlayer(result, player.getId(), Const.TipsType.BLACK);
/* 228 */       return null;
/*     */     } 
/*     */     
/* 231 */     disCardItemByEnterArea(sceneProp, player);
/*     */     
/* 233 */     if (sceneProp.type == Const.SCENE_TYPE.NORMAL.getValue() || sceneProp.type == Const.SCENE_TYPE.ILLUSION.getValue())
/* 234 */       return dispatchByAreaId(player, new AreaData(areaId, targetX, targetY), (Map<String, Object>)null); 
/* 235 */     if (sceneProp.type == Const.SCENE_TYPE.FIGHT_LEVEL.getValue() || sceneProp.type == Const.SCENE_TYPE.LOOP.getValue() || sceneProp.type == Const.SCENE_TYPE.DEMON_TOWER.getValue() || sceneProp.type == Const.SCENE_TYPE.RESOURCE_DUNGEON.getValue() || sceneProp.type == Const.SCENE_TYPE.ILLUSION_2.getValue()) {
/*     */       
/* 237 */       FightLevelManager fightLevelManager = player.fightLevelManager;
/* 238 */       String data = fightLevelManager.enterDungeonReq(player, areaId);
/* 239 */       if (data != null) {
/* 240 */         PlayerUtil.sendSysMessageToPlayer(data, player.getId(), Const.TipsType.BLACK);
/*     */       }
/* 242 */       return null;
/* 243 */     }  if (sceneProp.type == Const.SCENE_TYPE.CROSS_SERVER.getValue()) {
/* 244 */       if (player.getSceneType() == Const.SCENE_TYPE.FIGHT_LEVEL.getValue() || player.getSceneType() == Const.SCENE_TYPE.LOOP.getValue()) {
/* 245 */         PlayerUtil.sendSysMessageToPlayer(LangService.getValue("CROSS_SERVER_AUTH_LIMIT_FIGHTLEVEL"), player.getId(), null);
/* 246 */         return null;
/*     */       } 
/* 248 */       return dispatchByCrossServerId(player, new AreaData(areaId, targetX, targetY));
/* 249 */     }  if (sceneProp.type == Const.SCENE_TYPE.WORLD_BOSS.getValue()) {
/* 250 */       String instanceId = null;
/* 251 */       if (player.getTeamManager().isInTeam()) {
/* 252 */         Map<String, TeamData.TeamMemberData> teamMembers = player.getTeamManager().getTeamMembers();
/* 253 */         for (TeamData.TeamMemberData teamMember : teamMembers.values()) {
/* 254 */           WNPlayer member = teamMember.getPlayer();
/* 255 */           if (member != null && !teamMember.id.equals(player.getId()) && member.getAreaId() == areaId) {
/* 256 */             instanceId = member.getInstanceId();
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 261 */       if (instanceId != null) {
/* 262 */         return dispatchByInstanceId(player, new AreaData(areaId, instanceId));
/*     */       }
/* 264 */       return dispatchByAreaId(player, new AreaData(areaId, 0.0F, 0.0F), (Map<String, Object>)null);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 270 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean canRideMount(int areaId) {
/* 277 */     MapBase prop = getAreaProp(areaId);
/* 278 */     return (prop.rideMount == 1);
/*     */   }
/*     */   
/*     */   public static final MapBase getAreaProp(int areaId) {
/* 282 */     return AreaDataConfig.getInstance().get(areaId);
/*     */   }
/*     */   
/*     */   public static final int getAreaType(int areaId) {
/* 286 */     return (getAreaProp(areaId)).type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date formatToday(String stringTime) {
/* 293 */     String[] begins = stringTime.split("-");
/* 294 */     Calendar date = Calendar.getInstance();
/* 295 */     if (begins.length == 3) {
/* 296 */       date.set(11, Integer.parseInt(begins[0]));
/* 297 */       date.set(12, Integer.parseInt(begins[1]));
/* 298 */       date.set(13, Integer.parseInt(begins[2]));
/* 299 */       date.set(14, 0);
/*     */     } 
/* 301 */     return date.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean needCreateArea(int areaId) {
/* 308 */     MapBase prop = getAreaProp(areaId);
/* 309 */     return (prop == null || (prop.type != Const.SCENE_TYPE.NORMAL.getValue() && prop.type != Const.SCENE_TYPE.ILLUSION.getValue() && prop.type != Const.SCENE_TYPE.CROSS_SERVER.getValue()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Area getArea(String instanceId) {
/* 316 */     return AreaManager.getInstance().getArea(instanceId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void closeArea(String instanceId) {
/* 323 */     AreaManager.getInstance().closeArea(instanceId);
/* 324 */     Out.debug(new Object[] { "closeArea:::", instanceId });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void closeAreaNoPlayer(String instanceId) {
/* 331 */     AreaManager.getInstance().closeAreaNoPlayer(instanceId);
/* 332 */     Out.debug(new Object[] { "closeAreaNoPlayer:::", instanceId });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void changeAreaPush(WNPlayer player, int areaId, String instanceId) {
/* 343 */     player.receive("area.playerPush.changeAreaPush", (GeneratedMessage)changeAreaPush(areaId, instanceId));
/*     */   }
/*     */ 
/*     */   
/*     */   public static final PlayerHandler.ChangeAreaPush changeAreaPush(int areaId, String instanceId) {
/* 348 */     MapBase prop = AreaDataConfig.getInstance().get(areaId);
/* 349 */     PlayerHandler.ChangeAreaPush.Builder data = PlayerHandler.ChangeAreaPush.newBuilder();
/* 350 */     data.setS2CMapId(areaId);
/* 351 */     data.setS2CInstanceId(instanceId);
/* 352 */     data.setS2CSceneId(prop.templateID);
/* 353 */     data.setS2CSceneType(prop.type);
/* 354 */     data.setS2CSceneUseAgent(prop.useAgent);
/* 355 */     data.setS2CRideMount(prop.rideMount);
/* 356 */     data.setS2CChangePkType(prop.changePKtype);
/* 357 */     return data.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Area changeArea(WNPlayer player, AreaData areaData) {
/* 368 */     Area area = player.getArea();
/* 369 */     if (area != null) {
/* 370 */       if (area.instanceId.equals(areaData.instanceId)) {
/* 371 */         Out.debug(new Object[] { player.getName(), "已在场景，无需切换：", area.prop.name });
/* 372 */         return area;
/*     */       } 
/*     */       
/* 375 */       String matchScene = GlobalConfig.MATCH_SCENE;
/* 376 */       MapBase destMap = AreaDataConfig.getInstance().get(areaData.areaId);
/* 377 */       if (destMap != null && matchScene.indexOf(String.valueOf(destMap.type)) == -1) {
/* 378 */         player.soloManager.quitMatching(false);
/* 379 */         player.five2FiveManager.cancelFive2FiveMatch(false);
/*     */       } 
/* 381 */       area.syncPlayerHistoryData(player);
/*     */     } 
/*     */     
/* 384 */     int areaId = areaData.areaId;
/* 385 */     float targetX = areaData.targetX;
/* 386 */     float targetY = areaData.targetY;
/*     */     
/* 388 */     player.syncBornData(targetX, targetY, areaId);
/* 389 */     player.setBornType(Const.BORN_TYPE.BORN);
/* 390 */     player.setEnterState(Const.ENTER_STATE.changeArea.value);
/*     */     
/* 392 */     PlayerRemote.playerEnterAreaServer(player, areaData.instanceId);
/* 393 */     Out.info(new Object[] { "enter scene:playerId=", player.getId(), "araid=", Integer.valueOf((area == null) ? areaId : area.areaId), ",instanceId=", (area == null) ? areaData.instanceId : area.instanceId });
/* 394 */     return area;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Area dispatchByInstanceId(WNPlayer player, AreaData areaData) {
/* 402 */     if (player.getInstanceId().equals(areaData.instanceId)) {
/* 403 */       return null;
/*     */     }
/*     */     
/* 406 */     changeTeamArea(player, areaData);
/* 407 */     return getArea(areaData.instanceId);
/*     */   }
/*     */   
/*     */   public static final Area dispatchByAreaId(WNPlayer player, int areaId, Map<String, Object> userData) {
/* 411 */     return dispatchByAreaId(player, new AreaData(areaId), userData);
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
/*     */   public static final Area dispatchByAreaId(WNPlayer player, int areaId, float targetX, float targetY) {
/* 424 */     return dispatchByAreaId(player, new AreaData(areaId, targetX, targetY), (Map<String, Object>)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Area dispatchByAreaId(WNPlayer player, AreaData areaData, Map<String, Object> userData) {
/* 431 */     Out.debug(new Object[] { "dispatchByAreaId areaData:", Integer.valueOf(areaData.areaId), ",", areaData.instanceId });
/* 432 */     JSONObject json = Utils.toJSON(new Object[] { "id", player.getId(), "logicServerId", Integer.valueOf(player.getLogicServerId()), "areaId", Integer.valueOf(areaData.areaId) });
/* 433 */     if (userData != null) {
/* 434 */       json.putAll(userData);
/*     */     }
/* 436 */     Area area = AreaManager.getInstance().dispatchByAreaId(player, json);
/* 437 */     areaData.instanceId = area.instanceId;
/*     */     
/* 439 */     changeTeamArea(player, areaData);
/* 440 */     return area;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final Area dispatchByCrossServerId(WNPlayer player, AreaData areaData) {
/* 447 */     Out.debug(new Object[] { "dispatchByCrossServerId areaData:", areaData });
/* 448 */     areaData.logicServerId = player.getAcrossServerId();
/* 449 */     JSONObject json = Utils.toJSON(new Object[] { "id", player.getId(), "logicServerId", Integer.valueOf(areaData.logicServerId), "areaId", Integer.valueOf(areaData.areaId) });
/* 450 */     Area area = null;
/* 451 */     if (GConfig.getInstance().isEnableProxy()) {
/* 452 */       json = ProxyClient.getInstance().request(ProxyType.ProxyMethod.M_DISPATCHER, json);
/* 453 */       if (json.containsKey("exists")) {
/* 454 */         area = getArea(json.getString("instanceId"));
/* 455 */         if (area == null) {
/* 456 */           return bindCrossServerArea(player, json, crossArea -> {
/*     */                 areaData.instanceId = crossArea.instanceId;
/*     */                 
/*     */                 changeTeamArea(player, areaData);
/*     */               });
/*     */         }
/*     */       } else {
/* 463 */         area = AreaManager.getInstance().createArea(player, json);
/* 464 */         json.put("csNode", GWorld.__CS_NODE);
/* 465 */         json.put("fullCount", Integer.valueOf(area.fullCount));
/* 466 */         json.put("maxCount", Integer.valueOf(area.maxCount));
/* 467 */         json.put("lifeTime", Integer.valueOf(area.lifeTime));
/* 468 */         json.put("sid", Integer.valueOf(GWorld.__SERVER_ID));
/* 469 */         json = ProxyClient.getInstance().request(ProxyType.ProxyMethod.M_CREATE, json);
/* 470 */         area.lineIndex = json.getIntValue("lineIndex");
/*     */       } 
/* 472 */       areaData.instanceId = area.instanceId;
/*     */       
/* 474 */       changeTeamArea(player, areaData);
/*     */     } else {
/* 476 */       area = dispatchByAreaId(player, areaData, (Map<String, Object>)null);
/*     */     } 
/*     */     
/* 479 */     return area;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Area bindCrossServerArea(WNPlayer player, JSONObject json, AreaCB cb) {
/* 488 */     CSharpNode node = (CSharpNode)json.getObject("csNode", CSharpNode.class);
/* 489 */     CrossServerArea crossServerArea1 = new CrossServerArea(json);
/* 490 */     AreaManager.CrossServerAreas.put(((Area)crossServerArea1).instanceId, crossServerArea1);
/* 491 */     String nodeId = node.getNodeId();
/* 492 */     CrossServerArea crossArea = crossServerArea1;
/* 493 */     if (CSharpClient.getXmdsManager(nodeId) == null) {
/* 494 */       CSharpClient.getInstance().connectAsync(node, () -> {
/*     */             Out.debug(new Object[] { " bindCrossServerArea ", nodeId });
/*     */             player.setBattleServerId(nodeId);
/*     */             crossArea.bindBattleServer(player);
/*     */             cb.call(crossArea);
/*     */           });
/* 500 */       return (Area)crossServerArea1;
/*     */     } 
/* 502 */     crossArea.bindBattleServer(player);
/*     */     
/* 504 */     cb.call(crossArea);
/* 505 */     return (Area)crossServerArea1;
/*     */   }
/*     */   
/*     */   public static final void changeTeamArea(WNPlayer player, AreaData areaData) {
/* 509 */     Map<String, TeamData.TeamMemberData> members = player.getTeamManager().getTeamMembers();
/* 510 */     if (members != null && player.getTeamManager().isTeamLeader() && areaData.areaId != 70002) {
/*     */       
/* 512 */       for (TeamData.TeamMemberData member : members.values()) {
/* 513 */         if (member.isFollow() && member.isOnline())
/*     */         {
/* 515 */           changeArea(member.getPlayer(), areaData);
/*     */         }
/*     */       } 
/*     */     } else {
/* 519 */       changeArea(player, areaData);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Area createAreaAndDispatch(WNPlayer player, Collection<String> playerIds, int logicServerId, int areaId, Map<String, Object> userData) {
/* 530 */     JSONObject areaData = Utils.toJSON(new Object[] { "logicServerId", Integer.valueOf(logicServerId), "areaId", Integer.valueOf(areaId) });
/* 531 */     if (userData != null) {
/* 532 */       areaData.putAll(userData);
/*     */     }
/* 534 */     Area area = AreaManager.getInstance().createArea(player, areaData);
/* 535 */     AreaData data = new AreaData(areaId, area.instanceId);
/*     */     
/* 537 */     for (String rid : playerIds) {
/* 538 */       WNPlayer member = PlayerUtil.getOnlinePlayer(rid);
/* 539 */       if (member != null)
/*     */       {
/* 541 */         changeArea(member, data);
/*     */       }
/*     */     } 
/*     */     
/* 545 */     return area;
/*     */   }
/*     */   
/*     */   public static Area dispatch(WNPlayer player, Collection<String> playerIds, int logicServerId, int areaId, Map<String, Object> userData) {
/* 549 */     JSONObject areaData = Utils.toJSON(new Object[] { "logicServerId", Integer.valueOf(logicServerId), "areaId", Integer.valueOf(areaId) });
/* 550 */     if (userData != null) {
/* 551 */       areaData.putAll(userData);
/*     */     }
/* 553 */     Area area = AreaManager.getInstance().dispatchByAreaId(player, areaData);
/* 554 */     AreaData data = new AreaData(areaId, area.instanceId);
/*     */     
/* 556 */     for (String rid : playerIds) {
/* 557 */       WNPlayer member = PlayerUtil.getOnlinePlayer(rid);
/* 558 */       if (member != null)
/*     */       {
/* 560 */         changeArea(member, data);
/*     */       }
/*     */     } 
/*     */     
/* 564 */     return area;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isNormalArea(int sceneType) {
/* 574 */     return (sceneType == Const.SCENE_TYPE.NORMAL.getValue() || sceneType == Const.SCENE_TYPE.ILLUSION.getValue() || sceneType == Const.SCENE_TYPE.CROSS_SERVER.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Area dispatch(WNPlayer player) {
/* 582 */     Const.BORN_TYPE bornType = Const.BORN_TYPE.NORMAL;
/* 583 */     Out.debug(new Object[] { "dispatch try createAreaAndDispatch begin" });
/* 584 */     Area area = player.getArea();
/* 585 */     if (area == null || area.isPlayerClose(player)) {
/* 586 */       int areaId = player.playerTempData.areaId;
/* 587 */       MapBase prop = getAreaProp(areaId);
/* 588 */       if (prop.disConnToMapID != 0) {
/* 589 */         areaId = (player.getPlayerTempData()).bornAreaId;
/* 590 */         bornType = Const.BORN_TYPE.BORN;
/* 591 */         Out.debug(new Object[] { "create area 2222: areaId:", Integer.valueOf(areaId), "  bornType:", bornType });
/* 592 */       } else if (!isNormalArea(prop.type)) {
/* 593 */         areaId = (player.getPlayerTempData()).historyAreaId;
/* 594 */         bornType = Const.BORN_TYPE.HISTORY;
/* 595 */         Out.debug(new Object[] { "create area 1111: areaId:", Integer.valueOf(areaId), "  bornType:", bornType });
/*     */       } 
/* 597 */       if (Const.SCENE_TYPE.CROSS_SERVER.getValue() == getAreaType(areaId)) {
/* 598 */         area = dispatchByCrossServerId(player, new AreaData(areaId));
/*     */       } else {
/* 600 */         player.setBornType(bornType, areaId);
/* 601 */         float x = player.playerTempData.x;
/* 602 */         float y = player.playerTempData.y;
/* 603 */         area = dispatchByAreaId(player, new AreaData(areaId, x, y), (Map<String, Object>)null);
/*     */       } 
/*     */     } else {
/* 606 */       if (!area.isNormal()) {
/* 607 */         bornType = Const.BORN_TYPE.BORN;
/*     */       }
/* 609 */       player.setBornType(bornType, area.areaId);
/*     */       
/* 611 */       PlayerRemote.playerEnterAreaServerInner(player, area);
/*     */     } 
/*     */     
/* 614 */     return area;
/*     */   }
/*     */   
/*     */   public static Area createArea(WNPlayer player, JSONObject json) {
/* 618 */     return AreaManager.getInstance().createArea(player, json);
/*     */   }
/*     */   
/*     */   public static boolean isCrossArea(int sceneType) {
/* 622 */     return (sceneType == Const.SCENE_TYPE.CROSS_SERVER.getValue());
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface AreaCB {
/*     */     void call(CrossServerArea param1CrossServerArea);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\area\AreaUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */