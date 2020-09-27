/*    */ package com.wanniu.game.onlineGift;
/*    */ 
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.OlGiftExt;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class OlGiftConfig
/*    */ {
/*    */   private static OlGiftConfig instance;
/*    */   private Map<Integer, OlGiftExt> olgTable;
/*    */   
/*    */   public static OlGiftConfig getInstance() {
/* 15 */     if (instance == null) {
/* 16 */       instance = new OlGiftConfig();
/*    */     }
/* 18 */     return instance;
/*    */   }
/*    */   
/*    */   private OlGiftConfig() {
/* 22 */     this.olgTable = GameData.OlGifts;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<OlGiftExt> getPropList() {
/* 29 */     return new ArrayList<>(this.olgTable.values());
/*    */   }
/*    */ 
/*    */   
/*    */   public OlGiftExt getPropById(int olgId) {
/* 34 */     if (this.olgTable.containsKey(Integer.valueOf(olgId))) {
/* 35 */       return this.olgTable.get(Integer.valueOf(olgId));
/*    */     }
/* 37 */     return null;
/*    */   }
/*    */   
/*    */   public List<OlGiftExt> getPropListByLevel(int giftType, int upLevel, int level) {
/* 41 */     List<OlGiftExt> lstOlg = new ArrayList<>();
/* 42 */     for (OlGiftExt gift : this.olgTable.values()) {
/* 43 */       if (giftType != gift.type) {
/*    */         continue;
/*    */       }
/*    */       
/* 47 */       if ((upLevel > 0) ? (
/* 48 */         upLevel < gift.downOrder || upLevel > gift.upOrder) : (
/*    */ 
/*    */ 
/*    */         
/* 52 */         level < gift.lvDown || level > gift.lvUp)) {
/*    */         continue;
/*    */       }
/*    */       
/* 56 */       lstOlg.add(gift);
/*    */     } 
/* 58 */     return lstOlg;
/*    */   }
/*    */ 
/*    */   
/*    */   public OlGiftExt getPropByLevelAndTime(int upLevel, int level, int time) {
/* 63 */     for (OlGiftExt gift : this.olgTable.values()) {
/* 64 */       if (gift.upOrder == upLevel && gift.time == time) {
/* 65 */         if (upLevel == 0 && 
/* 66 */           gift.lvDown <= level && gift.lvUp >= level) {
/* 67 */           return gift;
/*    */         }
/*    */         
/* 70 */         return gift;
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 75 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\onlineGift\OlGiftConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */