/*     */ package com.wanniu.core.tcp.server;
/*     */ 
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.GSystem;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import io.netty.channel.Channel;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.SocketAddress;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import java.util.concurrent.ConcurrentSkipListSet;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class IPBlacks
/*     */   extends ConcurrentSkipListSet<String>
/*     */ {
/*     */   private static final long serialVersionUID = 7814293538258552651L;
/*  33 */   private static IPBlacks instance = new IPBlacks();
/*     */   
/*  35 */   private static final String __IP_FILE_BLACK__ = GGlobal.DIR_COMMON + "black.ip";
/*     */ 
/*     */   
/*  38 */   private ConcurrentMap<String, Byte> ExceptionIPS = new ConcurrentHashMap<>();
/*     */   
/*  40 */   private static Map<String, Long> __ENDCOOLS = new HashMap<>();
/*  41 */   private static int BLACKCOOL = GConfig.getInstance().getInt("game.blackcool", 1800000);
/*     */ 
/*     */ 
/*     */   
/*     */   public static IPBlacks getInstance() {
/*  46 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadBalckIps() {
/*  53 */     BufferedReader br = null;
/*  54 */     FileReader reader = null;
/*  55 */     File file = new File(__IP_FILE_BLACK__);
/*  56 */     if (file.exists()) {
/*     */       try {
/*  58 */         reader = new FileReader(file);
/*  59 */         br = new BufferedReader(reader);
/*  60 */         String line = null;
/*  61 */         while ((line = br.readLine()) != null) {
/*  62 */           instance.add(line);
/*     */         }
/*  64 */       } catch (Exception e) {
/*  65 */         Out.error(new Object[] { "loadBalckIps", e });
/*     */       } finally {
/*     */         try {
/*  68 */           if (br != null) {
/*  69 */             br.close();
/*     */           }
/*  71 */         } catch (IOException iOException) {}
/*     */         
/*     */         try {
/*  74 */           if (reader != null) {
/*  75 */             reader.close();
/*     */           }
/*  77 */         } catch (IOException iOException) {}
/*     */       } 
/*     */       
/*  80 */       Out.info(new Object[] { "IP黑名单已加载：", Integer.valueOf(instance.size()) });
/*     */     } else {
/*  82 */       Out.info(new Object[] { "IP黑名单【", __IP_FILE_BLACK__, "】未定义！" });
/*     */     } 
/*     */   }
/*     */   
/*     */   public long getEndCool(String ip) {
/*  87 */     return ((Long)__ENDCOOLS.get(ip)).longValue();
/*     */   }
/*     */   
/*     */   public void black(Channel session, String from) {
/*  91 */     SocketAddress remoteAddress = session.remoteAddress();
/*  92 */     session.close();
/*  93 */     if (remoteAddress instanceof InetSocketAddress) {
/*  94 */       InetSocketAddress addr = (InetSocketAddress)remoteAddress;
/*  95 */       String ip = addr.getAddress().getHostAddress();
/*  96 */       Out.error(new Object[] { "black", from, ip });
/*  97 */       exceptionIp(ip);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void exceptionPlayer(String rid) {
/* 102 */     GPlayer player = GGame.getInstance().getPlayer(rid);
/* 103 */     if (player != null) {
/* 104 */       exceptionIp(player.getSession());
/*     */     }
/*     */   }
/*     */   
/*     */   public void exceptionIp(Channel session) {
/* 109 */     String ip = getIp(session);
/* 110 */     if (ip != null) {
/* 111 */       exceptionIp(ip);
/* 112 */       if (__ENDCOOLS.containsKey(ip)) {
/* 113 */         session.close();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void exceptionIp(String ip) {
/* 119 */     byte count = this.ExceptionIPS.containsKey(ip) ? ((Byte)this.ExceptionIPS.get(ip)).byteValue() : 0;
/* 120 */     if (count > 30) {
/* 121 */       if (!contains(ip)) {
/* 122 */         add(ip);
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
/* 135 */         GSystem.addDelayJob(new Cool(ip), BLACKCOOL, TimeUnit.MILLISECONDS);
/* 136 */         __ENDCOOLS.put(ip, Long.valueOf(System.currentTimeMillis() + BLACKCOOL));
/* 137 */         Out.debug(new Object[] { ip, " -> 黑名单中" });
/*     */       } 
/*     */     } else {
/* 140 */       count = (byte)(count + 1); this.ExceptionIPS.put(ip, Byte.valueOf(count));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addIp(Channel session) {
/* 145 */     String ip = getIp(session);
/* 146 */     if (ip != null) {
/* 147 */       add(ip);
/*     */     }
/*     */   }
/*     */   
/*     */   public String getIp(Channel session) {
/* 152 */     SocketAddress remoteAddress = session.remoteAddress();
/* 153 */     if (remoteAddress instanceof InetSocketAddress) {
/* 154 */       InetSocketAddress addr = (InetSocketAddress)remoteAddress;
/* 155 */       String ip = addr.getAddress().getHostAddress();
/* 156 */       return ip;
/*     */     } 
/* 158 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\tcp\server\IPBlacks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */