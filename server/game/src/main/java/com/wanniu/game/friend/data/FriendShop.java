/*    */ package com.wanniu.game.friend.data;
/*    */ 
/*    */ import com.wanniu.game.common.CurrencyData;
/*    */ import com.wanniu.game.data.SShopCO;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ public class FriendShop
/*    */   extends SShopCO
/*    */ {
/*    */   public ArrayList<CurrencyData> moneyReqList;
/*    */   
/*    */   public void initProperty() {
/* 14 */     super.initProperty();
/* 15 */     ArrayList<CurrencyData> moneyReqList = new ArrayList<>();
/* 16 */     boolean has = true;
/* 17 */     int type = 0;
/* 18 */     int value = 0;
/* 19 */     for (int i = 1; i <= 3; i++) {
/* 20 */       switch (i) {
/*    */         case 1:
/* 22 */           if (this.type1 > 0 && this.value1 > 0) {
/* 23 */             has = true;
/* 24 */             type = this.type1;
/* 25 */             value = this.value1; break;
/*    */           } 
/* 27 */           has = false;
/*    */           break;
/*    */         
/*    */         case 2:
/* 31 */           if (this.type2 > 0 && this.value2 > 0) {
/* 32 */             has = true;
/* 33 */             type = this.type2;
/* 34 */             value = this.value2; break;
/*    */           } 
/* 36 */           has = false;
/*    */           break;
/*    */         
/*    */         case 3:
/* 40 */           if (this.type3 > 0 && this.value3 > 0) {
/* 41 */             has = true;
/* 42 */             type = this.type3;
/* 43 */             value = this.value3; break;
/*    */           } 
/* 45 */           has = false;
/*    */           break;
/*    */       } 
/*    */       
/* 49 */       if (has) {
/* 50 */         moneyReqList.add(new CurrencyData(type, value));
/*    */       }
/*    */     } 
/* 53 */     this.moneyReqList = moneyReqList;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\friend\data\FriendShop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */