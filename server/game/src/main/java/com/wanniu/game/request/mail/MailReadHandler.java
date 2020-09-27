/*    */ package com.wanniu.game.request.mail;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import pomelo.area.MailHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.mailHandler.mailReadNotify")
/*    */ public class MailReadHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     MailHandler.MailReadNotify req = MailHandler.MailReadNotify.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 22 */     GPlayer player = this.pak.getPlayer();
/* 23 */     WNPlayer wPlayer = (WNPlayer)player;
/* 24 */     if (req.getC2SIdCount() > 0) {
/* 25 */       String[] ids = new String[1];
/* 26 */       ids[0] = req.getC2SId(0);
/* 27 */       wPlayer.mailManager.readMail(ids);
/*    */     } 
/* 29 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\mail\MailReadHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */