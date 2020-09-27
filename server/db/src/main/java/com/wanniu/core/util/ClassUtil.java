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
/*     */   public static Object getStaticProperty(Class<?> clz, String fieldName) throws Exception {
/*  54 */     Field field = clz.getField(fieldName);
/*  55 */     Object property = field.get(clz);
/*  56 */     return property;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object invokeMethod(Object owner, String methodName, Object... args) throws Exception {
/*  64 */     Class<?> ownerClass = owner.getClass();
/*  65 */     Class[] argsClass = new Class[args.length];
/*  66 */     for (int i = 0, j = args.length; i < j; i++) {
/*  67 */       argsClass[i] = args[i].getClass();
/*     */     }
/*  69 */     Method method = ownerClass.getMethod(methodName, argsClass);
/*  70 */     return method.invoke(owner, args);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object invokeStaticMethod(String className, String methodName, Object... args) throws Exception {
/*  78 */     Class<?> ownerClass = Class.forName(className);
/*  79 */     Class[] argsClass = new Class[args.length];
/*  80 */     for (int i = 0, j = args.length; i < j; i++) {
/*  81 */       argsClass[i] = args[i].getClass();
/*     */     }
/*  83 */     Method method = ownerClass.getMethod(methodName, argsClass);
/*  84 */     return method.invoke(null, args);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object newInstance(String className, Object... args) throws Exception {
/*  91 */     Class<?> newoneClass = Class.forName(className);
/*  92 */     Class[] argsClass = new Class[args.length];
/*  93 */     for (int i = 0, j = args.length; i < j; i++) {
/*  94 */       argsClass[i] = args[i].getClass();
/*     */     }
/*  96 */     Constructor<?> cons = newoneClass.getConstructor(argsClass);
/*  97 */     return cons.newInstance(args);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<Class<?>> getClasses(String packageName) throws ClassNotFoundException, IOException {
/* 106 */     ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
/* 107 */     String path = packageName.replace(".", "/");
/* 108 */     Enumeration<URL> resources = classLoader.getResources(path);
/* 109 */     List<File> dirs = new ArrayList<>();
/* 110 */     while (resources.hasMoreElements()) {
/* 111 */       URL resource = resources.nextElement();
/* 112 */       dirs.add(new File(resource.getFile()));
/*     */     } 
/* 114 */     ArrayList<Class<?>> classes = new ArrayList<>();
/* 115 */     for (File directory : dirs) {
/* 116 */       classes.addAll(findClass(directory, packageName));
/*     */     }
/* 118 */     return classes;
/*     */   }
/*     */   
/*     */   private static List<Class<?>> findClass(File directory, String packageName) throws ClassNotFoundException {
/* 122 */     List<Class<?>> classes = new ArrayList<>();
/* 123 */     if (!directory.exists()) {
/* 124 */       return classes;
/*     */     }
/* 126 */     File[] files = directory.listFiles(); byte b; int i; File[] arrayOfFile1;
/* 127 */     for (i = (arrayOfFile1 = files).length, b = 0; b < i; ) { File file = arrayOfFile1[b];
/* 128 */       if (file.isDirectory()) {
/* 129 */         assert !file.getName().contains(".");
/* 130 */         classes.addAll(findClass(file, String.valueOf(packageName) + "." + file.getName()));
/* 131 */       } else if (file.getName().endsWith(".class")) {
/* 132 */         classes.add(
/* 133 */             Class.forName(String.valueOf(packageName) + "." + file.getName().substring(0, file.getName().length() - 6)));
/*     */       }  b++; }
/*     */     
/* 136 */     return classes;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\cor\\util\ClassUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */