/*    */ package com.wanniu.game.request.guild.guildManager;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildService;
/*    */ import com.wanniu.game.guild.guildDungeon.GuildDungeonAward;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.guild.GuildManagerHandler;
/*    */ 
/*    */ 
/*    */ @GClientEvent("guild.guildManagerHandler.dungeonAwardInfoRequest")
/*    */ public class DungeonAwardInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 18 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 20 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 23 */           GuildManagerHandler.DungeonAwardInfoResponse.Builder res = GuildManagerHandler.DungeonAwardInfoResponse.newBuilder();
/*    */           
/* 25 */           GuildDungeonAward data = GuildService.dungeonAwardInfo(player.getId());
/* 26 */           res.setS2CCode(200);
/* 27 */           res.addAllItemInfos(data.itemInfos);
/* 28 */           res.setDiceLeftTime(data.diceLeftTime);
/* 29 */           res.addAllGetDungeonScoreInfo(data.getDungeonScoreInfo);
/* 30 */           res.setIsFightOver(data.isFightOver);
/* 31 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildManager\DungeonAwardInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */