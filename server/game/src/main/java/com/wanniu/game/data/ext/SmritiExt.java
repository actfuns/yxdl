/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.SmritiCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class SmritiExt
/*    */   extends SmritiCO
/*    */ {
/*    */   private Map<String, Integer> needItems;
/*    */   
/*    */   public void initProperty() {
/* 14 */     Map<String, Integer> tpneedItems = new HashMap<>();
/* 15 */     if (!StringUtil.isEmpty(this.mateCode1) && this.mateCount1 > 0) {
/* 16 */       tpneedItems.put(this.mateCode1, Integer.valueOf(this.mateCount1));
/*    */     }
/* 18 */     if (!StringUtil.isEmpty(this.mateCode2) && this.mateCount2 > 0) {
/* 19 */       tpneedItems.put(this.mateCode2, Integer.valueOf(this.mateCount2));
/*    */     }
/* 21 */     if (!StringUtil.isEmpty(this.mateCode3) && this.mateCount3 > 0) {
/* 22 */       tpneedItems.put(this.mateCode3, Integer.valueOf(this.mateCount3));
/*    */     }
/* 24 */     this.needItems = tpneedItems;
/*    */   }
/*    */   
/*    */   public Map<String, Integer> getNeedItems() {
/* 28 */     return this.needItems;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\SmritiExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */