/*    */ package com.wanniu.core.game.message;
/*    */ 
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DispatcherMessage
/*    */   extends MulticastMessage
/*    */ {
/*    */   private ByteBuf buffer;
/*    */   
/*    */   public DispatcherMessage(Packet packet) {
/* 18 */     this.header.decode(packet.getHeader());
/* 19 */     this.buffer = packet.getBody();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void write() throws IOException {
/* 24 */     this.body.writeBuffer(this.buffer);
/*    */   }
/*    */ 
/*    */   
/*    */   public short getType() {
/* 29 */     return this.header.getType();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\game\message\DispatcherMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */