/*    */ package com.wanniu.game.request.guild;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.GuildHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildHandler.getGuildListRequest")
/*    */ public class GetGuildListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     final GuildHandler.GetGuildListRequest req = GuildHandler.GetGuildListRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 22 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 25 */           GuildHandler.GetGuildListResponse.Builder res = GuildHandler.GetGuildListResponse.newBuilder();
/* 26 */           List<GuildHandler.GuildInfo> guildList = player.guildManager.getGuildList(req.getC2SName());
/* 27 */           res.setS2CCode(200);
/* 28 */           res.addAllS2CGuildList(guildList);
/* 29 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\GetGuildListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */