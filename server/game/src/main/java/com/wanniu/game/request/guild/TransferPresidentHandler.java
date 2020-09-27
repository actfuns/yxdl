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
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildHandler.transferPresidentRequest")
/*    */ public class TransferPresidentHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 22 */     GuildHandler.TransferPresidentRequest req = GuildHandler.TransferPresidentRequest.parseFrom(this.pak.getRemaingBytes());
/* 23 */     final String memberId = req.getMemberId();
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           GuildHandler.TransferPresidentResponse.Builder res = GuildHandler.TransferPresidentResponse.newBuilder();
/*    */           
/* 29 */           GuildResult ret = player.guildManager.transferGuildPresident(memberId);
/* 30 */           int result = ret.result;
/* 31 */           if (result == 0) {
/* 32 */             GuildResult.MyGuildMember data = (GuildResult.MyGuildMember)(player.guildManager.getMyGuildMemberList()).data;
/* 33 */             GuildHandler.MyGuildInfo guildInfo = player.guildManager.getMyGuildInfo();
/* 34 */             res.setS2CCode(200);
/* 35 */             res.addAllS2CMemberList(data.list);
/* 36 */             res.setS2CGuildInfo(guildInfo);
/* 37 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 39 */           if (result == -20) {
/* 40 */             res.setS2CCode(500);
/* 41 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 42 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 44 */           if (result == -1) {
/* 45 */             res.setS2CCode(500);
/* 46 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 47 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 49 */           if (result == -2) {
/* 50 */             res.setS2CCode(500);
/* 51 */             res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
/* 52 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 54 */           if (result == -3) {
/* 55 */             res.setS2CCode(500);
/* 56 */             res.setS2CMsg(LangService.getValue("GUILD_MEMBER_NOT_EXIST"));
/* 57 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 60 */           res.setS2CCode(500);
/* 61 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 62 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\TransferPresidentHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */