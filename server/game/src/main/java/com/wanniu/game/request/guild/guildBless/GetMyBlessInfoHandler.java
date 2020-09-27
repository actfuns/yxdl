/*    */ package com.wanniu.game.request.guild.guildBless;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildBlessHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildBlessHandler.getMyBlessInfoRequest")
/*    */ public class GetMyBlessInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 17 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 19 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 22 */           GuildBlessHandler.GetMyBlessInfoResponse.Builder res = GuildBlessHandler.GetMyBlessInfoResponse.newBuilder();
/*    */           
/* 24 */           GuildBlessHandler.MyBlessInfo data = player.guildManager.getMyBlessInfo();
/* 25 */           res.setS2CCode(200);
/* 26 */           res.setS2CBlessInfo(data);
/* 27 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildBless\GetMyBlessInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */