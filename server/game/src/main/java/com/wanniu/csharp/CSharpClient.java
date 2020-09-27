/*     */ package com.wanniu.csharp;
/*     */ 
/*     */

/*     */ import Xmds.XmdsManagerPrx;
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.GSystem;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.game.protocol.PomeloPush;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.csharp.ice.XmdsManager;
/*     */ import com.wanniu.csharp.ice.ZoneManager;
/*     */ import com.wanniu.csharp.message.CSharpJoinMessage;
/*     */ import com.wanniu.csharp.protocol.CSharpMessage;
/*     */ import com.wanniu.csharp.protocol.CSharpPacket;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.channel.Channel;
/*     */ import io.netty.channel.ChannelHandler;
/*     */ import io.netty.util.AttributeKey;
/*     */ import java.io.IOException;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CSharpClient
/*     */ {
/*  31 */   private static final AttributeKey<CSharpNode> NodeKey = AttributeKey.valueOf("__KEY.CSharpNode__");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  36 */   private static CSharpClient instance = new CSharpClient();
/*     */ 
/*     */   
/*  39 */   private CSharpBootstrap bootstrap = new CSharpBootstrap((ChannelHandler)new CSharpSessionHandler());
/*     */ 
/*     */   
/*  42 */   private static ConcurrentHashMap<String, Channel> csharpServers = new ConcurrentHashMap<>();
/*  43 */   private static ConcurrentHashMap<String, ZoneManager> zoneManagers = new ConcurrentHashMap<>();
/*  44 */   private static ConcurrentHashMap<String, XmdsManager> nbManagers = new ConcurrentHashMap<>();
/*     */   
/*     */   public static CSharpClient getInstance() {
/*  47 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  53 */     connectAsync(GGame.__CS_NODE);
/*     */   }
/*     */   
/*     */   public void connectAsync(CSharpNode node) {
/*  57 */     connectAsync(node, null);
/*     */   }
/*     */   
/*     */   public void connectAsync(final CSharpNode node, final Runnable cb) {
/*  61 */     (new Thread(new Runnable()
/*     */         {
/*     */           public void run() {
/*  64 */             CSharpClient.this.connect(node, cb);
/*     */           }
/*  66 */         })).start();
/*     */   }
/*     */   
/*     */   public void connect(CSharpNode node, Runnable cb) {
/*  70 */     if (!csharpServers.containsKey(node.getNodeId())) {
/*     */       Channel channel;
/*  72 */       while ((channel = this.bootstrap.connect(node.host, node.port)) == null) {
/*  73 */         GSystem.waitMills(5000);
/*  74 */         Out.warn(new Object[] { " reconnect ", node });
/*     */       } 
/*  76 */       channel.attr(NodeKey).set(node);
/*  77 */       bind(channel);
/*     */     } 
/*  79 */     if (cb != null) {
/*  80 */       cb.run();
/*     */     }
/*     */   }
/*     */   
/*     */   public static ZoneManagerPrx getZoneManager(String csharpServerId) {
/*  85 */     ZoneManager manager = zoneManagers.get(csharpServerId);
/*  86 */     if (manager != null) {
/*  87 */       return manager.getManager();
/*     */     }
/*  89 */     return null;
/*     */   }
/*     */   
/*     */   public static XmdsManagerPrx getXmdsManager(String csharpServerId) {
/*  93 */     XmdsManager manager = nbManagers.get(csharpServerId);
/*  94 */     if (manager != null) {
/*  95 */       return manager.getManager();
/*     */     }
/*  97 */     return null;
/*     */   }
/*     */   
/*     */   public void bind(Channel channel) {
/* 101 */     CSharpNode node = (CSharpNode)channel.attr(NodeKey).get();
/* 102 */     String nodeId = node.getNodeId();
/* 103 */     csharpServers.put(nodeId, channel);
/*     */     
/* 105 */     ZoneManager zoneManager = zoneManagers.get(nodeId);
/* 106 */     if (zoneManager != null)
/* 107 */       zoneManager.destory(); 
/* 108 */     zoneManager = (new ZoneManager(node)).bind();
/* 109 */     zoneManagers.put(nodeId, zoneManager);
/*     */     
/* 111 */     XmdsManager nbManager = nbManagers.get(nodeId);
/* 112 */     if (nbManager != null)
/* 113 */       nbManager.destory(); 
/* 114 */     nbManager = (new XmdsManager(node)).bind();
/* 115 */     nbManagers.put(nodeId, nbManager);
/*     */     
/* 117 */     channel.writeAndFlush((new CSharpJoinMessage(nodeId)).getContent()).awaitUninterruptibly(3000L);
/*     */   }
/*     */   
/*     */   public void close(Channel channel) {
/* 121 */     CSharpNode node = (CSharpNode)channel.attr(NodeKey).get();
/* 122 */     if (node != null) {
/* 123 */       String nodeId = node.getNodeId();
/* 124 */       Out.info(new Object[] { " connect ", node });
/* 125 */       csharpServers.remove(nodeId);
/* 126 */       GGame.getInstance().battleServerClose(nodeId);
/* 127 */       connectAsync(node);
/*     */     } else {
/* 129 */       Out.warn(new Object[] { " close ", channel.remoteAddress() });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Watcher
/*     */   {
/*     */     public int count;
/*     */     public long buf;
/* 138 */     public Map<Long, CSharpClient.WatcherSecond> ws = new ConcurrentHashMap<>();
/*     */     
/*     */     public void inrc(ByteBuf buf) {
/* 141 */       if (!GGame.MONITOR) {
/*     */         return;
/*     */       }
/*     */       
/* 145 */       this.buf += buf.readableBytes();
/* 146 */       this.count++;
/*     */       
/* 148 */       ((CSharpClient.WatcherSecond)this.ws.computeIfAbsent(Long.valueOf(System.currentTimeMillis() / 1000L), key -> new CSharpClient.WatcherSecond())).inrc(buf);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class WatcherSecond {
/*     */     public int count;
/*     */     public long buf;
/*     */     
/*     */     public void inrc(ByteBuf buf) {
/* 157 */       this.buf += buf.readableBytes();
/* 158 */       this.count++;
/*     */     }
/*     */   }
/*     */   
/* 162 */   public static Watcher UP = new Watcher();
/* 163 */   public static Watcher DOWN = new Watcher();
/*     */   
/*     */   public void dispatch(CSharpMessage msg) {
/* 166 */     Channel channel = csharpServers.get(msg.getServerId());
/* 167 */     if (channel != null) {
/* 168 */       UP.inrc(msg.getContent());
/* 169 */       channel.writeAndFlush(msg.getContent());
/*     */     } else {
/* 171 */       Out.error(new Object[] { "dispatch - ", msg.getServerId(), " & ", msg.getHeader().getUid() });
/*     */     } 
/*     */   }
/*     */   
/*     */   public void handle(final CSharpPacket pak) {
/* 176 */     String rid = pak.getHeader().getUid();
/* 177 */     GPlayer player = GGame.getInstance().getPlayer(rid);
/* 178 */     if (player == null)
/*     */       return; 
/* 180 */     PomeloPush push = new PomeloPush()
/*     */       {
/*     */         protected void write() throws IOException {
/* 183 */           this.body.writeBytes(pak.getBody().array());
/*     */         }
/*     */ 
/*     */         
/*     */         public String getRoute() {
/* 188 */           return "area.playerPush.battleEventPush";
/*     */         }
/*     */       };
/* 191 */     (push.getHeader()).compressRoute = true;
/* 192 */     DOWN.inrc(push.getContent());
/* 193 */     Channel session = player.getSession();
/* 194 */     if (session != null) {
/* 195 */       session.writeAndFlush(push.getContent());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void gmTestClose() {
/* 203 */     csharpServers.values().forEach(v -> v.close());
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\csharp\CSharpClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */