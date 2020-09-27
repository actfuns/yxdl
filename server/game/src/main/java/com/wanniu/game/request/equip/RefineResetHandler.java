/*    */ package com.wanniu.game.request.equip;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
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
/*    */ 
/*    */ @GClientEvent("area.equipHandler.refineResetRequest")
/*    */ public class RefineResetHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 27 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 28 */     final EquipManager wnEquip = player.equipManager;
/*    */     
/* 30 */     EquipHandler.RefineResetRequest req = EquipHandler.RefineResetRequest.parseFrom(this.pak.getRemaingBytes());
/* 31 */     final int equipPos = req.getC2SPos();
/* 32 */     final int propIndex = req.getC2SPropIndex() - 1;
/*    */     
/* 34 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 37 */           EquipHandler.RefineResetResponse.Builder res = EquipHandler.RefineResetResponse.newBuilder();
/*    */           
/* 39 */           if (propIndex < 0) {
/* 40 */             res.setS2CCode(500);
/* 41 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 42 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 45 */           NormalEquip equip = wnEquip.getEquipment(equipPos);
/* 46 */           if (equip == null) {
/* 47 */             res.setS2CCode(500);
/* 48 */             res.setS2CMsg(LangService.getValue("BAG_STACKINDEX_ILLEGALITY"));
/* 49 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 52 */           int result = -1;
/* 53 */           if (result == 0) {
/* 54 */             res.setS2CCode(200);
/* 55 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 57 */           if (result == -1) {
/* 58 */             res.setS2CCode(500);
/* 59 */             res.setS2CMsg(LangService.getValue("REFINE_RESET_PROP_NOT_EXIST"));
/* 60 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 62 */           if (result == -2) {
/* 63 */             res.setS2CCode(500);
/* 64 */             res.setS2CMsg(LangService.getValue("REFINE_RESET_MATE_NOT_ENOUGH"));
/* 65 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 68 */           res.setS2CCode(500);
/* 69 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 70 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\RefineResetHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */