/*    */ package Xmds;
/*    */ 
/*    */ import Ice.ObjectPrx;
/*    */ import Ice.ObjectPrxHelperBase;
/*    */ import IceInternal.BasicStream;
/*    */ import java.util.Map;
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
/*    */ 
/*    */ public final class PlayerPKInfoDataPrxHelper
/*    */   extends ObjectPrxHelperBase
/*    */   implements PlayerPKInfoDataPrx
/*    */ {
/*    */   public static PlayerPKInfoDataPrx checkedCast(ObjectPrx __obj) {
/* 30 */     return (PlayerPKInfoDataPrx)checkedCastImpl(__obj, ice_staticId(), PlayerPKInfoDataPrx.class, PlayerPKInfoDataPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static PlayerPKInfoDataPrx checkedCast(ObjectPrx __obj, Map<String, String> __ctx) {
/* 35 */     return (PlayerPKInfoDataPrx)checkedCastImpl(__obj, __ctx, ice_staticId(), PlayerPKInfoDataPrx.class, PlayerPKInfoDataPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static PlayerPKInfoDataPrx checkedCast(ObjectPrx __obj, String __facet) {
/* 40 */     return (PlayerPKInfoDataPrx)checkedCastImpl(__obj, __facet, ice_staticId(), PlayerPKInfoDataPrx.class, PlayerPKInfoDataPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static PlayerPKInfoDataPrx checkedCast(ObjectPrx __obj, String __facet, Map<String, String> __ctx) {
/* 45 */     return (PlayerPKInfoDataPrx)checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), PlayerPKInfoDataPrx.class, PlayerPKInfoDataPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static PlayerPKInfoDataPrx uncheckedCast(ObjectPrx __obj) {
/* 50 */     return (PlayerPKInfoDataPrx)uncheckedCastImpl(__obj, PlayerPKInfoDataPrx.class, PlayerPKInfoDataPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static PlayerPKInfoDataPrx uncheckedCast(ObjectPrx __obj, String __facet) {
/* 55 */     return (PlayerPKInfoDataPrx)uncheckedCastImpl(__obj, __facet, PlayerPKInfoDataPrx.class, PlayerPKInfoDataPrxHelper.class);
/*    */   }
/*    */   
/* 58 */   public static final String[] __ids = new String[] { "::Ice::Object", "::Xmds::PlayerPKInfoData" };
/*    */ 
/*    */   
/*    */   public static final long serialVersionUID = 0L;
/*    */ 
/*    */ 
/*    */   
/*    */   public static String ice_staticId() {
/* 66 */     return __ids[1];
/*    */   }
/*    */ 
/*    */   
/*    */   public static void __write(BasicStream __os, PlayerPKInfoDataPrx v) {
/* 71 */     __os.writeProxy(v);
/*    */   }
/*    */ 
/*    */   
/*    */   public static PlayerPKInfoDataPrx __read(BasicStream __is) {
/* 76 */     ObjectPrx proxy = __is.readProxy();
/* 77 */     if (proxy != null) {
/*    */       
/* 79 */       PlayerPKInfoDataPrxHelper result = new PlayerPKInfoDataPrxHelper();
/* 80 */       result.__copyFrom(proxy);
/* 81 */       return result;
/*    */     } 
/* 83 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\Xmds\PlayerPKInfoDataPrxHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */