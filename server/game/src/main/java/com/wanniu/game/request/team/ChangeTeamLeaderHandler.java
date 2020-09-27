/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.team.TeamData;
/*    */ import com.wanniu.game.team.TeamService;
/*    */ import com.wanniu.game.team.TeamUtil;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.TeamHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.teamHandler.changeTeamLeaderRequest")
/*    */ public class ChangeTeamLeaderHandler
/*    */   extends TeamRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 28 */     TeamHandler.ChangeTeamLeaderRequest msg = TeamHandler.ChangeTeamLeaderRequest.parseFrom(this.pak.getRemaingBytes());
/* 29 */     String playerId = msg.getC2SPlayerId();
/* 30 */     if (StringUtil.isEmpty(playerId)) {
/* 31 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("DATA_ERR"));
/*    */     }
/* 33 */     if (!PlayerUtil.isOnline(playerId)) {
/* 34 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_OFF_LINE"));
/*    */     }
/* 36 */     final TeamData.TeamMemberData teamLeader = player.getTeamManager().getTeamMember();
/* 37 */     if (teamLeader == null) {
/* 38 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_LEAVE"));
/*    */     }
/* 40 */     if (!teamLeader.isLeader) {
/* 41 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_NO_AUTHORITY"));
/*    */     }
/* 43 */     final TeamData team = player.getTeamManager().getTeam();
/* 44 */     final TeamData.TeamMemberData teamMember = team.getMember(playerId);
/* 45 */     if (teamMember == null) {
/* 46 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_OBJ_LEAVE_TEAM"));
/*    */     }
/* 48 */     if (!teamLeader.teamId.equals(teamMember.teamId)) {
/* 49 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_WE_NOT_ONE_TEAM"));
/*    */     }
/*    */     
/* 52 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 55 */           TeamHandler.ChangeTeamLeaderResponse.Builder res = TeamHandler.ChangeTeamLeaderResponse.newBuilder();
/*    */           
/* 57 */           teamLeader.isLeader = false;
/* 58 */           teamMember.isLeader = true;
/* 59 */           team.leaderId = teamMember.id;
/*    */           
/* 61 */           TeamService.refreshTeam(team);
/* 62 */           TeamUtil.sendSysMessageByLeaderChanged(teamLeader.teamId, player.getName());
/*    */           
/* 64 */           res.setS2CCode(200);
/* 65 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\ChangeTeamLeaderHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */