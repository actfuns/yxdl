/*    */ package com.wanniu.core.db.connet;
/*    */ 
/*    */ import com.wanniu.core.tcp.client.ClientBootstrap;
/*    */ import com.wanniu.core.tcp.protocol.GCodecFactory;
/*    */ import io.netty.channel.ChannelHandler;
/*    */ import io.netty.channel.ChannelInitializer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DBClientBootstrap
/*    */   extends ClientBootstrap
/*    */ {
/*    */   public DBClientBootstrap(ChannelHandler handler) {
/* 18 */     super((ChannelInitializer)new GCodecFactory(handler));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\connet\DBClientBootstrap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */