/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.ItemIdConfigCO;
/*    */ import java.util.List;
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
/*    */ public class ItemIdConfigExt
/*    */   extends ItemIdConfigCO
/*    */ {
/*    */   private List<OrderRule> orderRules;
/*    */   
/*    */   public void initProperty() {}
/*    */   
/*    */   public static class OrderRule
/*    */   {
/*    */     public String orderKey;
/*    */     public int orderType;
/*    */     
/*    */     public OrderRule(String orderKey, int orderType) {
/* 44 */       this.orderKey = orderKey;
/* 45 */       this.orderType = orderType;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public String getKey() {
/* 51 */     return super.getKey();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\ItemIdConfigExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */