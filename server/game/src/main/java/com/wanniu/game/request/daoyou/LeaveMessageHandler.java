/*    */ package com.wanniu.game.request.daoyou;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.daoyou.DaoYouService;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.daoyou.DaoYouHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("daoyou.daoYouHandler.daoYouLeaveMessageRequest")
/*    */ public class LeaveMessageHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 26 */     DaoYouHandler.DaoYouLeaveMessageRequest req = DaoYouHandler.DaoYouLeaveMessageRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 28 */     final String messsage = req.getMessage();
/* 29 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 33 */           DaoYouHandler.DaoYouLeaveMessageResponse.Builder res = DaoYouHandler.DaoYouLeaveMessageResponse.newBuilder();
/* 34 */           String trimMessage = messsage.trim();
/* 35 */           String msg = DaoYouService.getInstance().leaveMessage(player, trimMessage);
/* 36 */           if (StringUtil.isNotEmpty(msg)) {
/* 37 */             res.setS2CCode(500);
/* 38 */             res.setS2CMsg(msg);
/*    */           } else {
/* 40 */             res.setS2CCode(200);
/*    */           } 
/* 42 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\daoyou\LeaveMessageHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */