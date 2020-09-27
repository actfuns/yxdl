/*    */ package com.wanniu.game.request.equip;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.equip.NormalEquip;
/*    */ import com.wanniu.game.item.ItemUtil;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ @GClientEvent("area.equipHandler.equipLevelUpRequest")
/*    */ public class EquipLevelUpHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 32 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 34 */     EquipHandler.EquipLevelUpRequest req = EquipHandler.EquipLevelUpRequest.parseFrom(this.pak.getRemaingBytes());
/* 35 */     final EquipHandler.EquipPos equipPos = req.getC2SEquipPos();
/* 36 */     final int _mateType = req.getC2SMateType();
/*    */     
/* 38 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 41 */           EquipHandler.EquipLevelUpResponse.Builder res = EquipHandler.EquipLevelUpResponse.newBuilder();
/*    */           
/* 43 */           int mateType = _mateType;
/* 44 */           if (mateType != 1 && mateType != 2) {
/* 45 */             res.setS2CCode(500);
/* 46 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 47 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 51 */           NormalEquip oldEquip = (NormalEquip)ItemUtil.getEquip(player, equipPos);
/* 52 */           if (oldEquip == null) {
/* 53 */             res.setS2CCode(500);
/* 54 */             res.setS2CMsg(LangService.getValue("EQUIP_NOT_EXIST"));
/* 55 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 58 */           if (!oldEquip.isEquip()) {
/* 59 */             res.setS2CCode(500);
/* 60 */             res.setS2CMsg(LangService.getValue("ITEM_NOT_EQUIP"));
/* 61 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 64 */           if (oldEquip.prop.itemType != Const.ItemType.Weapon.getValue() && oldEquip.prop.itemType != Const.ItemType.Armor.getValue()) {
/* 65 */             res.setS2CCode(500);
/* 66 */             res.setS2CMsg(LangService.getValue("EQUIP_CAN_NOT_LEVEL_UP"));
/* 67 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 71 */           int minColor = GlobalConfig.Equipment_LvUp_QColor;
/* 72 */           if (oldEquip.prop.qcolor < minColor) {
/* 73 */             res.setS2CCode(500);
/* 74 */             res.setS2CMsg(LangService.getValue("EQUIP_LEVEL_UP_QUALITY_TO_LOW"));
/* 75 */             this.body.writeBytes(res.build().toByteArray());
/*    */ 
/*    */             
/*    */             return;
/*    */           } 
/*    */           
/* 81 */           if (equipPos.getBagOrBody() == Const.EquipPos.BODY.value) {
/* 82 */             player.equipManager.unEquip(oldEquip.getPosition());
/*    */           } else {
/* 84 */             player.getWnBag().removeItemByPos(equipPos.getPosOrGrid(), true, Const.GOODS_CHANGE_TYPE.equipLevelUp);
/*    */           } 
/* 86 */           Map<String, Integer> biItems = new HashMap<>();
/* 87 */           biItems.put(oldEquip.itemDb.code, Integer.valueOf(1));
/*    */           
/* 89 */           res.setS2CCode(200);
/* 90 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\EquipLevelUpHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */