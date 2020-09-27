/*    */ package com.wanniu.game.request.guild.guildBless;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildBlessHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildBlessHandler.receiveBlessGiftRequest")
/*    */ public class ReceiveBlessGiftHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     final GuildBlessHandler.ReceiveBlessGiftRequest req = GuildBlessHandler.ReceiveBlessGiftRequest.parseFrom(this.pak.getRemaingBytes());
/* 21 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 24 */           GuildBlessHandler.ReceiveBlessGiftResponse.Builder res = GuildBlessHandler.ReceiveBlessGiftResponse.newBuilder();
/*    */           
/* 26 */           GuildResult resData = player.guildManager.receiveBlessGift(req.getIndex());
/* 27 */           int result = resData.result;
/* 28 */           if (0 == result) {
/* 29 */             res.setS2CCode(200);
/* 30 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 32 */           if (-1 == result) {
/* 33 */             res.setS2CCode(500);
/* 34 */             res.setS2CMsg(LangService.getValue("BLESS_GIFT_HAVE_RECEIVED"));
/* 35 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 37 */           if (-2 == result) {
/* 38 */             res.setS2CCode(500);
/* 39 */             res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/* 40 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 42 */           if (1 == result) {
/* 43 */             res.setS2CCode(500);
/* 44 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 45 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 47 */           if (2 == result) {
/* 48 */             res.setS2CCode(500);
/* 49 */             res.setS2CMsg(LangService.getValue("BLESS_NOT_FINISH"));
/* 50 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 52 */           if (3 == result) {
/* 53 */             res.setS2CCode(500);
/* 54 */             res.setS2CMsg(LangService.getValue("GUILD_PARAMS"));
/* 55 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 57 */           if (4 == result) {
/* 58 */             res.setS2CCode(500);
/* 59 */             res.setS2CMsg(LangService.getValue("GUILD_GETTED"));
/* 60 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 63 */           res.setS2CCode(500);
/* 64 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 65 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildBless\ReceiveBlessGiftHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */