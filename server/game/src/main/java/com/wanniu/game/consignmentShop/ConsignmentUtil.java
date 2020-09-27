/*     */ package com.wanniu.game.consignmentShop;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.RandomUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.CardCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.SaleReviewTimeCO;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.mail.MailCenter;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.message.MessageData;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.ConsignmentItemsPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import pomelo.item.ItemOuterClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConsignmentUtil
/*     */ {
/*     */   public static int depositPrice(int price) {
/*  35 */     int ratio = GlobalConfig.Consignment_Fee;
/*  36 */     int min = GlobalConfig.Consignment_MinFee;
/*  37 */     return Math.max(min, (int)Math.floor((price * ratio / 100)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int commissionPrice(int globalZone, int price) {
/*  44 */     int ratio = GlobalConfig.Consignment_Commission;
/*  45 */     if (globalZone == 1) {
/*  46 */       ratio = GlobalConfig.Consignment_Commission_serverEnter;
/*     */     }
/*  48 */     int min = GlobalConfig.Consignment_MinCommission;
/*  49 */     return Math.max(min, (int)Math.floor((price * ratio / 100)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int consignmentMinPrice(int price) {
/*  56 */     int min = GlobalConfig.Consignment_MinPrice;
/*  57 */     return Math.max(price, min);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int consignmentMaxPrice(int price) {
/*  64 */     int max = GlobalConfig.Consignment_MaxPrice;
/*  65 */     return Math.min(price, max);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int sellNum(WNPlayer player) {
/*  72 */     int orgin = GlobalConfig.Consignment_SellNum;
/*  73 */     int vip = player.baseDataManager.getVip();
/*  74 */     int add = 0;
/*  75 */     if (vip > 0) {
/*  76 */       add = ((CardCO)GameData.Cards.get(Integer.valueOf(vip))).prv4;
/*     */     }
/*  78 */     return orgin + add;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int sellTime() {
/*  87 */     return GlobalConfig.Consignment_SellTime * Const.Time.Hour.getValue();
/*     */   }
/*     */   
/*     */   public static int getConsignmentLevel() {
/*  91 */     return GlobalConfig.Consignment_Level;
/*     */   }
/*     */   
/*  94 */   public static String sysItemId = "0000000";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getLateMinutes(int price) {
/* 102 */     int minutes = 0;
/* 103 */     for (SaleReviewTimeCO cfg : GameData.SaleReviewTimes.values()) {
/* 104 */       if (price >= cfg.minDiamond && price <= cfg.maxDiamond) {
/* 105 */         minutes = RandomUtil.getInt(cfg.minTime, cfg.maxTime);
/*     */         break;
/*     */       } 
/*     */     } 
/* 109 */     return minutes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void timeOutMail(ConsignmentItemsPO v) {
/* 116 */     NormalItem actualItem = ItemUtil.createItemByDbOpts(v.db);
/* 117 */     String itemName = MessageUtil.itemColorName(actualItem.prop.qcolor, actualItem.prop.name);
/* 118 */     MailSysData mailData = new MailSysData("Consignment_sendback");
/* 119 */     mailData.replace = new HashMap<>();
/* 120 */     mailData.replace.put("storeItem", itemName);
/* 121 */     mailData.entityItems = new ArrayList();
/* 122 */     mailData.entityItems.add(actualItem.itemDb);
/* 123 */     MailCenter.getInstance().sendOfflineMailToPlayers(new String[] { v.consignmentPlayerId }, (MailData)mailData, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_TIMEOUT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ItemOuterClass.ConsignmentItem buildConsignmentItem(WNPlayer player, ConsignmentItemsPO item) {
/* 130 */     NormalItem normalItem = ItemUtil.createItemByDbOpts(item.db);
/* 131 */     ItemOuterClass.ConsignmentItem.Builder builder = ItemOuterClass.ConsignmentItem.newBuilder();
/* 132 */     builder.setDetail(normalItem.getItemDetail(player.playerBasePO));
/* 133 */     builder.setGroupCount(item.groupCount);
/* 134 */     builder.setPublishTimes(item.publishTimes);
/* 135 */     builder.setConsignmentPlayerId(item.consignmentPlayerId);
/*     */     
/* 137 */     builder.setConsignmentPlayerName(GlobalConfig.Consignment_Anonymous_Show);
/* 138 */     builder.setConsignmentPrice(item.consignmentPrice);
/* 139 */     builder.setConsignmentPlayerPro(item.consignmentPlayerPro);
/*     */     
/* 141 */     long lateTime = (item.lateMinutes * Const.Time.Minute.getValue());
/* 142 */     builder.setLateTime(lateTime);
/* 143 */     builder.setConsignmentTime(String.valueOf(item.consignmentTime));
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
/* 156 */     return builder.build();
/*     */   }
/*     */   
/*     */   public static boolean onMessage(WNPlayer player, Const.MESSAGE_TYPE msgType, int operate, MessageData message) {
/* 160 */     if (operate == Const.MESSAGE_OPERATE.TYPE_ACCEPT.getValue()) {
/* 161 */       Out.error(new Object[] { Utils.serialize(message) });
/*     */     }
/* 163 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\consignmentShop\ConsignmentUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */