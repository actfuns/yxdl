/*     */ package com.wanniu.core.util;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.JarURLConnection;
/*     */ import java.net.URL;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClassUtils
/*     */ {
/*     */   private static final String URL_PROTOCOL_FILE = "file";
/*     */   private static final String URL_PROTOCOL_JAR = "jar";
/*     */   
/*     */   public static Class<?> loadClass(String className) {
/*     */     try {
/*  33 */       return Thread.currentThread().getContextClassLoader().loadClass(className);
/*  34 */     } catch (ClassNotFoundException classNotFoundException) {
/*     */       
/*     */       try {
/*  37 */         return Class.forName(className);
/*  38 */       } catch (ClassNotFoundException classNotFoundException1) {
/*     */         
/*  40 */         throw new RuntimeException("无法加载指定类" + className);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> T newInstance(Class<T> klass) {
/*     */     try {
/*  54 */       return klass.newInstance();
/*  55 */     } catch (InstantiationException|IllegalAccessException e) {
/*  56 */       throw new RuntimeException("无法创建实例对象" + klass.getName(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void scanPackage(String packagePath, ResourceCallback callback) {
/*  62 */     packagePath = packagePath.replace('.', '/').replace('\\', '/');
/*  63 */     if (!packagePath.endsWith("/")) {
/*  64 */       packagePath = packagePath + "/";
/*     */     }
/*     */     
/*     */     try {
/*  68 */       Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
/*  69 */       while (urls.hasMoreElements()) {
/*  70 */         URL url = urls.nextElement();
/*  71 */         switch (url.getProtocol()) {
/*     */           
/*     */           case "file":
/*  74 */             doFindFileResources(packagePath, new File(url.getFile()), callback);
/*     */ 
/*     */           
/*     */           case "jar":
/*  78 */             doFindJarResources(url, callback, packagePath);
/*     */         } 
/*     */ 
/*     */ 
/*     */       
/*     */       } 
/*  84 */     } catch (IOException e) {
/*  85 */       throw new RuntimeException("扫描过程中出异常啦", e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void doFindJarResources(URL url, ResourceCallback callback, String rootEntryPath) throws IOException {
/*  91 */     JarURLConnection jarCon = (JarURLConnection)url.openConnection();
/*  92 */     try (JarFile jarFile = jarCon.getJarFile()) {
/*  93 */       for (Enumeration<JarEntry> entries = jarFile.entries(); entries.hasMoreElements(); ) {
/*  94 */         String entryPath = ((JarEntry)entries.nextElement()).getName();
/*  95 */         if (entryPath.startsWith(rootEntryPath)) {
/*  96 */           findJarFile(entryPath, callback);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void doFindFileResources(String packagePath, File file, ResourceCallback callback) {
/* 106 */     String path = file.getAbsolutePath();
/*     */ 
/*     */     
/* 109 */     if (!file.exists()) {
/* 110 */       Out.debug(new Object[] { "Skipping [", path, "] because it does not exist" });
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 115 */     if (!file.canRead()) {
/* 116 */       Out.warn(new Object[] { "Cannot search for matching files underneath directory [", path, "] because the application is not allowed to read the directory" });
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 122 */     if (file.isDirectory()) {
/* 123 */       findDir(packagePath, file, callback);
/*     */     
/*     */     }
/* 126 */     else if (file.isFile()) {
/* 127 */       findFile(packagePath, file, callback);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void findDir(String packagePath, File dir, ResourceCallback callback) {
/* 140 */     File[] dirContents = dir.listFiles();
/*     */ 
/*     */     
/* 143 */     if (dirContents == null) {
/* 144 */       Out.warn(new Object[] { "Could not retrieve contents of directory [", dir.getAbsolutePath(), "]" });
/*     */       
/*     */       return;
/*     */     } 
/* 148 */     for (File content : dirContents) {
/*     */       
/* 150 */       if (content.isFile()) {
/* 151 */         findFile(packagePath, content, callback);
/*     */       
/*     */       }
/* 154 */       else if (content.isDirectory()) {
/*     */         
/* 156 */         findDir(packagePath + content.getName() + "/", content, callback);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void findJarFile(String entryPath, ResourceCallback callback) {
/* 170 */     analysisResource(callback, entryPath);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void findFile(String packagePath, File file, ResourceCallback callback) {
/* 184 */     analysisResource(callback, packagePath + file.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   private static void analysisResource(ResourceCallback callback, String resourceName) {
/* 189 */     if ("package-info.class".equals(resourceName)) {
/*     */       return;
/*     */     }
/*     */     
/* 193 */     if (!resourceName.endsWith(".class")) {
/*     */       return;
/*     */     }
/*     */     
/* 197 */     callback.handleResource(
/* 198 */         loadClass(resourceName.substring(0, resourceName.length() - 6).replaceAll("[/\\\\]", ".")));
/*     */   }
/*     */   
/*     */   public static interface ResourceCallback {
/*     */     void handleResource(Class<?> param1Class);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\ClassUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */