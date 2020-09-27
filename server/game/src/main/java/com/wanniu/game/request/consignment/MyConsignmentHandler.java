/*    */ package com.wanniu.game.request.consignment;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.consignmentShop.ConsignmentUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.ConsignmentLineHandler;
/*    */ import pomelo.item.ItemOuterClass;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.consignmentLineHandler.myConsignmentRequest")
/*    */ public class MyConsignmentHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     ConsignmentLineHandler.MyConsignmentRequest msg = ConsignmentLineHandler.MyConsignmentRequest.parseFrom(this.pak.getRemaingBytes());
/* 22 */     int globalZone = msg.getC2SGlobal();
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           ConsignmentLineHandler.MyConsignmentResponse.Builder res = ConsignmentLineHandler.MyConsignmentResponse.newBuilder();
/* 27 */           res.setS2CCode(200);
/* 28 */           List<ItemOuterClass.ConsignmentItem> list = player.consignmentManager.getAll();
/* 29 */           res.addAllS2CData(list);
/* 30 */           res.setS2CCanSellNum(ConsignmentUtil.sellNum(player));
/* 31 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\consignment\MyConsignmentHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */