/*    */ package com.wanniu.game.request.mail;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.mail.MailUtil;
/*    */ import com.wanniu.game.mail.data.MailData;
/*    */ import com.wanniu.game.mail.data.MailPlayerData;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.util.BlackWordUtil;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.mailHandler.mailSendMailRequest")
/*    */ public class MailSendMailHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 36 */     final MailHandler.MailSendMailRequest req = MailHandler.MailSendMailRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 38 */     GPlayer player = this.pak.getPlayer();
/* 39 */     final WNPlayer wPlayer = (WNPlayer)player;
/* 40 */     final MailPlayerData mailData = new MailPlayerData();
/* 41 */     mailData.mailSender = wPlayer.getName();
/* 42 */     mailData.mailSenderId = wPlayer.getId();
/* 43 */     mailData.mailTitle = req.getMailTitle();
/* 44 */     mailData.mailText = req.getMailText();
/* 45 */     mailData.mailRead = req.getMailRead();
/* 46 */     mailData.mailIcon = (wPlayer.getPlayer()).pro;
/* 47 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 50 */           MailHandler.MailSendMailResponse.Builder res = MailHandler.MailSendMailResponse.newBuilder();
/*    */           
/* 52 */           if (BlackWordUtil.isIncludeBlackString(mailData.mailTitle)) {
/* 53 */             res.setS2CCode(500);
/* 54 */             res.setS2CMsg(LangService.getValue("MAIL_TITLE_BLACK_STRING"));
/* 55 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 57 */           if (BlackWordUtil.isIncludeBlackString(mailData.mailText)) {
/* 58 */             res.setS2CCode(500);
/* 59 */             res.setS2CMsg(LangService.getValue("MAIL_TEXT_BLACK_STRING"));
/* 60 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 63 */           if (mailData.mailText.length() > Const.MailSysParam.MAIL_MAX_WORD.getValue() + 10) {
/* 64 */             res.setS2CCode(500);
/* 65 */             res.setS2CMsg(LangService.getValue("MAIL_TEXT_TOO_LONG"));
/* 66 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 68 */           if (wPlayer.friendManager.isInBlackList(req.getToPlayerId())) {
/* 69 */             res.setS2CCode(500);
/* 70 */             res.setS2CMsg(LangService.getValue("MAIL_PLAYER_IN_BLACK_LIST"));
/* 71 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 74 */           boolean result = MailUtil.getInstance().sendMailToOnePlayer(req.getToPlayerId(), (MailData)mailData, Const.GOODS_CHANGE_TYPE.mail);
/* 75 */           if (result) {
/* 76 */             res.setS2CCode(200);
/*    */           } else {
/* 78 */             res.setS2CCode(500);
/* 79 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*    */           } 
/*    */           
/* 82 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\mail\MailSendMailHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */