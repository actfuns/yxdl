/*    */ package com.wanniu.game.request.item;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.bag.WNBag;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import pomelo.area.ItemHandler;
/*    */ import pomelo.item.ItemOuterClass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.itemHandler.getAllEquipDetailsRequest")
/*    */ public class GetAllEquipDetailsHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 27 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 28 */     final WNBag wnBag = player.getWnBag();
/*    */     
/* 30 */     ItemHandler.GetAllEquipDetailsRequest req = ItemHandler.GetAllEquipDetailsRequest.parseFrom(this.pak.getRemaingBytes());
/*    */ 
/*    */     
/* 33 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 36 */           ItemHandler.GetAllEquipDetailsResponse.Builder res = ItemHandler.GetAllEquipDetailsResponse.newBuilder();
/*    */           
/* 38 */           List<ItemOuterClass.ItemDetail> data = new ArrayList<>();
/* 39 */           data.addAll(wnBag.getAllEquipDetails4PayLoad());
/* 40 */           data.addAll(player.equipManager.getAllEquipDetails4PayLoad());
/* 41 */           data.addAll(player.wareHouse.getAllEquipDetails4PayLoad());
/*    */           
/* 43 */           res.setS2CCode(200);
/* 44 */           res.addAllS2CItems(data);
/* 45 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\item\GetAllEquipDetailsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */