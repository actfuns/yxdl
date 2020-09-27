/*    */ package com.wanniu.game.player;
/*    */ 
/*    */ public class PlayerService
/*    */ {
/*    */   public void afterPlayerChangeName(WNPlayer player) {
/*  6 */     player.consignmentManager.afterPlayerChangeName();
/*  7 */     player.refreshBattlerServerBasic();
/*  8 */     player.rankManager.onChangeName();
/*  9 */     player.guildManager.onChangeName();
/*    */   }
/*    */   
/*    */   private PlayerService() {}
/*    */   
/*    */   private static class PlayerManagerHolder {
/* 15 */     public static final PlayerService INSTANCE = new PlayerService();
/*    */   }
/*    */   
/*    */   public static PlayerService getInstance() {
/* 19 */     return PlayerManagerHolder.INSTANCE;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\PlayerService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */