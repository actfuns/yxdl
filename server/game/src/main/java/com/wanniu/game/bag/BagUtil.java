/*     */ package com.wanniu.game.bag;
/*     */ 
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.locks.Condition;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BagUtil
/*     */ {
/*     */   public static int getGridPrice(int type) {
/*  19 */     if (type == Const.BAG_TYPE.BAG.getValue())
/*  20 */       return GlobalConfig.Package_PricePer; 
/*  21 */     if (type == Const.BAG_TYPE.RECYCLE.getValue()) {
/*  22 */       return 0;
/*     */     }
/*  24 */     return GlobalConfig.PersonalWarehouse_PricePer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean checkCost(WNPlayer player, List<Object[]> costs) {
/*  32 */     boolean flag = true;
/*  33 */     if (costs.size() == 0) {
/*  34 */       flag = false;
/*     */     }
/*  36 */     for (Object[] intString : costs) {
/*  37 */       if (player.getWnBag().findItemNumByCode((String)intString[0]) < ((Integer)intString[1]).intValue()) {
/*  38 */         flag = false;
/*     */       }
/*     */     } 
/*     */     
/*  42 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void cost(WNPlayer player, List<Object[]> costs, Const.GOODS_CHANGE_TYPE costFrom) {
/*  50 */     costs.forEach(v -> player.getWnBag().discardItem((String)v[0], ((Integer)v[1]).intValue(), costFrom, null, false, false));
/*     */   }
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
/*     */   public static void costJustHave(WNPlayer player, List<Object[]> costs) {
/*  63 */     costs.forEach(v -> {
/*     */           int num = player.getWnBag().findItemNumByCode((String)v[0]);
/*     */           player.getWnBag().discardItem((String)v[0], num, null, null, false, false);
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getGridPrice(Const.BAG_TYPE type) {
/*  76 */     if (type == Const.BAG_TYPE.BAG)
/*  77 */       return GlobalConfig.Package_PricePer; 
/*  78 */     if (type == Const.BAG_TYPE.RECYCLE) {
/*  79 */       return 0;
/*     */     }
/*  81 */     return GlobalConfig.PersonalWarehouse_PricePer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getTotalCount(Const.BAG_TYPE type) {
/*  92 */     if (type == Const.BAG_TYPE.BAG)
/*  93 */       return GlobalConfig.Package_MaxSize; 
/*  94 */     if (type == Const.BAG_TYPE.RECYCLE) {
/*  95 */       return GlobalConfig.Package_MaxSize;
/*     */     }
/*  97 */     return GlobalConfig.PersonalWarehouse_MaxSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getSellPrice(int price, int num) {
/* 109 */     return Math.round((price * GlobalConfig.NpcShop_ItemPrice_CutRate / 100)) * num;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WNBag getStoreByType(WNPlayer player, int type) {
/* 120 */     if (type == Const.BAG_TYPE.BAG.getValue())
/* 121 */       return player.bag; 
/* 122 */     if (type == Const.BAG_TYPE.WAREHOUSE.getValue()) {
/* 123 */       return player.wareHouse;
/*     */     }
/* 125 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 130 */     Lock lock = new ReentrantLock();
/* 131 */     lock.lock();
/*     */     try {
/* 133 */       Condition condition = lock.newCondition();
/* 134 */       condition.await(15000L, TimeUnit.MILLISECONDS);
/* 135 */       System.out.println("xxx");
/* 136 */     } catch (InterruptedException e) {
/*     */       
/* 138 */       e.printStackTrace();
/*     */     } finally {
/* 140 */       lock.unlock();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\bag\BagUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */