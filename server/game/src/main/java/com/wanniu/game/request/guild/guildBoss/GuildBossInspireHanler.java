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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildBossHandler.guildBossInspireRequest")
/*    */ public class GuildBossInspireHanler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 37 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 38 */     GuildBossHandler.GuildBossInspireRequest req = GuildBossHandler.GuildBossInspireRequest.parseFrom(this.pak.getRemaingBytes());
/* 39 */     final int index = req.getC2SIndex();
/* 40 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 43 */           GuildBossHandler.EnterGuildBossAreaResponse.Builder res = GuildBossHandler.EnterGuildBossAreaResponse.newBuilder();
/* 44 */           String msg = player.guildBossManager.handlerInspireGuildBoss(index);
/* 45 */           if (msg != null) {
/* 46 */             res.setS2CCode(500);
/* 47 */             res.setS2CMsg(msg);
/*    */           } else {
/* 49 */             res.setS2CCode(200);
/*    */           } 
/* 51 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildBoss\GuildBossInspireHanler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */