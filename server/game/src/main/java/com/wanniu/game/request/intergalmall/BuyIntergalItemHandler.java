/*     */ package com.wanniu.game.request.intergalmall;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.CardCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.base.IntergalShopBase;
/*     */ import com.wanniu.game.intergalmall.IntergalMallConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.player.bi.LogReportService;
/*     */ import com.wanniu.game.poes.IntergalMallPO;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import pomelo.area.IntergalMallHandler;
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
/*     */ @GClientEvent("area.intergalMallHandler.buyIntergalItemRequest")
/*     */ public class BuyIntergalItemHandler
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  38 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*     */     
/*  40 */     IntergalMallHandler.BuyIntergalItemRequest req = IntergalMallHandler.BuyIntergalItemRequest.parseFrom(this.pak.getRemaingBytes());
/*     */     
/*  42 */     final int shopType = req.getC2SType();
/*  43 */     final int itemId = req.getC2SItemId();
/*  44 */     final int buyNum = req.getC2SNum();
/*     */     
/*  46 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/*  49 */           IntergalMallHandler.BuyIntergalItemResponse.Builder res = IntergalMallHandler.BuyIntergalItemResponse.newBuilder();
/*     */ 
/*     */           
/*  52 */           if (buyNum <= 0 || buyNum > 9999) {
/*  53 */             res.setS2CCode(500);
/*  54 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*  55 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  59 */           IntergalShopBase prop = IntergalMallConfig.getInstance().getIntergalMallProp(shopType, itemId);
/*     */           
/*  61 */           if (prop == null) {
/*  62 */             res.setS2CCode(500);
/*  63 */             res.setS2CMsg(LangService.getValue("ITEM_NULL"));
/*  64 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  68 */           if (prop.isShow == 0) {
/*  69 */             res.setS2CCode(500);
/*  70 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*  71 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  76 */           if (prop.periodStartDate != null && prop.periodStartDate.getTime() > System.currentTimeMillis()) {
/*  77 */             res.setS2CCode(500);
/*  78 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*  79 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  83 */           if (prop.periodEndDate != null && prop.periodEndDate.getTime() < System.currentTimeMillis()) {
/*  84 */             res.setS2CCode(500);
/*  85 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*  86 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*  90 */           IntergalMallPO intergalMallPO = (player.getIntergalMallManager()).intergalMallPO;
/*     */           
/*  92 */           Map<Integer, Integer> shopHasBuyMap = (Map<Integer, Integer>)intergalMallPO.hasBuyItem.get(Integer.valueOf(shopType));
/*  93 */           if (shopHasBuyMap == null) {
/*  94 */             shopHasBuyMap = new HashMap<>();
/*  95 */             intergalMallPO.hasBuyItem.put(Integer.valueOf(shopType), shopHasBuyMap);
/*     */           } 
/*  97 */           int hasBuyNum = shopHasBuyMap.containsKey(Integer.valueOf(itemId)) ? ((Integer)shopHasBuyMap.get(Integer.valueOf(itemId))).intValue() : 0;
/*     */ 
/*     */           
/* 100 */           int vip = player.baseDataManager.getVip();
/* 101 */           int add = 0;
/* 102 */           if (vip > 0) {
/* 103 */             add = ((CardCO)GameData.Cards.get(Integer.valueOf(vip))).prv7;
/*     */           }
/*     */ 
/*     */           
/* 107 */           if (prop.buyTimes != -1 && hasBuyNum + buyNum > prop.buyTimes + add) {
/* 108 */             res.setS2CCode(500);
/* 109 */             res.setS2CMsg(LangService.getValue("SHOPMALL_REMAINNUM_NOT_ENOUGH"));
/* 110 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/* 115 */           int needNum = prop.price;
/* 116 */           if (prop.price2 > 0) {
/* 117 */             needNum = prop.price2;
/*     */           }
/*     */ 
/*     */           
/* 121 */           if (1L * needNum * buyNum > 2147483647L) {
/* 122 */             needNum = Integer.MAX_VALUE;
/*     */           } else {
/* 124 */             needNum *= buyNum;
/*     */           } 
/*     */           
/* 127 */           boolean pointEnough = false;
/* 128 */           String msg = null;
/* 129 */           if (shopType == 2) {
/* 130 */             pointEnough = player.moneyManager.enoughConsumePoint(needNum);
/* 131 */             msg = LangService.getValue("PLAER_CONSUMEPOINT_NOT_ENOUGH");
/* 132 */           } else if (shopType == 3) {
/* 133 */             pointEnough = player.moneyManager.enoughXianYuan(needNum);
/* 134 */             msg = LangService.getValue("PLAER_XIANYUAN_NOT_ENOUGH");
/* 135 */           } else if (shopType == 4) {
/* 136 */             pointEnough = player.soloManager.enoughSolopoint(needNum);
/* 137 */             msg = LangService.getValue("SOLOPOINT_NOT_ENOUGH");
/* 138 */           } else if (shopType == 5) {
/* 139 */             pointEnough = player.guildManager.enoughContribution(needNum);
/* 140 */             msg = LangService.getValue("GUILD_POINT_NOT_ENOUGH");
/* 141 */           } else if (shopType == 1) {
/* 142 */             pointEnough = player.moneyManager.enoughGold(needNum);
/* 143 */             msg = LangService.getValue("GOLD_NOT_ENOUGH");
/*     */           } 
/* 145 */           if (!pointEnough) {
/* 146 */             res.setS2CCode(500);
/* 147 */             res.setS2CMsg(msg);
/* 148 */             this.body.writeBytes(res.build().toByteArray());
/*     */             
/*     */             return;
/*     */           } 
/* 152 */           Out.info(new Object[] { "积分商城购买道具 playerId=", this.val$player.getId(), ",itemId=", prop.itemCode, ",count=", Integer.valueOf(prop.num * this.val$buyNum) });
/*     */ 
/*     */           
/* 155 */           int currencyNum = 0;
/* 156 */           if (shopType == 2) {
/* 157 */             player.moneyManager.costConsumePoint(needNum, Const.GOODS_CHANGE_TYPE.intergalmall);
/* 158 */             currencyNum = player.moneyManager.getConsumePoint();
/* 159 */           } else if (shopType == 3) {
/* 160 */             player.moneyManager.costXianYuan(needNum, Const.GOODS_CHANGE_TYPE.intergalmall);
/* 161 */             currencyNum = player.moneyManager.getXianYuan();
/* 162 */           } else if (shopType == 4) {
/* 163 */             player.soloManager.costSolopoint(needNum, Const.GOODS_CHANGE_TYPE.intergalmall);
/* 164 */             currencyNum = player.soloManager.getSolopoint();
/* 165 */           } else if (shopType == 5) {
/* 166 */             player.guildManager.costContribution(needNum, Const.GOODS_CHANGE_TYPE.intergalmall);
/* 167 */             currencyNum = player.guildManager.getContribution();
/* 168 */           } else if (shopType == 1) {
/* 169 */             player.moneyManager.costGold(needNum, Const.GOODS_CHANGE_TYPE.intergalmall);
/* 170 */             currencyNum = player.baseDataManager.baseData.gold;
/*     */           } 
/*     */ 
/*     */           
/* 174 */           player.bag.addCodeItemMail(prop.itemCode, prop.num * buyNum, Const.ForceType.getE(prop.isBind), Const.GOODS_CHANGE_TYPE.intergalmall, "Bag_full_common");
/*     */ 
/*     */           
/* 177 */           hasBuyNum += buyNum;
/* 178 */           shopHasBuyMap.put(Integer.valueOf(itemId), Integer.valueOf(hasBuyNum));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 184 */           if (prop.buyTimes != -1) {
/* 185 */             res.setLastcount(prop.buyTimes - hasBuyNum + add);
/*     */           } else {
/* 187 */             res.setLastcount(-1);
/*     */           } 
/*     */ 
/*     */           
/* 191 */           LogReportService.getInstance().ansycReportShop(player, prop.itemCode, prop.num * buyNum, shopType + 10, needNum);
/*     */           
/* 193 */           res.setCurrencyNum(currencyNum);
/* 194 */           res.setTotalNum(player.bag.findItemNumByCode(prop.itemCode));
/* 195 */           res.setS2CCode(200);
/* 196 */           this.body.writeBytes(res.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\intergalmall\BuyIntergalItemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */