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
/*    */ @GClientEvent("area.friendHandler.addBlackListRequest")
/*    */ public class AddBlackListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     FriendHandler.AddBlackListRequest msg = FriendHandler.AddBlackListRequest.parseFrom(this.pak.getRemaingBytes());
/* 22 */     final String blackListId = msg.getC2SBlackListId();
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           FriendHandler.AddBlackListResponse.Builder res = FriendHandler.AddBlackListResponse.newBuilder();
/* 27 */           FriendManager friendManager = player.getFriendManager();
/* 28 */           String info = friendManager.addBlackList(blackListId);
/* 29 */           if (info == null) {
/* 30 */             res.setS2CCode(200);
/* 31 */             res.setS2CMsg(LangService.getValue("FRIEND_ADD_SUCCESS"));
/*    */           } else {
/*    */             
/* 34 */             res.setS2CCode(500);
/* 35 */             res.setS2CMsg(info);
/*    */           } 
/* 37 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\AddBlackListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */