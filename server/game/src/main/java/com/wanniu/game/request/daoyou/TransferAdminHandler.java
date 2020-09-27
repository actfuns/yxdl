/*    */ package com.wanniu.game.request.daoyou;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("daoyou.daoYouHandler.daoYouTransferAdminRequest")
/*    */ public class TransferAdminHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 30 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 32 */     DaoYouHandler.DaoYouTransferAdminRequest req = DaoYouHandler.DaoYouTransferAdminRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 34 */     final String newAdminPlayerId = req.getPlayerId();
/*    */     
/* 36 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 40 */           DaoYouHandler.DaoYouKickTeamResponse.Builder res = DaoYouHandler.DaoYouKickTeamResponse.newBuilder();
/*    */           try {
/* 42 */             if (null == player) {
/* 43 */               res.setS2CCode(500);
/* 44 */               res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 45 */               this.body.writeBytes(res.build().toByteArray());
/*    */               
/*    */               return;
/*    */             } 
/* 49 */             String msg = DaoYouService.getInstance().transferAdmin(player, newAdminPlayerId);
/* 50 */             if (!msg.equals("")) {
/* 51 */               res.setS2CCode(500);
/* 52 */               res.setS2CMsg(msg);
/* 53 */               this.body.writeBytes(res.build().toByteArray());
/*    */               return;
/*    */             } 
/* 56 */             res.setS2CCode(200);
/* 57 */             this.body.writeBytes(res.build().toByteArray());
/*    */           }
/* 59 */           catch (Exception err) {
/* 60 */             Out.error(new Object[] { err });
/* 61 */             res.setS2CCode(500);
/* 62 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\daoyou\TransferAdminHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */