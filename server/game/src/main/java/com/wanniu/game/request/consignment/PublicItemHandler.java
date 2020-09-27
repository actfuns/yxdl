/*     */ package com.wanniu.game.request.consignment;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.consignmentShop.ConsignmentLineService;
/*     */ import com.wanniu.game.data.ChatSettingCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.ConsignmentItemsPO;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import pomelo.area.ConsignmentLineHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("area.consignmentLineHandler.publicItemRequest")
/*     */ public class PublicItemHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  32 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  33 */     ConsignmentLineHandler.PublicItemRequest msg = ConsignmentLineHandler.PublicItemRequest.parseFrom(this.pak.getRemaingBytes());
/*  34 */     final String id = msg.getId();
/*     */     
/*  36 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  39 */           ConsignmentLineHandler.PublicItemResponse.Builder res = ConsignmentLineHandler.PublicItemResponse.newBuilder();
/*     */           
/*  41 */           ConsignmentItemsPO item = ConsignmentLineService.getInstance().getById(id);
/*  42 */           if (item == null) {
/*  43 */             Out.error(new Object[] { "publicItemRequest ", this.val$id, " not found." });
/*  44 */             res.setS2CCode(500);
/*  45 */             res.setS2CMsg(LangService.getValue("ITEM_NULL"));
/*  46 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  51 */           int scope = Const.CHAT_SCOPE.WORLD.getValue();
/*  52 */           ChatSettingCO setting = (ChatSettingCO)GameData.ChatSettings.get(Integer.valueOf(scope));
/*  53 */           if (player.chatTime == null) {
/*  54 */             player.chatTime = new HashMap<>();
/*     */           }
/*  56 */           Long lasttime = (Long)player.chatTime.get(Integer.valueOf(scope));
/*  57 */           long currTime = System.currentTimeMillis();
/*  58 */           long second = 0L;
/*  59 */           if (lasttime != null) {
/*  60 */             second = setting.coolDown - (currTime - lasttime.longValue()) / 1000L;
/*     */           }
/*     */ 
/*     */           
/*  64 */           if (item.publishTimes == 0) {
/*  65 */             if (second > 0L) {
/*  66 */               res.setS2CCode(500);
/*  67 */               res.setS2CMsg(LangService.format("CHAT_WORLD_COOL", new Object[] { Long.valueOf(second) }));
/*  68 */               this.body.writeBytes(res.build().toByteArray());
/*     */               return;
/*     */             } 
/*  71 */           } else if (item.publishTimes > 0 && item.publishTimes <= GlobalConfig.Consignment_Advertisement_goldNum) {
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
/*     */ 
/*     */ 
/*     */             
/*  87 */             if (player.player.gold < GlobalConfig.Consignment_Advertisement_gold) {
/*  88 */               res.setS2CCode(500);
/*  89 */               res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
/*  90 */               this.body.writeBytes(res.build().toByteArray());
/*     */               
/*     */               return;
/*     */             } 
/*  94 */             if (second > 0L) {
/*  95 */               res.setS2CCode(500);
/*  96 */               res.setS2CMsg(LangService.format("CHAT_WORLD_COOL", new Object[] { Long.valueOf(second) }));
/*  97 */               this.body.writeBytes(res.build().toByteArray());
/*     */               
/*     */               return;
/*     */             } 
/* 101 */             player.moneyManager.costGold(GlobalConfig.Consignment_Advertisement_gold, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_PUBLIC);
/* 102 */           } else if (item.publishTimes > GlobalConfig.Consignment_Advertisement_goldNum) {
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
/*     */ 
/*     */ 
/*     */             
/* 118 */             if (player.player.ticket < GlobalConfig.Consignment_Advertisement_diamond && player.player.diamond < GlobalConfig.Consignment_Advertisement_diamond) {
/* 119 */               res.setS2CCode(500);
/* 120 */               res.setS2CMsg(LangService.getValue("DIAMAND_NOT_ENOUGH"));
/* 121 */               this.body.writeBytes(res.build().toByteArray());
/*     */               
/*     */               return;
/*     */             } 
/* 125 */             if (second > 0L) {
/* 126 */               res.setS2CCode(500);
/* 127 */               res.setS2CMsg(LangService.format("CHAT_WORLD_COOL", new Object[] { Long.valueOf(second) }));
/* 128 */               this.body.writeBytes(res.build().toByteArray());
/*     */               
/*     */               return;
/*     */             } 
/* 132 */             if (player.player.ticket >= GlobalConfig.Consignment_Advertisement_diamond) {
/* 133 */               player.moneyManager.costTicket(GlobalConfig.Consignment_Advertisement_diamond, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_PUBLIC);
/*     */             } else {
/* 135 */               player.moneyManager.costDiamond(GlobalConfig.Consignment_Advertisement_diamond, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_PUBLIC);
/*     */             } 
/*     */           } 
/*     */           
/* 139 */           item.publishTimes++;
/*     */           
/* 141 */           GCache.put(ConstsTR.chat_item_tr.value + "/" + id, JSON.toJSONString(item.db), 600);
/*     */           
/* 143 */           res.setS2CCode(200);
/* 144 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\consignment\PublicItemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */