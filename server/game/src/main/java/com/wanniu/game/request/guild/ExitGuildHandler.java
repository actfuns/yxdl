/*    */ package com.wanniu.game.request.guild;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildHandler;
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildHandler.exitGuildRequest")
/*    */ public class ExitGuildHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 23 */           GuildHandler.ExitGuildResponse.Builder res = GuildHandler.ExitGuildResponse.newBuilder();
/* 24 */           GuildResult ret = player.guildManager.exitGuild();
/* 25 */           int result = ret.result;
/* 26 */           if (result == 0) {
/* 27 */             res.setS2CCode(200);
/* 28 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 30 */           if (result == 1) {
/* 31 */             res.setS2CCode(500);
/* 32 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 33 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 35 */           if (result == 2) {
/* 36 */             res.setS2CCode(500);
/* 37 */             res.setS2CMsg(LangService.getValue("GUILD_PRESIDENT_CANNOT_EXIT"));
/* 38 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 41 */           res.setS2CCode(500);
/* 42 */           res.setS2CMsg(StringUtil.isNotEmpty(ret.des) ? ret.des : LangService.getValue("SOMETHING_ERR"));
/* 43 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\ExitGuildHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */