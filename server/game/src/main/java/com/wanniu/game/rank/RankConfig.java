/*    */ package com.wanniu.game.rank;
/*    */ 
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.RankListExt;
/*    */ 
/*    */ public class RankConfig
/*    */ {
/*    */   private static RankConfig instance;
/*    */   
/*    */   public static RankConfig getInstance() {
/* 11 */     if (instance == null) {
/* 12 */       instance = new RankConfig();
/*    */     }
/* 14 */     return instance;
/*    */   }
/*    */   
/*    */   public final RankListExt findListRankPropByRankID(int rankId) {
/* 18 */     for (RankListExt RankCO : GameData.RankLists.values()) {
/* 19 */       if (RankCO.rankID == rankId) {
/* 20 */         return RankCO;
/*    */       }
/*    */     } 
/* 23 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\RankConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */