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
/*    */ public final class SkillDataICEHolder
/*    */   extends ObjectHolderBase<SkillDataICE>
/*    */ {
/*    */   public SkillDataICEHolder() {}
/*    */   
/*    */   public SkillDataICEHolder(SkillDataICE value) {
/* 33 */     this.value = (Object)value;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void patch(Object v) {
/* 39 */     if (v == null || v instanceof SkillDataICE) {
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
/* 52 */     return SkillDataICE.ice_staticId();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\Xmds\SkillDataICEHolder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */