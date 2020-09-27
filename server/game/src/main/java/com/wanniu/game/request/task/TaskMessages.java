/*     */ package com.wanniu.game.request.task;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.base.TaskBase;
/*     */ import com.wanniu.game.message.MessageData;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.task.TaskUtils;
/*     */ import com.wanniu.game.team.TeamData;
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
/*     */ public class TaskMessages
/*     */ {
/*     */   public static final boolean onMessage(WNPlayer player, Const.MESSAGE_TYPE msgType, int operate, MessageData message) {
/*  29 */     if (operate == Const.MESSAGE_OPERATE.TYPE_ACCEPT.getValue()) {
/*  30 */       if (message.messageType == Const.MESSAGE_TYPE.daily_task_times.getValue()) {
/*  31 */         if (player.taskManager.dailyTasks.size() > 0) {
/*  32 */           MessageUtil.sendSysTip(player, LangService.getValue("DAILY_HAS_ACCEPTED"), Const.TipsType.BLACK);
/*  33 */           return false;
/*     */         } 
/*     */         
/*  36 */         TaskBase prop = TaskUtils.getRDDailyTask(player.getLevel(), 0, player.getPro());
/*  37 */         AcceptTaskHandler.AcceptTaskResult result = player.getPlayerTasks().acceptTask(prop.iD, 2);
/*  38 */         if (result.task != null) {
/*  39 */           result.task.setSecProgress(player.taskManager.getSecProgress(result.task.getKind()));
/*  40 */           player.getPlayerTasks().pushTaskUpdate(result.task);
/*  41 */           return true;
/*     */         } 
/*  43 */         MessageUtil.sendSysTip(player, result.msg, Const.TipsType.BLACK);
/*  44 */         return false;
/*     */       } 
/*     */       
/*  47 */       if (message.messageType == Const.MESSAGE_TYPE.loop_task_addfriend.getValue()) {
/*  48 */         TeamData team = player.teamManager.getTeam();
/*  49 */         if (team != null && !player.getId().equals(team.leaderId)) {
/*  50 */           player.friendManager.friendApply(team.leaderId, player);
/*     */         }
/*  52 */       } else if (message.messageType == Const.MESSAGE_TYPE.loop_task_member_leave.getValue()) {
/*     */         
/*  54 */         TeamData team = player.teamManager.getTeam();
/*  55 */         if (team != null && team.leaderId.equals(player.getId())) {
/*  56 */           player.teamManager.setIsAutoTeam(true);
/*  57 */           MessageUtil.sendSysTip(player, LangService.getValue("TEAM_SET_AUTO_SUCC"), Const.TipsType.BLACK);
/*  58 */           player.teamManager.pushTeamData();
/*     */         } 
/*  60 */       } else if (message.messageType == Const.MESSAGE_TYPE.loop_task_times.getValue()) {
/*     */         
/*  62 */         TeamData team = player.teamManager.getTeam();
/*  63 */         if (team == null) {
/*  64 */           MessageUtil.sendSysTip(player, LangService.getValue("TASK_NEED_TEAM"), Const.TipsType.BLACK);
/*  65 */           return false;
/*     */         } 
/*     */         
/*  68 */         if (!team.leaderId.equals(player.getId())) {
/*  69 */           MessageUtil.sendSysTip(player, LangService.getValue("TEAM_NO_AUTHORITY"), Const.TipsType.BLACK);
/*  70 */           return false;
/*     */         } 
/*     */ 
/*     */         
/*  74 */         if (team.memberCount() < 3) {
/*  75 */           MessageUtil.sendSysTip(player, String.format(LangService.getValue("TEAM_NEED_MEMBER"), new Object[] { Integer.valueOf(3) }), Const.TipsType.BLACK);
/*  76 */           return false;
/*     */         } 
/*     */ 
/*     */         
/*  80 */         TaskBase prop = TaskUtils.getFirstLoopTask();
/*  81 */         int templateId = prop.iD;
/*     */         
/*  83 */         AcceptTaskHandler.AcceptTaskResult result = player.getPlayerTasks().acceptTask(templateId, prop.kind);
/*  84 */         if (result.task != null) {
/*  85 */           result.task.setSecProgress(player.taskManager.getSecProgress(result.task.getKind()));
/*     */           
/*  87 */           for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/*  88 */             WNPlayer mPlayer = member.getPlayer();
/*  89 */             if (mPlayer == null)
/*     */               continue; 
/*  91 */             mPlayer.getPlayerTasks().pushTaskUpdate(result.task);
/*     */           } 
/*     */         } else {
/*  94 */           Out.error(new Object[] { "accept loop task failed" });
/*  95 */           return false;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 100 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\task\TaskMessages.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */