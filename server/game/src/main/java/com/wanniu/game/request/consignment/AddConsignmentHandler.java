/*     */ package com.wanniu.game.request.consignment;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.consignmentShop.ConsignmentLineService;
/*     */ import com.wanniu.game.consignmentShop.ConsignmentUtil;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.item.ItemConfig;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.ConsignmentItemsPO;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import pomelo.area.ConsignmentLineHandler;
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
/*     */ @GClientEvent("area.consignmentLineHandler.addConsignmentRequest")
/*     */ public class AddConsignmentHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  37 */     ConsignmentLineHandler.AddConsignmentRequest msg = ConsignmentLineHandler.AddConsignmentRequest.parseFrom(this.pak.getRemaingBytes());
/*     */     
/*  39 */     int index = msg.getC2SIndex();
/*  40 */     int num = msg.getC2SNumber();
/*  41 */     int salePrice = msg.getC2SPrice();
/*  42 */     String itemId = msg.getC2SId();
/*  43 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*     */     
/*  45 */     int needLevel = ConsignmentUtil.getConsignmentLevel();
/*  46 */     if (needLevel > player.getLevel()) {
/*  47 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("CONSIGNMENT_OPEN_LEVEL").replace("{needLevel}", String.valueOf(needLevel)));
/*     */     }
/*     */     
/*  50 */     if (num < 1) {
/*  51 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("CONSIGNMENT_ITEM_NUM_LESS_ONE"));
/*     */     }
/*     */     
/*  54 */     NormalItem item = player.getWnBag().getItem(index);
/*  55 */     if (item == null) {
/*  56 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("ITEM_NULL"));
/*     */     }
/*     */ 
/*     */     
/*  60 */     if (!item.isEquip() && item.prop.salePrice > 0) {
/*     */       
/*  62 */       if (salePrice < item.prop.salePrice * GlobalConfig.Consignment_Advertisement_minPercent * num / 100) {
/*  63 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("CONSIGNMENT_PRICE_LESS"));
/*     */       }
/*     */       
/*  66 */       if (salePrice > item.prop.salePrice * GlobalConfig.Consignment_Advertisement_maxPercent * num / 100) {
/*  67 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("CONSIGNMENT_PRICE_MORE"));
/*     */       
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/*  73 */       if (salePrice < 2 * num) {
/*  74 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("CONSIGNMENT_PRICE_LESS"));
/*     */       }
/*     */       
/*  77 */       if (salePrice > 10000000) {
/*  78 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("CONSIGNMENT_PRICE_MORE"));
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  83 */     if (StringUtils.isNotEmpty(itemId)) {
/*  84 */       return handleReshelf(player, itemId, salePrice);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     if (item.isBinding()) {
/*  91 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("CONSIGNMENT_BIND_CANNOT"));
/*     */     }
/*     */ 
/*     */     
/*  95 */     if (!item.canAuction()) {
/*  96 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("CONSIGNMENT_ITEM_CANNOT_SALE"));
/*     */     }
/*     */ 
/*     */     
/* 100 */     if (item.itemDb.groupCount < num) {
/* 101 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("ITEM_NOT_ENOUGH"));
/*     */     }
/*     */ 
/*     */     
/* 105 */     List<ConsignmentItemsPO> myList = ConsignmentLineService.getInstance().findByPlayerId(player.getId());
/* 106 */     if (myList.size() >= ConsignmentUtil.sellNum(player)) {
/* 107 */       player.onFunctionGoTo(Const.FUNCTION_GOTO_TYPE.CONSIGNMENT, null, null, null);
/* 108 */       return (PomeloResponse)new ErrorResponse();
/*     */     } 
/*     */ 
/*     */     
/* 112 */     int depositCoin = ConsignmentUtil.depositPrice(item.prop.price * num);
/* 113 */     if (!player.moneyManager.enoughGold(depositCoin)) {
/* 114 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("CONSIGNMENT_GOLD_NOT_ENOUGH"));
/*     */     }
/*     */     
/* 117 */     int lateMinutes = ConsignmentUtil.getLateMinutes(salePrice);
/* 118 */     ConsignmentItemsPO data = item.toJSON4ConsignmentLine(salePrice, player.getName(), player.getPro(), player.getId(), ConsignmentUtil.sellTime(), num, lateMinutes);
/* 119 */     boolean ret = ConsignmentLineService.getInstance().insert(data);
/* 120 */     if (!ret) {
/* 121 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("CommonUtil_ITEM_IS_IN_SALE"));
/*     */     }
/* 123 */     Out.info(new Object[] { "上架拍卖道具 playerId=", player.getId(), ",itemId=", data.id, ",code=", data.db.code, ",count=", Integer.valueOf(num), ",price=", Integer.valueOf(salePrice) });
/* 124 */     player.getWnBag().discardItemByPos(index, num, false, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_ADD);
/*     */     
/* 126 */     player.moneyManager.costGold(depositCoin, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_ADD);
/*     */     
/* 128 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/* 131 */           ConsignmentLineHandler.AddConsignmentResponse.Builder res = ConsignmentLineHandler.AddConsignmentResponse.newBuilder();
/* 132 */           res.setS2CCode(200);
/* 133 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   private PomeloResponse handleReshelf(WNPlayer player, String itemId, int salePrice) {
/* 140 */     ConsignmentItemsPO item = ConsignmentLineService.getInstance().getById(itemId);
/* 141 */     if (item == null) {
/* 142 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("ITEM_NULL"));
/*     */     }
/*     */ 
/*     */     
/* 146 */     DItemEquipBase prop = ItemConfig.getInstance().getItemProp(item.db.code);
/* 147 */     if (prop == null) {
/* 148 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("ITEM_NULL"));
/*     */     }
/*     */ 
/*     */     
/* 152 */     int depositCoin = ConsignmentUtil.depositPrice(prop.price * item.db.groupCount);
/* 153 */     if (!player.moneyManager.costGold(depositCoin, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_ADD)) {
/* 154 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("CONSIGNMENT_GOLD_NOT_ENOUGH"));
/*     */     }
/* 156 */     Out.info(new Object[] { "重新上架拍卖道具 playerId=", player.getId(), ",itemId=", item.id, ",code=", item.db.code, ",count=", Integer.valueOf(item.groupCount), ",price=", Integer.valueOf(salePrice) });
/*     */     
/* 158 */     int lateMinutes = ConsignmentUtil.getLateMinutes(salePrice);
/* 159 */     item.consignmentPrice = salePrice;
/* 160 */     item.consignmentTime = System.currentTimeMillis() + ConsignmentUtil.sellTime() + (lateMinutes * Const.Time.Minute.getValue());
/* 161 */     item.lateMinutes = lateMinutes;
/*     */     
/* 163 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/* 166 */           ConsignmentLineHandler.AddConsignmentResponse.Builder res = ConsignmentLineHandler.AddConsignmentResponse.newBuilder();
/* 167 */           res.setS2CCode(200);
/* 168 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\consignment\AddConsignmentHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */