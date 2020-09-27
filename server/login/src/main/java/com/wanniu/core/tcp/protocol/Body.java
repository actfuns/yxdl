/*     */ package com.wanniu.core.tcp.protocol;
/*     */ 
/*     */ import com.wanniu.core.GGlobal;
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
/*     */ 
/*     */ 
/*     */ public final class Body
/*     */ {
/*     */   private ByteBuf body;
/*     */   
/*     */   public Body() {
/*  22 */     this(GGlobal.__BODY_CAPACITY);
/*     */   }
/*     */   
/*     */   public Body(int initCapacity) {
/*  26 */     this.body = BufferUtil.getAutoBuffer(initCapacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeBoolean(boolean bool) {
/*  33 */     writeByte(bool);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeByte(int value) {
/*  40 */     this.body.writeByte(value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeByte(boolean value) {
/*  47 */     this.body.writeByte(value ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeShort(short value) {
/*  54 */     this.body.writeShort(value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeShort(int value) {
/*  61 */     this.body.writeShort((short)value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeInt(int value) {
/*  68 */     this.body.writeInt(value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeFloat(float value) {
/*  75 */     this.body.writeFloat(value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeLong(long value) {
/*  82 */     this.body.writeLong(value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeDouble(double value) {
/*  89 */     this.body.writeDouble(value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeString(String utf) {
/*  96 */     if (utf == null) {
/*  97 */       this.body.writeShort(0); return;
/*     */     } 
/*  99 */     if (utf.length() > 5000) {
/* 100 */       utf = utf.substring(0, 5000);
/*     */     }
/*     */     
/* 103 */     byte[] bytes = utf.getBytes(GGlobal.UTF_8);
/* 104 */     this.body.writeShort((short)bytes.length);
/* 105 */     this.body.writeBytes(bytes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeBytes(byte[] inwrite) {
/* 112 */     this.body.writeBytes(inwrite);
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
/*     */   public void writeBytes(byte[] inwrite, int offset) {
/* 125 */     this.body.writeBytes(inwrite, offset, inwrite.length - offset);
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
/*     */   public void writeBytes(byte[] inwrite, int offset, int length) {
/* 140 */     this.body.writeBytes(inwrite, offset, length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write2DBytes(byte[][] inwrite) {
/* 147 */     for (int i = 0; i < inwrite.length; i++) {
/* 148 */       this.body.writeBytes(inwrite[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeBuffer(ByteBuf buffer) {
/* 155 */     this.body.writeBytes(buffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeBytes(Prefix prefix, byte[] inwrite) {
/* 161 */     int length = (inwrite != null) ? inwrite.length : 0;
/* 162 */     switch (prefix) {
/*     */       case null:
/* 164 */         this.body.writeByte((byte)length);
/*     */         break;
/*     */       case SHORT:
/* 167 */         this.body.writeShort((short)length);
/*     */         break;
/*     */       case INT:
/* 170 */         this.body.writeInt(length);
/*     */         break;
/*     */     } 
/* 173 */     if (length == 0) {
/*     */       return;
/*     */     }
/* 176 */     this.body.writeBytes(inwrite);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 183 */     this.body.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 190 */     return this.body.readableBytes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getBytes() {
/* 197 */     return this.body.array();
/*     */   }
/*     */   
/*     */   public ByteBuf getBuffer() {
/* 201 */     return this.body;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\tcp\protocol\Body.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */