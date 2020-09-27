/*     */ package com.wanniu.core.util.http;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Base64
/*     */ {
/*   9 */   private static final byte[] encodingTable = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
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
/*     */   private static byte[] encodeInner(byte[] data) {
/*     */     byte[] bytes;
/*  26 */     int b1, b2, b3, d1, d2, modulus = data.length % 3;
/*  27 */     if (modulus == 0) {
/*  28 */       bytes = new byte[4 * data.length / 3];
/*     */     } else {
/*  30 */       bytes = new byte[4 * (data.length / 3 + 1)];
/*     */     } 
/*     */     
/*  33 */     int dataLength = data.length - modulus;
/*     */     
/*  35 */     for (int i = 0, j = 0; i < dataLength; i += 3, j += 4) {
/*  36 */       int a1 = data[i] & 0xFF;
/*  37 */       int a2 = data[i + 1] & 0xFF;
/*  38 */       int a3 = data[i + 2] & 0xFF;
/*     */       
/*  40 */       bytes[j] = encodingTable[a1 >>> 2 & 0x3F];
/*  41 */       bytes[j + 1] = encodingTable[(a1 << 4 | a2 >>> 4) & 0x3F];
/*  42 */       bytes[j + 2] = encodingTable[(a2 << 2 | a3 >>> 6) & 0x3F];
/*  43 */       bytes[j + 3] = encodingTable[a3 & 0x3F];
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  52 */     switch (modulus) {
/*     */ 
/*     */       
/*     */       case 1:
/*  56 */         d1 = data[data.length - 1] & 0xFF;
/*  57 */         b1 = d1 >>> 2 & 0x3F;
/*  58 */         b2 = d1 << 4 & 0x3F;
/*     */         
/*  60 */         bytes[bytes.length - 4] = encodingTable[b1];
/*  61 */         bytes[bytes.length - 3] = encodingTable[b2];
/*  62 */         bytes[bytes.length - 2] = 61;
/*  63 */         bytes[bytes.length - 1] = 61;
/*     */         break;
/*     */       case 2:
/*  66 */         d1 = data[data.length - 2] & 0xFF;
/*  67 */         d2 = data[data.length - 1] & 0xFF;
/*     */         
/*  69 */         b1 = d1 >>> 2 & 0x3F;
/*  70 */         b2 = (d1 << 4 | d2 >>> 4) & 0x3F;
/*  71 */         b3 = d2 << 2 & 0x3F;
/*     */         
/*  73 */         bytes[bytes.length - 4] = encodingTable[b1];
/*  74 */         bytes[bytes.length - 3] = encodingTable[b2];
/*  75 */         bytes[bytes.length - 2] = encodingTable[b3];
/*  76 */         bytes[bytes.length - 1] = 61;
/*     */         break;
/*     */     } 
/*     */     
/*  80 */     return bytes;
/*     */   }
/*     */   
/*     */   public static String encodeToString(byte[] data) {
/*  84 */     if (null == data) {
/*  85 */       return null;
/*     */     }
/*     */     
/*  88 */     return new String(encodeInner(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static String encodeToString(String data) {
/*  93 */     if (null == data) {
/*  94 */       return null;
/*     */     }
/*  96 */     return encodeToString(data.getBytes());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 105 */   private static final byte[] decodingTable = new byte[128]; static {
/*     */     int i;
/* 107 */     for (i = 0; i < 128; i++) {
/* 108 */       decodingTable[i] = -1;
/*     */     }
/*     */     
/* 111 */     for (i = 65; i <= 90; i++) {
/* 112 */       decodingTable[i] = (byte)(i - 65);
/*     */     }
/*     */     
/* 115 */     for (i = 97; i <= 122; i++) {
/* 116 */       decodingTable[i] = (byte)(i - 97 + 26);
/*     */     }
/*     */     
/* 119 */     for (i = 48; i <= 57; i++) {
/* 120 */       decodingTable[i] = (byte)(i - 48 + 52);
/*     */     }
/*     */     
/* 123 */     decodingTable[43] = 62;
/* 124 */     decodingTable[47] = 63;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] decode(byte[] data) {
/*     */     byte[] bytes;
/* 133 */     if (null == data) {
/* 134 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 139 */     data = discardNonBase64Bytes(data);
/*     */     
/* 141 */     if (data[data.length - 2] == 61) {
/* 142 */       bytes = new byte[(data.length / 4 - 1) * 3 + 1];
/* 143 */     } else if (data[data.length - 1] == 61) {
/* 144 */       bytes = new byte[(data.length / 4 - 1) * 3 + 2];
/*     */     } else {
/* 146 */       bytes = new byte[data.length / 4 * 3];
/*     */     } 
/*     */     
/* 149 */     for (int i = 0, j = 0; i < data.length - 4; i += 4, j += 3) {
/* 150 */       byte b1 = decodingTable[data[i]];
/* 151 */       byte b2 = decodingTable[data[i + 1]];
/* 152 */       byte b3 = decodingTable[data[i + 2]];
/* 153 */       byte b4 = decodingTable[data[i + 3]];
/*     */       
/* 155 */       bytes[j] = (byte)(b1 << 2 | b2 >> 4);
/* 156 */       bytes[j + 1] = (byte)(b2 << 4 | b3 >> 2);
/* 157 */       bytes[j + 2] = (byte)(b3 << 6 | b4);
/*     */     } 
/*     */     
/* 160 */     if (data[data.length - 2] == 61) {
/* 161 */       byte b1 = decodingTable[data[data.length - 4]];
/* 162 */       byte b2 = decodingTable[data[data.length - 3]];
/*     */       
/* 164 */       bytes[bytes.length - 1] = (byte)(b1 << 2 | b2 >> 4);
/* 165 */     } else if (data[data.length - 1] == 61) {
/* 166 */       byte b1 = decodingTable[data[data.length - 4]];
/* 167 */       byte b2 = decodingTable[data[data.length - 3]];
/* 168 */       byte b3 = decodingTable[data[data.length - 2]];
/*     */       
/* 170 */       bytes[bytes.length - 2] = (byte)(b1 << 2 | b2 >> 4);
/* 171 */       bytes[bytes.length - 1] = (byte)(b2 << 4 | b3 >> 2);
/*     */     } else {
/* 173 */       byte b1 = decodingTable[data[data.length - 4]];
/* 174 */       byte b2 = decodingTable[data[data.length - 3]];
/* 175 */       byte b3 = decodingTable[data[data.length - 2]];
/* 176 */       byte b4 = decodingTable[data[data.length - 1]];
/*     */       
/* 178 */       bytes[bytes.length - 3] = (byte)(b1 << 2 | b2 >> 4);
/* 179 */       bytes[bytes.length - 2] = (byte)(b2 << 4 | b3 >> 2);
/* 180 */       bytes[bytes.length - 1] = (byte)(b3 << 6 | b4);
/*     */     } 
/*     */     
/* 183 */     return bytes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] decode(String data) {
/*     */     byte[] bytes;
/* 194 */     if (null == data) {
/* 195 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 200 */     data = discardNonBase64Chars(data);
/*     */     
/* 202 */     if (data.charAt(data.length() - 2) == '=') {
/* 203 */       bytes = new byte[(data.length() / 4 - 1) * 3 + 1];
/* 204 */     } else if (data.charAt(data.length() - 1) == '=') {
/* 205 */       bytes = new byte[(data.length() / 4 - 1) * 3 + 2];
/*     */     } else {
/* 207 */       bytes = new byte[data.length() / 4 * 3];
/*     */     } 
/*     */     
/* 210 */     for (int i = 0, j = 0; i < data.length() - 4; i += 4, j += 3) {
/* 211 */       byte b1 = decodingTable[data.charAt(i)];
/* 212 */       byte b2 = decodingTable[data.charAt(i + 1)];
/* 213 */       byte b3 = decodingTable[data.charAt(i + 2)];
/* 214 */       byte b4 = decodingTable[data.charAt(i + 3)];
/*     */       
/* 216 */       bytes[j] = (byte)(b1 << 2 | b2 >> 4);
/* 217 */       bytes[j + 1] = (byte)(b2 << 4 | b3 >> 2);
/* 218 */       bytes[j + 2] = (byte)(b3 << 6 | b4);
/*     */     } 
/*     */     
/* 221 */     if (data.charAt(data.length() - 2) == '=') {
/* 222 */       byte b1 = decodingTable[data.charAt(data.length() - 4)];
/* 223 */       byte b2 = decodingTable[data.charAt(data.length() - 3)];
/*     */       
/* 225 */       bytes[bytes.length - 1] = (byte)(b1 << 2 | b2 >> 4);
/* 226 */     } else if (data.charAt(data.length() - 1) == '=') {
/* 227 */       byte b1 = decodingTable[data.charAt(data.length() - 4)];
/* 228 */       byte b2 = decodingTable[data.charAt(data.length() - 3)];
/* 229 */       byte b3 = decodingTable[data.charAt(data.length() - 2)];
/*     */       
/* 231 */       bytes[bytes.length - 2] = (byte)(b1 << 2 | b2 >> 4);
/* 232 */       bytes[bytes.length - 1] = (byte)(b2 << 4 | b3 >> 2);
/*     */     } else {
/* 234 */       byte b1 = decodingTable[data.charAt(data.length() - 4)];
/* 235 */       byte b2 = decodingTable[data.charAt(data.length() - 3)];
/* 236 */       byte b3 = decodingTable[data.charAt(data.length() - 2)];
/* 237 */       byte b4 = decodingTable[data.charAt(data.length() - 1)];
/*     */       
/* 239 */       bytes[bytes.length - 3] = (byte)(b1 << 2 | b2 >> 4);
/* 240 */       bytes[bytes.length - 2] = (byte)(b2 << 4 | b3 >> 2);
/* 241 */       bytes[bytes.length - 1] = (byte)(b3 << 6 | b4);
/*     */     } 
/*     */     
/* 244 */     return bytes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String decode(String data, String charset) {
/* 252 */     if (null == data) {
/* 253 */       return null;
/*     */     }
/* 255 */     if (charset == null)
/*     */     {
/* 257 */       return new String(decode(data));
/*     */     }
/*     */     
/*     */     try {
/* 261 */       return new String(decode(data), charset);
/* 262 */     } catch (UnsupportedEncodingException ex) {
/* 263 */       return new String(decode(data));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String decode(byte[] data, String charset) {
/* 273 */     if (null == data) {
/* 274 */       return null;
/*     */     }
/* 276 */     if (charset == null)
/*     */     {
/* 278 */       return new String(decode(data));
/*     */     }
/*     */     
/*     */     try {
/* 282 */       return new String(decode(data), charset);
/* 283 */     } catch (UnsupportedEncodingException ex) {
/* 284 */       return new String(decode(data));
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
/*     */   
/*     */   private static byte[] discardNonBase64Bytes(byte[] data) {
/* 300 */     byte[] temp = new byte[data.length];
/* 301 */     int bytesCopied = 0;
/*     */     
/* 303 */     for (int i = 0; i < data.length; i++) {
/* 304 */       if (isValidBase64Byte(data[i])) {
/* 305 */         temp[bytesCopied++] = data[i];
/*     */       }
/*     */     } 
/*     */     
/* 309 */     byte[] newData = new byte[bytesCopied];
/*     */     
/* 311 */     System.arraycopy(temp, 0, newData, 0, bytesCopied);
/*     */     
/* 313 */     return newData;
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
/*     */   private static String discardNonBase64Chars(String data) {
/* 326 */     StringBuilder sb = new StringBuilder();
/*     */     
/* 328 */     int length = data.length();
/*     */     
/* 330 */     for (int i = 0; i < length; i++) {
/* 331 */       if (isValidBase64Byte((byte)data.charAt(i))) {
/* 332 */         sb.append(data.charAt(i));
/*     */       }
/*     */     } 
/*     */     
/* 336 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isValidBase64Byte(byte b) {
/* 347 */     if (b == 61)
/* 348 */       return true; 
/* 349 */     if (b < 0 || b >= 128)
/* 350 */       return false; 
/* 351 */     if (decodingTable[b] == -1) {
/* 352 */       return false;
/*     */     }
/* 354 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 361 */     String str = "PD94bWwgdmVyc2lvbj0nMS4wJyBlbmNvZGluZz0nVVRGLTgnIHN0YW5kYWxvbmU9J3llcycgPz4NCjxCPg0KICA8VHM+MjAxMjA4MDEwNDI5NDQ0MTQ8L1RzPg0KICA8VHlwZT4xPC9UeXBlPg0KICA8RXh0PlRnPT08L0V4dD4NCjwvQj4=";
/* 362 */     System.out.println(decode(str, "utf-8"));
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\http\Base64.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */