/*    */ package com.wanniu.game.request.mail;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.MailHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.mailHandler.mailDeleteRequest")
/*    */ public class MailDeleteHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     MailHandler.MailDeleteRequest req = MailHandler.MailDeleteRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 26 */     GPlayer gPlayer = this.pak.getPlayer();
/* 27 */     final String id = req.getC2SId();
/* 28 */     final WNPlayer wPlayer = (WNPlayer)gPlayer;
/* 29 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 32 */           MailHandler.MailDeleteResponse.Builder res = MailHandler.MailDeleteResponse.newBuilder();
/* 33 */           if (wPlayer.mailManager.mailDelete(id, false)) {
/* 34 */             res.setS2CCode(200);
/*    */           } else {
/*    */             
/* 37 */             res.setS2CCode(500);
/* 38 */             res.setS2CMsg(LangService.getValue("MAIL_DEL_NOT_READ_OR_NOT_GET_ATTACH"));
/*    */           } 
/* 40 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\mail\MailDeleteHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */