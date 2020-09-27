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
/*    */ public final class RefreshPlayerPropertyChangePrxHelper
/*    */   extends ObjectPrxHelperBase
/*    */   implements RefreshPlayerPropertyChangePrx
/*    */ {
/*    */   public static RefreshPlayerPropertyChangePrx checkedCast(ObjectPrx __obj) {
/* 30 */     return (RefreshPlayerPropertyChangePrx)checkedCastImpl(__obj, ice_staticId(), RefreshPlayerPropertyChangePrx.class, RefreshPlayerPropertyChangePrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static RefreshPlayerPropertyChangePrx checkedCast(ObjectPrx __obj, Map<String, String> __ctx) {
/* 35 */     return (RefreshPlayerPropertyChangePrx)checkedCastImpl(__obj, __ctx, ice_staticId(), RefreshPlayerPropertyChangePrx.class, RefreshPlayerPropertyChangePrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static RefreshPlayerPropertyChangePrx checkedCast(ObjectPrx __obj, String __facet) {
/* 40 */     return (RefreshPlayerPropertyChangePrx)checkedCastImpl(__obj, __facet, ice_staticId(), RefreshPlayerPropertyChangePrx.class, RefreshPlayerPropertyChangePrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static RefreshPlayerPropertyChangePrx checkedCast(ObjectPrx __obj, String __facet, Map<String, String> __ctx) {
/* 45 */     return (RefreshPlayerPropertyChangePrx)checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), RefreshPlayerPropertyChangePrx.class, RefreshPlayerPropertyChangePrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static RefreshPlayerPropertyChangePrx uncheckedCast(ObjectPrx __obj) {
/* 50 */     return (RefreshPlayerPropertyChangePrx)uncheckedCastImpl(__obj, RefreshPlayerPropertyChangePrx.class, RefreshPlayerPropertyChangePrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static RefreshPlayerPropertyChangePrx uncheckedCast(ObjectPrx __obj, String __facet) {
/* 55 */     return (RefreshPlayerPropertyChangePrx)uncheckedCastImpl(__obj, __facet, RefreshPlayerPropertyChangePrx.class, RefreshPlayerPropertyChangePrxHelper.class);
/*    */   }
/*    */   
/* 58 */   public static final String[] __ids = new String[] { "::Ice::Object", "::Xmds::RefreshPlayerPropertyChange" };
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
/*    */   public static void __write(BasicStream __os, RefreshPlayerPropertyChangePrx v) {
/* 71 */     __os.writeProxy(v);
/*    */   }
/*    */ 
/*    */   
/*    */   public static RefreshPlayerPropertyChangePrx __read(BasicStream __is) {
/* 76 */     ObjectPrx proxy = __is.readProxy();
/* 77 */     if (proxy != null) {
/*    */       
/* 79 */       RefreshPlayerPropertyChangePrxHelper result = new RefreshPlayerPropertyChangePrxHelper();
/* 80 */       result.__copyFrom(proxy);
/* 81 */       return result;
/*    */     } 
/* 83 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\Xmds\RefreshPlayerPropertyChangePrxHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */