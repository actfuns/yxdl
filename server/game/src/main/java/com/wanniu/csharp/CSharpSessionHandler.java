/*    */ package com.wanniu.csharp;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.csharp.protocol.CSharpPacket;
/*    */ import io.netty.channel.ChannelHandler.Sharable;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.channel.ChannelInboundHandlerAdapter;
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
/*    */ @Sharable
/*    */ public class CSharpSessionHandler
/*    */   extends ChannelInboundHandlerAdapter
/*    */ {
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 23 */     Out.error(new Object[] { "连接出现异常，Session:", ctx
/* 24 */           .channel().remoteAddress(), "; Exception:", cause
/* 25 */           .getMessage() });
/* 26 */     super.exceptionCaught(ctx, cause);
/*    */   }
/*    */ 
/*    */   
/*    */   public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
/* 31 */     CSharpClient.getInstance().handle((CSharpPacket)msg);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
/* 37 */     CSharpClient.getInstance().close(ctx.channel());
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\csharp\CSharpSessionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */