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
/*    */ public final class CanTalkWithNpcResultPrxHelper
/*    */   extends ObjectPrxHelperBase
/*    */   implements CanTalkWithNpcResultPrx
/*    */ {
/*    */   public static CanTalkWithNpcResultPrx checkedCast(ObjectPrx __obj) {
/* 30 */     return (CanTalkWithNpcResultPrx)checkedCastImpl(__obj, ice_staticId(), CanTalkWithNpcResultPrx.class, CanTalkWithNpcResultPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CanTalkWithNpcResultPrx checkedCast(ObjectPrx __obj, Map<String, String> __ctx) {
/* 35 */     return (CanTalkWithNpcResultPrx)checkedCastImpl(__obj, __ctx, ice_staticId(), CanTalkWithNpcResultPrx.class, CanTalkWithNpcResultPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CanTalkWithNpcResultPrx checkedCast(ObjectPrx __obj, String __facet) {
/* 40 */     return (CanTalkWithNpcResultPrx)checkedCastImpl(__obj, __facet, ice_staticId(), CanTalkWithNpcResultPrx.class, CanTalkWithNpcResultPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CanTalkWithNpcResultPrx checkedCast(ObjectPrx __obj, String __facet, Map<String, String> __ctx) {
/* 45 */     return (CanTalkWithNpcResultPrx)checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), CanTalkWithNpcResultPrx.class, CanTalkWithNpcResultPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CanTalkWithNpcResultPrx uncheckedCast(ObjectPrx __obj) {
/* 50 */     return (CanTalkWithNpcResultPrx)uncheckedCastImpl(__obj, CanTalkWithNpcResultPrx.class, CanTalkWithNpcResultPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CanTalkWithNpcResultPrx uncheckedCast(ObjectPrx __obj, String __facet) {
/* 55 */     return (CanTalkWithNpcResultPrx)uncheckedCastImpl(__obj, __facet, CanTalkWithNpcResultPrx.class, CanTalkWithNpcResultPrxHelper.class);
/*    */   }
/*    */   
/* 58 */   public static final String[] __ids = new String[] { "::Ice::Object", "::Xmds::CanTalkWithNpcResult" };
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
/*    */   public static void __write(BasicStream __os, CanTalkWithNpcResultPrx v) {
/* 71 */     __os.writeProxy(v);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CanTalkWithNpcResultPrx __read(BasicStream __is) {
/* 76 */     ObjectPrx proxy = __is.readProxy();
/* 77 */     if (proxy != null) {
/*    */       
/* 79 */       CanTalkWithNpcResultPrxHelper result = new CanTalkWithNpcResultPrxHelper();
/* 80 */       result.__copyFrom(proxy);
/* 81 */       return result;
/*    */     } 
/* 83 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\Xmds\CanTalkWithNpcResultPrxHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */