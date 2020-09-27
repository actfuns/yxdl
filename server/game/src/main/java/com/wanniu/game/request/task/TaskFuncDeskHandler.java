/*    */ package com.wanniu.game.request.task;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
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
/*    */ @GClientEvent("area.taskHandler.taskFuncDeskRequest")
/*    */ public class TaskFuncDeskHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     TaskHandler.TaskFuncDeskRequest req = TaskHandler.TaskFuncDeskRequest.parseFrom(this.pak.getRemaingBytes());
/* 24 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 25 */     final String npcId = req.getC2SNcpId();
/* 26 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 29 */           TaskHandler.TaskFuncDeskResponse.Builder res = TaskHandler.TaskFuncDeskResponse.newBuilder();
/* 30 */           player.getPlayerTasks().dealTaskEvent(Const.TaskType.FUNC_DESK, npcId, 1);
/* 31 */           res.setS2CCode(200);
/* 32 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\task\TaskFuncDeskHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */