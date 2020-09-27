/*     */ package com.wanniu.core.util;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.List;
/*     */ import java.util.zip.CRC32;
/*     */ import java.util.zip.CheckedInputStream;
/*     */ import java.util.zip.GZIPInputStream;
/*     */ import java.util.zip.GZIPOutputStream;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipFile;
/*     */ import java.util.zip.ZipInputStream;
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
/*     */ public final class ZipUtil
/*     */ {
/*     */   public static final String EXT = ".zip";
/*     */   private static final int BUFFER = 1024;
/*     */   
/*     */   public static void decompress(String srcPath) throws Exception {
/*  45 */     File srcFile = new File(srcPath);
/*  46 */     decompress(srcFile);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void decompress(File srcFile) throws Exception {
/*  56 */     String basePath = srcFile.getParent();
/*  57 */     decompress(srcFile, basePath);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void decompress(File srcFile, File destFile) throws Exception {
/*  68 */     fileProber(destFile);
/*  69 */     CheckedInputStream cis = new CheckedInputStream(new FileInputStream(srcFile), new CRC32());
/*  70 */     ZipInputStream zis = new ZipInputStream(cis);
/*  71 */     decompress(destFile, zis);
/*  72 */     zis.closeEntry();
/*  73 */     zis.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void decompress(File srcFile, String destPath) throws Exception {
/*  84 */     decompress(srcFile, new File(destPath));
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
/*     */   public static void decompress(String srcPath, String destPath) throws Exception {
/*  97 */     File srcFile = new File(srcPath);
/*  98 */     decompress(srcFile, destPath);
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
/*     */   private static void decompress(File destFile, ZipInputStream zis) throws Exception {
/* 111 */     ZipEntry entry = null;
/* 112 */     while ((entry = zis.getNextEntry()) != null) {
/*     */       
/* 114 */       String dir = destFile.getPath() + File.separator + entry.getName();
/* 115 */       File dirFile = new File(dir);
/* 116 */       if (entry.isDirectory()) {
/* 117 */         dirFile.mkdirs(); continue;
/*     */       } 
/* 119 */       decompressFile(dirFile, zis);
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
/*     */ 
/*     */   
/*     */   private static void fileProber(File dirFile) {
/* 134 */     File parentFile = dirFile.getParentFile();
/* 135 */     if (!parentFile.exists()) {
/* 136 */       fileProber(parentFile);
/*     */       return;
/*     */     } 
/* 139 */     if (!dirFile.exists()) {
/* 140 */       dirFile.mkdir();
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
/*     */   
/*     */   private static void decompressFile(File destFile, ZipInputStream zis) throws Exception {
/* 154 */     fileProber(destFile.getParentFile());
/* 155 */     BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
/*     */     
/* 157 */     byte[] data = new byte[1024]; int count;
/* 158 */     while ((count = zis.read(data, 0, 1024)) != -1) {
/* 159 */       bos.write(data, 0, count);
/*     */     }
/* 161 */     bos.write(data);
/* 162 */     bos.close();
/*     */   }
/*     */   
/*     */   public static void readZipFile(String zipFile) {
/*     */     try {
/* 167 */       ZipFile zf = new ZipFile(zipFile);
/* 168 */       Enumeration<?> entries = zf.entries();
/*     */       
/* 170 */       while (entries.hasMoreElements()) {
/* 171 */         ZipEntry ze = (ZipEntry)entries.nextElement();
/* 172 */         System.out.println("读取：" + ze.getName());
/* 173 */         long size = ze.getSize();
/* 174 */         if (size > 0L) {
/* 175 */           System.out.println("长度：" + size);
/*     */           
/* 177 */           BufferedReader br = new BufferedReader(new InputStreamReader(zf.getInputStream(ze)));
/* 178 */           StringBuilder context = new StringBuilder();
/* 179 */           while (br.ready()) {
/* 180 */             context.append(br.readLine());
/*     */           }
/* 182 */           System.out.println(context);
/* 183 */           br.close();
/*     */         } 
/*     */       } 
/*     */       
/* 187 */       zf.close();
/* 188 */     } catch (IOException e) {
/* 189 */       Out.error(new Object[] { "ZipUtil readZipFile", e });
/*     */     } 
/*     */   }
/*     */   
/*     */   public static List<String> readHttpZip(String sURL) {
/* 194 */     List<String> mapJsons = new ArrayList<>();
/* 195 */     ZipInputStream in = null;
/*     */     try {
/* 197 */       URL url = new URL(sURL);
/* 198 */       HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
/* 199 */       DataInputStream input = new DataInputStream(httpConnection.getInputStream());
/*     */       
/* 201 */       in = new ZipInputStream(input);
/* 202 */       while (in.getNextEntry() != null) {
/* 203 */         BufferedReader br = new BufferedReader(new InputStreamReader(in));
/* 204 */         StringBuilder context = new StringBuilder();
/* 205 */         while (br.ready()) {
/* 206 */           context.append(br.readLine());
/*     */         }
/* 208 */         mapJsons.add(context.toString());
/*     */       } 
/* 210 */     } catch (Exception e) {
/* 211 */       Out.error(new Object[] { "ZipUtil readHttpZip", e });
/*     */     } finally {
/*     */       try {
/* 214 */         if (in != null) {
/* 215 */           in.closeEntry();
/* 216 */           in.close();
/*     */         } 
/* 218 */       } catch (IOException e) {
/* 219 */         Out.error(new Object[] { "ZipUtil readHttpZip", e });
/*     */       } 
/*     */     } 
/* 222 */     return mapJsons;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String compress(String text) throws IOException {
/* 227 */     if (text == null || text.length() == 0) {
/* 228 */       return text;
/*     */     }
/* 230 */     ByteArrayOutputStream out = new ByteArrayOutputStream();
/* 231 */     GZIPOutputStream gzip = new GZIPOutputStream(out);
/* 232 */     gzip.write(text.getBytes());
/* 233 */     gzip.close();
/* 234 */     return out.toString("ISO-8859-1");
/*     */   }
/*     */ 
/*     */   
/*     */   public static String uncompress(String text) throws IOException {
/* 239 */     if (text == null || text.length() == 0) {
/* 240 */       return text;
/*     */     }
/* 242 */     ByteArrayOutputStream out = new ByteArrayOutputStream();
/* 243 */     ByteArrayInputStream in = new ByteArrayInputStream(text.getBytes("ISO-8859-1"));
/* 244 */     GZIPInputStream gunzip = new GZIPInputStream(in);
/* 245 */     byte[] buffer = new byte[256];
/*     */     int n;
/* 247 */     while ((n = gunzip.read(buffer)) >= 0) {
/* 248 */       out.write(buffer, 0, n);
/*     */     }
/* 250 */     return out.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] encode(String text) throws IOException {
/* 255 */     if (text == null || text.length() == 0) {
/* 256 */       return new byte[0];
/*     */     }
/* 258 */     ByteArrayOutputStream out = new ByteArrayOutputStream();
/* 259 */     GZIPOutputStream gzip = new GZIPOutputStream(out);
/* 260 */     gzip.write(text.getBytes());
/* 261 */     gzip.close();
/* 262 */     return out.toByteArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String decode(byte[] bytes) throws IOException {
/* 267 */     if (bytes == null || bytes.length == 0) {
/* 268 */       return null;
/*     */     }
/* 270 */     ByteArrayOutputStream out = new ByteArrayOutputStream();
/* 271 */     ByteArrayInputStream in = new ByteArrayInputStream(bytes);
/* 272 */     GZIPInputStream gunzip = new GZIPInputStream(in);
/* 273 */     byte[] buffer = new byte[256];
/*     */     int n;
/* 275 */     while ((n = gunzip.read(buffer)) >= 0) {
/* 276 */       out.write(buffer, 0, n);
/*     */     }
/* 278 */     return out.toString();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\ZipUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */