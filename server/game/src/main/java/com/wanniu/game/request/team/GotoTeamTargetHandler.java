/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.Area;
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
/*    */ @GClientEvent("area.teamHandler.gotoTeamTargetRequest")
/*    */ public class GotoTeamTargetHandler
/*    */   extends TeamRequestFilter
/*    */ {
/*    */   public PomeloResponse request(WNPlayer player) throws Exception {
/* 25 */     TeamHandler.GotoTeamTargetRequest target = TeamHandler.GotoTeamTargetRequest.parseFrom(this.pak.getRemaingBytes());
/* 26 */     int targetId = target.getTargetId();
/* 27 */     int difficulty = target.getDifficulty();
/* 28 */     TeamData team = player.getTeamManager().getTeam();
/* 29 */     if (team == null) {
/* 30 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_MEMBER_COUNT"));
/*    */     }
/* 32 */     if (!player.getTeamManager().isTeamLeader()) {
/* 33 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_NO_AUTHORITY"));
/*    */     }
/* 35 */     if (!team.isAllOnline()) {
/* 36 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_PLAYER_OFF_LINE"));
/*    */     }
/* 38 */     team.curTargetId = targetId;
/* 39 */     team.curDifficulty = difficulty;
/* 40 */     int mapId = team.getTargetMap();
/* 41 */     if (mapId == 0) {
/* 42 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_NOTARGET_GO"));
/*    */     }
/*    */     
/* 45 */     Area area = TeamUtil.goToTeamTarget(team, player);
/* 46 */     if (area == null) {
/* 47 */       return (PomeloResponse)new ErrorResponse("");
/*    */     }
/*    */     
/* 50 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 53 */           TeamHandler.GotoTeamTargetResponse.Builder res = TeamHandler.GotoTeamTargetResponse.newBuilder();
/* 54 */           res.setS2CCode(200);
/* 55 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\GotoTeamTargetHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */