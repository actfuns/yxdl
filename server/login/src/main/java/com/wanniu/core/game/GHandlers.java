/*     */ package com.wanniu.core.game;
/*     */ 
/*     */ import com.wanniu.core.GServer;
/*     */ import com.wanniu.core.game.request.GClientEvent;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.NetHandler;
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
/*     */ public final class GHandlers
/*     */ {
/*     */   public static void init(String pakName) {
/*  20 */     Out.info(
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
/*     */ 
/*     */         
/*  53 */         new Object[] { "搜索客户端处理句柄路径 -> ", pakName }); try { Enumeration<URL> urls = GHandlers.class.getClassLoader().getResources(pakName.replace(".", "/")); while (urls.hasMoreElements()) { URL url = urls.nextElement(); if (url != null) { String protocol = url.getProtocol(); if (protocol.equals("file")) { String pakPath = URLDecoder.decode(url.getPath(), "UTF-8"); addClassByAnnotation(pakPath, pakName); continue; }  if (protocol.equals("jar")) { JarURLConnection jarURLConnection = (JarURLConnection)url.openConnection(); JarFile jarFile = jarURLConnection.getJarFile(); Enumeration<JarEntry> jarEntries = jarFile.entries(); while (jarEntries.hasMoreElements()) { JarEntry jarEntry = jarEntries.nextElement(); String jarEntryName = jarEntry.getName(); if (jarEntryName.endsWith(".class")) { String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replaceAll("/", "."); if (className.startsWith(pakName)) { Class<?> cls = Class.forName(className); if (cls.isAnnotationPresent((Class)GClientEvent.class))
/*     */                     GServer.getInstance().registerHandler((NetHandler)cls.newInstance());  }  }  }  }  }  }
/*     */        }
/*     */     catch (Exception e) { throw new RuntimeException(e); }
/*  57 */      } private static void addClassByAnnotation(String pakPath, String pakName) { try { File[] files = getClassFiles(pakPath);
/*  58 */       if (files != null) {
/*  59 */         byte b; int i; File[] arrayOfFile; for (i = (arrayOfFile = files).length, b = 0; b < i; ) { File file = arrayOfFile[b];
/*  60 */           String fileName = file.getName();
/*  61 */           if (file.isFile()) {
/*  62 */             String className = getClassName(pakName, fileName);
/*  63 */             if (className.startsWith(pakName)) {
/*  64 */               Class<?> cls = Class.forName(className);
/*  65 */               if (cls.isAnnotationPresent((Class)GClientEvent.class)) {
/*  66 */                 GServer.getInstance().registerHandler((NetHandler)cls.newInstance());
/*     */               }
/*     */             } 
/*     */           } else {
/*  70 */             String subPackagePath = getSubPackagePath(pakPath, fileName);
/*  71 */             String subPakName = getSubPackageName(pakName, fileName);
/*  72 */             addClassByAnnotation(subPackagePath, subPakName);
/*     */           }  b++; }
/*     */       
/*     */       }  }
/*  76 */     catch (Exception e)
/*  77 */     { throw new RuntimeException(e); }
/*     */      }
/*     */ 
/*     */   
/*     */   private static File[] getClassFiles(String pakPath) {
/*  82 */     return (new File(pakPath)).listFiles(new FileFilter()
/*     */         {
/*     */           public boolean accept(File file) {
/*  85 */             return !((!file.isFile() || !file.getName().endsWith(".class")) && !file.isDirectory());
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private static String getClassName(String pakName, String fileName) {
/*  91 */     String className = fileName.substring(0, fileName.lastIndexOf("."));
/*  92 */     if (!isEmpty(pakName)) {
/*  93 */       className = String.valueOf(pakName) + "." + className;
/*     */     }
/*  95 */     return className;
/*     */   }
/*     */   
/*     */   private static String getSubPackagePath(String pakPath, String filePath) {
/*  99 */     String subPakPath = filePath;
/* 100 */     if (!isEmpty(pakPath)) {
/* 101 */       subPakPath = String.valueOf(pakPath) + "/" + subPakPath;
/*     */     }
/* 103 */     return subPakPath;
/*     */   }
/*     */   
/*     */   private static String getSubPackageName(String pakName, String filePath) {
/* 107 */     String subPakName = filePath;
/* 108 */     if (!isEmpty(pakName)) {
/* 109 */       subPakName = String.valueOf(pakName) + "." + subPakName;
/*     */     }
/* 111 */     return subPakName;
/*     */   }
/*     */   
/*     */   private static boolean isEmpty(String tmp) {
/* 115 */     return !(tmp != null && !"".equals(tmp.trim()));
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\game\GHandlers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */