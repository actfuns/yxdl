/*     */ package com.wanniu.game.poes;
/*     */ 
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.game.DBTable;
/*     */ import com.wanniu.game.activity.ActivityManager;
/*     */ import com.wanniu.game.activity.po.LuckyAward;
/*     */ import com.wanniu.game.bag.WNBag;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.LimitTimeGiftCO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ @DBTable("player_activity")
/*     */ public class ActivityDataPO
/*     */   extends GEntity
/*     */ {
/*  79 */   public ArrayList<LuckyAward> luckyAwardContainer = new ArrayList<>();
/*  80 */   public Date refreshTime = new Date(0L);
/*  81 */   public HashMap<Integer, ActivityManager.RewardRecord> activityRewardRecorder = new HashMap<>();
/*  82 */   public HashMap<Integer, ActivityManager.RewardRecord> dailyRechargeRecorder = new HashMap<>();
/*  83 */   public HashMap<Integer, ActivityManager.RewardRecord> superPackageRecorder = new HashMap<>();
/*  84 */   public HashMap<Integer, HashMap<Integer, Integer>> activityInfo = new HashMap<>();
/*  85 */   public HashMap<Integer, WNBag.SimpleItemInfo> drawedContainer = new HashMap<>();
/*  86 */   public HashMap<Integer, Integer> recovery = new HashMap<>();
/*  87 */   public HashMap<Integer, Integer> recoveryHistory = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean daily_recharge_have_entered = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean super_pakage_have_enterd = false;
/*     */ 
/*     */ 
/*     */   
/* 101 */   public Map<Integer, Integer> daily_draw_forgerandom_map = new HashMap<>();
/* 102 */   public Map<Integer, Integer> daily_draw_forgerandom_map_add = new HashMap<>();
/*     */   
/* 104 */   public List<Integer> sevendayList = new LinkedList<>(); public ActivityDataPO() {
/* 105 */     for (int i = 0; i < 7; i++) {
/* 106 */       this.sevendayList.add(i, Integer.valueOf(0));
/*     */     }
/* 108 */     this.sevendayList.set(0, Integer.valueOf(1));
/*     */     
/* 110 */     this.timeLimitGiftTriggeredTimeMap = new HashMap<>();
/* 111 */     this.timeLimitGiftTriggeredIdMap = new HashMap<>();
/* 112 */     this.timeLimitGiftPushMap = new HashMap<>();
/* 113 */     this.timeLimitGiftBuyMap = new HashMap<>();
/* 114 */     for (LimitTimeGiftCO limitTimeGiftCO : GameData.LimitTimeGifts.values()) {
/* 115 */       this.timeLimitGiftPushMap.put(Integer.valueOf(limitTimeGiftCO.id), Integer.valueOf(0));
/* 116 */       if (!this.timeLimitGiftTriggeredTimeMap.containsKey(Integer.valueOf(limitTimeGiftCO.condition)))
/*     */       {
/* 118 */         this.timeLimitGiftTriggeredTimeMap.put(Integer.valueOf(limitTimeGiftCO.condition), null);
/*     */       }
/* 120 */       if (!this.timeLimitGiftTriggeredIdMap.containsKey(Integer.valueOf(limitTimeGiftCO.condition)))
/*     */       {
/* 122 */         this.timeLimitGiftTriggeredIdMap.put(Integer.valueOf(limitTimeGiftCO.condition), Integer.valueOf(-1));
/*     */       }
/* 124 */       this.timeLimitGiftBuyMap.put(Integer.valueOf(limitTimeGiftCO.id), Integer.valueOf(0));
/*     */     } 
/*     */   }
/*     */   
/*     */   public int buffTimes;
/*     */   public int daily_draw_free_time;
/*     */   public int daily_draw_free_time_add;
/*     */   public Map<Integer, Date> timeLimitGiftTriggeredTimeMap;
/*     */   public Map<Integer, Integer> timeLimitGiftTriggeredIdMap;
/*     */   public Map<Integer, Integer> timeLimitGiftPushMap;
/*     */   public Map<Integer, Integer> timeLimitGiftBuyMap;
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\ActivityDataPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */