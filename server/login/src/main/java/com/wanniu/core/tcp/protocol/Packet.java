/*     */ package com.wanniu.core.tcp.protocol;
/*     */ 
/*     */ import com.wanniu.core.GGlobal;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.buffer.Unpooled;
/*     */ import io.netty.channel.Channel;
/*     */ import io.netty.util.AttributeKey;
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
/*     */ public class Packet
/*     */ {
/*     */   protected Header header;
/*     */   protected ByteBuf body;
/*     */   protected Channel session;
/*     */   
/*     */   public Packet() {}
/*     */   
/*     */   public Packet(Channel session) {
/*  28 */     this.session = session;
/*  29 */     this.header = new Header();
/*     */   }
/*     */   
/*     */   public ByteBuf init() {
/*  33 */     this.body = Unpooled.buffer(this.header.getLength()).order(GGlobal.__BYTE_ORDER);
/*  34 */     return this.body;
/*     */   }
/*     */   
/*     */   public double getDouble() {
/*  38 */     return this.body.readDouble();
/*     */   }
/*     */   
/*     */   public float getFloat() {
/*  42 */     return this.body.readFloat();
/*     */   }
/*     */   
/*     */   public long getLong() {
/*  46 */     return this.body.readLong();
/*     */   }
/*     */   
/*     */   public int getInt() {
/*  50 */     return this.body.readInt();
/*     */   }
/*     */   
/*     */   public short getShort() {
/*  54 */     return this.body.readShort();
/*     */   }
/*     */   
/*     */   public byte getByte() {
/*  58 */     return this.body.readByte();
/*     */   }
/*     */   
/*     */   public boolean getBoolean() {
/*  62 */     return (getByte() == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getBytes(byte[] dst) {
/*  70 */     this.body.readBytes(dst);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString() {
/*  78 */     byte[] src = getBytes(Prefix.SHORT);
/*  79 */     return (src == null) ? null : new String(src, GGlobal.UTF_8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getBytes(Prefix prefix) {
/*  86 */     int len = 0;
/*     */     
/*  88 */     switch (prefix) {
/*     */       case null:
/*  90 */         len = getByte();
/*     */         break;
/*     */       case SHORT:
/*  93 */         len = getShort();
/*     */         break;
/*     */       case INT:
/*  96 */         len = getInt();
/*     */         break;
/*     */     } 
/*     */     
/* 100 */     if (len == 0) {
/* 101 */       return null;
/*     */     }
/* 103 */     byte[] dst = new byte[len];
/* 104 */     getBytes(dst);
/*     */     
/* 106 */     return dst;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillBody(byte[] src) {
/* 115 */     this.body.writeBytes(src);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetBody() {
/* 124 */     this.body.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Channel getSession() {
/* 133 */     return this.session;
/*     */   }
/*     */   
/*     */   public <T> T getAttr(AttributeKey<T> att) {
/* 137 */     return (T)this.session.attr(att).get();
/*     */   }
/*     */   
/*     */   public <T> void setAttr(AttributeKey<T> att, T value) {
/* 141 */     this.session.attr(att).set(value);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 145 */     return this.header.getTypeHexString();
/*     */   }
/*     */   
/*     */   public short getPacketType() {
/* 149 */     return this.header.getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getBytes() {
/* 156 */     return this.body.array();
/*     */   }
/*     */   
/*     */   public byte[] getRemaingBytes() {
/* 160 */     int length = this.body.readableBytes();
/* 161 */     byte[] array = new byte[length];
/* 162 */     this.body.getBytes(this.body.readerIndex(), array, 0, length);
/* 163 */     return array;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Header getHeader() {
/* 170 */     return this.header;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteBuf getBody() {
/* 176 */     return this.body;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void skip(int len) {
/* 182 */     this.body.skipBytes(len);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int remaing() {
/* 188 */     return this.body.readableBytes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isClosed() {
/* 195 */     return !(this.session != null && this.session.isActive());
/*     */   }
/*     */   
/*     */   public void close() {
/* 199 */     if (this.session != null) {
/* 200 */       this.session.close();
/*     */     }
/*     */   }
/*     */   
/*     */   public String getIp() {
/* 205 */     if (this.session != null) {
/* 206 */       String ip = this.session.remoteAddress().toString();
/* 207 */       return ip.substring(1, ip.indexOf(":"));
/*     */     } 
/* 209 */     return null;
/*     */   }
/*     */   
/*     */   public void setSession(Channel session) {
/* 213 */     this.session = session;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUid() {
/* 218 */     return (String)this.session.attr(GGlobal._KEY_USER_ID).get();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\tcp\protocol\Packet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */