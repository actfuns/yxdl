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
/*    */   public boolean isBattlePak() {
/* 23 */     return (this.compressRoute || "area.playerHandler.battleEventNotify".equals(this.route_s));
/*    */   }
/*    */   
/*    */   public void setRoute(String route) {
/* 27 */     this.route_s = route;
/* 28 */     this.compressRoute = false;
/*    */   }
/*    */   public void setRoute(short route) {
/* 31 */     this.route_n = route;
/* 32 */     this.type = route;
/* 33 */     this.compressRoute = true;
/*    */   }
/*    */   public void setRoute(short route_n, String route_s) {
/* 36 */     this.route_n = route_n;
/* 37 */     this.route_s = route_s;
/* 38 */     if (route_s != null) {
/* 39 */       this.compressRoute = true;
/*    */     }
/*    */   }
/*    */   
/*    */   public int getLength() {
/* 44 */     return this.length;
/*    */   }
/*    */   
/*    */   public void setLength(int length) {
/* 48 */     this.length = length;
/*    */   }
/*    */   
/*    */   public byte getPomeloType() {
/* 52 */     return this.pomelo_type;
/*    */   }
/*    */   
/*    */   public void setPomeloType(byte pomelo_type) {
/* 56 */     this.pomelo_type = pomelo_type;
/*    */   }
/*    */   
/*    */   public String getTypeHexString() {
/* 60 */     return super.getTypeHexString() + ":" + this.route_s;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void encode(ByteBuf out) {
/* 68 */     out.writeByte(this.pomelo_type);
/* 69 */     out.writeByte(this.length >> 16 & 0xFF);
/* 70 */     out.writeByte(this.length >> 8 & 0xFF);
/* 71 */     out.writeByte(this.length & 0xFF);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void decode(ByteBuf in) {
/* 78 */     this.pomelo_type = in.readByte();
/* 79 */     this.length = (in.readByte() & 0xFF) << 16 | (in.readByte() & 0xFF) << 8 | in.readByte() & 0xFF;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\game\protocol\PomeloHeader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */