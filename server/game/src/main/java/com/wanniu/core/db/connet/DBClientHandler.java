/*    */ package com.wanniu.core.db.connet;
/*    */ 
/*    */ import com.wanniu.core.tcp.client.ClientCallback;
/*    */ import com.wanniu.core.tcp.client.ClientSessionHandler;
/*    */ import io.netty.channel.ChannelHandler.Sharable;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Sharable
/*    */ public class DBClientHandler
/*    */   extends ClientSessionHandler
/*    */ {
/*    */   public DBClientHandler(ClientCallback callback) {
/* 18 */     super(callback);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 24 */     ctx.channel().close();
/* 25 */     super.exceptionCaught(ctx, cause);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\connet\DBClientHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */