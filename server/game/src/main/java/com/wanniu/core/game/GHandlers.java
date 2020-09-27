/*     */ package com.wanniu.core.game;
/*     */ 
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.net.JarURLConnection;
/*     */ import java.net.URL;
/*     */ import java.net.URLDecoder;
/*     */ import java.util.Enumeration;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GHandlers
/*     */ {
/*     */   public static void init(String pakName) {
/*  23 */     Out.info(new Object[] { "搜索客户端处理句柄路径 -> ", pakName });
/*     */     try {
/*  25 */       Enumeration<URL> urls = GHandlers.class.getClassLoader().getResources(pakName.replace(".", "/"));
/*  26 */       while (urls.hasMoreElements()) {
/*  27 */         URL url = urls.nextElement();
/*  28 */         if (url != null) {
/*  29 */           String protocol = url.getProtocol();
/*  30 */           if (protocol.equals("file")) {
/*  31 */             String pakPath = URLDecoder.decode(url.getPath(), "UTF-8");
/*  32 */             addClassByAnnotation(pakPath, pakName); continue;
/*  33 */           }  if (protocol.equals("jar")) {
/*  34 */             JarURLConnection jarURLConnection = (JarURLConnection)url.openConnection();
/*  35 */             JarFile jarFile = jarURLConnection.getJarFile();
/*  36 */             Enumeration<JarEntry> jarEntries = jarFile.entries();
/*  37 */             while (jarEntries.hasMoreElements()) {
/*  38 */               JarEntry jarEntry = jarEntries.nextElement();
/*  39 */               String jarEntryName = jarEntry.getName();
/*  40 */               if (jarEntryName.endsWith(".class")) {
/*  41 */                 String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replaceAll("/", ".");
/*  42 */                 if (className.startsWith(pakName)) {
/*  43 */                   GGame.getInstance().addClassBySearchPath(className);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*  50 */     } catch (Exception e) {
/*  51 */       Out.error(new Object[] { "GHandlers init", e });
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void addClassByAnnotation(String pakPath, String pakName) {
/*  56 */     File[] files = getClassFiles(pakPath);
/*  57 */     if (files != null) {
/*  58 */       for (File file : files) {
/*  59 */         String fileName = file.getName();
/*  60 */         if (file.isFile()) {
/*  61 */           String className = getClassName(pakName, fileName);
/*  62 */           if (className.startsWith(pakName)) {
/*  63 */             GGame.getInstance().addClassBySearchPath(className);
/*     */           }
/*     */         } else {
/*  66 */           String subPackagePath = getSubPackagePath(pakPath, fileName);
/*  67 */           String subPakName = getSubPackageName(pakName, fileName);
/*  68 */           addClassByAnnotation(subPackagePath, subPakName);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static File[] getClassFiles(String pakPath) {
/*  75 */     return (new File(pakPath)).listFiles(new FileFilter()
/*     */         {
/*     */           public boolean accept(File file) {
/*  78 */             return ((file.isFile() && file.getName().endsWith(".class")) || file.isDirectory());
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private static String getClassName(String pakName, String fileName) {
/*  84 */     String className = fileName.substring(0, fileName.lastIndexOf("."));
/*  85 */     if (!isEmpty(pakName)) {
/*  86 */       className = pakName + "." + className;
/*     */     }
/*  88 */     return className;
/*     */   }
/*     */   
/*     */   private static String getSubPackagePath(String pakPath, String filePath) {
/*  92 */     String subPakPath = filePath;
/*  93 */     if (!isEmpty(pakPath)) {
/*  94 */       subPakPath = pakPath + "/" + subPakPath;
/*     */     }
/*  96 */     return subPakPath;
/*     */   }
/*     */   
/*     */   private static String getSubPackageName(String pakName, String filePath) {
/* 100 */     String subPakName = filePath;
/* 101 */     if (!isEmpty(pakName)) {
/* 102 */       subPakName = pakName + "." + subPakName;
/*     */     }
/* 104 */     return subPakName;
/*     */   }
/*     */   
/*     */   private static boolean isEmpty(String tmp) {
/* 108 */     return (tmp == null || "".equals(tmp.trim()));
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\game\GHandlers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */