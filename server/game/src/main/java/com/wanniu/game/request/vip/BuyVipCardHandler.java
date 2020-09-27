/*    */ package com.wanniu.game.request.vip;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.VipHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.vipHandler.buyVipCardRequest")
/*    */ public class BuyVipCardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final VipHandler.BuyVipCardResponse.Builder res = VipHandler.BuyVipCardResponse.newBuilder();
/*    */ 
/*    */ 
/*    */     
/* 23 */     res.setS2CCode(500);
/* 24 */     res.setS2CMsg(LangService.getValue("CONFIG_ERR"));
/*    */     
/* 26 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 29 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\vip\BuyVipCardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */