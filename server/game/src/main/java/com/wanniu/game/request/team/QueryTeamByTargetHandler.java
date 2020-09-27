/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.TeamTargetCO;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.team.TeamData;
/*    */ import com.wanniu.game.team.TeamService;
/*    */ import com.wanniu.game.team.TeamUtil;
/*    */ import java.io.IOException;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
/*    */ import pomelo.area.TeamHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.teamHandler.queryTeamByTargetRequest")
/*    */ public class QueryTeamByTargetHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 33 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 34 */     TeamHandler.QueryTeamByTargetRequest msg = TeamHandler.QueryTeamByTargetRequest.parseFrom(this.pak.getRemaingBytes());
/* 35 */     int targetId = msg.getC2STargetId();
/* 36 */     int difficulty = msg.getC2SDifficulty();
/* 37 */     Out.debug(new Object[] { "targetId - ", Integer.valueOf(targetId) });
/*    */     
/* 39 */     TeamTargetCO targetProp = (TeamTargetCO)GameData.TeamTargets.get(Integer.valueOf(targetId));
/*    */     
/* 41 */     if (targetProp == null || (difficulty != 1 && difficulty != 2 && difficulty != 3)) {
/* 42 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
/*    */     
/* 45 */     List<TeamData> finalTeams = TeamService.queryTeamByTarget(team -> (targetId <= 1) ? true : ((team.targetId == targetId && team.difficulty == difficulty)));
/* 46 */     if (targetId <= 1) {
/* 47 */       Collections.sort(finalTeams, new Comparator<TeamData>()
/*    */           {
/*    */             public int compare(TeamData o1, TeamData o2) {
/* 50 */               if (o1.targetId == o2.targetId) {
/* 51 */                 return 0;
/*    */               }
/* 53 */               return (o1.targetId > o2.targetId) ? 1 : -1;
/*    */             }
/*    */           });
/*    */     }
/*    */     
/* 58 */     final TeamHandler.QueryTeamByTargetResponse.Builder res = TeamHandler.QueryTeamByTargetResponse.newBuilder();
/* 59 */     Out.debug(new Object[] { "queryTeamByTargetRequest finalTeams:", Integer.valueOf(finalTeams.size()) });
/* 60 */     res.setS2CCode(200);
/* 61 */     for (TeamData team : finalTeams) {
/* 62 */       TeamHandler.Team.Builder tm = team.createTeamProto();
/* 63 */       if (tm != null) {
/* 64 */         if (TeamUtil.isHasAppliedTeam(player, team)) {
/* 65 */           tm.setIsApplied(1);
/*    */         } else {
/* 67 */           tm.setIsApplied(0);
/*    */         } 
/* 69 */         tm.setIsFighting(!team.isOpenJoin());
/* 70 */         res.addS2CTeams(tm.build());
/*    */       } 
/*    */     } 
/*    */     
/* 74 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 77 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public short getType() {
/* 83 */     return 777;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\QueryTeamByTargetHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */