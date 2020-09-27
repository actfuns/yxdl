/*    */ package com.wanniu.core.util;
/*    */ 
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
/*    */ public final class PropertiesUtil
/*    */ {
/*    */   public static Map<String, String> loadProperties(File file) {
/* 22 */     Map<String, String> ret = new HashMap<>();
/* 23 */     Properties props = new Properties();
/*    */     try {
/* 25 */       InputStream in = new FileInputStream(file);
/* 26 */       props.load(in);
/* 27 */       Enumeration<?> en = props.propertyNames();
/* 28 */       while (en.hasMoreElements()) {
/* 29 */         String key = (String)en.nextElement();
/* 30 */         String value = props.getProperty(key);
/* 31 */         ret.put(key, value);
/*    */       } 
/* 33 */       props.clear();
/* 34 */     } catch (Exception e) {
/* 35 */       e.printStackTrace();
/*    */     } 
/* 37 */     return ret;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void writeProperties(File file, String name, String value) {
/* 42 */     Properties prop = new Properties();
/*    */     try {
/* 44 */       InputStream fis = new FileInputStream(file);
/*    */       
/* 46 */       prop.load(fis);
/*    */ 
/*    */       
/* 49 */       OutputStream fos = new FileOutputStream(file);
/* 50 */       prop.setProperty(name, value);
/*    */ 
/*    */       
/* 53 */       prop.store(fos, "Update '" + name + "' value");
/* 54 */     } catch (IOException e) {
/* 55 */       System.err.println("Visit " + file.getPath() + " for updating " + name + " value error");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\cor\\util\PropertiesUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */