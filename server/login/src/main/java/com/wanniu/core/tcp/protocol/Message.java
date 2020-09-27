/*    */ package com.wanniu.core.tcp.protocol;
/*    */ 
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
/* 27 */     this(new Body());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Message(Body body) {
/* 34 */     this.header = newHeader();
/* 35 */     this.body = body;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Header newHeader() {
/* 42 */     return new Header();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ByteBuf newContent() {
/* 49 */     return BufferUtil.getAutoBuffer(this.body.getBuffer().readableBytes() + Header.SIZE);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void encodeHeader() {
/* 56 */     this.header.setType(getType());
/* 57 */     this.header.setLength(this.body.getBuffer().readableBytes());
/* 58 */     this.header.encode(this.content);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void encodeBody() {
/* 65 */     this.content.writeBytes(this.body.getBuffer());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ByteBuf getContent() {
/*    */     try {
/* 75 */       if (this.content == null) {
/*    */         
/* 77 */         write();
/*    */         
/* 79 */         this.content = newContent();
/* 80 */         encodeHeader();
/* 81 */         encodeBody();
/*    */         
/* 83 */         this.body = null;
/* 84 */         this.header = null;
/*    */       } 
/*    */       
/* 87 */       return this.content;
/* 88 */     } catch (Exception e) {
/* 89 */       e.printStackTrace();
/* 90 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   protected abstract void write() throws IOException;
/*    */   
/*    */   public abstract short getType();
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\tcp\protocol\Message.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */