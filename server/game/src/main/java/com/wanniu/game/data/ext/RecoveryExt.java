/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.RecoveryCO;
/*    */ 
/*    */ public class RecoveryExt
/*    */   extends RecoveryCO {
/*    */   public int minLevel;
/*    */   public int maxLevel;
/*    */   
/*    */   public void initProperty() {
/* 11 */     String[] ls = this.level.split(":");
/* 12 */     this.minLevel = Integer.parseInt(ls[0]);
/* 13 */     this.maxLevel = Integer.parseInt(ls[1]);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\RecoveryExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */