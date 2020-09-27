/*     */ package com.wanniu.game.request.equip;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.game.bag.WNBag;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.ext.EnchantExt;
/*     */ import com.wanniu.game.equip.EquipManager;
/*     */ import com.wanniu.game.equip.EquipUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.PlayerBasePO;
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
/*     */ @GClientEvent("area.equipHandler.equipStrengthenRequest")
/*     */ public class EquipStrengthenHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  31 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  32 */     final WNBag wnBag = player.getWnBag();
/*  33 */     final EquipManager wnEquip = player.equipManager;
/*     */     
/*  35 */     EquipHandler.EquipStrengthenRequest req = EquipHandler.EquipStrengthenRequest.parseFrom(this.pak.getRemaingBytes());
/*  36 */     final int pos = req.getC2SPos();
/*     */     
/*  38 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  41 */           EquipHandler.EquipStrengthenResponse.Builder res = EquipHandler.EquipStrengthenResponse.newBuilder();
/*     */           
/*  43 */           if (!player.functionOpenManager.isOpen(Const.FunctionType.STRENGTHEN.getValue())) {
/*  44 */             res.setS2CCode(500);
/*  45 */             res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
/*  46 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  50 */           PlayerBasePO.EquipStrengthPos strengthPos = (PlayerBasePO.EquipStrengthPos)player.equipManager.strengthPos.get(Integer.valueOf(pos));
/*  51 */           if (strengthPos == null) {
/*  52 */             res.setS2CCode(500);
/*  53 */             res.setS2CMsg(LangService.getValue("EQUIP_POS_NOT_EXIST"));
/*  54 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  58 */           if (EquipUtil.isMaxStrengthLevel(strengthPos.enSection, strengthPos.enLevel)) {
/*  59 */             res.setS2CCode(500);
/*  60 */             res.setS2CMsg(LangService.getValue("EQUIP_MAX_STRENGTH_LEVEL"));
/*  61 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  65 */           EnchantExt prop = EquipUtil.getStrengthConfig(strengthPos.enSection, strengthPos.enLevel);
/*  66 */           if (prop == null) {
/*  67 */             res.setS2CCode(500);
/*  68 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*  69 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  73 */           if (player.moneyManager.getGold() < prop.costGold) {
/*  74 */             res.setS2CCode(500);
/*  75 */             res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
/*  76 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  81 */           for (String mateCode : prop.mates.keySet()) {
/*  82 */             int haveNum = wnBag.findItemNumByCode(mateCode);
/*  83 */             int needNum = prop.mates.getIntValue(mateCode);
/*  84 */             if (haveNum < needNum) {
/*  85 */               res.setS2CCode(500);
/*  86 */               res.setS2CMsg(LangService.getValue("ITEM_NOT_ENOUGH"));
/*  87 */               this.body.writeBytes(res.build().toByteArray());
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*     */           
/*  93 */           for (String mateCode : prop.mates.keySet()) {
/*  94 */             int needNum = prop.mates.getIntValue(mateCode);
/*  95 */             wnBag.discardItem(mateCode, needNum, Const.GOODS_CHANGE_TYPE.equipstrengh, null, false, false);
/*     */           } 
/*     */           
/*  98 */           player.moneyManager.costGold(prop.costGold, Const.GOODS_CHANGE_TYPE.equipstrengh);
/*     */           
/* 100 */           Object[] result = wnEquip.equipStrengthen(pos);
/*     */           
/* 102 */           res.setS2CStrengthenData(EquipUtil.getStrengthInfo(player, pos));
/* 103 */           if (((Boolean)result[0]).booleanValue()) {
/* 104 */             res.setS2CSuccess(1);
/*     */           } else {
/* 106 */             res.setS2CSuccess(1);
/*     */           } 
/*     */           
/* 109 */           res.setS2CCode(200);
/* 110 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\EquipStrengthenHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */