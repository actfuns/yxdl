/*     */ package com.wanniu.core.tcp.client;
/*     */ 
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.GBootstrap;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import com.wanniu.core.tcp.protocol.RequestMessage;
/*     */ import io.netty.bootstrap.Bootstrap;
/*     */ import io.netty.channel.Channel;
/*     */ import io.netty.channel.ChannelFuture;
/*     */ import io.netty.channel.ChannelHandler;
/*     */ import io.netty.channel.ChannelInitializer;
/*     */ import io.netty.channel.ChannelOption;
/*     */ import io.netty.channel.EventLoopGroup;
/*     */ import io.netty.channel.nio.NioEventLoopGroup;
/*     */ import io.netty.channel.socket.SocketChannel;
/*     */ import io.netty.channel.socket.nio.NioSocketChannel;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import java.util.concurrent.locks.Condition;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClientBootstrap
/*     */   extends GBootstrap
/*     */ {
/*     */   static class RequestLock
/*     */   {
/*     */     private Lock lock;
/*     */     private Condition condition;
/*     */     private Packet pak;
/*     */     
/*     */     RequestLock(Lock lock, Condition condition) {
/*  41 */       this.lock = lock;
/*  42 */       this.condition = condition;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*  47 */   private static final int REQUEST_AWAIN = GConfig.getInstance().getInt("game.request.await", 15000);
/*     */ 
/*     */   
/*  50 */   private static AtomicLong UUID = new AtomicLong(System.currentTimeMillis());
/*  51 */   private static Map<Long, RequestLock> LOCKS = new ConcurrentHashMap<>();
/*     */   
/*     */   private Bootstrap boots;
/*     */   
/*     */   protected Channel session;
/*  56 */   private static final EventLoopGroup m_loop = (EventLoopGroup)new NioEventLoopGroup();
/*     */   
/*     */   public ClientBootstrap(ChannelInitializer<SocketChannel> factory) {
/*  59 */     this(factory, m_loop);
/*     */   }
/*     */   
/*     */   public ClientBootstrap(ChannelInitializer<SocketChannel> factory, EventLoopGroup loop) {
/*  63 */     this.boots = new Bootstrap();
/*  64 */     this.boots.channel(NioSocketChannel.class);
/*  65 */     this.boots.option(ChannelOption.TCP_NODELAY, Boolean.valueOf(true));
/*  66 */     this.boots.option(ChannelOption.SO_KEEPALIVE, Boolean.valueOf(true));
/*  67 */     this.boots.handler((ChannelHandler)factory);
/*  68 */     this.boots.group(loop);
/*     */   }
/*     */   
/*     */   public Channel connect(String host, int port) {
/*     */     try {
/*  73 */       ChannelFuture future = this.boots.connect(new InetSocketAddress(host, port));
/*  74 */       future.awaitUninterruptibly(10L, TimeUnit.SECONDS);
/*     */       
/*  76 */       if (!future.isSuccess()) {
/*  77 */         if (future.cause() != null) {
/*  78 */           Out.error(new Object[] { future.cause().getMessage() });
/*     */         }
/*  80 */         return null;
/*     */       } 
/*  82 */       this.session = future.channel();
/*  83 */       return future.channel();
/*  84 */     } catch (Exception e) {
/*  85 */       Out.error(new Object[] { e });
/*  86 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void quit(Channel session) {
/*  91 */     if (this.session == session) {
/*  92 */       this.session = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class RequestException
/*     */     extends RuntimeException
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     public RequestException(String msg) {
/* 104 */       super(msg);
/*     */     }
/*     */     
/*     */     public RequestException(Throwable ex) {
/* 108 */       super(ex);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Packet request(RequestMessage req) {
/* 114 */     if (this.session == null) {
/* 115 */       throw new RequestException("session is null!!!");
/*     */     }
/* 117 */     long reqId = UUID.incrementAndGet();
/* 118 */     Lock lock = new ReentrantLock();
/* 119 */     lock.lock();
/*     */     try {
/* 121 */       reqId = req.setReqId(reqId);
/* 122 */       Condition condition = lock.newCondition();
/* 123 */       RequestLock look = new RequestLock(lock, condition);
/* 124 */       LOCKS.put(Long.valueOf(reqId), look);
/* 125 */       this.session.writeAndFlush(req.getContent());
/* 126 */       condition.await(REQUEST_AWAIN, TimeUnit.MILLISECONDS);
/* 127 */       LOCKS.remove(Long.valueOf(reqId));
/* 128 */       if (look.pak == null) {
/* 129 */         throw new RequestException("session is close!!!");
/*     */       }
/* 131 */       return look.pak;
/* 132 */     } catch (Exception e) {
/* 133 */       Out.error(new Object[] { e });
/*     */     } finally {
/* 135 */       lock.unlock();
/*     */     } 
/* 137 */     return null;
/*     */   }
/*     */   
/*     */   public void response(long reqId, Packet pak) {
/* 141 */     RequestLock look = LOCKS.get(Long.valueOf(reqId));
/* 142 */     if (look != null) {
/* 143 */       look.lock.lock();
/*     */       try {
/* 145 */         look.pak = pak;
/* 146 */         look.condition.signal();
/* 147 */       } catch (Exception e) {
/* 148 */         Out.error(new Object[] { e });
/*     */       } finally {
/* 150 */         look.lock.unlock();
/*     */       } 
/*     */     } else {
/* 153 */       Out.warn(new Object[] { Long.valueOf(reqId), " request timeout!!!" });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\tcp\client\ClientBootstrap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */