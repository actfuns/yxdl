/*    */ package com.wanniu.core.game.protocol;
/*    */ 
/*    */ import com.wanniu.core.tcp.protocol.Header;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class PomeloHeader
/*    */   extends Header
/*    */ {
/*    */   public static final byte SIZE = 4;
/* 15 */   protected byte pomelo_type = 4;
/*    */   
/*    */   protected int length;
/*    */   public boolean compressRoute;
/*    */   public short route_n;
/*    */   public String route_s;
/*    */   
/*    */   public void setRoute(String route) {
/* 23 */     this.route_s = route;
/* 24 */     this.compressRoute = false;
/*    */   }
/*    */   public void setRoute(short route) {
/* 27 */     this.route_n = route;
/* 28 */     this.type = route;
/* 29 */     this.compressRoute = true;
/*    */   }
/*    */   public void setRoute(short route_n, String route_s) {
/* 32 */     this.route_n = route_n;
/* 33 */     this.route_s = route_s;
/* 34 */     if (route_s != null) {
/* 35 */       this.compressRoute = true;
/*    */     }
/*    */   }
/*    */   
/*    */   public int getLength() {
/* 40 */     return this.length;
/*    */   }
/*    */   
/*    */   public void setLength(int length) {
/* 44 */     this.length = length;
/*    */   }
/*    */   
/*    */   public byte getPomeloType() {
/* 48 */     return this.pomelo_type;
/*    */   }
/*    */   
/*    */   public void setPomeloType(byte pomelo_type) {
/* 52 */     this.pomelo_type = pomelo_type;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTypeHexString() {
/* 59 */     return "0x" + Integer.toHexString(this.type) + ":" + this.route_s;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void encode(ByteBuf out) {
/* 67 */     out.writeByte(this.pomelo_type);
/* 68 */     out.writeByte(this.length >> 16 & 0xFF);
/* 69 */     out.writeByte(this.length >> 8 & 0xFF);
/* 70 */     out.writeByte(this.length & 0xFF);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void decode(ByteBuf in) {
/* 77 */     this.pomelo_type = in.readByte();
/* 78 */     this.length = (in.readByte() & 0xFF) << 16 | (in.readByte() & 0xFF) << 8 | in.readByte() & 0xFF;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\game\protocol\PomeloHeader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */