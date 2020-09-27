/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
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
/*    */ @GClientEvent("area.teamHandler.setAutoAcceptTeamRequest")
/*    */ public class SetAutoAcceptTeamHandler
/*    */   extends TeamRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 26 */     TeamHandler.SetAutoAcceptTeamRequest msg = TeamHandler.SetAutoAcceptTeamRequest.parseFrom(this.pak.getRemaingBytes());
/* 27 */     final int isAccept = msg.getC2SIsAccept();
/* 28 */     if (isAccept != 1 && isAccept != 0) {
/* 29 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("SOMETHING_ERR"));
/*    */     }
/* 31 */     Out.debug(new Object[] { "isAccept:::", Integer.valueOf(isAccept) });
/* 32 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 35 */           TeamHandler.SetAutoAcceptTeamResponse.Builder res = TeamHandler.SetAutoAcceptTeamResponse.newBuilder();
/* 36 */           res.setS2CCode(200);
/* 37 */           TeamData.TeamMemberData teamLeader = player.getTeamManager().getTeamMember();
/* 38 */           if (teamLeader != null && teamLeader.isLeader) {
/* 39 */             TeamData team = player.getTeamManager().getTeam();
/* 40 */             if (team != null) {
/* 41 */               team.setAutoTeam((isAccept == 1));
/*    */             }
/* 43 */             TeamService.refreshTeam(team, false);
/*    */           } else {
/* 45 */             player.setIsAcceptAutoTeam(isAccept);
/*    */           } 
/* 47 */           res.setS2CIsAcceptAutoTeam(player.getTeamManager().getIsAutoTeam());
/* 48 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\SetAutoAcceptTeamHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */