/*    */ package com.wanniu.core.gm.connect;
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
/*    */ public class GMSessionHandler
/*    */   extends ClientSessionHandler
/*    */ {
/*    */   public GMSessionHandler(ClientCallback callback) {
/* 18 */     super(callback);
/*    */   }
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
/*    */   
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 36 */     Out.error(new Object[] { "连接出现异常，Session:", ctx
/* 37 */           .channel().remoteAddress(), "; Exception:", cause
/* 38 */           .getMessage() });
/*    */     
/* 40 */     super.exceptionCaught(ctx, cause);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\gm\connect\GMSessionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */