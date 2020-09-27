/*    */ package com.wanniu.game.request.guild.guildManager;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildService;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.guild.GuildManagerHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("guild.guildManagerHandler.guildDungeonListRequest")
/*    */ public class GuildDungeonListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 23 */           GuildManagerHandler.GuildDungeonListResponse.Builder res = GuildManagerHandler.GuildDungeonListResponse.newBuilder();
/*    */           
/* 25 */           GuildManagerHandler.DungeonList data = GuildService.guildDungeonList(player.getId());
/* 26 */           if (null != data) {
/* 27 */             res.setS2CCode(200);
/* 28 */             res.setS2CList(data);
/* 29 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 32 */           res.setS2CCode(500);
/* 33 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 34 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildManager\GuildDungeonListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */