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
/*    */ @GClientEvent("area.guildHandler.getMyGuildMembersRequest")
/*    */ public class GetMyGuildMembersHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 21 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 24 */           GuildHandler.GetMyGuildMembersResponse.Builder res = GuildHandler.GetMyGuildMembersResponse.newBuilder();
/*    */           
/* 26 */           GuildResult ret = player.guildManager.getMyGuildMemberList();
/* 27 */           if (0 != ret.result) {
/* 28 */             res.setS2CCode(500);
/* 29 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_EXIST"));
/* 30 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } 
/*    */           
/* 33 */           res.setS2CCode(200);
/* 34 */           GuildResult.MyGuildMember data = (GuildResult.MyGuildMember)ret.data;
/* 35 */           if (null != data) {
/* 36 */             res.addAllS2CMemberList(data.list);
/* 37 */             res.setS2CLeftKickNum(data.leftKickNum);
/*    */           } 
/* 39 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\GetMyGuildMembersHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */