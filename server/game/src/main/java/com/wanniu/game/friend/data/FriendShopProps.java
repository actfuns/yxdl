/*    */ package com.wanniu.game.friend.data;
/*    */ 
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.SShopCO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class FriendShopProps
/*    */ {
/*    */   public static SShopCO findPropByItemIDAndIsValid(int itemId, int isValid) {
/* 12 */     for (Map.Entry<Integer, SShopCO> node : (Iterable<Map.Entry<Integer, SShopCO>>)GameData.SShops.entrySet()) {
/* 13 */       SShopCO data = node.getValue();
/* 14 */       if (data.isValid == isValid && data.itemID == itemId) {
/* 15 */         return data;
/*    */       }
/*    */     } 
/* 18 */     return null;
/*    */   }
/*    */   
/*    */   public static ArrayList<SShopCO> findPropByIsValid(int isValid) {
/* 22 */     ArrayList<SShopCO> list = new ArrayList<>();
/* 23 */     for (Map.Entry<Integer, SShopCO> node : (Iterable<Map.Entry<Integer, SShopCO>>)GameData.SShops.entrySet()) {
/* 24 */       SShopCO data = node.getValue();
/* 25 */       if (data.isValid == isValid) {
/* 26 */         list.add(data);
/*    */       }
/*    */     } 
/* 29 */     return list;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\friend\data\FriendShopProps.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */