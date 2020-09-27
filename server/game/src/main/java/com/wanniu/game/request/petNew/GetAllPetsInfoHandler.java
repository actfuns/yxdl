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
/*    */ @GClientEvent("area.petNewHandler.getAllPetsInfoRequest")
/*    */ public class GetAllPetsInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 17 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 19 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 21 */           PetNewHandler.GetAllPetsInfoResponse.Builder res = player.petNewManager.toJson4Payload();
/* 22 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\petNew\GetAllPetsInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */