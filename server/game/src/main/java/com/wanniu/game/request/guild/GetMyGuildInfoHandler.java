/*    */ package com.wanniu.game.request.guild;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildHandler;
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildHandler.getMyGuildInfoRequest")
/*    */ public class GetMyGuildInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 16 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 18 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 21 */           GuildHandler.GetMyGuildInfoResponse.Builder res = GuildHandler.GetMyGuildInfoResponse.newBuilder();
/*    */           
/* 23 */           GuildHandler.MyGuildInfo guildInfo = player.guildManager.getMyGuildInfo();
/* 24 */           res.setS2CCode(200);
/* 25 */           if (null != guildInfo) {
/* 26 */             res.setS2CGuildInfo(guildInfo);
/*    */           }
/* 28 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\GetMyGuildInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */