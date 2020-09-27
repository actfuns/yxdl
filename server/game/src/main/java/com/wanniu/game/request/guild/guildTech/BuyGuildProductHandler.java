/*    */ package com.wanniu.game.request.guild.guildTech;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.guild.guildTech.GuildTechManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildTechHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildTechHandler.buyGuildProductRequest")
/*    */ public class BuyGuildProductHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     GuildTechHandler.BuyGuildProductRequest req = GuildTechHandler.BuyGuildProductRequest.parseFrom(this.pak.getRemaingBytes());
/* 22 */     final int productId = req.getProductId();
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           GuildTechHandler.BuyGuildProductResponse.Builder res = GuildTechHandler.BuyGuildProductResponse.newBuilder();
/* 27 */           GuildTechManager guildTechManager = player.guildManager.guildTechManager;
/* 28 */           GuildResult ret = guildTechManager.buyGuildTechProduct(productId);
/* 29 */           int result = ret.result;
/* 30 */           if (result == 0) {
/* 31 */             res.setS2CCode(200);
/* 32 */             res.setS2CId(Integer.parseInt(ret.id));
/* 33 */             res.setS2CState(ret.state);
/* 34 */             res.setS2CContribution(player.guildManager.getContribution());
/* 35 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 37 */           if (result == -1) {
/* 38 */             res.setS2CCode(500);
/* 39 */             res.setS2CMsg(LangService.getValue("TECH_PRODUCT_NOT_EXIST"));
/* 40 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 42 */           if (result == -2) {
/* 43 */             res.setS2CCode(500);
/* 44 */             res.setS2CMsg(LangService.getValue("TECH_PRODUCT_SELL_OUT"));
/* 45 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 47 */           if (result == -3) {
/* 48 */             res.setS2CCode(500);
/* 49 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 50 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 52 */           if (result == -4) {
/* 53 */             res.setS2CCode(500);
/* 54 */             res.setS2CMsg(LangService.getValue("PRODUCT_NEED_JOB_TOO_LOW"));
/* 55 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 57 */           if (result == -5) {
/* 58 */             res.setS2CCode(500);
/* 59 */             res.setS2CMsg(LangService.getValue("PRODUCT_NEED_LEVEL_TOO_LOW"));
/* 60 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 62 */           if (result == -6) {
/* 63 */             res.setS2CCode(500);
/* 64 */             res.setS2CMsg(LangService.getValue("GUILD_CONTRIBUTION_NOT_ENOUGH"));
/* 65 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 67 */           if (result == -7) {
/* 68 */             res.setS2CCode(500);
/* 69 */             res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/* 70 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 73 */           res.setS2CCode(500);
/* 74 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 75 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildTech\BuyGuildProductHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */