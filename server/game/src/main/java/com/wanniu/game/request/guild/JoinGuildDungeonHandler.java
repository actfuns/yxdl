/*    */ package com.wanniu.game.request.guild;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.guild.guildDungeon.GuildDungeonResult;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildHandler;
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildHandler.joinGuildDungeonRequest")
/*    */ public class JoinGuildDungeonHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 18 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 19 */     GuildHandler.JoinGuildDungeonRequest req = GuildHandler.JoinGuildDungeonRequest.parseFrom(this.pak.getRemaingBytes());
/* 20 */     final int c2s_type = req.getC2SType();
/* 21 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 24 */           GuildHandler.JoinGuildDungeonResponse.Builder res = GuildHandler.JoinGuildDungeonResponse.newBuilder();
/* 25 */           Area area = player.getArea();
/* 26 */           GuildDungeonResult data = player.guildManager.joinGuildDungeon(area, c2s_type);
/* 27 */           if (data.result) {
/* 28 */             res.setS2CCode(200);
/* 29 */             res.setS2CType(data.type);
/* 30 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } else {
/* 32 */             res.setS2CCode(500);
/* 33 */             res.setS2CMsg(data.info);
/* 34 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\JoinGuildDungeonHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */