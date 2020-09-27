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
/*    */ 
/*    */ @GClientEvent("area.friendHandler.deleteBlackListRequest")
/*    */ public class DeleteBlackListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     FriendHandler.DeleteBlackListRequest msg = FriendHandler.DeleteBlackListRequest.parseFrom(this.pak.getRemaingBytes());
/* 22 */     final String blackListId = msg.getC2SBlackListId();
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           FriendHandler.DeleteBlackListResponse.Builder res = FriendHandler.DeleteBlackListResponse.newBuilder();
/* 27 */           FriendManager friendManager = player.getFriendManager();
/* 28 */           boolean rtFlag = friendManager.deleteBlackListById(blackListId);
/* 29 */           if (rtFlag) {
/* 30 */             res.setS2CCode(200);
/* 31 */             res.setS2CMsg(LangService.getValue("FRIEND_DEL_SUCCESS"));
/*    */           } else {
/*    */             
/* 34 */             res.setS2CCode(500);
/* 35 */             res.setS2CMsg(LangService.getValue("FRIEND_DEL_FAIL"));
/*    */           } 
/* 37 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\DeleteBlackListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */