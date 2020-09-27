/*    */ package com.wanniu.core.tcp.server;
/*    */ 
/*    */ import com.wanniu.core.GGlobal;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ import java.util.concurrent.ConcurrentSkipListSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class IPWhites
/*    */   extends ConcurrentSkipListSet<String>
/*    */ {
/*    */   private static final long serialVersionUID = 8350520844632354637L;
/* 20 */   private static IPWhites instance = new IPWhites();
/*    */   
/* 22 */   private static final String __IP_FILE_WHITE__ = GGlobal.DIR_COMMON + "white.ip";
/*    */ 
/*    */ 
/*    */   
/*    */   public static IPWhites getInstance() {
/* 27 */     return instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void loadWhiteIps() {
/* 34 */     BufferedReader br = null;
/* 35 */     FileReader reader = null;
/* 36 */     File file = new File(__IP_FILE_WHITE__);
/* 37 */     if (file.exists()) {
/*    */       try {
/* 39 */         reader = new FileReader(file);
/* 40 */         br = new BufferedReader(reader);
/* 41 */         String line = null;
/* 42 */         while ((line = br.readLine()) != null) {
/* 43 */           if (!instance.contains(line)) {
/* 44 */             instance.add(line);
/*    */           }
/*    */         } 
/* 47 */       } catch (Exception e) {
/* 48 */         Out.error(new Object[] { "loadWhiteIps", e });
/*    */       } finally {
/*    */         try {
/* 51 */           if (br != null) {
/* 52 */             br.close();
/*    */           }
/* 54 */         } catch (IOException iOException) {}
/*    */         
/*    */         try {
/* 57 */           if (reader != null) {
/* 58 */             reader.close();
/*    */           }
/* 60 */         } catch (IOException iOException) {}
/*    */       } 
/*    */       
/* 63 */       Out.info(new Object[] { "IP白名单已加载：", Integer.valueOf(instance.size()) });
/*    */     } else {
/* 65 */       Out.info(new Object[] { "IP白名单【", __IP_FILE_WHITE__, "】未定义！" });
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean check(String host) {
/* 71 */     return (contains(host) || host.startsWith("192.168."));
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\tcp\server\IPWhites.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */