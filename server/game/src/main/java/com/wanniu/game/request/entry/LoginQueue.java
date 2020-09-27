/*     */ package com.wanniu.game.request.entry;
/*     */ 
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.protocol.PomeloPush;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import com.wanniu.game.GWorld;
/*     */ import io.netty.channel.Channel;
/*     */ import io.netty.util.AttributeKey;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import pomelo.connector.EntryHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LoginQueue
/*     */ {
/*  28 */   private static final AttributeKey<Long> __KEY_QUEUE_TIME = AttributeKey.valueOf("__KEY.QUEUE.TIME");
/*     */   
/*  30 */   public static final List<Channel> EntryQueue = new CopyOnWriteArrayList<>();
/*  31 */   public static final Map<String, Channel> GotoBindQueue = new ConcurrentHashMap<>();
/*     */   
/*     */   static class QueueMessage extends PomeloPush {
/*     */     private int num;
/*     */     
/*     */     QueueMessage(int num) {
/*  37 */       this.num = num;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void write() throws IOException {
/*  42 */       EntryHandler.LoginQueuePush.Builder push = EntryHandler.LoginQueuePush.newBuilder();
/*  43 */       push.setNum(this.num);
/*  44 */       push.setTime(LoginQueue.OL_AVG_TIME * this.num);
/*  45 */       this.body.writeBytes(push.build().toByteArray());
/*     */     }
/*     */ 
/*     */     
/*     */     public String getRoute() {
/*  50 */       return "connector.entryPush.loginQueuePush";
/*     */     }
/*     */   }
/*     */   
/*  54 */   private static int OL_AVG_TIME = 60;
/*     */   private static boolean initQueueSch = false;
/*  56 */   private static final AtomicLong TOTAL_COUNT = new AtomicLong();
/*  57 */   private static final AtomicLong TOTAL_TIME = new AtomicLong();
/*     */   
/*     */   private static int getOnlineCount() {
/*  60 */     return GWorld.getInstance().getOnlineCount() + GotoBindQueue.size();
/*     */   }
/*     */   
/*     */   public static void syncQueueInfo() {
/*  64 */     if (!initQueueSch) {
/*  65 */       initQueueSch = true;
/*  66 */       JobFactory.addScheduleJob(() -> { if (!EntryQueue.isEmpty()) { Out.info(new Object[] { "sync queque info...", Integer.valueOf(EntryQueue.size()) }, ); int canLoginCount = GWorld.__PLAYER_LIMIT - getOnlineCount(); if (canLoginCount > 0) { Channel channel = EntryQueue.get(0); GotoBindQueue.put(channel.attr(GGlobal.__KEY_USER_ID).get(), channel); Out.debug(new Object[] { channel, ".................................goto bind....................................", Integer.valueOf(canLoginCount) }); removeEntryQueue(channel); channel.writeAndFlush(new QueueMessage(0)); for (int i = 0; i < EntryQueue.size(); i++) ((Channel)EntryQueue.get(i)).writeAndFlush(new QueueMessage(i + 1));  }  }  }1000L, 1000L);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean checkQueue(Packet pak) {
/*  87 */     Channel channel = pak.getSession();
/*  88 */     if (EntryQueue.size() > 0 || getOnlineCount() >= GWorld.__PLAYER_LIMIT) {
/*  89 */       String uid = (String)pak.getAttr(GGlobal.__KEY_USER_ID);
/*  90 */       if (!GotoBindQueue.containsKey(uid)) {
/*  91 */         int index = EntryQueue.indexOf(channel);
/*  92 */         if (index < 0) {
/*  93 */           index = EntryQueue.size();
/*  94 */           EntryQueue.add(channel);
/*  95 */           channel.attr(__KEY_QUEUE_TIME).set(Long.valueOf(System.currentTimeMillis()));
/*  96 */           syncQueueInfo();
/*     */         } 
/*  98 */         channel.writeAndFlush((new QueueMessage(index + 1)).getContent());
/*  99 */         return false;
/*     */       } 
/*     */     } 
/* 102 */     addBindQueue(channel);
/* 103 */     return true;
/*     */   }
/*     */   
/*     */   public static void remove(Channel channel) {
/* 107 */     String uid = (String)channel.attr(GGlobal.__KEY_USER_ID).get();
/* 108 */     if (uid != null && !removeEntryQueue(channel) && 
/* 109 */       GotoBindQueue.containsKey(uid)) {
/* 110 */       JobFactory.addDelayJob(() -> { if (channel == GotoBindQueue.get(uid)) { Out.debug(new Object[] { "remove bind queue..." }, ); GotoBindQueue.remove(uid); } else { Out.debug(new Object[] { "current binding queue..." }, ); }  }10000L);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean removeEntryQueue(Channel channel) {
/* 123 */     if (EntryQueue.remove(channel)) {
/* 124 */       Long queueTime = (Long)channel.attr(__KEY_QUEUE_TIME).get();
/* 125 */       long count = TOTAL_COUNT.incrementAndGet();
/* 126 */       long total = TOTAL_TIME.get();
/* 127 */       TOTAL_TIME.compareAndSet(total, total + System.currentTimeMillis() - queueTime.longValue());
/* 128 */       OL_AVG_TIME = Math.max(10, (int)(TOTAL_TIME.get() / count / 1000L));
/* 129 */       Out.debug(new Object[] { "OL_AVG_TIME : ", Integer.valueOf(OL_AVG_TIME) });
/* 130 */       for (int i = 0; i < EntryQueue.size(); i++) {
/* 131 */         ((Channel)EntryQueue.get(i)).writeAndFlush(new QueueMessage(i + 1));
/*     */       }
/* 133 */       return true;
/*     */     } 
/* 135 */     return false;
/*     */   }
/*     */   
/*     */   public static void addBindQueue(Channel channel) {
/* 139 */     String uid = (String)channel.attr(GGlobal.__KEY_USER_ID).get();
/* 140 */     if (uid != null && 
/* 141 */       GotoBindQueue.put(uid, channel) == channel) {
/* 142 */       Out.warn(new Object[] { "bug???...应该是客户端排队连接已优化了......................................." });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean removeBindQueue(Channel channel) {
/* 148 */     String uid = (String)channel.attr(GGlobal.__KEY_USER_ID).get();
/* 149 */     if (uid != null && GotoBindQueue.containsKey(uid)) {
/* 150 */       GotoBindQueue.remove(uid);
/* 151 */       return true;
/*     */     } 
/* 153 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\entry\LoginQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */