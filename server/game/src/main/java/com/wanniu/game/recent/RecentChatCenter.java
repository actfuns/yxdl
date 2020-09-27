/*    */ package com.wanniu.game.recent;
/*    */ 
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.poes.RecentChatPO;
/*    */ import com.wanniu.redis.PlayerPOManager;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class RecentChatCenter
/*    */ {
/*    */   private static RecentChatCenter instance;
/* 21 */   private Map<String, RecentChatMgr> recentChatMgrs = new HashMap<>();
/*    */ 
/*    */   
/*    */   public static RecentChatCenter getInstance() {
/* 25 */     if (null == instance) {
/* 26 */       instance = new RecentChatCenter();
/*    */     }
/* 28 */     return instance;
/*    */   }
/*    */   
/*    */   public RecentChatMgr getRecentChatMgr(String playerId) {
/* 32 */     if (this.recentChatMgrs.containsKey(playerId)) {
/* 33 */       return this.recentChatMgrs.get(playerId);
/*    */     }
/*    */     
/* 36 */     RecentChatPO po = (RecentChatPO)PlayerPOManager.findPO(ConstsTR.playerRecentChatTR, playerId, RecentChatPO.class);
/* 37 */     RecentChatMgr recentChatMgr = new RecentChatMgr(playerId, po);
/* 38 */     this.recentChatMgrs.put(playerId, recentChatMgr);
/* 39 */     return recentChatMgr;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\recent\RecentChatCenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */