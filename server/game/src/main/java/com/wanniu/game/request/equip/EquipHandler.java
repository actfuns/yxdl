/*     */ package com.wanniu.game.request.equip;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.game.bag.WNBag;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.equip.EquipManager;
/*     */ import com.wanniu.game.equip.NormalEquip;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("area.equipHandler.equipRequest")
/*     */ public class EquipHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  32 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  33 */     final WNBag wnBag = player.getWnBag();
/*  34 */     final EquipManager wnEquip = player.equipManager;
/*     */     
/*  36 */     pomelo.area.EquipHandler.EquipRequest req = pomelo.area.EquipHandler.EquipRequest.parseFrom(this.pak.getRemaingBytes());
/*  37 */     final int gridIndex = req.getC2SGridIndex();
/*  38 */     NormalItem item = wnBag.getItem(gridIndex);
/*     */     
/*  40 */     if (item == null) {
/*  41 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("SOMETHING_ERR"));
/*     */     }
/*  43 */     if (!item.isEquip()) {
/*  44 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("ITEM_NOT_EQUIP"));
/*     */     }
/*  46 */     final NormalEquip equip = (NormalEquip)item;
/*  47 */     if (equip.prop.Pro != 0 && 
/*  48 */       equip.prop.Pro != player.getPro()) {
/*  49 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("OCCUPATION_WRONG"));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  54 */     if (equip.getUpLevel() != 0) {
/*  55 */       if (equip.getUpLevel() > (player.getPlayer()).upLevel) {
/*  56 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("UP_NOT_ENOUGH"));
/*     */       }
/*     */     }
/*  59 */     else if (equip.getLevel() > player.getLevel()) {
/*  60 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("LEVEL_NOT_ENOUGH"));
/*     */     } 
/*     */ 
/*     */     
/*  64 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  67 */           pomelo.area.EquipHandler.EquipResponse.Builder res = pomelo.area.EquipHandler.EquipResponse.newBuilder();
/*     */           
/*  69 */           if (equip.prop.itemType == Const.ItemType.Weapon.getValue() && (equip.prop.isBothHand == 1 || wnEquip.haveBothHandWeapon())) {
/*     */             
/*  71 */             int num = player.equipManager.weaponNum();
/*  72 */             num--;
/*  73 */             if (wnBag.emptyGridNum() < num) {
/*  74 */               res.setS2CCode(500);
/*  75 */               res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/*  76 */               this.body.writeBytes(res.build().toByteArray());
/*     */               
/*     */               return;
/*     */             } 
/*  80 */             wnBag.removeItemByPos(gridIndex, false, Const.GOODS_CHANGE_TYPE.equip);
/*  81 */             NormalEquip mainH = wnEquip.getEquipment(Const.EquipType.MAIN_HAND.getValue());
/*  82 */             if (mainH != null) {
/*  83 */               wnBag.addEntityItem((NormalItem)mainH, null, null, true, true);
/*  84 */               wnEquip.unEquip(Const.EquipType.MAIN_HAND.getValue());
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*  91 */             wnEquip.equip(equip);
/*     */ 
/*     */             
/*  94 */             res.setS2CCode(200);
/*  95 */             this.body.writeBytes(res.build().toByteArray());
/*     */             return;
/*     */           } 
/*  98 */           NormalEquip oldEquip = player.equipManager.getEquipment(equip.getPosition());
/*  99 */           wnBag.removeItemByPos(gridIndex, false, Const.GOODS_CHANGE_TYPE.equip);
/* 100 */           if (oldEquip != null) {
/* 101 */             wnBag.addItemToPos(gridIndex, (NormalItem)oldEquip, Const.GOODS_CHANGE_TYPE.equip);
/*     */           }
/* 103 */           wnEquip.equip(equip);
/*     */ 
/*     */           
/* 106 */           res.setS2CCode(200);
/* 107 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\EquipHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */