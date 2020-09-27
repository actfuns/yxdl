/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.area.AreaUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.PlayerUtil;
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
/*    */ @GClientEvent("area.teamHandler.summonConfirmRequest")
/*    */ public class SummonConfirmHandler
/*    */   extends TeamRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 29 */     TeamHandler.SummonConfirmRequest msg = TeamHandler.SummonConfirmRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 31 */     final int operate = msg.getS2COperate();
/* 32 */     if (operate != 1 && operate != 0) {
/* 33 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("DATA_ERR"));
/*    */     }
/*    */     
/* 36 */     String messageId = msg.getC2SId();
/* 37 */     TeamData.TeamMemberData selfTeamMember = player.getTeamManager().getTeamMember();
/* 38 */     if (selfTeamMember == null || selfTeamMember.isLeader || !selfTeamMember.teamId.equals(messageId)) {
/* 39 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("EXPIRED_MSG"));
/*    */     }
/*    */     
/* 42 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 45 */           TeamHandler.SummonConfirmResponse.Builder res = TeamHandler.SummonConfirmResponse.newBuilder();
/*    */           
/* 47 */           TeamData team = player.getTeamManager().getTeam();
/* 48 */           String summonResultStr = "";
/* 49 */           if (operate == 0) {
/* 50 */             summonResultStr = LangService.getValue("TEAM_SUMMON_FAIL").replace("{playerName}", player.getName());
/*    */           } else {
/* 52 */             if (team == null || !team.isOpenFollow()) {
/* 53 */               res.setS2CCode(500);
/* 54 */               res.setS2CMsg(LangService.getValue("TEAM_LOCKED"));
/* 55 */               this.body.writeBytes(res.build().toByteArray());
/*    */               return;
/*    */             } 
/* 58 */             WNPlayer leader = PlayerUtil.getOnlinePlayer(team.leaderId);
/* 59 */             Area area = leader.getArea();
/* 60 */             String result = AreaUtil.canEnterArea(area.prop, player);
/* 61 */             if (result == null) {
/* 62 */               result = TeamService.followLeader(player, true);
/*    */             }
/* 64 */             if (result != null) {
/* 65 */               res.setS2CCode(500);
/* 66 */               res.setS2CMsg(result);
/* 67 */               this.body.writeBytes(res.build().toByteArray());
/*    */ 
/*    */ 
/*    */ 
/*    */               
/*    */               return;
/*    */             } 
/*    */ 
/*    */ 
/*    */             
/* 77 */             summonResultStr = LangService.getValue("TEAM_SUMMON_SUCCESS").replace("{playerName}", player.getName());
/*    */           } 
/*    */           
/* 80 */           PlayerUtil.sendSysMessageToPlayer(summonResultStr, team.leaderId, Const.TipsType.BLACK);
/* 81 */           res.setS2CCode(200);
/* 82 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\SummonConfirmHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */