/*     */ package com.wanniu.game.request.team;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.message.MessageData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import com.wanniu.game.team.TeamService;
/*     */ import com.wanniu.game.team.TeamUtil;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import pomelo.area.TeamHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("area.teamHandler.formTeamRequest")
/*     */ public class FormTeamHandler
/*     */   extends TeamRequestFilter
/*     */ {
/*     */   public PomeloResponse request(final WNPlayer player) throws Exception {
/*  35 */     TeamHandler.FormTeamRequest msg = TeamHandler.FormTeamRequest.parseFrom(this.pak.getRemaingBytes());
/*  36 */     final String toPlayerId = msg.getC2SPlayerId();
/*  37 */     if (toPlayerId == null) {
/*  38 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("SOMETHING_ERR"));
/*     */     }
/*  40 */     if (!PlayerUtil.isOnline(toPlayerId)) {
/*  41 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_OFF_LINE"));
/*     */     }
/*  43 */     if (player.getFriendManager().isInBlackList(toPlayerId)) {
/*  44 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("FRIEND_TARGET_IN_BLACK_LIST"));
/*     */     }
/*  46 */     final WNPlayer toPlayer = PlayerUtil.findPlayer(toPlayerId);
/*  47 */     if (toPlayer.getFriendManager().isInBlackList(player.getId())) {
/*  48 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("FRIEND_IN_BLACK_LIST"));
/*     */     }
/*  50 */     if (toPlayer.getLevel() < GlobalConfig.Team_Min_Level) {
/*  51 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_OTHER_LV_LESS"));
/*     */     }
/*     */     
/*  54 */     if (!TeamUtil.isValidOfMap(player.getSceneType())) {
/*  55 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_IN_RAID"));
/*     */     }
/*     */     
/*  58 */     int toAreaType = AreaUtil.getAreaType(toPlayer.getAreaId());
/*  59 */     if (!TeamUtil.isValidOfMap(toAreaType)) {
/*  60 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TEAM_MAPTPYE_TARGET_DISABLE"));
/*     */     }
/*     */     
/*  63 */     if (player.getSceneType() == Const.SCENE_TYPE.CROSS_SERVER.getValue() && toAreaType != Const.SCENE_TYPE.CROSS_SERVER.getValue())
/*  64 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("CROSS_SERVER_AUTH_LIMIT_TEAM_FORM2")); 
/*  65 */     if (player.getSceneType() != Const.SCENE_TYPE.CROSS_SERVER.getValue() && toAreaType == Const.SCENE_TYPE.CROSS_SERVER.getValue()) {
/*  66 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("CROSS_SERVER_AUTH_LIMIT_TEAM_FORM1"));
/*     */     }
/*     */     
/*  69 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException
/*     */         {
/*  73 */           TeamHandler.FormTeamResponse.Builder res = TeamHandler.FormTeamResponse.newBuilder();
/*  74 */           res.setS2CCode(200);
/*     */           
/*  76 */           TeamData.TeamMemberData selfTeamMember = player.getTeamManager().getTeamMember();
/*  77 */           TeamData.TeamMemberData targetTeamMember = toPlayer.getTeamManager().getTeamMember();
/*     */           
/*  79 */           if (selfTeamMember != null) {
/*  80 */             if (targetTeamMember != null) {
/*  81 */               res.setS2CCode(500);
/*  82 */               res.setS2CMsg(LangService.getValue("TEAM_TARGET_IN_TEAM"));
/*  83 */               this.body.writeBytes(res.build().toByteArray());
/*     */               
/*     */               return;
/*     */             } 
/*  87 */             TeamData team = player.getTeamManager().getTeam();
/*  88 */             String result = TeamUtil.canJoinTeam(player, team);
/*  89 */             if (result != null) {
/*  90 */               res.setS2CCode(500);
/*  91 */               res.setS2CMsg(result);
/*  92 */               this.body.writeBytes(res.build().toByteArray());
/*     */               return;
/*     */             } 
/*  95 */             if (team.invites.containsKey(toPlayerId)) {
/*  96 */               res.setS2CCode(500);
/*  97 */               res.setS2CMsg(LangService.getValue("TEAM_INVITATION"));
/*  98 */               this.body.writeBytes(res.build().toByteArray());
/*     */               
/*     */               return;
/*     */             } 
/* 102 */             int sendLimit = MessageUtil.getSendLimit(Const.MESSAGE_TYPE.team_invite.getValue());
/* 103 */             if (sendLimit > 0 && team.invites.size() >= sendLimit) {
/* 104 */               res.setS2CCode(500);
/* 105 */               res.setS2CMsg(LangService.getValue("TEAM_THIS_MSG_SEND_TOO_MUCH"));
/* 106 */               this.body.writeBytes(res.build().toByteArray());
/*     */               
/*     */               return;
/*     */             } 
/* 110 */             team.invite(player, toPlayerId);
/* 111 */             PlayerUtil.sendSysMessageToPlayer(LangService.getValue("TEAM_INVITATION"), player.getId());
/* 112 */           } else if (targetTeamMember != null) {
/* 113 */             String teamId = targetTeamMember.teamId;
/* 114 */             TeamData team = TeamService.getTeam(teamId);
/*     */             
/* 116 */             String result = TeamUtil.canJoinTeam(player, team);
/* 117 */             if (result != null) {
/* 118 */               res.setS2CCode(500);
/* 119 */               res.setS2CMsg(result);
/* 120 */               this.body.writeBytes(res.build().toByteArray());
/*     */               
/*     */               return;
/*     */             } 
/* 124 */             if (team.applies.containsKey(player.getId())) {
/* 125 */               res.setS2CCode(500);
/* 126 */               res.setS2CMsg(LangService.getValue("TEAM_ALREADY_INVITATION"));
/* 127 */               this.body.writeBytes(res.build().toByteArray());
/*     */               
/*     */               return;
/*     */             } 
/* 131 */             Map<String, String> strMsg = new HashMap<>(1);
/* 132 */             strMsg.put("playerName", PlayerUtil.getColorPlayerNameByPro(player.getPro(), player.getName()));
/* 133 */             MessageData.MessageData_Team_apply msgData = new MessageData.MessageData_Team_apply();
/* 134 */             msgData.applyId = player.getId();
/* 135 */             msgData.name = player.getName();
/* 136 */             msgData.teamId = teamId;
/* 137 */             MessageData message = MessageUtil.createMessage(Const.MESSAGE_TYPE.team_apply.getValue(), player.getId(), (MessageData.MessageData_Data)msgData, strMsg);
/* 138 */             message.id = player.getId();
/* 139 */             MessageUtil.sendMessageToPlayer(message, team.leaderId);
/* 140 */             team.addApply(player.getId(), message.validTime);
/*     */           } else {
/* 142 */             res.setS2CCode(500);
/* 143 */             res.setS2CMsg(LangService.getValue("TEAM_NULL"));
/*     */           } 
/*     */           
/* 146 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\FormTeamHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */