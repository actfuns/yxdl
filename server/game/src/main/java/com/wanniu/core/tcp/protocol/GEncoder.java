/*    */ package com.wanniu.core.tcp.protocol;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.handler.codec.MessageToByteEncoder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class GEncoder
/*    */   extends MessageToByteEncoder<Message>
/*    */ {
/*    */   protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
/* 15 */     out.writeBytes(msg.getContent());
/* 16 */     ctx.flush();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\tcp\protocol\GEncoder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */