/*    */ package com.wanniu.game.request.guild;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildCommonUtil;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildHandler.joinGuildRequest")
/*    */ public class JoinGuildHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     GuildHandler.JoinGuildRequest req = GuildHandler.JoinGuildRequest.parseFrom(this.pak.getRemaingBytes());
/* 21 */     final String c2s_guildId = req.getC2SGuildId();
/* 22 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 25 */           GuildHandler.JoinGuildResponse.Builder res = GuildHandler.JoinGuildResponse.newBuilder();
/*    */           
/* 27 */           GuildResult resData = player.guildManager.joinGuild(c2s_guildId);
/* 28 */           int result = resData.result;
/* 29 */           if (result == 0) {
/* 30 */             res.setS2CCode(200);
/* 31 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 35 */           res.setS2CCode(500);
/* 36 */           String errMsg = GuildCommonUtil.getJoinGuildErrorMsg(resData);
/* 37 */           res.setS2CMsg(errMsg);
/* 38 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\JoinGuildHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */