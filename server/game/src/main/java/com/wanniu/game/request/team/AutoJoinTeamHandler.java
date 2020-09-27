/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.TeamTargetCO;
/*    */ import com.wanniu.game.player.WNPlayer;
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
/*    */ @GClientEvent("area.teamHandler.autoJoinTeamRequest")
/*    */ public class AutoJoinTeamHandler
/*    */   extends TeamRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 25 */     TeamHandler.AutoJoinTeamRequest msg = TeamHandler.AutoJoinTeamRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 27 */     final int targetId = msg.getC2STargetId();
/*    */     
/* 29 */     if (targetId == 0) {
/* 30 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_TARGET_ERROR"));
/*    */     }
/*    */     
/* 33 */     if (player.getTeamManager().isInTeam()) {
/* 34 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_ALREADY_IN_TEAM"));
/*    */     }
/*    */     
/* 37 */     final int difficulty = msg.getC2SDifficulty();
/* 38 */     TeamTargetCO targetProp = (TeamTargetCO)GameData.TeamTargets.get(Integer.valueOf(targetId));
/*    */     
/* 40 */     if (targetProp == null || (difficulty != 1 && difficulty != 2 && difficulty != 3)) {
/* 41 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
/*    */     
/* 44 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 48 */           TeamHandler.AutoJoinTeamResponse.Builder res = TeamHandler.AutoJoinTeamResponse.newBuilder();
/*    */           
/* 50 */           TeamService.addAutoMatch(player, targetId, difficulty);
/*    */           
/* 52 */           res.setS2CCode(200);
/* 53 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\AutoJoinTeamHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */