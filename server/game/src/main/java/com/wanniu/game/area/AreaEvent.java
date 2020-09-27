/*     */ package com.wanniu.game.area;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.Body;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.chat.ChannelUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.Normal_WorldCO;
/*     */ import com.wanniu.game.data.ResurrectionCO;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.data.base.MonsterBase;
/*     */ import com.wanniu.game.data.base.TaskBase;
/*     */ import com.wanniu.game.data.ext.MonsterRefreshExt;
/*     */ import com.wanniu.game.data.ext.WayTreasureExt;
/*     */ import com.wanniu.game.item.ItemConfig;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.item.data.ItemToBtlServerData;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.monster.MonsterConfig;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.task.TaskEvent;
/*     */ import com.wanniu.game.task.TaskUtils;
/*     */ import com.wanniu.game.task.po.TaskPO;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
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
/*     */ public class AreaEvent
/*     */ {
/*     */   public static class MonsterData
/*     */   {
/*     */     public int templateId;
/*     */     public int level;
/*     */     public int qColor;
/*     */     public String id;
/*     */     public String name;
/*     */     public String sceneType;
/*     */     public int killType;
/*     */     public int pro;
/*     */     public int drop;
/*     */   }
/*     */   
/*     */   public static void onTaskEvent(String taskPlayerId, int unitTemplateId) {
/*  67 */     if (StringUtil.isNotEmpty(taskPlayerId)) {
/*  68 */       WNPlayer taskPlayer = PlayerUtil.getOnlinePlayer(taskPlayerId);
/*  69 */       if (taskPlayer != null) {
/*  70 */         if (taskPlayer.isProxy()) {
/*  71 */           taskPlayer.onProxyEvent(3, body -> body.writeInt(unitTemplateId));
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */         
/*  77 */         for (TaskPO taskpo : taskPlayer.taskManager.treasureTasks.values()) {
/*  78 */           TaskBase prop = TaskUtils.getTaskProp(taskpo.templateId);
/*  79 */           for (String target : prop.targets) {
/*  80 */             WayTreasureExt way = (WayTreasureExt)GameData.WayTreasures.get(Integer.valueOf(Integer.parseInt(target)));
/*  81 */             if (way == null) {
/*     */               continue;
/*     */             }
/*  84 */             if (way.monsterIds.contains(Integer.valueOf(unitTemplateId))) {
/*  85 */               taskPlayer.taskManager.dealTaskEvent(Const.TaskType.FIND_TREASURE, target, 1);
/*     */               
/*  87 */               int lastIndex = prop.targets.indexOf(target);
/*  88 */               if (lastIndex < prop.targets.size() - 1) {
/*  89 */                 TaskUtils.treasurePush(taskPlayer, Integer.parseInt(prop.targets.get(lastIndex + 1)), taskpo.templateId);
/*     */               }
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/*  97 */         List<Normal_WorldCO> normal_WorldCOs = GameData.findNormal_Worlds(t -> (t.type >= 4));
/*  98 */         for (Normal_WorldCO normal_WorldCO : normal_WorldCOs) {
/*  99 */           if (normal_WorldCO.iD == unitTemplateId) {
/* 100 */             taskPlayer.onEvent(new TaskEvent(Const.EventType.killBossCount, new Object[] { Integer.valueOf(unitTemplateId), Integer.valueOf(1) }));
/*     */           }
/*     */         } 
/*     */         
/* 104 */         taskPlayer.onEvent(new TaskEvent(Const.EventType.killMonster, new Object[] { Integer.valueOf(unitTemplateId), Integer.valueOf(1) }));
/* 105 */         taskPlayer.taskManager.dealTaskEvent(Const.TaskType.GOT, String.valueOf(unitTemplateId), 1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void unitDead(Area area, JSONObject msg) {
/* 111 */     int unitType = msg.getIntValue("unitType");
/* 112 */     String hitFinalPlayerId = msg.getString("hitFinal");
/* 113 */     String belongPlayerId = msg.getString("belongPlayerId");
/* 114 */     JSONArray atkAssistantList = msg.getJSONArray("atkAssistantList");
/* 115 */     WNPlayer hitFinalPlayer = null;
/* 116 */     if (!StringUtil.isEmpty(belongPlayerId)) {
/* 117 */       hitFinalPlayer = area.getPlayer(belongPlayerId);
/*     */     }
/* 119 */     if (hitFinalPlayer == null && !StringUtil.isEmpty(hitFinalPlayerId)) {
/* 120 */       hitFinalPlayer = area.getPlayer(hitFinalPlayerId);
/*     */     }
/*     */     
/* 123 */     if (unitType == 0) {
/* 124 */       int unitTemplateId = msg.getIntValue("unitTemplateId");
/*     */ 
/*     */       
/* 127 */       String refreshPoint = msg.getString("refreshPoint");
/* 128 */       area.removeAliveBoss(Integer.valueOf(unitTemplateId), refreshPoint);
/*     */       
/* 130 */       if (hitFinalPlayer == null) {
/* 131 */         Out.debug(new Object[] { "怪物死亡时，受益人为空. belongPlayerId=", belongPlayerId, ",hitFinalPlayerId=", hitFinalPlayerId });
/*     */         
/*     */         return;
/*     */       } 
/* 135 */       MonsterBase monsterProp = MonsterConfig.getInstance().get(unitTemplateId);
/* 136 */       if (monsterProp == null) {
/* 137 */         if (Arrays.binarySearch(GlobalConfig.Monster_NoDrop_IDLists, unitTemplateId) < 0) {
/* 138 */           Out.error(new Object[] { "can not get prop from monsterProps by unitDead msg.unitTemplateId:", Integer.valueOf(unitTemplateId) });
/*     */         }
/*     */       } else {
/* 141 */         List<MonsterRefreshExt> refreshProps = GameData.findMonsterRefreshs(t -> 
/* 142 */             (t.monsterID == unitTemplateId && t.mapID == area.areaId));
/*     */         
/* 144 */         if (refreshProps != null && !refreshProps.isEmpty()) {
/* 145 */           MonsterRefreshExt bossExt = refreshProps.get(0);
/* 146 */           Out.info(new Object[] { "has boss dead:bossId = ", Integer.valueOf(bossExt.monsterID) });
/*     */         } 
/*     */         
/* 149 */         JSONArray teamSharedIdList = msg.getJSONArray("awardPlayer");
/*     */         
/* 151 */         area.onMonsterDead(unitTemplateId, msg.getIntValue("unitLevel"), msg.getIntValue("posX"), msg.getIntValue("posY"), msg.getIntValue("attackType"), refreshPoint, hitFinalPlayer, teamSharedIdList, atkAssistantList);
/*     */         
/* 153 */         onTaskEvent(hitFinalPlayer.getId(), unitTemplateId);
/* 154 */         int shareType = monsterProp.shareType;
/* 155 */         if (shareType == 1 && 
/* 156 */           atkAssistantList != null && !atkAssistantList.isEmpty()) {
/* 157 */           atkAssistantList.forEach(atkAssistant -> {
/*     */                 String _playerId = (String)atkAssistant;
/*     */                 
/*     */                 WNPlayer bindPlayer = area.getPlayer(_playerId);
/*     */                 
/*     */                 if (_playerId != null && !_playerId.equals(belongPlayerId) && bindPlayer != null && bindPlayer.area.areaId == area.areaId) {
/*     */                   onTaskEvent(_playerId, unitTemplateId);
/*     */                 }
/*     */               });
/*     */         }
/* 167 */         if (teamSharedIdList != null && !teamSharedIdList.isEmpty()) {
/* 168 */           teamSharedIdList.forEach(teamSharedId -> onTaskEvent((String)teamSharedId, unitTemplateId));
/*     */         }
/*     */       }
/*     */     
/*     */     }
/* 173 */     else if (unitType == 1) {
/* 174 */       String unitPlayerId = msg.getString("unitPlayerId");
/* 175 */       WNPlayer deadPlayer = area.getPlayer(unitPlayerId);
/*     */       
/* 177 */       Area.Actor actor = area.getActor(unitPlayerId);
/* 178 */       if (actor != null) {
/* 179 */         actor.alive = false;
/* 180 */         ResurrectionCO resurrection = (ResurrectionCO)GameData.Resurrections.get(Integer.valueOf(area.areaId));
/* 181 */         if (resurrection != null && resurrection.resurrectCD > 0) {
/* 182 */           actor.reliveCoolTime = System.currentTimeMillis() + (resurrection.resurrectCD * 1000);
/*     */         }
/* 184 */         if (!PlayerUtil.isOnline(unitPlayerId)) {
/* 185 */           JobFactory.addDelayJob(() -> area.relive(unitPlayerId, area.getReliveType()), (GlobalConfig.JJC_RebirthTime * 1000));
/*     */         
/*     */         }
/*     */       }
/* 189 */       else if (!area.isNormal()) {
/* 190 */         area.recordDie(unitPlayerId);
/*     */       } 
/* 192 */       if (hitFinalPlayerId != null) {
/* 193 */         if (deadPlayer != null) {
/* 194 */           area.onPlayerDeadByPlayer(deadPlayer, hitFinalPlayer, msg.getIntValue("posX"), msg.getIntValue("posY"));
/*     */           
/* 196 */           if (area.needSendKillMail()) {
/* 197 */             deadPlayer.chouRenManager.beKilledOnce(hitFinalPlayerId);
/* 198 */             deadPlayer.friendManager.beKilledOnce(hitFinalPlayerId);
/*     */           } 
/*     */         } 
/*     */         
/* 202 */         if (hitFinalPlayer != null && 
/* 203 */           area.needSendKillMail()) {
/* 204 */           hitFinalPlayer.chouRenManager.killOtherOnce(unitPlayerId);
/* 205 */           hitFinalPlayer.friendManager.killOtherOnce(unitPlayerId);
/*     */         }
/*     */       
/* 208 */       } else if (deadPlayer != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 218 */         area.onPlayerDeadByMonster(deadPlayer, null, msg.getIntValue("posX"), msg.getIntValue("posY"));
/*     */       } 
/* 220 */       List<ItemToBtlServerData> itemsPayLoad = null;
/* 221 */       List<NormalItem> normalItemsPayLoad = null;
/* 222 */       if (area.isPKDrop()) {
/* 223 */         long pkTime = msg.getLongValue("pkTime");
/* 224 */         if (pkTime < GlobalConfig.PK_Killed_LostEquip_HurtDmgTimeOut) {
/* 225 */           Object[] objects = area.onPKPlayerDeadDrop(deadPlayer, hitFinalPlayer, msg.getIntValue("pkValue"), msg.getIntValue("posX"), msg.getIntValue("posY"));
/* 226 */           itemsPayLoad = (List<ItemToBtlServerData>)objects[0];
/* 227 */           normalItemsPayLoad = (List<NormalItem>)objects[1];
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 232 */       if (hitFinalPlayer != null && deadPlayer != null && area.needSendKillMail()) {
/* 233 */         MailSysData mailData = null;
/* 234 */         if (itemsPayLoad != null && itemsPayLoad.size() > 0) {
/* 235 */           mailData = new MailSysData("BeKilledBySomneone1");
/*     */         } else {
/* 237 */           mailData = new MailSysData("BeKilledBySomneone2");
/*     */         } 
/* 239 */         mailData.replace = new HashMap<>();
/* 240 */         mailData.replace.put("time", DateUtil.format(Calendar.getInstance().getTime()));
/* 241 */         mailData.replace.put("location", area.getSceneName());
/* 242 */         mailData.replace.put("name", hitFinalPlayer.getName());
/* 243 */         if (itemsPayLoad != null && itemsPayLoad.size() > 0) {
/* 244 */           StringBuffer stringBuffer = new StringBuffer();
/* 245 */           for (NormalItem nItem : normalItemsPayLoad) {
/*     */             
/* 247 */             String itemText = LangService.getValue(MessageUtil.getColorLink(nItem.prop.qcolor));
/* 248 */             String itemLink = ChannelUtil.setItemInfo(nItem);
/* 249 */             DItemEquipBase base = ItemConfig.getInstance().getItemProp(nItem.prop.code);
/* 250 */             itemText = itemText.replace("{a}", base.name).replace("{b}", itemLink);
/*     */             
/* 252 */             String numText = LangService.getValue("DEFAULT");
/* 253 */             numText = numText.replace("{a}", "*" + nItem.getNum());
/*     */             
/* 255 */             String targetItemText = itemText + numText;
/*     */             
/* 257 */             stringBuffer.append(targetItemText);
/* 258 */             stringBuffer.append("、");
/*     */           } 
/*     */           
/* 261 */           stringBuffer.deleteCharAt(stringBuffer.length() - 1);
/*     */           
/* 263 */           mailData.replace.put("item", stringBuffer.toString());
/*     */         } 
/*     */ 
/*     */         
/* 267 */         MailUtil.getInstance().sendMailToOnePlayer(deadPlayer.getId(), (MailData)mailData, Const.GOODS_CHANGE_TYPE.KILL_PLAYER);
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
/*     */   public static void unitDeadEventB2R(Area area, JSONObject event) {
/* 280 */     area.onUnitDead(event);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void gameOverEventB2R(Area area, JSONObject event) {
/* 285 */     if (!area.isClose()) {
/* 286 */       Out.info(new Object[] { "scene game over:areaId=" + area.areaId + ",instanceId=", area.instanceId });
/* 287 */       area.isClose = true;
/* 288 */       area.onGameOver(event);
/* 289 */       area.addCloseFuture();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void pickItemEventB2R(Area area, JSONObject msg) {
/* 294 */     area.onPickItem(msg.getString("playerId"), msg.getString("itemId"), msg.getBooleanValue("isGuard"));
/*     */   }
/*     */   
/*     */   public static void messageEventB2R(Area area, JSONObject msg) {
/* 298 */     String paramData, msgArray[] = msg.getString("msg").split(",");
/* 299 */     String type = msgArray[0];
/* 300 */     String playerId = msgArray[1];
/* 301 */     String param = msgArray[2];
/*     */     
/* 303 */     WNPlayer player = area.getPlayer(playerId);
/* 304 */     if (player == null) {
/* 305 */       Out.warn(new Object[] { "AreaEvent player is offline:", playerId, "::", type, "::", param });
/*     */       return;
/*     */     } 
/* 308 */     switch (type) {
/*     */       case "accessable":
/*     */       case "unaccessable":
/* 311 */         player.taskManager.onTaskRequestEvent(type, Integer.valueOf(param).intValue(), null, 0);
/*     */         return;
/*     */       
/*     */       case "achievement":
/* 315 */         player.achievementManager.onPlaceArrived(Integer.parseInt(param));
/*     */         return;
/*     */       
/*     */       case "addUnit":
/* 319 */         player.onEvent(new TaskEvent(Const.EventType.addUnit, new Object[] { area, param }));
/*     */         return;
/*     */       
/*     */       case "loopTransform":
/* 323 */         JobFactory.addDelayJob(() -> player.onEvent(new TaskEvent(Const.EventType.loopTransform, new Object[] { area, param })), 0L);
/*     */         return;
/*     */ 
/*     */ 
/*     */       
/*     */       case "typeArena":
/* 329 */         paramData = msgArray[3];
/* 330 */         area.eatOrLostBuffer(player, param, paramData);
/*     */         return;
/*     */       
/*     */       case "挖宝事件":
/* 334 */         player.onEvent(new TaskEvent(Const.EventType.addUnit, new Object[] { area, param }));
/*     */         return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void battleReportEventB2R(Area area, JSONObject msg) {
/* 346 */     area.onBattleReport(msg.getJSONArray("data").toJavaList(DamageHealVO.class));
/*     */   }
/*     */   
/*     */   public static void killBossEventB2R(Area area, JSONObject msg) {
/* 350 */     area.onKillBoss(msg.getString("playerId"));
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\area\AreaEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */