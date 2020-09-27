/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.common.msg.MessageUtil;
/*    */ import com.wanniu.game.message.MessageData;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.team.TeamData;
/*    */ import com.wanniu.game.team.TeamService;
/*    */ import com.wanniu.game.team.TeamUtil;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import pomelo.area.TeamHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.teamHandler.joinTeamRequest")
/*    */ public class JoinTeamHandler
/*    */   extends TeamRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 32 */     if (TeamUtil.isInTeam(player.getId())) {
/* 33 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_ALREADY_IN_TEAM"));
/*    */     }
/*    */     
/* 36 */     TeamHandler.JoinTeamRequest msg = TeamHandler.JoinTeamRequest.parseFrom(this.pak.getRemaingBytes());
/* 37 */     final String teamId = msg.getC2STeamId();
/* 38 */     final TeamData team = TeamService.getTeam(teamId);
/* 39 */     if (teamId == null || team == null) {
/* 40 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_NULL"));
/*    */     }
/*    */     
/* 43 */     if (team.applies.containsKey(player.getId())) {
/* 44 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_ALREADY_INVITATION"));
/*    */     }
/*    */     
/* 47 */     String result = TeamUtil.canJoinTeam(player, team);
/* 48 */     if (result != null) {
/* 49 */       return (PomeloResponse)new ErrorResponse(result);
/*    */     }
/*    */     
/* 52 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 56 */           TeamHandler.JoinTeamResponse.Builder res = TeamHandler.JoinTeamResponse.newBuilder();
/*    */           
/* 58 */           Map<String, String> strMsg = new HashMap<>(1);
/* 59 */           strMsg.put("playerName", PlayerUtil.getFullColorName(player));
/* 60 */           MessageData.MessageData_Team_apply msgData = new MessageData.MessageData_Team_apply();
/* 61 */           msgData.applyId = player.getId();
/* 62 */           msgData.name = player.getName();
/* 63 */           msgData.teamId = teamId;
/* 64 */           MessageData message = MessageUtil.createMessage(Const.MESSAGE_TYPE.team_apply.getValue(), player.getId(), (MessageData.MessageData_Data)msgData, strMsg);
/* 65 */           message.id = player.getId();
/* 66 */           if (!player.getTeamManager().isInTeam()) {
/* 67 */             team.addApply(player.getId(), message.validTime);
/* 68 */             MessageUtil.sendMessageToPlayer(message, team.leaderId);
/* 69 */             PlayerUtil.sendSysMessageToPlayer(LangService.getValue("TEAM_APPLY"), player.getId(), Const.TipsType.BLACK);
/*    */           } 
/* 71 */           res.setS2CCode(200);
/*    */           
/* 73 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\JoinTeamHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */