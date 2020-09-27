/*    */ package com.wanniu.game.request.task;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
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
/*    */ @GClientEvent("area.taskHandler.updateTaskStatusRequest")
/*    */ public class UpdateTaskStatusHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     TaskHandler.UpdateTaskStatusRequest req = TaskHandler.UpdateTaskStatusRequest.parseFrom(this.pak.getRemaingBytes());
/* 24 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 25 */     final int templateId = req.getC2STemplateId();
/* 26 */     final int kind = req.getC2SKind();
/* 27 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 30 */           TaskHandler.UpdateTaskStatusResponse.Builder res = TaskHandler.UpdateTaskStatusResponse.newBuilder();
/* 31 */           if (templateId > 0 && player.getPlayerTasks().updateStatus(templateId, kind)) {
/* 32 */             res.setS2CCode(200);
/*    */           } else {
/* 34 */             res.setS2CCode(500);
/* 35 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*    */           } 
/* 37 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\task\UpdateTaskStatusHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */