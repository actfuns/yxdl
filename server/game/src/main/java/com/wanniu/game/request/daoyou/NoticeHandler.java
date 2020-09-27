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
/*    */ @GClientEvent("daoyou.daoYouHandler.daoYouNoticeRequest")
/*    */ public class NoticeHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 26 */     DaoYouHandler.DaoYouNoticeRequest req = DaoYouHandler.DaoYouNoticeRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 28 */     final String notice = req.getNotice();
/* 29 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 33 */           DaoYouHandler.DaoYouNoticeResponse.Builder res = DaoYouHandler.DaoYouNoticeResponse.newBuilder();
/*    */           
/* 35 */           String trimNotice = notice.trim();
/* 36 */           String playerId = player.getId();
/* 37 */           String msg = DaoYouService.getInstance().editNotice(playerId, trimNotice);
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


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\daoyou\NoticeHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */