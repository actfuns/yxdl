/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.friend.FriendManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.FriendHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.friendHandler.friendApplyRequest")
/*    */ public class FriendApplyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 22 */     FriendHandler.FriendApplyRequest msg = FriendHandler.FriendApplyRequest.parseFrom(this.pak.getRemaingBytes());
/* 23 */     final String toPlayerId = msg.getC2SToPlayerId();
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           FriendHandler.FriendApplyResponse.Builder res = FriendHandler.FriendApplyResponse.newBuilder();
/* 28 */           FriendManager friendManager = player.getFriendManager();
/* 29 */           String result = friendManager.friendApply(toPlayerId, player);
/* 30 */           if (result == null) {
/* 31 */             player.getPlayerTasks().dealTaskEvent(Const.TaskType.ADD_FRIEND, 1);
/* 32 */             res.setS2CCode(200);
/* 33 */             res.setS2CMsg(LangService.getValue("FRIEND_SEND_MESSAGE"));
/*    */           } else {
/*    */             
/* 36 */             res.setS2CCode(500);
/* 37 */             res.setS2CMsg(result);
/*    */           } 
/* 39 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\FriendApplyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */