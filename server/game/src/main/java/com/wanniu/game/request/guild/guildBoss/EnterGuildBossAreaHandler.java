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
/*    */ @GClientEvent("area.guildBossHandler.enterGuildBossAreaRequest")
/*    */ public class EnterGuildBossAreaHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 23 */     return new PomeloResponse() {
/* 24 */         GuildBossHandler.EnterGuildBossAreaResponse.Builder res = GuildBossHandler.EnterGuildBossAreaResponse.newBuilder();
/* 25 */         String msg = player.guildBossManager.handleEnterGuildBossArea();
/*    */ 
/*    */         
/*    */         protected void write() throws IOException {
/* 29 */           if (this.msg != null) {
/* 30 */             this.res.setS2CCode(500);
/* 31 */             this.res.setS2CMsg(this.msg);
/*    */           } else {
/* 33 */             this.res.setS2CCode(200);
/*    */           } 
/* 35 */           this.body.writeBytes(this.res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildBoss\EnterGuildBossAreaHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */