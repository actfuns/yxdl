/*     */ package com.wanniu.game.area;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.base.MonsterBase;
/*     */ import com.wanniu.game.data.ext.MonsterRefreshExt;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.monster.MonsterConfig;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.MonsterDropPO;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.area.ItemHandler;
/*     */ import pomelo.item.ItemOuterClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DropManager
/*     */ {
/*     */   public WNPlayer player;
/*     */   private MonsterDropPO po;
/*     */   
/*     */   public DropManager(WNPlayer player, MonsterDropPO po) {
/*  36 */     this.player = player;
/*  37 */     if (po == null) {
/*  38 */       po = new MonsterDropPO();
/*     */     }
/*  40 */     this.po = po;
/*  41 */     PlayerPOManager.put(ConstsTR.monster_drop_infoTR, player.getId(), (GEntity)po);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canDrop(int bossId, Area area) {
/*  51 */     if (bossId == 0 || area.sceneType == Const.SCENE_TYPE.FIGHT_LEVEL.getValue()) {
/*  52 */       return true;
/*     */     }
/*     */     
/*  55 */     MonsterBase prop = MonsterConfig.getInstance().get(bossId);
/*  56 */     if (prop == null || prop.type < 4) {
/*  57 */       return true;
/*     */     }
/*  59 */     List<MonsterRefreshExt> refreshProps = GameData.findMonsterRefreshs(t -> 
/*  60 */         (t.monsterID == bossId && t.mapID == area.areaId));
/*     */     
/*  62 */     if (refreshProps == null || refreshProps.isEmpty()) {
/*  63 */       return true;
/*     */     }
/*  65 */     MonsterRefreshExt ext = refreshProps.get(0);
/*  66 */     if (ext.useType == 1) {
/*  67 */       int count = this.po.getTodayCount();
/*  68 */       return (count < GlobalConfig.Lords_MaxNumEveryday);
/*     */     } 
/*  70 */     return true;
/*     */   }
/*     */   
/*     */   public void sendJoinReward(int bossId, String bossName, List<MonsterRefreshExt> refreshProps) {
/*  74 */     if (refreshProps == null || refreshProps.isEmpty()) {
/*     */       return;
/*     */     }
/*  77 */     MonsterRefreshExt ext = refreshProps.get(0);
/*  78 */     sendJoinRward(bossName, ext.joinReward);
/*     */   }
/*     */   
/*     */   private void sendJoinRward(String name, Map<String, Integer> rankRewards) {
/*  82 */     if (rankRewards == null) {
/*     */       return;
/*     */     }
/*  85 */     List<ItemOuterClass.MiniItem> miniItem = new ArrayList<>();
/*  86 */     for (Map.Entry<String, Integer> attach : rankRewards.entrySet()) {
/*  87 */       miniItem.add(ItemUtil.getMiniItemData(attach.getKey(), ((Integer)attach.getValue()).intValue(), Const.ForceType.BIND).build());
/*     */     }
/*     */     
/*  90 */     if (!miniItem.isEmpty()) {
/*  91 */       ItemHandler.RewardItemPush.Builder data = ItemHandler.RewardItemPush.newBuilder();
/*  92 */       data.setS2CCode(200);
/*  93 */       data.addAllS2CItem(miniItem);
/*  94 */       this.player.receive("area.itemPush.rewardItemPush", (GeneratedMessage)data.build());
/*     */ 
/*     */       
/*  97 */       MailSysData mailData = new MailSysData("Lords_Reward_ForPartake");
/*  98 */       Map<String, String> replace = new HashMap<>();
/*  99 */       replace.put("name", name);
/* 100 */       mailData.replace = replace;
/* 101 */       mailData.attachments = new ArrayList();
/* 102 */       for (Map.Entry<String, Integer> attach : rankRewards.entrySet()) {
/* 103 */         MailData.Attachment item = new MailData.Attachment();
/* 104 */         item.itemCode = attach.getKey();
/* 105 */         item.itemNum = ((Integer)attach.getValue()).intValue();
/* 106 */         mailData.attachments.add(item);
/*     */       } 
/* 108 */       MailUtil.getInstance().sendMailToOnePlayer(this.player.getId(), (MailData)mailData, Const.GOODS_CHANGE_TYPE.BOSS_ASSISTS);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBossDead(int bossId) {
/* 118 */     if (bossId == 0) {
/*     */       return;
/*     */     }
/* 121 */     MonsterBase prop = MonsterConfig.getInstance().get(bossId);
/* 122 */     if (prop == null || prop.type < 4) {
/*     */       return;
/*     */     }
/* 125 */     this.po.addBossCount();
/*     */   }
/*     */   
/*     */   public void refreshNewDay() {
/* 129 */     if (this.po != null)
/* 130 */       this.po.clear(); 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\area\DropManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */