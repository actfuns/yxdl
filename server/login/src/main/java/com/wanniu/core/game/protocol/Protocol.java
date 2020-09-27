/*     */ package com.wanniu.core.game.protocol;
/*     */ 
/*     */ import com.wanniu.core.tcp.BufferUtil;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Protocol
/*     */ {
/*     */   public static final byte TYPE_HANDSHAKE = 1;
/*     */   public static final byte TYPE_HANDSHAKE_ACK = 2;
/*     */   public static final byte TYPE_HEARTBEAT = 3;
/*     */   public static final byte TYPE_DATA = 4;
/*     */   public static final byte TYPE_KICK = 5;
/*     */   public static final byte TYPE_REQUEST = 0;
/*     */   public static final byte TYPE_NOTIFY = 1;
/*     */   public static final byte TYPE_RESPONSE = 2;
/*     */   public static final byte TYPE_PUSH = 3;
/*     */   public static final byte MSG_FLAG_BYTES = 1;
/*     */   public static final byte MSG_ROUTE_CODE_BYTES = 2;
/*     */   public static final byte MSG_ID_MAX_BYTES = 5;
/*     */   public static final byte MSG_ROUTE_LEN_BYTES = 1;
/*     */   public static final int MSG_ROUTE_CODE_MAX = 65535;
/*     */   public static final byte MSG_COMPRESS_ROUTE_MASK = 1;
/*     */   public static final byte MSG_COMPRESS_GZIP_MASK = 1;
/*     */   public static final byte MSG_COMPRESS_GZIP_ENCODE_MASK = 16;
/*     */   public static final byte MSG_TYPE_MASK = 7;
/*     */   private static final int LEFT_SHIFT_BITS = 128;
/*     */   
/*     */   public static ByteBuf strencode(String str) {
/*  37 */     ByteBuf buf = BufferUtil.getAutoBuffer(str.length() * 3);
/*  38 */     for (int i = 0; i < str.length(); i++) {
/*  39 */       byte charCode = (byte)str.charAt(i);
/*  40 */       byte[] codes = null;
/*  41 */       if (charCode <= Byte.MAX_VALUE) {
/*  42 */         codes = new byte[] { charCode };
/*  43 */       } else if (charCode <= 2047) {
/*  44 */         codes = new byte[] { (byte)(0xC0 | charCode >> 6), (byte)(0x80 | charCode & 0x3F) };
/*     */       } else {
/*  46 */         codes = new byte[] { (byte)(0xE0 | charCode >> 12), (byte)(0x80 | (charCode & 0xFC0) >> 6), 
/*  47 */             (byte)(0x80 | charCode & 0x3F) };
/*     */       } 
/*  49 */       for (int j = 0; j < codes.length; j++) {
/*  50 */         buf.writeByte(codes[j]);
/*     */       }
/*     */     } 
/*  53 */     return buf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String strdecode(byte[] bytes) {
/*  60 */     ByteBuf array = BufferUtil.getAutoBuffer(bytes.length);
/*  61 */     int offset = 0;
/*  62 */     int charCode = 0;
/*  63 */     int end = bytes.length;
/*  64 */     while (offset < end) {
/*  65 */       if (bytes[offset] < 128) {
/*  66 */         charCode = bytes[offset];
/*  67 */         offset++;
/*  68 */       } else if (bytes[offset] < 224) {
/*  69 */         charCode = ((bytes[offset] & 0x3F) << 6) + (bytes[offset + 1] & 0x3F);
/*  70 */         offset += 2;
/*     */       } else {
/*  72 */         charCode = ((bytes[offset] & 0xF) << 12) + ((bytes[offset + 1] & 0x3F) << 6) + (
/*  73 */           bytes[offset + 2] & 0x3F);
/*  74 */         offset += 3;
/*     */       } 
/*  76 */       array.writeByte((byte)charCode);
/*     */     } 
/*  78 */     byte[] b = array.array();
/*  79 */     return new String(b);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] writeLength(int length, int contentLen) {
/*  85 */     int offset = contentLen - 1;
/*  86 */     byte[] bytes = new byte[contentLen];
/*  87 */     for (; offset >= 0; offset--) {
/*  88 */       int b = length % 128;
/*  89 */       if (offset < contentLen - 1) {
/*  90 */         b |= 0x80;
/*     */       }
/*  92 */       bytes[offset] = (byte)b;
/*  93 */       length >>= 7;
/*     */     } 
/*  95 */     return bytes;
/*     */   }
/*     */   
/*     */   public static int calLengthSize(int length) {
/*  99 */     int res = 0;
/* 100 */     while (length > 0) {
/* 101 */       length >>= 7;
/* 102 */       res++;
/*     */     } 
/* 104 */     return res;
/*     */   }
/*     */   
/*     */   public static int caculateMsgIdBytes(int id) {
/* 108 */     int len = 0;
/*     */     do {
/* 110 */       len++;
/* 111 */       id >>= 7;
/* 112 */     } while (id > 0);
/* 113 */     return len;
/*     */   }
/*     */   
/*     */   public static boolean msgHasId(byte type) {
/* 117 */     return !(type != 0 && type != 2);
/*     */   }
/*     */   
/*     */   public static boolean msgHasRoute(int type) {
/* 121 */     return !(type != 0 && type != 1 && type != 3);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\game\protocol\Protocol.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */