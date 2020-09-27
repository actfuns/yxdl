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
/*    */ @GClientEvent("area.petNewHandler.upgradeToTopRequest")
/*    */ public class UpgradeToTopHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 17 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 18 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 21 */           PetNewHandler.UpgradeToTopRequest req = PetNewHandler.UpgradeToTopRequest.parseFrom(UpgradeToTopHandler.this.pak.getRemaingBytes());
/* 22 */           int id = req.getC2SId();
/* 23 */           PetNewHandler.UpgradeToTopResponse.Builder res = player.petNewManager.reqUpgrade2Top(id);
/* 24 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\petNew\UpgradeToTopHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */