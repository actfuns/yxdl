/*     */ package com.wanniu.core.util;
/*     */ 
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.file.Files;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
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
/*     */ public class FileUtil
/*     */ {
/*     */   public static List<String> readLines(String filename) {
/*  44 */     File file = new File(filename);
/*  45 */     return readLines(file);
/*     */   }
/*     */   
/*     */   public static void eachLine(String file, FileReader cloure) {
/*  49 */     eachLine(new File(file), cloure);
/*     */   }
/*     */   
/*     */   public static void eachLine(File file, FileReader cloure) {
/*  53 */     BufferedReader bufferReader = null;
/*  54 */     InputStreamReader reader = null;
/*  55 */     if (file.exists()) {
/*     */       try {
/*  57 */         reader = new InputStreamReader(new FileInputStream(file), GGlobal.UTF_8);
/*  58 */         bufferReader = new BufferedReader(reader);
/*  59 */         String line = null;
/*  60 */         while ((line = bufferReader.readLine()) != null) {
/*  61 */           cloure.read(line);
/*     */         }
/*  63 */       } catch (Exception e) {
/*  64 */         Out.error(new Object[] { "FileUtil eachLine", e });
/*     */       } finally {
/*     */         try {
/*  67 */           if (reader != null) {
/*  68 */             reader.close();
/*     */           }
/*  70 */         } catch (IOException e) {
/*  71 */           Out.error(new Object[] { "FileUtil eachLine", e });
/*     */         } 
/*     */         try {
/*  74 */           if (bufferReader != null) {
/*  75 */             bufferReader.close();
/*     */           }
/*  77 */         } catch (IOException e) {
/*  78 */           Out.error(new Object[] { "FileUtil eachLine", e });
/*     */         } 
/*     */       } 
/*     */     } else {
/*  82 */       Out.error(new Object[] { "FileUtil eachLine", String.format("Not found %s!", new Object[] { file.getAbsolutePath() }) });
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String checkLine(String file, FileChecker cloure) {
/*  87 */     return checkLine(new File(file), cloure);
/*     */   }
/*     */   
/*     */   public static String checkLine(File file, FileChecker cloure) {
/*  91 */     BufferedReader bufferReader = null;
/*  92 */     InputStreamReader reader = null;
/*  93 */     if (file.exists()) {
/*     */       try {
/*  95 */         reader = new InputStreamReader(new FileInputStream(file), GGlobal.UTF_8);
/*  96 */         bufferReader = new BufferedReader(reader);
/*  97 */         String line = null;
/*  98 */         while ((line = bufferReader.readLine()) != null) {
/*  99 */           if (cloure.check(line)) {
/* 100 */             return line;
/*     */           }
/*     */         } 
/* 103 */       } catch (Exception e) {
/* 104 */         Out.error(new Object[] { "FileUtil checkLine", e });
/*     */       } finally {
/*     */         try {
/* 107 */           if (reader != null) {
/* 108 */             reader.close();
/*     */           }
/* 110 */         } catch (IOException e) {
/* 111 */           Out.error(new Object[] { "FileUtil checkLine", e });
/*     */         } 
/*     */         try {
/* 114 */           if (bufferReader != null) {
/* 115 */             bufferReader.close();
/*     */           }
/* 117 */         } catch (IOException e) {
/* 118 */           Out.error(new Object[] { "FileUtil checkLine", e });
/*     */         } 
/*     */       } 
/*     */     } else {
/* 122 */       Out.error(new Object[] { "FileUtil checkLine", String.format("Not found %s!", new Object[] { file.getAbsolutePath() }) });
/*     */     } 
/* 124 */     return null;
/*     */   }
/*     */   
/*     */   public static List<String> readLines(File file) {
/* 128 */     final List<String> lines = new ArrayList<>();
/* 129 */     eachLine(file, new FileReader()
/*     */         {
/*     */           public void read(String line) {
/* 132 */             lines.add(line);
/*     */           }
/*     */         });
/* 135 */     return lines;
/*     */   }
/*     */   
/*     */   public static String readText(File file) {
/* 139 */     final StringBuilder lines = new StringBuilder();
/* 140 */     eachLine(file, new FileReader()
/*     */         {
/*     */           public void read(String line) {
/* 143 */             lines.append(line).append('\n');
/*     */           }
/*     */         });
/* 146 */     return lines.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean copy(String src, String dest) {
/* 157 */     File srcFile = new File(src);
/* 158 */     if (!srcFile.exists() || !srcFile.isFile() || !srcFile.canRead()) {
/* 159 */       return false;
/*     */     }
/* 161 */     File destFile = new File(dest);
/* 162 */     if (destFile.exists()) {
/* 163 */       destFile.delete();
/*     */     }
/*     */     
/* 166 */     BufferedInputStream bis = null;
/* 167 */     BufferedOutputStream bos = null;
/*     */     try {
/* 169 */       bis = new BufferedInputStream(new FileInputStream(srcFile));
/* 170 */       bos = new BufferedOutputStream(new FileOutputStream(destFile));
/* 171 */       byte[] buf = new byte[1024];
/* 172 */       int len = 0;
/* 173 */       while ((len = bis.read(buf)) != -1) {
/* 174 */         bos.write(buf, 0, len);
/*     */       }
/*     */       
/* 177 */       return true;
/* 178 */     } catch (FileNotFoundException e) {
/* 179 */       Out.error(new Object[] { "FileUtil copy", e });
/* 180 */     } catch (IOException e) {
/* 181 */       Out.error(new Object[] { "FileUtil copy", e });
/*     */     } finally {
/* 183 */       if (bos != null) {
/*     */         try {
/* 185 */           bos.close();
/* 186 */         } catch (IOException iOException) {}
/*     */       }
/* 188 */       if (bis != null) {
/*     */         try {
/* 190 */           bis.close();
/* 191 */         } catch (IOException iOException) {}
/*     */       }
/*     */     } 
/*     */     
/* 195 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean clear(File file) {
/*     */     try {
/* 207 */       PrintWriter writer = new PrintWriter(new FileWriter(file, false));
/* 208 */       writer.close();
/* 209 */     } catch (IOException e) {
/* 210 */       Out.error(new Object[] { "FileUtil clear", e });
/* 211 */       return false;
/*     */     } 
/* 213 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] file2bytes(File file) {
/* 220 */     BufferedInputStream in = null;
/*     */     try {
/* 222 */       in = new BufferedInputStream(new FileInputStream(file));
/* 223 */       ByteArrayOutputStream out = new ByteArrayOutputStream(in.available());
/* 224 */       byte[] temp = new byte[1024];
/* 225 */       int size = 0;
/* 226 */       while ((size = in.read(temp)) != -1) {
/* 227 */         out.write(temp, 0, size);
/*     */       }
/* 229 */       return out.toByteArray();
/* 230 */     } catch (Exception e) {
/* 231 */       Out.error(new Object[] { "FileUtil file2bytes", e });
/*     */     } finally {
/* 233 */       if (in != null) {
/*     */         try {
/* 235 */           in.close();
/* 236 */         } catch (IOException e) {
/* 237 */           Out.error(new Object[] { "FileUtil file2bytes", e });
/*     */         } 
/*     */       }
/*     */     } 
/* 241 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void copyNio(File from, File to) throws IOException {
/* 248 */     RandomAccessFile inFile = new RandomAccessFile(from, "r");
/*     */     try {
/* 250 */       RandomAccessFile outFile = new RandomAccessFile(to, "rw");
/*     */       try {
/* 252 */         FileChannel inChannel = inFile.getChannel();
/* 253 */         FileChannel outChannel = outFile.getChannel();
/* 254 */         long pos = 0L;
/* 255 */         long toCopy = inFile.length();
/* 256 */         while (toCopy > 0L) {
/* 257 */           long bytes = inChannel.transferTo(pos, toCopy, outChannel);
/* 258 */           pos += bytes;
/* 259 */           toCopy -= bytes;
/*     */         } 
/*     */       } finally {
/* 262 */         outFile.close();
/*     */       } 
/*     */     } finally {
/* 265 */       inFile.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void write(File file, Collection<String> lines) {
/*     */     try {
/* 274 */       PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file, false), GGlobal.UTF_8), true);
/* 275 */       for (String key : lines) {
/* 276 */         writer.println(key);
/*     */       }
/* 278 */       writer.close();
/* 279 */       writer = null;
/* 280 */     } catch (Exception e) {
/* 281 */       Out.error(new Object[] { "FileUtil write", e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void write(File file, String content) {
/*     */     try {
/* 290 */       if (file.exists()) {
/* 291 */         byte[] text = Files.readAllBytes(file.toPath());
/* 292 */         byte[] newText = content.getBytes("UTF-8");
/*     */         
/* 294 */         boolean same = true;
/* 295 */         if (text.length == newText.length) {
/* 296 */           for (int i = 0; i < text.length; i++) {
/* 297 */             if (text[i] != newText[i]) {
/* 298 */               same = false;
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } else {
/* 303 */           same = false;
/*     */         } 
/*     */         
/* 306 */         if (!same) {
/* 307 */           Files.write(file.toPath(), newText, new java.nio.file.OpenOption[0]);
/*     */         } else {
/* 309 */           Out.info(new Object[] { "检查未变更，忽略生成", file.getName() });
/*     */         } 
/*     */       } else {
/* 312 */         Files.write(file.toPath(), content.getBytes("UTF-8"), new java.nio.file.OpenOption[0]);
/*     */       } 
/* 314 */     } catch (IOException e) {
/* 315 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static interface FileReader {
/*     */     void read(String param1String);
/*     */   }
/*     */   
/*     */   public static interface FileChecker {
/*     */     boolean check(String param1String);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\FileUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */