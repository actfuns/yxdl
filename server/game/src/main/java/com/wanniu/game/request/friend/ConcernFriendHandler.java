/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.friend.FriendManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.TreeMap;
/*    */ import pomelo.area.FriendHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.friendHandler.concernFriendRequest")
/*    */ public class ConcernFriendHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     FriendHandler.ConcernFriendRequest msg = FriendHandler.ConcernFriendRequest.parseFrom(this.pak.getRemaingBytes());
/* 22 */     final String friendId = msg.getC2SFriendId();
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           FriendHandler.ConcernFriendResponse.Builder res = FriendHandler.ConcernFriendResponse.newBuilder();
/* 27 */           FriendManager friendManager = player.getFriendManager();
/* 28 */           TreeMap<String, Object> rtData = friendManager.concernFriend(friendId, player);
/* 29 */           boolean result = ((Boolean)rtData.get("result")).booleanValue();
/* 30 */           String info = (String)rtData.get("info");
/* 31 */           if (result) {
/* 32 */             res.setS2CCode(200);
/* 33 */             res.setS2CMsg(info);
/*    */           } else {
/*    */             
/* 36 */             res.setS2CCode(500);
/* 37 */             res.setS2CMsg(info);
/*    */           } 
/* 39 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\ConcernFriendHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */