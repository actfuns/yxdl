/*    */ package com.wanniu.game.request.redpacket;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.redpacket.RedPacketService;
/*    */ import java.io.IOException;
/*    */ import pomelo.redpacket.RedPacketHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("redpacket.redPacketHandler.getRedPacketListRequest")
/*    */ public class GetRedPacketListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 26 */     final RedPacketHandler.GetRedPacketListResponse.Builder res = RedPacketService.getInstance().getAllRedPackets(player.getId());
/* 27 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 30 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\redpacket\GetRedPacketListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */