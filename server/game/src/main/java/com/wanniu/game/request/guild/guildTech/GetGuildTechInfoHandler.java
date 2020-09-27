/*    */ package com.wanniu.game.request.guild.guildTech;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.guildTech.GuildTechManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildTechHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildTechHandler.getGuildTechInfoRequest")
/*    */ public class GetGuildTechInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 18 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 20 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 23 */           GuildTechHandler.GetGuildTechInfoResponse.Builder res = GuildTechHandler.GetGuildTechInfoResponse.newBuilder();
/*    */           
/* 25 */           GuildTechManager guildTechManager = player.guildManager.guildTechManager;
/* 26 */           guildTechManager.getGuildTechAsync();
/* 27 */           GuildTechHandler.GuildTechInfo techInfo = guildTechManager.toJson4PayLoad();
/* 28 */           res.setS2CCode(200);
/* 29 */           res.setS2CTechInfo(techInfo);
/* 30 */           res.setS2CContribution(player.guildManager.getContribution());
/* 31 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildTech\GetGuildTechInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */