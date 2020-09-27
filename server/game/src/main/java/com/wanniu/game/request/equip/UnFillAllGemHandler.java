/*    */ package com.wanniu.game.request.equip;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.bag.WNBag;
/*    */ import com.wanniu.game.equip.EquipManager;
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
/*    */ @GClientEvent("area.equipHandler.unFillAllGemRequest")
/*    */ public class UnFillAllGemHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 27 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 28 */     WNBag wnBag = player.getWnBag();
/* 29 */     EquipManager wnEquip = player.equipManager;
/*    */     
/* 31 */     EquipHandler.UnFillAllGemRequest req = EquipHandler.UnFillAllGemRequest.parseFrom(this.pak.getRemaingBytes());
/* 32 */     int pos = req.getC2SPos();
/*    */     
/* 34 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 37 */           EquipHandler.UnFillAllGemResponse.Builder res = EquipHandler.UnFillAllGemResponse.newBuilder();
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\UnFillAllGemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */