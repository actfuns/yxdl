/*    */ package com.wanniu.core.game;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
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
/*    */ 
/*    */ public final class LangService
/*    */ {
/* 17 */   private static final Map<String, String> __LANGS = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String put(String key, String value) {
/* 23 */     if (__LANGS.containsKey(key)) {
/* 24 */       Out.warn(new Object[] { "语言包重复配置:", key });
/*    */     }
/* 26 */     return __LANGS.put(key, value);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getValue(String key) {
/* 33 */     return __LANGS.getOrDefault(key, key);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String format(String key, Object... o) {
/* 40 */     return String.format(getValue(key), o);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\game\LangService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */