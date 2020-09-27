/*    */ package com.wanniu.core.tcp.server;
/*    */ 
/*    */ import com.wanniu.core.GConfig;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import io.netty.channel.Channel;
/*    */ import io.netty.util.AttributeKey;
/*    */ import java.net.InetSocketAddress;
/*    */ import java.net.SocketAddress;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class FirewallFilter
/*    */ {
/* 20 */   private static final AttributeKey<Boolean> __WHITE_KEY__ = AttributeKey.valueOf("__WHITE_KEY__");
/* 21 */   private static final Map<Channel, Integer> __READS__ = new ConcurrentHashMap<>();
/* 22 */   private static final Map<Channel, Long> __LAST_READ_TIMES = new ConcurrentHashMap<>();
/*    */   
/* 24 */   public static final long __ALLOWED_COUNT__ = GConfig.getInstance().getInt("client.message.total", 1000000);
/* 25 */   public static final long __SKIP_TIME__ = GConfig.getInstance().getInt("client.message.skiptime", 100);
/* 26 */   public static final long __SKIP_COUNT__ = GConfig.getInstance().getInt("client.message.skipcount", 50);
/*    */ 
/*    */ 
/*    */   
/*    */   public void channelCreated(Channel channel) {
/* 31 */     if (checkConnectionOk(channel)) {
/* 32 */       __LAST_READ_TIMES.put(channel, Long.valueOf(System.currentTimeMillis()));
/* 33 */       __READS__.put(channel, Integer.valueOf(0));
/*    */     } else {
/* 35 */       channel.close();
/* 36 */       Out.error(new Object[] { channel.remoteAddress(), "在黑名单中，无法创建" });
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean messageReceived(Channel channel) {
/* 41 */     if (checkReadOk(channel)) {
/* 42 */       return true;
/*    */     }
/* 44 */     Out.error(new Object[] { channel.remoteAddress(), "读取异常快" });
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public void channelClosed(Channel channel) {
/* 49 */     __READS__.remove(channel);
/* 50 */     __LAST_READ_TIMES.remove(channel);
/*    */   }
/*    */   
/*    */   private boolean checkReadOk(Channel channel) {
/* 54 */     int readCount = ((Integer)__READS__.get(channel)).intValue();
/* 55 */     long lastReadTime = ((Long)__LAST_READ_TIMES.get(channel)).longValue();
/* 56 */     long nowReadTime = System.currentTimeMillis();
/* 57 */     if (nowReadTime - lastReadTime < __SKIP_TIME__) {
/* 58 */       if (channel.attr(__WHITE_KEY__).get() != null) return true; 
/* 59 */       if (++readCount > __SKIP_COUNT__) {
/* 60 */         IPBlacks.getInstance().black(channel, "过快,");
/* 61 */         IPBlacks.getInstance().addIp(channel);
/* 62 */         return false;
/*    */       } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 69 */       __READS__.put(channel, Integer.valueOf(readCount));
/* 70 */       return true;
/*    */     } 
/*    */     
/* 73 */     __LAST_READ_TIMES.put(channel, Long.valueOf(nowReadTime));
/* 74 */     __READS__.put(channel, Integer.valueOf(0));
/* 75 */     return true;
/*    */   }
/*    */   
/*    */   private boolean checkConnectionOk(Channel channel) {
/* 79 */     SocketAddress remoteAddress = channel.remoteAddress();
/* 80 */     if (remoteAddress instanceof InetSocketAddress) {
/* 81 */       InetSocketAddress addr = (InetSocketAddress)remoteAddress;
/* 82 */       String host = addr.getAddress().getHostAddress();
/*    */       
/* 84 */       if (IPWhites.getInstance().check(host)) {
/* 85 */         channel.attr(__WHITE_KEY__).set(Boolean.TRUE);
/* 86 */         return true;
/*    */       } 
/* 88 */       if (IPBlacks.getInstance().contains(host)) {
/* 89 */         return false;
/*    */       }
/* 91 */       return true;
/*    */     } 
/* 93 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\tcp\server\FirewallFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */