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
/*    */ @GClientEvent("daoyou.daoYouHandler.daoYouFastInviteDaoYouRequest")
/*    */ public class FastInviteDaoYouHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 25 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 29 */           DaoYouHandler.DaoYouFastInviteDaoYouResponse.Builder res = DaoYouHandler.DaoYouFastInviteDaoYouResponse.newBuilder();
/*    */           
/* 31 */           String msg = DaoYouService.getInstance().fastInviteDaoYouCreateTeam(player);
/* 32 */           if (StringUtil.isNotEmpty(msg)) {
/* 33 */             res.setS2CCode(500);
/* 34 */             res.setS2CMsg(msg);
/*    */           } else {
/* 36 */             res.setS2CCode(200);
/*    */           } 
/* 38 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\daoyou\FastInviteDaoYouHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */