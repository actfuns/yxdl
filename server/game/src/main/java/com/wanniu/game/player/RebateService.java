/*    */ package com.wanniu.game.player;
/*    */ 
/*    */ import com.wanniu.game.GWorld;
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
/*    */ public class RebateService
/*    */ {
/* 24 */   private static final RebateService instance = new RebateService();
/*    */   
/*    */   public static RebateService getInstance() {
/* 27 */     return instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void ansycCheckRebate(WNPlayer player) {
/* 34 */     GWorld.getInstance().ansycExec(new RebateCheckTask(player));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\RebateService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */