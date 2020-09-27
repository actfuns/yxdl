/*    */ package com.wanniu.game.request.mail;
/*    */ 
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
/*    */ 
/*    */ @GClientEvent("area.mailHandler.mailDeleteOneKeyRequest")
/*    */ public class MailDeleteOneKeyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     GPlayer player = this.pak.getPlayer();
/* 25 */     WNPlayer wPlayer = (WNPlayer)player;
/* 26 */     final String[] ids = wPlayer.mailManager.mailDeleteOneKey();
/* 27 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 30 */           MailHandler.MailDeleteOneKeyResponse.Builder res = MailHandler.MailDeleteOneKeyResponse.newBuilder();
/*    */           
/* 32 */           res.setS2CCode(200);
/* 33 */           for (int i = 0; i < ids.length; i++) {
/* 34 */             res.addS2CIds(ids[i]);
/*    */           }
/* 36 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\mail\MailDeleteOneKeyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */