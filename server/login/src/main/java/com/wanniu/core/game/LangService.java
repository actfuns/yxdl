/*     */ package com.wanniu.core.game;
/*     */ 
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.FileUtil;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class LangService
/*     */ {
/*  21 */   private static final Map<String, String> __LANGS = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<String, String> build(Class<?> clz) {
/*  27 */     return build(String.valueOf(clz.getSimpleName()) + ".txt");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<String, String> build(String file) {
/*  34 */     return build(new File(String.valueOf(GGlobal.DIR_LANGUAGE) + file));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<String, String> build(File file) {
/*  41 */     Map<String, String> maps = new HashMap<>();
/*  42 */     List<String> langs = FileUtil.readLines(file);
/*  43 */     for (String lang : langs) {
/*  44 */       String text = lang.trim();
/*  45 */       if (text.startsWith("#") || text.length() == 0)
/*  46 */         continue;  int index = text.indexOf("=");
/*  47 */       if (index > 0) {
/*  48 */         String key = text.substring(0, index);
/*  49 */         String value = text.substring(index + 1);
/*  50 */         if (value.length() > 0) {
/*  51 */           maps.put(key, value);
/*     */         }
/*     */       } 
/*     */     } 
/*  55 */     return maps;
/*     */   }
/*     */   
/*     */   private static void init(boolean reinit) {
/*  59 */     File language = new File(GGlobal.DIR_LANGUAGE);
/*  60 */     if (language.exists() && language.isDirectory()) {
/*  61 */       File[] langs = language.listFiles(new FileFilter()
/*     */           {
/*     */             public boolean accept(File file) {
/*  64 */               if (file.isFile()) return true; 
/*  65 */               return false;
/*     */             }
/*     */           });
/*  68 */       Map<String, String> msgs = null; byte b; int i; File[] arrayOfFile1;
/*  69 */       for (i = (arrayOfFile1 = langs).length, b = 0; b < i; ) { File file = arrayOfFile1[b];
/*  70 */         msgs = build(file);
/*  71 */         for (Map.Entry<String, String> entry : msgs.entrySet()) {
/*  72 */           if (__LANGS.containsKey(entry.getKey()) && !reinit) {
/*  73 */             Out.error(new Object[] { String.format("当前包 (%s) ： [%s]  -> %s，已经存在值：%s", new Object[] { file.getName(), entry.getKey(), entry.getValue(), __LANGS.get(entry.getKey()) }) });
/*     */           }
/*  75 */           __LANGS.put(entry.getKey(), entry.getValue());
/*     */         } 
/*  77 */         Out.info(new Object[] { String.format("加载语言包文件 -> %s\t\t[%d / %d]", new Object[] { file.getName(), Integer.valueOf(msgs.size()), Integer.valueOf(__LANGS.size()) }) });
/*     */         b++; }
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void init() {
/*  84 */     init(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void reinit() {
/*  89 */     init(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String put(String key, String value) {
/*  96 */     return __LANGS.put(key, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getValue(String key) {
/* 103 */     return __LANGS.get(key);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\game\LangService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */