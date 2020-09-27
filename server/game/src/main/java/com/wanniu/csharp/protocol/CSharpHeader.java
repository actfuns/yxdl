/*    */ package com.wanniu.csharp.protocol;
/*    */ 
/*    */ import com.wanniu.core.GGlobal;
/*    */ import com.wanniu.core.tcp.protocol.Header;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class CSharpHeader
/*    */   extends Header
/*    */ {
/*    */   public static final byte SIZE = 8;
/*    */   private String uid;
/* 19 */   private int uidLength = 0;
/*    */   
/*    */   public int getCharpLength() {
/* 22 */     return this.uidLength + this.length;
/*    */   }
/*    */   
/*    */   public String getUid() {
/* 26 */     return this.uid;
/*    */   }
/*    */   
/*    */   public void setUid(String uid) {
/* 30 */     this.uid = uid;
/* 31 */     this.uidLength = uid.length();
/*    */   }
/*    */   
/*    */   public int getUidLength() {
/* 35 */     return this.uidLength;
/*    */   }
/*    */   
/*    */   public int getBodyLength() {
/* 39 */     return getLength();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void encode(ByteBuf out) {
/* 51 */     out.writeShort(this.uid.length());
/* 52 */     out.writeInt(getLength());
/* 53 */     out.writeBytes(this.uid.getBytes(GGlobal.UTF_8));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void decode(ByteBuf in) {
/* 60 */     this.uidLength = readU16(in);
/*    */     
/* 62 */     this.length = readU32(in);
/*    */   }
/*    */   
/*    */   public int readU8(ByteBuf in) {
/* 66 */     return in.readByte() & 0xFF;
/*    */   }
/*    */   
/*    */   public int readU16(ByteBuf in) {
/* 70 */     return readU8(in) | readU8(in) << 8;
/*    */   }
/*    */   
/*    */   public int readU32(ByteBuf in) {
/* 74 */     return readU8(in) | readU8(in) << 8 | readU8(in) << 16 | readU8(in) << 24;
/*    */   }
/*    */   
/*    */   public void readBody(ByteBuf in) {
/* 78 */     byte[] uid = new byte[this.uidLength];
/* 79 */     in.readBytes(uid);
/* 80 */     this.uid = new String(uid, GGlobal.UTF_8);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\csharp\protocol\CSharpHeader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */