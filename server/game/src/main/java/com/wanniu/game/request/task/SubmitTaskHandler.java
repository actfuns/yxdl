/*    */ package com.wanniu.game.request.task;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.task.TaskData;
/*    */ import com.wanniu.game.team.TeamData;
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
/*    */ @GClientEvent("area.taskHandler.submitTaskRequest")
/*    */ public class SubmitTaskHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 29 */     TaskHandler.SubmitTaskRequest req = TaskHandler.SubmitTaskRequest.parseFrom(this.pak.getRemaingBytes());
/* 30 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 31 */     final int templateId = req.getC2STemplateId();
/* 32 */     if (templateId == 0) {
/* 33 */       Out.error(new Object[] { "submitTaskRequest:", player.getName(), "--", Integer.valueOf(templateId) });
/* 34 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("CANNOT_COMPLETE_QUEST"));
/*    */     } 
/* 36 */     final int kind = req.getC2SKind();
/* 37 */     TaskData task = player.getPlayerTasks().getTask(templateId, kind);
/* 38 */     if (task == null)
/*    */     {
/* 40 */       return (PomeloResponse)new ErrorResponse("");
/*    */     }
/*    */     
/* 43 */     String npcId = req.getC2SNpcId();
/* 44 */     if (!player.canTalkWithNpc(templateId, Integer.parseInt(npcId))) {
/* 45 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("TASK_OBJ_FAR_AWAY"));
/*    */     }
/*    */     
/* 48 */     final int isDouble = req.getC2SDouble();
/*    */     
/* 50 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 53 */           TaskHandler.SubmitTaskResponse.Builder res = TaskHandler.SubmitTaskResponse.newBuilder();
/* 54 */           int code = 0;
/*    */           
/* 56 */           if (kind == 3) {
/* 57 */             TeamData team = player.getTeamManager().getTeam();
/* 58 */             if (team == null || !team.leaderId.equals(player.getId())) {
/* 59 */               res.setS2CCode(500);
/* 60 */               res.setS2CMsg(LangService.getValue("TEAM_NO_AUTHORITY"));
/* 61 */               this.body.writeBytes(res.build().toByteArray());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */               
/*    */               return;
/*    */             } 
/*    */           } 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 74 */           code = player.getPlayerTasks().submitTask(templateId, kind, isDouble);
/*    */ 
/*    */           
/* 77 */           if (code == 1) {
/* 78 */             res.setS2CCode(200);
/* 79 */           } else if (code == -2) {
/* 80 */             res.setS2CCode(500);
/*    */           } else {
/* 82 */             res.setS2CCode(500);
/*    */           } 
/*    */ 
/*    */           
/* 86 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\task\SubmitTaskHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */