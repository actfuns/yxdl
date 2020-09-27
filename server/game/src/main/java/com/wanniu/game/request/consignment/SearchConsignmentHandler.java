/*    */ package com.wanniu.game.request.consignment;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.consignmentShop.ConsignmentLineService;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.ConsignmentLineHandler;
/*    */ import pomelo.item.ItemOuterClass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.consignmentLineHandler.searchConsignmentRequest")
/*    */ public class SearchConsignmentHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 23 */     ConsignmentLineHandler.SearchConsignmentRequest msg = ConsignmentLineHandler.SearchConsignmentRequest.parseFrom(this.pak.getRemaingBytes());
/* 24 */     String condition = msg.getC2SCondition();
/* 25 */     final List<ItemOuterClass.ConsignmentItem> result = ConsignmentLineService.getInstance().search(player, GWorld.__SERVER_ID, condition);
/*    */     
/* 27 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 30 */           ConsignmentLineHandler.SearchConsignmentResponse.Builder res = ConsignmentLineHandler.SearchConsignmentResponse.newBuilder();
/* 31 */           res.setS2CCode(200);
/* 32 */           res.addAllS2CData(result);
/* 33 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\consignment\SearchConsignmentHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */