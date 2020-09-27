/*    */ package com.wanniu.db;
/*    */ 
/*    */ import com.wanniu.core.GConfig;
/*    */ import com.wanniu.core.db.pool.DBFactory;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.db.connet.DBServerBootstrap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DBMain
/*    */ {
/*    */   public static void main(String[] args) {
/* 15 */     GConfig.getInstance().init(true);
/* 16 */     DBFactory.init();
/* 17 */     DBServerBootstrap.getInstance().start();
/* 18 */     (new Thread((Runnable)DBServer.Dispatcher, "业务分发")).start();
/* 19 */     Runtime.getRuntime().addShutdownHook(new Thread("关服程序") {
/*    */           public void run() {
/* 21 */             Out.info(
/*    */ 
/*    */                 
/* 24 */                 new Object[] { "正在进行安全停服中..." });
/*    */             DBServer.onProcessExit();
/*    */             Out.info(new Object[] { "服务器已安全停止，可以继续执行后续的工作了，O(∩_∩)O~" });
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\db\DBMain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */