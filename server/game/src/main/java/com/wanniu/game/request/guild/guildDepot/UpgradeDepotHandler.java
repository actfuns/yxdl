/*    */ package com.wanniu.game.request.guild.guildDepot;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildDepotHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildDepotHandler.upgradeDepotRequest")
/*    */ public class UpgradeDepotHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 21 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 24 */           GuildDepotHandler.UpgradeDepotResponse.Builder res = GuildDepotHandler.UpgradeDepotResponse.newBuilder();
/*    */           
/* 26 */           GuildResult resData = player.guildManager.upgradeDepotLevel();
/* 27 */           int result = resData.result;
/* 28 */           GuildResult.DepotUpgradeLevelData data = (GuildResult.DepotUpgradeLevelData)resData.data;
/* 29 */           if (result == 0) {
/* 30 */             res.setS2CCode(200);
/* 31 */             res.setS2CLevel(data.newLevel);
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
/* 42 */             res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
/* 43 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 45 */           if (result == 3) {
/* 46 */             res.setS2CCode(500);
/* 47 */             res.setS2CMsg(LangService.getValue("DEPOT_NOT_EXIST"));
/* 48 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 50 */           if (result == 4) {
/* 51 */             res.setS2CCode(500);
/* 52 */             res.setS2CMsg(LangService.getValue("DEPOT_LEVEL_FULL"));
/* 53 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 55 */           if (result == 5) {
/* 56 */             res.setS2CCode(500);
/* 57 */             res.setS2CMsg(LangService.getValue("GUILD_LEVEL_NOT_ENOUGH"));
/* 58 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 60 */           if (result == 6) {
/* 61 */             res.setS2CCode(500);
/* 62 */             res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
/* 63 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 65 */           if (result == 7) {
/* 66 */             res.setS2CCode(500);
/* 67 */             res.setS2CMsg(LangService.getValue("GUILD_FUND_NOT_ENOUGH"));
/* 68 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 71 */           res.setS2CCode(500);
/* 72 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 73 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildDepot\UpgradeDepotHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */