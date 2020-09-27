/*    */ package com.wanniu.game.request.mail;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.mail.MailManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
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
/*    */ @GClientEvent("area.mailHandler.mailGetAttachmentOneKeyRequest")
/*    */ public class MailGetAttachmentOneKeyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 28 */     GPlayer player = this.pak.getPlayer();
/* 29 */     final WNPlayer wPlayer = (WNPlayer)player;
/* 30 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 33 */           Const.MailAttachments attachments = wPlayer.mailManager.mailGetAttachmentOneKey();
/* 34 */           MailHandler.MailGetAttachmentOneKeyResponse.Builder res = MailHandler.MailGetAttachmentOneKeyResponse.newBuilder();
/*    */           
/* 36 */           res.setS2CCode(200);
/* 37 */           List<String> mailIds = attachments.mailIds;
/* 38 */           res.addAllS2CIds(mailIds);
/*    */ 
/*    */ 
/*    */           
/* 42 */           if (attachments.code == MailManager.ERR_CODE.ERR_CODE_BAG_FULL.getValue())
/*    */           {
/*    */             
/* 45 */             res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/*    */           }
/*    */           
/* 48 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\mail\MailGetAttachmentOneKeyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */