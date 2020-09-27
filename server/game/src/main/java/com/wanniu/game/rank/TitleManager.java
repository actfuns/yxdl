/*     */ package com.wanniu.game.rank;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.msg.WNNotifyManager;
/*     */ import com.wanniu.game.data.ext.RankListExt;
/*     */ import com.wanniu.game.player.AttributeUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.TitlePO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import pomelo.area.RankHandler;
/*     */ 
/*     */ public class TitleManager {
/*     */   public WNPlayer player;
/*     */   public TitlePO titlePO;
/*     */   
/*     */   public static class AwardRankData {
/*     */     public int id;
/*     */     public long gotTime;
/*     */     
/*     */     public AwardRankData() {}
/*     */     
/*     */     public AwardRankData(int id, long gotTime) {
/*  26 */       this.id = id;
/*  27 */       this.gotTime = gotTime;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class RankBiData
/*     */   {
/*     */     public TreeMap<String, Integer> all;
/*     */     
/*     */     public TreeMap<String, Integer> single;
/*     */   }
/*     */   
/*     */   public TitleManager(WNPlayer player, TitlePO titlePO) {
/*  40 */     this.player = player;
/*  41 */     this.titlePO = titlePO;
/*     */   }
/*     */   
/*     */   public int getSelectedRankId() {
/*  45 */     return this.titlePO.selectedRankId;
/*     */   }
/*     */   
/*     */   public final int getTitleId() {
/*  49 */     return this.titlePO.selectedRankId;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void showRank() {
/*  54 */     this.player.refreshBattlerServerBasic();
/*     */   }
/*     */   
/*     */   public final ArrayList<RankHandler.AwardRank.Builder> getRankInfo() {
/*  58 */     checkInvalidRanks(true);
/*  59 */     ArrayList<RankHandler.AwardRank.Builder> list = new ArrayList<>();
/*  60 */     for (Map.Entry<Integer, AwardRankData> node : (Iterable<Map.Entry<Integer, AwardRankData>>)this.titlePO.awardRanks.entrySet()) {
/*  61 */       AwardRankData each = node.getValue();
/*  62 */       RankListExt prop = RankConfig.getInstance().findListRankPropByRankID(each.id);
/*  63 */       long validTime = (prop != null) ? (1L * prop.validTime * 60L * 60L * 1000L) : 0L;
/*     */       
/*  65 */       int invalidTime = 0;
/*  66 */       if (validTime > 0L) {
/*  67 */         invalidTime = (int)Math.floor(((each.gotTime + validTime) / 1000L));
/*     */       }
/*  69 */       RankHandler.AwardRank.Builder rank = RankHandler.AwardRank.newBuilder();
/*  70 */       rank.setId(each.id);
/*  71 */       rank.setInvalidTime(invalidTime);
/*  72 */       list.add(rank);
/*     */     } 
/*  74 */     return list;
/*     */   }
/*     */   
/*     */   public final void saveRank(int selectedRankId) {
/*  78 */     if (this.titlePO.awardRanks.containsKey(Integer.valueOf(selectedRankId))) {
/*  79 */       this.titlePO.selectedRankId = selectedRankId;
/*  80 */       showRank();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void onAwardRank(int rankId) {
/*  90 */     RankListExt prop = RankConfig.getInstance().findListRankPropByRankID(rankId);
/*  91 */     if (prop == null) {
/*  92 */       Out.error(new Object[] { "there is no data of RankID: ", Integer.valueOf(rankId), " in rankListProps " });
/*     */       return;
/*     */     } 
/*  95 */     long gotTime = System.currentTimeMillis();
/*  96 */     this.titlePO.awardRanks.put(Integer.valueOf(rankId), new AwardRankData(rankId, gotTime));
/*  97 */     if (this.titlePO.selectedRankId == 0) {
/*  98 */       this.titlePO.selectedRankId = rankId;
/*     */       
/* 100 */       this.player.refreshBattlerServerBasic();
/*     */     } 
/*     */     
/* 103 */     RankBiData biData = biGetInfluence(rankId);
/*     */ 
/*     */     
/* 106 */     pushAndRefreshRankInflu(true);
/* 107 */     WNNotifyManager.getInstance().pushAwardRank(this.player, rankId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void pushAndRefreshRankInflu(boolean refresh) {
/* 114 */     this.player.updateTitleAttrs();
/* 115 */     this.player.initAndCalAllInflu(null);
/* 116 */     if (refresh) {
/* 117 */       this.player.refreshBattlerServerEffect(false);
/*     */     }
/* 119 */     this.player.pushEffectData();
/*     */   }
/*     */   
/*     */   public final void refreshNewDay() {
/* 123 */     checkInvalidRanks(true);
/*     */   }
/*     */   
/*     */   public final void checkInvalidRanks(boolean refresh) {
/* 127 */     boolean needUpdate = false;
/* 128 */     if (null != this.titlePO.awardRanks) {
/* 129 */       Iterator<Map.Entry<Integer, AwardRankData>> iter = this.titlePO.awardRanks.entrySet().iterator();
/* 130 */       while (iter.hasNext()) {
/* 131 */         Map.Entry<Integer, AwardRankData> entry = iter.next();
/* 132 */         AwardRankData each = entry.getValue();
/* 133 */         if (null == each) {
/*     */           continue;
/*     */         }
/* 136 */         RankListExt prop = RankConfig.getInstance().findListRankPropByRankID(each.id);
/* 137 */         if (prop != null && prop.validTime > 0) {
/* 138 */           long validTime = 1L * prop.validTime * 60L * 60L * 1000L;
/* 139 */           long invalidTime = each.gotTime + validTime;
/* 140 */           long currTime = System.currentTimeMillis();
/* 141 */           if (currTime >= invalidTime) {
/* 142 */             iter.remove();
/* 143 */             needUpdate = true;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 149 */     if (this.titlePO.selectedRankId != 0 && !this.titlePO.awardRanks.containsKey(Integer.valueOf(this.titlePO.selectedRankId))) {
/* 150 */       this.titlePO.selectedRankId = 0;
/* 151 */       if (refresh)
/*     */       {
/* 153 */         this.player.refreshBattlerServerBasic();
/*     */       }
/*     */     } 
/* 156 */     if (needUpdate) {
/* 157 */       pushAndRefreshRankInflu(refresh);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final TreeMap<String, Integer> calAllInfluence() {
/* 165 */     TreeMap<String, Integer> data = new TreeMap<>();
/* 166 */     for (Map.Entry<Integer, AwardRankData> node : (Iterable<Map.Entry<Integer, AwardRankData>>)this.titlePO.awardRanks.entrySet()) {
/* 167 */       AwardRankData each = node.getValue();
/* 168 */       RankListExt prop = RankConfig.getInstance().findListRankPropByRankID(each.id);
/* 169 */       if (prop != null) {
/* 170 */         Map<String, Integer> rankAttrs = prop.rankAttrs;
/* 171 */         for (Map.Entry<String, Integer> atts : rankAttrs.entrySet()) {
/* 172 */           if (data.containsKey(atts.getKey())) {
/* 173 */             int value = ((Integer)atts.getValue()).intValue() + ((Integer)data.get(atts.getKey())).intValue();
/* 174 */             data.put(atts.getKey(), Integer.valueOf(value)); continue;
/*     */           } 
/* 176 */           data.put(atts.getKey(), atts.getValue());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 181 */     return data;
/*     */   }
/*     */   
/*     */   private final RankBiData biGetInfluence(int rankId) {
/* 185 */     RankBiData data = new RankBiData();
/* 186 */     data.all = new TreeMap<>();
/* 187 */     data.single = new TreeMap<>();
/* 188 */     for (Map.Entry<Integer, AwardRankData> node : (Iterable<Map.Entry<Integer, AwardRankData>>)this.titlePO.awardRanks.entrySet()) {
/* 189 */       AwardRankData each = node.getValue();
/* 190 */       RankListExt prop = RankConfig.getInstance().findListRankPropByRankID(each.id);
/* 191 */       if (prop != null) {
/* 192 */         Map<String, Integer> rankAttrs = prop.rankAttrs;
/* 193 */         for (Map.Entry<String, Integer> atts : rankAttrs.entrySet()) {
/* 194 */           String name = AttributeUtil.getNameByKey(atts.getKey());
/* 195 */           if (data.all.containsKey(name)) {
/* 196 */             int value = ((Integer)data.all.get(name)).intValue();
/* 197 */             value += ((Integer)atts.getValue()).intValue();
/* 198 */             data.all.put(name, Integer.valueOf(value));
/*     */           } else {
/* 200 */             data.all.put(name, atts.getValue());
/*     */           } 
/* 202 */           if (rankId == each.id) {
/* 203 */             if (data.single.containsKey(name)) {
/* 204 */               int value = ((Integer)data.single.get(name)).intValue();
/* 205 */               value += ((Integer)atts.getValue()).intValue();
/* 206 */               data.single.put(name, Integer.valueOf(value)); continue;
/*     */             } 
/* 208 */             data.single.put(name, atts.getValue());
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 214 */     return data;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int calFightPower() {
/* 219 */     TreeMap<String, Integer> allInflus = calAllInfluence();
/*     */ 
/*     */     
/* 222 */     int fightPower = 0;
/* 223 */     return fightPower;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\TitleManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */