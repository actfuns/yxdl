/*     */ package com.wanniu.game.guild.guildShop;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.GShopCO;
/*     */ import com.wanniu.game.data.ext.GShopExt;
/*     */ import com.wanniu.game.guild.GuildResult;
/*     */ import com.wanniu.game.guild.GuildService;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import pomelo.area.GuildShopHandler;
/*     */ import pomelo.item.ItemOuterClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuildShopManager
/*     */ {
/*     */   public WNPlayer player;
/*     */   public ArrayList<Integer> boughtList;
/*     */   public ArrayList<Integer> goods;
/*     */   
/*     */   public GuildShopManager(WNPlayer player) {
/*  29 */     this.player = player;
/*  30 */     this.boughtList = new ArrayList<>();
/*  31 */     this.goods = new ArrayList<>();
/*     */   }
/*     */   
/*     */   public JSONObject toJson4Serialize() {
/*  35 */     JSONObject data = new JSONObject();
/*  36 */     data.put("boughtList ", this.boughtList);
/*  37 */     return data;
/*     */   }
/*     */   
/*     */   public void refreshNewDay(boolean isNewDay) {
/*  41 */     if (isNewDay && null != this.boughtList) {
/*  42 */       this.boughtList.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   public void refreshGuildTodayGoods() {
/*  47 */     GuildResult ret = GuildService.getGuildTodayGoodsList(this.player);
/*  48 */     if (null != ret && null != this.goods) {
/*  49 */       this.goods = ret.goods;
/*     */     }
/*     */   }
/*     */   
/*     */   public void resetPublicData() {
/*  54 */     if (null != this.goods) {
/*  55 */       this.goods.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   public GuildShopHandler.ShopInfo toJson4PayLoad() {
/*  60 */     GuildShopHandler.ShopInfo.Builder shopInfo = GuildShopHandler.ShopInfo.newBuilder();
/*  61 */     if (null == this.goods || this.goods.size() == 0) {
/*  62 */       return shopInfo.build();
/*     */     }
/*     */     
/*  65 */     List<GShopExt> itemPropList = GuildUtil.getShopPropList();
/*  66 */     List<GuildShopHandler.ExchangeItem> todayList = new ArrayList<>();
/*  67 */     List<GuildShopHandler.ExchangeItem> nextList = new ArrayList<>();
/*  68 */     for (int i = 0; i < itemPropList.size(); i++) {
/*  69 */       GShopExt prop = itemPropList.get(i);
/*  70 */       int goodId = prop.itemID;
/*  71 */       ItemOuterClass.MiniItem.Builder miniData = ItemUtil.getMiniItemData(prop.itemCode, prop.itemCount, Const.ForceType.getE(prop.isBind));
/*  72 */       if (null != miniData) {
/*     */ 
/*     */ 
/*     */         
/*  76 */         GuildShopHandler.ExchangeItem.Builder good = GuildShopHandler.ExchangeItem.newBuilder();
/*  77 */         good.setId(goodId);
/*  78 */         good.setItemShowName(prop.itemShowName);
/*  79 */         good.setItem(miniData.build());
/*  80 */         good.setIsBind(miniData.getBindType());
/*  81 */         good.setItemDes(prop.itemDes);
/*     */         
/*  83 */         good.addAllNeedMoney(prop.moneyReqList);
/*     */         
/*  85 */         good.addAllCondition(getConditions((GShopCO)prop));
/*  86 */         good.setMeetCondition((getConditionStatus((GShopCO)prop) == 0) ? 1 : 0);
/*     */         
/*  88 */         good.setState(Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue());
/*  89 */         if (this.goods.indexOf(Integer.valueOf(goodId)) != -1) {
/*  90 */           good.setState(Const.EVENT_GIFT_STATE.CAN_RECEIVE.getValue());
/*  91 */           if (this.boughtList.indexOf(Integer.valueOf(goodId)) != -1) {
/*  92 */             good.setState(Const.EVENT_GIFT_STATE.RECEIVED.getValue());
/*     */           }
/*  94 */           todayList.add(good.build());
/*     */         } else {
/*  96 */           nextList.add(good.build());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 101 */     nextList.sort((a, b) -> (a.getItem().getQColor() != b.getItem().getQColor()) ? (b.getItem().getQColor() - a.getItem().getQColor()) : ((a.getId() != b.getId()) ? (a.getId() - b.getId()) : 0));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     nextList.subList(11, nextList.size() - 1);
/*     */ 
/*     */     
/* 114 */     long miniSeconds = Const.Time.Day.getValue() + Utils.getZeroDate().getTime() - System.currentTimeMillis();
/* 115 */     shopInfo.addAllTodayItems(todayList);
/* 116 */     shopInfo.addAllNextItems(nextList);
/* 117 */     shopInfo.setRefreshTime(0, (int)Math.ceil((miniSeconds / 1000L)));
/* 118 */     return shopInfo.build();
/*     */   }
/*     */   
/*     */   public GuildShopHandler.ShopCondition newCondition(int type, int num) {
/* 122 */     GuildShopHandler.ShopCondition.Builder data = GuildShopHandler.ShopCondition.newBuilder();
/* 123 */     data.setType(type);
/* 124 */     data.setNumber(num);
/* 125 */     return data.build();
/*     */   }
/*     */   
/*     */   public List<GuildShopHandler.ShopCondition> getConditions(GShopCO prop) {
/* 129 */     List<GuildShopHandler.ShopCondition> data = new ArrayList<>();
/* 130 */     if (prop.levelReq > 0) {
/* 131 */       data.add(newCondition(1, prop.levelReq));
/*     */     }
/*     */     
/* 134 */     if (prop.upReq > 0) {
/* 135 */       data.add(newCondition(2, prop.upReq));
/*     */     }
/*     */     
/* 138 */     if (prop.vipReq > 0) {
/* 139 */       data.add(newCondition(3, prop.vipReq));
/*     */     }
/*     */     
/* 142 */     if (prop.raceReq > 0) {
/* 143 */       data.add(newCondition(4, prop.raceReq));
/*     */     }
/* 145 */     if (prop.raceClass > 0) {
/* 146 */       data.add(newCondition(5, prop.raceClass));
/*     */     }
/*     */     
/* 149 */     return data;
/*     */   }
/*     */   
/*     */   public int getConditionStatus(GShopCO prop) {
/* 153 */     List<GuildShopHandler.ShopCondition> conditions = getConditions(prop);
/* 154 */     for (int i = 0; i < conditions.size(); i++) {
/* 155 */       GuildShopHandler.ShopCondition condition = conditions.get(i);
/* 156 */       int type = condition.getType();
/* 157 */       int number = condition.getNumber();
/* 158 */       if (type == 1 && (this.player.getPlayer()).level < number) {
/* 159 */         return 1;
/*     */       }
/* 161 */       if (type == 2 && (this.player.getPlayer()).upLevel < number) {
/* 162 */         return 2;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 167 */       if (type == 4);
/*     */ 
/*     */       
/* 170 */       if (type == 5);
/*     */ 
/*     */       
/* 173 */       if (type == 6);
/*     */ 
/*     */       
/* 176 */       if (type == 7);
/*     */     } 
/*     */ 
/*     */     
/* 180 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildShop\GuildShopManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */