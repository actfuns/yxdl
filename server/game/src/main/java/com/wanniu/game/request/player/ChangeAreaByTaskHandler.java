/*     */ package com.wanniu.game.request.player;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.OpenLvCO;
/*     */ import com.wanniu.game.functionOpen.FunctionOpenUtil;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.task.TaskUtils;
/*     */ import com.wanniu.game.task.po.TaskPO;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import java.io.IOException;
/*     */ import java.util.Map;
/*     */ import pomelo.area.PlayerHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("area.playerHandler.changeAreaByTaskRequest")
/*     */ public class ChangeAreaByTaskHandler
/*     */   extends ChangeAreaFilter
/*     */ {
/*     */   public PomeloResponse request(WNPlayer player) throws Exception {
/*  40 */     PlayerHandler.ChangeAreaByTaskRequest req = PlayerHandler.ChangeAreaByTaskRequest.parseFrom(this.pak.getRemaingBytes());
/*  41 */     int mapId = req.getMapId();
/*  42 */     int taskId = req.getTaskId();
/*  43 */     int x = req.getPosx();
/*  44 */     int y = req.getPosy();
/*  45 */     int pointId = req.getPoint();
/*     */     
/*  47 */     if (mapId <= 0 || taskId <= 0) {
/*  48 */       return (PomeloResponse)new ErrorResponse(player.getAreaId() + " - " + pointId + " : " + LangService.getValue("AREA_ID_NULL"));
/*     */     }
/*     */     
/*  51 */     boolean done = false;
/*     */ 
/*     */ 
/*     */     
/*  55 */     TeamData team = player.getTeamManager().getTeam();
/*  56 */     if (team != null) {
/*  57 */       TaskPO taskData = null;
/*  58 */       int areaId = 0;
/*     */       
/*  60 */       Map<Integer, TaskPO> loopTasks = player.teamManager.getLoopTasks();
/*  61 */       if (loopTasks != null) {
/*  62 */         for (TaskPO task : loopTasks.values()) {
/*  63 */           if (taskId == task.templateId) {
/*  64 */             areaId = (TaskUtils.getTaskProp(task.templateId)).circleDungeonID;
/*  65 */             taskData = task;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/*  70 */       if (areaId > 0 && taskData != null && taskData.state == Const.TaskState.NOT_COMPLETED.getValue()) {
/*  71 */         if (team.leaderId.equals(player.getId())) {
/*  72 */           boolean success = true;
/*  73 */           for (TeamData.TeamMemberData teamMember : team.teamMembers.values()) {
/*  74 */             WNPlayer mPlayer = PlayerUtil.getOnlinePlayer(teamMember.id);
/*  75 */             if (mPlayer == null) {
/*  76 */               success = false;
/*  77 */               MessageUtil.sendSysTip(player, LangService.getValue("TEAM_PLAYER_OFF_LINE"), Const.TipsType.BLACK);
/*     */               break;
/*     */             } 
/*  80 */             if (!teamMember.isOnline()) {
/*  81 */               success = false;
/*  82 */               MessageUtil.sendSysTip(player, LangService.getValue("TEAM_PLAYER_OFF_LINE"), Const.TipsType.BLACK);
/*     */               
/*     */               break;
/*     */             } 
/*  86 */             OpenLvCO openConfig = FunctionOpenUtil.findFunctionOpenPropsByFuncName(Const.FunctionType.LoopTask.getValue());
/*  87 */             if (mPlayer.getLevel() < openConfig.openLv) {
/*  88 */               success = false;
/*  89 */               MessageUtil.sendSysTip(player, 
/*  90 */                   LangService.getValue("TEAM_MEMBER_LEVEL_LIMIT").replace("{level}", String.valueOf(openConfig.openLv)), Const.TipsType.BLACK);
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */           
/*  96 */           if (success) {
/*  97 */             if (team.memberCount() >= 3) {
/*  98 */               if (team.followCount() == team.memberCount()) {
/*  99 */                 team.confirm = false;
/*     */               }
/* 101 */               if (player.getAreaId() != areaId) {
/* 102 */                 AreaUtil.dispatchByAreaId(player, areaId, null);
/* 103 */                 done = true;
/*     */               } 
/*     */             } else {
/* 106 */               MessageUtil.sendSysTip(player, LangService.getValue("TASK_NEED_TEAM"), Const.TipsType.BLACK);
/*     */             } 
/*     */           }
/*     */         } else {
/* 110 */           MessageUtil.sendSysTip(player, LangService.getValue("TEAM_NO_AUTHORITY"), Const.TipsType.BLACK);
/*     */         } 
/*     */       }
/*     */       
/* 114 */       if (!done) {
/* 115 */         Out.warn(new Object[] { "changeAreaByTaskRequest handle failed: " + req.toString() });
/*     */       }
/*     */     } 
/* 118 */     Out.debug(new Object[] { "changeAreaByTaskRequest: " + req.toString() });
/*     */     
/* 120 */     final PlayerHandler.ChangeAreaByTaskResponse.Builder res = PlayerHandler.ChangeAreaByTaskResponse.newBuilder();
/* 121 */     res.setS2CCode(200);
/* 122 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/* 125 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\player\ChangeAreaByTaskHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */