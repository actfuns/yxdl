/*    */ package com.wanniu.game.vip;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum VipFuncType
/*    */ {
/* 10 */   SINGLE_SCENE(1),
/* 11 */   TEAM_SCENE(2),
/* 12 */   SECRET_SCENE(3),
/* 13 */   SUPER_SCENE(4),
/* 14 */   SIN_COM(5),
/* 15 */   MONSTER_KILL_EXP(6),
/* 16 */   EVERY_SIGN(7),
/* 17 */   FAME_ADD(8),
/* 18 */   MONERY_TREE(9),
/* 19 */   CONSIGNMENT_STORE(10),
/* 20 */   BUY_SINGLE_SCENE(11),
/* 21 */   BUY_TEAM_SCENE(12),
/* 22 */   BUY_SUPER_SCENE(13);
/*    */   
/*    */   private int value;
/*    */   
/*    */   VipFuncType(int value) {
/* 27 */     this.value = value;
/*    */   }
/*    */   
/*    */   public int getValue() {
/* 31 */     return this.value;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\vip\VipFuncType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */