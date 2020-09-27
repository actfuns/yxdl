/*    */ package com.wanniu.core.proxy;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.client.ClientCallback;
/*    */ import com.wanniu.core.tcp.client.ClientSessionHandler;
/*    */ import io.netty.channel.ChannelHandler.Sharable;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Sharable
/*    */ public class ProxySessionHandler
/*    */   extends ClientSessionHandler
/*    */ {
/*    */   public ProxySessionHandler(ClientCallback callback) {
/* 18 */     super(callback);
/*    */   }
/*    */ 
/*    */   
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 23 */     Out.error(new Object[] { "连接出现异常，Session:", ctx
/* 24 */           .channel().remoteAddress(), "; Exception:", cause
/* 25 */           .getMessage() });
/*    */     
/* 27 */     super.exceptionCaught(ctx, cause);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\proxy\ProxySessionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */