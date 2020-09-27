/*     */ package com.wanniu.game.request.equip;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.ext.ReBuildExt;
/*     */ import com.wanniu.game.equip.EquipManager;
/*     */ import com.wanniu.game.equip.NormalEquip;
/*     */ import com.wanniu.game.item.ItemConfig;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ @GClientEvent("area.equipHandler.equipRebuildRequest")
/*     */ public class EquipRebuildHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  34 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  35 */     final EquipManager equipManager = player.equipManager;
/*     */     
/*  37 */     EquipHandler.EquipRebuildRequest req = EquipHandler.EquipRebuildRequest.parseFrom(this.pak.getRemaingBytes());
/*  38 */     final String equipId = req.getEquipId();
/*  39 */     final List<Integer> lockedAttIdList = req.getLockedAttIdList();
/*     */     
/*  41 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  44 */           EquipHandler.EquipRebuildResponse.Builder res = EquipHandler.EquipRebuildResponse.newBuilder();
/*  45 */           if (!player.functionOpenManager.isOpen(Const.FunctionType.Rebuild.getValue())) {
/*  46 */             res.setS2CCode(500);
/*  47 */             res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
/*  48 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  53 */           boolean isDressed = true;
/*  54 */           NormalEquip equip = null;
/*  55 */           int gridIndex = equipManager.getEquipmentById(equipId);
/*  56 */           if (gridIndex > 0) {
/*  57 */             equip = equipManager.getEquipment(gridIndex);
/*     */           }
/*     */           
/*  60 */           if (equip == null) {
/*  61 */             isDressed = false;
/*  62 */             NormalItem item = player.bag.findItemById(equipId);
/*  63 */             if (item != null) {
/*  64 */               equip = (NormalEquip)item;
/*  65 */               gridIndex = player.bag.findPosById(equipId);
/*     */             } 
/*     */           } 
/*     */           
/*  69 */           if (equip == null) {
/*  70 */             res.setS2CCode(500);
/*  71 */             res.setS2CMsg(LangService.getValue("BAG_STACKINDEX_ILLEGALITY"));
/*  72 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  77 */           if (!equipManager.checkRebuildLocks(lockedAttIdList, equip.speData.extAtts.size())) {
/*  78 */             res.setS2CCode(500);
/*  79 */             res.setS2CMsg(LangService.getValue("EQUIP_LOCKED_ID_ERR"));
/*  80 */             this.body.writeBytes(res.build().toByteArray());
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */ 
/*     */           
/*  87 */           ReBuildExt rebornCO = (ReBuildExt)((Map)(ItemConfig.getInstance()).rebuildMap.get(Integer.valueOf(equip.prop.levelReq))).get(Integer.valueOf(lockedAttIdList.size()));
/*     */ 
/*     */           
/*  90 */           if (player.player.gold < rebornCO.costGold) {
/*  91 */             res.setS2CCode(500);
/*  92 */             res.setS2CMsg(LangService.getValue("NOT_ENOUGH_GOLD_LEARN"));
/*  93 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  97 */           for (String mateCode : rebornCO.materials.keySet()) {
/*  98 */             int mateCount = ((Integer)rebornCO.materials.get(mateCode)).intValue();
/*     */             
/* 100 */             if (player.bag.findItemNumByCode(mateCode) < mateCount) {
/* 101 */               res.setS2CCode(500);
/* 102 */               res.setS2CMsg(LangService.getValue("ITEM_NOT_ENOUGH"));
/* 103 */               this.body.writeBytes(res.build().toByteArray());
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*     */           
/* 109 */           player.moneyManager.costGold(rebornCO.costGold, Const.GOODS_CHANGE_TYPE.Rebuild);
/*     */ 
/*     */           
/* 112 */           for (String mateCode : rebornCO.materials.keySet()) {
/* 113 */             int mateCount = ((Integer)rebornCO.materials.get(mateCode)).intValue();
/*     */             
/* 115 */             if (!player.bag.discardItem(mateCode, mateCount, Const.GOODS_CHANGE_TYPE.Rebuild)) {
/* 116 */               res.setS2CCode(500);
/* 117 */               res.setS2CMsg(LangService.getValue("ITEM_NOT_ENOUGH"));
/* 118 */               this.body.writeBytes(res.build().toByteArray());
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*     */           
/* 124 */           equipManager.rebuild(equip, gridIndex, isDressed, lockedAttIdList);
/*     */           
/* 126 */           player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.EQUIP_REBUILD_COUNT, new Object[0]);
/*     */           
/* 128 */           res.setS2CCode(200);
/* 129 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\EquipRebuildHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */