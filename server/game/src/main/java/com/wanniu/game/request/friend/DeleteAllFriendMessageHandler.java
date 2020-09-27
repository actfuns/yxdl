/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.friend.FriendManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.FriendHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.friendHandler.deleteAllFriendMessageRequest")
/*    */ public class DeleteAllFriendMessageHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 23 */           FriendManager friendManager = player.getFriendManager();
/* 24 */           FriendHandler.DeleteAllFriendMessageResponse.Builder res = FriendHandler.DeleteAllFriendMessageResponse.newBuilder();
/* 25 */           friendManager.deleteFriendMessage();
/* 26 */           res.setS2CCode(200);
/* 27 */           res.setS2CMsg(LangService.getValue("FRIEND_DEL_SUCCESS"));
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\DeleteAllFriendMessageHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */