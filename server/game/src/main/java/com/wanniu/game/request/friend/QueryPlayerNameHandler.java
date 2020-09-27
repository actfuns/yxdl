/*    */ package com.wanniu.game.request.friend;
/*    */ 
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
/*    */ 
/*    */ @GClientEvent("area.friendHandler.queryPlayerNameRequest")
/*    */ public class QueryPlayerNameHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     FriendHandler.QueryPlayerNameRequest msg = FriendHandler.QueryPlayerNameRequest.parseFrom(this.pak.getRemaingBytes());
/* 21 */     final String strName = msg.getC2SStrName();
/* 22 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 25 */           FriendManager friendManager = player.getFriendManager();
/* 26 */           FriendHandler.QueryPlayerNameResponse.Builder rtData = friendManager.queryPlayerName(strName);
/* 27 */           this.body.writeBytes(rtData.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\QueryPlayerNameHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */