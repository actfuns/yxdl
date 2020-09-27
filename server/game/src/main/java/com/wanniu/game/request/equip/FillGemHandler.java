/*    */ package com.wanniu.game.request.equip;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.bag.WNBag;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.EquipSockExt;
/*    */ import com.wanniu.game.item.NormalItem;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.PlayerBasePO;
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
/*    */ @GClientEvent("area.equipHandler.fillGemRequest")
/*    */ public class FillGemHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 30 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 31 */     final WNBag wnBag = player.getWnBag();
/*    */     
/* 33 */     EquipHandler.FillGemRequest req = EquipHandler.FillGemRequest.parseFrom(this.pak.getRemaingBytes());
/* 34 */     final int pos = req.getC2SPos();
/*    */     
/* 36 */     final int gridIndex = req.getC2SGridIndex();
/*    */     
/* 38 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 41 */           EquipHandler.FillGemResponse.Builder res = EquipHandler.FillGemResponse.newBuilder();
/*    */           
/* 43 */           if (!player.functionOpenManager.isOpen(Const.FunctionType.SetNew.getValue())) {
/* 44 */             res.setS2CCode(500);
/* 45 */             res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
/* 46 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 50 */           NormalItem item = wnBag.getItem(gridIndex);
/* 51 */           if (item == null || item.prop.itemSecondType != Const.ItemSecondType.gem.getValue()) {
/* 52 */             res.setS2CCode(500);
/* 53 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 54 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/*    */           
/* 59 */           if (!((EquipSockExt)GameData.EquipSocks.get(Integer.valueOf(pos))).typeList.contains(item.itemDb.code)) {
/* 60 */             res.setS2CCode(500);
/* 61 */             res.setS2CMsg(LangService.getValue("EQUIP_CANNOT_USE_GEM"));
/* 62 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/*    */           
/* 67 */           PlayerBasePO.EquipStrengthPos posInfo = (PlayerBasePO.EquipStrengthPos)player.equipManager.strengthPos.get(Integer.valueOf(pos));
/* 68 */           if (posInfo == null) {
/* 69 */             res.setS2CCode(500);
/* 70 */             res.setS2CMsg(LangService.getValue("EQUIP_POS_NOT_EXIST"));
/* 71 */             this.body.writeBytes(res.build().toByteArray());
/*    */ 
/*    */             
/*    */             return;
/*    */           } 
/*    */           
/* 77 */           int[] index = { -1 };
/* 78 */           if (player.equipManager.fillGem(pos, index, item.prop.code, player)) {
/* 79 */             wnBag.discardItemByPos(gridIndex, 1, false, Const.GOODS_CHANGE_TYPE.equipmosaic);
/* 80 */             if (index[0] != -1) {
/* 81 */               res.setS2CIndex(index[0]);
/*    */             }
/* 83 */             res.setS2CCode(200);
/* 84 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } else {
/* 86 */             res.setS2CCode(500);
/* 87 */             res.setS2CMsg(LangService.getValue("EQUIP_FILL_ERROR"));
/* 88 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\FillGemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */