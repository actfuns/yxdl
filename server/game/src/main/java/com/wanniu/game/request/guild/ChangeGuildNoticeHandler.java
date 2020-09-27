/*    */ package com.wanniu.game.request.guild;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildHandler.changeGuildNoticeRequest")
/*    */ public class ChangeGuildNoticeHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     GuildHandler.ChangeGuildNoticeRequest req = GuildHandler.ChangeGuildNoticeRequest.parseFrom(this.pak.getRemaingBytes());
/* 21 */     final String notice = req.getNotice();
/*    */     
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           GuildHandler.ChangeGuildNoticeResponse.Builder res = GuildHandler.ChangeGuildNoticeResponse.newBuilder();
/* 27 */           if (null == player) {
/* 28 */             res.setS2CCode(500);
/* 29 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 30 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 34 */           GuildResult resData = player.guildManager.changeGuildNotice(notice);
/* 35 */           int result = resData.result;
/* 36 */           if (result == 0) {
/* 37 */             res.setS2CCode(200);
/* 38 */             res.setS2CNotice(resData.newNotice);
/* 39 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 41 */           if (result == -1) {
/* 42 */             res.setS2CCode(500);
/* 43 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 44 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 46 */           if (result == -2) {
/* 47 */             res.setS2CCode(500);
/* 48 */             res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
/* 49 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 51 */           if (result == -3) {
/* 52 */             res.setS2CCode(500);
/* 53 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 54 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 56 */           if (result == -4) {
/* 57 */             res.setS2CCode(500);
/* 58 */             res.setS2CMsg(LangService.getValue("GUILD_NOTICE_TOO_LONG"));
/* 59 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 61 */           if (result == -9) {
/* 62 */             res.setS2CCode(500);
/* 63 */             res.setS2CMsg(LangService.getValue("GUILD_NOTICE_BLACK_STRING"));
/* 64 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 67 */           res.setS2CCode(500);
/* 68 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 69 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\ChangeGuildNoticeHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */