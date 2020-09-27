/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.google.protobuf.ProtocolStringList;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.friend.FriendManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.FriendHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.friendHandler.concernAllFriendRequest")
/*    */ public class ConcernAllFriendHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     FriendHandler.ConcernAllFriendRequest msg = FriendHandler.ConcernAllFriendRequest.parseFrom(this.pak.getRemaingBytes());
/* 22 */     final ProtocolStringList friendIds = msg.getC2SFriendIdsList();
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           FriendHandler.ConcernAllFriendResponse.Builder res = FriendHandler.ConcernAllFriendResponse.newBuilder();
/* 27 */           FriendManager friendManager = player.getFriendManager();
/* 28 */           for (String s : friendIds) {
/* 29 */             friendManager.concernFriend(s, player);
/*    */           }
/* 31 */           res.setS2CCode(200);
/* 32 */           res.setS2CMsg("");
/* 33 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\ConcernAllFriendHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */