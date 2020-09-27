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
/*    */ @GClientEvent("area.guildHandler.impeachGuildPresidentRequest")
/*    */ public class ImpeachGuildPresidentHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 18 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 19 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 22 */           GuildHandler.ImpeachGuildPresidentResponse.Builder res = GuildHandler.ImpeachGuildPresidentResponse.newBuilder();
/* 23 */           GuildResult resData = player.guildManager.impeachGuildPresident();
/* 24 */           int result = resData.result;
/* 25 */           if (result == 0) {
/* 26 */             res.setS2CCode(200);
/* 27 */             res.setIsNew(resData.isNew);
/* 28 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 30 */           if (result == -1) {
/* 31 */             res.setS2CCode(500);
/* 32 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 33 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 35 */           if (result == -2) {
/* 36 */             res.setS2CCode(500);
/* 37 */             res.setS2CMsg(LangService.getValue("GUILD_CANNOT_IMPEACH_SELF"));
/* 38 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 40 */           if (result == -3) {
/* 41 */             res.setS2CCode(500);
/* 42 */             res.setS2CMsg(LangService.getValue("GUILD_PRESIDENT_IS_ONLINE"));
/* 43 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 45 */           if (result == -4) {
/* 46 */             res.setS2CCode(500);
/* 47 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 48 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 50 */           if (result == -5) {
/* 51 */             res.setS2CCode(500);
/* 52 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 53 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 55 */           if (result == -6) {
/* 56 */             res.setS2CCode(500);
/* 57 */             res.setS2CMsg(resData.des);
/* 58 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 60 */           if (result == -7) {
/* 61 */             res.setS2CCode(500);
/* 62 */             res.setS2CMsg(resData.des);
/* 63 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 66 */           res.setS2CCode(500);
/* 67 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 68 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\ImpeachGuildPresidentHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */