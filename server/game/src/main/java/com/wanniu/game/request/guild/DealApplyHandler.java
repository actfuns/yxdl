/*    */ package com.wanniu.game.request.guild;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildHandler.dealApplyRequest")
/*    */ public class DealApplyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     final GuildHandler.DealApplyRequest req = GuildHandler.DealApplyRequest.parseFrom(this.pak.getRemaingBytes());
/* 21 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 24 */           GuildHandler.DealApplyResponse.Builder res = GuildHandler.DealApplyResponse.newBuilder();
/* 25 */           if (null == player) {
/* 26 */             res.setS2CCode(500);
/* 27 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 28 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 32 */           GuildResult ret = player.guildManager.dealApply(req.getC2SApplyId(), req.getC2SOperate());
/* 33 */           int result = ret.result;
/* 34 */           if (result == 0) {
/* 35 */             res.setS2CCode(200);
/* 36 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 38 */           if (result == -20) {
/* 39 */             res.setS2CCode(500);
/* 40 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 41 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 43 */           if (result == -1) {
/* 44 */             res.setS2CCode(500);
/* 45 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 46 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 48 */           if (result == -2) {
/* 49 */             res.setS2CCode(500);
/* 50 */             res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
/* 51 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 53 */           if (result == -3) {
/* 54 */             res.setS2CCode(500);
/* 55 */             res.setS2CMsg(LangService.getValue("GUILD_FULL"));
/* 56 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 58 */           if (result == -4) {
/* 59 */             res.setS2CCode(500);
/* 60 */             res.setS2CMsg(LangService.getValue("GUILD_APPLY_NOT_EXIST"));
/* 61 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 64 */           res.setS2CCode(500);
/* 65 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 66 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\DealApplyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */