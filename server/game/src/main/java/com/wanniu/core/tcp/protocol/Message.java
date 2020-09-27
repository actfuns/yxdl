/*    */ package com.wanniu.core.tcp.protocol;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.BufferUtil;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Message
/*    */ {
/*    */   protected Header header;
/*    */   protected Body body;
/*    */   protected ByteBuf content;
/*    */   
/*    */   public Message() {
/* 28 */     this(new Body());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Message(Body body) {
/* 35 */     this.header = newHeader();
/* 36 */     this.body = body;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Header newHeader() {
/* 43 */     return new Header();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ByteBuf newContent() {
/* 50 */     return BufferUtil.getAutoBuffer(this.body.getBuffer().readableBytes() + Header.SIZE);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void encodeHeader() {
/* 57 */     this.header.setType(getType());
/* 58 */     this.header.setLength(this.body.getBuffer().readableBytes());
/* 59 */     this.header.encode(this.content);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void encodeBody() {
/* 66 */     this.content.writeBytes(this.body.getBuffer());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ByteBuf getContent() {
/*    */     try {
/* 76 */       if (null == this.content) {
/*    */         
/* 78 */         write();
/*    */         
/* 80 */         this.content = newContent();
/* 81 */         encodeHeader();
/* 82 */         encodeBody();
/*    */         
/* 84 */         this.body = null;
/* 85 */         this.header = null;
/*    */       } 
/*    */       
/* 88 */       return this.content;
/* 89 */     } catch (Exception e) {
/* 90 */       Out.error(new Object[] { "Message getContent", e });
/* 91 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   protected abstract void write() throws IOException;
/*    */   
/*    */   public abstract short getType();
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\tcp\protocol\Message.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */