/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.friend.ChouRenManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.FriendHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.friendHandler.friendDeleteChouRenRequest")
/*    */ public class FriendDeleteChouRenHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     FriendHandler.FriendDeleteChouRenRequest msg = FriendHandler.FriendDeleteChouRenRequest.parseFrom(this.pak.getRemaingBytes());
/* 22 */     final String chouRenId = msg.getC2SChouRenId();
/* 23 */     final ChouRenManager chouRenManager = player.getChouRenManager();
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           FriendHandler.FriendDeleteChouRenResponse.Builder res = FriendHandler.FriendDeleteChouRenResponse.newBuilder();
/* 28 */           boolean rtFlag = chouRenManager.deleteChouRenById(chouRenId);
/* 29 */           if (rtFlag) {
/* 30 */             res.setS2CCode(200);
/* 31 */             res.setS2CMsg(LangService.getValue("FRIEND_ADD_SUCCESS"));
/*    */           } else {
/*    */             
/* 34 */             res.setS2CCode(500);
/* 35 */             res.setS2CMsg(LangService.getValue("FRIEND_ADD_FAIL"));
/*    */           } 
/* 37 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\FriendDeleteChouRenHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */