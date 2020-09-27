/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.friend.ChouRenManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.TreeMap;
/*    */ import pomelo.area.FriendHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.friendHandler.friendAddChouRenRequest")
/*    */ public class FriendAddChouRenHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     final ChouRenManager chouRenManager = player.getChouRenManager();
/* 22 */     FriendHandler.FriendAddChouRenRequest msg = FriendHandler.FriendAddChouRenRequest.parseFrom(this.pak.getRemaingBytes());
/* 23 */     final String chouRenId = msg.getC2SChouRenId();
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           TreeMap<String, Object> rtData = chouRenManager.add2ChouRenList(chouRenId);
/* 28 */           boolean result = ((Boolean)rtData.get("result")).booleanValue();
/* 29 */           FriendHandler.FriendAddChouRenResponse.Builder res = FriendHandler.FriendAddChouRenResponse.newBuilder();
/* 30 */           String info = (String)rtData.get("info");
/* 31 */           if (result) {
/* 32 */             res.setS2CCode(200);
/*    */           } else {
/*    */             
/* 35 */             res.setS2CCode(500);
/*    */           } 
/* 37 */           res.setS2CMsg(info);
/* 38 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\FriendAddChouRenHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */