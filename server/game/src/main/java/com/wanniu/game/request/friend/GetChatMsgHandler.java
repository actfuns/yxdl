/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.recent.RecentChatMgr;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.FriendHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.friendHandler.getChatMsgRequest")
/*    */ public class GetChatMsgHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 22 */     final FriendHandler.GetChatMsgRequest req = FriendHandler.GetChatMsgRequest.parseFrom(this.pak.getRemaingBytes());
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           FriendHandler.GetChatMsgResponse.Builder res = FriendHandler.GetChatMsgResponse.newBuilder();
/* 27 */           RecentChatMgr recentChatMgr = player.getRecentChatMgr();
/* 28 */           List<FriendHandler.ChatMsg> ls = recentChatMgr.getRecentMsg(req.getC2SFriendId());
/* 29 */           res.setS2CCode(200);
/* 30 */           res.addAllS2CMsgLs(ls);
/* 31 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\GetChatMsgHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */