/*    */ package com.wanniu.core.gm.connect;
/*    */ 
/*    */ import com.wanniu.core.tcp.client.ClientBootstrap;
/*    */ import com.wanniu.core.tcp.protocol.GCodecFactory;
/*    */ import io.netty.channel.ChannelHandler;
/*    */ import io.netty.channel.ChannelInitializer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GMBootstrap
/*    */   extends ClientBootstrap
/*    */ {
/*    */   public GMBootstrap(ChannelHandler handler) {
/* 15 */     super((ChannelInitializer)new GCodecFactory(handler));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\gm\connect\GMBootstrap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */