/*    */ package com.wanniu.game.request.task;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.base.TaskBase;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.PlayerUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.task.TaskData;
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
/*    */ @GClientEvent("area.taskHandler.acceptTaskRequest")
/*    */ public class AcceptTaskHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 33 */     TaskHandler.AcceptTaskRequest req = TaskHandler.AcceptTaskRequest.parseFrom(this.pak.getRemaingBytes());
/* 34 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 35 */     final int templateId = req.getC2STemplateId();
/* 36 */     final int kind = req.getC2SKind();
/* 37 */     String npcId = req.getC2SNpcId();
/* 38 */     TaskBase prop = TaskUtils.getTaskProp(templateId);
/* 39 */     if (prop == null) {
/* 40 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
/* 42 */     if (prop.getType() == Const.TaskType.INTERACT_NPC.getValue() && player != null && !player.canTalkWithNpc(templateId, Integer.parseInt(npcId))) {
/* 43 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TASK_OBJ_FAR_AWAY"));
/*    */     }
/*    */     
/* 46 */     if (prop.kind == 2)
/*    */     {
/* 48 */       if (player.taskManager.taskListPO != null && player.taskManager.taskListPO.todayDailyTaskCount >= GlobalConfig.Daily_completeMax) {
/* 49 */         Out.warn(new Object[] { "当日师门任务已达上限，playerId=", player.getId(), ", templateId=", Integer.valueOf(templateId), ",kind=", Integer.valueOf(kind) });
/* 50 */         return (PomeloResponse)new ErrorResponse("系统异常，请联系客服处理");
/*    */       } 
/*    */     }
/*    */     
/* 54 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 57 */           TaskHandler.AcceptTaskResponse.Builder res = TaskHandler.AcceptTaskResponse.newBuilder();
/* 58 */           if (null == player) {
/* 59 */             res.setS2CCode(500);
/* 60 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 61 */             this.body.writeBytes(res.build().toByteArray());
/* 62 */             PlayerUtil.logWarnIfPlayerNull(AcceptTaskHandler.this.pak);
/*    */             return;
/*    */           } 
/* 65 */           AcceptTaskHandler.AcceptTaskResult result = player.getPlayerTasks().acceptTask(templateId, kind);
/* 66 */           if (result.task != null) {
/* 67 */             player.getPlayerTasks().pushTaskUpdate(result.task);
/* 68 */             res.setS2CCode(200);
/*    */           } else {
/* 70 */             res.setS2CCode(500);
/* 71 */             res.setS2CMsg(result.msg);
/*    */           } 
/* 73 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */   
/*    */   public static class AcceptTaskResult
/*    */   {
/*    */     public TaskData task;
/*    */     public String msg;
/*    */     
/*    */     public AcceptTaskResult() {}
/*    */     
/*    */     public AcceptTaskResult(TaskData task, String msg) {
/* 87 */       this.task = task;
/* 88 */       this.msg = msg;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\task\AcceptTaskHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */