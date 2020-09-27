/*    */ package com.wanniu.core.util;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import java.util.Enumeration;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Properties;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class PropertiesUtil
/*    */ {
/*    */   public static Map<String, String> loadProperties(File file) {
/* 24 */     Map<String, String> ret = new HashMap<>();
/* 25 */     Properties props = new Properties();
/*    */     try {
/* 27 */       InputStream in = new FileInputStream(file);
/* 28 */       props.load(in);
/* 29 */       Enumeration<?> en = props.propertyNames();
/* 30 */       while (en.hasMoreElements()) {
/* 31 */         String key = (String)en.nextElement();
/* 32 */         String value = props.getProperty(key);
/* 33 */         ret.put(key, value);
/*    */       } 
/* 35 */       props.clear();
/* 36 */     } catch (Exception e) {
/* 37 */       Out.error(new Object[] { "PropertiesUtil loadProperties", e });
/*    */     } 
/* 39 */     return ret;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void writeProperties(File file, String name, String value) {
/* 44 */     Properties prop = new Properties();
/*    */     try {
/* 46 */       InputStream fis = new FileInputStream(file);
/*    */       
/* 48 */       prop.load(fis);
/*    */ 
/*    */       
/* 51 */       OutputStream fos = new FileOutputStream(file);
/* 52 */       prop.setProperty(name, value);
/*    */ 
/*    */       
/* 55 */       prop.store(fos, "Update '" + name + "' value");
/* 56 */     } catch (IOException e) {
/* 57 */       Out.error(new Object[] { "Visit ", file.getPath(), " for updating ", name, " value error", e });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\PropertiesUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */