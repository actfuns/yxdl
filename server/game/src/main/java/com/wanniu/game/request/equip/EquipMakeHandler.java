/*     */ package com.wanniu.game.request.equip;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.bag.WNBag;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.ext.EquipMakeExt;
/*     */ import com.wanniu.game.equip.EquipCraftConfig;
/*     */ import com.wanniu.game.equip.EquipCraftUtil;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.item.po.DetailItemNum;
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
/*     */ 
/*     */ @GClientEvent("area.equipHandler.equipMakeRequest")
/*     */ public class EquipMakeHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  37 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*     */     
/*  39 */     EquipHandler.EquipMakeRequest req = EquipHandler.EquipMakeRequest.parseFrom(this.pak.getRemaingBytes());
/*  40 */     final String targetCode = req.getC2STargetCode();
/*     */     
/*  42 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  45 */           EquipHandler.EquipMakeResponse.Builder res = EquipHandler.EquipMakeResponse.newBuilder();
/*     */ 
/*     */           
/*  48 */           if (!player.functionOpenManager.isOpen(Const.FunctionType.Make.getValue())) {
/*  49 */             res.setS2CCode(500);
/*  50 */             res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
/*  51 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  55 */           if (StringUtil.isEmpty(targetCode)) {
/*  56 */             res.setS2CCode(500);
/*  57 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*  58 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  62 */           EquipMakeExt makeProp = EquipCraftConfig.getInstance().getEquipMakePropByCode(targetCode);
/*  63 */           if (makeProp == null) {
/*  64 */             res.setS2CCode(500);
/*  65 */             res.setS2CMsg(LangService.getValue("EQUIP_MAKE_NOT_MAKE_PAPER"));
/*  66 */             this.body.writeBytes(res.build().toByteArray());
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  72 */           if (player.player.gold < makeProp.costMoney) {
/*  73 */             res.setS2CCode(500);
/*  74 */             res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
/*  75 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  79 */           List<WNBag.SimpleItemInfo> reqMate = makeProp.reqMate;
/*  80 */           for (int i = 0; i < reqMate.size(); i++) {
/*  81 */             WNBag.SimpleItemInfo itemInfo = reqMate.get(i);
/*  82 */             DetailItemNum mateInfo = player.getWnBag().findDetailItemNumByCode(itemInfo.itemCode);
/*  83 */             if (mateInfo.totalNum < itemInfo.itemNum) {
/*  84 */               res.setS2CCode(500);
/*  85 */               res.setS2CMsg(LangService.getValue("EQUIP_MAKE_MATE_NOT_ENOUGH"));
/*  86 */               this.body.writeBytes(res.build().toByteArray());
/*     */ 
/*     */ 
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/*  95 */           Const.ForceType forceType = Const.ForceType.BIND;
/*  96 */           if (!player.getWnBag().testAddCodeItem(targetCode, 1, forceType, true)) {
/*  97 */             res.setS2CCode(500);
/*  98 */             res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/*  99 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/* 104 */           player.moneyManager.costGold(makeProp.costMoney, Const.GOODS_CHANGE_TYPE.equipMake);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 111 */           for (int j = 0; j < reqMate.size(); j++) {
/* 112 */             WNBag.SimpleItemInfo mateInfo = reqMate.get(j);
/* 113 */             player.getWnBag().discardItem(mateInfo.itemCode, mateInfo.itemNum, Const.GOODS_CHANGE_TYPE.equipMake, null, false, false);
/*     */           } 
/*     */ 
/*     */           
/* 117 */           NormalItem newEquip = ItemUtil.createItemsByItemCode(targetCode, 1).get(0);
/* 118 */           newEquip.setBind(ItemUtil.getPropBindType(newEquip.prop, forceType));
/* 119 */           player.getWnBag().addEntityItem(newEquip, Const.GOODS_CHANGE_TYPE.equipMake, null, false, false);
/* 120 */           EquipCraftUtil.sendEquipMakeMsg(player, newEquip);
/*     */ 
/*     */           
/* 123 */           player.taskManager.dealTaskEvent(Const.TaskType.EQUIP_MAKE, "", 1);
/*     */           
/* 125 */           player.achievementManager.onEquipMake();
/*     */           
/* 127 */           player.equipManager.updateMakeScript(null);
/*     */           
/* 129 */           res.setS2CCode(200);
/* 130 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\EquipMakeHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */