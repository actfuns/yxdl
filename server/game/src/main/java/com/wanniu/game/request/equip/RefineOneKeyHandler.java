/*     */ package com.wanniu.game.request.equip;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.equip.EquipManager;
/*     */ import com.wanniu.game.equip.NormalEquip;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.io.IOException;
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
/*     */ 
/*     */ @GClientEvent("area.equipHandler.refineOneKeyRequest")
/*     */ public class RefineOneKeyHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  32 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  33 */     final EquipManager wnEquip = player.equipManager;
/*     */     
/*  35 */     EquipHandler.RefineOneKeyRequest req = EquipHandler.RefineOneKeyRequest.parseFrom(this.pak.getRemaingBytes());
/*  36 */     final int equipPos = req.getC2SPos();
/*  37 */     final String itemCode = req.getC2SItemCode();
/*     */     
/*  39 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  42 */           EquipHandler.RefineOneKeyResponse.Builder res = EquipHandler.RefineOneKeyResponse.newBuilder();
/*     */           
/*  44 */           if (StringUtil.isEmpty(itemCode)) {
/*  45 */             res.setS2CCode(500);
/*  46 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*  47 */             this.body.writeBytes(res.build().toByteArray());
/*     */             return;
/*     */           } 
/*  50 */           NormalEquip equip = wnEquip.getEquipment(equipPos);
/*  51 */           if (equip == null) {
/*  52 */             res.setS2CCode(500);
/*  53 */             res.setS2CMsg(LangService.getValue("BAG_STACKINDEX_ILLEGALITY"));
/*  54 */             this.body.writeBytes(res.build().toByteArray());
/*     */             return;
/*     */           } 
/*  57 */           Map<String, Integer> resData = null;
/*  58 */           int result = ((Integer)resData.get("result")).intValue();
/*  59 */           if (result == 0) {
/*  60 */             if (((Integer)resData.get("successNum")).intValue() > 0) {
/*  61 */               res.setS2CCode(200);
/*  62 */               this.body.writeBytes(res.build().toByteArray());
/*     */               return;
/*     */             } 
/*  65 */             PlayerUtil.sendSysMessageToPlayer(LangService.getValue("REFINE_FAILED_TIPS"), player.getId(), Const.TipsType.NORMAL);
/*  66 */             res.setS2CCode(500);
/*  67 */             res.setS2CMsg("");
/*  68 */             this.body.writeBytes(res.build().toByteArray());
/*     */             return;
/*     */           } 
/*  71 */           if (result == -1) {
/*  72 */             res.setS2CCode(500);
/*  73 */             res.setS2CMsg(LangService.getValue("EQUIP_CAN_NOT_REFINE"));
/*  74 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  76 */           if (result == -2) {
/*  77 */             res.setS2CCode(500);
/*  78 */             res.setS2CMsg(LangService.getValue("REFINE_MATE_ERROR"));
/*  79 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  81 */           if (result == 1) {
/*  82 */             res.setS2CCode(500);
/*  83 */             res.setS2CMsg(LangService.getValue("EQUIPMENT_REFINE_HIGHEST"));
/*  84 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  86 */           if (result == 2) {
/*  87 */             res.setS2CCode(500);
/*  88 */             res.setS2CMsg(LangService.getValue("REFINE_MATE_NOT_ENOUGH"));
/*  89 */             this.body.writeBytes(res.build().toByteArray()); return;
/*     */           } 
/*  91 */           if (result == 3) {
/*  92 */             res.setS2CCode(500);
/*  93 */             res.setS2CMsg(LangService.getValue("CONFIG_ERR"));
/*  94 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  98 */           res.setS2CCode(500);
/*  99 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 100 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\equip\RefineOneKeyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */