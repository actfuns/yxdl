/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.achievement.AchievementServiceNew;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.ext.AchievementExt;
/*    */ import com.wanniu.game.friend.FriendsCenter;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import pomelo.area.FriendHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.friendHandler.friendAgreeApplyRequest")
/*    */ public class FriendAgreeApplyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 27 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 28 */     FriendHandler.FriendAgreeApplyRequest msg = FriendHandler.FriendAgreeApplyRequest.parseFrom(this.pak.getRemaingBytes());
/* 29 */     final String requestId = msg.getC2SRequestId();
/* 30 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 33 */           FriendHandler.FriendAgreeApplyResponse.Builder res = FriendHandler.FriendAgreeApplyResponse.newBuilder();
/* 34 */           Map<String, Object> rtData = FriendsCenter.getInstance().friendAgreeApply(player.getId(), requestId);
/* 35 */           boolean result = ((Boolean)rtData.get("result")).booleanValue();
/* 36 */           if (result) {
/* 37 */             player.getPlayerTasks().dealTaskEvent(Const.TaskType.ADD_FRIEND, 1);
/* 38 */             res.setS2CCode(200);
/* 39 */             res.setS2CMsg(LangService.getValue("FRIEND_ADD_SUCCESS"));
/*    */             
/* 41 */             AchievementServiceNew achievementService = AchievementServiceNew.getInstance();
/*    */             
/* 43 */             player.achievementManager.onFriendNumber(1);
/* 44 */             if (PlayerUtil.isOnline(requestId)) {
/* 45 */               (PlayerUtil.getOnlinePlayer(requestId)).achievementManager.onFriendNumber(1);
/*    */             } else {
/* 47 */               List<AchievementExt> achievementArray = achievementService.findByConditionType(Const.ACHIEVEMENT_CONDITION_TYPE.FRIENDS_NUM);
/* 48 */               if (achievementArray.size() > 0) {
/* 49 */                 AchievementServiceNew.OnFriendAchieveOfOfflinePlayer(1, achievementArray, requestId);
/*    */               }
/*    */             } 
/*    */           } else {
/*    */             
/* 54 */             res.setS2CCode(500);
/* 55 */             String info = (String)rtData.get("info");
/* 56 */             res.setS2CMsg(info);
/*    */           } 
/* 58 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\FriendAgreeApplyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */