/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.recent.RecentChatMgr;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.FriendHandler;
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.friendHandler.rmChatMsgRequest")
/*    */ public class RmChatMsgHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 18 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 19 */     final FriendHandler.RmChatMsgRequest req = FriendHandler.RmChatMsgRequest.parseFrom(this.pak.getRemaingBytes());
/* 20 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 23 */           FriendHandler.RmChatMsgResponse.Builder res = FriendHandler.RmChatMsgResponse.newBuilder();
/*    */           try {
/* 25 */             RecentChatMgr recentMgr = player.getRecentChatMgr();
/* 26 */             recentMgr.removeRecentMsg(req.getC2SFriendId());
/* 27 */             res.setS2CCode(200);
/* 28 */             this.body.writeBytes(res.build().toByteArray());
/* 29 */           } catch (Exception e) {
/* 30 */             Out.error(new Object[] { e });
/* 31 */             res.setS2CCode(500);
/* 32 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\RmChatMsgHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */