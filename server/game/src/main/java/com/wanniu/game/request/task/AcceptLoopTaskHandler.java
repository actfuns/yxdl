/*     */ package com.wanniu.game.request.task;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.base.TaskBase;
/*     */ import com.wanniu.game.functionOpen.FunctionOpenUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.task.TaskData;
/*     */ import com.wanniu.game.task.TaskUtils;
/*     */ import com.wanniu.game.task.po.TaskPO;
/*     */ import com.wanniu.game.team.TeamData;
/*     */ import java.io.IOException;
/*     */ import java.util.Map;
/*     */ import pomelo.area.TaskHandler;
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
/*     */ @GClientEvent("area.taskHandler.acceptLoopTaskRequest")
/*     */ public class AcceptLoopTaskHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  37 */     TaskHandler.AcceptLoopTaskRequest req = TaskHandler.AcceptLoopTaskRequest.parseFrom(this.pak.getRemaingBytes());
/*  38 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  39 */     final String npcId = req.getC2SNpcId();
/*     */     
/*  41 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  44 */           TaskHandler.AcceptLoopTaskResponse.Builder res = TaskHandler.AcceptLoopTaskResponse.newBuilder();
/*  45 */           if (!player.canTalkWithNpc(0, Integer.parseInt(npcId))) {
/*  46 */             res.setS2CCode(500);
/*  47 */             res.setS2CMsg(LangService.getValue("TASK_OBJ_FAR_AWAY"));
/*  48 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  53 */           int openLevel = (FunctionOpenUtil.getPropByName(Const.FunctionType.LoopTask.getValue())).openLv;
/*  54 */           if (player.getLevel() < openLevel) {
/*  55 */             res.setS2CCode(500);
/*  56 */             res.setS2CMsg(LangService.getValue("AREA_PLAYER_LEVEL_LIMIT").replace("{playerLevel}", openLevel + ""));
/*  57 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  62 */           TeamData team = player.getTeamManager().getTeam();
/*  63 */           if (team == null) {
/*  64 */             res.setS2CCode(500);
/*  65 */             res.setS2CMsg(String.format(LangService.getValue("TEAM_NEED_MEMBER"), new Object[] { Integer.valueOf(3) }));
/*  66 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  70 */           if (!team.leaderId.equals(player.getId())) {
/*  71 */             res.setS2CCode(500);
/*  72 */             res.setS2CMsg(LangService.getValue("TEAM_NO_AUTHORITY"));
/*  73 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  78 */           if (team.memberCount() < 3) {
/*  79 */             res.setS2CCode(500);
/*  80 */             res.setS2CMsg(String.format(LangService.getValue("TEAM_NEED_MEMBER"), new Object[] { Integer.valueOf(3) }));
/*  81 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  86 */           if (team.isInLoopTask()) {
/*     */             
/*  88 */             Map<Integer, TaskPO> loopTasks = player.teamManager.getLoopTasks();
/*  89 */             StringBuilder sb = (new StringBuilder(player.getId())).append(" in acceptLoopTaskRequest||");
/*  90 */             if (loopTasks != null) {
/*  91 */               for (TaskPO db : loopTasks.values()) {
/*  92 */                 player.taskManager.pushTaskUpdate(new TaskData(db));
/*  93 */                 sb.append("loopTask:").append(db.templateId).append(",").append(db.state).append(",").append(db.progress).append(",");
/*     */               } 
/*     */             }
/*  96 */             Out.info(new Object[] { sb.toString() });
/*  97 */             res.setS2CCode(500);
/*  98 */             res.setS2CMsg(LangService.getValue("TASK_IS_ACCPETED"));
/*  99 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/* 104 */           TaskBase prop = TaskUtils.getFirstLoopTask();
/*     */           
/* 106 */           AcceptTaskHandler.AcceptTaskResult result = player.getPlayerTasks().acceptTask(prop.iD, prop.kind);
/* 107 */           if (result.task != null) {
/* 108 */             result.task.setSecProgress(player.taskManager.getSecProgress(result.task.getKind()));
/*     */             
/* 110 */             for (TeamData.TeamMemberData member : team.teamMembers.values()) {
/* 111 */               WNPlayer mPlayer = member.getPlayer();
/* 112 */               if (mPlayer == null)
/*     */                 continue; 
/* 114 */               mPlayer.getPlayerTasks().pushTaskUpdate(result.task);
/*     */ 
/*     */               
/* 117 */               mPlayer.taskManager.dealTaskEvent(Const.TaskType.ACCEPT_DAILY_LOOP, String.valueOf(3), 1);
/*     */             } 
/*     */           } else {
/* 120 */             Out.error(new Object[] { "accept loop task failed" });
/* 121 */             res.setS2CCode(500);
/* 122 */             res.setS2CMsg(LangService.getValue("CANNOT_ACCEPT_QUEST"));
/* 123 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/* 127 */           res.setS2CCode(200);
/*     */           
/* 129 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\task\AcceptLoopTaskHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */