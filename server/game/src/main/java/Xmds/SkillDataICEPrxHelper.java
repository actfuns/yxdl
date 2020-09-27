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
/*    */ public final class SkillDataICEPrxHelper
/*    */   extends ObjectPrxHelperBase
/*    */   implements SkillDataICEPrx
/*    */ {
/*    */   public static SkillDataICEPrx checkedCast(ObjectPrx __obj) {
/* 30 */     return (SkillDataICEPrx)checkedCastImpl(__obj, ice_staticId(), SkillDataICEPrx.class, SkillDataICEPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static SkillDataICEPrx checkedCast(ObjectPrx __obj, Map<String, String> __ctx) {
/* 35 */     return (SkillDataICEPrx)checkedCastImpl(__obj, __ctx, ice_staticId(), SkillDataICEPrx.class, SkillDataICEPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static SkillDataICEPrx checkedCast(ObjectPrx __obj, String __facet) {
/* 40 */     return (SkillDataICEPrx)checkedCastImpl(__obj, __facet, ice_staticId(), SkillDataICEPrx.class, SkillDataICEPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static SkillDataICEPrx checkedCast(ObjectPrx __obj, String __facet, Map<String, String> __ctx) {
/* 45 */     return (SkillDataICEPrx)checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), SkillDataICEPrx.class, SkillDataICEPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static SkillDataICEPrx uncheckedCast(ObjectPrx __obj) {
/* 50 */     return (SkillDataICEPrx)uncheckedCastImpl(__obj, SkillDataICEPrx.class, SkillDataICEPrxHelper.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static SkillDataICEPrx uncheckedCast(ObjectPrx __obj, String __facet) {
/* 55 */     return (SkillDataICEPrx)uncheckedCastImpl(__obj, __facet, SkillDataICEPrx.class, SkillDataICEPrxHelper.class);
/*    */   }
/*    */   
/* 58 */   public static final String[] __ids = new String[] { "::Ice::Object", "::Xmds::SkillDataICE" };
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
/*    */   public static void __write(BasicStream __os, SkillDataICEPrx v) {
/* 71 */     __os.writeProxy(v);
/*    */   }
/*    */ 
/*    */   
/*    */   public static SkillDataICEPrx __read(BasicStream __is) {
/* 76 */     ObjectPrx proxy = __is.readProxy();
/* 77 */     if (proxy != null) {
/*    */       
/* 79 */       SkillDataICEPrxHelper result = new SkillDataICEPrxHelper();
/* 80 */       result.__copyFrom(proxy);
/* 81 */       return result;
/*    */     } 
/* 83 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\Xmds\SkillDataICEPrxHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */