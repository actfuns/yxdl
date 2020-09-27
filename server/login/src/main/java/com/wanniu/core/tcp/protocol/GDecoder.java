/*    */ package com.wanniu.core.tcp.protocol;
/*    */ 
/*    */ import com.wanniu.core.GConfig;
/*    */ import com.wanniu.core.GGlobal;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.Channel;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.handler.codec.ByteToMessageDecoder;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class GDecoder
/*    */   extends ByteToMessageDecoder
/*    */ {
/* 20 */   private static int __RESPONSE_MAX_LEN = GConfig.getInstance().getInt("gate.response.maxlen", GGlobal.__RESPONSE_MAX_LEN);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> packets) throws Exception {
/* 28 */     if (in.readableBytes() < Header.SIZE) {
/*    */       return;
/*    */     }
/* 31 */     in = in.order(GGlobal.__BYTE_ORDER);
/* 32 */     in.markReaderIndex();
/* 33 */     Packet packet = new Packet(ctx.channel());
/* 34 */     Header header = packet.getHeader();
/* 35 */     header.decode(in);
/*    */     
/* 37 */     int len = header.getLength();
/*    */     
/* 39 */     if (len > __RESPONSE_MAX_LEN || len < 0) {
/* 40 */       Channel session = ctx.channel();
/* 41 */       Out.warn(new Object[] { "包体长度错误：" + len + 
/* 42 */             " 句柄：" + header.getTypeHexString() + session.remoteAddress() });
/* 43 */       session.close();
/*    */       
/*    */       return;
/*    */     } 
/* 47 */     if (in.readableBytes() < len) {
/* 48 */       in.resetReaderIndex();
/* 49 */       header = null;
/* 50 */       packet = null;
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 55 */     ByteBuf body = packet.init();
/* 56 */     body.writeBytes(in, len);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 62 */     packets.add(packet);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\tcp\protocol\GDecoder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */