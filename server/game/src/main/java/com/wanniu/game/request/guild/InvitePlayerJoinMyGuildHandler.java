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
/*    */ @GClientEvent("area.guildHandler.invitePlayerJoinMyGuildRequest")
/*    */ public class InvitePlayerJoinMyGuildHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 18 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 19 */     GuildHandler.InvitePlayerJoinMyGuildRequest req = GuildHandler.InvitePlayerJoinMyGuildRequest.parseFrom(this.pak.getRemaingBytes());
/* 20 */     final String c2s_playerId = req.getC2SPlayerId();
/* 21 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 24 */           GuildHandler.InvitePlayerJoinMyGuildResponse.Builder res = GuildHandler.InvitePlayerJoinMyGuildResponse.newBuilder();
/*    */           
/* 26 */           GuildResult resData = player.guildManager.invitePlayerJoinGuild(c2s_playerId);
/* 27 */           int result = resData.result;
/* 28 */           if (result == 0) {
/* 29 */             res.setS2CCode(200);
/* 30 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 34 */           res.setS2CCode(500);
/* 35 */           String errMsg = "";
/* 36 */           if (-1 == resData.result) {
/* 37 */             errMsg = LangService.getValue("GUILD_NOT_JOIN");
/* 38 */           } else if (-2 == resData.result) {
/* 39 */             errMsg = LangService.getValue("GUILD_NO_POWER");
/* 40 */           } else if (-3 == resData.result) {
/* 41 */             errMsg = LangService.getValue("GUILD_INVITE_OTHER_IN_GUILD");
/* 42 */           } else if (-4 == resData.result) {
/* 43 */             errMsg = LangService.getValue("GUILD_INVITE_OTHER_OFFLINE");
/* 44 */           } else if (-7 == resData.result) {
/* 45 */             errMsg = LangService.getValue("GUILD_NOT_EXIST");
/*    */           } else {
/* 47 */             errMsg = LangService.getValue("SOMETHING_ERR");
/*    */           } 
/* 49 */           res.setS2CMsg(errMsg);
/* 50 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\InvitePlayerJoinMyGuildHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */