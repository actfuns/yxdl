/*    */ package com.wanniu.game.request.petNew;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.PetNewHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.petNewHandler.petFightRequest")
/*    */ public class PetFightHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 18 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 20 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 22 */           PetNewHandler.PetFightRequest req = PetNewHandler.PetFightRequest.parseFrom(PetFightHandler.this.pak.getRemaingBytes());
/* 23 */           int id = req.getC2SId();
/* 24 */           int type = req.getC2SType();
/* 25 */           PetNewHandler.ChangePetNameNewResponse.Builder res = PetNewHandler.ChangePetNameNewResponse.newBuilder();
/*    */           
/* 27 */           String msg = player.petNewManager.petOutFight(id, type);
/* 28 */           if (msg != null) {
/*    */             
/* 30 */             res.setS2CMsg(msg);
/* 31 */             res.setS2CCode(500);
/*    */           } else {
/* 33 */             res.setS2CCode(200);
/*    */           } 
/* 35 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\petNew\PetFightHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */