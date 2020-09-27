/*    */ package com.wanniu.game.shopMall;
/*    */ 
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.ExchangeMallExt;
/*    */ import com.wanniu.game.data.ext.ShopMallItemsExt;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShopMallConfig
/*    */ {
/*    */   private static ShopMallConfig instance;
/* 18 */   private static List<ShopMallItemsExt> shopMallItems = new ArrayList<>();
/*    */   
/*    */   public static ShopMallConfig getInstance() {
/* 21 */     if (instance == null) {
/* 22 */       instance = new ShopMallConfig();
/*    */       
/* 24 */       for (ShopMallItemsExt item : GameData.ShopMallItemss.values()) {
/* 25 */         shopMallItems.add(item);
/*    */       }
/* 27 */       Collections.sort(shopMallItems, new Comparator<ShopMallItemsExt>()
/*    */           {
/*    */             public int compare(ShopMallItemsExt o1, ShopMallItemsExt o2)
/*    */             {
/* 31 */               return o1.sort - o2.sort;
/*    */             }
/*    */           });
/*    */     } 
/*    */ 
/*    */     
/* 37 */     return instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final ShopMallItemsExt fingShowMallItemByID(String id) {
/* 57 */     for (ShopMallItemsExt item : shopMallItems) {
/* 58 */       if (item.iD.equals(id)) {
/* 59 */         return item;
/*    */       }
/*    */     } 
/*    */     
/* 63 */     return null;
/*    */   }
/*    */   
/*    */   public final ExchangeMallExt findExchangeMallItemByID(String id) {
/* 67 */     for (ExchangeMallExt exchangeMallExt : GameData.ExchangeMalls.values()) {
/* 68 */       if (exchangeMallExt.iD.equals(id)) {
/* 69 */         return exchangeMallExt;
/*    */       }
/*    */     } 
/*    */     
/* 73 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\shopMall\ShopMallConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */