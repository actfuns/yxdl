/*    */ package com.wanniu.game.friend;
/*    */ 
/*    */ import com.wanniu.game.common.ConstsTR;
/*    */ import com.wanniu.game.poes.PlayerFriendsPO;
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
/*    */ public class FriendsCenter
/*    */ {
/*    */   private static FriendsCenter instance;
/*    */   private Map<String, FriendManager> friendsMgr;
/*    */   
/*    */   public static synchronized FriendsCenter getInstance() {
/* 21 */     if (null == instance) {
/* 22 */       instance = new FriendsCenter();
/*    */     }
/* 24 */     return instance;
/*    */   }
/*    */   
/*    */   private FriendsCenter() {
/* 28 */     this.friendsMgr = new HashMap<>();
/*    */   }
/*    */   
/*    */   public Map<String, FriendManager> getAllFriendMgr() {
/* 32 */     return this.friendsMgr;
/*    */   }
/*    */   
/*    */   public void onPlayerDisponse(String playerId) {
/* 36 */     this.friendsMgr.remove(playerId);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FriendManager getFriendsMgr(String playerId) {
/* 46 */     if (this.friendsMgr.containsKey(playerId)) {
/* 47 */       return this.friendsMgr.get(playerId);
/*    */     }
/*    */     
/* 50 */     PlayerFriendsPO po = (PlayerFriendsPO)PlayerPOManager.findPO(ConstsTR.player_friendsTR, playerId, PlayerFriendsPO.class);
/*    */     
/* 52 */     FriendManager friendMgr = new FriendManager(playerId, po);
/* 53 */     this.friendsMgr.put(playerId, friendMgr);
/* 54 */     return friendMgr;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, Object> friendAgreeApply(String selfId, String requestId) {
/* 64 */     FriendManager friendMgr = getFriendsMgr(selfId);
/* 65 */     return friendMgr.friendAgreeApply(requestId);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\friend\FriendsCenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */