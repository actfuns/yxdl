/*    */ package com.wanniu.game.request.task;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.base.TaskBase;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.task.TaskUtils;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.TaskHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.taskHandler.acceptDailyTaskRequest")
/*    */ public class AcceptDailyTaskHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 31 */     TaskHandler.AcceptDailyTaskRequest req = TaskHandler.AcceptDailyTaskRequest.parseFrom(this.pak.getRemaingBytes());
/* 32 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 33 */     final String npcId = req.getC2SNpcId();
/*    */     
/* 35 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 38 */           TaskHandler.AcceptDailyTaskResponse.Builder res = TaskHandler.AcceptDailyTaskResponse.newBuilder();
/* 39 */           if (!player.canTalkWithNpc(0, Integer.parseInt(npcId))) {
/* 40 */             res.setS2CCode(500);
/* 41 */             res.setS2CMsg(LangService.getValue("TASK_OBJ_FAR_AWAY"));
/* 42 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 46 */           if (!player.functionOpenManager.isOpen(Const.FunctionType.teacher.getValue())) {
/* 47 */             res.setS2CCode(500);
/* 48 */             res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
/* 49 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 53 */           if (player.taskManager.dailyTasks.size() > 0) {
/* 54 */             res.setS2CCode(500);
/* 55 */             res.setS2CMsg(LangService.getValue("DAILY_HAS_ACCEPTED"));
/* 56 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/*    */           
/* 61 */           if (player.taskManager.taskListPO != null && player.taskManager.taskListPO.todayDailyTaskCount >= GlobalConfig.Daily_completeMax) {
/*    */             
/* 63 */             res.setS2CCode(500);
/* 64 */             res.setS2CMsg(LangService.getValue("DAILY_TODAY_MAX"));
/* 65 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/*    */           
/* 70 */           TaskBase prop = TaskUtils.getRDDailyTask(player.getLevel(), 0, player.getPro());
/* 71 */           AcceptTaskHandler.AcceptTaskResult result = player.getPlayerTasks().acceptTask(prop.iD, 2);
/* 72 */           if (result.task != null) {
/* 73 */             result.task.setSecProgress(player.taskManager.getSecProgress(result.task.getKind()));
/* 74 */             player.getPlayerTasks().pushTaskUpdate(result.task);
/* 75 */             res.setS2CCode(200);
/*    */ 
/*    */             
/* 78 */             player.taskManager.dealTaskEvent(Const.TaskType.ACCEPT_DAILY_LOOP, String.valueOf(2), 1);
/* 79 */             player.taskManager.dealTaskEvent(Const.TaskType.ACCEPT_DAILY, String.valueOf(2), 1);
/*    */           } else {
/* 81 */             res.setS2CCode(500);
/* 82 */             res.setS2CMsg(result.msg);
/*    */           } 
/* 84 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\task\AcceptDailyTaskHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */