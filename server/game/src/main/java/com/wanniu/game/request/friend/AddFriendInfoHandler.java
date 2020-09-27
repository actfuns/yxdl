/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.friend.FriendManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import pomelo.area.FriendHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.friendHandler.addFriendInfoRequest")
/*    */ public class AddFriendInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 24 */           FriendHandler.AddFriendInfoResponse.Builder res = FriendHandler.AddFriendInfoResponse.newBuilder();
/* 25 */           FriendManager friendManager = player.getFriendManager();
/* 26 */           ArrayList<FriendHandler.PlayerInfo> rtData = friendManager.addFriendInfo(player.getLevel());
/* 27 */           res.setS2CCode(200);
/* 28 */           res.addAllData(rtData);
/* 29 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\AddFriendInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */