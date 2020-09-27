/*     */ package com.wanniu.game.request.equip;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.SeniorReBuildExt;
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
/*     */ @GClientEvent("area.equipHandler.equipSeniorRebuildRequest")
/*     */ public class EquipSeniorRebuildHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  33 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  34 */     final EquipManager equipManager = player.equipManager;
/*     */     
/*  36 */     EquipHandler.EquipSeniorRebuildRequest req = EquipHandler.EquipSeniorRebuildRequest.parseFrom(this.pak.getRemaingBytes());
/*  37 */     final String equipId = req.getEquipId();
/*     */     
/*  39 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  42 */           EquipHandler.EquipSeniorRebuildResponse.Builder res = EquipHandler.EquipSeniorRebuildResponse.newBuilder();
/*  43 */           if (!player.functionOpenManager.isOpen(Const.FunctionType.Rebuild.getValue())) {
/*  44 */             res.setS2CCode(500);
/*  45 */             res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
/*  46 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
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
/*  74 */           SeniorReBuildExt seniorRebuildExt = (SeniorReBuildExt)GameData.SeniorReBuilds.get(Integer.valueOf(equip.prop.levelReq));
/*     */ 
/*     */ 
/*     */           
/*  78 */           if (player.player.gold < seniorRebuildExt.costGold) {
/*  79 */             res.setS2CCode(500);
/*  80 */             res.setS2CMsg(LangService.getValue("NOT_ENOUGH_GOLD_LEARN"));
/*  81 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  85 */           for (String mateCode : seniorRebuildExt.materials.keySet()) {
/*  86 */             int mateCount = ((Integer)seniorRebuildExt.materials.get(mateCode)).intValue();
/*     */             
/*  88 */             if (player.bag.findItemNumByCode(mateCode) < mateCount) {
/*  89 */               res.setS2CCode(500);
/*  90 */               res.setS2CMsg(LangService.getValue("ITEM_NOT_ENOUGH"));
/*  91 */               this.body.writeBytes(res.build().toByteArray());
/*     */ 
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/*  99 */           player.moneyManager.costGold(seniorRebuildExt.costGold, Const.GOODS_CHANGE_TYPE.SeniorRebuild);
/*     */ 
/*     */           
/* 102 */           for (String mateCode : seniorRebuildExt.materials.keySet()) {
/* 103 */             int mateCount = ((Integer)seniorRebuildExt.materials.get(mateCode)).intValue();
/*     */             
/* 105 */             player.bag.discardItem(mateCode, mateCount, Const.GOODS_CHANGE_TYPE.SeniorRebuild);
/*     */           } 
/*     */ 
/*     */           
/* 109 */           equipManager.seniorRebuild(equip, gridIndex, isDressed);
/* 110 */           player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.EQUIP_REBUILD_COUNT, new Object[0]);
/*     */           
/* 112 */           res.setS2CCode(200);
/* 113 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\EquipSeniorRebuildHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */