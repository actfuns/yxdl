/*    */ package com.wanniu.game.request.equip;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.bag.WNBag;
/*    */ import com.wanniu.game.equip.EquipManager;
/*    */ import com.wanniu.game.equip.EquipUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.PlayerBasePO;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
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
/*    */ 
/*    */ @GClientEvent("area.equipHandler.unFillGemRequest")
/*    */ public class UnFillGemHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 31 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 32 */     final WNBag wnBag = player.getWnBag();
/* 33 */     final EquipManager wnEquip = player.equipManager;
/*    */     
/* 35 */     EquipHandler.UnFillGemRequest req = EquipHandler.UnFillGemRequest.parseFrom(this.pak.getRemaingBytes());
/* 36 */     final int pos = req.getC2SPos();
/* 37 */     final int index = req.getC2SIndex();
/*    */     
/* 39 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 42 */           EquipHandler.UnFillGemResponse.Builder res = EquipHandler.UnFillGemResponse.newBuilder();
/* 43 */           PlayerBasePO.EquipStrengthPos posInfo = (PlayerBasePO.EquipStrengthPos)wnEquip.strengthPos.get(Integer.valueOf(pos));
/* 44 */           if (posInfo == null) {
/* 45 */             res.setS2CCode(500);
/* 46 */             res.setS2CMsg(LangService.getValue("EQUIP_NOT_EXIST"));
/* 47 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 51 */           List<WNBag.SimpleItemInfo> gemList = EquipUtil.getGemList(posInfo, index);
/* 52 */           if (gemList.size() == 0) {
/* 53 */             res.setS2CCode(500);
/* 54 */             res.setS2CMsg(LangService.getValue("EQUIP_UNFILL_ERROR"));
/* 55 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 59 */           if (!wnBag.testAddCodeItems(gemList, null, false)) {
/* 60 */             res.setS2CCode(500);
/* 61 */             res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/* 62 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 66 */           if (wnEquip.unfillGem(pos, index)) {
/* 67 */             res.setS2CCode(200);
/* 68 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 72 */           res.setS2CCode(500);
/* 73 */           res.setS2CMsg(LangService.getValue("EQUIP_UNFILL_ERROR"));
/* 74 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\UnFillGemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */