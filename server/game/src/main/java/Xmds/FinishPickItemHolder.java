/*    */ package Xmds;
/*    */ 
/*    */ import Ice.Object;
/*    */ import Ice.ObjectHolderBase;
/*    */ import IceInternal.Ex;
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
/*    */ public final class FinishPickItemHolder
/*    */   extends ObjectHolderBase<FinishPickItem>
/*    */ {
/*    */   public FinishPickItemHolder() {}
/*    */   
/*    */   public FinishPickItemHolder(FinishPickItem value) {
/* 33 */     this.value = (Object)value;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void patch(Object v) {
/* 39 */     if (v == null || v instanceof FinishPickItem) {
/*    */       
/* 41 */       this.value = v;
/*    */     }
/*    */     else {
/*    */       
/* 45 */       Ex.throwUOE(type(), v);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String type() {
/* 52 */     return FinishPickItem.ice_staticId();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\Xmds\FinishPickItemHolder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */