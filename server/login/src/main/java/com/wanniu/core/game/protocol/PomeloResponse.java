/*    */ package com.wanniu.core.game.protocol;
/*    */ 
/*    */ import com.wanniu.core.tcp.BufferUtil;
/*    */ import com.wanniu.core.tcp.protocol.Header;
/*    */ import com.wanniu.core.tcp.protocol.Message;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class PomeloResponse
/*    */   extends Message
/*    */ {
/*    */   private ByteBuf route;
/*    */   private int capacity;
/*    */   
/*    */   protected Header newHeader() {
/* 17 */     return new PomeloHeader();
/*    */   }
/*    */   
/*    */   public PomeloHeader getHeader() {
/* 21 */     return (PomeloHeader)this.header;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 26 */   public byte type = 2;
/*    */   
/*    */   protected ByteBuf newContent() {
/* 29 */     PomeloHeader header = getHeader();
/* 30 */     int capacity = 1;
/* 31 */     capacity += Protocol.msgHasId(this.type) ? Protocol.caculateMsgIdBytes(header.getType()) : 0;
/* 32 */     if (Protocol.msgHasRoute(this.type)) {
/* 33 */       if (header.compressRoute) {
/* 34 */         capacity += 2;
/*    */       } else {
/* 36 */         this.route = Protocol.strencode(header.route_s);
/* 37 */         capacity++;
/* 38 */         capacity += this.route.readableBytes();
/*    */       } 
/*    */     }
/* 41 */     capacity += this.body.getBuffer().readableBytes();
/* 42 */     this.capacity = capacity;
/* 43 */     return BufferUtil.getAutoBuffer(4 + capacity);
/*    */   }
/*    */   
/*    */   protected void encodeHeader() {
/* 47 */     PomeloHeader header = getHeader();
/*    */     
/* 49 */     header.setLength(this.capacity);
/* 50 */     header.encode(this.content);
/*    */   }
/*    */   
/*    */   protected void encodeBody() {
/* 54 */     PomeloHeader header = getHeader();
/*    */ 
/*    */     
/* 57 */     int flag = this.type << 1 | (header.compressRoute ? 1 : 0);
/*    */ 
/*    */ 
/*    */     
/* 61 */     this.content.writeByte(flag);
/*    */ 
/*    */     
/* 64 */     if (Protocol.msgHasId(this.type)) {
/* 65 */       int id = header.getType();
/*    */       do {
/* 67 */         int tmp = id % 128;
/* 68 */         int next = id / 128;
/* 69 */         if (next != 0) {
/* 70 */           tmp += 128;
/*    */         }
/* 72 */         this.content.writeByte(tmp);
/* 73 */         id = next;
/* 74 */       } while (id != 0);
/*    */     } 
/*    */ 
/*    */     
/* 78 */     if (Protocol.msgHasRoute(this.type)) {
/* 79 */       if (header.compressRoute) {
/* 80 */         this.content.writeByte(header.route_n >> 8 & 0xFF);
/* 81 */         this.content.writeByte(header.route_n & 0xFF);
/*    */       }
/* 83 */       else if (this.route != null) {
/* 84 */         this.content.writeByte(this.route.readableBytes() & 0xFF);
/* 85 */         this.content.writeBytes(this.route);
/*    */       } else {
/* 87 */         this.content.writeByte(0);
/*    */       } 
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 93 */     this.content.writeBytes(this.body.getBuffer());
/*    */   }
/*    */   
/*    */   public short getType() {
/* 97 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\game\protocol\PomeloResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */