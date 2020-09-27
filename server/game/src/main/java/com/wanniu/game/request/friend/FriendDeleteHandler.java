/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONObject;
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
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.friendHandler.friendDeleteRequest")
/*    */ public class FriendDeleteHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 23 */     FriendHandler.FriendDeleteRequest msg = FriendHandler.FriendDeleteRequest.parseFrom(this.pak.getRemaingBytes());
/* 24 */     final String friendId = msg.getC2SFriendId();
/* 25 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 28 */           FriendHandler.FriendDeleteResponse.Builder res = FriendHandler.FriendDeleteResponse.newBuilder();
/* 29 */           FriendManager friendManager = player.getFriendManager();
/* 30 */           JSONObject ret = friendManager.deleteFriend(friendId);
/* 31 */           if (ret.getIntValue("code") == 200) {
/* 32 */             res.setS2CCode(200);
/* 33 */             res.setS2CMsg(LangService.getValue("FRIEND_DEL_SUCCESS"));
/*    */           }
/* 35 */           else if (ret.getIntValue("code") == 500) {
/* 36 */             res.setS2CCode(500);
/* 37 */             res.setS2CMsg(LangService.getValue("FRIEND_NOT_EXIST"));
/*    */           } 
/* 39 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\FriendDeleteHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */