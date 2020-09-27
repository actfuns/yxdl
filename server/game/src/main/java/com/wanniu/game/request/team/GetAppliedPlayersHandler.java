/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.guild.GuildUtil;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.PlayerPO;
/*    */ import com.wanniu.game.team.TeamData;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.TeamHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.teamHandler.getAppliedPlayersRequest")
/*    */ public class GetAppliedPlayersHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 27 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 28 */     final TeamData team = player.getTeamManager().getTeam();
/* 29 */     if (team == null) {
/* 30 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_NULL"));
/*    */     }
/* 32 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 36 */           TeamHandler.GetAppliedPlayersResponse.Builder res = TeamHandler.GetAppliedPlayersResponse.newBuilder();
/* 37 */           for (String key : team.applies.keySet()) {
/* 38 */             WNPlayer member = PlayerUtil.getOnlinePlayer(key);
/* 39 */             if (member != null && !member.getTeamManager().isInTeam()) {
/* 40 */               PlayerPO po = member.getPlayer();
/*    */               
/* 42 */               TeamHandler.TeamMemberBasic.Builder data = TeamHandler.TeamMemberBasic.newBuilder();
/* 43 */               data.setId(po.id);
/* 44 */               data.setName(po.name);
/* 45 */               data.setPro(po.pro);
/* 46 */               data.setLevel(po.level);
/* 47 */               data.setUpLevel(po.upLevel);
/* 48 */               data.setGuildName(GuildUtil.getGuildName(po.id));
/*    */               
/* 50 */               res.addS2CPlayers(data); continue;
/*    */             } 
/* 52 */             team.removeApply(key);
/*    */           } 
/*    */           
/* 55 */           res.setS2CCode(200);
/* 56 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */   
/*    */   public short getType() {
/* 63 */     return 771;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\GetAppliedPlayersHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */