/*    */ package com.wanniu.game.request.mail;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.mail.MailUtil;
/*    */ import com.wanniu.game.mail.data.MailData;
/*    */ import com.wanniu.game.mail.data.MailPlayerData;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import pomelo.area.MailHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.mailHandler.mailSendTestNotify")
/*    */ public class MailSendTestHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     MailHandler.MailSendTestNotify req = MailHandler.MailSendTestNotify.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 26 */     GPlayer player = this.pak.getPlayer();
/* 27 */     WNPlayer wPlayer = (WNPlayer)player;
/* 28 */     MailPlayerData mailData = new MailPlayerData();
/* 29 */     mailData.mailId = req.getC2SMailId();
/* 30 */     mailData.mailSender = wPlayer.getName();
/* 31 */     mailData.mailSenderId = wPlayer.getId();
/* 32 */     mailData.tcCode = req.getC2STcCode();
/* 33 */     mailData.mailIcon = (wPlayer.getPlayer()).pro;
/* 34 */     MailUtil.getInstance().sendMailToOnePlayer(player.getId(), (MailData)mailData, Const.GOODS_CHANGE_TYPE.mail);
/* 35 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\mail\MailSendTestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */