/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.google.protobuf.ProtocolStringList;
/*    */ import com.wanniu.core.game.LangService;
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
/*    */ @GClientEvent("area.friendHandler.friendAllRefuceApplyRequest")
/*    */ public class FriendAllRefuceApplyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 22 */     FriendHandler.FriendAllRefuceApplyRequest msg = FriendHandler.FriendAllRefuceApplyRequest.parseFrom(this.pak.getRemaingBytes());
/* 23 */     final ProtocolStringList requestIds = msg.getC2SRequestIdsList();
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           FriendHandler.FriendAllRefuceApplyResponse.Builder res = FriendHandler.FriendAllRefuceApplyResponse.newBuilder();
/* 28 */           FriendManager friendManager = player.getFriendManager();
/* 29 */           for (String s : requestIds) {
/* 30 */             friendManager.friendRefuseApply(s, player);
/*    */           }
/* 32 */           res.setS2CCode(200);
/* 33 */           res.setS2CMsg(LangService.getValue("FRIEND_REFUSE_SUCCESS"));
/* 34 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\FriendAllRefuceApplyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */