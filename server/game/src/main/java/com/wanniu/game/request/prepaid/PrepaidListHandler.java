/*    */ package com.wanniu.game.request.prepaid;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.PrepaidHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.prepaidHandler.prepaidListRequest")
/*    */ public class PrepaidListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 23 */           PrepaidHandler.PrepaidListResponse.Builder res = PrepaidHandler.PrepaidListResponse.newBuilder();
/* 24 */           List<PrepaidHandler.FeeItem> items = player.prepaidManager.getPrepaidList();
/* 25 */           res.addAllS2CItems(items);
/* 26 */           res.setS2CCode(200);
/* 27 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\prepaid\PrepaidListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */