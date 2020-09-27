/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import java.util.Date;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @DBTable("player_shop_mall")
/*    */ public final class ShopMallPO
/*    */   extends GEntity
/*    */ {
/*    */   public Map<Integer, Map<Integer, Boolean>> seenTab;
/* 29 */   public Map<String, Integer> dayMallItemNums = new HashMap<>();
/* 30 */   public Map<String, Integer> weekMallItemNums = new HashMap<>();
/* 31 */   public Map<String, Integer> dayMallExchangeItemNums = new HashMap<>();
/* 32 */   public Map<String, Integer> weekMallExchangeItemNums = new HashMap<>();
/* 33 */   public Map<String, Integer> totalMallExchangeItemNums = new HashMap<>();
/*    */   public Date resetTime;
/*    */   
/*    */   public ShopMallPO(Map<Integer, Map<Integer, Boolean>> seenTab) {
/* 37 */     this();
/* 38 */     this.seenTab = seenTab;
/*    */   }
/*    */   
/*    */   public ShopMallPO() {}
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\ShopMallPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */