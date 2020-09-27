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
/*    */ public final class GetPlayerDataPrxHelper
/*    */   extends ObjectPrxHelperBase
/*    */   implements GetPlayerDataPrx
/*    */ {
/*    */   public static GetPlayerDataPrx checkedCast(ObjectPrx __obj) {
/* 27 */     return (GetPlayerDataPrx)checkedCastImpl(__obj, ice_staticId(), GetPlayerDataPrx.class, GetPlayerDataPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GetPlayerDataPrx checkedCast(ObjectPrx __obj, Map<String, String> __ctx) {
/* 32 */     return (GetPlayerDataPrx)checkedCastImpl(__obj, __ctx, ice_staticId(), GetPlayerDataPrx.class, GetPlayerDataPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GetPlayerDataPrx checkedCast(ObjectPrx __obj, String __facet) {
/* 37 */     return (GetPlayerDataPrx)checkedCastImpl(__obj, __facet, ice_staticId(), GetPlayerDataPrx.class, GetPlayerDataPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GetPlayerDataPrx checkedCast(ObjectPrx __obj, String __facet, Map<String, String> __ctx) {
/* 42 */     return (GetPlayerDataPrx)checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), GetPlayerDataPrx.class, GetPlayerDataPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GetPlayerDataPrx uncheckedCast(ObjectPrx __obj) {
/* 47 */     return (GetPlayerDataPrx)uncheckedCastImpl(__obj, GetPlayerDataPrx.class, GetPlayerDataPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GetPlayerDataPrx uncheckedCast(ObjectPrx __obj, String __facet) {
/* 52 */     return (GetPlayerDataPrx)uncheckedCastImpl(__obj, __facet, GetPlayerDataPrx.class, GetPlayerDataPrxHelper.class);
/*    */   }
/*    */   
/* 55 */   public static final String[] __ids = new String[] { "::Ice::Object", "::Xmds::GetPlayerData" };
/*    */ 
/*    */   
/*    */   public static final long serialVersionUID = 0L;
/*    */ 
/*    */ 
/*    */   
/*    */   public static String ice_staticId() {
/* 63 */     return __ids[1];
/*    */   }
/*    */ 
/*    */   
/*    */   public static void __write(BasicStream __os, GetPlayerDataPrx v) {
/* 68 */     __os.writeProxy(v);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GetPlayerDataPrx __read(BasicStream __is) {
/* 73 */     ObjectPrx proxy = __is.readProxy();
/* 74 */     if (proxy != null) {
/*    */       
/* 76 */       GetPlayerDataPrxHelper result = new GetPlayerDataPrxHelper();
/* 77 */       result.__copyFrom(proxy);
/* 78 */       return result;
/*    */     } 
/* 80 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\Xmds\GetPlayerDataPrxHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */