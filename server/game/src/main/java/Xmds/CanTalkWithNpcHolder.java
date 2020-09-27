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
/*    */ public final class CanTalkWithNpcHolder
/*    */   extends ObjectHolderBase<CanTalkWithNpc>
/*    */ {
/*    */   public CanTalkWithNpcHolder() {}
/*    */   
/*    */   public CanTalkWithNpcHolder(CanTalkWithNpc value) {
/* 33 */     this.value = (Object)value;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void patch(Object v) {
/* 39 */     if (v == null || v instanceof CanTalkWithNpc) {
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
/* 52 */     return CanTalkWithNpc.ice_staticId();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\Xmds\CanTalkWithNpcHolder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */