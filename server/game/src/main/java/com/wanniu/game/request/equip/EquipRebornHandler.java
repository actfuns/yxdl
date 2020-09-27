/*     */ package com.wanniu.game.request.equip;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.ReBornExt;
/*     */ import com.wanniu.game.equip.EquipManager;
/*     */ import com.wanniu.game.equip.NormalEquip;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*     */ import java.io.IOException;
/*     */ import pomelo.area.EquipHandler;
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
/*     */ @GClientEvent("area.equipHandler.equipRebornRequest")
/*     */ public class EquipRebornHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  33 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  34 */     final EquipManager equipManager = player.equipManager;
/*     */     
/*  36 */     EquipHandler.EquipRebornRequest req = EquipHandler.EquipRebornRequest.parseFrom(this.pak.getRemaingBytes());
/*  37 */     final String equipId = req.getEquipId();
/*     */     
/*  39 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  42 */           EquipHandler.EquipRebornResponse.Builder res = EquipHandler.EquipRebornResponse.newBuilder();
/*     */           
/*  44 */           if (!player.functionOpenManager.isOpen(Const.FunctionType.Reborn.getValue())) {
/*  45 */             res.setS2CCode(500);
/*  46 */             res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
/*  47 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  51 */           boolean isDressed = true;
/*  52 */           NormalEquip equip = null;
/*  53 */           int gridIndex = equipManager.getEquipmentById(equipId);
/*  54 */           if (gridIndex > 0) {
/*  55 */             equip = equipManager.getEquipment(gridIndex);
/*     */           }
/*     */           
/*  58 */           if (equip == null) {
/*  59 */             isDressed = false;
/*  60 */             NormalItem item = player.bag.findItemById(equipId);
/*  61 */             if (item != null) {
/*  62 */               equip = (NormalEquip)item;
/*  63 */               gridIndex = player.bag.findPosById(equipId);
/*     */             } 
/*     */           } 
/*     */           
/*  67 */           if (equip == null) {
/*  68 */             res.setS2CCode(500);
/*  69 */             res.setS2CMsg(LangService.getValue("BAG_STACKINDEX_ILLEGALITY"));
/*  70 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  74 */           ReBornExt rebornCO = (ReBornExt)GameData.ReBorns.get(Integer.valueOf(equip.prop.levelReq));
/*     */           
/*  76 */           if (player.player.gold < rebornCO.costGold) {
/*  77 */             res.setS2CCode(500);
/*  78 */             res.setS2CMsg(LangService.getValue("NOT_ENOUGH_GOLD_LEARN"));
/*  79 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  83 */           for (String mateCode : rebornCO.materials.keySet()) {
/*  84 */             int mateCount = ((Integer)rebornCO.materials.get(mateCode)).intValue();
/*  85 */             if (player.bag.findItemNumByCode(mateCode) < mateCount) {
/*  86 */               res.setS2CCode(500);
/*  87 */               res.setS2CMsg(LangService.getValue("ITEM_NOT_ENOUGH"));
/*  88 */               this.body.writeBytes(res.build().toByteArray());
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*  93 */           player.moneyManager.costGold(rebornCO.costGold, Const.GOODS_CHANGE_TYPE.Reborn);
/*     */ 
/*     */           
/*  96 */           for (String mateCode : rebornCO.materials.keySet()) {
/*  97 */             int mateCount = ((Integer)rebornCO.materials.get(mateCode)).intValue();
/*  98 */             player.bag.discardItem(mateCode, mateCount, Const.GOODS_CHANGE_TYPE.Reborn);
/*     */           } 
/*     */ 
/*     */           
/* 102 */           equipManager.reborn(equip, gridIndex, isDressed);
/*     */           
/* 104 */           player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.EQUIP_REBORN_COUNT, new Object[0]);
/*     */           
/* 106 */           res.setS2CCode(200);
/* 107 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\EquipRebornHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */