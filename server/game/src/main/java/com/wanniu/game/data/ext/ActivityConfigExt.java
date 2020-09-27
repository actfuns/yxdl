/*     */ package com.wanniu.game.data.ext;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.bag.WNBag;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.ActivityConfigCO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ 
/*     */ public class ActivityConfigExt
/*     */   extends ActivityConfigCO
/*     */ {
/*     */   public HashMap<Integer, ArrayList<WNBag.SimpleItemInfo>> costItems;
/*     */   public HashMap<Integer, ArrayList<WNBag.SimpleItemInfo>> RankReward;
/*     */   public int indexDay;
/*     */   public String condition;
/*     */   
/*     */   public void initProperty() {
/*  21 */     this.RankReward = new HashMap<>();
/*  22 */     this.costItems = new HashMap<>();
/*  23 */     if (this.mailID == 0) {
/*  24 */       Out.error(new Object[] { "ActivityConfig`s MailID == 0 ID:", Integer.valueOf(this.id) });
/*     */     }
/*  26 */     if (this.extend1 != null) {
/*  27 */       this.costItems.put(Integer.valueOf(0), parseString(this.extend1));
/*     */     }
/*  29 */     if (this.itemCode != null) {
/*  30 */       this.RankReward.put(Integer.valueOf(0), parseString(this.itemCode));
/*     */     } else {
/*  32 */       this.RankReward.put(Integer.valueOf(1), parseString(this.zSItemCode));
/*  33 */       this.RankReward.put(Integer.valueOf(2), parseString(this.cKItemCode));
/*  34 */       this.RankReward.put(Integer.valueOf(3), parseString(this.fSItemCode));
/*  35 */       this.RankReward.put(Integer.valueOf(4), parseString(this.lRItemCode));
/*  36 */       this.RankReward.put(Integer.valueOf(5), parseString(this.mSItemCode));
/*     */     } 
/*     */     
/*  39 */     if (StringUtil.isEmpty(this.notes1)) {
/*     */       return;
/*     */     }
/*  42 */     String[] notes = this.notes1.split("_");
/*  43 */     if (notes.length > 2) {
/*  44 */       String indexDay = notes[1];
/*  45 */       if (indexDay.equals("OneDay")) {
/*  46 */         this.indexDay = 1;
/*  47 */         this.condition = notes[2];
/*  48 */       } else if (indexDay.equals("TwoDay")) {
/*  49 */         this.indexDay = 2;
/*  50 */         this.condition = notes[2];
/*  51 */       } else if (indexDay.equals("ThreeDay")) {
/*  52 */         this.indexDay = 3;
/*  53 */         this.condition = notes[2];
/*  54 */       } else if (indexDay.equals("FourDay")) {
/*  55 */         this.indexDay = 4;
/*  56 */         this.condition = notes[2];
/*  57 */       } else if (indexDay.equals("FiveDay")) {
/*  58 */         this.indexDay = 5;
/*  59 */         this.condition = notes[2];
/*  60 */       } else if (indexDay.equals("SixDay")) {
/*  61 */         this.indexDay = 6;
/*  62 */         this.condition = notes[2];
/*  63 */       } else if (indexDay.equals("SevenDay")) {
/*  64 */         this.indexDay = 7;
/*  65 */         this.condition = notes[2];
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ActivityConfigItem
/*     */   {
/*     */     public String itemCode;
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
/*     */     public int itemNum;
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
/*     */     public Const.ForceType isBind;
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
/*     */   public ArrayList<WNBag.SimpleItemInfo> parseString(String itemCode) {
/* 142 */     ArrayList<WNBag.SimpleItemInfo> RankReward = new ArrayList<>();
/* 143 */     if (StringUtil.isEmpty(itemCode)) {
/* 144 */       return RankReward;
/*     */     }
/* 146 */     String[] rewards = itemCode.split(";");
/* 147 */     for (String ss : rewards) {
/* 148 */       String[] rw = ss.split(":");
/* 149 */       if (rw.length == 2) {
/* 150 */         WNBag.SimpleItemInfo item = new WNBag.SimpleItemInfo();
/* 151 */         item.itemCode = rw[0];
/* 152 */         item.itemNum = Integer.parseInt(rw[1]);
/* 153 */         item.forceType = Const.ForceType.BIND;
/* 154 */         RankReward.add(item);
/*     */       } 
/*     */     } 
/* 157 */     return RankReward;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\ActivityConfigExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */