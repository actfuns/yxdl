/*    */ package com.wanniu.game.request.player;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.PlayerHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.playerHandler.exchangePropertyInfoRequest")
/*    */ public class ExchangePropertyInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 24 */     final PlayerHandler.ExchangePropertyInfoResponse.Builder res = PlayerHandler.ExchangePropertyInfoResponse.newBuilder();
/* 25 */     res.setS2CCode(200);
/* 26 */     res.setCount((player.getPlayer()).exchangCount);
/*    */     
/* 28 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 31 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\ExchangePropertyInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */