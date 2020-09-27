/*    */ package com.wanniu.csharp.protocol;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.handler.codec.ByteToMessageDecoder;
/*    */ import java.util.List;
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
/*    */ public class CSharpDecoder
/*    */   extends ByteToMessageDecoder
/*    */ {
/*    */   protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> messages) throws Exception {
/* 21 */     if (in.readableBytes() < 8) {
/*    */       return;
/*    */     }
/* 24 */     in.markReaderIndex();
/* 25 */     CSharpHeader header = new CSharpHeader();
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
/* 37 */     header.decode(in);
/*    */     
/* 39 */     int len = header.getCharpLength();
/* 40 */     if (len < 0) {
/* 41 */       ctx.channel().close();
/*    */       
/*    */       return;
/*    */     } 
/* 45 */     if (in.readableBytes() < len) {
/* 46 */       in.resetReaderIndex();
/* 47 */       header = null;
/*    */       return;
/*    */     } 
/* 50 */     header.readBody(in);
/*    */     
/* 52 */     CSharpPacket packet = new CSharpPacket(header);
/* 53 */     packet.readBody(in);
/*    */     
/* 55 */     messages.add(packet);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\csharp\protocol\CSharpDecoder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */