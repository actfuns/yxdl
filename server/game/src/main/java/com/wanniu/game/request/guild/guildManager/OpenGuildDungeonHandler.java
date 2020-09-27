/*    */ package com.wanniu.game.request.guild.guildManager;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildService;
/*    */ import com.wanniu.game.guild.guildDungeon.OpenGuildDungeonResult;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.guild.GuildManagerHandler;
/*    */ 
/*    */ 
/*    */ @GClientEvent("guild.guildManagerHandler.openGuildDungeonRequest")
/*    */ public class OpenGuildDungeonHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 18 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 20 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 23 */           GuildManagerHandler.OpenGuildDungeonResponse.Builder res = GuildManagerHandler.OpenGuildDungeonResponse.newBuilder();
/*    */           
/* 25 */           OpenGuildDungeonResult data = GuildService.openGuildDungeon(player.getId());
/* 26 */           if (data.result) {
/* 27 */             res.setS2CCode(200);
/* 28 */             res.setS2CWaitTime((int)data.waitTime);
/* 29 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 32 */           res.setS2CCode(500);
/* 33 */           res.setS2CMsg(data.info);
/* 34 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildManager\OpenGuildDungeonHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */