/*    */ package com.wanniu.game.intergalmall;
/*    */ 
/*    */ import com.wanniu.core.db.GCache;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.common.ConstsTR;
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
/*    */ public class IntergalMallGlobalService
/*    */ {
/*    */   private IntergalMallGlobalService() {}
/*    */   
/*    */   public static class Holder
/*    */   {
/* 22 */     public static final IntergalMallGlobalService instance = new IntergalMallGlobalService();
/*    */   }
/*    */   
/*    */   public static IntergalMallGlobalService getInstance() {
/* 26 */     return Holder.instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void refreshNewDay() {
/* 33 */     Map<String, String> nums = GCache.hgetAll(ConstsTR.intergalMallGlobalTR.value);
/* 34 */     if (nums == null) {
/*    */       return;
/*    */     }
/* 37 */     for (String key : nums.keySet()) {
/* 38 */       GCache.hset(ConstsTR.intergalMallGlobalTR.value, key, String.valueOf(0));
/*    */     }
/*    */   }
/*    */   
/*    */   public int getGlobalNum(int shopType, int itemId) {
/* 43 */     int result = 0;
/* 44 */     String str = GCache.hget(ConstsTR.intergalMallGlobalTR.value, shopType + "/" + itemId);
/* 45 */     if (StringUtil.isNotEmpty(str)) {
/* 46 */       result = Integer.parseInt(str);
/*    */     }
/* 48 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\intergalmall\IntergalMallGlobalService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */