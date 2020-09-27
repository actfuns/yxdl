/*     */ package com.wanniu.core.util;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.StringTokenizer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StringUtil
/*     */ {
/*     */   public static final String ASCII_CHARSET = "US-ASCII";
/*     */   public static final String GBK = "GBK";
/*     */   
/*     */   public static final String join(int[] os, String tag) {
/*  18 */     StringBuilder builder = new StringBuilder();
/*  19 */     for (int i = 0; i < os.length; i++) {
/*  20 */       if (i > 0) {
/*  21 */         builder.append(tag);
/*     */       }
/*  23 */       builder.append(os[i]);
/*     */     } 
/*  25 */     return builder.toString();
/*     */   }
/*     */   
/*     */   public static final String join(Object[] os, String tag) {
/*  29 */     StringBuilder builder = new StringBuilder();
/*  30 */     for (int i = 0; i < os.length; i++) {
/*  31 */       if (i > 0) {
/*  32 */         builder.append(tag);
/*     */       }
/*  34 */       builder.append(os[i]);
/*     */     } 
/*  36 */     return builder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String[] split(String txt, String tag) {
/*  43 */     StringTokenizer tokenizer = new StringTokenizer(txt, tag);
/*  44 */     String[] result = new String[tokenizer.countTokens()];
/*  45 */     for (int index = 0; tokenizer.hasMoreTokens();) {
/*  46 */       result[index++] = tokenizer.nextToken();
/*     */     }
/*  48 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean isEmpty(String param) {
/*  58 */     return (param == null || param.length() == 0 || param.trim().equals(""));
/*     */   }
/*     */   
/*     */   public static final boolean isNotEmpty(String param) {
/*  62 */     return !isEmpty(param);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean hasChinese(String txt) {
/*  73 */     char[] chars = txt.toCharArray();
/*  74 */     int length = chars.length;
/*  75 */     for (int i = 0; i < length; i++) {
/*  76 */       if (isChinese(chars[i])) {
/*  77 */         return true;
/*     */       }
/*     */     } 
/*  80 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean isChinese(String txt) {
/*  87 */     char[] chars = txt.toCharArray();
/*  88 */     int length = chars.length;
/*  89 */     for (int i = 0; i < length; i++) {
/*  90 */       if (!isChinese(chars[i])) {
/*  91 */         return false;
/*     */       }
/*     */     } 
/*  94 */     return true;
/*     */   }
/*     */   
/*     */   public static final boolean isChinese(char c) {
/*  98 */     Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
/*  99 */     if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 105 */       return true;
/*     */     }
/* 107 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean isAlpha(String value) {
/* 114 */     if (value == null || value.length() == 0) {
/* 115 */       return false;
/*     */     }
/* 117 */     for (int i = 0; i < value.length(); i++) {
/* 118 */       if (!isAlpha(value.charAt(i))) {
/* 119 */         return false;
/*     */       }
/*     */     } 
/* 122 */     return true;
/*     */   }
/*     */   public static final boolean isAlpha(char c) {
/* 125 */     if (('A' > c || c > 'Z') && ('a' > c || c > 'z')) {
/* 126 */       return false;
/*     */     }
/* 128 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean isNumeric(String value) {
/* 134 */     if (value == null || value.length() == 0) {
/* 135 */       return false;
/*     */     }
/* 137 */     for (int i = 0; i < value.length(); i++) {
/* 138 */       if (!isNumeric(value.charAt(i))) {
/* 139 */         return false;
/*     */       }
/*     */     } 
/* 142 */     return true;
/*     */   }
/*     */   public static final boolean isNumeric(char c) {
/* 145 */     if ('0' > c || c > '9') {
/* 146 */       return false;
/*     */     }
/* 148 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean isAlphaNumeric(String value) {
/* 154 */     if (value == null || value.trim().length() == 0) {
/* 155 */       return true;
/*     */     }
/* 157 */     for (int i = 0; i < value.length(); i++) {
/* 158 */       char letter = value.charAt(i);
/* 159 */       if (!isAlpha(letter) && !isNumeric(letter)) {
/* 160 */         return false;
/*     */       }
/*     */     } 
/* 163 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean isAlphaNumeric_(String value) {
/* 169 */     if (value == null || value.trim().length() == 0) {
/* 170 */       return true;
/*     */     }
/* 172 */     for (int i = 0; i < value.length(); i++) {
/* 173 */       char letter = value.charAt(i);
/* 174 */       if (!isAlpha(letter) && !isNumeric(letter) && letter != '_') {
/* 175 */         return false;
/*     */       }
/*     */     } 
/* 178 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String replace(String string, String oldString, String newString) {
/* 185 */     if (string == null) {
/* 186 */       return null;
/*     */     }
/* 188 */     if (newString == null) {
/* 189 */       return string;
/*     */     }
/* 191 */     int i = 0;
/* 192 */     if ((i = string.indexOf(oldString, i)) >= 0) {
/* 193 */       char[] string2 = string.toCharArray();
/* 194 */       char[] newString2 = newString.toCharArray();
/* 195 */       int oLength = oldString.length();
/* 196 */       StringBuffer buf = new StringBuffer(string2.length);
/* 197 */       buf.append(string2, 0, i).append(newString2);
/* 198 */       i += oLength;
/*     */       int j;
/* 200 */       for (j = i; (i = string.indexOf(oldString, i)) > 0; j = i) {
/* 201 */         buf.append(string2, j, i - j).append(newString2);
/* 202 */         i += oLength;
/*     */       } 
/*     */       
/* 205 */       buf.append(string2, j, string2.length - j);
/* 206 */       return buf.toString();
/*     */     } 
/* 208 */     return string;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String replaceIgnoreCase(String line, String oldString, String newString) {
/* 216 */     if (line == null) {
/* 217 */       return null;
/*     */     }
/* 219 */     String lcLine = line.toLowerCase();
/* 220 */     String lcOldString = oldString.toLowerCase();
/* 221 */     int i = 0;
/* 222 */     if ((i = lcLine.indexOf(lcOldString, i)) >= 0) {
/* 223 */       char[] line2 = line.toCharArray();
/* 224 */       char[] newString2 = newString.toCharArray();
/* 225 */       int oLength = oldString.length();
/* 226 */       StringBuffer buf = new StringBuffer(line2.length);
/* 227 */       buf.append(line2, 0, i).append(newString2);
/* 228 */       i += oLength;
/*     */       int j;
/* 230 */       for (j = i; (i = lcLine.indexOf(lcOldString, i)) > 0; j = i) {
/* 231 */         buf.append(line2, j, i - j).append(newString2);
/* 232 */         i += oLength;
/*     */       } 
/*     */       
/* 235 */       buf.append(line2, j, line2.length - j);
/* 236 */       return buf.toString();
/*     */     } 
/* 238 */     return line;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 245 */   public static String WESTERN = " 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-=[];,./~!@#$%^&*()+_{}:|<>?'\\\"æøåÆØÅäöüÄÖÜßåäöÅÄÖÑñ";
/*     */   public static final byte[] getAsciiBytes(String data) {
/* 247 */     if (data == null) {
/* 248 */       throw new IllegalArgumentException("Parameter may not be null");
/*     */     }
/*     */     try {
/* 251 */       return data.getBytes("US-ASCII");
/* 252 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*     */       
/* 254 */       throw new RuntimeException("LGame requires ASCII support");
/*     */     } 
/*     */   }
/*     */   public static final String getAsciiString(byte[] data, int offset, int length) {
/* 258 */     if (data == null) {
/* 259 */       throw new IllegalArgumentException("Parameter may not be null");
/*     */     }
/*     */     try {
/* 262 */       return new String(data, offset, length, "US-ASCII");
/* 263 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*     */       
/* 265 */       throw new RuntimeException("LGame requires ASCII support");
/*     */     } 
/*     */   }
/*     */   public static final String getAsciiString(byte[] data) {
/* 269 */     return getAsciiString(data, 0, data.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String getSpecialString(String context, String encoding) {
/*     */     try {
/* 278 */       ByteArrayInputStream in = new ByteArrayInputStream(context.getBytes());
/* 279 */       InputStreamReader isr = new InputStreamReader(in, encoding);
/* 280 */       BufferedReader reader = new BufferedReader(isr);
/* 281 */       StringBuffer buffer = new StringBuffer();
/*     */       String result;
/* 283 */       while ((result = reader.readLine()) != null) {
/* 284 */         buffer.append(result);
/*     */       }
/* 286 */       return buffer.toString();
/* 287 */     } catch (Exception ex) {
/* 288 */       return context;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String fillSpace(String txt, int length) {
/* 297 */     byte[] txtBytes = txt.getBytes();
/* 298 */     if (txtBytes.length >= length) {
/* 299 */       return txt;
/*     */     }
/* 301 */     StringBuffer txtBuffer = new StringBuffer(length);
/* 302 */     txtBuffer.append(txt);
/* 303 */     for (int i = 0; i < length - txtBytes.length; i++) {
/* 304 */       txtBuffer.append(" ");
/*     */     }
/* 306 */     return txtBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int charCount(String txt, char c) {
/* 313 */     if (txt != null) {
/* 314 */       int count = 0;
/* 315 */       int length = txt.length();
/* 316 */       for (int i = 0; i < length; i++) {
/* 317 */         if (txt.charAt(i) == c) {
/* 318 */           count++;
/*     */         }
/*     */       } 
/* 321 */       return count;
/*     */     } 
/* 323 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int getBytesLength(String txt, String encoding) {
/* 330 */     if (txt == null || txt.length() == 0) {
/* 331 */       return 0;
/*     */     }
/*     */     try {
/* 334 */       byte[] bytes = txt.getBytes(encoding);
/* 335 */       int length = bytes.length;
/* 336 */       return length;
/* 337 */     } catch (UnsupportedEncodingException exception) {
/* 338 */       System.err.println(exception.getMessage());
/*     */       
/* 340 */       return 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String getGbkString(byte[] chars) {
/* 347 */     String value = null;
/*     */     try {
/* 349 */       value = new String(chars, "GBK");
/* 350 */     } catch (UnsupportedEncodingException e) {
/* 351 */       value = new String(chars);
/*     */     } 
/* 353 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final byte[] getGbkBytes(String value) {
/*     */     byte[] bytes;
/*     */     try {
/* 362 */       bytes = value.getBytes("GBK");
/* 363 */     } catch (UnsupportedEncodingException e) {
/* 364 */       bytes = value.getBytes();
/*     */     } 
/* 366 */     return bytes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean isWestern(String string) {
/* 373 */     char[] chars = string.toCharArray();
/* 374 */     int size = chars.length;
/* 375 */     for (int i = 0; i < size; i++) {
/* 376 */       if (WESTERN.indexOf(chars[i]) == -1) {
/* 377 */         return false;
/*     */       }
/*     */     } 
/* 380 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\StringUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */