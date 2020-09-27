/*    */ package com.wanniu.game.request.equip;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.equip.Suit;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.EquipHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.equipHandler.getSuitDetailRequest")
/*    */ public class GetSuitDetailHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 26 */     EquipHandler.GetSuitDetailRequest req = EquipHandler.GetSuitDetailRequest.parseFrom(this.pak.getRemaingBytes());
/* 27 */     final int suitType = req.getC2SSuitType();
/*    */     
/* 29 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 32 */           EquipHandler.GetSuitDetailResponse.Builder res = EquipHandler.GetSuitDetailResponse.newBuilder();
/*    */ 
/*    */           
/* 35 */           res.setS2CCode(200);
/* 36 */           res.addAllS2CData(Suit.getSuitTypeDetail(player.getPro(), suitType));
/*    */           
/* 38 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\GetSuitDetailHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */