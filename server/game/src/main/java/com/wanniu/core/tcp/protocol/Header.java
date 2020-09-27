/*     */ package com.wanniu.core.tcp.protocol;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
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
/*     */ public class Header
/*     */ {
/*     */   protected short type;
/*     */   protected int length;
/*     */   private long receiveTime;
/*     */   
/*     */   public void decode(ByteBuf in) {
/*  29 */     this.type = in.readShort();
/*  30 */     this.length = in.readInt();
/*     */   }
/*     */   
/*     */   public void decodeHeader(ByteBuf in) {
/*  34 */     decode(in);
/*     */   }
/*     */   
/*     */   public void decode(Header header) {
/*  38 */     this.type = header.getType();
/*  39 */     this.length = header.getLength();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void encode(ByteBuf out) {
/*  46 */     out.writeShort(this.type);
/*  47 */     out.writeInt(this.length);
/*     */   }
/*     */   
/*     */   public int getLength() {
/*  51 */     return this.length;
/*     */   }
/*     */   
/*     */   public void setLength(int length) {
/*  55 */     this.length = length;
/*     */   }
/*     */   
/*     */   public short getType() {
/*  59 */     return this.type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTypeHexString() {
/*  66 */     return "0x" + Integer.toHexString(this.type);
/*     */   }
/*     */   
/*     */   public void setType(short type) {
/*  70 */     this.type = type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte calcBytes() {
/*  77 */     Field[] fs = Header.class.getDeclaredFields();
/*  78 */     return (byte)(calcSize(fs) - 2);
/*     */   }
/*     */   
/*     */   public long getReceiveTime() {
/*  82 */     return this.receiveTime;
/*     */   }
/*     */   
/*     */   public void setReceiveTime(long receiveTime) {
/*  86 */     this.receiveTime = receiveTime;
/*     */   }
/*     */   
/*     */   public static int calcSize(Field[] fs) {
/*  90 */     int bits = 0;
/*  91 */     for (Field f : fs) {
/*  92 */       int mod = f.getModifiers();
/*  93 */       String type = f.getGenericType().toString().intern();
/*  94 */       if (!Modifier.isStatic(mod)) {
/*  95 */         if (type.equals("byte")) {
/*  96 */           bits += 8;
/*  97 */         } else if (type.equals("short")) {
/*  98 */           bits += 16;
/*  99 */         } else if (type.equals("int")) {
/* 100 */           bits += 32;
/* 101 */         } else if (type.equals("long")) {
/* 102 */           bits += 64;
/* 103 */         } else if (type.equals("char")) {
/* 104 */           bits += 16;
/* 105 */         } else if (type.equals("float")) {
/* 106 */           bits += 32;
/* 107 */         } else if (type.equals("double")) {
/* 108 */           bits += 64;
/*     */         } else {
/* 110 */           Out.warn(new Object[] { "过滤了非基础数据类型属性：", Modifier.toString(mod), " - ", type, "[", f.getName(), "]" });
/*     */         }
/*     */       
/* 113 */       } else if (!"SIZE".equals(f.getName())) {
/* 114 */         Out.warn(new Object[] { "过滤了静态属性：", Modifier.toString(mod), " - ", type, "[", f.getName(), "]" });
/*     */       } 
/*     */     } 
/*     */     
/* 118 */     bits /= 8;
/* 119 */     if (bits > 127 || bits < -128) {
/* 120 */       Out.error(new Object[] { "数值[", Integer.valueOf(bits), "]超过byte边界" });
/* 121 */       return 0;
/*     */     } 
/* 123 */     return bits;
/*     */   }
/*     */ 
/*     */   
/* 127 */   public static final byte SIZE = calcBytes();
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\tcp\protocol\Header.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */