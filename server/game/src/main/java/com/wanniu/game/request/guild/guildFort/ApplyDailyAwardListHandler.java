/*    */ package com.wanniu.game.request.guild.guildFort;
/*    */ 
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
/*    */ @GClientEvent("area.guildFortHandler.applyDailyAwardListRequest")
/*    */ public class ApplyDailyAwardListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           GuildFortHandler.ApplyDailyAwardListResponse.Builder res = GuildFortHandler.ApplyDailyAwardListResponse.newBuilder();
/* 28 */           String msg = player.guildFortManager.handleApplyDailyAwardList(res);
/* 29 */           if (msg != null) {
/* 30 */             res.setS2CCode(500);
/*    */           } else {
/* 32 */             res.setS2CCode(200);
/*    */           } 
/* 34 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildFort\ApplyDailyAwardListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */