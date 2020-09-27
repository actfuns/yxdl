/*    */ package com.wanniu.game.sale;
/*    */ 
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.MenuUISaleCO;
/*    */ import com.wanniu.game.data.NpcSaleCO;
/*    */ import com.wanniu.game.data.base.SaleBase;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ 
/*    */ public class SaleConfig
/*    */ {
/*    */   private static SaleConfig instance;
/*    */   
/*    */   public static SaleConfig getInstance() {
/* 16 */     if (instance == null) {
/* 17 */       instance = new SaleConfig();
/*    */     }
/* 19 */     return instance;
/*    */   }
/*    */   
/* 22 */   private ArrayList<SaleBase> listSaleProp = new ArrayList<>();
/*    */   
/*    */   private SaleConfig() {
/* 25 */     for (MenuUISaleCO sale : GameData.MenuUISales.values()) {
/* 26 */       sale.initProperty();
/* 27 */       this.listSaleProp.add(sale);
/*    */     } 
/* 29 */     for (NpcSaleCO sale : GameData.NpcSales.values()) {
/* 30 */       sale.initProperty();
/* 31 */       this.listSaleProp.add(sale);
/*    */     } 
/*    */   }
/*    */   
/*    */   public final ArrayList<SaleBase> findPropByTypeId(List<Integer> typeIds) {
/* 36 */     ArrayList<SaleBase> list = new ArrayList<>();
/* 37 */     for (SaleBase sale : this.listSaleProp) {
/* 38 */       for (Iterator<Integer> iterator = typeIds.iterator(); iterator.hasNext(); ) { int value = ((Integer)iterator.next()).intValue();
/* 39 */         if (sale.typeID == value) {
/* 40 */           list.add(sale);
/*    */         } }
/*    */     
/*    */     } 
/*    */     
/* 45 */     return list;
/*    */   }
/*    */   
/*    */   public final ArrayList<SaleBase> findPropByItemCode(String itemCode) {
/* 49 */     ArrayList<SaleBase> list = new ArrayList<>();
/* 50 */     for (SaleBase sale : this.listSaleProp) {
/* 51 */       if (sale.itemCode.equals(itemCode)) {
/* 52 */         list.add(sale);
/*    */       }
/*    */     } 
/* 55 */     return list;
/*    */   }
/*    */   
/*    */   public final SaleBase findPropByTypeIdAndItemId(int typeId, int itemId) {
/* 59 */     for (SaleBase sale : this.listSaleProp) {
/* 60 */       if (sale.typeID == typeId && sale.itemID == itemId) {
/* 61 */         return sale;
/*    */       }
/*    */     } 
/* 64 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\sale\SaleConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */