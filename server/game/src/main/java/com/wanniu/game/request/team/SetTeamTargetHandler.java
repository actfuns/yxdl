/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.TeamTargetCO;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.team.TeamData;
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
/*    */ @GClientEvent("area.teamHandler.setTeamTargetRequest")
/*    */ public class SetTeamTargetHandler
/*    */   extends TeamRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 30 */     TeamData.TeamMemberData selfTeamMember = player.getTeamManager().getTeamMember();
/* 31 */     if (selfTeamMember == null || !selfTeamMember.isLeader) {
/* 32 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_NO_AUTHORITY"));
/*    */     }
/* 34 */     Area area = player.getArea();
/* 35 */     if (area != null && !area.isNormal()) {
/* 36 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_LOCKED"));
/*    */     }
/* 38 */     TeamHandler.SetTeamTargetRequest msg = TeamHandler.SetTeamTargetRequest.parseFrom(this.pak.getRemaingBytes());
/* 39 */     final int targetId = msg.getC2STargetId();
/* 40 */     final int difficulty = msg.getC2SDifficulty();
/* 41 */     final int minLevel = msg.getC2SMinLevel();
/* 42 */     final int maxLevel = msg.getC2SMaxLevel();
/* 43 */     final int isAutoTeam = msg.getC2SIsAutoTeam();
/* 44 */     final int isAutoStart = msg.getC2SIsAutoStart();
/* 45 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 49 */           TeamHandler.SetTeamTargetResponse.Builder res = TeamHandler.SetTeamTargetResponse.newBuilder();
/* 50 */           TeamTargetCO targetProp = (TeamTargetCO)GameData.TeamTargets.get(Integer.valueOf(targetId));
/*    */           
/* 52 */           if (targetProp == null || (difficulty != 1 && difficulty != 2 && difficulty != 3) || minLevel < 0 || minLevel > GlobalConfig.Role_LevelLimit || (isAutoStart != 0 && isAutoStart != 1) || (isAutoTeam != 0 && isAutoTeam != 1)) {
/*    */ 
/*    */ 
/*    */ 
/*    */             
/* 57 */             res.setS2CCode(500);
/* 58 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 59 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/*    */           
/* 64 */           TeamData team = player.getTeamManager().getTeam();
/* 65 */           team.targetId = targetId;
/* 66 */           team.difficulty = difficulty;
/* 67 */           team.minLevel = minLevel;
/* 68 */           team.maxLevel = maxLevel;
/* 69 */           team.isAutoTeam = (isAutoTeam == 1);
/* 70 */           team.isAutoStart = (isAutoStart == 1);
/*    */           
/* 72 */           PlayerUtil.sendSysMessageToPlayer(LangService.getValue("TEAM_TARGET_SUCCESS"), player.getId(), Const.TipsType.BLACK);
/* 73 */           res.setS2CCode(200);
/* 74 */           this.body.writeBytes(res.build().toByteArray());
/*    */           
/* 76 */           team.onTeamChange();
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\SetTeamTargetHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */