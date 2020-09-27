/*    */ package com.wanniu.game.intergalmall;
/*    */ 
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.base.IntergalShopBase;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IntergalMallConfig
/*    */ {
/* 17 */   public Map<Integer, Map<Integer, IntergalShopBase>> shopItems = new HashMap<>();
/*    */   
/* 19 */   private static IntergalMallConfig intergalMallConfig = null;
/*    */   
/*    */   private IntergalMallConfig() {
/* 22 */     this.shopItems.put(Integer.valueOf(1), new HashMap<>());
/* 23 */     this.shopItems.put(Integer.valueOf(2), new HashMap<>());
/* 24 */     this.shopItems.put(Integer.valueOf(3), new HashMap<>());
/* 25 */     this.shopItems.put(Integer.valueOf(4), new HashMap<>());
/* 26 */     this.shopItems.put(Integer.valueOf(5), new HashMap<>());
/* 27 */     ((Map)this.shopItems.get(Integer.valueOf(1))).putAll(GameData.SundryShops);
/* 28 */     ((Map)this.shopItems.get(Integer.valueOf(2))).putAll(GameData.MallShops);
/* 29 */     ((Map)this.shopItems.get(Integer.valueOf(3))).putAll(GameData.FateShops);
/* 30 */     ((Map)this.shopItems.get(Integer.valueOf(4))).putAll(GameData.AthleticShops);
/* 31 */     ((Map)this.shopItems.get(Integer.valueOf(5))).putAll(GameData.GuildShops);
/*    */   }
/*    */   
/*    */   public static IntergalMallConfig getInstance() {
/* 35 */     if (intergalMallConfig == null) {
/* 36 */       intergalMallConfig = new IntergalMallConfig();
/*    */     }
/* 38 */     return intergalMallConfig;
/*    */   }
/*    */   
/*    */   public IntergalShopBase getIntergalMallProp(int shopType, int itemId) {
/* 42 */     Map<Integer, IntergalShopBase> items = this.shopItems.get(Integer.valueOf(shopType));
/* 43 */     for (IntergalShopBase prop : items.values()) {
/* 44 */       if (prop.iD == itemId) {
/* 45 */         return prop;
/*    */       }
/*    */     } 
/* 48 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\intergalmall\IntergalMallConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */