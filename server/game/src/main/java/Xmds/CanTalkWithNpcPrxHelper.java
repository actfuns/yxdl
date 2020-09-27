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
/*    */ public final class CanTalkWithNpcPrxHelper
/*    */   extends ObjectPrxHelperBase
/*    */   implements CanTalkWithNpcPrx
/*    */ {
/*    */   public static CanTalkWithNpcPrx checkedCast(ObjectPrx __obj) {
/* 30 */     return (CanTalkWithNpcPrx)checkedCastImpl(__obj, ice_staticId(), CanTalkWithNpcPrx.class, CanTalkWithNpcPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CanTalkWithNpcPrx checkedCast(ObjectPrx __obj, Map<String, String> __ctx) {
/* 35 */     return (CanTalkWithNpcPrx)checkedCastImpl(__obj, __ctx, ice_staticId(), CanTalkWithNpcPrx.class, CanTalkWithNpcPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CanTalkWithNpcPrx checkedCast(ObjectPrx __obj, String __facet) {
/* 40 */     return (CanTalkWithNpcPrx)checkedCastImpl(__obj, __facet, ice_staticId(), CanTalkWithNpcPrx.class, CanTalkWithNpcPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CanTalkWithNpcPrx checkedCast(ObjectPrx __obj, String __facet, Map<String, String> __ctx) {
/* 45 */     return (CanTalkWithNpcPrx)checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), CanTalkWithNpcPrx.class, CanTalkWithNpcPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CanTalkWithNpcPrx uncheckedCast(ObjectPrx __obj) {
/* 50 */     return (CanTalkWithNpcPrx)uncheckedCastImpl(__obj, CanTalkWithNpcPrx.class, CanTalkWithNpcPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CanTalkWithNpcPrx uncheckedCast(ObjectPrx __obj, String __facet) {
/* 55 */     return (CanTalkWithNpcPrx)uncheckedCastImpl(__obj, __facet, CanTalkWithNpcPrx.class, CanTalkWithNpcPrxHelper.class);
/*    */   }
/*    */   
/* 58 */   public static final String[] __ids = new String[] { "::Ice::Object", "::Xmds::CanTalkWithNpc" };
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
/*    */   public static void __write(BasicStream __os, CanTalkWithNpcPrx v) {
/* 71 */     __os.writeProxy(v);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CanTalkWithNpcPrx __read(BasicStream __is) {
/* 76 */     ObjectPrx proxy = __is.readProxy();
/* 77 */     if (proxy != null) {
/*    */       
/* 79 */       CanTalkWithNpcPrxHelper result = new CanTalkWithNpcPrxHelper();
/* 80 */       result.__copyFrom(proxy);
/* 81 */       return result;
/*    */     } 
/* 83 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\Xmds\CanTalkWithNpcPrxHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */