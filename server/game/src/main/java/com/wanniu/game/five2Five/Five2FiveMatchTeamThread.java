/*    */ package com.wanniu.game.five2Five;
/*    */ 
/*    */ import com.wanniu.core.game.JobFactory;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.Const;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Five2FiveMatchTeamThread
/*    */   implements Runnable
/*    */ {
/*    */   public void run() {
/*    */     try {
/* 23 */       Five2FiveMatchPool.doMatchJob();
/* 24 */       JobFactory.addDelayJob(this, Const.Five2Five.five2five_thread_delay_time.value, TimeUnit.MILLISECONDS);
/* 25 */     } catch (Exception e) {
/* 26 */       Out.error(new Object[] { e });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\five2Five\Five2FiveMatchTeamThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */