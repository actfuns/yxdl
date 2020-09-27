/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.team.TeamData;
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
/*    */ @GClientEvent("area.teamHandler.acrossMatchRequest")
/*    */ public class AcrossMatchHandler
/*    */   extends TeamRequestFilter
/*    */ {
/*    */   public PomeloResponse request(WNPlayer player) throws Exception {
/* 24 */     TeamHandler.AcrossMatchRequest target = TeamHandler.AcrossMatchRequest.parseFrom(this.pak.getRemaingBytes());
/* 25 */     int targetId = target.getTargetId();
/* 26 */     int difficulty = target.getDifficulty();
/* 27 */     TeamData team = player.getTeamManager().getTeam();
/* 28 */     if (team != null) {
/* 29 */       if (!player.getTeamManager().isTeamLeader()) {
/* 30 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_NO_AUTHORITY"));
/*    */       }
/* 32 */       team.curTargetId = targetId;
/* 33 */       team.curDifficulty = difficulty;
/*    */     } else {
/* 35 */       (player.getTeamManager()).acrossTargetId = targetId;
/* 36 */       (player.getTeamManager()).acrossDifficulty = difficulty;
/*    */     } 
/*    */     
/* 39 */     TeamUtil.pushAcrossMatch(player);
/*    */     
/* 41 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 44 */           TeamHandler.AcrossMatchResponse.Builder res = TeamHandler.AcrossMatchResponse.newBuilder();
/* 45 */           res.setS2CCode(200);
/* 46 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\AcrossMatchHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */