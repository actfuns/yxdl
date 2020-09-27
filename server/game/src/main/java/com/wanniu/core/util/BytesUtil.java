/*     */ package com.wanniu.core.util;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
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
/*     */ 
/*     */ public final class BytesUtil
/*     */ {
/*     */   public static long bytes2long(byte[] bytes) {
/*  27 */     return (bytes[7] & 0xFF | (bytes[6] & 0xFF) << 8 | (bytes[5] & 0xFF) << 16 | (bytes[4] & 0xFF) << 24 | (bytes[3] & 0xFF) << 32 | (bytes[2] & 0xFF) << 40 | (bytes[1] & 0xFF) << 48 | (bytes[0] & 0xFF) << 56);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] long2bytes(long n) {
/*  38 */     byte[] bytes = new byte[8];
/*     */     
/*  40 */     bytes[7] = (byte)(int)(n & 0xFFL);
/*  41 */     bytes[6] = (byte)(int)(n >> 8L & 0xFFL);
/*  42 */     bytes[5] = (byte)(int)(n >> 16L & 0xFFL);
/*  43 */     bytes[4] = (byte)(int)(n >> 24L & 0xFFL);
/*  44 */     bytes[3] = (byte)(int)(n >> 32L & 0xFFL);
/*  45 */     bytes[2] = (byte)(int)(n >> 40L & 0xFFL);
/*  46 */     bytes[1] = (byte)(int)(n >> 48L & 0xFFL);
/*  47 */     bytes[0] = (byte)(int)(n >> 56L & 0xFFL);
/*     */     
/*  49 */     return bytes;
/*     */   }
/*     */   
/*     */   public static int bytes2int(byte[] bytes) {
/*  53 */     return bytes[3] & 0xFF | (bytes[2] & 0xFF) << 8 | (bytes[1] & 0xFF) << 16 | (bytes[0] & 0xFF) << 24;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] int2bytes(int n) {
/*  60 */     byte[] bytes = new byte[4];
/*     */     
/*  62 */     bytes[3] = (byte)(n & 0xFF);
/*  63 */     bytes[2] = (byte)(n >> 8 & 0xFF);
/*  64 */     bytes[1] = (byte)(n >> 16 & 0xFF);
/*  65 */     bytes[0] = (byte)(n >> 24 & 0xFF);
/*     */     
/*  67 */     return bytes;
/*     */   }
/*     */   
/*     */   public static short bytes2short(byte[] bytes) {
/*  71 */     return (short)(bytes[1] & 0xFF | (bytes[0] & 0xFF) << 8);
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] short2bytes(short n) {
/*  76 */     return new byte[] { (byte)(n >>> 8 & 0xFF), (byte)(n & 0xFF) };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] short2bytes(int n) {
/*  82 */     return new byte[] { (byte)(n >>> 8 & 0xFF), (byte)(n & 0xFF) };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] short2bytes(long n) {
/*  88 */     return new byte[] { (byte)(int)(n >>> 8L & 0xFFL), (byte)(int)(n & 0xFFL) };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] object2bytes(Serializable obj) {
/*  94 */     byte[] bytes = null;
/*     */     try {
/*  96 */       ByteArrayOutputStream bo = new ByteArrayOutputStream(512);
/*  97 */       ObjectOutputStream oo = new ObjectOutputStream(bo);
/*  98 */       oo.writeObject(obj);
/*     */       
/* 100 */       bytes = bo.toByteArray();
/*     */       
/* 102 */       bo.close();
/* 103 */       oo.close();
/* 104 */     } catch (Exception e) {
/* 105 */       Out.error(new Object[] { "BytesUtil object2bytes", e });
/*     */     } 
/* 107 */     return bytes;
/*     */   }
/*     */   
/*     */   public static <T extends Serializable> T bytes2object(byte[] bytes) {
/*     */     Serializable serializable;
/* 112 */     T t = null;
/*     */     try {
/* 114 */       ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
/* 115 */       ObjectInputStream oi = new ObjectInputStream(bi);
/* 116 */       serializable = (Serializable)oi.readObject();
/* 117 */       bi.close();
/* 118 */       oi.close();
/* 119 */     } catch (Exception e) {
/* 120 */       Out.error(new Object[] { "BytesUtil bytes2object", e });
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
/* 152 */         Out.error(new Object[] { "BytesUtil zip", e });
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
/* 186 */         Out.error(new Object[] { "BytesUtil unZip", e });
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
/* 201 */         Out.error(new Object[] { "BytesUtil clean", e });
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


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\BytesUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */