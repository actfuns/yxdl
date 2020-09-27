/*    */ package com.wanniu.game.request.mail;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.mail.MailManager;
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
/*    */ @GClientEvent("area.mailHandler.mailGetAttachmentRequest")
/*    */ public class MailGetAttachmentHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     MailHandler.MailGetAttachmentRequest req = MailHandler.MailGetAttachmentRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 27 */     GPlayer player = this.pak.getPlayer();
/* 28 */     WNPlayer wPlayer = (WNPlayer)player;
/* 29 */     final int code = wPlayer.mailManager.mailGetAttachment(req.getC2SId(), true);
/* 30 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 33 */           MailHandler.MailGetAttachmentResponse.Builder res = MailHandler.MailGetAttachmentResponse.newBuilder();
/*    */           
/* 35 */           if (code == MailManager.ERR_CODE.ERR_CODE_OK.getValue()) {
/* 36 */             res.setS2CCode(200);
/*    */           }
/* 38 */           else if (code == MailManager.ERR_CODE.ERR_CODE_BAG_FULL.getValue()) {
/* 39 */             res.setS2CCode(500);
/* 40 */             res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/*    */           }
/* 42 */           else if (code == MailManager.ERR_CODE.ERR_CODE_NO_ATTACH.getValue()) {
/* 43 */             res.setS2CCode(500);
/* 44 */             res.setS2CMsg(LangService.getValue("MAIL_NO_ATTACHMENT"));
/*    */           }
/* 46 */           else if (code == MailManager.ERR_CODE.ERR_CODE_NO_SUCH_MAIL.getValue()) {
/* 47 */             res.setS2CCode(500);
/* 48 */             res.setS2CMsg(LangService.getValue("MAIL_NO_SUCH_MAIL"));
/*    */           } else {
/*    */             
/* 51 */             res.setS2CCode(500);
/* 52 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*    */           } 
/* 54 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\mail\MailGetAttachmentHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */