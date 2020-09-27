/*     */ package com.wanniu.game.request.equip;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.data.ext.SmritiExt;
/*     */ import com.wanniu.game.equip.EquipManager;
/*     */ import com.wanniu.game.equip.NormalEquip;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
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
/*     */ @GClientEvent("area.equipHandler.smritiRequest")
/*     */ public class EquipSmritiHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  34 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  35 */     final EquipManager equipManager = player.equipManager;
/*     */     
/*  37 */     EquipHandler.SmritiRequest req = EquipHandler.SmritiRequest.parseFrom(this.pak.getRemaingBytes());
/*  38 */     String leftEquipId = req.getLetfEquipId();
/*  39 */     String rightEquipId = req.getRightEquipId();
/*  40 */     if (StringUtil.isEmpty(leftEquipId) || StringUtil.isEmpty(rightEquipId) || leftEquipId.endsWith(rightEquipId)) {
/*  41 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("DATA_ERR"));
/*     */     }
/*  43 */     final Object[] leftFlag = checkEquipExists(leftEquipId, player);
/*  44 */     boolean isExists = ((Boolean)leftFlag[0]).booleanValue();
/*  45 */     if (!isExists) {
/*  46 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("BAG_STACKINDEX_ILLEGALITY"));
/*     */     }
/*  48 */     final Object[] rightFlag = checkEquipExists(rightEquipId, player);
/*  49 */     isExists = ((Boolean)rightFlag[0]).booleanValue();
/*  50 */     if (!isExists) {
/*  51 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("BAG_STACKINDEX_ILLEGALITY"));
/*     */     }
/*  53 */     final NormalEquip leftEquip = (NormalEquip)leftFlag[3];
/*  54 */     final NormalEquip rightEquip = (NormalEquip)rightFlag[3];
/*  55 */     if (rightEquip.prop.tcLevel < leftEquip.prop.tcLevel) {
/*  56 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("EQUIP_SMRITI_LEVEL"));
/*     */     }
/*  58 */     if (rightEquip.prop.qcolor < Const.EQUIP_QCOLOR.GREEN.value) {
/*  59 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("EQUIP_SMRITI_QULITY"));
/*     */     }
/*  61 */     if (leftEquip.speData.extAtts == null || leftEquip.speData.extAtts.isEmpty()) {
/*  62 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("EQUIP_SMRITI_CANNOT"));
/*     */     }
/*     */     
/*  65 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  68 */           EquipHandler.SmritiResponse.Builder res = EquipHandler.SmritiResponse.newBuilder();
/*  69 */           if (!player.functionOpenManager.isOpen(Const.FunctionType.Inherit.getValue())) {
/*  70 */             res.setS2CCode(500);
/*  71 */             res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
/*  72 */             this.body.writeBytes(res.build().toByteArray());
/*     */             return;
/*     */           } 
/*  75 */           List<SmritiExt> coList = equipManager.findSmritiCO(leftEquip.prop.tcLevel);
/*  76 */           if (coList == null || coList.isEmpty()) {
/*  77 */             res.setS2CCode(500);
/*  78 */             res.setS2CMsg(LangService.getValue("CONFIG_ERR"));
/*  79 */             this.body.writeBytes(res.build().toByteArray());
/*     */             return;
/*     */           } 
/*  82 */           SmritiExt smritiCo = coList.get(0);
/*     */ 
/*     */           
/*  85 */           for (String mateCode : smritiCo.getNeedItems().keySet()) {
/*  86 */             int mateCount = ((Integer)smritiCo.getNeedItems().get(mateCode)).intValue();
/*     */             
/*  88 */             if (player.bag.findItemNumByCode(mateCode) < mateCount) {
/*  89 */               res.setS2CCode(500);
/*  90 */               res.setS2CMsg(LangService.getValue("ITEM_NOT_ENOUGH"));
/*  91 */               this.body.writeBytes(res.build().toByteArray());
/*     */               return;
/*     */             } 
/*     */           } 
/*  95 */           boolean leftIsDressed = ((Boolean)leftFlag[1]).booleanValue();
/*  96 */           int leftGridIndex = ((Integer)leftFlag[2]).intValue();
/*     */           
/*  98 */           boolean rightIsDressed = ((Boolean)rightFlag[1]).booleanValue();
/*  99 */           int rightGridIndex = ((Integer)rightFlag[2]).intValue();
/*     */           
/* 101 */           if (player.player.gold < smritiCo.costGold) {
/* 102 */             res.setS2CCode(500);
/* 103 */             res.setS2CMsg(LangService.getValue("NOT_ENOUGH_GOLD_LEARN"));
/* 104 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/* 109 */           player.moneyManager.costGold(smritiCo.costGold, Const.GOODS_CHANGE_TYPE.inherit);
/*     */ 
/*     */           
/* 112 */           for (String mateCode : smritiCo.getNeedItems().keySet()) {
/* 113 */             int mateCount = ((Integer)smritiCo.getNeedItems().get(mateCode)).intValue();
/* 114 */             player.bag.discardItem(mateCode, mateCount, Const.GOODS_CHANGE_TYPE.inherit);
/*     */           } 
/* 116 */           equipManager.smritiEquip(leftEquip, leftGridIndex, leftIsDressed, rightEquip, rightGridIndex, rightIsDressed);
/* 117 */           res.setS2CCode(200);
/* 118 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   private Object[] checkEquipExists(String equipId, WNPlayer player) {
/* 125 */     Object[] obj = new Object[4];
/* 126 */     obj[0] = Boolean.valueOf(true);
/* 127 */     obj[1] = Boolean.valueOf(true);
/* 128 */     obj[2] = Integer.valueOf(0);
/* 129 */     EquipManager equipManager = player.equipManager;
/* 130 */     NormalEquip equip = null;
/* 131 */     int gridIndex = equipManager.getEquipmentById(equipId);
/* 132 */     if (gridIndex > 0) {
/* 133 */       equip = equipManager.getEquipment(gridIndex);
/*     */     }
/* 135 */     if (equip == null) {
/* 136 */       obj[1] = Boolean.valueOf(false);
/* 137 */       NormalItem item = player.bag.findItemById(equipId);
/* 138 */       if (item != null) {
/* 139 */         equip = (NormalEquip)item;
/* 140 */         gridIndex = player.bag.findPosById(equipId);
/*     */       } 
/*     */     } 
/* 143 */     if (equip == null) {
/* 144 */       obj[0] = Boolean.valueOf(false);
/*     */     }
/* 146 */     obj[2] = Integer.valueOf(gridIndex);
/* 147 */     obj[3] = equip;
/* 148 */     return obj;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\EquipSmritiHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */