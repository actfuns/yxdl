/*     */ package com.wanniu.game.activity;
/*     */ 
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.DropListExt;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.DemonTowerPO;
/*     */ import com.wanniu.game.poes.PlayerPO;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.TimerTask;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import pomelo.Common;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DemonTowerManager
/*     */ {
/*  34 */   private static Map<String, ScheduledFuture<?>> scheduleMap = new HashMap<>();
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
/*     */   public DemonTowerPO po;
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
/*     */   private WNPlayer player;
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
/*     */   TimerTask timerTask;
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
/*     */   public DemonTowerManager(WNPlayer player) {
/*  94 */     this.timerTask = new TimerTask()
/*     */       {
/*     */         public void run()
/*     */         {
/*  98 */           String callbackPlayerId = DemonTowerManager.this.player.getId();
/*  99 */           DemonTowerPO tempPo = (DemonTowerPO)PlayerPOManager.findPO(ConstsTR.PLAYER_DEMON_TOWER, DemonTowerManager.this.player.getId(), DemonTowerPO.class);
/* 100 */           tempPo.sweepEndTime = null;
/*     */           
/* 102 */           MailSysData mailData = new MailSysData("DemonTower_sweep");
/*     */           
/* 104 */           mailData.attachments = new ArrayList();
/* 105 */           HashMap<String, Integer> rewardMap = DemonTowerManager.this.ComputeSweepRewards();
/* 106 */           for (String code : rewardMap.keySet()) {
/* 107 */             MailData.Attachment item = new MailData.Attachment();
/* 108 */             item.itemCode = code;
/* 109 */             item.itemNum = ((Integer)rewardMap.get(code)).intValue();
/* 110 */             mailData.attachments.add(item);
/*     */           } 
/* 112 */           MailUtil.getInstance().sendMailToOnePlayer(callbackPlayerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.DemonTower);
/*     */           
/* 114 */           DemonTowerManager.scheduleMap.remove(DemonTowerManager.this.player.getId()); }
/*     */       }; this.po = (DemonTowerPO)PlayerPOManager.findPO(ConstsTR.PLAYER_DEMON_TOWER, player.getId(), DemonTowerPO.class); if (this.po == null) { this.po = new DemonTowerPO(player.getId(), 1, 0, GlobalConfig.ResetNum); PlayerPOManager.put(ConstsTR.PLAYER_DEMON_TOWER, player.getId(), (GEntity)this.po); }
/*     */      this.player = player; } public void init() { if (this.po.sweepEndTime != null) { Date now = new Date(); long timeOffset = this.po.sweepEndTime.getTime() - now.getTime(); if (timeOffset <= 0L) { GetSweepRewards(); }
/*     */       else if (!scheduleMap.containsKey(this.player.getId()))
/*     */       { ScheduledFuture<?> scheduledFuture = JobFactory.addDelayJob(this.timerTask, timeOffset); scheduleMap.put(this.player.getId(), scheduledFuture); }
/*     */        }
/* 120 */      } public void FinishSweepWhenSpeeping() { if (this.po.sweepEndTime == null) {
/* 121 */       Out.debug(new Object[] { "不在扫荡中" });
/*     */     }
/* 123 */     GetSweepRewards();
/* 124 */     ((ScheduledFuture)scheduleMap.get(this.player.getId())).cancel(false);
/* 125 */     scheduleMap.remove(this.player.getId()); }
/*     */   public int GetSecondToEndTime() { if (this.po.sweepEndTime != null) {
/*     */       Date now = new Date(); return (int)((this.po.sweepEndTime.getTime() - now.getTime()) / 1000L);
/*     */     }  return 0; }
/*     */   public void StartToSweep(int sweepTime) { if (this.po.sweepCountLeft <= 0) {
/*     */       Out.error(new Object[] { "没有扫荡次数！" }); return;
/* 131 */     }  this.po.sweepCountLeft--; Date now = new Date(); Calendar calendar = Calendar.getInstance(); calendar.setTime(now); calendar.add(13, sweepTime); this.po.sweepEndTime = calendar.getTime(); ScheduledFuture<?> scheduledFuture = JobFactory.addDelayJob(this.timerTask, (sweepTime * 1000)); scheduleMap.put(this.player.getId(), scheduledFuture); this.player.dailyActivityMgr.onEvent(Const.DailyType.DEMON_TOWER, "0", 1); } public void FinishSweep() { if (this.po.sweepEndTime != null) {
/* 132 */       Out.debug(new Object[] { "在扫荡中" });
/*     */     }
/* 134 */     GetSweepRewards();
/*     */     
/* 136 */     this.player.dailyActivityMgr.onEvent(Const.DailyType.DEMON_TOWER, "0", 1); }
/*     */ 
/*     */ 
/*     */   
/*     */   public HashMap<String, Integer> ComputeSweepRewards() {
/* 141 */     HashMap<String, Integer> rewardMap = new HashMap<>();
/*     */     
/* 143 */     if (this.po.maxFloor == 1) {
/* 144 */       return rewardMap;
/*     */     }
/* 146 */     for (int i = 1; i < this.po.maxFloor; i++) {
/* 147 */       DropListExt dropListExt = (DropListExt)GameData.DropLists.get(Integer.valueOf(i));
/*     */       
/* 149 */       for (Map.Entry<String, Integer> entry : (Iterable<Map.Entry<String, Integer>>)dropListExt.rewardPreview.entrySet()) {
/* 150 */         if (!rewardMap.containsKey(entry.getKey()))
/* 151 */           rewardMap.put(entry.getKey(), Integer.valueOf(0)); 
/* 152 */         rewardMap.put(entry.getKey(), Integer.valueOf(((Integer)rewardMap.get(entry.getKey())).intValue() + ((Integer)entry.getValue()).intValue()));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 157 */     return rewardMap;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void GetSweepRewards() {
/* 163 */     HashMap<String, Integer> rewardMap = ComputeSweepRewards();
/*     */     
/* 165 */     for (String code : rewardMap.keySet()) {
/* 166 */       this.player.bag.addCodeItem(code, ((Integer)rewardMap.get(code)).intValue(), Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.DemonTower);
/*     */     }
/*     */ 
/*     */     
/* 170 */     this.po.sweepEndTime = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void UpdateSweepCount() {
/* 175 */     this.po.sweepCountLeft = 1;
/*     */   }
/*     */   
/*     */   public void refreshNewDay() {
/* 179 */     Calendar calendar = Calendar.getInstance();
/* 180 */     calendar.setTime(new Date());
/* 181 */     if (calendar.get(7) == 2) {
/* 182 */       DemonTowerService.getInstance().dispatchWeekReward(this.player);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Common.DemonTowerFloorInfo.Builder getFloorInfoBuilder(int floorId) {
/* 189 */     Common.DemonTowerFloorInfo.Builder floorInfoBuilder = Common.DemonTowerFloorInfo.newBuilder();
/* 190 */     floorInfoBuilder.setFloorId(floorId);
/*     */     
/* 192 */     String firstPlayerId = null;
/* 193 */     Date firstPlayerDate = null;
/* 194 */     String fastPlayerId = null;
/* 195 */     Long fastPlayerTime = null;
/* 196 */     synchronized ((DemonTowerService.getInstance()).demonTowerCenterPO) {
/* 197 */       firstPlayerId = (DemonTowerService.getInstance()).demonTowerCenterPO.firstPlayerIds.get(floorId - 1);
/* 198 */       firstPlayerDate = (DemonTowerService.getInstance()).demonTowerCenterPO.firstPlayerDates.get(floorId - 1);
/* 199 */       fastPlayerId = (DemonTowerService.getInstance()).demonTowerCenterPO.fastPlayerIds.get(floorId - 1);
/* 200 */       fastPlayerTime = (DemonTowerService.getInstance()).demonTowerCenterPO.fastPlayerTimes.get(floorId - 1);
/*     */     } 
/*     */ 
/*     */     
/* 204 */     if (firstPlayerId != null) {
/* 205 */       PlayerPO playerPO = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, firstPlayerId, PlayerPO.class);
/* 206 */       if (playerPO != null) {
/* 207 */         floorInfoBuilder.setFirstPlayerName(playerPO.name);
/* 208 */         floorInfoBuilder.setFirstPlayerDate(firstPlayerDate.getTime());
/*     */       }
/*     */       else {
/*     */         
/* 212 */         DemonTowerService.getInstance().clearFirstData(floorId);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 218 */     if (fastPlayerId != null) {
/* 219 */       PlayerPO playerPO = (PlayerPO)PlayerPOManager.findPO(ConstsTR.playerTR, fastPlayerId, PlayerPO.class);
/* 220 */       if (playerPO != null) {
/* 221 */         floorInfoBuilder.setFastPlayerName(playerPO.name);
/* 222 */         floorInfoBuilder.setFastPlayerTime(fastPlayerTime.intValue() / 1000);
/*     */       }
/*     */       else {
/*     */         
/* 226 */         DemonTowerService.getInstance().clearFastData(floorId);
/*     */       } 
/*     */     } 
/*     */     
/* 230 */     if (this.po.leastTimeList.size() >= floorId) {
/* 231 */       floorInfoBuilder.setMyFastTime(((Long)this.po.leastTimeList.get(floorId - 1)).intValue() / 1000);
/*     */     }
/*     */     
/* 234 */     return floorInfoBuilder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxFloor() {
/* 241 */     return this.po.maxFloor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSweepCountLeft() {
/* 248 */     return this.po.sweepCountLeft;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\activity\DemonTowerManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */