/*     */ package com.wanniu.game.request.equip;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.KaiGuangExt;
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
/*     */ @GClientEvent("area.equipHandler.equipRefineLegendRequest")
/*     */ public class EquipRefineLegendHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  34 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*     */ 
/*     */     
/*  37 */     if (!player.functionOpenManager.isOpen(Const.FunctionType.REFINE.getValue())) {
/*  38 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
/*     */     }
/*     */     
/*  41 */     EquipHandler.EquipRefineLegendRequest req = EquipHandler.EquipRefineLegendRequest.parseFrom(this.pak.getRemaingBytes());
/*  42 */     String equipId = req.getEquipId();
/*  43 */     EquipManager equipManager = player.equipManager;
/*     */     
/*  45 */     boolean isDressed = true;
/*     */     
/*  47 */     NormalEquip equip = null;
/*  48 */     int gridIndex = equipManager.getEquipmentById(equipId);
/*  49 */     if (gridIndex > 0) {
/*  50 */       equip = equipManager.getEquipment(gridIndex);
/*     */     }
/*     */     
/*  53 */     if (equip == null) {
/*  54 */       isDressed = false;
/*  55 */       NormalItem item = player.bag.findItemById(equipId);
/*  56 */       if (item != null) {
/*  57 */         equip = (NormalEquip)item;
/*  58 */         gridIndex = player.bag.findPosById(equipId);
/*     */       } 
/*     */     } 
/*     */     
/*  62 */     if (equip == null) {
/*  63 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("BAG_STACKINDEX_ILLEGALITY"));
/*     */     }
/*     */ 
/*     */     
/*  67 */     if (equip.prop.qcolor <= Const.ItemQuality.PURPLE.getValue()) {
/*  68 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("EQUIP_REFINE_LEGEND_PURPLE"));
/*     */     }
/*     */ 
/*     */     
/*  72 */     KaiGuangExt rebornCO = (KaiGuangExt)GameData.KaiGuangs.get(Integer.valueOf(equip.prop.levelReq));
/*     */     
/*  74 */     if (player.player.gold < rebornCO.costGold) {
/*  75 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("NOT_ENOUGH_GOLD_LEARN"));
/*     */     }
/*     */     
/*  78 */     for (String mateCode : rebornCO.materials.keySet()) {
/*  79 */       int mateCount = ((Integer)rebornCO.materials.get(mateCode)).intValue();
/*  80 */       if (player.bag.findItemNumByCode(mateCode) < mateCount) {
/*  81 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("ITEM_NOT_ENOUGH"));
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  86 */     player.moneyManager.costGold(rebornCO.costGold, Const.GOODS_CHANGE_TYPE.Refine);
/*     */     
/*  88 */     for (String mateCode : rebornCO.materials.keySet()) {
/*  89 */       int mateCount = ((Integer)rebornCO.materials.get(mateCode)).intValue();
/*  90 */       player.bag.discardItem(mateCode, mateCount, Const.GOODS_CHANGE_TYPE.Refine);
/*     */     } 
/*     */ 
/*     */     
/*  94 */     equipManager.refineLegend(equip, gridIndex, isDressed);
/*     */     
/*  96 */     player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.EQUIP_REFINE_COUNT, new Object[0]);
/*     */     
/*  98 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/* 101 */           EquipHandler.EquipRefineLegendResponse.Builder res = EquipHandler.EquipRefineLegendResponse.newBuilder();
/* 102 */           res.setS2CCode(200);
/* 103 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\EquipRefineLegendHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */