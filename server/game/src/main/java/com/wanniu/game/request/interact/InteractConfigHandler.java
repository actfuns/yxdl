/*    */ package com.wanniu.game.request.interact;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.interact.PlayerInteract;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.InteractHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.interactHandler.interactConfigRequest")
/*    */ public class InteractConfigHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 17 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 20 */           InteractHandler.InteractConfigResponse.Builder res = InteractHandler.InteractConfigResponse.newBuilder();
/* 21 */           res.setS2CCode(200);
/* 22 */           res.addAllS2CData(PlayerInteract.getConfig());
/* 23 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\interact\InteractConfigHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */