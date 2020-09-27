/*    */ package com.wanniu.game.request.guild.guildBless;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildBlessHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildBlessHandler.upgradeBlessRequest")
/*    */ public class UpgradeBlessHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 21 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 24 */           GuildBlessHandler.UpgradeBlessResponse.Builder res = GuildBlessHandler.UpgradeBlessResponse.newBuilder();
/*    */           
/* 26 */           GuildResult resData = player.guildManager.upgradeBlessLevel();
/* 27 */           GuildResult.UpgradeLevel data = (GuildResult.UpgradeLevel)resData.data;
/* 28 */           int result = resData.result;
/* 29 */           if (result == 0) {
/* 30 */             res.setS2CCode(200);
/* 31 */             res.setS2CLevel(data.level);
/* 32 */             res.setS2CFund((int)data.fund);
/* 33 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 35 */           if (result == 1) {
/* 36 */             res.setS2CCode(500);
/* 37 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 38 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 40 */           if (result == 2) {
/* 41 */             res.setS2CCode(500);
/* 42 */             res.setS2CMsg(LangService.getValue("BLESS_NO_POWER"));
/* 43 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 45 */           if (result == 3) {
/* 46 */             res.setS2CCode(500);
/* 47 */             res.setS2CMsg(LangService.getValue("BLESS_LEVEL_FULL"));
/* 48 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 50 */           if (result == 4) {
/* 51 */             res.setS2CCode(500);
/* 52 */             res.setS2CMsg(LangService.getValue("GUILD_LEVEL_NOT_ENOUGH"));
/* 53 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 55 */           if (result == 5) {
/* 56 */             res.setS2CCode(500);
/* 57 */             res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
/* 58 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 60 */           if (result == 6) {
/* 61 */             res.setS2CCode(500);
/* 62 */             res.setS2CMsg(LangService.getValue("GUILD_FUND_NOT_ENOUGH"));
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


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildBless\UpgradeBlessHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */