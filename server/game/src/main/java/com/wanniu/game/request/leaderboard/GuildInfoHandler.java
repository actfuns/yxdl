/*    */ package com.wanniu.game.request.leaderboard;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.data.GuildLevelCO;
/*    */ import com.wanniu.game.guild.GuildServiceCenter;
/*    */ import com.wanniu.game.guild.GuildUtil;
/*    */ import com.wanniu.game.poes.GuildPO;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.LeaderBoardHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.leaderBoardHandler.guildInfoRequest")
/*    */ public class GuildInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 28 */     final LeaderBoardHandler.GuildInfoRequest req = LeaderBoardHandler.GuildInfoRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 30 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 33 */           LeaderBoardHandler.GuildInfoResponse.Builder res = LeaderBoardHandler.GuildInfoResponse.newBuilder();
/*    */           try {
/* 35 */             String guildId = req.getC2SGuildId();
/* 36 */             GuildPO guild = GuildServiceCenter.getInstance().getGuild(guildId);
/* 37 */             if (null != guild) {
/* 38 */               GuildLevelCO prop = GuildUtil.getGuildLevelPropByLevel(guild.level);
/* 39 */               int maxMember = (null != prop) ? prop.member : 1;
/* 40 */               LeaderBoardHandler.RankGuildInfo.Builder data = LeaderBoardHandler.RankGuildInfo.newBuilder();
/* 41 */               data.setGuildId(guild.id);
/* 42 */               data.setGuildIcon(guild.icon);
/* 43 */               data.setGuildMaster(guild.presidentName);
/* 44 */               data.setGuildMasterPro(guild.presidentPro);
/* 45 */               data.setGuildLevel(guild.level);
/* 46 */               data.setCurMember(GuildUtil.getGuildMemberCount(guild.id));
/* 47 */               data.setMaxMember(maxMember);
/* 48 */               data.setFund((int)guild.sumFund);
/* 49 */               data.setNotice(guild.notice);
/*    */               
/* 51 */               res.setS2CCode(200);
/* 52 */               res.setS2CData(data.build());
/* 53 */               this.body.writeBytes(res.build().toByteArray());
/*    */             } else {
/* 55 */               res.setS2CCode(200);
/* 56 */               res.setS2CMsg(LangService.getValue("GUILD_NOT_EXIST"));
/* 57 */               this.body.writeBytes(res.build().toByteArray());
/*    */             } 
/* 59 */           } catch (Exception err) {
/* 60 */             Out.error(new Object[] { err });
/* 61 */             res.setS2CCode(500);
/* 62 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\leaderboard\GuildInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */