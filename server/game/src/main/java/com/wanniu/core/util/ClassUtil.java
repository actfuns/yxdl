/*     */ package com.wanniu.core.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClassUtil
/*     */ {
/*     */   public static Field getDeclaredField(Object object, String fieldName) {
/*  20 */     Field field = null;
/*  21 */     for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
/*     */       try {
/*  23 */         field = clazz.getDeclaredField(fieldName);
/*  24 */         return field;
/*  25 */       } catch (Exception exception) {}
/*     */     } 
/*     */     
/*  28 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object getProperty(Object owner, String fieldName) throws Exception {
/*  35 */     Field field = getDeclaredField(owner, fieldName);
/*  36 */     field.setAccessible(true);
/*  37 */     Object property = field.get(owner);
/*  38 */     return property;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setProperty(Object owner, String fieldName, Object value) throws Exception {
/*  45 */     Field field = getDeclaredField(owner, fieldName);
/*  46 */     field.setAccessible(true);
/*  47 */     field.set(owner, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object getStaticProperty(Class<?> clz, String fieldName) throws Exception {
/*  56 */     Field field = clz.getField(fieldName);
/*  57 */     Object property = field.get(clz);
/*  58 */     return property;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object invokeMethod(Object owner, String methodName, Object... args) throws Exception {
/*  66 */     Class<?> ownerClass = owner.getClass();
/*  67 */     Class<?>[] argsClass = new Class[args.length];
/*  68 */     for (int i = 0, j = args.length; i < j; i++) {
/*  69 */       argsClass[i] = args[i].getClass();
/*     */     }
/*  71 */     Method method = ownerClass.getMethod(methodName, argsClass);
/*  72 */     return method.invoke(owner, args);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object invokeStaticMethod(String className, String methodName, Object... args) throws Exception {
/*  80 */     Class<?> ownerClass = Class.forName(className);
/*  81 */     Class<?>[] argsClass = new Class[args.length];
/*  82 */     for (int i = 0, j = args.length; i < j; i++) {
/*  83 */       argsClass[i] = args[i].getClass();
/*     */     }
/*  85 */     Method method = ownerClass.getMethod(methodName, argsClass);
/*  86 */     return method.invoke(null, args);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object newInstance(String className, Object... args) throws Exception {
/*  93 */     Class<?> newoneClass = Class.forName(className);
/*  94 */     Class<?>[] argsClass = new Class[args.length];
/*  95 */     for (int i = 0, j = args.length; i < j; i++) {
/*  96 */       argsClass[i] = args[i].getClass();
/*     */     }
/*  98 */     Constructor<?> cons = newoneClass.getConstructor(argsClass);
/*  99 */     return cons.newInstance(args);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<Class<?>> getClasses(String packageName) throws ClassNotFoundException, IOException {
/* 108 */     ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
/* 109 */     String path = packageName.replace(".", "/");
/* 110 */     Enumeration<URL> resources = classLoader.getResources(path);
/* 111 */     List<File> dirs = new ArrayList<>();
/* 112 */     while (resources.hasMoreElements()) {
/* 113 */       URL resource = resources.nextElement();
/* 114 */       dirs.add(new File(resource.getFile()));
/*     */     } 
/* 116 */     ArrayList<Class<?>> classes = new ArrayList<>();
/* 117 */     for (File directory : dirs) {
/* 118 */       classes.addAll(findClass(directory, packageName));
/*     */     }
/* 120 */     return classes;
/*     */   }
/*     */   
/*     */   private static List<Class<?>> findClass(File directory, String packageName) throws ClassNotFoundException {
/* 124 */     List<Class<?>> classes = new ArrayList<>();
/* 125 */     if (!directory.exists()) {
/* 126 */       return classes;
/*     */     }
/* 128 */     File[] files = directory.listFiles();
/* 129 */     for (File file : files) {
/* 130 */       if (file.isDirectory()) {
/* 131 */         assert !file.getName().contains(".");
/* 132 */         classes.addAll(findClass(file, packageName + "." + file.getName()));
/* 133 */       } else if (file.getName().endsWith(".class")) {
/* 134 */         classes.add(
/* 135 */             Class.forName(packageName + "." + file.getName().substring(0, file.getName().length() - 6)));
/*     */       } 
/*     */     } 
/* 138 */     return classes;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\ClassUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */