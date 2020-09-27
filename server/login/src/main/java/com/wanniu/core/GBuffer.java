/*     */ package com.wanniu.core;
/*     */ 
/*     */ import com.wanniu.core.tcp.protocol.Prefix;
/*     */ import java.nio.ByteBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GBuffer
/*     */ {
/*     */   private ByteBuffer body;
/*     */   
/*     */   private GBuffer(int size) {
/*  16 */     malloc(size);
/*     */   }
/*     */   
/*     */   private GBuffer(byte[] src) {
/*  20 */     this.body = ByteBuffer.wrap(src).order(GGlobal.__BYTE_ORDER);
/*     */   }
/*     */   
/*     */   private GBuffer(ByteBuffer input) {
/*  24 */     this.body = input;
/*     */   }
/*     */ 
/*     */   
/*     */   public static GBuffer allocate() {
/*  29 */     return allocate(GGlobal.__BUFFER_CAPACITY);
/*     */   }
/*     */   public static GBuffer allocate(int size) {
/*  32 */     return new GBuffer(size);
/*     */   }
/*     */   
/*     */   public static GBuffer wrap(byte[] bytes) {
/*  36 */     return new GBuffer(bytes);
/*     */   }
/*     */   
/*     */   public static GBuffer wrap(ByteBuffer buffer) {
/*  40 */     return new GBuffer(buffer);
/*     */   }
/*     */   
/*     */   public boolean getBoolean() {
/*  44 */     return (getByte() != 0);
/*     */   }
/*     */   
/*     */   public byte getByte() {
/*  48 */     return this.body.get();
/*     */   }
/*     */   
/*     */   public short getShort() {
/*  52 */     return this.body.getShort();
/*     */   }
/*     */   
/*     */   public int getInt() {
/*  56 */     return this.body.getInt();
/*     */   }
/*     */   
/*     */   public float getFloat() {
/*  60 */     return this.body.getFloat();
/*     */   }
/*     */   
/*     */   public long getLong() {
/*  64 */     return this.body.getLong();
/*     */   }
/*     */   
/*     */   public double getDouble() {
/*  68 */     return this.body.getDouble();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/*  73 */     short size = getShort();
/*  74 */     if (size == 0) {
/*  75 */       return null;
/*     */     }
/*  77 */     byte[] tmp = new byte[size];
/*  78 */     this.body.get(tmp);
/*  79 */     return new String(tmp, GConst.UTF_8);
/*     */   }
/*     */   
/*     */   public byte[] getBytes(int size) {
/*  83 */     byte[] bytes = new byte[size];
/*  84 */     this.body.get(bytes);
/*  85 */     return bytes;
/*     */   }
/*     */   
/*     */   public GBuffer flip() {
/*  89 */     this.body.flip();
/*  90 */     return this;
/*     */   }
/*     */   
/*     */   public void skip(int size) {
/*  94 */     this.body.position(this.body.position() + size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getBytes(Prefix prefix) {
/* 101 */     byte[] bytes = null;
/* 102 */     switch (prefix) {
/*     */       case null:
/* 104 */         bytes = new byte[this.body.get()];
/*     */         break;
/*     */       case SHORT:
/* 107 */         bytes = new byte[this.body.getShort()];
/*     */         break;
/*     */       case INT:
/* 110 */         bytes = new byte[this.body.getInt()];
/*     */         break;
/*     */     } 
/* 113 */     this.body.get(bytes);
/* 114 */     return bytes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getBytes() {
/* 121 */     if (this.body.position() > 0) {
/* 122 */       byte[] bytes = new byte[this.body.position()];
/* 123 */       this.body.flip();
/* 124 */       this.body.get(bytes);
/* 125 */       return bytes;
/*     */     } 
/* 127 */     byte[] remain = new byte[this.body.limit() - this.body.position()];
/* 128 */     this.body.get(remain);
/* 129 */     return remain;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void putBytes(Prefix prefix, byte[] data) {
/* 136 */     switch (prefix) {
/*     */       case null:
/* 138 */         putByte(data.length);
/*     */         break;
/*     */       case SHORT:
/* 141 */         putShort(data.length);
/*     */         break;
/*     */       case INT:
/* 144 */         putInt(data.length);
/*     */         break;
/*     */     } 
/* 147 */     put(data);
/*     */   }
/*     */   
/*     */   public void putBuffer(Prefix prefix, ByteBuffer buffer) {
/* 151 */     switch (prefix) {
/*     */       case null:
/* 153 */         putByte(buffer.remaining());
/*     */         break;
/*     */       case SHORT:
/* 156 */         putShort(buffer.remaining());
/*     */         break;
/*     */       case INT:
/* 159 */         putInt(buffer.remaining());
/*     */         break;
/*     */     } 
/* 162 */     put(buffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void putString(String value) {
/* 167 */     if (value == null) {
/* 168 */       putShort(0);
/*     */       return;
/*     */     } 
/* 171 */     byte[] sbuf = value.getBytes(GConst.UTF_8);
/* 172 */     putBytes(Prefix.SHORT, sbuf);
/*     */   }
/*     */   
/*     */   public void putBoolean(boolean b) {
/* 176 */     putByte((byte)(b ? 1 : 0));
/*     */   }
/*     */   
/*     */   public void putShort(int i) {
/* 180 */     putShort((short)i);
/*     */   }
/*     */   
/*     */   public void putByte(int i) {
/* 184 */     putByte((byte)i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void put(byte[] src) {
/* 191 */     autoExpand(src.length);
/* 192 */     this.body.put(src);
/*     */   }
/*     */   
/*     */   public void put(byte[] src, int start, int length) {
/* 196 */     autoExpand(length);
/* 197 */     this.body.put(src, start, length);
/*     */   }
/*     */   
/*     */   public void put(ByteBuffer buffer) {
/* 201 */     autoExpand(buffer.remaining());
/* 202 */     this.body.put(buffer);
/*     */   }
/*     */   
/*     */   public void putDouble(double d) {
/* 206 */     autoExpand(8);
/* 207 */     this.body.putDouble(d);
/*     */   }
/*     */   
/*     */   public void putFloat(float f) {
/* 211 */     autoExpand(4);
/* 212 */     this.body.putFloat(f);
/*     */   }
/*     */   
/*     */   public void putLong(long l) {
/* 216 */     autoExpand(8);
/* 217 */     this.body.putLong(l);
/*     */   }
/*     */   
/*     */   public void putInt(int i) {
/* 221 */     autoExpand(4);
/* 222 */     this.body.putInt(i);
/*     */   }
/*     */   
/*     */   public void putShort(short s) {
/* 226 */     autoExpand(2);
/* 227 */     this.body.putShort(s);
/*     */   }
/*     */   
/*     */   public void putByte(byte b) {
/* 231 */     autoExpand(1);
/* 232 */     this.body.put(b);
/*     */   }
/*     */   
/*     */   private void malloc(int size) {
/* 236 */     this.body = ByteBuffer.allocate(size).order(GGlobal.__BYTE_ORDER);
/*     */   }
/*     */   
/*     */   private void autoExpand(int count) {
/* 240 */     if (this.body.capacity() < this.body.position() + count) {
/* 241 */       ByteBuffer buffer = this.body;
/* 242 */       buffer.flip();
/* 243 */       malloc(this.body.capacity() + Math.max(32, count));
/* 244 */       this.body.put(buffer);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\GBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */