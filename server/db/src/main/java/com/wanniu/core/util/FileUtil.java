/*     */ package com.wanniu.core.util;
/*     */ 
/*     */ import com.wanniu.core.GGlobal;
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
/*     */ public class FileUtil
/*     */ {
/*     */   public static List<String> readLines(String filename) {
/*  41 */     File file = new File(filename);
/*  42 */     return readLines(file);
/*     */   }
/*     */   
/*     */   public static void eachLine(String file, FileReader cloure) {
/*  46 */     eachLine(new File(file), cloure);
/*     */   }
/*     */   
/*     */   public static void eachLine(File file, FileReader cloure) {
/*  50 */     BufferedReader bufferReader = null;
/*  51 */     InputStreamReader reader = null;
/*  52 */     if (file.exists()) {
/*     */       try {
/*  54 */         reader = new InputStreamReader(new FileInputStream(file), GGlobal.UTF_8);
/*  55 */         bufferReader = new BufferedReader(reader);
/*  56 */         String line = null;
/*  57 */         while ((line = bufferReader.readLine()) != null) {
/*  58 */           cloure.read(line);
/*     */         }
/*  60 */       } catch (Exception e) {
/*  61 */         e.printStackTrace();
/*     */       } finally {
/*     */         try {
/*  64 */           if (reader != null) {
/*  65 */             reader.close();
/*     */           }
/*  67 */         } catch (IOException e) {
/*  68 */           e.printStackTrace();
/*     */         } 
/*     */         try {
/*  71 */           if (bufferReader != null) {
/*  72 */             bufferReader.close();
/*     */           }
/*  74 */         } catch (IOException e) {
/*  75 */           e.printStackTrace();
/*     */         } 
/*     */       } 
/*     */     } else {
/*  79 */       System.err.println(String.format("Not found %s!", new Object[] { file.getAbsolutePath() }));
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String checkLine(String file, FileChecker cloure) {
/*  84 */     return checkLine(new File(file), cloure);
/*     */   }
/*     */   
/*     */   public static String checkLine(File file, FileChecker cloure) {
/*  88 */     BufferedReader bufferReader = null;
/*  89 */     InputStreamReader reader = null;
/*  90 */     if (file.exists()) {
/*     */       
/*  92 */       try { reader = new InputStreamReader(new FileInputStream(file), GGlobal.UTF_8);
/*  93 */         bufferReader = new BufferedReader(reader);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */          }
/*     */       
/* 100 */       catch (Exception e)
/* 101 */       { e.printStackTrace(); }
/*     */       finally
/*     */       { try {
/* 104 */           if (reader != null) {
/* 105 */             reader.close();
/*     */           }
/* 107 */         } catch (IOException e) {
/* 108 */           e.printStackTrace();
/*     */         } 
/*     */         
/* 111 */         try { if (bufferReader != null) {
/* 112 */             bufferReader.close();
/*     */           } }
/* 114 */         catch (IOException e)
/* 115 */         { e.printStackTrace(); }  }  try { if (reader != null) reader.close();  } catch (IOException e) { e.printStackTrace(); }  try { if (bufferReader != null) bufferReader.close();  } catch (IOException e) { e.printStackTrace(); }
/*     */     
/*     */     } else {
/*     */       
/* 119 */       System.err.println(String.format("Not found %s!", new Object[] { file.getAbsolutePath() }));
/*     */     } 
/* 121 */     return null;
/*     */   }
/*     */   
/*     */   public static List<String> readLines(File file) {
/* 125 */     final List<String> lines = new ArrayList<>();
/* 126 */     eachLine(file, new FileReader()
/*     */         {
/*     */           public void read(String line) {
/* 129 */             lines.add(line);
/*     */           }
/*     */         });
/* 132 */     return lines;
/*     */   }
/*     */   
/*     */   public static String readText(File file) {
/* 136 */     final StringBuilder lines = new StringBuilder();
/* 137 */     eachLine(file, new FileReader()
/*     */         {
/*     */           public void read(String line) {
/* 140 */             lines.append(line).append('\n');
/*     */           }
/*     */         });
/* 143 */     return lines.toString();
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
/*     */   public static boolean copy(String src, String dest) {
/* 155 */     File srcFile = new File(src);
/* 156 */     if (!srcFile.exists() || !srcFile.isFile() || !srcFile.canRead()) {
/* 157 */       return false;
/*     */     }
/* 159 */     File destFile = new File(dest);
/* 160 */     if (destFile.exists()) {
/* 161 */       destFile.delete();
/*     */     }
/*     */     
/* 164 */     BufferedInputStream bis = null;
/* 165 */     BufferedOutputStream bos = null;
/*     */     try {
/* 167 */       bis = new BufferedInputStream(new FileInputStream(srcFile));
/* 168 */       bos = new BufferedOutputStream(new FileOutputStream(destFile));
/* 169 */       byte[] buf = new byte[1024];
/* 170 */       int len = 0;
/* 171 */       while ((len = bis.read(buf)) != -1) {
/* 172 */         bos.write(buf, 0, len);
/*     */       }
/*     */       
/* 175 */       return true;
/* 176 */     } catch (FileNotFoundException e) {
/* 177 */       e.printStackTrace();
/* 178 */     } catch (IOException e) {
/* 179 */       e.printStackTrace();
/*     */     } finally {
/* 181 */       if (bos != null) {
/*     */         try {
/* 183 */           bos.close();
/* 184 */         } catch (IOException iOException) {}
/*     */       }
/*     */       
/* 187 */       if (bis != null) {
/*     */         try {
/* 189 */           bis.close();
/* 190 */         } catch (IOException iOException) {}
/*     */       }
/*     */     } 
/*     */ 
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
/*     */   
/*     */   public static boolean clear(File file) {
/*     */     try {
/* 208 */       PrintWriter writer = new PrintWriter(new FileWriter(file, false));
/* 209 */       writer.close();
/* 210 */     } catch (IOException e) {
/* 211 */       e.printStackTrace();
/* 212 */       return false;
/*     */     } 
/* 214 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] file2bytes(File file) {
/* 221 */     BufferedInputStream in = null;
/*     */     try {
/* 223 */       in = new BufferedInputStream(new FileInputStream(file));
/* 224 */       ByteArrayOutputStream out = new ByteArrayOutputStream(in.available());
/* 225 */       byte[] temp = new byte[1024];
/* 226 */       int size = 0;
/* 227 */       while ((size = in.read(temp)) != -1) {
/* 228 */         out.write(temp, 0, size);
/*     */       }
/* 230 */       return out.toByteArray();
/* 231 */     } catch (Exception e) {
/* 232 */       e.printStackTrace();
/*     */     } finally {
/* 234 */       if (in != null) {
/*     */         try {
/* 236 */           in.close();
/* 237 */         } catch (IOException e) {
/* 238 */           e.printStackTrace();
/*     */         } 
/*     */       }
/*     */     } 
/* 242 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void copyNio(File from, File to) throws IOException {
/* 249 */     RandomAccessFile inFile = new RandomAccessFile(from, "r");
/*     */     try {
/* 251 */       RandomAccessFile outFile = new RandomAccessFile(to, "rw");
/*     */       try {
/* 253 */         FileChannel inChannel = inFile.getChannel();
/* 254 */         FileChannel outChannel = outFile.getChannel();
/* 255 */         long pos = 0L;
/* 256 */         long toCopy = inFile.length();
/* 257 */         while (toCopy > 0L) {
/* 258 */           long bytes = inChannel.transferTo(pos, toCopy, outChannel);
/* 259 */           pos += bytes;
/* 260 */           toCopy -= bytes;
/*     */         } 
/*     */       } finally {
/* 263 */         outFile.close();
/*     */       } 
/*     */     } finally {
/* 266 */       inFile.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void write(File file, Collection<String> lines) {
/*     */     try {
/* 275 */       PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file, false), GGlobal.UTF_8), true);
/* 276 */       for (String key : lines) {
/* 277 */         writer.println(key);
/*     */       }
/* 279 */       writer.close();
/* 280 */       writer = null;
/* 281 */     } catch (Exception e) {
/* 282 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void write(File file, String content) {
/*     */     try {
/* 291 */       FileOutputStream out = new FileOutputStream(file);
/* 292 */       out.write(content.getBytes(GGlobal.UTF_8));
/* 293 */       out.close();
/* 294 */     } catch (Exception e) {
/* 295 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static interface FileChecker {
/*     */     boolean check(String param1String);
/*     */   }
/*     */   
/*     */   public static interface FileReader {
/*     */     void read(String param1String);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\cor\\util\FileUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */