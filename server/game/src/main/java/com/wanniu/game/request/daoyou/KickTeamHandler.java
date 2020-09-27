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
/*    */ @GClientEvent("daoyou.daoYouHandler.daoYouKickTeamRequest")
/*    */ public class KickTeamHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 26 */     DaoYouHandler.DaoYouKickTeamRequest req = DaoYouHandler.DaoYouKickTeamRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 28 */     final String kickPlayerId = req.getPlayerId();
/*    */     
/* 30 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 34 */           DaoYouHandler.DaoYouKickTeamResponse.Builder res = DaoYouHandler.DaoYouKickTeamResponse.newBuilder();
/*    */           
/* 36 */           String playerId = player.getId();
/* 37 */           String msg = DaoYouService.getInstance().kickDaoYou(playerId, player.getName(), kickPlayerId);
/* 38 */           if (StringUtil.isNotEmpty(msg)) {
/* 39 */             res.setS2CCode(500);
/* 40 */             res.setS2CMsg(msg);
/*    */           } else {
/* 42 */             res.setS2CCode(200);
/*    */           } 
/* 44 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\daoyou\KickTeamHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */