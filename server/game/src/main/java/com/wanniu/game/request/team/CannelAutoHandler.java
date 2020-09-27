/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
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
/*    */ @GClientEvent("area.teamHandler.cancelAutoRequest")
/*    */ public class CannelAutoHandler
/*    */   extends TeamRequestFilter
/*    */ {
/*    */   public PomeloResponse request(WNPlayer player) throws Exception {
/* 25 */     TeamData team = player.getTeamManager().getTeam();
/* 26 */     if (team != null && !player.getTeamManager().isTeamLeader()) {
/* 27 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_NO_AUTHORITY"));
/*    */     }
/*    */     
/* 30 */     TeamService.removeAutoMatch(player.getId());
/*    */     
/* 32 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 35 */           TeamHandler.CancelAutoResponse.Builder res = TeamHandler.CancelAutoResponse.newBuilder();
/* 36 */           res.setS2CCode(200);
/* 37 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\CannelAutoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */