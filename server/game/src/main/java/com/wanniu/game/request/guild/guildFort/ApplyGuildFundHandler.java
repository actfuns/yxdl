/*    */ package com.wanniu.game.request.guild.guildFort;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildFortHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildFortHandler.applyGuildFundRequest")
/*    */ public class ApplyGuildFundHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           GuildFortHandler.ApplyGuildFundResponse.Builder res = GuildFortHandler.ApplyGuildFundResponse.newBuilder();
/* 28 */           String msg = ApplyGuildFundHandler.this.handleApplyGuildFund(res, player);
/*    */           
/* 30 */           if (msg != null) {
/* 31 */             res.setS2CCode(500);
/* 32 */             res.setS2CMsg(msg);
/*    */           } else {
/* 34 */             res.setS2CCode(200);
/*    */           } 
/* 36 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   private String handleApplyGuildFund(GuildFortHandler.ApplyGuildFundResponse.Builder res, WNPlayer player) {
/* 42 */     if (!player.guildManager.isInGuild()) {
/* 43 */       res.setGuildFund(0);
/* 44 */       return LangService.getValue("GUILD_NOT_JOIN");
/*    */     } 
/*    */     
/* 47 */     int fund = (int)(player.guildManager.getGuildInfo()).fund;
/* 48 */     res.setGuildFund(fund);
/*    */     
/* 50 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildFort\ApplyGuildFundHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */