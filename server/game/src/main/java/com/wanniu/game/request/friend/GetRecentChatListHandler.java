/*    */ package com.wanniu.game.request.friend;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.recent.RecentChatMgr;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.FriendHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.friendHandler.getRecentChatListRequest")
/*    */ public class GetRecentChatListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 25 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 28 */           FriendHandler.GetRecentChatListResponse.Builder res = FriendHandler.GetRecentChatListResponse.newBuilder();
/* 29 */           RecentChatMgr recentMgr = player.getRecentChatMgr();
/* 30 */           res.setS2CCode(200);
/* 31 */           res.addAllS2CLs(recentMgr.getRecentLs());
/* 32 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\friend\GetRecentChatListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */