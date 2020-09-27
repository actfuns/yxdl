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
/*    */ @GClientEvent("area.guildHandler.setMemberJobRequest")
/*    */ public class SetMemberJobHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     GuildHandler.SetMemberJobRequest req = GuildHandler.SetMemberJobRequest.parseFrom(this.pak.getRemaingBytes());
/* 21 */     final String memberId = req.getMemberId();
/* 22 */     final int job = req.getJob();
/*    */     
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           GuildHandler.SetMemberJobResponse.Builder res = GuildHandler.SetMemberJobResponse.newBuilder();
/* 28 */           GuildResult ret = player.guildManager.setMemberJob(memberId, job);
/* 29 */           int result = ret.result;
/* 30 */           if (result == 0) {
/* 31 */             res.setS2CCode(200);
/* 32 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 34 */           if (result == -20) {
/* 35 */             res.setS2CCode(500);
/* 36 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 37 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 39 */           if (result == -21) {
/* 40 */             res.setS2CCode(500);
/* 41 */             res.setS2CMsg(LangService.getValue("GUILD_JOB_NOT_SET_SELF"));
/* 42 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 44 */           if (result == -1) {
/* 45 */             res.setS2CCode(500);
/* 46 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 47 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 49 */           if (result == -2) {
/* 50 */             res.setS2CCode(500);
/* 51 */             res.setS2CMsg(LangService.getValue("GUILD_MEMBER_NOT_EXIST"));
/* 52 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 54 */           if (result == -3) {
/* 55 */             res.setS2CCode(500);
/* 56 */             res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
/* 57 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 59 */           if (result == -4) {
/* 60 */             res.setS2CCode(500);
/* 61 */             res.setS2CMsg(LangService.getValue("GUILD_JOB_HIGHER_THAN_YOU"));
/* 62 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 64 */           if (result == -5) {
/* 65 */             res.setS2CCode(500);
/* 66 */             res.setS2CMsg(LangService.getValue("GUILD_JOB_FULL"));
/* 67 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 70 */           res.setS2CCode(500);
/* 71 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 72 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\SetMemberJobHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */