/*    */ package com.wanniu.csharp.protocol;
/*    */ 
/*    */ import com.wanniu.core.tcp.protocol.Header;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSharpPacket
/*    */   extends Packet
/*    */ {
/*    */   public CSharpPacket(CSharpHeader header) {
/* 16 */     this.header = header;
/*    */   }
/*    */   
/*    */   public short getPacketType() {
/* 20 */     return this.header.getType();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CSharpHeader getHeader() {
/* 29 */     return (CSharpHeader)this.header;
/*    */   }
/*    */   
/*    */   public void readBody(ByteBuf in) {
/* 33 */     ByteBuf body = init();
/* 34 */     body.writeBytes(in, this.header.getLength());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 43 */     return this.header.getTypeHexString();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\csharp\protocol\CSharpPacket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */