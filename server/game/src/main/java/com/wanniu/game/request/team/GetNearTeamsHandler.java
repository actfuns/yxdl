/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.guild.GuildUtil;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.PlayerPO;
/*    */ import com.wanniu.game.team.TeamData;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import pomelo.area.TeamHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.teamHandler.getNearTeamsRequest")
/*    */ public class GetNearTeamsHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 31 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 32 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 35 */           TeamHandler.GetNearTeamsResponse.Builder res = TeamHandler.GetNearTeamsResponse.newBuilder();
/* 36 */           Area area = player.getArea();
/* 37 */           Map<String, TeamData> teams = new HashMap<>();
/* 38 */           for (String playerId : area.actors.keySet()) {
/* 39 */             WNPlayer near = PlayerUtil.getOnlinePlayer(playerId);
/* 40 */             if (near == null) {
/*    */               continue;
/*    */             }
/* 43 */             TeamData team = near.getTeamManager().getTeam();
/* 44 */             if (team != null && team != player.getTeamManager().getTeam()) {
/* 45 */               teams.put(team.id, team);
/*    */             }
/*    */           } 
/* 48 */           for (TeamData team : teams.values()) {
/* 49 */             TeamHandler.NearTeam.Builder nearTeam = TeamHandler.NearTeam.newBuilder();
/* 50 */             nearTeam.setTeamId(team.id);
/* 51 */             PlayerPO leader = PlayerUtil.getPlayerBaseData(team.leaderId);
/* 52 */             TeamHandler.NearTeamLeader.Builder ntLeader = TeamHandler.NearTeamLeader.newBuilder();
/* 53 */             ntLeader.setName(leader.name);
/* 54 */             ntLeader.setGuildName(GuildUtil.getGuildName(leader.id));
/* 55 */             ntLeader.setLv(leader.level);
/* 56 */             ntLeader.setPro(leader.pro);
/* 57 */             nearTeam.setLeader(ntLeader);
/* 58 */             for (TeamData.TeamMemberData teamMember : team.teamMembers.values()) {
/* 59 */               TeamHandler.NearTeamMember.Builder ntMember = TeamHandler.NearTeamMember.newBuilder();
/* 60 */               PlayerPO member = teamMember.getPlayerData();
/* 61 */               ntMember.setPro(member.pro);
/* 62 */               ntMember.setLv(member.level);
/* 63 */               nearTeam.addMembers(ntMember);
/*    */             } 
/* 65 */             nearTeam.setApply(team.applies.containsKey(player.getId()) ? 1 : 0);
/* 66 */             res.addTeams(nearTeam);
/*    */           } 
/* 68 */           res.setS2CCode(200);
/* 69 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public short getType() {
/* 75 */     return 773;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\GetNearTeamsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */