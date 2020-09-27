/*    */ package com.wanniu.csharp.protocol;
/*    */ 
/*    */ import com.wanniu.core.tcp.protocol.Message;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.handler.codec.MessageToByteEncoder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSharpEncoder
/*    */   extends MessageToByteEncoder<Message>
/*    */ {
/*    */   protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
/* 18 */     out.writeBytes(msg.getContent());
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\csharp\protocol\CSharpEncoder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */