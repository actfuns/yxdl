/*     */ package com.wanniu.core.tcp.protocol;
/*     */ 
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.game.entity.GPlayer;
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
/*  29 */     this.session = session;
/*  30 */     this.header = new Header();
/*     */   }
/*     */   
/*     */   public ByteBuf init() {
/*  34 */     this.body = Unpooled.buffer(this.header.getLength()).order(GGlobal.__BYTE_ORDER);
/*  35 */     return this.body;
/*     */   }
/*     */   
/*     */   public double getDouble() {
/*  39 */     return this.body.readDouble();
/*     */   }
/*     */   
/*     */   public float getFloat() {
/*  43 */     return this.body.readFloat();
/*     */   }
/*     */   
/*     */   public long getLong() {
/*  47 */     return this.body.readLong();
/*     */   }
/*     */   
/*     */   public int getInt() {
/*  51 */     return this.body.readInt();
/*     */   }
/*     */   
/*     */   public short getShort() {
/*  55 */     return this.body.readShort();
/*     */   }
/*     */   
/*     */   public byte getByte() {
/*  59 */     return this.body.readByte();
/*     */   }
/*     */   
/*     */   public boolean getBoolean() {
/*  63 */     return (getByte() == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getBytes(byte[] dst) {
/*  71 */     this.body.readBytes(dst);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString() {
/*  79 */     byte[] src = getBytes(Prefix.SHORT);
/*  80 */     return (src == null) ? null : new String(src, GGlobal.UTF_8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getBytes(Prefix prefix) {
/*  87 */     int len = 0;
/*     */     
/*  89 */     switch (prefix) {
/*     */       case BYTE:
/*  91 */         len = getByte();
/*     */         break;
/*     */       case SHORT:
/*  94 */         len = getShort();
/*     */         break;
/*     */       case INT:
/*  97 */         len = getInt();
/*     */         break;
/*     */     } 
/*     */     
/* 101 */     if (len == 0) {
/* 102 */       return null;
/*     */     }
/* 104 */     byte[] dst = new byte[len];
/* 105 */     getBytes(dst);
/*     */     
/* 107 */     return dst;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillBody(byte[] src) {
/* 116 */     this.body.writeBytes(src);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetBody() {
/* 125 */     this.body.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Channel getSession() {
/* 134 */     return this.session;
/*     */   }
/*     */   
/*     */   public <T> T getAttr(AttributeKey<T> att) {
/* 138 */     return (T)this.session.attr(att).get();
/*     */   }
/*     */   
/*     */   public <T> void setAttr(AttributeKey<T> att, T value) {
/* 142 */     this.session.attr(att).set(value);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 146 */     return this.header.getTypeHexString();
/*     */   }
/*     */   
/*     */   public short getPacketType() {
/* 150 */     return this.header.getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getBytes() {
/* 157 */     return this.body.array();
/*     */   }
/*     */   
/*     */   public byte[] getRemaingBytes() {
/* 161 */     int length = this.body.readableBytes();
/* 162 */     byte[] array = new byte[length];
/* 163 */     this.body.getBytes(this.body.readerIndex(), array, 0, length);
/* 164 */     return array;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Header getHeader() {
/* 171 */     return this.header;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteBuf getBody() {
/* 177 */     return this.body;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void skip(int len) {
/* 183 */     this.body.skipBytes(len);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int remaing() {
/* 189 */     return this.body.readableBytes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isClosed() {
/* 196 */     return (this.session == null || !this.session.isActive());
/*     */   }
/*     */   
/*     */   public void close() {
/* 200 */     if (this.session != null) {
/* 201 */       this.session.close();
/*     */     }
/*     */   }
/*     */   
/*     */   public String getIp() {
/* 206 */     if (this.session != null) {
/* 207 */       String ip = this.session.remoteAddress().toString();
/* 208 */       return ip.substring(1, ip.indexOf(":"));
/*     */     } 
/* 210 */     return null;
/*     */   }
/*     */   
/*     */   public void setSession(Channel session) {
/* 214 */     this.session = session;
/*     */   }
/*     */   
/*     */   public String getRid() {
/* 218 */     GPlayer player = (GPlayer)this.session.attr(GGlobal.__KEY_PLAYER).get();
/* 219 */     return (player == null) ? null : player.getId();
/*     */   }
/*     */   
/*     */   public GPlayer getPlayer() {
/* 223 */     return (GPlayer)this.session.attr(GGlobal.__KEY_PLAYER).get();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUid() {
/* 228 */     return getAttr(GGlobal.__KEY_USER_ID);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\tcp\protocol\Packet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */