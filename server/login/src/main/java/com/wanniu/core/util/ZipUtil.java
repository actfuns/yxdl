/*     */ package com.wanniu.core.util;
/*     */ 
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
/*     */ import java.net.MalformedURLException;
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
/*     */ public final class ZipUtil
/*     */ {
/*     */   public static final String EXT = ".zip";
/*     */   private static final int BUFFER = 1024;
/*     */   
/*     */   public static void decompress(String srcPath) throws Exception {
/*  44 */     File srcFile = new File(srcPath);
/*  45 */     decompress(srcFile);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void decompress(File srcFile) throws Exception {
/*  55 */     String basePath = srcFile.getParent();
/*  56 */     decompress(srcFile, basePath);
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
/*  67 */     fileProber(destFile);
/*  68 */     CheckedInputStream cis = new CheckedInputStream(new FileInputStream(srcFile), new CRC32());
/*  69 */     ZipInputStream zis = new ZipInputStream(cis);
/*  70 */     decompress(destFile, zis);
/*  71 */     zis.closeEntry();
/*  72 */     zis.close();
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
/*  83 */     decompress(srcFile, new File(destPath));
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
/*  96 */     File srcFile = new File(srcPath);
/*  97 */     decompress(srcFile, destPath);
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
/* 110 */     ZipEntry entry = null;
/* 111 */     while ((entry = zis.getNextEntry()) != null) {
/*     */       
/* 113 */       String dir = String.valueOf(destFile.getPath()) + File.separator + entry.getName();
/* 114 */       File dirFile = new File(dir);
/* 115 */       if (entry.isDirectory()) {
/* 116 */         dirFile.mkdirs(); continue;
/*     */       } 
/* 118 */       decompressFile(dirFile, zis);
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
/* 133 */     File parentFile = dirFile.getParentFile();
/* 134 */     if (!parentFile.exists()) {
/* 135 */       fileProber(parentFile);
/*     */       return;
/*     */     } 
/* 138 */     if (!dirFile.exists()) {
/* 139 */       dirFile.mkdir();
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
/* 153 */     fileProber(destFile.getParentFile());
/* 154 */     BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
/*     */     
/* 156 */     byte[] data = new byte[1024]; int count;
/* 157 */     while ((count = zis.read(data, 0, 1024)) != -1) {
/* 158 */       bos.write(data, 0, count);
/*     */     }
/* 160 */     bos.write(data);
/* 161 */     bos.close();
/*     */   }
/*     */   
/*     */   public static void readZipFile(String zipFile) {
/*     */     try {
/* 166 */       ZipFile zf = new ZipFile(zipFile);
/* 167 */       Enumeration<?> entries = zf.entries();
/*     */       
/* 169 */       while (entries.hasMoreElements()) {
/* 170 */         ZipEntry ze = (ZipEntry)entries.nextElement();
/* 171 */         System.out.println("读取：" + ze.getName());
/* 172 */         long size = ze.getSize();
/* 173 */         if (size > 0L) {
/* 174 */           System.out.println("长度：" + size);
/* 175 */           BufferedReader br = new BufferedReader(new InputStreamReader(
/* 176 */                 zf.getInputStream(ze)));
/* 177 */           StringBuilder context = new StringBuilder();
/* 178 */           while (br.ready()) {
/* 179 */             context.append(br.readLine());
/*     */           }
/* 181 */           System.out.println(context);
/* 182 */           br.close();
/*     */         } 
/*     */       } 
/*     */       
/* 186 */       zf.close();
/* 187 */     } catch (IOException e) {
/* 188 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static List<String> readHttpZip(String sURL) {
/* 193 */     List<String> mapJsons = new ArrayList<>();
/* 194 */     ZipInputStream in = null;
/*     */     try {
/* 196 */       URL url = new URL(sURL);
/* 197 */       HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
/* 198 */       DataInputStream input = new DataInputStream(httpConnection.getInputStream());
/*     */       
/* 200 */       in = new ZipInputStream(input);
/* 201 */       while (in.getNextEntry() != null) {
/* 202 */         BufferedReader br = new BufferedReader(new InputStreamReader(in));
/* 203 */         StringBuilder context = new StringBuilder();
/* 204 */         while (br.ready()) {
/* 205 */           context.append(br.readLine());
/*     */         }
/* 207 */         mapJsons.add(context.toString());
/*     */       } 
/* 209 */     } catch (MalformedURLException e) {
/* 210 */       e.printStackTrace();
/* 211 */     } catch (IOException e) {
/* 212 */       e.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 215 */         if (in != null) {
/* 216 */           in.closeEntry();
/* 217 */           in.close();
/*     */         } 
/* 219 */       } catch (IOException e) {
/* 220 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/* 223 */     return mapJsons;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String compress(String text) throws IOException {
/* 228 */     if (text == null || text.length() == 0) {
/* 229 */       return text;
/*     */     }
/* 231 */     ByteArrayOutputStream out = new ByteArrayOutputStream();
/* 232 */     GZIPOutputStream gzip = new GZIPOutputStream(out);
/* 233 */     gzip.write(text.getBytes());
/* 234 */     gzip.close();
/* 235 */     return out.toString("ISO-8859-1");
/*     */   }
/*     */ 
/*     */   
/*     */   public static String uncompress(String text) throws IOException {
/* 240 */     if (text == null || text.length() == 0) {
/* 241 */       return text;
/*     */     }
/* 243 */     ByteArrayOutputStream out = new ByteArrayOutputStream();
/* 244 */     ByteArrayInputStream in = new ByteArrayInputStream(text.getBytes("ISO-8859-1"));
/* 245 */     GZIPInputStream gunzip = new GZIPInputStream(in);
/* 246 */     byte[] buffer = new byte[256];
/*     */     int n;
/* 248 */     while ((n = gunzip.read(buffer)) >= 0) {
/* 249 */       out.write(buffer, 0, n);
/*     */     }
/* 251 */     return out.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] encode(String text) throws IOException {
/* 256 */     if (text == null || text.length() == 0) {
/* 257 */       return new byte[0];
/*     */     }
/* 259 */     ByteArrayOutputStream out = new ByteArrayOutputStream();
/* 260 */     GZIPOutputStream gzip = new GZIPOutputStream(out);
/* 261 */     gzip.write(text.getBytes());
/* 262 */     gzip.close();
/* 263 */     return out.toByteArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String decode(byte[] bytes) throws IOException {
/* 268 */     if (bytes == null || bytes.length == 0) {
/* 269 */       return null;
/*     */     }
/* 271 */     ByteArrayOutputStream out = new ByteArrayOutputStream();
/* 272 */     ByteArrayInputStream in = new ByteArrayInputStream(bytes);
/* 273 */     GZIPInputStream gunzip = new GZIPInputStream(in);
/* 274 */     byte[] buffer = new byte[256];
/*     */     int n;
/* 276 */     while ((n = gunzip.read(buffer)) >= 0) {
/* 277 */       out.write(buffer, 0, n);
/*     */     }
/* 279 */     return out.toString();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\cor\\util\ZipUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */