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
/*     */   
/*     */   public void decode(ByteBuf in) {
/*  28 */     this.type = in.readShort();
/*  29 */     this.length = in.readInt();
/*     */   }
/*     */   
/*     */   public void decodeHeader(ByteBuf in) {
/*  33 */     decode(in);
/*     */   }
/*     */   
/*     */   public void decode(Header header) {
/*  37 */     this.type = header.getType();
/*  38 */     this.length = header.getLength();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void encode(ByteBuf out) {
/*  45 */     out.writeShort(this.type);
/*  46 */     out.writeInt(this.length);
/*     */   }
/*     */   
/*     */   public int getLength() {
/*  50 */     return this.length;
/*     */   }
/*     */   
/*     */   public void setLength(int length) {
/*  54 */     this.length = length;
/*     */   }
/*     */   
/*     */   public short getType() {
/*  58 */     return this.type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTypeHexString() {
/*  65 */     return "0x" + Integer.toHexString(this.type);
/*     */   }
/*     */   
/*     */   public void setType(short type) {
/*  69 */     this.type = type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte calcBytes() {
/*  76 */     Field[] fs = Header.class.getDeclaredFields();
/*  77 */     return (byte)(calcSize(fs) - 2);
/*     */   }
/*     */   
/*     */   public static int calcSize(Field[] fs) {
/*  81 */     int bits = 0; byte b; int i; Field[] arrayOfField;
/*  82 */     for (i = (arrayOfField = fs).length, b = 0; b < i; ) { Field f = arrayOfField[b];
/*  83 */       int mod = f.getModifiers();
/*  84 */       String type = f.getGenericType().toString().intern();
/*  85 */       if (!Modifier.isStatic(mod)) {
/*  86 */         if (type == "byte") {
/*  87 */           bits += 8;
/*  88 */         } else if (type == "short") {
/*  89 */           bits += 16;
/*  90 */         } else if (type == "int") {
/*  91 */           bits += 32;
/*  92 */         } else if (type == "long") {
/*  93 */           bits += 64;
/*  94 */         } else if (type == "char") {
/*  95 */           bits += 16;
/*  96 */         } else if (type == "float") {
/*  97 */           bits += 32;
/*  98 */         } else if (type == "double") {
/*  99 */           bits += 64;
/*     */         } else {
/* 101 */           Out.warn(new Object[] { "过滤了非基础数据类型属性：" + Modifier.toString(mod) + " - " + type + "[" + f.getName() + "]" });
/*     */         }
/*     */       
/* 104 */       } else if (!"SIZE".equals(f.getName())) {
/* 105 */         Out.warn(new Object[] { "过滤了静态属性：" + Modifier.toString(mod) + " - " + type + "[" + f.getName() + "]" });
/*     */       } 
/*     */       b++; }
/*     */     
/* 109 */     bits /= 8;
/* 110 */     if (bits > 127 || bits < -128) {
/* 111 */       Out.error(new Object[] { "数值[" + bits + "]超过byte边界" });
/* 112 */       return 0;
/*     */     } 
/* 114 */     return bits;
/*     */   }
/*     */ 
/*     */   
/* 118 */   public static final byte SIZE = calcBytes();
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\tcp\protocol\Header.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */