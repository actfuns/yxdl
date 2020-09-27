/*    */ package com.wanniu.game.request.petNew;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.PetNewHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.petNewHandler.addExpByItemRequest")
/*    */ public class AddExpByItemHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 24 */     PetNewHandler.AddExpByItemRequest req = PetNewHandler.AddExpByItemRequest.parseFrom(this.pak.getRemaingBytes());
/* 25 */     int id = req.getC2SId();
/* 26 */     String itemCode = req.getC2SItemCode();
/*    */     
/* 28 */     final PetNewHandler.AddExpByItemResponse.Builder res = player.petNewManager.addExpByItem(id, itemCode, 1);
/*    */     
/* 30 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 32 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\petNew\AddExpByItemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */