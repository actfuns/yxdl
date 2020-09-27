/*    */ package com.wanniu.game.request.team;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.team.TeamUtil;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.TeamHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.teamHandler.leaveAcrossMatchRequest")
/*    */ public class LeaveAcrossMatchHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 23 */     TeamUtil.removeAcrossMatch(player);
/*    */     
/* 25 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 28 */           TeamHandler.LeaveAcrossMatchResponse.Builder res = TeamHandler.LeaveAcrossMatchResponse.newBuilder();
/* 29 */           res.setS2CCode(200);
/* 30 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\team\LeaveAcrossMatchHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */