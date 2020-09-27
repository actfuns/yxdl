/*    */ package com.wanniu.game.money;
/*    */ 
/*    */ import com.wanniu.game.item.VirtualItemType;
/*    */ import java.util.EnumMap;
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
/*    */ public class CostResult
/*    */ {
/*    */   private final boolean success;
/* 29 */   private final EnumMap<VirtualItemType, Integer> values = new EnumMap<>(VirtualItemType.class);
/*    */   
/*    */   public CostResult(boolean success) {
/* 32 */     this.success = success;
/*    */   }
/*    */   
/*    */   public boolean isSuccess() {
/* 36 */     return this.success;
/*    */   }
/*    */   
/*    */   public int getValue(VirtualItemType type) {
/* 40 */     return ((Integer)this.values.getOrDefault(type, Integer.valueOf(0))).intValue();
/*    */   }
/*    */   
/*    */   public CostResult addValue(VirtualItemType type, int value) {
/* 44 */     this.values.put(type, Integer.valueOf(value));
/* 45 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\money\CostResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */