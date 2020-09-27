/*    */ package com.wanniu.game.request.equip;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.bag.WNBag;
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
/*    */ 
/*    */ @Deprecated
/*    */ @GClientEvent("area.equipHandler.fillAllGemRequest")
/*    */ public class FillAllGemHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 26 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 27 */     WNBag wnBag = player.getWnBag();
/*    */     
/* 29 */     EquipHandler.FillAllGemRequest req = EquipHandler.FillAllGemRequest.parseFrom(this.pak.getRemaingBytes());
/* 30 */     int pos = req.getC2SPos();
/*    */     
/* 32 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 35 */           EquipHandler.FillAllGemResponse.Builder res = EquipHandler.FillAllGemResponse.newBuilder();
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\FillAllGemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */