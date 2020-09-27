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
/*    */ @GClientEvent("area.functionOpenHandler.getFunctionListRequest")
/*    */ public class GetFunctionListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     FunctionOpenHandler.GetFunctionListRequest req = FunctionOpenHandler.GetFunctionListRequest.parseFrom(this.pak.getRemaingBytes());
/* 23 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 25 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 28 */           FunctionOpenHandler.GetFunctionListResponse.Builder res = FunctionOpenHandler.GetFunctionListResponse.newBuilder();
/*    */           
/* 30 */           res.addAllS2CList(player.functionOpenManager.toJson4PayLoad());
/*    */           
/* 32 */           res.setS2CCode(200);
/* 33 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\functionOpen\GetFunctionListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */