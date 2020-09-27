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
/*    */ @GClientEvent("area.friendHandler.friendMessageListRequest")
/*    */ public class FriendMessageListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 24 */           FriendManager friendManager = player.getFriendManager();
/* 25 */           FriendHandler.FriendMessageListResponse.Builder rtData = friendManager.friendMessageList();
/* 26 */           rtData.setS2CCode(200);
/* 27 */           rtData.setS2CMsg(LangService.getValue("FRIEND_ADD_SUCCESS"));
/* 28 */           this.body.writeBytes(rtData.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\FriendMessageListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */