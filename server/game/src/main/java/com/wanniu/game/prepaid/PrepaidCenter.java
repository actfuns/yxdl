/*    */ package com.wanniu.game.prepaid;
/*    */ 
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.redis.GameDao;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PrepaidCenter
/*    */ {
/*    */   private static PrepaidCenter instance;
/*    */   
/*    */   public static synchronized PrepaidCenter getInstance() {
/* 17 */     if (instance == null) {
/* 18 */       instance = new PrepaidCenter();
/*    */     }
/* 20 */     return instance;
/*    */   }
/*    */   
/*    */   public PrepaidManager findPrepaid(String playerId) {
/* 24 */     WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
/* 25 */     if (player == null) {
/* 26 */       return new PrepaidManager(playerId);
/*    */     }
/* 28 */     return player.prepaidManager;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void update(String playerId, PrepaidManager manager) {
/* 35 */     GameDao.update(playerId, ConstsTR.prepaidNewTR, manager.po);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\prepaid\PrepaidCenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */