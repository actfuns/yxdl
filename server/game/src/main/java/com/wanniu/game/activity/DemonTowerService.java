/*     */ package com.wanniu.game.activity;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.DropListExt;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.DemonTowerCenterPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.LinkedList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DemonTowerService
/*     */ {
/*     */   static DemonTowerService demonTowerService;
/*     */   public DemonTowerCenterPO demonTowerCenterPO;
/*     */   
/*     */   public static DemonTowerService getInstance() {
/*  47 */     if (demonTowerService == null) {
/*  48 */       demonTowerService = new DemonTowerService();
/*     */     }
/*  50 */     return demonTowerService;
/*     */   }
/*     */   
/*     */   public void init() {
/*  54 */     String data = GCache.hget(Integer.toString(GWorld.__SERVER_ID), ConstsTR.DemonTower.value);
/*  55 */     if (data == null) {
/*  56 */       this.demonTowerCenterPO = new DemonTowerCenterPO();
/*  57 */       GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.DemonTower.value, JSON.toJSONString(this.demonTowerCenterPO));
/*     */     } else {
/*     */       
/*  60 */       this.demonTowerCenterPO = (DemonTowerCenterPO)JSON.parseObject(data, DemonTowerCenterPO.class);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean finishFloor(int floorId, String playerId, long time) {
/*  67 */     boolean refreshRechord = false;
/*  68 */     synchronized (this.demonTowerCenterPO) {
/*  69 */       if (this.demonTowerCenterPO.firstPlayerIds.get(floorId - 1) == null) {
/*  70 */         this.demonTowerCenterPO.firstPlayerIds.set(floorId - 1, playerId);
/*  71 */         this.demonTowerCenterPO.firstPlayerDates.set(floorId - 1, new Date());
/*     */       } 
/*     */ 
/*     */       
/*  75 */       if (this.demonTowerCenterPO.fastPlayerTimes.get(floorId - 1) == null || ((Long)this.demonTowerCenterPO.fastPlayerTimes
/*  76 */         .get(floorId - 1)).longValue() > time) {
/*  77 */         this.demonTowerCenterPO.fastPlayerIds.set(floorId - 1, playerId);
/*  78 */         this.demonTowerCenterPO.fastPlayerTimes.set(floorId - 1, Long.valueOf(time));
/*  79 */         refreshRechord = true;
/*     */       } 
/*     */       
/*  82 */       GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.DemonTower.value, JSON.toJSONString(this.demonTowerCenterPO));
/*     */     } 
/*  84 */     return refreshRechord;
/*     */   }
/*     */   
/*     */   public void clearFirstData(int floorId) {
/*  88 */     synchronized (this.demonTowerCenterPO) {
/*  89 */       if (this.demonTowerCenterPO.firstPlayerIds.get(floorId - 1) == null) {
/*  90 */         this.demonTowerCenterPO.firstPlayerIds.set(floorId - 1, null);
/*  91 */         this.demonTowerCenterPO.firstPlayerDates.set(floorId - 1, null);
/*     */         
/*  93 */         GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.DemonTower.value, JSON.toJSONString(this.demonTowerCenterPO));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void clearFastData(int floorId) {
/*  99 */     synchronized (this.demonTowerCenterPO) {
/* 100 */       if (this.demonTowerCenterPO.fastPlayerTimes.get(floorId - 1) == null) {
/* 101 */         this.demonTowerCenterPO.fastPlayerIds.set(floorId - 1, null);
/* 102 */         this.demonTowerCenterPO.fastPlayerTimes.set(floorId - 1, null);
/* 103 */         GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.DemonTower.value, JSON.toJSONString(this.demonTowerCenterPO));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void clearAllData() {
/* 109 */     this.demonTowerCenterPO.firstPlayerIds = new LinkedList();
/* 110 */     this.demonTowerCenterPO.firstPlayerDates = new LinkedList();
/* 111 */     this.demonTowerCenterPO.fastPlayerIds = new LinkedList();
/* 112 */     this.demonTowerCenterPO.fastPlayerTimes = new LinkedList();
/* 113 */     for (DropListExt dropListExt : GameData.DropLists.values()) {
/* 114 */       this.demonTowerCenterPO.firstPlayerIds.add(null);
/* 115 */       this.demonTowerCenterPO.firstPlayerDates.add(null);
/* 116 */       this.demonTowerCenterPO.fastPlayerIds.add(null);
/* 117 */       this.demonTowerCenterPO.fastPlayerTimes.add(null);
/*     */     } 
/*     */     
/* 120 */     GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.DemonTower.value, JSON.toJSONString(this.demonTowerCenterPO));
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
/*     */   public void dispatchWeekReward(WNPlayer player) {
/* 156 */     List<NormalItem> items = new LinkedList<>();
/*     */     
/* 158 */     synchronized (this.demonTowerCenterPO) {
/* 159 */       for (int i = 0; i < this.demonTowerCenterPO.fastPlayerIds.size(); i++) {
/* 160 */         String pid = this.demonTowerCenterPO.fastPlayerIds.get(i);
/* 161 */         if (pid != null && 
/* 162 */           pid.equals(player.getId())) {
/* 163 */           DropListExt dropListExt = (DropListExt)GameData.DropLists.get(Integer.valueOf(i + 1));
/* 164 */           List<NormalItem> item = ItemUtil.createItemsByItemCode(dropListExt.weekRewardPreview);
/* 165 */           items.addAll(item);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 172 */     MailSysData mailData = new MailSysData("DemonTowerFastRecordReward");
/* 173 */     List<MailData.Attachment> list_attach = new ArrayList<>();
/* 174 */     for (NormalItem item : items) {
/*     */       
/* 176 */       if (item.isVirtual()) {
/* 177 */         player.bag.addEntityItem(item, Const.GOODS_CHANGE_TYPE.DemonTower); continue;
/*     */       } 
/* 179 */       MailData.Attachment attachment = new MailData.Attachment();
/* 180 */       attachment.itemCode = item.itemCode();
/* 181 */       attachment.itemNum = item.getNum();
/* 182 */       list_attach.add(attachment);
/*     */     } 
/*     */     
/* 185 */     if (list_attach.size() > 0) {
/* 186 */       mailData.attachments = list_attach;
/* 187 */       MailUtil.getInstance().sendMailToOnePlayer(player.getId(), (MailData)mailData, Const.GOODS_CHANGE_TYPE.DemonTower);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\activity\DemonTowerService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */