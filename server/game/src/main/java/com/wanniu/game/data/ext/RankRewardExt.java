/*     */ package com.wanniu.game.data.ext;
/*     */ 
/*     */ import com.wanniu.core.util.RandomUtil;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.RankRewardCO;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import java.util.ArrayList;
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
/*     */ public class RankRewardExt
/*     */   extends RankRewardCO
/*     */ {
/*     */   private List<GuildBossRandItem> list;
/*     */   private int totalPercent;
/*     */   
/*     */   public void initProperty() {
/*  38 */     int t1 = this.prob1 + this.prob2 + this.prob3;
/*  39 */     this.totalPercent = t1;
/*     */     
/*  41 */     List<GuildBossRandItem> tplist = new ArrayList<>();
/*  42 */     tplist.add(new GuildBossRandItem(this.prob1, this.randomReward1));
/*  43 */     tplist.add(new GuildBossRandItem(this.prob2, this.randomReward2));
/*  44 */     tplist.add(new GuildBossRandItem(this.prob3, this.randomReward3));
/*  45 */     tplist.add(new GuildBossRandItem(this.prob4, this.randomReward4));
/*  46 */     tplist.add(new GuildBossRandItem(this.prob5, this.randomReward5));
/*  47 */     this.list = tplist;
/*     */   }
/*     */   
/*     */   public List<NormalItem> getRandomReward() {
/*  51 */     boolean hasRate = RandomUtil.hasHitRate(10000, this.rankProb + this.dropProb);
/*  52 */     if (hasRate) {
/*  53 */       String itemStr = getRandomItem();
/*  54 */       return parseItems(itemStr);
/*     */     } 
/*  56 */     return null;
/*     */   }
/*     */   
/*     */   private String getRandomItem() {
/*  60 */     if (this.totalPercent <= 0 || this.list == null) {
/*  61 */       return null;
/*     */     }
/*  63 */     int pct = RandomUtil.randomValue(this.totalPercent);
/*  64 */     int totalCount = 0;
/*  65 */     for (GuildBossRandItem bean : this.list) {
/*  66 */       totalCount += bean.getRandomValue();
/*  67 */       if (totalCount > pct) {
/*  68 */         return bean.getReward();
/*     */       }
/*     */     } 
/*  71 */     return null;
/*     */   }
/*     */   
/*     */   public List<NormalItem> getList() {
/*  75 */     return parseItems(this.rankReward);
/*     */   }
/*     */   
/*     */   private List<NormalItem> parseItems(String itemStr) {
/*  79 */     if (!StringUtil.isEmpty(itemStr)) {
/*  80 */       List<NormalItem> tpList = new ArrayList<>();
/*  81 */       String[] items = itemStr.split(";");
/*  82 */       for (String oneItem : items) {
/*  83 */         String[] randomCounts = oneItem.split("[|]");
/*  84 */         String oneItemStr = randomCounts[0];
/*  85 */         String[] countStr = randomCounts[1].split("-");
/*  86 */         int begin = Integer.parseInt(countStr[0]);
/*  87 */         int end = Integer.parseInt(countStr[1]);
/*  88 */         int count = RandomUtil.getInt(begin, end);
/*  89 */         for (int i = 0; i < count; i++) {
/*  90 */           String[] item = oneItemStr.split(":");
/*  91 */           List<NormalItem> list = ItemUtil.createItemsByItemCode(item[0], Integer.parseInt(item[1]));
/*  92 */           if (list != null && !list.isEmpty()) {
/*  93 */             for (NormalItem ni : list) {
/*  94 */               ni.itemDb.isBind = Const.ForceType.BIND.getValue();
/*  95 */               tpList.add(ni);
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 101 */       return tpList;
/*     */     } 
/* 103 */     return null;
/*     */   }
/*     */   
/*     */   public static class GuildBossRandItem {
/*     */     public GuildBossRandItem(int randomValue, String reward) {
/* 108 */       this.randomValue = randomValue;
/* 109 */       this.reward = reward;
/*     */     }
/*     */     
/*     */     private int randomValue;
/*     */     private String reward;
/*     */     
/*     */     public int getRandomValue() {
/* 116 */       return this.randomValue;
/*     */     }
/*     */     
/*     */     public void setRandomValue(int randomValue) {
/* 120 */       this.randomValue = randomValue;
/*     */     }
/*     */     
/*     */     public String getReward() {
/* 124 */       return this.reward;
/*     */     }
/*     */     
/*     */     public void setReward(String reward) {
/* 128 */       this.reward = reward;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\RankRewardExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */