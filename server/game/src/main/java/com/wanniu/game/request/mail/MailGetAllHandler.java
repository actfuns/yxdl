/*    */ package com.wanniu.game.request.mail;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.common.Const;
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
/*    */ @GClientEvent("area.mailHandler.mailGetAllRequest")
/*    */ public class MailGetAllHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           MailHandler.MailGetAllResponse.Builder res = MailHandler.MailGetAllResponse.newBuilder();
/*    */           
/* 29 */           res.setS2CCode(200);
/* 30 */           GPlayer gPlayer = MailGetAllHandler.this.pak.getPlayer();
/* 31 */           WNPlayer wPlayer = (WNPlayer)gPlayer;
/* 32 */           MailHandler.Mail[] mails = wPlayer.mailManager.getAllMails(wPlayer);
/* 33 */           for (int i = 0; i < mails.length; i++) {
/* 34 */             res.addMails(mails[i]);
/*    */           }
/* 36 */           res.setS2CMaxMailNum(Const.MailSysParam.MAIL_MAX_NUM.getValue());
/* 37 */           res.setS2CMaxWordNum(Const.MailSysParam.MAIL_MAX_WORD.getValue());
/* 38 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\mail\MailGetAllHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */