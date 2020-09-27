/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
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
/*    */ @GClientEvent("area.friendHandler.friendRefuceApplyRequest")
/*    */ public class FriendRefuceApplyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 22 */     FriendHandler.FriendRefuceApplyRequest msg = FriendHandler.FriendRefuceApplyRequest.parseFrom(this.pak.getRemaingBytes());
/* 23 */     final String requestId = msg.getC2SRequestId();
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           FriendHandler.FriendRefuceApplyResponse.Builder res = FriendHandler.FriendRefuceApplyResponse.newBuilder();
/* 28 */           FriendManager friendManager = player.getFriendManager();
/* 29 */           TreeMap<String, Object> rtData = friendManager.friendRefuseApply(requestId, player);
/* 30 */           boolean result = ((Boolean)rtData.get("result")).booleanValue();
/* 31 */           if (result) {
/* 32 */             res.setS2CCode(200);
/* 33 */             res.setS2CMsg(LangService.getValue("FRIEND_REFUSE_SUCCESS"));
/*    */           } else {
/*    */             
/* 36 */             res.setS2CCode(500);
/* 37 */             String info = (String)rtData.get("info");
/* 38 */             res.setS2CMsg(info);
/*    */           } 
/* 40 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\FriendRefuceApplyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */