/*    */ package com.wanniu.game.request.functionOpen;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
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
/*    */ @GClientEvent("area.functionOpenHandler.setFunctionPlayedRequest")
/*    */ public class SetFunctionPlayedHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     final FunctionOpenHandler.SetFunctionPlayedRequest req = FunctionOpenHandler.SetFunctionPlayedRequest.parseFrom(this.pak.getRemaingBytes());
/* 24 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 26 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 29 */           FunctionOpenHandler.SetFunctionPlayedResponse.Builder res = FunctionOpenHandler.SetFunctionPlayedResponse.newBuilder();
/*    */ 
/*    */           
/* 32 */           int result = player.functionOpenManager.setFunctionPlayed(req.getFunctionName());
/* 33 */           if (result == 0) {
/* 34 */             res.setS2CCode(200);
/* 35 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 37 */           if (result == -1) {
/* 38 */             res.setS2CCode(500);
/* 39 */             res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
/* 40 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 43 */           res.setS2CCode(500);
/* 44 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 45 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\functionOpen\SetFunctionPlayedHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */