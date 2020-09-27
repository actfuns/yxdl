/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.team.TeamData;
/*    */ import com.wanniu.game.team.TeamService;
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
/*    */ @GClientEvent("area.teamHandler.kickOutTeamRequest")
/*    */ public class KickOutTeamHandler
/*    */   extends TeamRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 25 */     TeamHandler.KickOutTeamRequest msg = TeamHandler.KickOutTeamRequest.parseFrom(this.pak.getRemaingBytes());
/* 26 */     final String playerId = msg.getC2SPlayerId();
/* 27 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 30 */           TeamHandler.KickOutTeamResponse.Builder res = TeamHandler.KickOutTeamResponse.newBuilder();
/* 31 */           TeamData team = player.getTeamManager().getTeam();
/* 32 */           TeamData.TeamMemberData teamLeader = player.getTeamManager().getTeamMember();
/* 33 */           if (team == null || teamLeader == null) {
/* 34 */             res.setS2CCode(500);
/* 35 */             res.setS2CMsg(LangService.getValue("TEAM_LEAVE"));
/* 36 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 39 */           if (!teamLeader.isLeader) {
/* 40 */             res.setS2CCode(500);
/* 41 */             res.setS2CMsg(LangService.getValue("TEAM_NO_AUTHORITY"));
/* 42 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 45 */           TeamData.TeamMemberData teamMember = team.getMember(playerId);
/* 46 */           if (teamMember == null) {
/* 47 */             res.setS2CCode(500);
/* 48 */             res.setS2CMsg(LangService.getValue("TEAM_OBJ_LEAVE_TEAM"));
/* 49 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 52 */           if (!teamLeader.teamId.equals(teamMember.teamId)) {
/* 53 */             res.setS2CCode(500);
/* 54 */             res.setS2CMsg(LangService.getValue("TEAM_WE_NOT_ONE_TEAM"));
/* 55 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 59 */           if (TeamService.kickOutTeam(team, teamMember)) {
/* 60 */             PlayerUtil.sendSysMessageToPlayer(LangService.getValue("TEAM_KICK"), playerId, null);
/* 61 */             PlayerUtil.sendSysMessageToPlayer(LangService.getValue("TEAM_TARGET_KICK").replace("{playerName}", (teamMember.getPlayerData()).name), player
/* 62 */                 .getId(), null);
/*    */           } 
/* 64 */           res.setS2CCode(200);
/* 65 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\KickOutTeamHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */