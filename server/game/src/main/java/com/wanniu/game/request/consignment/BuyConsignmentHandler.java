/*     */ package com.wanniu.game.request.consignment;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.consignmentShop.ConsignmentLineService;
/*     */ import com.wanniu.game.consignmentShop.ConsignmentUtil;
/*     */ import com.wanniu.game.data.base.DItemEquipBase;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.WNMail;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.bi.LogReportService;
/*     */ import com.wanniu.game.poes.ConsignmentItemsPO;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import pomelo.Common;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("area.consignmentLineHandler.buyConsignmentRequest")
/*     */ public class BuyConsignmentHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  50 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*  51 */     ConsignmentLineHandler.BuyConsignmentRequest msg = ConsignmentLineHandler.BuyConsignmentRequest.parseFrom(this.pak.getRemaingBytes());
/*  52 */     String id = msg.getC2SId();
/*  53 */     int globalZone = msg.getC2SGlobal();
/*     */ 
/*     */     
/*  56 */     int needLevel = ConsignmentUtil.getConsignmentLevel();
/*  57 */     if (needLevel > player.getLevel()) {
/*  58 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("CONSIGNMENT_OPEN_LEVEL").replace("{needLevel}", String.valueOf(needLevel)));
/*     */     }
/*     */     
/*  61 */     ConsignmentItemsPO item = ConsignmentLineService.getInstance().getById(id);
/*  62 */     if (item == null) {
/*  63 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("CONSIGNMENT_ITEM_CANNOT_BUY"));
/*     */     }
/*     */ 
/*     */     
/*  67 */     if (item.consignmentPlayerId.equals(player.getId())) {
/*  68 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("CONSIGNMENT_CANNOT_BUY_SELF_ITEM"));
/*     */     }
/*     */ 
/*     */     
/*  72 */     if (!player.moneyManager.enoughDiamond(item.consignmentPrice)) {
/*  73 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("DIAMAND_NOT_ENOUGH"));
/*     */     }
/*     */ 
/*     */     
/*  77 */     List<Common.KeyValueStruct> changeItems = new ArrayList<>();
/*  78 */     Common.KeyValueStruct.Builder items = Common.KeyValueStruct.newBuilder();
/*  79 */     items.setKey(item.db.code);
/*  80 */     items.setValue(String.valueOf(item.db.groupCount));
/*  81 */     changeItems.add(items.build());
/*  82 */     player.moneyManager.costDiamond(item.consignmentPrice, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_BUY, changeItems);
/*     */     
/*  84 */     DItemEquipBase itemBase = ItemUtil.getPropByCode(item.db.code);
/*  85 */     String itemName = MessageUtil.itemColorName(itemBase.qcolor, itemBase.name);
/*     */ 
/*     */     
/*  88 */     if (!id.equals(ConsignmentUtil.sysItemId)) {
/*  89 */       Out.info(new Object[] { "拍卖道具出售成功 playerId=", item.consignmentPlayerId, ",name=", item.consignmentPlayerName, ",itemId=", item.id, ",code=", item.db.code, ",count=", Integer.valueOf(item.db.groupCount), ",price=", Integer.valueOf(item.consignmentPrice) });
/*     */       
/*  91 */       int salePrice = item.consignmentPrice - ConsignmentUtil.commissionPrice(globalZone, item.consignmentPrice);
/*  92 */       if (salePrice < 0) {
/*  93 */         salePrice = 0;
/*     */       }
/*  95 */       MailSysData mailSaleData = new MailSysData("Consignment_sale");
/*  96 */       mailSaleData.attachments = new ArrayList();
/*  97 */       MailData.Attachment att = new MailData.Attachment();
/*  98 */       att.itemCode = "diamond";
/*  99 */       att.itemNum = salePrice;
/* 100 */       mailSaleData.attachments.add(att);
/* 101 */       mailSaleData.replace = new HashMap<>();
/* 102 */       mailSaleData.replace.put("storeItem", itemName);
/* 103 */       mailSaleData.replace.put("price", String.valueOf(item.consignmentPrice));
/* 104 */       mailSaleData.replace.put("realprice", String.valueOf(salePrice));
/* 105 */       MailUtil.getInstance().sendMailToOnePlayer(item.consignmentPlayerId, (MailData)mailSaleData, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_SELL);
/*     */       
/* 107 */       ConsignmentLineService.getInstance().remove(item.id);
/*     */     } else {
/* 109 */       player.consignmentManager.signBuyFirstConsignItem();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 114 */     Out.info(new Object[] { "拍卖道具购买成功 playerId=", player.getId(), ",name=", player.getName(), ",itemId=", item.id, ",code=", item.db.code, ",count=", Integer.valueOf(item.db.groupCount), ",price=", Integer.valueOf(item.consignmentPrice) });
/* 115 */     MailSysData mailData = new MailSysData("Consignment_buy");
/* 116 */     mailData.replace = new HashMap<>();
/* 117 */     mailData.replace.put("storeItem", itemName);
/* 118 */     mailData.entityItems = new ArrayList();
/* 119 */     mailData.entityItems.add(item.db);
/*     */     
/* 121 */     WNMail mail = MailUtil.getInstance().createMail((MailData)mailData, player.getId(), Const.GOODS_CHANGE_TYPE.CONSIGNMENT_BUY);
/* 122 */     MailUtil.getInstance().sendMail(player, mail);
/*     */     
/* 124 */     PlayerUtil.sendSysMessageToPlayer("购买成功，请到邮箱中查收！", player.getId(), null);
/*     */ 
/*     */     
/* 127 */     LogReportService.getInstance().ansycReportConsignment(player, item.consignmentPlayerId, item.consignmentPlayerName, item.db.code, item.db.groupCount);
/*     */     
/* 129 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException
/*     */         {
/* 133 */           ConsignmentLineHandler.BuyConsignmentResponse.Builder res = ConsignmentLineHandler.BuyConsignmentResponse.newBuilder();
/* 134 */           res.setS2CCode(200);
/* 135 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\consignment\BuyConsignmentHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */