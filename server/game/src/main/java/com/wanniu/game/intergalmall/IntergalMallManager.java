/*     */ package com.wanniu.game.intergalmall;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.data.CardCO;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ShopLabCO;
/*     */ import com.wanniu.game.data.base.IntergalShopBase;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.IntergalMallPO;
/*     */ import com.wanniu.redis.GameDao;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
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
/*     */ public class IntergalMallManager
/*     */ {
/*     */   public WNPlayer player;
/*     */   public IntergalMallPO intergalMallPO;
/*     */   
/*     */   public IntergalMallManager(WNPlayer player) {
/*  34 */     this.player = player;
/*     */     
/*  36 */     this.intergalMallPO = (IntergalMallPO)GameDao.get(ConstsTR.intergalMallTR.value, player.getId(), IntergalMallPO.class);
/*  37 */     if (this.intergalMallPO == null) {
/*  38 */       this.intergalMallPO = new IntergalMallPO();
/*  39 */       this.intergalMallPO.hasBuyItem = new HashMap<>();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IntergalMallHandler.IntergalMallTab> getIntergalMallItemList(int shopType) {
/*  48 */     List<IntergalMallHandler.IntergalMallTab> list = new ArrayList<>();
/*     */     
/*  50 */     for (ShopLabCO tabCO : GameData.ShopLabs.values()) {
/*  51 */       if (shopType != -1 && shopType != tabCO.id) {
/*     */         continue;
/*     */       }
/*  54 */       IntergalMallHandler.IntergalMallTab.Builder mallTab = IntergalMallHandler.IntergalMallTab.newBuilder();
/*  55 */       mallTab.setTabId(tabCO.id);
/*  56 */       if (tabCO.id == 2) {
/*  57 */         mallTab.setCurrencyNum(this.player.moneyManager.getConsumePoint());
/*  58 */       } else if (tabCO.id == 3) {
/*  59 */         if (this.player.allBlobData.xianYuan != null) {
/*  60 */           mallTab.setCurrencyNum(this.player.moneyManager.getXianYuan());
/*     */         }
/*  62 */       } else if (tabCO.id == 4) {
/*  63 */         mallTab.setCurrencyNum(this.player.soloManager.getSolopoint());
/*  64 */       } else if (tabCO.id == 5) {
/*  65 */         mallTab.setCurrencyNum(this.player.guildManager.getContribution());
/*  66 */       } else if (tabCO.id == 1) {
/*  67 */         mallTab.setCurrencyNum(this.player.moneyManager.getGold());
/*     */       } 
/*     */       
/*  70 */       Map<Integer, IntergalShopBase> items = (IntergalMallConfig.getInstance()).shopItems.get(Integer.valueOf(tabCO.id));
/*  71 */       for (IntergalShopBase prop : items.values()) {
/*     */         
/*  73 */         if (prop.isShow == 0) {
/*     */           continue;
/*     */         }
/*  76 */         if (prop.periodStartDate != null && prop.periodStartDate.getTime() > System.currentTimeMillis()) {
/*     */           continue;
/*     */         }
/*     */         
/*  80 */         if (prop.periodEndDate != null && prop.periodEndDate.getTime() < System.currentTimeMillis()) {
/*     */           continue;
/*     */         }
/*     */         
/*  84 */         IntergalMallHandler.IntergalMallItem.Builder item = IntergalMallHandler.IntergalMallItem.newBuilder();
/*  85 */         item.setId(prop.iD);
/*  86 */         item.setCode(prop.itemCode);
/*     */         
/*  88 */         if (prop.buyTimes == -1) {
/*  89 */           item.setLastcount(-1);
/*     */         }
/*     */         else {
/*     */           
/*  93 */           Map<Integer, Integer> shopHasBuyMap = (Map<Integer, Integer>)this.intergalMallPO.hasBuyItem.get(Integer.valueOf(tabCO.id));
/*  94 */           if (shopHasBuyMap == null) {
/*  95 */             shopHasBuyMap = new HashMap<>();
/*  96 */             this.intergalMallPO.hasBuyItem.put(Integer.valueOf(tabCO.id), shopHasBuyMap);
/*     */           } 
/*  98 */           int hasBuyNum = shopHasBuyMap.containsKey(Integer.valueOf(prop.iD)) ? ((Integer)shopHasBuyMap.get(Integer.valueOf(prop.iD))).intValue() : 0;
/*  99 */           if (hasBuyNum > 0) {
/* 100 */             Out.debug(new Object[] { Integer.valueOf(prop.iD), "---------------------------------------" });
/*     */           }
/*     */           
/* 103 */           int vip = this.player.baseDataManager.getVip();
/* 104 */           int add = 0;
/* 105 */           if (vip > 0) {
/* 106 */             add = ((CardCO)GameData.Cards.get(Integer.valueOf(vip))).prv7;
/*     */           }
/*     */           
/* 109 */           int lastBuyNum = prop.buyTimes - hasBuyNum + add;
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
/*     */ 
/*     */ 
/*     */           
/* 129 */           item.setLastcount(lastBuyNum);
/*     */         } 
/*     */         
/* 132 */         if (prop.countDown == 1) {
/* 133 */           item.setCountdown(prop.periodEndDate.getTime());
/*     */         }
/* 135 */         mallTab.addItems(item);
/*     */       } 
/* 137 */       list.add(mallTab.build());
/*     */     } 
/*     */     
/* 140 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void refreshNewDay() {
/* 147 */     this.intergalMallPO.hasBuyItem.clear();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\intergalmall\IntergalMallManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */