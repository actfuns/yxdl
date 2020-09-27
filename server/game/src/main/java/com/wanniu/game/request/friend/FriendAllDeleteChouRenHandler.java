/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.google.protobuf.ProtocolStringList;
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.friend.ChouRenManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.FriendHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.friendHandler.friendAllDeleteChouRenRequest")
/*    */ public class FriendAllDeleteChouRenHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 22 */     FriendHandler.FriendAllDeleteChouRenRequest msg = FriendHandler.FriendAllDeleteChouRenRequest.parseFrom(this.pak.getRemaingBytes());
/* 23 */     final ProtocolStringList chouRenIds = msg.getC2SChouRenIdsList();
/* 24 */     final ChouRenManager chouRenManager = player.getChouRenManager();
/* 25 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 29 */           for (String s : chouRenIds) {
/* 30 */             chouRenManager.deleteChouRenById(s);
/*    */           }
/* 32 */           FriendHandler.FriendAllDeleteChouRenResponse.Builder res = FriendHandler.FriendAllDeleteChouRenResponse.newBuilder();
/* 33 */           res.setS2CCode(200);
/* 34 */           res.setS2CMsg(LangService.getValue("FRIEND_DEL_SUCCESS"));
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\FriendAllDeleteChouRenHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */