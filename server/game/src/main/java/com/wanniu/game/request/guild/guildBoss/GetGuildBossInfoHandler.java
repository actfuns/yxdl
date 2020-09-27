/*    */ package com.wanniu.game.request.guild.guildBoss;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildBossHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildBossHandler.getGuildBossInfoRequest")
/*    */ public class GetGuildBossInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           GuildBossHandler.GetGuildBossInfoResponse.Builder res = GuildBossHandler.GetGuildBossInfoResponse.newBuilder();
/* 27 */           String msg = player.guildBossManager.handlerGetBossInfo(res);
/* 28 */           if (msg != null) {
/* 29 */             res.setS2CCode(500);
/* 30 */             res.setS2CMsg(msg);
/*    */           } else {
/* 32 */             res.setS2CCode(200);
/*    */           } 
/* 34 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildBoss\GetGuildBossInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */