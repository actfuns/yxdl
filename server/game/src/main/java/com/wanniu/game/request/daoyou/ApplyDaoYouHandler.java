/*    */ package com.wanniu.game.request.daoyou;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
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
/*    */ @GClientEvent("daoyou.daoYouHandler.daoYouRequest")
/*    */ public class ApplyDaoYouHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 27 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 28 */     if (!player.functionOpenManager.isOpen(Const.FunctionType.DaoYou.getValue())) {
/* 29 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("DAO_YOU_NOT_OPEN"));
/*    */     }
/*    */     
/* 32 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 35 */           DaoYouHandler.DaoYouResponse.Builder res = DaoYouHandler.DaoYouResponse.newBuilder();
/*    */           
/* 37 */           String playerId = player.getId();
/* 38 */           DaoYouService.getInstance().applyDaoYouList(playerId, res);
/* 39 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\daoyou\ApplyDaoYouHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */