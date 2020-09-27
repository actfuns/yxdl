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
/*    */ @GClientEvent("area.guildHandler.setGuildQQGroupRequest")
/*    */ public class SetGuildQQGroupHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     GuildHandler.SetGuildQQGroupRequest req = GuildHandler.SetGuildQQGroupRequest.parseFrom(this.pak.getRemaingBytes());
/* 21 */     final String qqGroup = req.getQqGroup();
/* 22 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 25 */           GuildHandler.SetGuildQQGroupResponse.Builder res = GuildHandler.SetGuildQQGroupResponse.newBuilder();
/*    */           
/* 27 */           GuildResult ret = player.guildManager.setGuildQQGroup(qqGroup);
/* 28 */           int result = ret.result;
/* 29 */           if (result == 0) {
/* 30 */             res.setS2CCode(200);
/* 31 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 33 */           if (result == -1) {
/* 34 */             res.setS2CCode(500);
/* 35 */             res.setS2CMsg(LangService.getValue("GUILD_QQGROUP_TOO_LONG"));
/* 36 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 38 */           if (result == -2) {
/* 39 */             res.setS2CCode(500);
/* 40 */             res.setS2CMsg(LangService.getValue("GUILD_QQGROUP_NOT_NUMBER"));
/* 41 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 43 */           if (result == -3) {
/* 44 */             res.setS2CCode(500);
/* 45 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 46 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 48 */           if (result == -4) {
/* 49 */             res.setS2CCode(500);
/* 50 */             res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
/* 51 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 54 */           res.setS2CCode(500);
/* 55 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 56 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\SetGuildQQGroupHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */