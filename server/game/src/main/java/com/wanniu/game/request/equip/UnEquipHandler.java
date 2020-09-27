/*    */ package com.wanniu.game.request.equip;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.bag.WNBag;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.equip.EquipManager;
/*    */ import com.wanniu.game.equip.NormalEquip;
/*    */ import com.wanniu.game.item.NormalItem;
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
/*    */ @GClientEvent("area.equipHandler.unEquipRequest")
/*    */ public class UnEquipHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 28 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 29 */     WNBag wnBag = player.getWnBag();
/* 30 */     EquipManager wnEquip = player.equipManager;
/*    */     
/* 32 */     EquipHandler.UnEquipRequest req = EquipHandler.UnEquipRequest.parseFrom(this.pak.getRemaingBytes());
/* 33 */     int gridIndex = req.getC2SGridIndex();
/*    */     
/* 35 */     NormalEquip normalEquip = wnEquip.getEquipment(gridIndex);
/* 36 */     if (normalEquip == null) {
/* 37 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("EQUIP_NOT_EQUIP"));
/*    */     }
/*    */     
/* 40 */     ((NormalItem)normalEquip).itemDb.isNew = 0;
/* 41 */     if (!wnBag.testAddEntityItem((NormalItem)normalEquip, true)) {
/* 42 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/*    */     }
/*    */     
/* 45 */     wnEquip.unEquip(gridIndex);
/* 46 */     wnBag.addEntityItem((NormalItem)normalEquip, null, null, true, false);
/*    */     
/* 48 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 51 */           EquipHandler.UnEquipResponse.Builder res = EquipHandler.UnEquipResponse.newBuilder();
/* 52 */           res.setS2CCode(200);
/* 53 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\UnEquipHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */