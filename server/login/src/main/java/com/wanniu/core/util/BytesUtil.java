/*     */ package com.wanniu.core.util;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Method;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipInputStream;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class BytesUtil
/*     */ {
/*     */   public static long bytes2long(byte[] bytes) {
/*  25 */     return (bytes[7] & 0xFF | (
/*  26 */       bytes[6] & 0xFF) << 8 | (
/*  27 */       bytes[5] & 0xFF) << 16 | (
/*  28 */       bytes[4] & 0xFF) << 24 | (
/*  29 */       bytes[3] & 0xFF) << 32 | (
/*  30 */       bytes[2] & 0xFF) << 40 | (
/*  31 */       bytes[1] & 0xFF) << 48 | (
/*  32 */       bytes[0] & 0xFF) << 56);
/*     */   }
/*     */   
/*     */   public static byte[] long2bytes(long n) {
/*  36 */     byte[] bytes = new byte[8];
/*     */     
/*  38 */     bytes[7] = (byte)(int)(n & 0xFFL);
/*  39 */     bytes[6] = (byte)(int)(n >> 8L & 0xFFL);
/*  40 */     bytes[5] = (byte)(int)(n >> 16L & 0xFFL);
/*  41 */     bytes[4] = (byte)(int)(n >> 24L & 0xFFL);
/*  42 */     bytes[3] = (byte)(int)(n >> 32L & 0xFFL);
/*  43 */     bytes[2] = (byte)(int)(n >> 40L & 0xFFL);
/*  44 */     bytes[1] = (byte)(int)(n >> 48L & 0xFFL);
/*  45 */     bytes[0] = (byte)(int)(n >> 56L & 0xFFL);
/*     */     
/*  47 */     return bytes;
/*     */   }
/*     */   
/*     */   public static int bytes2int(byte[] bytes) {
/*  51 */     return bytes[3] & 0xFF | (
/*  52 */       bytes[2] & 0xFF) << 8 | (
/*  53 */       bytes[1] & 0xFF) << 16 | (
/*  54 */       bytes[0] & 0xFF) << 24;
/*     */   }
/*     */   
/*     */   public static byte[] int2bytes(int n) {
/*  58 */     byte[] bytes = new byte[4];
/*     */     
/*  60 */     bytes[3] = (byte)(n & 0xFF);
/*  61 */     bytes[2] = (byte)(n >> 8 & 0xFF);
/*  62 */     bytes[1] = (byte)(n >> 16 & 0xFF);
/*  63 */     bytes[0] = (byte)(n >> 24 & 0xFF);
/*     */     
/*  65 */     return bytes;
/*     */   }
/*     */   
/*     */   public static short bytes2short(byte[] bytes) {
/*  69 */     return (short)(bytes[1] & 0xFF | (
/*  70 */       bytes[0] & 0xFF) << 8);
/*     */   }
/*     */   
/*     */   public static byte[] short2bytes(short n) {
/*  74 */     return new byte[] {
/*  75 */         (byte)(n >>> 8 & 0xFF), 
/*  76 */         (byte)(n & 0xFF) };
/*     */   }
/*     */   
/*     */   public static byte[] short2bytes(int n) {
/*  80 */     return new byte[] {
/*  81 */         (byte)(n >>> 8 & 0xFF), 
/*  82 */         (byte)(n & 0xFF) };
/*     */   }
/*     */   
/*     */   public static byte[] short2bytes(long n) {
/*  86 */     return new byte[] {
/*  87 */         (byte)(int)(n >>> 8L & 0xFFL), 
/*  88 */         (byte)(int)(n & 0xFFL) };
/*     */   }
/*     */   
/*     */   public static byte[] object2bytes(Serializable obj) {
/*  92 */     byte[] bytes = null;
/*     */     try {
/*  94 */       ByteArrayOutputStream bo = new ByteArrayOutputStream(512);
/*  95 */       ObjectOutputStream oo = new ObjectOutputStream(bo);
/*  96 */       oo.writeObject(obj);
/*     */       
/*  98 */       bytes = bo.toByteArray();
/*     */       
/* 100 */       bo.close();
/* 101 */       oo.close();
/* 102 */     } catch (Exception e) {
/* 103 */       System.out.println("object2bytes:" + e.getMessage());
/* 104 */       e.printStackTrace();
/*     */     } 
/* 106 */     return bytes;
/*     */   }
/*     */   
/*     */   public static <T extends Serializable> T bytes2object(byte[] bytes) {
/*     */     Serializable serializable;
/* 111 */     T t = null;
/*     */     try {
/* 113 */       ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
/* 114 */       ObjectInputStream oi = new ObjectInputStream(bi);
/* 115 */       serializable = (Serializable)oi.readObject();
/* 116 */       bi.close();
/* 117 */       oi.close();
/* 118 */     } catch (Exception e) {
/* 119 */       System.out.println("bytes2object:" + e.getMessage());
/* 120 */       e.printStackTrace();
/*     */     } 
/* 122 */     return (T)serializable;
/*     */   }
/*     */   
/*     */   public static String bytes2String(byte[] bytes) {
/* 126 */     return new String(bytes, Charset.defaultCharset());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] zip(byte[] data) {
/* 133 */     byte[] b = null;
/* 134 */     ByteArrayOutputStream bos = null;
/* 135 */     ZipOutputStream zip = null;
/*     */     try {
/* 137 */       bos = new ByteArrayOutputStream();
/* 138 */       zip = new ZipOutputStream(bos);
/* 139 */       ZipEntry entry = new ZipEntry("zip");
/* 140 */       entry.setSize(data.length);
/* 141 */       zip.putNextEntry(entry);
/* 142 */       zip.write(data);
/* 143 */       zip.closeEntry();
/* 144 */       b = bos.toByteArray();
/* 145 */     } catch (Exception ex) {
/* 146 */       ex.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 149 */         if (zip != null) zip.close(); 
/* 150 */         if (bos != null) bos.close(); 
/* 151 */       } catch (IOException e) {
/* 152 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/* 155 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] unZip(byte[] data) {
/* 162 */     byte[] b = null;
/* 163 */     ByteArrayInputStream bis = null;
/* 164 */     ZipInputStream zip = null;
/*     */     try {
/* 166 */       bis = new ByteArrayInputStream(data);
/* 167 */       zip = new ZipInputStream(bis);
/* 168 */       while (zip.getNextEntry() != null) {
/* 169 */         byte[] buf = new byte[1024];
/* 170 */         int num = -1;
/* 171 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 172 */         while ((num = zip.read(buf, 0, buf.length)) != -1) {
/* 173 */           baos.write(buf, 0, num);
/*     */         }
/* 175 */         b = baos.toByteArray();
/* 176 */         baos.flush();
/* 177 */         baos.close();
/*     */       } 
/* 179 */     } catch (Exception ex) {
/* 180 */       ex.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 183 */         if (zip != null) zip.close(); 
/* 184 */         if (bis != null) bis.close(); 
/* 185 */       } catch (IOException e) {
/* 186 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/* 189 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clean(ByteBuffer byteBuffer) {
/* 196 */     if (byteBuffer.isDirect()) {
/*     */       try {
/* 198 */         Object cleaner = invoke(byteBuffer, "cleaner");
/* 199 */         invoke(cleaner, "clean");
/* 200 */       } catch (Exception e) {
/* 201 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static Object invoke(final Object target, String methodName) throws Exception {
/* 207 */     final Method method = target.getClass().getMethod(methodName, new Class[0]);
/* 208 */     return AccessController.doPrivileged(new PrivilegedAction() {
/*     */           public Object run() {
/*     */             try {
/* 211 */               method.setAccessible(true);
/* 212 */               return method.invoke(target, new Object[0]);
/* 213 */             } catch (Exception e) {
/* 214 */               throw new RuntimeException(e);
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\cor\\util\BytesUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */