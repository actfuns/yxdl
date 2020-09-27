/*    */ package com.wanniu.core.logfs;
/*    */ 
/*    */ import com.wanniu.core.util.DateUtil;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.Date;
/*    */ import org.apache.log4j.DailyRollingFileAppender;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Log4jAppender
/*    */   extends DailyRollingFileAppender
/*    */ {
/*    */   private String formatFileName;
/*    */   
/*    */   public synchronized void setFile(String fileName, boolean arg1, boolean arg2, int arg3) throws IOException {
/* 17 */     String dir = DateUtil.format(new Date(System.currentTimeMillis() + 3601000L), "yyyy-MM-dd");
/* 18 */     dir = String.valueOf(dir.substring(0, 7)) + File.separator + dir;
/* 19 */     fileName = String.format(this.formatFileName, new Object[] { dir });
/* 20 */     File log = new File(fileName);
/* 21 */     if (!log.exists()) {
/* 22 */       log.getParentFile().mkdirs();
/*    */     }
/* 24 */     super.setFile(fileName);
/* 25 */     super.setFile(fileName, arg1, arg2, arg3);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setFile(String fileName) {
/* 30 */     this.formatFileName = fileName;
/* 31 */     super.setFile(fileName);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\core\logfs\Log4jAppender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */