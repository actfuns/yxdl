/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.team.TeamData;
/*    */ import com.wanniu.game.team.TeamUtil;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.TeamHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.teamHandler.getTeamMembersRequest")
/*    */ public class GetTeamMembersHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 22 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 26 */           TeamHandler.GetTeamMembersResponse.Builder res = TeamHandler.GetTeamMembersResponse.newBuilder();
/* 27 */           TeamData.TeamMemberData teamMember = player.getTeamManager().getTeamMember();
/* 28 */           int isAutoTeam = player.getTeamManager().getIsAutoTeam();
/* 29 */           res.setS2CCode(200);
/* 30 */           res.setS2CIsAcceptAutoTeam(isAutoTeam);
/* 31 */           if (teamMember != null) {
/* 32 */             TeamData team = player.getTeamManager().getTeam();
/* 33 */             res.setS2CTeamTarget(TeamUtil.generateTeamTargetData(team));
/* 34 */             res.addAllS2CTeamMembers(TeamUtil.generateTeamMemberDetailData(player, team));
/* 35 */             res.setS2CIsAcceptAutoTeam(team.isAutoTeam ? 1 : 0);
/* 36 */             res.setFollow(teamMember.getFollow());
/* 37 */             res.setHaveApply(team.applies.size());
/*    */           } else {
/* 39 */             Out.warn(new Object[] { this.val$player.getName(), " not in team request!" });
/*    */           } 
/* 41 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public short getType() {
/* 47 */     return 775;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\GetTeamMembersHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */