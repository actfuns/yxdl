/*    */ package com.wanniu.game.request.guild.guildManager;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildService;
/*    */ import com.wanniu.game.guild.guildDungeon.GuildDiceAwardResult;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.guild.GuildManagerHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("guild.guildManagerHandler.diceAwardRequest")
/*    */ public class DiceAwardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     final GuildManagerHandler.DiceAwardRequest req = GuildManagerHandler.DiceAwardRequest.parseFrom(this.pak.getRemaingBytes());
/* 21 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 24 */           GuildManagerHandler.DiceAwardResponse.Builder res = GuildManagerHandler.DiceAwardResponse.newBuilder();
/*    */           
/* 26 */           GuildDiceAwardResult data = GuildService.diceAward(player.getId(), req.getS2CPos());
/* 27 */           if (data.result) {
/* 28 */             res.setS2CCode(200);
/* 29 */             res.setS2CItemInfo(data.itemInfo);
/* 30 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 33 */           res.setS2CCode(500);
/* 34 */           res.setS2CMsg(data.info);
/* 35 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildManager\DiceAwardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */