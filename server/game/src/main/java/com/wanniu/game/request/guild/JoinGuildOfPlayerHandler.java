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
/*    */ @GClientEvent("area.guildHandler.joinGuildOfPlayerRequest")
/*    */ public class JoinGuildOfPlayerHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 18 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 19 */     GuildHandler.JoinGuildOfPlayerRequest req = GuildHandler.JoinGuildOfPlayerRequest.parseFrom(this.pak.getRemaingBytes());
/* 20 */     final String c2s_playerId = req.getC2SPlayerId();
/* 21 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 24 */           GuildHandler.JoinGuildOfPlayerResponse.Builder res = GuildHandler.JoinGuildOfPlayerResponse.newBuilder();
/*    */           
/* 26 */           GuildResult resData = player.guildManager.joinGuildByPlayerId(c2s_playerId);
/* 27 */           int result = resData.result;
/* 28 */           if (result == 0) {
/* 29 */             res.setS2CCode(200);
/* 30 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 34 */           res.setS2CCode(500);
/* 35 */           String errMsg = GuildCommonUtil.getJoinGuildErrorMsg(resData);
/* 36 */           res.setS2CMsg(errMsg);
/* 37 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\JoinGuildOfPlayerHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */