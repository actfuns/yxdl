/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
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
/*    */ @GClientEvent("area.teamHandler.createTeamRequest")
/*    */ public class CreateTeamHandler
/*    */   extends TeamRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 24 */     if (!TeamUtil.isValidOfMap(player.getSceneType())) {
/* 25 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_IN_RAID"));
/*    */     }
/* 27 */     if (player.getTeamManager().isInTeam()) {
/* 28 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_ALREADY_IN_TEAM"));
/*    */     }
/*    */     
/* 31 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 35 */           TeamHandler.CreateTeamResponse.Builder res = TeamHandler.CreateTeamResponse.newBuilder();
/*    */           
/* 37 */           String result = null;
/* 38 */           if (player.getSceneType() == Const.SCENE_TYPE.CROSS_SERVER.getValue()) {
/* 39 */             result = TeamUtil.createAcrossTeam(player.getId(), null);
/*    */           } else {
/* 41 */             result = TeamUtil.createLocaleTeam(player.getId(), null);
/*    */           } 
/*    */           
/* 44 */           if (result == null) {
/* 45 */             res.setS2CCode(200);
/*    */           } else {
/* 47 */             res.setS2CCode(500);
/* 48 */             res.setS2CMsg(result);
/*    */           } 
/* 50 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\CreateTeamHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */