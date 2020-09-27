/*    */ package com.wanniu.game.request.consignment;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.consignmentShop.ConsignmentLineService;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.ConsignmentLineHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.consignmentLineHandler.consignmentListRequest")
/*    */ public class ConsignmentListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 23 */     ConsignmentLineHandler.ConsignmentListRequest msg = ConsignmentLineHandler.ConsignmentListRequest.parseFrom(this.pak.getRemaingBytes());
/* 24 */     int pro = msg.getC2SPro();
/* 25 */     int qColor = msg.getC2SQcolor();
/* 26 */     int order = msg.getC2SOrder();
/* 27 */     int itemSecondType = msg.getC2SItemSecondType();
/* 28 */     int page = msg.getC2SPage();
/* 29 */     String itemType = msg.getC2SItemType();
/* 30 */     int level = msg.getC2SLevel();
/*    */     
/* 32 */     ConsignmentLineService.ConsignmentQueryParam opts = new ConsignmentLineService.ConsignmentQueryParam();
/* 33 */     opts.pro = pro;
/* 34 */     opts.qColor = qColor;
/* 35 */     opts.order = order;
/* 36 */     opts.itemSecondType = itemSecondType;
/* 37 */     opts.page = page;
/* 38 */     opts.itemType = itemType;
/* 39 */     opts.level = level;
/*    */     
/* 41 */     final ConsignmentLineHandler.ConsignmentListResponse.Builder result = ConsignmentLineService.getInstance().query(player, GWorld.__SERVER_ID, opts);
/* 42 */     result.setS2CCode(200);
/*    */     
/* 44 */     player.getPlayerTasks().dealTaskEvent(Const.TaskType.OPEN_SONSIGMENT, 1);
/*    */     
/* 46 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 49 */           this.body.writeBytes(result.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\consignment\ConsignmentListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */