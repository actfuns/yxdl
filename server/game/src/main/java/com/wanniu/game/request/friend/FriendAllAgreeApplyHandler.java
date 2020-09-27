/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.google.protobuf.ProtocolStringList;
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.friend.FriendManager;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import java.util.TreeMap;
/*    */ import pomelo.area.FriendHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.friendHandler.friendAllAgreeApplyRequest")
/*    */ public class FriendAllAgreeApplyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 25 */     FriendHandler.FriendAllAgreeApplyRequest msg = FriendHandler.FriendAllAgreeApplyRequest.parseFrom(this.pak.getRemaingBytes());
/* 26 */     final ProtocolStringList requestIds = msg.getC2SRequestIdsList();
/* 27 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 30 */           FriendHandler.FriendAllAgreeApplyResponse.Builder res = FriendHandler.FriendAllAgreeApplyResponse.newBuilder();
/* 31 */           FriendManager friendManager = player.getFriendManager();
/* 32 */           TreeMap<String, Object> rtData = friendManager.friendAllAgreeApply(requestIds, player);
/* 33 */           boolean result = ((Boolean)rtData.get("result")).booleanValue();
/* 34 */           if (result) {
/* 35 */             player.getPlayerTasks().dealTaskEvent(Const.TaskType.ADD_FRIEND, requestIds.size());
/* 36 */             res.setS2CCode(200);
/* 37 */             res.setS2CMsg(LangService.getValue("FRIEND_ADD_SUCCESS"));
/*    */ 
/*    */             
/* 40 */             player.achievementManager.onFriendNumber(requestIds.size());
/* 41 */             for (String requestId : requestIds) {
/* 42 */               if (PlayerUtil.isOnline(requestId)) {
/* 43 */                 (PlayerUtil.getOnlinePlayer(requestId)).achievementManager.onFriendNumber(1);
/*    */               }
/*    */             }
/*    */           
/*    */           }
/*    */           else {
/*    */             
/* 50 */             res.setS2CCode(500);
/* 51 */             String info = (String)rtData.get("info");
/* 52 */             res.setS2CMsg(info);
/*    */           } 
/* 54 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\FriendAllAgreeApplyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */