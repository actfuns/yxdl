/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.team.TeamUtil;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.TeamHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.teamHandler.leaveTeamRequest")
/*    */ public class LeaveTeamHandler
/*    */   extends TeamRequestFilter
/*    */ {
/*    */   protected PomeloResponse checkRemote(WNPlayer player) {
/* 20 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 25 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 29 */           TeamHandler.LeaveTeamResponse.Builder res = TeamHandler.LeaveTeamResponse.newBuilder();
/* 30 */           boolean isInTeam = player.getTeamManager().isInTeam();
/* 31 */           if (isInTeam) {
/* 32 */             TeamUtil.leaveTeamInAreaServer(player);
/* 33 */             res.setS2CCode(200);
/*    */           } else {
/* 35 */             res.setS2CCode(500);
/* 36 */             res.setS2CMsg(LangService.getValue("TEAM_LEAVE"));
/*    */           } 
/* 38 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\LeaveTeamHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */