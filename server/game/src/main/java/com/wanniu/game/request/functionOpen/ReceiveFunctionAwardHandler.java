/*    */ package com.wanniu.game.request.functionOpen;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.FunctionOpenHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.functionOpenHandler.receiveFunctionAwardRequest")
/*    */ public class ReceiveFunctionAwardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 24 */     FunctionOpenHandler.ReceiveFunctionAwardRequest req = FunctionOpenHandler.ReceiveFunctionAwardRequest.parseFrom(this.pak.getRemaingBytes());
/* 25 */     final int guideId = req.getGuideId();
/*    */     
/* 27 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 30 */           FunctionOpenHandler.ReceiveFunctionAwardResponse.Builder res = FunctionOpenHandler.ReceiveFunctionAwardResponse.newBuilder();
/*    */           
/* 32 */           String msg = player.functionOpenManager.receiveFunctionAward(guideId);
/*    */           
/* 34 */           if (msg != null) {
/* 35 */             res.setS2CCode(500);
/* 36 */             res.setS2CMsg(msg);
/*    */           } else {
/* 38 */             res.setS2CCode(200);
/*    */           } 
/*    */           
/* 41 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\functionOpen\ReceiveFunctionAwardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */