/*    */ package com.wanniu.game.request.equip;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.equip.EquipManager;
/*    */ import com.wanniu.game.equip.NormalEquip;
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
/*    */ @GClientEvent("area.equipHandler.getRefineExtPropRequest")
/*    */ public class GetRefineExtPropHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 26 */     final EquipManager equipManager = player.equipManager;
/*    */     
/* 28 */     EquipHandler.GetRefineExtPropRequest req = EquipHandler.GetRefineExtPropRequest.parseFrom(this.pak.getRemaingBytes());
/* 29 */     final String equipId = req.getEquipId();
/*    */     
/* 31 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 34 */           EquipHandler.GetRefineExtPropResponse.Builder res = EquipHandler.GetRefineExtPropResponse.newBuilder();
/*    */           
/* 36 */           int pos = equipManager.getEquipmentById(equipId);
/* 37 */           NormalEquip equip = equipManager.getEquipment(pos);
/* 38 */           if (equip == null) {
/* 39 */             equip = (NormalEquip)player.bag.findItemById(equipId);
/*    */           }
/*    */           
/* 42 */           res.addAllExtAtts(equipManager.getRefineExtProp(equip));
/*    */           
/* 44 */           res.setS2CCode(200);
/* 45 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\GetRefineExtPropHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */