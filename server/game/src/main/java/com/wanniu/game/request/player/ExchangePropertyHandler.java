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
/*    */ 
/*    */ @GClientEvent("area.playerHandler.exchangePropertyRequest")
/*    */ public class ExchangePropertyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     PlayerHandler.ExchangePropertyRequest request = PlayerHandler.ExchangePropertyRequest.parseFrom(this.pak.getRemaingBytes());
/* 24 */     int type = request.getType();
/*    */     
/* 26 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 28 */     PomeloResponse result = player.baseDataManager.exchange(type);
/* 29 */     if (result != null) {
/* 30 */       return result;
/*    */     }
/*    */     
/* 33 */     final PlayerHandler.ExchangePropertyResponse.Builder res = PlayerHandler.ExchangePropertyResponse.newBuilder();
/* 34 */     res.setS2CCode(200);
/* 35 */     res.setCount((player.getPlayer()).exchangCount);
/*    */     
/* 37 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 40 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\ExchangePropertyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */