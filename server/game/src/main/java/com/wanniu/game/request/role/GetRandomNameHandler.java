/*    */ package com.wanniu.game.request.role;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.area.PlayerRemote;
/*    */ import java.io.IOException;
/*    */ import pomelo.connector.RoleHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("connector.roleHandler.getRandomNameRequest")
/*    */ public class GetRandomNameHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     RoleHandler.GetRandomNameRequest req = RoleHandler.GetRandomNameRequest.parseFrom(this.pak.getRemaingBytes());
/* 25 */     final int pro = req.getC2SPro();
/*    */     
/* 27 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 30 */           RoleHandler.GetRandomNameResponse.Builder res = RoleHandler.GetRandomNameResponse.newBuilder();
/*    */           
/* 32 */           if (pro == 0) {
/* 33 */             Out.warn(new Object[] { "getRandomNameRequest pro is null!" });
/* 34 */             res.setS2CCode(400);
/* 35 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*    */             
/*    */             return;
/*    */           } 
/* 39 */           String lastName = PlayerRemote.getRandomName(pro, 0);
/*    */           
/* 41 */           res.setS2CCode(200);
/* 42 */           res.setS2CName(lastName);
/*    */           
/* 44 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\role\GetRandomNameHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */