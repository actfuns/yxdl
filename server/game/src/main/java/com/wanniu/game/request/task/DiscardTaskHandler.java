/*    */ package com.wanniu.game.request.task;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
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
/*    */ @GClientEvent("area.taskHandler.discardTaskRequest")
/*    */ public class DiscardTaskHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     TaskHandler.DiscardTaskRequest req = TaskHandler.DiscardTaskRequest.parseFrom(this.pak.getRemaingBytes());
/* 26 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 27 */     final int templateId = req.getC2STemplateId();
/* 28 */     final int kind = req.getC2SKind();
/*    */     
/* 30 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 33 */           TaskHandler.DiscardTaskResponse.Builder res = TaskHandler.DiscardTaskResponse.newBuilder();
/*    */           
/* 35 */           if (kind == 3) {
/* 36 */             TeamData team = player.getTeamManager().getTeam();
/* 37 */             if (team != null && !team.leaderId.equals(player.getId())) {
/* 38 */               res.setS2CCode(500);
/* 39 */               res.setS2CMsg(LangService.getValue("TEAM_NO_AUTHORITY"));
/* 40 */               this.body.writeBytes(res.build().toByteArray());
/*    */               
/*    */               return;
/*    */             } 
/*    */           } 
/*    */           
/* 46 */           if (templateId > 0 && player.getPlayerTasks().discardTask(templateId, kind)) {
/* 47 */             res.setS2CCode(200);
/*    */           } else {
/* 49 */             res.setS2CCode(500);
/* 50 */             res.setS2CMsg(LangService.getValue("CANNOT_GIVEUP_QUEST"));
/*    */           } 
/* 52 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\task\DiscardTaskHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */